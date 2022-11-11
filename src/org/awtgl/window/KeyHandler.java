package org.awtgl.window;

import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyHandler {

    private static final Map<Integer, Boolean> pressedKeys = new HashMap<>();

    static {

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {

            synchronized (KeyHandler.class) {

                if (event.getID() == KeyEvent.KEY_PRESSED) { 
                    
                    pressedKeys.put(event.getKeyCode(), true); 
                
                }

                else if (event.getID() == KeyEvent.KEY_RELEASED) {

                    pressedKeys.put(event.getKeyCode(), false);

                }

                return false;
            }

        });

    }

    public static boolean isKeyPressed(int keyCode) {
        
        return pressedKeys.getOrDefault(keyCode, false);

    }

}