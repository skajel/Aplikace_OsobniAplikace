package cz.vse.aplikace;

import junit.framework.TestCase;
import org.junit.Before;


public class AddControllerTest extends TestCase {

    public String addTransactionSum;
    public String addTransactionDescription;

    @Before
    public void setUp() throws Exception {
        addTransactionDescription = "popis";
        addTransactionSum = "500";
        super.setUp();
    }


    public void testDescription(){
        assertEquals("popis", addTransactionDescription);
    }

    public void testSum(){
        assertEquals("500", addTransactionSum);
    }

}