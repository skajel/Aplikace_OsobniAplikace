package cz.vse.aplikace.model;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class SettingsController {
    public Button account;
    public Button add;
    public Button transaction;
    public Button overview;
    public ImageView profilePic;
    public Button changeUsername;
    public Button changePassword;
    public Button changeCurrency;
    public Button changePicture;
    public Button premium;
    public Button changeTheme;
    public Button logOut;


    public void loadOverview() {Menu.loadOverview();}
    public void loadAccount(){Menu.loadAccount();}
    public void loadAdd(){Menu.loadAdd(); }
    public void loadTransaction(){Menu.loadTransaction();}
    public void loadLogin(){Menu.loadLogin();}
}






