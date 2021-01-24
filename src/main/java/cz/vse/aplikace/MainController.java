package cz.vse.aplikace;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MainController {
    public static Stage primaryStage;
    public static Scene scene;

    public static void makeWindow(InputStream str) throws IOException{
        primaryStage = new Stage();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Moneify");

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(str);
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void changeScene(InputStream str) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(str);
        primaryStage.setScene((new Scene(root)));
    }

}
