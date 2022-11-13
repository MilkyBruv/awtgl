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
    private Window mainWindow;

    public int gameWidth;
    public int gameHeight;
    public int tiledWidth;
    public int tiledHeight;

    public GamePanel(int width, int height, int fps, Window mainWindow) {

        this.width = width;
        this.height = height;
        this.fps = fps;
        this.mainWindow = mainWindow;

        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setBackground(new Color(255, 0, 0));
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

        while (this.gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // UPDATE
                this.update();

                // DRAW
                //? Uses built-in method to call the other overridden methods
                this.repaint();

                delta--;

            }

        }

    }



    public void update() {

        int preWidth = this.mainWindow.getContentPane().getWidth();
        int preHeight = this.mainWindow.getContentPane().getHeight();
        int newWidth = (preWidth / this.mainWindow.gameSettings.fullTilsize) * this.mainWindow.gameSettings.fullTilsize;
        int newHeight = (preHeight / this.mainWindow.gameSettings.fullTilsize) * this.mainWindow.gameSettings.fullTilsize;
        
        this.setBackground(Color.RED);
        this.setSize(newWidth, newHeight);
        this.setLocation((this.mainWindow.getContentPane().getWidth() / 2) - (this.getWidth() / 2), (this.mainWindow.getContentPane().getHeight() / 2) - (this.getHeight() / 2));
        
        this.gameWidth = this.getWidth();
        this.gameHeight = this.getHeight();
        this.tiledWidth = newWidth / this.mainWindow.gameSettings.fullTilsize;
        this.tiledHeight = newHeight / this.mainWindow.gameSettings.fullTilsize;

        this.mainWindow.setTitle("" + newWidth + ", " + newHeight + " | " + this.mainWindow.getContentPane().getWidth() + ", " + this.mainWindow.getContentPane().getHeight() + " | " + newWidth / this.mainWindow.gameSettings.fullTilsize + ", " + newHeight / this.mainWindow.gameSettings.fullTilsize + " | " + this.getWidth() + ", " + this.getHeight());

    }



    //? Default method overridden
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
    }

}
