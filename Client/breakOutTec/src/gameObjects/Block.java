package gameObjects;

import input.KeyBoard;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase de los bloques del juego
 */
public class Block {
    public Vector2D position;
    public String state;

    public Integer value;

    public Color color;

    /**
     * Constructor
     */
    public Block() {
        this.state = "enabled";
        this.value = 0;
    }

    /**
     * Actualizar el bloque
     */
    public void update() {
        this.position = position;
        this.state = state;

    }

    /**
     * Obtener el estado del bloque
     * @return : String estado del bloque
     */
    public String getState() {
        return state;
    }

    /**
     * Asignar estado a un bloque
     * @param state : estado de un bloque
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Obtener la posicion de un bloque
     * @return : Vector posicion de un bloque
     */
    public Vector2D getPosition() {
        return position;
    }

    /**
     * Asignar la posicion a un bloque
     * @param position : posicion de un bloque
     */
    public void setPosition(Vector2D position) {
        this.position = position;
    }

    /**
     * Obtener color de un bloque
     * @return : Color color de un bloque
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Asignar color a un bloque
     * @param color : color de un bloque
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Obtener valor (puntos) de un bloque
     * @return : Integer valor de un bloque
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Asignar valor a un bloque
     * @param value : valor del bloque
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * Dibujar los bloques
     * @param g : Graphics
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(position.getX().intValue(),position.getY().intValue(),80,20);
    }


}
