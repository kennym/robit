/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package juegos.signGuess;

import java.util.ArrayList;

/**
 * Generador de problemas aritméticas.
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 * @author Jorge Gimenez <jrg.gmnz@hotmail.com>
 */
public class Generator {

    // El nivel de los problemas
    private int nivel = 1;

    /**
     * El objeto enum que representa a un operador aritmética.
     *
     * La razón de crear un objeto que representa un operador es que no se puede
     * guardar expresiones matemáticas en arrays.  El generador *guardaba* un
     * vector de la siguiente forma: ["4", "+", "5", "9"].  Lo que intentamos
     * hacer es evaluar el signo aritmético, pero aparentemente no es posible
     * en Java.
     * Evaluar el signo nos guarda muchas líneas de código, para no escribir
     * bloques if - else monstruosos (ver commits ante
     * 3d23851589ea121ea3b5d51ce8a74fdbe3c4163d en nuestro repositorio Git)
     *
     * El objeto operador nos permite convertir el objeto a String para despues
     * convertirlo a un objeto otra vez para poder procesar el problema.
     * El ejemplo de uso es el siguiente:
     *
     *  calcular(Operador.ADDITION, 4, 7) -> 11
     *  calcular(Operador.SUBSTRACTION, 7, 4) -> 3
     *
     *   // Crear el vector para los signos aritméticos.
     *   ArrayList<String> signos = new ArrayList<String>();
     *   // Los signos que usamos
     *   signos.add("ADDITION"); // +
     *   signos.add("SUBSTRACTION");
     *
     * En teoría es posible usar otros operadores, también.
     */
    public enum Operador {
        ADDITION("+") {
            @Override
            public int apply(int x1, int x2) {
                return x1 + x2;
            }
        },
        SUBSTRACTION("-") {
            @Override
            public int apply(int x1, int x2) {
                return x1 - x2;
            }
        };

        private final String text;

        private Operador(String text) {
            this.text = text;
        }

        public abstract int apply(int x1, int x2);

        @Override 
        public String toString() {
            return text;
        }

    }

    public String calcular(Operador op, String x1, String x2) {
        return String.valueOf(op.apply(
                Integer.parseInt(x1),
                Integer.parseInt(x2)));
    }

    public String obtenerSigno(String op) {
        return String.valueOf(Operador.valueOf(op));
    }

    /**
     * Generar un numero aleatorio y retornarlo como objeto String.
     *
     * @return String
     */
    public String generarNumero() {
        int r = (int) ((Math.random() * 10) + 1);
        return Integer.toString(r);
    }

    /**
     * Generar un numero aleatorio dentro de un rango y retornarlo.
     *
     * @param rango
     * @return String
     */
    public String generarNumero(int rango) {
        int r = (int) ((Math.random() * rango) + 1);
        return Integer.toString(r);
    }

    /**
     * Genera un problema con operaciones aritmeticas, + y - .
     *
     * @param nivel
     *      Un número entero que indique el nivel del jugador.
     *      Rango: 1 - 4
     * @return ArrayList
     */
    public ArrayList generarProblema(int nivel) {
        // Crear el vector para los elementos.
        ArrayList<String> resultado = new ArrayList<String>();
        // Crear el vector para los signos
        ArrayList<String> signos = new ArrayList<String>();
        // Los signos que usamos
        signos.add("ADDITION"); // +
        signos.add("SUBSTRACTION"); // -

        // Crear un numero y añadirlo al Array
        resultado.add(generarNumero());

        if (nivel == 1) {
            // Añadir un signo aleatoriamente al vector resultado
            int op = (int) (Math.random() * 2); // 0 o 1
            resultado.add((signos.get(op)).toString()); // Indice 0

            // Crear otro numero
            resultado.add(generarNumero());
            // Hallar el resultado.
            Operador op1 = Operador.valueOf(resultado.get(1));

            String res = calcular(op1, resultado.get(0), resultado.get(2));
            resultado.add(res);
        /**
         * Nivel 2
         */
        } else if (nivel == 2) {
            // Obtener un signo aleatoriamente del vector signos
            int op = (int) (Math.random() * 2); // 0 o 1
            resultado.add((signos.get(op)).toString()); // Indice 0

            // Crear otro numero
            resultado.add(generarNumero());

            // Crear otro signo
            // Obtener un signo aleatoriamente del vector signos
            op = (int) (Math.random() * 2); // 0 o 1
            /* Convertir el enum Operador a String para poder guardarlo en el array */
            resultado.add((signos.get(op)).toString());

            // Obtener los operadores guaradados en el array "resultado"
            Operador op1 = Operador.valueOf(resultado.get(1));
            Operador op2 = Operador.valueOf(resultado.get(3));

            // Agregar otro numero
            resultado.add(generarNumero());


            // Hallar el resultado.
            // TODO: Document me
            String res = calcular(op2,
                    calcular(op1, resultado.get(0), resultado.get(2)),
                    resultado.get(4));

            resultado.add(res);
        /**
         * Nivel 3
         */
        } else if (nivel == 3) {
            // Obtener un signo aleatoriamente del vector signos
            int op = (int) (Math.random() * 2); // 0 o 1
            resultado.add((signos.get(op)).toString()); // Indice 0

            // Agregar otro numero
            resultado.add(generarNumero());

            // Crear otro signo
            op = (int) (Math.random() * 2); // 0 o 1
            resultado.add((signos.get(op)).toString()); // Indice 0

            // Agregar otro numero
            resultado.add(generarNumero());

            // Crear otro signo y añadirlo al resultado
            op = (int) (Math.random() * 2); // 0 o 1
            resultado.add((signos.get(op)).toString()); // Indice 0

            // Agregar otro numero
            resultado.add(generarNumero());

            // Obtener los operadores guaradados en el array "resultado"
            Operador op1 = Operador.valueOf(resultado.get(1));
            Operador op2 = Operador.valueOf(resultado.get(3));
            Operador op3 = Operador.valueOf(resultado.get(5));

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
            // ATENCIÓN: Magica -- No tocar!
            String res =
                    calcular(op3,
                        calcular(op2,
                            calcular(op1, resultado.get(0), resultado.get(2)),
                                resultado.get(4)),
                    resultado.get(6));

            resultado.add(res);
        }

        return resultado;
    }

    public static void main(String[] args) {
        Generator generador = new Generator();
        int nivel = 1;
        System.out.println(generador.generarProblema(nivel));
    }
}