package cz.vse.aplikace;

import cz.vse.aplikace.model.JSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Třída cz.vse.aplikace.RegisterControllerTest je součástí testl pto aplikaci pro vedení přehledu výdajů a příjmů.
 *
 * Tato třída slouží k otestování RegisterControlleru aplikace.
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */

public class RegisterControllerTest {

    /**
     * Metoda před testem vytvoří objekt user v JSON. Vloží zadané parametry.
     */
    @Before
    public void before(){
        JSONObject user = new JSONObject();
        user.put(MainController.USERNAME, "user");
        user.put(MainController.PASSWORD, "password");
        user.put(MainController.EMAIL, "user@user.cz");
        user.put(MainController.PICTURE, "img1.jpg");
        JSONArray userList = JSON.loadData();
        userList.add(user);
        JSON.saveData(userList);
        JSON.setCurrentUser(user);


    }

    /**
     * Metoda testuje assertEquals na současné uživatelské jméno uživatele a to uložené
     */
    @Test
    public void testUsername() {
        assertEquals("user",JSON.getCurrentUser().get(MainController.USERNAME).toString());
    }

    /**
     * Metoda testuje assertEquals na současný heslo uživatele a to uložené
     */
    @Test
    public void testPassword() {
        assertEquals("password",JSON.getCurrentUser().get(MainController.PASSWORD).toString());
    }

    /**
     * Metoda testuje assertEquals na současný email uživatele a ten uložený
     */
    @Test
    public void testEmail() {
        assertEquals("user@user.cz",JSON.getCurrentUser().get(MainController.EMAIL).toString());
    }

    /**
     * Metoda testuje assertEquals na současný obrázek uživatele a ten vložený
     */
    @Test
    public void testPicture() {
        assertEquals("img1.jpg",JSON.getCurrentUser().get(MainController.PICTURE).toString());
    }

    /**
     * Metoda po testu vymaže objekt user z JSON.
     */

    @After
    public void after(){
        JSONArray userList = JSON.loadData();
        JSONObject user = JSON.findUser((String) JSON.getCurrentUser().get(MainController.EMAIL));
        userList.remove(user);
        JSON.saveData(userList);
    }
}