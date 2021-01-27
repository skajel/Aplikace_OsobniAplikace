package cz.vse.aplikace.main;

import cz.vse.aplikace.MainController;
import cz.vse.aplikace.model.JSON;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class Start extends Application {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader(JSON.SAVE_FILE_NAME);
            JSONParser jsonParser = new JSONParser();
            jsonParser.parse(reader);
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            JSON.saveData(new JSONArray());
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("LoginScreen.fxml");
        MainController.makeWindow(stream);
    }
}
