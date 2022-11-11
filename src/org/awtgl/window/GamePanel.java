package org.awtgl.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;

    private int width;
    private int height;
    private int fps;
    private GameUpdater gameUpdater;
    private Renderer renderer;

    public GamePanel(int width, int height, int fps, GameUpdater gameUpdater, Renderer renderer) {

        this.width = width;
        this.height = height;
        this.fps = fps;
        this.gameUpdater = gameUpdater;
        this.renderer = renderer;

        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }



    public void startgameThread() {

        this.gameThread = new Thread(this);
        this.gameThread.start();

    }



    @Override
    public void run() {

        //* Main game loop

        double drawInterval = 1000000000 / this.fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (this.gameThread != null && this.gameUpdater != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // UPDATE
                this.gameUpdater.update();

                // DRAW
                //? Uses built-in method to call the other overridden methods
                this.repaint();

                delta--;

            }

        }

    }



    //? Default method overridden
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        this.renderer.supplyGraphics(g);

    }

}
