package cz.vse.aplikace.model;



import cz.vse.aplikace.MainController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

/**
 * Třída cz.vse.aplikace.model.ChangeUsernameController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží jako controller pro screen ChangeUsername.fxml
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public class ChangePictureController {
    public ImageView change_picture;

    /**
     * Tato metoda inicializuje vložené úpravy a vyvolává vložené metody
     */
    public void initialize(){
        setPicture();
    }

    /**
     * Metoda ukládá změněné username do JSON.json
     */
    public void savePicture() {

        Menu.loadAccount();
    }

    /**
     * Metoda nastaví hodnotu labelu na aktuální username.
     */
    public void setPicture() {
        String picture = findPicture();
        InputStream stream = getClass().getClassLoader().getResourceAsStream(picture + ".jpg");
        Image img = new Image(stream);
        change_picture.setImage(img);
    }

    /**
     * Metoda vrací username aktuálního uživatele
     */
    public String findPicture() {
        return JSON.getCurrentUser().get(MainController.PICTURE).toString();
    }
}
