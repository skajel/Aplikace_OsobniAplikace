package cz.vse.aplikace.model;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterController {
    public TextField username;
    public TextField password;
    public TextField confirmpassword;
    public TextField email;
    public Hyperlink haveanaccount;
    public Button signup;
    public Label alert;

    public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    private void addUserToJSON() throws NoSuchAlgorithmException {
        if (!(password.getText().equals(confirmpassword.getText()))){
            alert.setText("Password doesn't match.");
            return;
        }

        Matcher matcher = VALID_EMAIL_REGEX.matcher(email.getText());
        if (!matcher.find()){
            alert.setText("Your email address is invalid");
        }

        if (JSON.findEmail(email.getText())){
            alert.setText("Email address '" + email.getText() + "' is being used. Change your email or sign in with this email.");
            return;
        }

        JSON.addUser(username.getText(), toHexString(getSHA(password.getText())), email.getText());

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
}


