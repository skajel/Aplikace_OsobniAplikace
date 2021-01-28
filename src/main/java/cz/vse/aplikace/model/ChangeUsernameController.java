package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeUsernameController {


    public TextField change_username;
    public Button change_save;
    public Label change_labelUsername;

    public void initialize(){
        setLabelUsername();
    }
    public void saveUsername() {
        String newUsername = change_username.getText();
        JSON.changeStateInUser(newUsername, MainController.USERNAME);
        Menu.loadAccount();
    }

    public void setLabelUsername() {
        change_labelUsername.setText(findUsername());
    }

    public String findUsername() {
        return JSON.getCurrentUser().get(MainController.USERNAME).toString();
    }
}
