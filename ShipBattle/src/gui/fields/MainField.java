package gui.fields;

import game.Game;
import gameelements.Point;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainField extends Stage {

    private Button[][] field = new Button[10][10];

    private Game game;

    public MainField(Game game) {
        this.game = game;

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid);

        setUpField(grid);
        setScene(scene);
    }

    private void setUpField(GridPane grid) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Button but =
                        field[i][j] = new Button(" ");
                but.setMinSize(25, 25);

                int finalI = i;
                int finalJ = j;

                but.setOnAction(event -> {
                    field[finalI][finalJ].setDisable(true);
                    this.game.makeShot(new Point(finalJ, finalI));

                });

                grid.add(but, j, i);
            }
        }
    }
}
