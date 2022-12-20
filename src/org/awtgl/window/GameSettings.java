package org.awtgl.window;

public class GameSettings {
    
    public int baseTileSize;
    public int scale;
    public int tiledWidth;
    public int tiledHeight;
    public int fullTilsize;

    public GameSettings(int baseTileSize, int scale, int tiledWidth, int tiledHeight) {

        this.baseTileSize = baseTileSize;
        this.scale = scale;
        this.tiledWidth = tiledWidth;
        this.tiledHeight = tiledHeight;
        this.fullTilsize = this.scale * this.baseTileSize;

    }



    protected void update(int newTilesize) {

        this.fullTilsize = newTilesize;
        this.scale = this.fullTilsize / this.baseTileSize;

    }

}
