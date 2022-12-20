package org.awtgl.window;

import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {

    protected GamePanel gamePanel;
    protected GameSettings gameSettings;
    protected Updater gameUpdater;
    
    public Window(int width, int height, String title, boolean resizeable, int fps, GameSettings gameSettings, Updater gameUpdater) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(resizeable);
        this.setTitle(title);
        this.getContentPane().setBackground(new Color(0x000000));
        this.gameSettings = gameSettings;
        this.gameUpdater = gameUpdater;
        this.gamePanel = new GamePanel(width, height, fps, gameUpdater, this);
        
        this.add(gamePanel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }



    public void start() {

        this.gamePanel.startgameThread();

    }

}
