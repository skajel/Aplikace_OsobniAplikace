package cz.vse.aplikace;

import junit.framework.TestCase;
import org.junit.Before;

/**
 * Třída cz.vse.aplikace.AddControllerTest je součástí testl pto aplikaci pro vedení přehledu výdajů a příjmů.
 *
 * Tato třída slouží k otestování AddControlleru aplikace.
 *
 * @author Martin Bureš, Ondra Šesták, Ondra Štěpán, Lukáš Fiala, Jan Andrášek
 * @version 1.0 GUI
 * @created leden 2021 pro ZS 2020/2021
 */

public class AddControllerTest extends TestCase {

    public String addTransactionSum;
    public String addTransactionDescription;

    /**
     * Metoda před začátkem testu nastaví popos a sumu transakce
     */
    @Before
    public void setUp() throws Exception {
        addTransactionDescription = "popis";
        addTransactionSum = "500";
        super.setUp();
    }

    /**
     * Test assertEquals na popis transakce
     */
    public void testDescription(){
        assertEquals("popis", addTransactionDescription);
    }
    /**
     * Test assertEquals na sumu transakce
     */
    public void testSum(){
        assertEquals("500", addTransactionSum);
    }

}