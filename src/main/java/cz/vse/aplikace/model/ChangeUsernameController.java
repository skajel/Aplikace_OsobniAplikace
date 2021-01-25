package cz.vse.aplikace.model;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;

public class ChangeUsernameController {

    public Button account;
    public TextField username;
    public Button save;
    public Label labelUsername;

    public void initialize(){
        setLabelUsername();
    }

    public void saveUsername() {
        save.setCursor(Cursor.HAND);
        Menu.loadAccount();
    }

    public String setLabelUsername(){

        JSONArray userList = JSON.loadData();

        System.out.println(userList);

        return null;
    }
}
