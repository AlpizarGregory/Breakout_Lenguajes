package gameObjects;
import math.Vector2D;
import java.awt.*;

public class Info {

    public Vector2D position;
    public Integer lives;

    public Integer level;

    public Integer points;

    private static Info info;

    public  static Info getInfo() {

        if (info == null) {

            info = new Info();
        }
        return info;
    }

    private Info() {
        this.lives = 3;
        this.level = 1;
        this.points = 0;

    }

    public void update() {
        if (getLives()>3){
            setLives(3);
        }
        if (getLives()<1){
            setLives(0);
        }
        this.lives = this.lives;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font( "Arial",Font.BOLD,19));
        g.drawString("LIVES: "+ getLives() + " / 3", 40,665);
        g.drawString("LEVEL: "+ getLevel() + " / ∞", 730,665);
        g.drawString("POINTS: "+ getPoints(), 410,665);
        //g.drawString();
        //g.drawRect(position.getX().intValue(),position.getY().intValue(),80,20);
    }

}
