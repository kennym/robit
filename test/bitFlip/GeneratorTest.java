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
    public void testGenerateNumbers() {
        System.out.println("generateNumbers");
        Generator testFunc = new Generator();
        // Create an array for our numbers
        int[] expected = new int[50];
        ArrayList result   = new ArrayList();

        // Call our function and get the numbers stored in an array.
        result = testFunc.generateNumbers();
        expected = null;

        assertEquals(result, expected);
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
        System.out.println("yes");
        Generator instance = new Generator();
        instance.yes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of no method, of class Generator.
     */
    @Test
    public void testNo() {
        System.out.println("no");
        Generator instance = new Generator();
        instance.no();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class Generator.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Generator instance = new Generator();
        instance.reset();
        assertTrue(instance.getFinalNumber().contains("0"));
        assertTrue(instance.getStep() == 0);
    }

    /**
     * Test of getStep method, of class Generator.
     */
    @Test
    public void testGetStep() {
        System.out.println("getStep");
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
        System.out.println("setRandomBit");
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
        System.out.println("getRandomBit");
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
        System.out.println("genRandomBit");
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
        System.out.println("getFinalNumber");
        Generator instance = new Generator();
        String expResult = "0";
        String result = instance.getFinalNumber();
    }

    /**
     * Test of setFinalNumber method, of class Generator.
     */
    @Test
    public void testSetFinalNumber() {
        System.out.println("setFinalNumber");
        int new_value = 0;
        Generator instance = new Generator();
        instance.setFinalNumber(new_value);
        assertEquals(instance.getFinalNumber(), String.valueOf(new_value));
    }
}