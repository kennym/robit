package bitFlip;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * The Canvas on which the numbers are drawn.
 */
public class GameCanvas extends Canvas {
    // The grid of the numbers.
    private Generator generator = new Generator();

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

    public void paint(Graphics g) {
        Dimension localDimension = super.getSize();
        // Clean up the old stuff
        g.clearRect(0, 0, getWidth(), getHeight());

        g.drawRect(0, 0,
                localDimension.width - 1,
                localDimension.height - 1);

        int m_w = ((localDimension.width - 2 * 10) / 10);
        int m_h = ((localDimension.width - 2 * 10) / 10);

        // Generate either 1 or 0 randomly
        int m_Bit = (int)(Math.random() * 2.0D);
        // Loop the numbers from 1 to 99
        for (int j = 1; j < 99; ++j)
        {
            if (((j & 1 << this.generator.getStep()) <= 0) || (m_Bit != 1))
            {
                if ((j & 1 << this.generator.getStep()) != 0)
                {
                    // Skip the current loop.
                    // This means that the number will not be listed.
                    continue;
                }
                if (m_Bit != 0)
                {
                    // Skip the current loop.
                    // This means that the number will not be listed.
                    continue;
                }
            }
            // Calculate the coordinates of the graph.
            int k = j % 10;
            int l = j / 10;
            // The number to show.
            String str = "" + j;
            g.drawString(str,
                    k * m_w + (m_w - 20) / 2,
                    l * m_h + (m_h + 10) / 2);
        }
    }
}