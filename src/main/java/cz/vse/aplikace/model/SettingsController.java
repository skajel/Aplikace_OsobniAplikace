package cz.vse.aplikace.model;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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

    @FXML
    public void loadOverview(ActionEvent event) throws IOException {

        InputStream stream = getClass().getClassLoader().getResourceAsStream("OverviewScreen.fxml");
        FXMLLoader loader = new FXMLLoader();
        Parent OverviewScreen = loader.load(stream);

        Scene OverviewScreenScene = new Scene(OverviewScreen);
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(OverviewScreenScene);
    }

    @FXML
    public void loadAccount(ActionEvent event) throws IOException {

        InputStream stream = getClass().getClassLoader().getResourceAsStream("SettingsScreen.fxml");
        FXMLLoader loader = new FXMLLoader();
        Parent SettingsScreen = loader.load(stream);

        Scene SettingScreenScene = new Scene(SettingsScreen);
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(SettingScreenScene);
    }

    @FXML
    public void loadAdd(ActionEvent event) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("AddScreen.fxml");
        FXMLLoader loader = new FXMLLoader();
        Parent AddScreen = loader.load(stream);

        Scene AddScreenScene = new Scene(AddScreen);
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(AddScreenScene);
    }

    @FXML
    public void loadTransaction(ActionEvent event) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("TransactionScreen.fxml");
        FXMLLoader loader = new FXMLLoader();
        Parent TransactionScreen = loader.load(stream);

        Scene TransactionScreenScene = new Scene(TransactionScreen);
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(TransactionScreenScene);
    }

    @FXML
    public void loadLogIn(ActionEvent event) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("LoginScreen.fxml");
        FXMLLoader loader = new FXMLLoader();
        Parent LoginScreen = loader.load(stream);

        Scene LoginScreenScene = new Scene(LoginScreen);
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(LoginScreenScene);
    }

}






