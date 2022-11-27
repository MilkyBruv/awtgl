package org.awtgl.window;

import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {

    public GamePanel gamePanel;
    protected GameSettings gameSettings;
    protected Updater gameUpdater;
    
    public Window(int width, int height, String title, boolean resizeable, int fps, GameSettings gameSettings, Updater gameUpdater) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(resizeable);
        this.setTitle(title);
        this.getContentPane().setBackground(new Color(0x000000));
        this.gameSettings = gameSettings;
        this.gameUpdater = gameUpdater;
        
        if (this.gameSettings.scale != 0) {

            this.gamePanel = new GamePanel(
            
                this.gameSettings.tiledWidth * this.gameSettings.fullTilsize, 
                this.gameSettings.tiledHeight * this.gameSettings.fullTilsize, 
                fps, 
                gameUpdater, 
                this
    
            );

        } else if (this.gameSettings.scale == 0) {

            this.gamePanel = new GamePanel(
            
                width, 
                height, 
                fps, 
                gameUpdater, 
                this
    
            );

        }
        
        this.add(gamePanel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }



    public void start() {

        this.gamePanel.startgameThread();

    }

}
