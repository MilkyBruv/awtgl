package window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;

    private int width;
    private int height;
    private int fps;
    private GameUpdater gameUpdater;

    public GamePanel(int width, int height, int fps, GameUpdater gameUpdater) {

        this.width = width;
        this.height = height;
        this.fps = fps;
        this.gameUpdater = gameUpdater;

        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }



    public void startgameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }



    @Override
    public void run() {

        //* Main game loop

        double drawInterval = 1000000000 / this.fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null && this.gameUpdater != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {

                // UPDATE
                this.gameUpdater.update();

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

        //

    }

}
