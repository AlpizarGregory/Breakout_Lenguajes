package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * CLase de la entrada de teclado
 */
public class KeyBoard implements KeyListener {

    private Boolean[] keys = new Boolean[256];

    public static Boolean left;
    public static Boolean right;

    /**
     * Constructor
     */
    public KeyBoard(){
        left = Boolean.FALSE;
        right = Boolean.TRUE;
    }

    /**
     * Actualizar entrada de teclado
     */
    public void update(){
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }

    /**
     * Tecla presionada
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyCode());
        keys[e.getKeyCode()] = true;
    }

    /**
     * Tecla soltada
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    /**
     * Tecla pulsada
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
