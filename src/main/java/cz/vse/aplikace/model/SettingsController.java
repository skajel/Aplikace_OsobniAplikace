package cz.vse.aplikace.model;

import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

    public Image image1 = new Image("img1.jpg");
    public Image image2 = new Image("img2.jpg");
    public Image image3 = new Image("img3.jpg");
    public Image currentImage = image1;


    public void initialize(){
        defaultPicture();
    }
    public void loadOverview() {
        overview.setCursor(Cursor.HAND);
        Menu.loadOverview();
    }

    public void loadAccount() {
        account.setCursor(Cursor.CLOSED_HAND);
    }

    public void loadAdd() {
        add.setCursor(Cursor.HAND);
        Menu.loadAdd();
    }

    public void loadTransaction() {
        transaction.setCursor(Cursor.HAND);
        Menu.loadTransaction();
    }

    public void loadLogin() {
        logOut.setCursor(Cursor.HAND);
        Menu.loadLogin();
    }

    public void loadChangeUsername(){
        changeUsername.setCursor(Cursor.HAND);
        Menu.loadChangeUsername();
    }

    public void setChangeUsername(){
        loadChangeUsername();
    }

    public void setChangePicture(ActionEvent event) {
        if (this.profilePic.getImage() == this.image1) {
            this.currentImage = this.image2;
        } else if (this.profilePic.getImage() == this.image2) {
            this.currentImage = this.image3;
        } else {
            this.currentImage = this.image1;
        }
        this.defaultPicture();
    }

    public void defaultPicture() {
        profilePic.setImage(this.currentImage);
    }

    public void setClearTransactions() {
        clearTransactions();
    }

    public void clearTransactions() {
    }

    public void setChangeTheme(ActionEvent event) {
    }
}










