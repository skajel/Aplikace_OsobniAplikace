package cz.vse.aplikace.model;

import cz.vse.aplikace.MainController;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Třída cz.vse.aplikace.model.RegisterController je součástí aplikace pro vedení přehledu výdajů a příjmů.
 * <p>
 *
 * Tato třída slouží k registraci uživatele do aplikace a vložení údajů do JSON.json
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */

public class RegisterController {

    public TextField username;
    public TextField register_password;
    public TextField confirm_password;
    public TextField register_email;
    public Button sign_up;
    public Label register_alert;

    public static final Pattern VALID_EMAIL_REGEX = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
    /**
     * Metoda, která vloží parametry uživatele do JSON.json a upravuje podmínky pro jednotlivé vstupní parametry
     */
    private void addUserToJSON() throws NoSuchAlgorithmException {
        if(register_password.getText().isEmpty()){
            register_alert.setText("Password is mandatory");
            return;
        }

        if(username.getText().isEmpty()){
            register_alert.setText("Username is mandatory");
            return;
        }

        if(register_email.getText().isEmpty()){
            register_alert.setText("Email is mandatory");
            return;
        }

        if (!(register_password.getText().equals(confirm_password.getText()))){
            register_alert.setText("Password doesn't match.");
            return;
        }
        Matcher matcher = VALID_EMAIL_REGEX.matcher(register_email.getText());
        if (!matcher.find()){
            register_alert.setText("Your email address is invalid");
            return;
        }

        if (JSON.findEmail(register_email.getText())){
            register_alert.setText("Email address '" + register_email.getText() + "' is being used. Change your email or sign in with this email.");
            return;
        }

        addUser(username.getText(), MainController.toHexString(MainController.getSHA(register_password.getText())), register_email.getText());
        Menu.loadTransaction();



    }
    /**
     * Metoda, která vytváří uživatele a vytvoří jeho array
     */

    public static void addUser(String username, String password, String email) {
        JSONObject user = new JSONObject();
        user.put(MainController.USERNAME, username);
        user.put(MainController.PASSWORD, password);
        user.put(MainController.EMAIL, email);
        user.put(MainController.PICTURE, "img1.jpg");
        user.put(MainController.TRANSACTIONS, new JSONArray());
        JSONArray userList = JSON.loadData();
        userList.add(user);
        JSON.saveData(userList);
        JSON.setCurrentUser(user);

    }
    /**
     * Metoda, která upravuje Button - submit, vyvolá metodu executeSubmit
     */
    public void submit(MouseEvent mouseEvent) {
        register_alert.setText("");
        sign_up.setCursor(Cursor.HAND);
        executeSubmit();
    }
    /**
     * Metoda, která provede samotný zápis uživatele, vyvoláním metody addUserToJSON
     */
    public void executeSubmit(){
        try {
            addUserToJSON();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    /**
     * Metoda, která upravuje Hyperlink a mění scénu na LoginScreen.fxml
     */
    public void toLoginScreen(MouseEvent mouseEvent) {
        Menu.loadLogin();
    }
}


