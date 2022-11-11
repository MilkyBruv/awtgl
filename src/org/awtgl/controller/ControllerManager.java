package org.awtgl.controller;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

public class ControllerManager {

    public static Controller[] getControllers() {

        try {

            Controllers.create();

        } catch (LWJGLException e) {

            e.printStackTrace();

        }

        List<Controller> controllers = new ArrayList<Controller>() {};

        Controllers.poll();

        for (int i = 0; i < Controllers.getControllerCount(); i++) {

            if (Controllers.getController(i).getName().equals("Wireless Controller")) {

                controllers.add(Controllers.getController(i));

            }

        }

        return (Controller[]) controllers.toArray();

    }

}
