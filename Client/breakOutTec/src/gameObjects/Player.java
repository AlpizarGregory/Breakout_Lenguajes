package gameObjects;

import input.KeyBoard;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.security.Key;

public class Player extends GameObject {

    public Integer lives = 3;
    public Integer playerSize;
    public Player (Vector2D position){
        super(position);
        this.playerSize = 151;

    }



    @Override
    public void update() {

        if (getLives()>3){
            setLives(3);
        }
        if (getLives()<1){
            setLives(0);
        }
        if (position.getX()<1.0){
            position.setX(1.0);
        }
        if (position.getX()>900.0-getPlayerSize()){
            position.setX(900.0-getPlayerSize());
        }
        if (KeyBoard.right == Boolean.TRUE){
            position.setX(position.getX() + 4);
        }
        if (KeyBoard.left == Boolean.TRUE) {
            position.setX(position.getX() - 4);
        }
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public Integer getPlayerSize() {
        return playerSize;
    }

    public void setPlayerSize(Integer playerSize) {
        this.playerSize = playerSize;
    }

    @Override
    public void draw(Graphics g) {
        //g.drawImage(texture, position.getX().intValue(), position.getY().intValue(), null);
        g.setColor(Color.CYAN);
        g.drawRect(position.getX().intValue(),position.getY().intValue(),playerSize,21);
    }
}
