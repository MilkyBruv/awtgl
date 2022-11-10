package window.image;

import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

public class Image extends BufferedImage {

    public Image(int width, int height, int imageType, IndexColorModel cm) {

        super(width, height, imageType, cm);

    }

}
