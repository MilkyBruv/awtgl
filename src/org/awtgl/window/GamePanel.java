package org.awtgl.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;

    private int width;
    private int height;
    private int fps;
    private Window mainWindow;
    private Updater gameUpdater;

    public int gameWidth;
    public int gameHeight;
    public int tiledWidth;
    public int tiledHeight;

    public Image mainDisplay;

    public GamePanel(int width, int height, int fps, Updater gameUpdater, Window mainWindow) {

        this.width = width;
        this.height = height;
        this.fps = fps;
        this.mainWindow = mainWindow;
        this.gameUpdater = gameUpdater;
        this.mainDisplay = new Image(this.width, this.height);

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

        if (this.mainWindow.gameSettings.scale != 0) {

            int preWidth = this.mainWindow.getContentPane().getWidth();
            int preHeight = this.mainWindow.getContentPane().getHeight();
            int newWidth = (preWidth / this.mainWindow.gameSettings.fullTilsize) * this.mainWindow.gameSettings.fullTilsize;
            int newHeight = (preHeight / this.mainWindow.gameSettings.fullTilsize) * this.mainWindow.gameSettings.fullTilsize;

            if (newWidth <= 1) {

                newWidth = 10;

            } if (newHeight <= 1) {

                newHeight = 10;

            }
            
            this.setBackground(Color.BLUE);
            this.setSize(newWidth, newHeight);
            this.setLocation((this.mainWindow.getContentPane().getWidth() / 2) - (this.getWidth() / 2), (this.mainWindow.getContentPane().getHeight() / 2) - (this.getHeight() / 2));
            
            this.gameWidth = this.getWidth();
            this.gameHeight = this.getHeight();
            this.tiledWidth = newWidth / this.mainWindow.gameSettings.fullTilsize;
            this.tiledHeight = newHeight / this.mainWindow.gameSettings.fullTilsize;
    
            this.mainWindow.setTitle("" + newWidth + ", " + newHeight + " | " + this.mainWindow.getContentPane().getWidth() + ", " + this.mainWindow.getContentPane().getHeight() + " | " + newWidth / this.mainWindow.gameSettings.fullTilsize + ", " + newHeight / this.mainWindow.gameSettings.fullTilsize + " | " + this.getWidth() + ", " + this.getHeight());
    
        }

        this.gameUpdater.update();
        
        this.mainDisplay = new Image(this.getWidth(), this.getHeight());

    }



    //? Default method overridden
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        try {

            BufferedImage testImage = ImageIO.read(new File(System.getProperty("user.dir") + "/src/res/i.png"));

            for (int x = 0; x < this.tiledWidth; x++) {
                
                for (int y = 0; y < this.tiledHeight; y++) {
                    
                    g2d.drawImage(testImage, x * this.mainWindow.gameSettings.fullTilsize, y * this.mainWindow.gameSettings.fullTilsize, this.mainWindow.gameSettings.fullTilsize, this.mainWindow.gameSettings.fullTilsize, null);

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        g2d.dispose();
        
    }

}
