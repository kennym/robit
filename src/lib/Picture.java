package lib;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * This class provides methods for manipulating individual pixels of
 * an image. The original image can be read from a file in JPEG, GIF,
 * or PNG format, or the user can create a blank image of a given size.
 * This class includes methods for displaying the image in a window on
 * the screen or saving to a file.
 * <p>
 * By default, pixel (x, y) is column x, row y, where (0, 0) is upper left.
 * The method setOriginLowerLeft() change the origin to the lower left.
 * <p>
 * For additional documentation, see
 * <a href="http://www.cs.princeton.edu/introcs/31datatype">Section 3.1</a> of
 * <i>Introduction to Programming in Java: An Interdisciplinary Approach</i>
 * by Robert Sedgewick and Kevin Wayne.
 */
public final class Picture {

    private BufferedImageOp op;
    private BufferedImage image; // the rasterized image
    private JFrame frame; // on-screen view
    private String filename; // name of file
    private boolean isOriginUpperLeft = true; // location of origin
    private int width, height; // width and height

    /**
     * Create a blank w-by-h picture, where each pixel is black.
     */
    public Picture(int w, int h) {
        width = w;
        height = h;
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
// set to TYPE_INT_ARGB to support transparency
        filename = w + "-by-" + h;
    }

    /**
     * Create a picture by reading in a .png, .gif, or .jpg from
     * the given filename or URL name.
     */
    public Picture(String filename) {
        this.filename = filename;
        // try to read from file in working directory
        try {
            File file = new File(filename);
            if (file.isFile()) {
                image = ImageIO.read(file);
            } else {
            // Hmm, the image is not in the working directory. Get the full path.
                URL url = getClass().getResource(filename);
                if (url == null) {
                    url = new URL(filename);
                }
                image = ImageIO.read(url);
            }
            width = image.getWidth(null);
            height = image.getWidth(null);
        } catch (IOException e) {
            throw new RuntimeException("Could not open file: " + filename);
        }

        // check that image was read in
        if (image == null) {
            throw new RuntimeException("Invalid image file: " + filename);
        }
    }

    /**
     * Create a picture by reading in a .png, .gif, or .jpg from a File.
     */
    public Picture(File file) {
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not open file: " + file);
        }
        if (image == null) {
            throw new RuntimeException("Invalid image file: " + file);
        }
    }

    /**
     * Return a JLabel containing this Picture, for embedding in a JPanel,
     * JFrame or other GUI widget.
     */
    public JLabel getJLabel() {
        if (image == null) {
            return null;
        } // no image available
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }

    public Image getImage() {
        if (image == null) {
            return null;
        }
        return image;
    }

    /**
     * Set the origin to be the upper left pixel.
     */
    public void setOriginUpperLeft() {
        isOriginUpperLeft = true;
    }

    /**
     * Set the origin to be the lower left pixel.
     */
    public void setOriginLowerLeft() {
        isOriginUpperLeft = false;
    }

    /**
     * Return the height of the picture in pixels.
     */
    public int height() {
        return height;
    }

    /**
     * Return the width of the picture in pixels.
     */
    public int width() {
        return width;
    }

    /**
     * Return the color of pixel (i, j).
     */
    public Color get(int i, int j) {
        if (isOriginUpperLeft) {
            return new Color(image.getRGB(i, j));
        } else {
            return new Color(image.getRGB(i, height - j - 1));
        }
    }

    /**
     * Set the color of pixel (i, j) to c.
     */
    public void set(int i, int j, Color c) {
        if (c == null) {
            throw new RuntimeException("can't set Color to null");
        }
        if (isOriginUpperLeft) {
            image.setRGB(i, j, c.getRGB());
        } else {
            image.setRGB(i, height - j - 1, c.getRGB());
        }
    }

    /**
     * Save the picture to a file in a standard image format.
     * The filetype must be .png or .jpg.
     */
    public void save(String name) {
        save(new File(name));
    }

    /**
     * Save the picture to a file in a standard image format.
     */
    public void save(File file) {
        this.filename = file.getName();
        if (frame != null) {
            frame.setTitle(filename);
        }
        String suffix = filename.substring(filename.lastIndexOf('.') + 1);
        suffix = suffix.toLowerCase();
        if (suffix.equals("jpg") || suffix.equals("png")) {
            try {
                ImageIO.write(image, suffix, file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: filename must end in .jpg or .png");
        }
    }
}
