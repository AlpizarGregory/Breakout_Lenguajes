package gameObjects;

import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
// atributos qe todos los objetos tendran en comun

// almacena posicion e imagen
public abstract class GameObject {
    protected BufferedImage texture;
    protected Vector2D position;

    public GameObject(Vector2D position, BufferedImage texture){
        this.position = position;
        this.texture = texture;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public abstract void update();

    public abstract void draw(Graphics g);
}
