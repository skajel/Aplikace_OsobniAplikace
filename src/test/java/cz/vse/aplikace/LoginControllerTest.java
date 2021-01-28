package cz.vse.aplikace;

import javafx.scene.control.TextField;
import junit.framework.TestCase;
import org.junit.Before;

public class LoginControllerTest extends TestCase {

    public String login_email;
    public String login_password;

    @Before
    public void setUp() throws Exception {
        login_email = "user@user.com";
        login_password = "password";
        super.setUp();
    }

    public void testCheckEmail() {
        assertEquals("user@user.com", login_email);
    }
    public void testPassword() {
        assertEquals("password", login_password);
    }
}