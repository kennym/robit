package signMix;

import java.awt.*;
import javax.swing.*;

public class Felicidades extends JPanel {
    public void paintComponent(Graphics g) {
        Dimension tamanio = getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("logo.png"));
        g.drawImage(fondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Felicidades feliz = new Felicidades();
        frame.add(feliz);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

}
