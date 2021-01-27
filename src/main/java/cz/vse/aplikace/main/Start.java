package cz.vse.aplikace.main;

import cz.vse.aplikace.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.InputStream;

public class Start extends Application {
    public static void main(String[] args) {
            launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("RegisterScreen.fxml");
        MainController.makeWindow(stream);
    }
}
