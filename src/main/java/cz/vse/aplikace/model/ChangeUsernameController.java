package cz.vse.aplikace.model;



import cz.vse.aplikace.MainController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Třída cz.vse.aplikace.model.ChangeUsernameController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží jako controller pro screen ChangeUsername.fxml
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public class ChangeUsernameController {


    public TextField change_username;
    public Button change_save;
    public Label change_labelUsername;
    public Label user_alert;

    /**
     * Tato metoda inicializuje vložené úpravy a vyvolává vložené metody
     */
    public void initialize(){
        setLabelUsername();
        user_alert.setText("");
    }

    /**
     * Metoda ukládá změněné username do JSON.json
     */
    public void saveUsername() {
        user_alert.setText("");
        String newUsername = change_username.getText();
        if(newUsername.isEmpty()){
            user_alert.setText("You have to fill in a username.");
            return;
        }
        JSON.changeStateInUser(newUsername, MainController.USERNAME);
        Menu.loadAccount();
    }

    /**
     * Metoda nastaví hodnotu labelu na aktuální username.
     */
    public void setLabelUsername() {
        change_labelUsername.setText(findUsername());
    }

    /**
     * Metoda vrací username aktuálního uživatele
     */
    public String findUsername() {
        return JSON.getCurrentUser().get(MainController.USERNAME).toString();
    }
}
