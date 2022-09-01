package game;

import javax.swing.JFrame;

import image.AGLImage;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import methodRunner.AGLMethodRunner;

public class AGLWindow {
    
    public String title;
    public boolean resizable;
    public JFrame frame;
    public AGLGamePanel gp;
    public int width;
    public int height;
    public int FPS;
    public Color colour;
    public AGLMethodRunner updateMethods;
    public AGLMethodRunner drawMethods;
    public List<AGLImage> drawImageOrder;
    public List<int[]> drawImagePos;

    public AGLWindow(String title, boolean resizable, int width, int height, int FPS, AGLMethodRunner updateMethods, Color colour) {

        this.title = title;
        this.resizable = resizable;

        this.width = width;
        this.height = height;
        this.FPS = FPS;
        this.updateMethods = updateMethods;
        this.colour = colour;
        this.drawImageOrder = new ArrayList<>();
        this.drawImagePos = new ArrayList<>();
    
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(this.resizable);
        this.frame.setTitle(this.title);

        this.gp = new AGLGamePanel(this.width, this.height, this.FPS, this.updateMethods, this.colour, this);

        this.frame.add(this.gp);

        this.frame.pack();

        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);

        this.gp.startGameThread();

    }



    public void drawImage(AGLImage image, int x, int y, int width, int height) {

        this.drawImageOrder.add(image);
        this.drawImagePos.add(new int[] {x, y, width, height});

    }

}
