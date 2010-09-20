package bitFlip;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.util.ArrayList;

/**
 * El Canvas por el cual se dibuja los numeros.
 */
public class GameCanvas extends Canvas {
    // El generador
    private Generator generador = Generator.getInstance();

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

    @Override
    public void paint(Graphics g) {
        Dimension dimensionLocal = super.getSize();

        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);


        ArrayList numeros = generador.generateNumbers();

        int width = ((dimensionLocal.width - 2 * 10) / 10);
        int height = ((dimensionLocal.height - 2 * 10) / 10);

        // NO TOCAR! MAGIA!
        System.out.println(numeros.size());
        for ( int i = 0; i < numeros.size(); i++) {
            int x = i % 10;
            int y = i / 10;

            String num = "";
            if (!(String.valueOf(numeros.get(i)).startsWith("0"))) {
                num = String.valueOf(numeros.get(i));
            }

            g.drawString(
                    num,
                    width  * x + (width  - 20) / 2,
                    height * y + (height + 10) / 2);
        }
    }
}