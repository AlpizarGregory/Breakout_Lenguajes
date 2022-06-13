package states;

import graphics.Assets;
import ui.Action;
import ui.Button;

import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.util.ArrayList;

public class MenuState extends State{
    private ArrayList<Button> buttons;

    public MenuState(){
        buttons = new ArrayList<Button>();

        buttons.add(new Button(
                Assets.greyBtn, Assets.blueBtn,
                350, 200, "Play",
                new Action() {
                    @Override
                    public void doAction() {
                        State.changeState(new GameState());
                    }
                }
        ));

        buttons.add(new Button(
                Assets.greyBtn, Assets.blueBtn,
                350, 400, "Close",
                new Action() {
                    @Override
                    public void doAction() {
                        System.exit(0);
                    }
                }
        ));
    }
    @Override
    public void update() {
        for(Button b:buttons){
            b.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for(Button b:buttons){
            b.draw(g);
        }
    }
}
