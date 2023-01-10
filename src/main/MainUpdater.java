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
    private float rot = 0;
    private int x = 0;
    private int y = 0;

    public MainUpdater(GameSettings settings, Renderer renderer) {

        super(settings, renderer);

        try {

            this.testImage = new Image(System.getProperty("user.dir") + "\\src\\res\\i.png");

        } catch (IOException e) {
            
            e.printStackTrace();

        }

    }
    


    @Override
    public void update() {

        if (KeyHandler.isKeyPressed(Keys.R)) {

            this.rot += 0.1;

        }

        if (KeyHandler.isKeyPressed(Keys.E)) {

            this.rot -= 0.1;

        }

        if (KeyHandler.isKeyPressed(Keys.RIGHT)) {

            this.x += 1;

        }

        if (KeyHandler.isKeyPressed(Keys.LEFT)) {

            this.x -= 1;

        }

        if (KeyHandler.isKeyPressed(Keys.UP)) {

            this.y -= 1;

        }

        if (KeyHandler.isKeyPressed(Keys.DOWN)) {

            this.y += 1;

        }

    }



    @Override
    public void draw(Image display) {

        this.renderer.drawImage(this.testImage, this.x, this.y, 0, display);
        this.renderer.drawImage(this.testImage, 1, 8, (int) -this.rot, display);

    }

}
