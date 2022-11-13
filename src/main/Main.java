package main;

import org.awtgl.window.GameSettings;
import org.awtgl.window.Window;

public class Main {
    
    public static void main(String[] args) {

        GameSettings settings = new GameSettings(8, 0, 10, 8);
        MainUpdater updater = new MainUpdater();
        Window window = new Window(800, 800, "test", true, 60, settings, updater);

        window.start();

    }

}
