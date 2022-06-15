package states;

import java.awt.*;

/**
 * Clase padre de los estados
 */
public abstract class State {

    private static State currentSTate = null;

    /**
     * Obtener el estado actual
     * @return State estado actual
     */
    public static State getCurrentSTate() {
        return currentSTate;
    }

    /**
     * Cambiar el estado actual
     * @param newState : nuevo estado al que se va a pasar
     */
    public static void changeState(State newState){
        currentSTate = newState;
    }

    /**
     * Actualizar los estados
     */
    public abstract void update();

    /**
     * Dibujado en cada estado
     * @param g : Graphics
     */
    public abstract void draw(Graphics g);
}
