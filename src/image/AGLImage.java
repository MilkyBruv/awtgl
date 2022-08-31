package image;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AGLImage {
    
    private BufferedImage bImage;
    private String dir;

    public AGLImage(String dir) {

        this.dir = dir;

        try {

            this.bImage = ImageIO.read(getClass().getResource(dir));

        } catch (IOException e) {
            
            this.bImage = new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB);

        }

    }

    public BufferedImage getBufferedImage() {

        return this.bImage;

    }

    public String getDir() {

        return this.dir;

    }

}
