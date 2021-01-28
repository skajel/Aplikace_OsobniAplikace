package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SettingsController {
    public Button settings_account;
    public Button setting_add;
    public Button settings_transaction;
    public Button settings_overview;
    public ImageView profilePic;

    public Button changeUsername;
    public Button clearTransactions;
    public Button changePicture;
    public Button changeTheme;
    public Button logOut;
    public static int currentPictureId = 1;
    public static String currentPicture;

/*
    public Image image1 = new Image("img1.jpg");
    public Image image2 = new Image("img2.jpg");
    public Image image3 = new Image("img3.jpg");
    public Image currentImage = image1;
*/

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
    public void setChangePicture() {
        setChangePicture();
    }

    /**
     * @param event
     */
    public void setChangePicture(ActionEvent event) {
        JSONObject currentUser = JSON.getCurrentUser();
        currentUser.replace(MainController.PICTURE, "something");

        JSON.setCurrentUser(currentUser);
        JSONArray userList = JSON.loadData();
        JSONObject currentUserInJSON = JSON.findUser((String) JSON.getCurrentUser().get(MainController.EMAIL));
        userList.remove(currentUserInJSON);
        userList.add(currentUser);
        JSON.saveData(userList);
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
    public static void swapPicture(){

        int pictureLenght = (Pictures.values().length);
        currentPictureId++;
        if(currentPictureId>pictureLenght){
            currentPictureId=1;
        }

        currentPicture = Pictures.getById(currentPictureId).getDescription();
        System.out.println(currentPicture);

    }
}










