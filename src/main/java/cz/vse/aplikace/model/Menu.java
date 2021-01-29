package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;

import java.io.InputStream;
/**
 * Třída cz.vse.aplikace.model.Menu je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží k přepínání obrazovek v menu
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */

public class Menu {

    /**
     * Tato metoda nastaví obrazovku na OverviewScreen.fxml
     */
    public static void loadOverview() {
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("OverviewScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Tato metoda nastaví obrazovku na SettingsScreen.fxml
     */
    public static void loadAccount(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("SettingsScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Tato metoda nastaví obrazovku na AddScreen.fxml
     */
    public static void loadAdd(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("AddScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Tato metoda nastaví obrazovku na LoginScreen.fxml
     */
    public static void loadLogin(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("LoginScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Tato metoda nastaví obrazovku na RegisterScreen.fxml
     */
    public static void loadRegister(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("RegisterScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Tato metoda nastaví obrazovku na ChangeUsername.fxml
     */
    public static void loadChangeUsername() {

        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("ChangeUsername.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


