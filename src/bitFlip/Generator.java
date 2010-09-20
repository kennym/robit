package bitFlip;

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
    private static Generator _instance;

	public int max_number = 100; // El numero máximo de numeros a generar.

    private int final_number = 0; // El resultado.
    private int random_bit;  // Bit aleatorio que es o 1 o 0.
    private int step_number = 1; // Guarda información del número del paso

	/**
	 * El constructor de la clase `Generator`.
	 */
	private void Generator() {
        // Generate a random bit
        genRandomBit();
        System.out.println(getRandomBit());
    }

    public static synchronized Generator getInstance() {
        if (_instance == null) {
            _instance = new Generator();
        }
        return _instance;
    }

    /**
     * No hay clonaje aquí!!! Entendido?!
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

	/**
	 * Generate the numbers.
	 *
	 * TODO: Document this method.
	 *
	 * @return ArrayList
	 */
    public ArrayList generateNumbers() {
        ArrayList numbers = new ArrayList();
        for (int j = 1; j < this.max_number ; j++){
            if (((j & 1 << this.step_number) <= 0) || (this.random_bit != 1)) {
                if ((j & 1 << this.step_number) != 0) {
					// Añadir 0 a nuestra lista y continuar con el próximo
					// numero.
					numbers.add(0);
					continue;
				}
                else if (this.random_bit != 0) {
					// Añadir 0 a nuestra lista y continuar con el próximo
					// numero.
					numbers.add(0);
					continue;
				}
            }
            numbers.add(j);
        }
		if (numbers.size() > 99) throw new AssertionError();
        return numbers;
    }

	/**
	 * Gets called once the imaginary number is in the ArrayList of the
	 * `Generator.generateNumbers` method.
	 */
	public void yes() {
        if (this.random_bit == 1)
            this.final_number += (1 << this.step_number);

        if (this.step_number + 1 > 6)
            System.out.println(this.final_number);
    }

	/**
	 *
	 */
	public void no() {
		if (this.random_bit == 0)
		    this.final_number += (1 << this.step_number);

		if (this.step_number + 1 > 6)
			System.out.println(this.final_number);
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
}

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
        Generator testGen = new Generator();

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
			testGen.incrementStep();
        }
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testRun();
    }
}
