package game;

import javax.swing.JPanel;

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

    public AGLGamePanel(int width, int height, int FPS, AGLMethodRunner updateMethods, AGLMethodRunner drawMethods, Color colour) {

        this.width = width;
        this.height = height;
        this.FPS = FPS;
        this.updateMethods = updateMethods;
        this.drawMethods = drawMethods;
        this.colour = colour;

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


        this.drawMethods.runMethods();


        g2.dispose();

    }

}
