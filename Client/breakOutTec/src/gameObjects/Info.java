package gameObjects;
import math.Vector2D;
import java.awt.*;

public class Info {

    public Vector2D position;
    public Integer lives;

    public Info() {
        this.lives = 3;

    }

    public void update() {
        if (getLives()>3){
            setLives(3);
        }
        this.lives = this.lives;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font( "Arial",Font.BOLD,19));
        g.drawString("LIVES: "+ getLives() + " / 3", 40,665);
        //g.drawString();
        //g.drawRect(position.getX().intValue(),position.getY().intValue(),80,20);
    }

}
