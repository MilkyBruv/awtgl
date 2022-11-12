package org.awtgl.window;

import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame {

    private GamePanel gamePanel;
    protected GameSettings gameSettings;
    
    public Window(int width, int height, String title, boolean resizeable, int fps, GameSettings gameSettings) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(resizeable);
        this.setTitle(title);
        this.getContentPane().setBackground(new Color(0x000000));
        this.gameSettings = gameSettings;
        
        this.gamePanel = new GamePanel(
            
            this.gameSettings.tiledWidth * this.gameSettings.fullTilsize, 
            this.gameSettings.tiledHeight * this.gameSettings.fullTilsize, 
            fps, 
            this

        );
        
        this.add(gamePanel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }



    public void start() {

        this.gamePanel.startgameThread();

    }

}
