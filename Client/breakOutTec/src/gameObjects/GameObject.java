package gameObjects;

import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase de los objetos moviles del juego
 */
public abstract class GameObject {
    //protected BufferedImage texture;
    protected Vector2D position;

    /**
     * Constructor
     * @param position : posicion del objeto
     */
    public GameObject(Vector2D position){
        this.position = position;
        //BufferedImage texture
        //this.texture = texture;
    }

    /**
     * Obtener la posicion del objeto movil
     * @return : Vector posicion del objeto
     */
    public Vector2D getPosition() {
        return position;
    }

    /**
     * Asignar posicion del objeto movil
     * @param position : posicion del objeto
     */
    public void setPosition(Vector2D position) {
        this.position = position;
    }

    /**
     * Actualizar objeto movil
     */
    public abstract void update();
    /**
     * Dibujar objeto movil
     */
    public abstract void draw(Graphics g);
}
