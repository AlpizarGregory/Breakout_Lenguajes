package input;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * CLase de la entrada del Mouse
 */
public class MouseInput extends MouseAdapter {

    public static Integer X = 0, Y= 0;

    public static Boolean MLB = false;

    /**
     * Boton del mouse presionado
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            MLB = true;
        }
    }

    /**
     * Boton del mouse soltado
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            MLB = false;
        }
    }

    /**
     * Boton del mouse mantenido
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
    }

    /**
     * Movimiento del mouse
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        X = e.getX();
        Y = e.getY();
    }
}
