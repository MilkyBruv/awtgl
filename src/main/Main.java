import colour.AGLColour;
import game.AGLWindow;
import methodRunner.AGLMethodRunner;

public class Main {
    
    public static void main(String[] args) {
        
        AGLMethodRunner updateMethods = new AGLMethodRunner() {

            @Override
            public void runMethods() {

                //

            }

        };

        AGLMethodRunner drawMethods = new AGLMethodRunner() {

            @Override
            public void runMethods() {

                //

            }

        };

        AGLWindow window = new AGLWindow("init", true, 500, 500, 60, updateMethods, drawMethods, AGLColour.rgbColour(255, 0, 0));

    }

}
