package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.simple.JSONObject;
import java.security.NoSuchAlgorithmException;

/**
 * Třída cz.vse.aplikace.model.LoginController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží k přihlášení existujícího uživatele do aplikace.
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */


public class LoginController {
    public TextField login_email;
    public TextField login_password;
    public Label login_alert;
    public Button sign_in;


    /**
     * Metoda, která upravuje Button - Sign in a vyvolává metodu checkUser
     */
    public void signIn() throws NoSuchAlgorithmException {
        login_alert.setText("");
        checkUser();
    }

    /**
     * Metoda, která slouží k ověření přihlašovácího emailu a hesla s údaji v JSON.json, společně s podmínky pro vstupní hodnoty
     */
    private void checkUser() throws NoSuchAlgorithmException {
        if(login_email.getText().isEmpty()){
            login_alert.setText("You have to fill in the email.");
            return;
        }
        if(login_password.getText().isEmpty()){
            login_alert.setText("You have to fill in the password.");
            return;
        }

        if(!JSON.findEmail(login_email.getText())){
            login_alert.setText("User not found.");
            return;
        }

        JSONObject user = JSON.findUser(login_email.getText());


        if (!(JSON.compareUserInfo(user, login_email.getText(), MainController.EMAIL)) || !(JSON.compareUserInfo(user, hashPassword(), MainController.PASSWORD))) {
            login_alert.setText("Email or password is invalid");
            return;
        }

        JSON.setCurrentUser(user);
        Menu.loadTransaction();

    }


    /**
     * Metoda, HASHuje heslo
     */
    private String hashPassword() throws NoSuchAlgorithmException {
          return MainController.toHexString(MainController.getSHA(login_password.getText()));
    }

    /**
     *Metoda, která upravuje HyperLink a mění scénu na RegisterScreen.fxml
     */
    public void toRegisterScreen() {
        Menu.loadRegister();
    }
}
