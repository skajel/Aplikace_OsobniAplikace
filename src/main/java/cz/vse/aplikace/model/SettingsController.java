package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    public static ImageView updatePicture;

    /**
     *
     */
    public void initialize(){
        defaultPicture();
    }

    /**
     *
     */
    public void loadOverview() {
        settings_overview.setCursor(Cursor.HAND);
        Menu.loadOverview();
    }

    /**
     *
     */
    public void loadAccount() {
        settings_account.setCursor(Cursor.CLOSED_HAND);
    }

    /**
     *
     */
    public void loadAdd() {
        setting_add.setCursor(Cursor.HAND);
        Menu.loadAdd();
    }

    /**
     *
     */
    public void loadTransaction() {
        settings_transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();
    }

    /**
     *
     */
    public void loadLogin() {
        logOut.setCursor(Cursor.HAND);
        Menu.loadLogin();
    }
    /**
     *
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

    public void supdatePicture(String picture){

        InputStream Stream = getClass().getClassLoader().getResourceAsStream(picture);
        assert Stream != null;
        Image img = new Image(Stream);
        updatePicture.setImage(img);
        updatePicture.setFitWidth(60);
        updatePicture.setFitHeight(60);


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
     *
     */
    public void clearTransactions() {

    }

    /**
     * @param
     */
    public void setChangeTheme() {

    }


    public void swapPicture(ActionEvent actionEvent) {
        int pictureLenght = (Pictures.values().length);
        currentPictureId++;
        if(currentPictureId>pictureLenght){
            currentPictureId=1;
        }
        currentPicture = Pictures.getById(currentPictureId).getDescription();
        changePicture(currentPicture);
        supdatePicture(currentPicture);
        System.out.println(currentPicture);

    }
}










