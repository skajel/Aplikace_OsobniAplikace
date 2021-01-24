package cz.vse.aplikace.model;



import cz.vse.aplikace.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class SettingsController implements Initializable {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void loadOverview() {
        Menu.loadOverview();
    }
    public void loadAccount(){
       Menu.loadAccount();
    }
    public void loadAdd(){
        Menu.loadAdd();
    }
    public void loadTransaction(){
        Menu.loadTransaction();
    }
    public void loadLogin(){

        Menu.loadLogin();
    }
}






