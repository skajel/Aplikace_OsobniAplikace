package cz.vse.aplikace.main;

import cz.vse.aplikace.MainController;
import cz.vse.aplikace.model.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.InputStream;

public class Start extends Application {
    public static void main(String[] args) {
            launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("registerScreen.fxml");
        MainController.makeWindow(stream);


    }
}
