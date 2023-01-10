package org.awtgl.window;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

    private BufferedImage bufferedImage;

    protected Image(BufferedImage bufferedImage) {

        this.bufferedImage = bufferedImage;

    }



    public Image(int width, int height) {

        this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

    }



    public Image(String dir) throws IOException {

        this.bufferedImage = ImageIO.read(new File(dir));

    }



    protected BufferedImage getBufferedImage() {

        return this.bufferedImage;

    }

}
