package main;

import org.awtgl.window.GameSettings;
import org.awtgl.window.Window;

public class Main {
    
    public static void main(String[] args) {

        GameSettings settings = new GameSettings(8, 12, 5, 5);
        MainUpdater updater = new MainUpdater(settings);
        Window window = new Window(1280, 720, "test", true, 60, settings, updater);

        window.start();

    }

}
