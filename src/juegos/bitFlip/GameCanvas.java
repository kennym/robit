package juegos.bitFlip;

import lib.Picture;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

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
    private static Font F_Grande = new Font("Arial", Font.BOLD, 60);
    private static Font F_Numero = new Font("Sans", Font.BOLD, 18);

    private FontMetrics fm;

    /**
     * Initializer of NumberBoard
     */
    public GameCanvas() {
        // Set the size and the background color
    }

    /**
     * Volver al estado incial.
     */
    public void resetearEstado() {
        this.estado_inicio = true;
    }

    /**
     * Modificar valor de <i>estado_incio</i>
     * @param estado
     */
    public void setEstadoIncio(boolean estado) {
        this.estado_inicio = estado;
    }

    /**
     * Mostrar el diálogo incial del juego.
     *
     * @param g
     */
    public void mostrarPantallaInicial(Graphics g) {
        // Dibujar Robit.
        Image image = new Picture("data/robit/bitFlipInstrucciones.png").getImage();

        g.drawImage(image,
            (dimensionLocal.width - image.getWidth(null)) / 2,
            dimensionLocal.height - image.getHeight(null),
            this);
    }

    /**
     * Mostrar el número final.
     * 
     * @param g
     */
    public void mostrarNumeroFinal(Graphics g2) {
        Graphics2D g = (Graphics2D)(g2);
        
        String numero  = String.valueOf(generador.getFinalNumber());

        Image image1 = new Picture("data/robit/bitFlipResultado.png").getImage();
        Image image2 = new Picture("data/robit/bitFlipCabeza.png").getImage();

        g.setFont(F_Grande);
        g.drawImage(image1,
            (dimensionLocal.width - image1.getWidth(null)) / 2,
            (dimensionLocal.height / 2) + fm.getAscent() - 50 ,
            this);
        g.drawImage(image2,
            (dimensionLocal.width - image2.getWidth(null)) / 2,
            (dimensionLocal.height / 2) + fm.getAscent() - 200 ,
            this);

        g.drawString(numero,
                dimensionLocal.width / 2 - fm.stringWidth(numero),
                // Un 50 px más debajo del centro del canvas menos la altura
                // de la fuente, porque en el centro se encuentra el mensaje
                // anterior.
                (dimensionLocal.height / 2) + fm.getAscent() + 50);
    }

    public void _determinarColorDeFondo(Graphics g) {
        // LATTE MACCHIATO:
        // Mostrar colores inversos de acuerdo al paso
        // Si estamos en el primer, tercero, quinto paso mostrar un
        // canvas negro con letra blanca.
        // Sino, mostrar un canvas blanco con letra negra.
        if ((generador.getStep() % 2 == 0) && (generador.getStep() < 6)) {
            setBackground(Color.BLACK);
            g.setColor(Color.white);
        } else {
            setBackground(Color.WHITE);
            g.setColor(Color.black);
        }
    }

    @Override
    public void paint(Graphics g) {
        this.dimensionLocal = getSize();
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        fm = g.getFontMetrics();

        _determinarColorDeFondo(g);

        if (this.estado_inicio == true) {
            mostrarPantallaInicial(g);
        } else if (generador.getStep() > 6) {
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
                        20 + height * y + (height) / 2);
            }
        }
    }
}
