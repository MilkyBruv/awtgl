package org.awtgl.window;

public class Updater {
    
    public GameSettings settings;
    public Renderer renderer;
    public GamePanel gamePanel;

    public Updater(GameSettings settings, Renderer renderer) {

        this.settings = settings;
        this.renderer = renderer;

    }



    public void update() { }



    public void draw(Image display) { }

}
