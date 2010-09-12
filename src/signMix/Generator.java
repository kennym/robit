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
     * TODO: Crear niveles.
     *
     * @return ArrayList
     */
    public ArrayList generador() {
        // Crear la lista de elementos.
        ArrayList<String> resultado = new ArrayList<String>();

        ArrayList<String> signos = new ArrayList<String>();
        signos.add("+");
        signos.add("-");

        // Crear un numero y añadirlo al Array
        resultado.add(generarNumero());
        // Crear un signo y añadirlo al Array
        int num = (int) (Math.random() * 2); // 0 o 1
        resultado.add(signos.get(num));
        // Crear otro numero
        resultado.add(generarNumero());
        // Hallar el resultado.
        int res = 0;
        if (resultado.get(1) == "+") {
            res = Integer.parseInt(resultado.get(0)) +
                  Integer.parseInt(resultado.get(2));
        } else {
            res = Integer.parseInt(resultado.get(0)) -
                  Integer.parseInt(resultado.get(2));
        }
        resultado.add(Integer.toString(res));


        return resultado;
    }

    public static void main(String[] args) {
        Generator generador = new Generator();
        System.out.println(generador.generador());
    }
}
