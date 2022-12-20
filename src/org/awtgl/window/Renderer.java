package org.awtgl.window;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Renderer {
    
    private AffineTransform backup = new AffineTransform();
    public GameSettings settings;

    public void drawImage(Image image, int x, int y, int rot, Graphics2D g2d, Image display) {

        AffineTransform a = AffineTransform.getRotateInstance(rot, x + (image.getBufferedImage().getWidth() / 2), y + (image.getBufferedImage().getHeight() / 2));

        g2d.setTransform(a);
        g2d.drawImage(image.getBufferedImage(), x, y, this.settings.fullTilsize, this.settings.fullTilsize, null);
        g2d.setTransform(backup);
        g2d.dispose();

    }

}
