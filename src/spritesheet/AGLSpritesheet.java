package spritesheet;

import java.awt.image.BufferedImage;

import image.AGLImage;

public class AGLSpritesheet {

    private BufferedImage bImage;
    private AGLImage aglImage;
    private String dir;

    public AGLSpritesheet(String dir) {

        this.dir = dir;

        this.aglImage = new AGLImage(this.dir);
        this.bImage = this.aglImage.getBufferedImage();

    }

    public BufferedImage getBImage() {

        return this.bImage;

    }

    public AGLImage getAGLImage() {

        return this.aglImage;

    }

    public String getDir() {

        return this.dir;

    }

}
