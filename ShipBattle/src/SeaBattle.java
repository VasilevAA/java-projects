import gui.menus.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class SeaBattle extends Application {
    @Override
    public void start(Stage primaryStage) {

        MainMenu menu = new MainMenu();

        menu.createMainMenu(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);


    }
}

