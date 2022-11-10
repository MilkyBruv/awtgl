package controller;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controllers;

public class Controller {

    public Controller() {

        try {

            Controllers.create();

        } catch (LWJGLException e) {

            e.printStackTrace();

        }

        Controllers.poll();

        for (int i = 0; i < Controllers.getControllerCount(); i++) {

            if (Controllers.getController(i).getName().equals("Wireless Controller")) {

                System.out.println(Controllers.getController(i).getName());

            }

        }

    }

}
