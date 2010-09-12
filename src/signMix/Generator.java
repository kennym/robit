/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package signMix;

import java.util.ArrayList;

/**
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 * @author Jorge Gimenez <jrg.gmnz@hotmail.com>
 *
 */
public class Generator {

    int nivel = 1;

    private String generarNumero() {
        int r = (int) ((Math.random() * 10) + 1);
        String rt = Integer.toString(r);
        return rt;
    }

    /**
     * Genera un problema con operaciones aritmeticas, + y - .
     *
     * @param nivel
     *      Un número entero que indique el nivel del jugador.
     *      Rango: 1 - 4
     * @return ArrayList
     */
    public ArrayList generador(int nivel) {
        // Crear el vector para los elementos.
        ArrayList<String> resultado = new ArrayList<String>();
        // Crear el vector para los signos
        ArrayList<String> signos = new ArrayList<String>();
        // Los signos que usamos
        signos.add("+");
        signos.add("-");

        // Crear un numero y añadirlo al Array
        resultado.add(generarNumero());
        // Crear un signo y añadirlo al Array
        if (nivel == 1) {
            // Obtener un signo aleatoriamente del vector signos
            int num = (int) (Math.random() * 2); // 0 o 1
            resultado.add(signos.get(num)); // Indice 0

            // Crear otro numero
            resultado.add(generarNumero());
            // Hallar el resultado.
            int res = 0;
            if (resultado.get(1).equals("+")) {
                res = Integer.parseInt(resultado.get(0)) +
                      Integer.parseInt(resultado.get(2));
            } else {
                res = Integer.parseInt(resultado.get(0)) -
                      Integer.parseInt(resultado.get(2));
            }
            resultado.add(Integer.toString(res));
        } else if (nivel == 2) {
            // Obtener un signo aleatoriamente del vector signos
            int num = (int) (Math.random() * 2); // 0 o 1
            resultado.add(signos.get(num)); // Indice 0

            // Crear otro numero
            resultado.add(generarNumero());

            // Crear otro signo
            num = (int) (Math.random() * 2); // 0 o 1
            resultado.add(signos.get(num)); // Indice 0

            // Agregar otro numero
            resultado.add(generarNumero());

            // Hallar el resultado.
            int res = 0;
            if (resultado.get(1).equals("+") ) {
                if (resultado.get(3).equals("+")) {
                    // Añadir operacion con resultado[3] (que es signo) y resultado[4] 
                    res = Integer.parseInt(resultado.get(0)) +
                          Integer.parseInt(resultado.get(2)) +
                          Integer.parseInt(resultado.get(4));
                } else {
                    res = Integer.parseInt(resultado.get(0)) +
                          Integer.parseInt(resultado.get(2)) -
                          Integer.parseInt(resultado.get(4));
                }
            } else if (resultado.get(1).equals("-")) {
                if (resultado.get(3).equals("-")) {
                    res = Integer.parseInt(resultado.get(0)) -
                          Integer.parseInt(resultado.get(2)) -
                          Integer.parseInt(resultado.get(4));
                } else {
                    res = Integer.parseInt(resultado.get(0)) -
                          Integer.parseInt(resultado.get(2)) +
                          Integer.parseInt(resultado.get(4));
                }
            }
            resultado.add(Integer.toString(res));
        } else if (nivel == 3) {
            // Obtener un signo aleatoriamente del vector signos
            int num = (int) (Math.random() * 2); // 0 o 1
            resultado.add(signos.get(num)); // Indice 0

            // Agregar otro numero
            resultado.add(generarNumero());

            // Crear otro signo
            num = (int) (Math.random() * 2); // 0 o 1
            resultado.add(signos.get(num)); // Indice 0

            // Agregar otro numero
            resultado.add(generarNumero());

            // Crear otro signo y añadirlo al resultado
            num = (int) (Math.random() * 2); // 0 o 1
            resultado.add(signos.get(num)); // Indice 0

            // Agregar otro numero
            resultado.add(generarNumero());

            // Hallar el resultado.
            //
            // Combinaciones posibles:
            // + + +
            // + + -
            // + - -
            // + - +
            // - + -
            // - - +
            // - + +
            // - - -
            //
            int res = 0;
            // + + +
            if (resultado.get(1).equals("+") && 
                    resultado.get(3).equals("+") &&
                    resultado.get(5).equals("+")) {
                res = Integer.parseInt(resultado.get(0)) +
                      Integer.parseInt(resultado.get(2)) +
                      Integer.parseInt(resultado.get(4)) +
                      Integer.parseInt(resultado.get(6));
            // + + -
            } else if (resultado.get(1).equals("+") &&
                    resultado.get(3).equals("+") &&
                    resultado.get(5).equals("-")) {
                res = Integer.parseInt(resultado.get(0)) +
                      Integer.parseInt(resultado.get(2)) +
                      Integer.parseInt(resultado.get(4)) -
                      Integer.parseInt(resultado.get(6));
            // + - -
            } else if (resultado.get(1).equals("+") &&
                    resultado.get(3).equals("-") &&
                    resultado.get(5).equals("-")) {

                res = Integer.parseInt(resultado.get(0)) +
                      Integer.parseInt(resultado.get(2)) -
                      Integer.parseInt(resultado.get(4)) -
                      Integer.parseInt(resultado.get(6));
            // + - +
            } else if (resultado.get(1).equals("+") &&
                    resultado.get(3).equals("-") &&
                    resultado.get(5).equals("+")) {

                res = Integer.parseInt(resultado.get(0)) +
                      Integer.parseInt(resultado.get(2)) -
                      Integer.parseInt(resultado.get(4)) +
                      Integer.parseInt(resultado.get(6));
            // - + -
            } else if (resultado.get(1).equals("-") &&
                    resultado.get(3).equals("+") &&
                    resultado.get(5).equals("-")) {

                res = Integer.parseInt(resultado.get(0)) -
                      Integer.parseInt(resultado.get(2)) +
                      Integer.parseInt(resultado.get(4)) -
                      Integer.parseInt(resultado.get(6));
            // - - +
            } else if (resultado.get(1).equals("-") &&
                    resultado.get(3).equals("-") &&
                    resultado.get(5).equals("+")) {

                res = Integer.parseInt(resultado.get(0)) -
                      Integer.parseInt(resultado.get(2)) -
                      Integer.parseInt(resultado.get(4)) +
                      Integer.parseInt(resultado.get(6));
            // - + +
            } else if (resultado.get(1).equals("-") &&
                    resultado.get(3).equals("+") &&
                    resultado.get(5).equals("+")) {

                res = Integer.parseInt(resultado.get(0)) -
                      Integer.parseInt(resultado.get(2)) +
                      Integer.parseInt(resultado.get(4)) +
                      Integer.parseInt(resultado.get(6));
            // - - -
            } else if (resultado.get(1).equals("-") &&
                    resultado.get(3).equals("-") &&
                    resultado.get(5).equals("-")) {

                res = Integer.parseInt(resultado.get(0)) -
                      Integer.parseInt(resultado.get(2)) -
                      Integer.parseInt(resultado.get(4)) -
                      Integer.parseInt(resultado.get(6));
            }
            else {
                // DIABLOS! Esto no tiene que ocurrir!!!
                throw new AssertionError(
                        resultado.get(1) + "\n" +
                        resultado.get(3) + "\n" +
                        resultado.get(5) + "\n");
            }

            resultado.add(Integer.toString(res));
        }

        return resultado;
    }

    public static void main(String[] args) {
        Generator generador = new Generator();
        int nivel = 3;
        System.out.println(generador.generador(nivel));
    }
}