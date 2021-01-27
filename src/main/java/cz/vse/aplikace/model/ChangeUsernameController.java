package cz.vse.aplikace.model;


import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ChangeUsernameController {


    public TextField change_username;
    public Button change_save;
    public Label change_labelUsername;

    public void initialize(){
        change_save.setCursor(Cursor.HAND);
        change_username.setPromptText("Enter new username");
        setLabelUsername();
    }
    public void saveUsername() {
        String newUsername = change_username.getText();
        JSONObject currentUser = JSON.getCurrentUser();
        currentUser.replace(MainController.USERNAME, newUsername);
        JSON.setCurrentUser(currentUser);
        JSONArray userList = JSON.loadData();
        JSONObject currentUserInJSON = JSON.findUser((String) JSON.getCurrentUser().get(MainController.EMAIL));
        userList.remove(currentUserInJSON);
        userList.add(currentUser);
        JSON.saveData(userList);


        Menu.loadAccount();
    }

    public void setLabelUsername() {
        change_labelUsername.setText(findUsername());
    }

    public String findUsername() {
        String username = (String) JSON.getCurrentUser().get(MainController.USERNAME);
        return username;
    }
}
