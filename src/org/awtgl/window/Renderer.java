package org.awtgl.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Renderer {
    
    private Graphics g;
    private AffineTransform backup;

    protected void supplyGraphics(Graphics g) {
        
        this.g = g;
        Graphics2D g2d = (Graphics2D) g;
        this.backup = g2d.getTransform();

    }



    public Image createDisplay(int width, int height) {

        return new Image(width, height);

    }



    public void drawImage(Image image, int x, int y, int width, int height, int rot) {

        Graphics2D g2d = (Graphics2D) this.g;

        AffineTransform a = AffineTransform.getRotateInstance(rot, x + (width / 2), y + (height / 2));
        g2d.setTransform(a);
        
        g2d.drawImage(image.getBufferedImage(), x, y, null);
        
        g2d.setTransform(backup);

        g2d.dispose();

    }

}
