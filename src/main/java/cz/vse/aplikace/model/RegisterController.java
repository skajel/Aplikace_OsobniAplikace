package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterController {

    public TextField username;
    public TextField register_password;
    public TextField confirm_password;
    public TextField register_email;
    public Button sign_up;
    public Label register_alert;
    private final String basePicture = Pictures.getById(1).getDescription();

    public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    private void addUserToJSON() throws NoSuchAlgorithmException {
        if(register_password.getText().isEmpty()){
            register_alert.setText("Password is mandatory");
            return;
        }

        if(username.getText().isEmpty()){
            register_alert.setText("Username is mandatory");
            return;
        }

        if(register_email.getText().isEmpty()){
            register_alert.setText("Email is mandatory");
            return;
        }

        if (!(register_password.getText().equals(confirm_password.getText()))){
            register_alert.setText("Password doesn't match.");
            return;
        }
        Matcher matcher = VALID_EMAIL_REGEX.matcher(register_email.getText());
        if (!matcher.find()){
            register_alert.setText("Your email address is invalid");
            return;
        }

        if (JSON.findEmail(register_email.getText())){
            register_alert.setText("Email address '" + register_email.getText() + "' is being used. Change your email or sign in with this email.");
            return;
        }

        addUser(username.getText(), MainController.toHexString(MainController.getSHA(register_password.getText())), register_email.getText(),basePicture);
        Menu.loadTransaction();



    }

    public static void addUser(String username, String password, String email, String basePicture) {
        JSONObject user = new JSONObject();
        user.put(MainController.USERNAME, username);
        user.put(MainController.PASSWORD, password);
        user.put(MainController.EMAIL, email);
        user.put(MainController.PICTURE, basePicture);
        user.put(MainController.TRANSACTIONS, new JSONArray());
        JSONArray userList = JSON.loadData();
        userList.add(user);
        JSON.saveData(userList);
        JSON.setCurrentUser(user);

    }

    public void submit(MouseEvent mouseEvent) {
        register_alert.setText("");
        sign_up.setCursor(Cursor.HAND);
        executeSubmit();
    }

    public void executeSubmit(){
        try {
            addUserToJSON();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void toLoginScreen(MouseEvent mouseEvent) {
        Menu.loadLogin();
    }
}


