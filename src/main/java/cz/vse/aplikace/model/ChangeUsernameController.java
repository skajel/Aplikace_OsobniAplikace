package cz.vse.aplikace.model;


import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ChangeUsernameController {

    public Button account;
    public TextField username;
    public Button save;
    public Label labelUsername;

    public void initialize(){
        username.setPromptText("Enter new username");
        setLabelUsername();
    }
    public void saveUsername() {
        save.setCursor(Cursor.HAND);
        Menu.loadAccount();
    }

    public void setLabelUsername() {
        labelUsername.setText(findUsername());
    }

    public String findUsername() {
        return MainController.USERNAME;
    }
}
