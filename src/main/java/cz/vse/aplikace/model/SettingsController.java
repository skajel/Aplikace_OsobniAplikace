package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
/**
 * Třída cz.vse.aplikace.model.SettingsController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží jako controller pro SettingsScreen.fxml - která slouží k nastavení uživatelského účtu
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public class SettingsController {
    public Button settings_account;
    public Button setting_add;
    public Button settings_overview;
    public Button changeUsername;
    public Button logOut;
    public static ImageView updatePicture1;
    public Label settings_username;
    public static BorderPane f;

    /**
     *Tato metoda inicializuje vložené úpravy a vyvolává vložené metody
     */
    public void initialize(){
        settings_username.setText(JSON.getCurrentUser().get(MainController.USERNAME).toString());
    }

    /**
     *Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
     */
    public void loadOverview() {
        Menu.loadOverview();
    }

    /**
     *Metoda, která upravuje Button - Add, provede změnu scény na AddScreen.fxml
     */
    public void loadAdd() {
        Menu.loadAdd();
    }

    /**
     *Metoda, která upravuje Button - Log out, provede změnu scény na LoginScreen.fxml
     */
    public void loadLogin() {
        Menu.loadLogin();
    }
    /**
     *Metoda, která upravuje Button - Change username, provede změnu scény na ChangeUsername.fxml
     */
    public void loadChangeUsername(){
        Menu.loadChangeUsername();
    }

    /**
     * Metoda na ovládání buttonu changeUsername
     */
    public void setChangeUsername(){
        loadChangeUsername();
    }
}










