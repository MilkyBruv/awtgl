package window;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    public Window(int width, int height, String title, boolean resizeable) {

        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(width, height);
        this.setTitle(title);
        this.setResizable(resizeable);

    }



    public void addPanel(Panel panel) {

        this.add(panel);

    }



    public void addGamePanel(GamePanel gamePanel) {

        this.add(gamePanel);

    }

}
