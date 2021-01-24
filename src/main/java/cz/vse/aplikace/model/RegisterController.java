package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterController {
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String TRANSACTIONS = "transactions";
    public static final String PICTURE = "picture";

    public TextField username;
    public TextField password;
    public TextField confirmpassword;
    public TextField email;
    public Hyperlink haveanaccount;
    public Button signup;
    public Label alert;

    public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    private void addUserToJSON() throws NoSuchAlgorithmException {
        if(password.getText().isEmpty()){
            alert.setText("Password is mandatory");
            return;
        }

        if(username.getText().isEmpty()){
            alert.setText("Username is mandatory");
            return;
        }

        if(email.getText().isEmpty()){
            alert.setText("Email is mandatory");
            return;
        }

        if (!(password.getText().equals(confirmpassword.getText()))){
            alert.setText("Password doesn't match.");
            return;
        }
        Matcher matcher = VALID_EMAIL_REGEX.matcher(email.getText());
        if (!matcher.find()){
            alert.setText("Your email address is invalid");
            return;
        }

        if (findEmail(email.getText())){
            alert.setText("Email address '" + email.getText() + "' is being used. Change your email or sign in with this email.");
            return;
        }

        addUser(username.getText(), toHexString(getSHA(password.getText())), email.getText());
        InputStream stream = getClass().getClassLoader().getResourceAsStream("TransactionScreen.fxml");
        try {
            MainController.changeScene(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addUser(String username, String password, String email) {
        JSONObject user = new JSONObject();
        user.put(USERNAME, username);
        user.put(PASSWORD, password);
        user.put(EMAIL, email);
        user.put(PICTURE, 1);
        user.put(TRANSACTIONS, "");
        JSONArray userList = JSON.loadData();
        userList.add(user);
        JSON.saveData(userList);

    }

    public static boolean findEmail(String email){
        JSONArray userList = JSON.loadData();
        AtomicBoolean value = new AtomicBoolean(false);
        userList.forEach(currentUser -> {
            if (JSON.compareUserInfo((JSONObject) currentUser, email, RegisterController.EMAIL)) {
                value.set(true);
                return;
            }});
        return value.get();
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    public void submit(MouseEvent mouseEvent) {
        alert.setText("");
        signup.setCursor(Cursor.HAND);
        executeSubmit();
    }

    public void executeSubmit(){
        try {
            addUserToJSON();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public void toLoginScreen(MouseEvent mouseEvent) throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("LoginScreen.fxml");
        MainController.changeScene(stream);
    }
}


