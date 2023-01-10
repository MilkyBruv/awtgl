# AWTGL

A game development library for Java made in AWT, Swing, JInput, and LWJGL.

Example code:

Main.java
```java
package main;

import org.awtgl.window.GameSettings;
import org.awtgl.window.Renderer;
import org.awtgl.window.Window;

public class Main {
    
    public static void main(String[] args) {

        GameSettings settings = new GameSettings(8, 12, 8);
        Renderer renderer = new Renderer();
        GameUpdater updater = new GameUpdater(settings, renderer);
        Window window = new Window(1280, 720, "test", true, 60, settings, updater);

        window.start();

    }

}
```

GameUpdater.java
```java
package main;

import java.io.IOException;

import org.awtgl.window.GamePanel;
import org.awtgl.window.GameSettings;
import org.awtgl.window.Image;
import org.awtgl.window.KeyHandler;
import org.awtgl.window.Keys;
import org.awtgl.window.Renderer;
import org.awtgl.window.Updater;

public class GameUpdater extends Updater {

    public GamePanel gamePanel;
    private Image testImage;

    public GameUpdater(GameSettings settings, Renderer renderer) {

        super(settings, renderer);

        try {

            this.testImage = new Image(System.getProperty("user.dir") + "\\src\\res\\i.png");
            
        } catch (IOException e) {
            
            e.printStackTrace();

        }

    }
    


    @Override
    public void update() {

        if (KeyHandler.isKeyPressed(Keys.RIGHT)) {

            //

        }

        if (KeyHandler.isKeyPressed(Keys.LEFT)) {

            //

        }

    }



    @Override
    public void draw(Image display) {

        this.renderer.drawImage(this.testImage, 20, 20, 0, display);

    }

}
```