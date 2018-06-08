package gui.fields;

import game.Game;
import gameelements.GameField;
import gameelements.Point;
import javafx.concurrent.Task;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainField extends Stage {

    private Button[][] opponentField = new Button[10][10];
    private Button[][] playerField = new Button[10][10];

    private Game game;

    private VBox opponentPart;

    private volatile Label statusBar;

    public MainField(Game game) {
        this.game = game;
//        initModality(Modality.APPLICATION_MODAL);
        HBox node = new HBox();
        setResizable(false);
        Scene scene = new Scene(node);

        setScene(scene);

        Separator sep = new Separator(Orientation.VERTICAL);
        sep.setMinWidth(20);
        opponentPart = setUpOpponentField();
        VBox playerPart = setUpPlayerField();
        node.getChildren().addAll(opponentPart, sep, playerPart);
    }
// TODO: 08.06.2018 to update graphic you need spec method

    private void updateFields() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                GameField.CellStatus status = game.getOpponent().getCellStatus(new Point(j, i));

                if (status == GameField.CellStatus.SHIPSHOT) {
                    opponentField[i][j].setStyle("-fx-background-color: red");
                    opponentField[i][j].setDisable(true);
                } else if (status == GameField.CellStatus.EMPTYSHOT) {
                    opponentField[i][j].setStyle("-fx-background-color: lightgreen");
                    opponentField[i][j].setDisable(true);
                }

                status = game.getPlayer().getCellStatus(new Point(j, i));

                if (status == GameField.CellStatus.SHIPSHOT) {
                    playerField[i][j].setStyle("-fx-background-color: red");
                } else if (status == GameField.CellStatus.EMPTYSHOT) {
                    playerField[i][j].setStyle("-fx-background-color: mediumseagreen");
                    playerField[i][j].setText("*");
                }

            }
        }
    }

    private void getShot() {

        Point point = game.getShot();
        statusBar.setText("Opponent Turn");

        Task task = new Task() {
            @Override
            protected Object call() {
                opponentPart.setDisable(true);

//                try {
//                    Thread.sleep(/*new Random().nextInt(2000) +*/ 500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                opponentPart.setDisable(false);
                return null;
            }
        };
        task.setOnSucceeded(event -> {
            GameField.CellStatus status = game.getPlayer().getCellStatus(point);
            updateFields();

            if (status == GameField.CellStatus.SHIPSHOT) {
                getShot();
            }
            statusBar.setText("Your Turn");
        });

        new Thread(task).start();

    }

    private VBox setUpPlayerField() {

        VBox vb = new VBox(4);

        Label lb1 = new Label("Your field: " + game.getPlayer().name());
        Label lb2 = new Label("status");
        vb.getStylesheets().add("css/PlayerField.css");


        GridPane grid = new GridPane();
        grid.setHgap(1.5);
        grid.setVgap(1.5);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button but =
                        playerField[i][j] = new Button(" ");
                but.setMinSize(25, 25);
                if (game.getPlayer().getCellStatus(new Point(j, i)) == GameField.CellStatus.SHIP)
                    but.setStyle("-fx-background-color: orange");
                // but.setStyle("-fx-background-color: blue");
                but.setDisable(true);

                grid.add(but, j, i);
            }

        }
        vb.getChildren().addAll(lb1, grid, new Separator(), lb2);
        return vb;
    }

    private VBox setUpOpponentField() {

        VBox vb = new VBox(4);
        vb.getStylesheets().add("css/OpponentField.css");
        Label lb1 = new Label("Opponent field: " + game.getOpponent().name());
        statusBar = new Label("Your Turn");


        GridPane grid = new GridPane();
        grid.setHgap(1.5);
        grid.setVgap(1.5);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button but =
                        opponentField[i][j] = new Button(" ");
                but.setMinSize(25, 25);

                int finalI = i;
                int finalJ = j;

                but.setOnAction(event -> {

                    Game.ShotType damage = this.game.makeShot(new Point(finalJ, finalI));
                    updateFields();

                    GameField.CellStatus status = this.game.getOpponent().getCellStatus(new Point(finalJ, finalI));

                    if (status != GameField.CellStatus.SHIPSHOT) {
                        getShot();
                    }
                });

                grid.add(but, j, i);
            }

        }
        vb.getChildren().addAll(lb1, grid, new Separator(), statusBar);
        return vb;
    }

}
