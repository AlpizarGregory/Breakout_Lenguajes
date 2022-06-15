package gameObjects;

import math.Vector2D;

import java.awt.*;

import java.util.Random;

/**
 * Clase de la bola del juego
 */
public class Ball extends GameObject {


    public Double speed;
    public Integer direction;

    public Random random = new Random();




    //-------------------------------------------------------------------------------------------

    /**
     * Constructor
     * @param position : vector posicion de la bola
     */
    public Ball(Vector2D position) {
        super(position);
        this.speed = 2.0;
    }

    /**
     * Constructor
     * @param speed : velocidad de la bola
     * @param position : vector posicion de la bola
     * @param direction : direccion de la bola
     */
    public Ball(Double speed, Vector2D position, Integer direction) {
        super(position);
        this.speed = speed;
        this.direction = direction;
    }


    /**
     * Actualiza el movimiento de la bola
     */
    public void update() {


        switch (this.direction){
            case 1:
                move1stQ();
                break;
            case 2:
                move2ndQ();
                break;
            case  3:
                move3rdQ();
                break;
            case 4:
                move4thQ();
                break;
            default:
                break;
        }

    }

    /**
     * Obtener velocidad de la bola
     * @return : Double velocidad de la bola
     */

    public Double getSpeed() {
        return speed;
    }

    /**
     * Asignar velocidad de la bola
     * @param speed : velocidad de la bola
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * Obtener direccion de la bola
     * @return : Integer direccion de la bola
     */
    public Integer getDirection() {
        return this.direction;
    }

    /**
     * Asignar direccion de la bola
     * @param direction : direccion de la bola
     */
    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    /**
     * Movimiento en direccion del primer cuadrante (+ , +)
     */
    public void move1stQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()+this.getSpeed(), this.getPosition().getY()-this.getSpeed()));
    }
    /**
     * Movimiento en direccion del segundo cuadrante (- , +)
     */
    public void move2ndQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()-this.getSpeed(), this.getPosition().getY()-this.getSpeed()));
    }
    /**
     * Movimiento en direccion del tercer cuadrante (- , -)
     */
    public void move3rdQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()-this.getSpeed(), this.getPosition().getY()+this.getSpeed()));
    }
    /**
     * Movimiento en direccion del cuarto cuadrante (+ , -)
     */
    public void move4thQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()+this.getSpeed(), this.getPosition().getY()+this.getSpeed()));
    }

    /**
     * Dibujar la bola
     * @param g : Graphics
     */
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(position.getX().intValue(),position.getY().intValue(),23,23);
    }


}
