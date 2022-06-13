package states;

import java.awt.*;

public abstract class State {

    private static State currentSTate = null;

    public static State getCurrentSTate() {
        return currentSTate;
    }

    public static void changeState(State newState){
        currentSTate = newState;
    }
    public abstract void update();
    public abstract void draw(Graphics g);
}
