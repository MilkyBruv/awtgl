package main;

import controller.Controller;
import window.GamePanel;
import window.Window;

public class Main {
    
    public static void main(String[] args) {

        Controller cont = new Controller();

        Window window = new Window(800, 800, "amongus", true);
        Updater mainUpdater = new Updater();
        GamePanel gamePanel = new GamePanel(800, 800, 60, mainUpdater);
        window.addGamePanel(gamePanel);

        gamePanel.startgameThread();

    }

}
