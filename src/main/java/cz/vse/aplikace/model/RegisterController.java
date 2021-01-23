package cz.vse.aplikace.model;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterController {
    private JSON json;

    public TextField username;
    public TextField password;
    public TextField confirmpassword;
    public TextField email;
    public Hyperlink haveanaccount;
    public Button signup;

    private void addUserToJSON() throws NoSuchAlgorithmException {
        json.addUser(username.getSelectedText(), hashPassword(password.getSelectedText()), email.getSelectedText());
    }


    public byte[] hashPassword(String originalString) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash= digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return encodedHash;
    }

    public void submit(ActionEvent actionEvent) {
        signup.setOnMouseClicked(event -> {
            try {
                addUserToJSON();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        });
    }
}


