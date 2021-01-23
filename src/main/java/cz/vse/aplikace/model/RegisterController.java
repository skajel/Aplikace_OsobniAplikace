package cz.vse.aplikace.model;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterController {
    public TextField username;
    public TextField password;
    public TextField confirmpassword;
    public TextField email;
    public Hyperlink haveanaccount;
    public Button signup;

    private void addUserToJSON() throws NoSuchAlgorithmException {
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

    public byte[] hashPassword(String originalString) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return encodedHash;
    }

    public void submit(MouseEvent mouseEvent) {
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


