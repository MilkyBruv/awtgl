package main;

import org.awtgl.window.KeyHandler;
import org.awtgl.window.Keys;
import org.awtgl.window.Updater;

public class MainUpdater implements Updater {
    
    @Override
    public void update() {

        if (KeyHandler.isKeyPressed(Keys.RIGHT)) {

            System.out.println("right was pressed");

        }

    }

}
