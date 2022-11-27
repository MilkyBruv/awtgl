package main;

import java.io.IOException;

import org.awtgl.window.GameSettings;
import org.awtgl.window.Image;
import org.awtgl.window.KeyHandler;
import org.awtgl.window.Keys;
import org.awtgl.window.Renderer;
import org.awtgl.window.Updater;

public class MainUpdater implements Updater {

    GameSettings settings;
    public Renderer renderer;

    public MainUpdater(GameSettings settings) {

        this.settings = settings;

    }
    
    @Override
    public void update() {

        if (KeyHandler.isKeyPressed(Keys.RIGHT)) {

            this.settings.scale += 1;

        }

        if (KeyHandler.isKeyPressed(Keys.LEFT)) {

            this.settings.scale -= 1;

        }

        this.settings.update();
        try {
            this.draw();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    public void draw() throws IOException {

        renderer.drawImage(new Image(System.getProperty("user.dir") + "/res/i.png"), 0, 0, this.settings.baseTileSize, this.settings.baseTileSize);

    }

}
