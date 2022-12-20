package main;

import java.io.IOException;

import org.awtgl.window.GamePanel;
import org.awtgl.window.GameSettings;
import org.awtgl.window.Image;
import org.awtgl.window.KeyHandler;
import org.awtgl.window.Keys;
import org.awtgl.window.Renderer;
import org.awtgl.window.Updater;

public class MainUpdater extends Updater {

    public GamePanel gamePanel;
    private Image testImage;

    public MainUpdater(GameSettings settings, Renderer renderer) {

        super(settings, renderer);

        try {
            this.testImage = new Image(System.getProperty("user.dir") + "\\src\\res\\i.png");
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
