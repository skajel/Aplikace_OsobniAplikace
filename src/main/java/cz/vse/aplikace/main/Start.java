package cz.vse.aplikace.main;


import cz.vse.aplikace.MainController;
import cz.vse.aplikace.model.Category;
import cz.vse.aplikace.model.JSON;
import cz.vse.aplikace.model.SettingsController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * Třída cz.vse.aplikace.main.Start je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 * Tato třída slouží ke spuštení grafického rozhraní aplikace.
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public class Start extends Application {
    /**
     * main metoda pro spuštění aplikace
     */
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
        } catch (IOException e) {
            e.printStackTrace();
        }

            launch();

    }

    /**
     *  Metoda určuje primární okno po spuštění, metoda inicializuje MainController
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("LoginScreen.fxml");
        MainController.makeWindow(stream);

    }
}
