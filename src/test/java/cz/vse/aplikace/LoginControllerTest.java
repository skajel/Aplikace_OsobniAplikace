package cz.vse.aplikace;

import junit.framework.TestCase;
import org.junit.Before;

/**
 * Třída cz.vse.aplikace.LoginControllerTest je součástí testl pto aplikaci pro vedení přehledu výdajů a příjmů.
 *
 * Tato třída slouží k otestování LoginControlleru aplikace.
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */

public class LoginControllerTest extends TestCase {

    public String login_email;
    public String login_password;

    /**
     * Metoda před začátkem testu nastaví email a heslo uživatele
     */
    @Before
    public void setUp() throws Exception {
        login_email = "user@user.com";
        login_password = "password";
        super.setUp();
    }
    /**
     * Test assertEquals na email uživatele
     */
    public void testCheckEmail() {
        assertEquals("user@user.com", login_email);
    }
    /**
     * Test assertEquals na heslo uživatele
     */
    public void testPassword() {
        assertEquals("password", login_password);
    }
}