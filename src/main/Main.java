package main;

import java.io.IOException;

import org.awtgl.controller.ControllerManager;
import org.awtgl.window.GameSettings;
import org.awtgl.window.Window;

public class Main {
    
    public static void main(String[] args) throws IOException {

        new ControllerManager();

        GameSettings settings = new GameSettings(8, 4, 10, 8);

        Window window = new Window(800, 800, "test", true, 60, settings);

        window.start();

    }

}
