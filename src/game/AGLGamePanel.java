package game;

import javax.swing.JPanel;

import image.AGLImage;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import methodRunner.AGLMethodRunner;

public class AGLGamePanel extends JPanel implements Runnable {
 
    Thread gameThread;
    public int width;
    public int height;
    public int FPS;
    public Color colour;
    public AGLMethodRunner updateMethods;
    public AGLMethodRunner drawMethods;
    private AGLWindow window;

    public AGLGamePanel(int width, int height, int FPS, AGLMethodRunner updateMethods, Color colour, AGLWindow window) {

        this.width = width;
        this.height = height;
        this.FPS = FPS;
        this.updateMethods = updateMethods;
        this.colour = colour;
        this.window = window;

        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setBackground(this.colour);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }



    public void startGameThread() {

        this.gameThread = new Thread(this);
        this.gameThread.start();

    }



    @Override
    public void run() {

        //* Main game loop

        double drawInterval = 1000000000 / this.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (this.gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // UPDATE
                this.updateMethods.runMethods();

                // DRAW
                //? Uses built-in method to call the other overridden methods
                repaint();

                delta--;

            }

        }

    }



    //? Default method overridden
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        for (AGLImage image : this.window.drawImageOrder) {

            int[] data = this.window.drawImagePos.get(this.window.drawImageOrder.indexOf(image));

            g2.drawImage(image.getBufferedImage(), data[0], data[1], data[2], data[3], null);

        }


        g2.dispose();

    }

}
