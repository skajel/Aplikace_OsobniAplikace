package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;

import java.io.InputStream;


public class Menu {

    public static void loadOverview() {
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("OverviewScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadAccount(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("SettingsScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadAdd(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("AddScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadTransaction(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("TransactionScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadLogin(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("LoginScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadRegister(){
        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("RegisterScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadChangeUsername() {

        InputStream stream = Menu.class.getClassLoader().getResourceAsStream("ChangeUsername.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


