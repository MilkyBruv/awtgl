package spritesheet;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

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



    public AGLSpritesheet(AGLImage image) {

        this.aglImage = image;
        this.bImage = image.getBufferedImage();

    }

    

    public AGLImage getSubImage(int x, int y, int width, int height) {

        BufferedImage preSubImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = preSubImage.getGraphics();

        g.drawImage(this.bImage, x, y, width, height, null);

        AGLImage subImage = new AGLImage(preSubImage);

        return subImage;

    }

}
