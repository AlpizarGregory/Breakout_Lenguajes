package gameObjects;

import input.KeyBoard;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Block {
    public Vector2D position;
    public String state;

    public Integer value;

    public Color color;

    public Block() {
        this.state = "enabled";
        this.value = 0;
    }

    public void update() {
        this.position = position;
        this.state = state;

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getValue() {
        return value;
    }


    public void setValue(Integer value) {
        this.value = value;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(position.getX().intValue(),position.getY().intValue(),80,20);
    }


}
