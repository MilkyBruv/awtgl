package main;

import window.GameUpdater;
import window.KeyHandler;
import static window.Keys.*;

public class Updater implements GameUpdater {
    
    @Override
    public void update() {

        if (KeyHandler.isKeyPressed(RIGHT)) {

            System.out.println("right");

        }

    }

}
