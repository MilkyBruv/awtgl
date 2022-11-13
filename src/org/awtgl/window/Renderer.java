package org.awtgl.window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

class Renderer {
    
    protected HashMap<Image, Integer[]> test = new HashMap<>();
    private Graphics2D g2d;

    protected Renderer(Graphics g) {

        this.g2d = (Graphics2D) g;

    }



    public void drawImage(Image image, int x, int y, int width, int height) {
        
        this.g2d.drawImage(image.getBufferedImage(), x, y, width, height, null);
        this.g2d.dispose();

    }

}
