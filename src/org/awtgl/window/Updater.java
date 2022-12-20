package org.awtgl.window;

import java.awt.Graphics2D;

public class Updater {
    
    public GameSettings settings;
    public Renderer renderer;
    public GamePanel gamePanel;

    public Updater(GameSettings settings, Renderer renderer) {

        this.settings = settings;
        this.renderer = renderer;
        this.renderer.settings = settings;

    }



    public void update() { }



    public void draw(Graphics2D g2d, Image display) { }

}
