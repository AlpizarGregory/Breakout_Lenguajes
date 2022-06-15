package states;

import graphics.Assets;
import ui.Action;
import ui.Button;

import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase del estado Menu
 */
public class MenuState extends State{
    private ArrayList<Button> buttons;
    /**
     * Constructor, crea el menu con todos sus botones
     */
    public MenuState(){
        buttons = new ArrayList<Button>();

        buttons.add(new Button(
                Assets.greyBtn, Assets.blueBtn,
                350, 150, "PLAY",
                new Action() {
                    @Override
                    public void doAction() {
                        State.changeState(new GameState());
                    }
                }
        ));

        buttons.add(new Button(
                Assets.greyBtn, Assets.blueBtn,
                350, 350, "WATCH",
                new Action() {
                    @Override
                    public void doAction() {
                        State.changeState(new GameState());
                    }
                }
        ));

        buttons.add(new Button(
                Assets.greyBtn, Assets.blueBtn,
                350, 550, "CLOSE",
                new Action() {
                    @Override
                    public void doAction() {
                        System.exit(0);
                    }
                }
        ));
    }

    /**
     * Actualizar las acciones realizadas sobre un boton del menu
     */
    @Override
    public void update() {
        for(Button b:buttons){
            b.update();
        }
    }

    /**
     * Dibuja los botones en el menu
     * @param g : Graphics
     */
    @Override
    public void draw(Graphics g) {
        for(Button b:buttons){
            b.draw(g);
        }
    }
}
