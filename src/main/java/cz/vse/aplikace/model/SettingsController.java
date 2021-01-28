package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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

import java.io.InputStream;

public class SettingsController {
    public Button settings_account;
    public Button setting_add;
    public Button settings_transaction;
    public Button settings_overview;
    public Button changeUsername;
    public Button clearTransactions;
    public Button changePicture;
    public Button changeTheme;
    public Button logOut;
    public static String currentPicture;
    public static int currentPictureId = 0;
    public static ImageView updatePicture1;


    /**
     *Tato metoda inicializuje vložené úpravy a vyvolává vložené metody
     */
    public void initialize(){
        defaultPicture();
    }

    /**
     *Metoda, která upravuje Button - Overview, provede změnu scény na OverviewScreen.fxml
     */
    public void loadOverview() {
        settings_overview.setCursor(Cursor.HAND);
        Menu.loadOverview();
    }

    /**
     *Metoda, která upravuje Button - Account, provede změnu scény na SettingsScreen.fxml
     */
    public void loadAccount() {
        settings_account.setCursor(Cursor.CLOSED_HAND);
    }

    /**
     *Metoda, která upravuje Button - Add, provede změnu scény na AddScreen.fxml
     */
    public void loadAdd() {
        setting_add.setCursor(Cursor.HAND);
        Menu.loadAdd();
    }

    /**
     *Metoda, která upravuje Button - Transaction, provede změnu scény na TransactionScreen.fxml
     */
    public void loadTransaction() {
        settings_transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();
    }

    /**
     *Metoda, která upravuje Button - Log out, provede změnu scény na LoginScreen.fxml
     */
    public void loadLogin() {
        logOut.setCursor(Cursor.HAND);
        Menu.loadLogin();
    }
    /**
     *Metoda, která upravuje Button - Change username, provede změnu scény na ChangeUsername.fxml
     */
    public void loadChangeUsername(){
        changeUsername.setCursor(Cursor.HAND);
        Menu.loadChangeUsername();
    }
    /**
     *
     */
    public void setChangeUsername(){
        loadChangeUsername();
    }

    /**
     *
     */
    public static void changePicture(String newPicture) {

        JSON.changeStateInUser(newPicture, MainController.PICTURE);

    }

    public void updatePicture(String picture){


        InputStream Stream = getClass().getClassLoader().getResourceAsStream(picture);
        assert Stream != null;
        Image img = new Image(Stream);
        updatePicture1.setImage(img);
        updatePicture1.setFitWidth(10);
        updatePicture1.setFitHeight(60);
    }

    /**
     *
     */
    public void defaultPicture() {
    }

    /**
     *
     */
    public void setClearTransactions() {
        clearTransactions();
    }

    /**
     *Metoda, která smaže transakce aktuálního/přihlášeného uživatele
     */
    public void clearTransactions() {

    }

    /**
     *
     */
    public void setChangeTheme() {

    }


    /**
     * Metoda, která upravuje Button - change picture, provede změnu obrázku aktuálního/přihlášeného uživatele
     */
    public void swapPicture(ActionEvent actionEvent) {
        int pictureLenght = (Pictures.values().length);
        currentPictureId++;
        if(currentPictureId>pictureLenght){
            currentPictureId=1;
        }
        currentPicture = Pictures.getById(currentPictureId).getDescription();
        changePicture(currentPicture);
        updatePicture(currentPicture);
        System.out.println(currentPicture+ "kurva proč nefunguju?");

    }
}










