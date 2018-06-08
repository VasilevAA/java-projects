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
            if (status == GameField.CellStatus.SHIPSHOT) {
                playerField[point.getY()][point.getX()].setStyle("-fx-background-color: red");
                getShot();
            } else {
                playerField[point.getY()][point.getX()].setStyle("-fx-background-color: mediumseagreen");
                playerField[point.getY()][point.getX()].setText("*");
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
                    opponentField[finalI][finalJ].setDisable(true);
                    this.game.makeShot(new Point(finalJ, finalI));
                    // Cell.CellStatus status = this.game.makeShot(new Point(finalJ, finalI));
                   GameField.CellStatus status = this.game.getOpponent().getCellStatus(new Point(finalJ, finalI));
                    if (status == GameField.CellStatus.SHIPSHOT) {
                        opponentField[finalI][finalJ].setStyle("-fx-background-color: red");
                    } else {
                        getShot();
                        opponentField[finalI][finalJ].setStyle("-fx-background-color: lightgreen");

                    }

                });

                grid.add(but, j, i);
            }

        }
        vb.getChildren().addAll(lb1, grid, new Separator(), statusBar);
        return vb;
    }

}
