/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lib;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Kenny Meyer <knny.myer@gmail.com>
 */
public class Sonido extends Thread {

    private String filename;
    private Position curPosition;
    private final int EXTERNAL_BUFFER_SIZE = 4096 * 128; // 128Kb

    enum Position {

        LEFT, RIGHT, NORMAL
    };

    public Sonido(String wavfile) {
        filename = wavfile;
        curPosition = Position.NORMAL;
    }

    public Sonido(String wavfile, Position p) {
        filename = wavfile;
        curPosition = p;
    }

    public String getFilePath(String filename) {
        URL url = getClass().getResource(filename);
        return url.toString();
    }

    public void run() {
        URL url = getClass().getResource(filename);

        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(url);
        } catch (UnsupportedAudioFileException e1) {
            e1.printStackTrace();
            return;
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }

        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

        try {
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    auline.write(abData, 0, nBytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            auline.drain();
            auline.close();
        }
    }

    public static void reproducirSonidoHover() {
        new Sonido("data/sounds/hover.wav").start();
    }

    public static void reproducirSonidoStartGame() {
        new Sonido("data/sounds/startgame.wav").start();
    }

    public static void reproducirSonidoPress() {
        new Sonido("data/sounds/press.wav").start();
    }

    public static void main(String[] args) {
        //new Sonido("/home/kenny/Programming/Java/Robit/src/lib/data/sounds/hover.wav").start();
        new Sonido("data/sounds/hover.wav").start();
    }
}
