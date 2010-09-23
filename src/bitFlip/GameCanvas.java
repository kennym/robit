package bitFlip;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import java.util.ArrayList;

/**
 * El Canvas por el cual se dibuja los numeros.
 */
public class GameCanvas extends Canvas {
    // El generador
    private Generator generador = Generator.getInstance();

    private boolean estado_inicio = true;

    private Dimension dimensionLocal;

    /**
     * Initializer of NumberBoard
     */
    public GameCanvas() {
        // Set the size and the background color
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

    public void repaint(Graphics g) {
        paint(g);
    }

    /**
     * Mostrar el diálogo incial del juego.
     *
     * @param g
     */
    public void mostrarPantallaInicial(Graphics g) {
        // Dibujar Robit.
        g.drawString("Welcome!",
                dimensionLocal.width / 2,
                dimensionLocal.height / 2);
        this.estado_inicio = false;
    }

    /**
     * Mostrar el número final.
     * 
     * @param g
     */
    public void mostrarNumeroFinal(Graphics g) {
        g.drawString("Tu número en cual pensaste fue: " + generador.getFinalNumber(),
                dimensionLocal.width / 2,
                dimensionLocal.height / 2);
    }

    @Override
    public void paint(Graphics g) {
        this.dimensionLocal = super.getSize();
//        if (this.estado_inicio) {
//            mostrarPantallaInicial(g);
//        } else if (generador.getStep() > 5) {
//            mostrarNumeroFinal(g);
//        } else {
//            g.clearRect(0, 0, getWidth(), getHeight());
//            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

            // Determinar la fuente de la letra que se va a dibujar en el Canvas
            g.setFont(new Font("SansSerif", Font.BOLD, 12));
            FontMetrics fm = g.getFontMetrics();

//            // Generar una nueva serie de numeros.
            ArrayList numeros = generador.generateNumbers();

            int width = ((dimensionLocal.width - 2 * 10) / 10);
            int height = ((dimensionLocal.height - 2 * 10) / 10);

            // NO TOCAR! MAGIA!
            for ( int i = 0; i < numeros.size(); i++) {
                int x = i % 10;
                int y = i / 10;

                String num = "";
                if ( ! ( String.valueOf(numeros.get(i)).startsWith("0") ) ) {
                    num = String.valueOf(numeros.get(i));
                }

                g.drawString(
                        // El número de tipo String.
                        num,
                        // Determinar la posición de cada número.
                        // El valor 10 se usa para que los numeros parezcan más
                        // centrados. Hay que encontrar una solución mejor.
                        10 + width  * x + (width  - fm.stringWidth(num)) / 2,
                        10 + height * y + (height) / 2);
//            }
        }
    }
}