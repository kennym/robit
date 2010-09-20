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
        assertEquals(testFunc.getStep(), 2);
        testFunc.incrementStep();
        assertEquals(testFunc.getStep(), 3);
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
}