package banking;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PhoneNumberTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PhoneNumberTest
{
    /**
     * Default constructor for test class PhoneNumberTest
     */
    public PhoneNumberTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void areaCodeTest()
    {
        banking.PhoneNumber phoneNum1 = new banking.PhoneNumber(876, 4725772);
        assertEquals(876, phoneNum1.getAreaCode());
    }

    @Test
    public void callingCodeTest()
    {
        banking.PhoneNumber phoneNum1 = new banking.PhoneNumber(876, 4725772);
        assertEquals(4725772, phoneNum1.getNumber());
    }

    @Test
    public void validTest()
    {
        banking.PhoneNumber phoneNum1 = new banking.PhoneNumber(876, 8679239);
        assertEquals(true, phoneNum1.isValid());
    }
    
    @Test
    public void fullNumberTest()
    {
        banking.PhoneNumber phoneNum1 = new banking.PhoneNumber(876, 8679239);
        assertEquals(8768679239L, phoneNum1.getFullNumber());
    }

    @Test
    public void invalidTest()
    {
        banking.PhoneNumber phoneNum1 = new banking.PhoneNumber(34, 2345);
        assertEquals(false, phoneNum1.isValid());
    }
    
    @Test
    public void tooLongTest()
    {
        banking.PhoneNumber phoneNum1 = new banking.PhoneNumber(34333, 23453333);
        assertEquals(false, phoneNum1.isValid());
    }
}






