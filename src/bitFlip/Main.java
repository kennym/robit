/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bitFlip;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 */
public class Main {

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
