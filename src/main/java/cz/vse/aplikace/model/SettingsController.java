package cz.vse.aplikace.model;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;


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


    public void loadOverview(ActionEvent event) throws IOException {
        BorderPane OverviewScreen = FXMLLoader.load(getClass().getResource("OverviewScreen.fxml"));
        overview.getChildrenUnmodifiable().setAll(OverviewScreen);
    }

    public void loadAccount(ActionEvent event) throws IOException {
        BorderPane AccountScreen = FXMLLoader.load(getClass().getResource("SettingsScreen.fxml"));
        account.getChildrenUnmodifiable().setAll(AccountScreen);
    }

    public void loadAdd(ActionEvent event) throws IOException {
        BorderPane AddScreen = FXMLLoader.load(getClass().getResource("AddScreen.fxml"));
        add.getChildrenUnmodifiable().setAll(AddScreen);
    }

    public void loadTransaction(ActionEvent event) throws IOException {
        BorderPane TransactionScreen = FXMLLoader.load(getClass().getResource("TransactionScreen.fxml"));
        transaction.getChildrenUnmodifiable().setAll(TransactionScreen);
    }

    public void loadLogIn(ActionEvent event) throws IOException {
        BorderPane LogInScreen = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        logOut.getChildrenUnmodifiable().setAll(LogInScreen);
    }
}






