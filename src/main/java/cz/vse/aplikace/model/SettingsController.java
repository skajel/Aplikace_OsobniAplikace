package cz.vse.aplikace.model;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SettingsController {
    public Button account;
    public Button add;
    public Button transaction;
    public Button overview;
    public ImageView profilePic;
    public Button changeUsername;
    public Button changePassword;
    public Button changeCurrency;
    public Button changePicture;
    public Button premium;
    public Button changeTheme;
    public Button logOut;


    public void loadOverview() {
        overview.setCursor(Cursor.HAND);
        Menu.loadOverview();}
    public void loadAccount(){
        account.setCursor(Cursor.CLOSED_HAND); }
    public void loadAdd(){
        add.setCursor(Cursor.HAND);
        Menu.loadAdd(); }
    public void loadTransaction(){
        transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();}
    public void loadLogin(){
        logOut.setCursor(Cursor.HAND);
        Menu.loadLogin();}
}






