package gameObjects;

import math.Vector2D;

import java.util.Random;

public class Factory {

    public static Random random = new Random();

    public static GameObject getMovableObject(String kind) {

        if (kind.equals("ball")) {

            return new Ball(new Vector2D(random.nextDouble(800.0-200.0) + 200.0,270.0));
        }
        else {
            return new Player(new Vector2D(100.0,580.0));
        }

    }
}
