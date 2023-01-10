package main;

import org.awtgl.window.GameSettings;
import org.awtgl.window.Renderer;
import org.awtgl.window.Window;

public class Main {
    
    public static void main(String[] args) {

        GameSettings settings = new GameSettings(8, 12, 8);
        Renderer renderer = new Renderer();
        MainUpdater updater = new MainUpdater(settings, renderer);
        Window window = new Window(1280, 720, "sus", true, 60, settings, updater, Window.SCALE_INNER_DISPLAY);

        window.start();

    }

}
