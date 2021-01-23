package cz.vse.aplikace.model;

import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

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






    public byte[] hashPassword(String originalString) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash= digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return encodedHash;
    }

}


