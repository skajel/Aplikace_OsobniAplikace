package cz.vse.aplikace;

import cz.vse.aplikace.model.JSON;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;

public class RegisterControllerTest extends TestCase {

    @Before
    public void setUp(){
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
    public void testUsername() {
        assertEquals("user",JSON.getCurrentUser().get(MainController.USERNAME).toString());
    }

    public void testPassword() {
        assertEquals("password",JSON.getCurrentUser().get(MainController.PASSWORD).toString());
    }

    public void testEmail() {
        assertEquals("user@user.cz",JSON.getCurrentUser().get(MainController.EMAIL).toString());
    }

    public void testPicture() {
        assertEquals("img1.jpg",JSON.getCurrentUser().get(MainController.PICTURE).toString());
    }
}