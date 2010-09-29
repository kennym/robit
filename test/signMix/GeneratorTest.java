package signMix;

import juegos.signMix.Generator;

;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of generarNumero method, of class Generator.
     */
    @Test
    public void testGenerarNumero() {
        System.out.println("generarNumero");
        Generator instance = new Generator();
        String expResult = "";
        String result = instance.generarNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarProblema method, of class Generator.
     */
    @Test
    public void testGenerarProblema() {
        System.out.println("generarProblema");
        int nivel = 0;
        Generator instance = new Generator();
        ArrayList expResult = null;
        ArrayList result = instance.generarProblema(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Generator.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Generator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarNumero method, of class Generator.
     */
    @Test
    public void testGenerarNumero_0args() {
        System.out.println("generarNumero");
        Generator instance = new Generator();
        String expResult = "";
        String result = instance.generarNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarNumero method, of class Generator.
     */
    @Test
    public void testGenerarNumero_int() {
        System.out.println("generarNumero");
        int rango = 0;
        Generator instance = new Generator();
        String expResult = "";
        String result = instance.generarNumero(rango);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}