package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONObject;
import java.security.NoSuchAlgorithmException;


public class LoginController {
    public TextField login_email;
    public TextField login_password;
    public Label login_alert;
    public Button sign_in;
    public static JSONObject currentUser;


    public void signIn(MouseEvent mouseEvent) throws NoSuchAlgorithmException {
        login_alert.setText("");
        sign_in.setCursor(Cursor.HAND);
        checkUser();
    }

    private void checkUser() throws NoSuchAlgorithmException {
        if(login_email.getText().isEmpty()){
            login_alert.setText("You have to fill in the email.");
            return;
        }
        if(login_password.getText().isEmpty()){
            login_alert.setText("You have to fill in the password.");
            return;
        }

        if(!JSON.findEmail(login_email.getText())){
            login_alert.setText("User not found.");
            return;
        }

        JSONObject user = JSON.findUser(login_email.getText());


        if (!(JSON.compareUserInfo(user, login_email.getText(), MainController.EMAIL)) || !(JSON.compareUserInfo(user, hashPassword(), MainController.PASSWORD))) {
            login_alert.setText("Email or password is invalid");
            return;
        }

        setCurrentUser(user);
        Menu.loadTransaction();


    }
    public static void setCurrentUser(JSONObject user){
        currentUser = user;
    }

    public static JSONObject getCurrentUser(){
        return currentUser;
    }


    private String hashPassword() throws NoSuchAlgorithmException {
          return MainController.toHexString(MainController.getSHA(login_password.getText()));
    }

    public void toRegisterScreen(MouseEvent mouseEvent) {
        Menu.loadRegister();
    }
}
