package cz.vse.aplikace.model;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import static cz.vse.aplikace.model.RegisterController.TRANSACTIONS;


public class SettingsController {
    public Button account;
    public Button add;
    public Button transaction;
    public Button overview;

    public ImageView profilePic;

    public Button changeUsername;
    public Button clearTransactions;
    public Button changePicture;
    public Button changeTheme;
    public Button logOut;

    private FileChooser fileChooser;
    private File filePath;



   public void initialize(){
       defaultPicture(); }

   public void loadOverview() {
       overview.setCursor(Cursor.HAND);
       Menu.loadOverview();}
   public void loadAccount(){
       account.setCursor(Cursor.CLOSED_HAND); }
   public void loadAdd(){
       add.setCursor(Cursor.HAND);
       Menu.loadAdd(); }
   public void loadTransaction(){
       transaction.setCursor(Cursor.HAND);
       Menu.loadTransaction();}
   public void loadLogin(){
       logOut.setCursor(Cursor.HAND);
       Menu.loadLogin();
   }
   public void setChangePicture(ActionEvent event) {

        Stage stage = (Stage) ((javafx.scene.Node)event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");

        String userDirectoryString = System.getProperty("user.home");
        File userDirectory = new File(userDirectoryString);

        if (!userDirectory.canRead())
            userDirectory = new File ("c:/");
        fileChooser.setInitialDirectory(userDirectory);
        this.filePath = fileChooser.showOpenDialog(stage);

        try {
            BufferedImage bufferedImage = ImageIO.read(filePath);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);

            profilePic.setImage(image);

        } catch (IOException e) {
            e.printStackTrace();}}
   public void defaultPicture(){Image image = new Image("img1.jpg");
   profilePic.setImage(image);}
   public void setClearTransactions(){
       clearTransactions();}

   public void clearTransactions() {
   }

   public void setChangeUsername(ActionEvent event){
   }

   public void setChangeTheme(ActionEvent event) {
   }

}









