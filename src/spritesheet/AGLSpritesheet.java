package spritesheet;

import java.awt.image.BufferedImage;

public class AGLSpritesheet {

    private BufferedImage image;

    public AGLSpritesheet(String dir) {

        this.dir = dir;

        this.aglImage = new AGLImage(this.dir);
        this.image = this.aglImage.get();

    }

}
