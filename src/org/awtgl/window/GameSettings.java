package org.awtgl.window;

public class GameSettings {
    
    public int tileSize;
    public int scale;
    public int tiledWidth;
    public int tiledHeight;
    public int width;
    public int height;

    public GameSettings(int tileSize, int tiledWidth, int tiledHeight) {

        this.tileSize = tileSize;
        this.tiledWidth = tiledWidth;
        this.tiledHeight = tiledHeight;
        this.width = this.tileSize * this.tiledWidth;
        this.height = this.tileSize * this.tiledHeight;

    }

}
