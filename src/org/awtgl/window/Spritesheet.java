package org.awtgl.window;

public class Spritesheet {
    
    protected Image image;

    public Spritesheet(Image image) {

        this.image = image;

    }



    public Image getSubImage(int x, int y, int width, int height) {

        Image subImage = new Image(this.image.getBufferedImage().getSubimage(x, y, width, height));

        return subImage;

    }



    public void setImage(Image image) {

        this.image = image;

    }

}
