package cz.vse.aplikace.main;

import cz.vse.aplikace.MainController;
import cz.vse.aplikace.model.JSON;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.simple.JSONArray;

import java.io.InputStream;

public class Start extends Application {
    public static void main(String[] args) {
//        if(JSON.loadData().){
//            JSONArray array = new JSONArray();
//            JSON.saveData(array);
//        }
            launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("LoginScreen.fxml");
        MainController.makeWindow(stream);
    }
}
