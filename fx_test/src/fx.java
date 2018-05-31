import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;


public class fx extends Application {

    Label response;
    ToggleGroup tg;

    double angle = 0.0;

    Rotate rotate = new Rotate();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Toggle demo");

        FlowPane rootNode = new FlowPane(10, 10);


        rootNode.setAlignment(Pos.CENTER);

        Scene scene = new Scene(rootNode, 200, 140);

        primaryStage.setScene(scene);

        Label choose = new Label("   Select a Transport Type   ");

        response = new Label("   No transport confairmed   ");

        RadioButton one = new RadioButton("          Train");
        RadioButton two = new RadioButton("    Car");
        RadioButton three = new RadioButton("    Plassne");

        TextField txt  = new TextField();

        txt.textProperty().addListener((observable, oldValue, newValue) -> response.setText(newValue));


        tg = new ToggleGroup();

        one.setToggleGroup(tg);
        two.setToggleGroup(tg);
        three.setToggleGroup(tg);

        one.setSelected(true);

        Button confirm = new Button("Confirm");
        confirm.getTransforms().add(rotate);

        confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                rotate.setPivotX(confirm.getWidth() / 2);
                rotate.setPivotY(confirm.getHeight() / 2);
                angle += 0;
                delay(10);
                rotate.setAngle(angle);
                angle += 1;
                delay(10);
                rotate.setAngle(angle);
                angle += 2;
                delay(10);
                rotate.setAngle(angle);
                angle += 3;
                delay(10);
                rotate.setAngle(angle);
                angle += 4;
                delay(10);
                rotate.setAngle(angle);
                angle += 5;
                delay(10);
                rotate.setAngle(angle);
                angle += 6;
                delay(10);
                rotate.setAngle(angle);
                angle += 7;
                delay(10);
                rotate.setAngle(angle);
                angle += 8;
                delay(10);
                rotate.setAngle(angle);
                angle += 9;
                delay(10);
                rotate.setAngle(angle);
                angle += 10;
                delay(10);
                rotate.setAngle(angle);
                angle += 11;
                delay(10);
                rotate.setAngle(angle);
                angle += 12;
                delay(10);
                rotate.setAngle(angle);
                angle += 13;
                delay(10);
                rotate.setAngle(angle);
                angle += 14;
                delay(10);
                rotate.setAngle(angle);
                angle += 15;
                delay(10);
                rotate.setAngle(angle);
                angle += 16;
                delay(10);
                rotate.setAngle(angle);
                angle += 17;
                delay(10);
                rotate.setAngle(angle);
                angle += 18;
                delay(10);
                rotate.setAngle(angle);
                angle += 19;
                delay(10);
                rotate.setAngle(angle);
                angle += 20;
                delay(10);
                rotate.setAngle(angle);
                angle += 21;
                delay(10);
                rotate.setAngle(angle);
                angle += 22;
                delay(10);
                rotate.setAngle(angle);
                angle += 23;
                delay(10);
                rotate.setAngle(angle);
                angle += 24;
                delay(10);
                rotate.setAngle(angle);
                angle += 25;
                delay(10);
                rotate.setAngle(angle);
                angle += 26;
                delay(10);
                rotate.setAngle(angle);
                angle += 27;
                delay(10);
                rotate.setAngle(angle);
                angle += 28;
                delay(10);
                rotate.setAngle(angle);
                angle += 29;
                delay(10);
                rotate.setAngle(angle);
            }


        });

        MenuItem cut = new MenuItem("cut");
        MenuItem copy = new MenuItem("copy");
        cut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });// FIXME: 31.05.2018
        ContextMenu ed = new ContextMenu(cut, copy);
        confirm.setContextMenu(ed);

        Separator sep = new Separator();
        sep.setPrefWidth(180);

        rootNode.getChildren().addAll(txt,choose, one, two, three, sep, confirm, response);

        primaryStage.show();
    }

    void delay(int m) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < m) {
        }
    }
}
