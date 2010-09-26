package bitFlip;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;

/**
 * El Canvas por el cual se dibuja los numeros.
 */
public class GameCanvas extends Canvas {
    // El generador
    private Generator generador = Generator.getInstance();

    private boolean estado_inicio = true;

    private Dimension dimensionLocal;

    // Las fuentes del Canvas
    private static Font F_Descripcion = new Font("SansSerif", Font.BOLD, 15);
    private static Font F_Grande = new Font("Arial", Font.BOLD, 60);
    private static Font F_Texto = new Font("SansSerif", Font.PLAIN, 15);
    private static Font F_Numero = new Font("Sans", Font.BOLD, 14);

    /**
     * Initializer of NumberBoard
     */
    public GameCanvas() {
        // Set the size and the background color
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

//    public void repaint(Graphics g) {
//        paint(g);
//    }

    /**
     * Mostrar el diálogo incial del juego.
     *
     * @param g
     */
    public void mostrarPantallaInicial(Graphics2D g) {
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
    public void mostrarNumeroFinal(Graphics g2) {
        Graphics2D g = (Graphics2D)(g2);
        FontMetrics fm = g.getFontMetrics();
        
        String mensaje = "Tu número imaginario fué: ";
        String numero  = String.valueOf(generador.getFinalNumber());

        g.setFont(F_Texto);
        g.drawString(mensaje,
                // Desplegar el mensaje en el centro.
                // (Anchura - mensaje) / 2
                (dimensionLocal.width - fm.stringWidth(mensaje)) / 2,
                dimensionLocal.height / 2);
        g.setFont(F_Grande);
        g.drawString(numero,
                (dimensionLocal.width - fm.stringWidth(numero)) / 2,
                // Un 50 px más debajo del centro del canvas menos la altura
                // de la fuente, porque en el centro se encuentra el mensaje
                // anterior.
                (dimensionLocal.height / 2) + fm.getAscent() + 50);
    }

    @Override
    public void paint(Graphics g) {
        this.dimensionLocal = super.getSize();
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

//        if (this.estado_inicio) {
//            mostrarPantallaInicial(g);
        if (generador.getStep() > 5) {
           mostrarNumeroFinal(g);
        } else {
            // Determinar la fuente de la letra que se va a dibujar en el Canvas
            g.setFont(F_Numero);
            FontMetrics fm = g.getFontMetrics();

            // Generar una nueva serie de numeros.
            ArrayList numeros = generador.generateNumbers();

            int width = ((dimensionLocal.width - 2 * 10) / 10);
            int height = ((dimensionLocal.height - 2 * 10) / 10);

            // NO TOCAR! MAGIA!
            for ( int i = 0; i < numeros.size(); i++ ) {
                int x = i % 10;
                int y = i / 10;

                String num = "";
                if ( ! ( String.valueOf(numeros.get(i)).startsWith("0") ) ) {
                    num = String.valueOf(numeros.get(i));
                }

                g.drawString(
                        // El número de tipo String, también puede ser un String
                        // vacío.
                        num,
                        // Determinar la posición de cada número.
                        // El valor 10 se usa para que los numeros parezcan más
                        // centrados. Hay que encontrar una solución mejor.
                        10 + width  * x + (width  - fm.stringWidth(num)) / 2,
                        10 + height * y + (height) / 2);
            }
        }
    }
}