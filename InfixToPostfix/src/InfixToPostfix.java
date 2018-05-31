
import functional.func;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class InfixToPostfix extends Application {

    private String str_outp;

    public  void start(Stage primaryStage) {

        VBox vb = new VBox(10);
        vb.setPadding(new Insets(10));

        Scene scene = new Scene(vb);

        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(150);
        primaryStage.setMaxHeight(170);
        primaryStage.setTitle("Infix notation to postfix");


        Label inf_lab = new Label("Infix not.: ");
        inf_lab.setMinWidth(70);
        TextField input = new TextField();
        input.setPromptText("Input text in infix notation");
        HBox hb1 = new HBox(5,inf_lab,input);
        hb1.setHgrow(input,Priority.ALWAYS);

        Button main_action = new Button("Convert to prefix");
        main_action.setAlignment(Pos.CENTER);
        main_action.setPrefWidth(Double.MAX_VALUE);

        Label postf_lab = new Label("Postfix not.: ");
        postf_lab.setMinWidth(70);
        TextField output = new TextField();
        output.setEditable(false);
        HBox hb2 = new HBox(5,postf_lab,output);
        hb2.setHgrow(output,Priority.ALWAYS);

        input.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                str_outp = func.inf_to_pstf(newValue);
                if(str_outp.equals("-+-"))
                    main_action.setDisable(true);
                else
                    main_action.setDisable(false);
            }
        });

        main_action.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                output.setText(func.inf_to_pstf(input.getText()));
            }
        });

        vb.getChildren().addAll(hb1,main_action,hb2);
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
