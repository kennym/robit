package juegos.bitFlip;

import java.util.ArrayList;
import java.io.*;

/**
 * The Generator module
 *
 * Provides the necessary methods for generating the numbers for the game.
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 */
public class Generator {
    // La instancia del generador
    private static Generator _instance;

    private int step_number = 0; // Guarda información del número del paso
    private int final_number = 0; // El resultado.
    private int random_bit = 0;  // Bit aleatorio que es o 1 o 0.

	public int max_number = 100; // El numero máximo de numeros a generar.


	private void Generator() {

    }

    public static synchronized Generator getInstance() {
        if (_instance == null) {
            _instance = new Generator();
        }
        return _instance;
    }

    /**
     * No Clone Wars (TM) here, aye sir!? :-)
     *
     * Don't permit that our Singleton to be cloned elsewhere, so throw
     * a CloneNotSupportedException.
     * 
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

	/**
	 * Generate the numbers to be displayed on the screen.
	 *
	 * @return ArrayList
     * @author Kenny Meyer <knny.myer@gmail.com>
	 */
    public synchronized ArrayList generateNumbers() {

        ArrayList numbers = new ArrayList();
        for (int j = 1; j < this.max_number ; j++) {
            if (((j & 1 << this.step_number) <= 0) || (this.random_bit != 1)) {
                if (((j & 1 << this.step_number) != 0) || (this.random_bit == 1)) {
                    // Añadir 0 a nuestra lista y continuar con el próximo
                    // numero.
                    numbers.add(0);
                    continue;
                }
            }
            numbers.add(j);
        }
        // Be sure that there are not more than 99 in the array.
		if (numbers.size() > 99) throw new AssertionError();

        return numbers;
    }

    /**
     * Yes, the number is in the ArrayList.
     * 
     * This is the whole logic part.
     * 
     * Get the value of the random_bit, to know which numbers are being displayed,
     * and then by knowing this number you know that when random_bit equals
     * 1, the number is in the list shown.
     * Therefore add the power of 2 by the step_number to the final result.
     */
	public void yes() {
        // The same instruction, just less readable (in my humble opinion)
        //this.final_number += ((this.random_bit == 0) ? 1 << this.step_number : 0);
        if (this.random_bit == 1) {
            this.final_number += (1 << this.step_number);
        }
        incrementStep();
    }

    /**
     * No, the number is not in the list.
     * 
     * See the yes() method for documentation, because they're very similar.
     */
	public void no() {
        // The same instruction, just less readable (in my humble opinion)
        //this.final_number += ((this.random_bit == 0) ? 1 << this.step_number : 0);
		if (this.random_bit == 0) {
		    this.final_number += (1 << this.step_number);
        }
        incrementStep();
    }

    /**
     * Reset the generator.
     * 
     * Resetting the generator means:
     * <ul>
     *  <li>Setting the instance.final_number to 0</li>
     *  <li>Setting the instance.step_number to 0</li>
     *  <li>Generate a new random bit</li>
     * </ul>
     */
    public void reset() {
        setFinalNumber(0);
        setStep(0);
        genRandomBit();
    }

    /**
     * Set the private variable `step_number` to a specific value.
     *
     * @param n Set `step_number` to n.
     */
    public void setStep(int n) {
        this.step_number = n;
    }

    /**
     * Get the value of the private variable step_number.
     *
     * Obtener el valor de variable privada step_number.
     *
     * @return int
     */
    public int getStep() {
        return this.step_number;
    }

    /**
     * Increment `step_number` by one.
     *
     * Incrementar `step_number` por uno.
     */
    public void incrementStep() {
        this.step_number++;
    }

	/**
	 * Set the random_bit value to `n` of type `int`.
	 *
	 * Determinar el valor de random_bit con el valor de `n` de tipo `int` o
	 * entero.
	 *
	 * @param n
	 */
    public void setRandomBit(int n) {
        this.random_bit = n;
        // Si el bit aleatorio *no* es 1 o 0, tirar un AssertionError.
        if (this.random_bit < 0 || this.random_bit > 1)
            throw new AssertionError();
    }

	/**
	 * Get the value for `this.random_bit`.
	 *
	 * Obtener el valor de `this.random_bit`.
	 *
	 * @return int
	 */
    public int getRandomBit() {
        return this.random_bit;
    }

    /**
     * Randomly generate either 0 or 1 and set it to `this.random_bit`.
	 * `this.random_bit` needs to be either 0 or 1 because later it will
	 * influence the outcome of the generateNumbers() function.
	 *
	 * Generar aleatoriamente o 0 o 1 y asignar el valor `this.random_bit`.
	 * Es necesario que `this.random_bit` sea 0 o 1, porque influirá la salida
	 * de la función Generator.generateNumbers().
	 *
     */
    public void genRandomBit() {
        setRandomBit((int)(Math.random() * 2));
    }

    public int getFinalNumber() {
        return this.final_number;
    }

    public void setFinalNumber(int new_value) {
        this.final_number = new_value;
    }
}

/**
 * Test our fucking generator.
 * 
 * @author Kenny Meyer
 */
class Main {

	private static int iteration = 1;

	public static void prettyPrint(ArrayList array) {
		System.out.println("Iteration: " + iteration);
		for (int i=0; i < array.size(); i++) {
			if ( i % 10 == 0 ) {
				System.out.println();
			}
			System.out.print(array.get(i) + ",");
		}
		System.out.println();
		iteration++;
	}

	public static void testRun() {
        Generator testGen = Generator.getInstance();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input;
        for ( int i = 1; i < 7; i++ ) {
			input = null;
            prettyPrint(testGen.generateNumbers());
			System.out.println("Is your number on that list?");
			try {
				input = br.readLine();
				System.out.println("Input:" + input);
			} catch (IOException ioe) {
				System.exit(1);
			}
			if (input.startsWith("y")) {
				testGen.yes();
			}
			else {
				testGen.no();
			}
        }
        System.out.println(testGen.getFinalNumber());
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testRun();
    }
}
