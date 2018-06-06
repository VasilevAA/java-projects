package gui.fields;

import gameelements.Point;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import player.Player;

public class MainField {
    Button [][]field = new Button[10][10];

    Stage stage = new Stage();

    Player opponent;
    Player player;


    public Stage getStage() {
        return stage;
    }

    public MainField(Player opponent, Player player){
        GridPane grid= new GridPane();
        Scene scene = new Scene(grid);
        this.opponent = opponent;
        this.player = player;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button but =
                field[i][j] = new Button(" ");
                but.setMinSize(25,25);

                int finalI = i;
                int finalJ = j;
                but.setOnAction(event -> {
                    //this.opponent.getCorrectShot(new Point(finalJ, finalI));
                    //this.opponent.printField();
                    field[finalI][finalJ].setDisable(true);
                    this.player.setShot(new Point(finalJ,finalI));
                    this.player.setThinking(false);

                });
                grid.add(but,j,i);
            }
        }


        stage.setScene(scene);
        stage.show();
    }
}
