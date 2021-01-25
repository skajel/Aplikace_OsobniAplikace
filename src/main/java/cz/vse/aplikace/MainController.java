package cz.vse.aplikace;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainController {
    public static final String AMOUNT = "amount";
    public static final String DATE = "date";
    public static final String DESCRIPTION = "description";
    public static final String ID = "id";

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String TRANSACTIONS = "transactions";
    public static final String PICTURE = "picture";


    public static Stage primaryStage;
    public static Scene scene;
    public Button account;

    public static void makeWindow(InputStream str) throws IOException{
        primaryStage = new Stage();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Moneify");

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(str);
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void changeScene(InputStream str) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(str);
        primaryStage.setScene((new Scene(root)));
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

}
