package org.awtgl.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;

    private int width;
    private int height;
    private int fps;
    private Window mainWindow;
    private Updater gameUpdater;

    private int displayWidth;
    private int displayHeight;
    private int displayX;
    private int displayY;

    private int prevWidth = 0;
    private int prevHeight = 0;

    public Image mainDisplay;

    public GamePanel(int width, int height, int fps, Updater gameUpdater, Window mainWindow) {

        this.width = width;
        this.height = height;
        this.fps = fps;
        this.mainWindow = mainWindow;
        this.gameUpdater = gameUpdater;
        this.mainDisplay = new Image(this.mainWindow.gameSettings.width, this.mainWindow.gameSettings.height);
        this.displayWidth = 0;
        this.displayHeight = 0;
        this.displayX = 0;
        this.displayY = 0;

        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setBackground(new Color(0, 0, 255));
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

        if (this.mainWindow.mode == Window.SCALE_INNER_DISPLAY)
        {

            if (this.mainWindow.getContentPane().getWidth() != this.prevWidth && this.mainWindow.getContentPane().getHeight() != this.prevHeight) {

                int bWidth = this.mainWindow.gameSettings.width;
                int bHeight = this.mainWindow.gameSettings.height;

                int mWidth = this.mainWindow.getWidth();
                int mHeight = this.mainWindow.getHeight();
                
                // scale inner display to max fit window
                float scale = Math.min(mWidth / bWidth, mHeight / bHeight);

                this.displayWidth = Math.round(bWidth * scale);
                this.displayHeight = Math.round(bHeight * scale);

                this.displayX = (this.mainWindow.getContentPane().getWidth() / 2) - (this.displayWidth / 2);
                this.displayY = (this.mainWindow.getContentPane().getHeight() / 2) - (this.displayHeight / 2);

                this.prevWidth = mWidth;
                this.prevHeight = mHeight;

                this.mainWindow.setTitle("b: " + bWidth + ", " + bHeight + "  |  " + "m: " + mWidth + ", " + mHeight + "  |  " + "s: " + scale);

            }

        }

        if (this.mainWindow.mode == Window.FIT_INNER_DISPLAY)
        {

            this.displayWidth = this.getWidth();
            this.displayHeight = this.getHeight();

            this.displayX = 0;
            this.displayY = 0;

        }

        this.gameUpdater.update();

    }



    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Graphics2D mdg2d = (Graphics2D) this.mainDisplay.getBufferedImage().getGraphics();
        mdg2d.setColor(new Color(0, 0, 0));
        mdg2d.fillRect(0, 0, this.mainDisplay.getBufferedImage().getWidth(), this.mainDisplay.getBufferedImage().getHeight());

        this.gameUpdater.draw(this.mainDisplay);

        g2d.drawImage(this.mainDisplay.getBufferedImage(), this.displayX, this.displayY, this.displayWidth, this.displayHeight, null);
        g2d.dispose();
        
    }

}
