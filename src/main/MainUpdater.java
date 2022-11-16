package main;

import org.awtgl.window.GameSettings;
import org.awtgl.window.KeyHandler;
import org.awtgl.window.Keys;
import org.awtgl.window.Updater;

public class MainUpdater implements Updater {

    GameSettings settings;

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

    }

}
