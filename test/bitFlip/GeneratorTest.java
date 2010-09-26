/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitFlip;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 *
 * @author kenny
 */
public class GeneratorTest {

    public GeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of Generator method, of class Generator.
     */
    @Test
    public void testGenerator() {
        System.out.println("Generator");
        Generator instance = new Generator();
    }

    /**
     * Test of generateNumbers method, of class Generator.
     */
    @Test
    public void testGenerateNumbersStep0() {
        Generator instance = Generator.getInstance();
        // Create an array for our numbers
        ArrayList result    = instance.generateNumbers();
        ArrayList expected  = new ArrayList();
        
        // Call our function and get the numbers stored in an array.
        assertEquals(result, expected);
    }

    @Test
    public void testGuessNumbers() {
        Generator instance = Generator.getInstance();

        for (int j = 1; j < 100; j++) {
            for ( int i = 0; i < 7; i++) {
                ArrayList numbers = instance.generateNumbers();
                if ( numbers.contains(j)) {
                    instance.yes();
                } else {
                    instance.no();
                }
            }
            assertEquals(j, instance.getFinalNumber());
            instance.reset();
        }
    }

    /**
     * Test of setStep method, of class Generator.
     */
    @Test
    public void testSetStep() {
        Generator testFunc = new Generator();

        testFunc.setStep(12);
        int step_number = testFunc.getStep();

        assertEquals(step_number, 12);
    }

    @Test
    public void testSetInvalidStep() {
        Generator testFunc = new Generator();

        testFunc.setStep(12);
        testFunc.setStep(14);
        assertEquals(testFunc.getStep(), 14);
    }

    @Test
    public void testIncrementStep() {
        Generator testFunc = new Generator();

        testFunc.incrementStep();
        assertEquals(testFunc.getStep(), 1);
        testFunc.incrementStep();
        assertEquals(testFunc.getStep(), 2);
    }

    @Test
    public void testSetRandomBitValue() {
        // Generator.setRandomBit() should only accept 1 or 0, otherwise it
        // raises an AssertionError
        Generator testFunc = new Generator();

        // The valid input:
        testFunc.setRandomBit(0);
        assertEquals(testFunc.getRandomBit(), 0);
        testFunc.setRandomBit(1);
        assertEquals(testFunc.getRandomBit(), 1);
        // Invalid input:
        try {
            testFunc.setRandomBit(2);
            testFunc.setRandomBit(123);
            testFunc.setRandomBit(-1);
        } catch (AssertionError e) {
            /* Do nothing. This is the expected behavior. */
        }
    }

    @Test
    public void testGenerateRandomBit() {
        Generator testFunc = new Generator();

        for (int i = 0; i < 10; i++) {
            testFunc.genRandomBit();
            assertTrue((testFunc.getRandomBit() == 0) || (testFunc.getRandomBit() == 1));
        }
    }

    /**
     * Test of getInstance method, of class Generator.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Generator expResult = Generator.getInstance();
        Generator result = Generator.getInstance();
        // Comprobar que los dos objetos son los mismos, porque Generator
        // es un Singleton.
        assertTrue(expResult == result);
    }

    /**
     * Test of clone method, of class Generator.
     */
    @Test (expected=CloneNotSupportedException.class)
    public void testClone() throws Exception {
        Generator g = Generator.getInstance();
        g.clone();
    }

    /**
     * Test of yes method, of class Generator.
     */
    @Test
    public void testYes() {
        Generator instance = new Generator();

        instance.reset();
        // Set random bit to 1 by force
        instance.setRandomBit(1);
        int expected = 0;
        for (int i = 0; i < 7; i++) {
            // Sum the product of 1 << step_number to expected.
            // That is what the yes() method in the generator does.
            expected += (1 << i);
            instance.yes();
            int result = instance.getFinalNumber();
            assertEquals(expected, result);
            // And do that i times.
        }
        System.out.println(instance.getFinalNumber());

        // IMPORTANT: Reset the generator.
        instance.reset();
        instance.setRandomBit(0);
        expected = 0;
        for (int i = 0; i < 7; i++) {
            instance.yes();
            System.out.println(i);
            int result = instance.getFinalNumber();
            // The expected result is always 0.
            assertEquals(expected, result);
        }
    }

    /**
     * Test of no method, of class Generator.
     */
    @Test
    public void testNo() {
        Generator instance = new Generator();

        instance.reset();
        // Set random bit to 1 by force
        instance.setRandomBit(0);
        int expected = 0;
        for (int i = 0; i < 7; i++) {
            // Sum the product of 1 << step_number to `expected`.
            // That is what the no() method in the generator does.
            expected += (1 << i);
            instance.no();
            int result = instance.getFinalNumber();
            assertEquals(expected, result);
            // And do that i times.
        }
        System.out.println(instance.getFinalNumber());


        // IMPORTANT: Reset the generator.
        instance.reset();
        instance.setRandomBit(1);
        expected = 0;
        for (int i = 0; i < 7; i++) {
            instance.no();
            System.out.println(i);
            int result = instance.getFinalNumber();
            // The expected result is always 0.
            assertEquals(expected, result);
        }
    }

    /**
     * Test of reset method, of class Generator.
     */
    @Test
    public void testReset() {
        Generator instance = new Generator();
        instance.reset();
        assertEquals(instance.getFinalNumber(), 0);
        assertTrue(instance.getStep() == 0);
    }

    /**
     * Test of getStep method, of class Generator.
     */
    @Test
    public void testGetStep() {
        Generator instance = new Generator();
        int expResult = 0;
        int result = instance.getStep();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRandomBit method, of class Generator.
     * 
     * Give the method an invalid value.
     * 
     * An invalid value is anything which is not an integer either 0 or 1.
     */
    @Test (expected=AssertionError.class)
    public void testSetRandomBit() throws Exception {
        // El valor inválido...
        int n = -1;
        Generator instance = new Generator();
        instance.setRandomBit(n);
        
        n = 10;
        instance.setRandomBit(n);
    }

    /**
     * Test of getRandomBit method, of class Generator.
     */
    @Test
    public void testGetRandomBit() {
        Generator instance = new Generator();
        int expResult = 0;
        int result = instance.getRandomBit();
        assertEquals(expResult, result);
        
        expResult = 1;
        instance.setRandomBit(1);
        result = instance.getRandomBit();
        assertEquals(expResult, result);
    }

    /**
     * Test of genRandomBit method, of class Generator.
     */
    @Test
    public void testGenRandomBit() {
        Generator instance = new Generator();
        for (int i = 0; i < 10; i++) {
            instance.genRandomBit();
            assertTrue(instance.getRandomBit() == 0 || instance.getRandomBit() == 1);
        }
    }

    /**
     * Test of getFinalNumber method, of class Generator.
     */
    @Test
    public void testGetFinalNumber() {
        Generator instance = new Generator();
        int expResult = 0;
        int result = instance.getFinalNumber();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setFinalNumber method, of class Generator.
     */
    @Test
    public void testSetFinalNumber() {
        int new_value = 0;
        Generator instance = new Generator();
        instance.setFinalNumber(new_value);
        assertEquals(instance.getFinalNumber(), new_value);
    }
}