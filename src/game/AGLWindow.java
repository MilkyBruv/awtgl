package game;

import javax.swing.JFrame;

import java.awt.Color;

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

    public AGLWindow(String title, boolean resizable, int width, int height, int FPS, AGLMethodRunner updateMethods, AGLMethodRunner drawMethods, Color colour) {

        this.title = title;
        this.resizable = resizable;

        this.width = width;
        this.height = height;
        this.FPS = FPS;
        this.updateMethods = updateMethods;
        this.drawMethods = drawMethods;
        this.colour = colour;
    
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(this.resizable);
        this.frame.setTitle(this.title);

        this.gp = new AGLGamePanel(this.width, this.height, this.FPS, this.drawMethods, this.drawMethods, this.colour);

        this.frame.add(this.gp);

        this.frame.pack();

        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);

        this.gp.startGameThread();

    }

}
