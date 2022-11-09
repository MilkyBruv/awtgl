package awtgl.window;

import javax.swing.JFrame;

public class Window extends JFrame {
    
    private Window(int x, int y, int width, int height, String title) {

        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setBounds(x, y, width, height);
        this.setTitle(title);

    }

}
