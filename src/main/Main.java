import colour.AGLColour;
import game.AGLWindow;
import methodRunner.AGLMethodRunner;
import spritesheet.AGLSpritesheet;
import image.AGLImage;

public class Main {
    
    public static void main(String[] args) {
        
        AGLMethodRunner updateMethods = new AGLMethodRunner() {

            @Override
            public void runMethods() {

                //

            }

        };

        AGLWindow window = new AGLWindow("init", true, 500, 500, 60, updateMethods, AGLColour.rgbColour(255, 0, 0));

        AGLImage image1 = new AGLImage("../assets/i.png");
        AGLSpritesheet spritesheet = new AGLSpritesheet(image1);
        AGLImage si = spritesheet.getSubImage(0, 0, 2, 2);

        window.drawImage(si, 0, 0, 80, 80);
        window.drawImage(image1, 80, 0, 80, 80);

    }

}
