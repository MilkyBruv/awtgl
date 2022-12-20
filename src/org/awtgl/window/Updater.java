package org.awtgl.window;

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



    public void draw(Image display) { }

}
