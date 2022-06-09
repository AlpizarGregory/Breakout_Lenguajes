package gameObjects;

import math.Vector2D;

import java.awt.*;

import java.util.Random;

public class Ball {

    public Vector2D position;
    public Double speed;
    public Integer direction;

    public Random random = new Random();




    //-------------------------------------------------------------------------------------------
    public Ball() {
        this.speed = 2.0;
    }

    public Ball(Double speed, Vector2D position, Integer direction) {
        super();
        this.speed = speed;
        this.position = position;
        this.direction = direction;
    }


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





    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getDirection() {
        return this.direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public void move1stQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()+this.getSpeed(), this.getPosition().getY()-this.getSpeed()));
    }
    public void move2ndQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()-this.getSpeed(), this.getPosition().getY()-this.getSpeed()));
    }
    public void move3rdQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()-this.getSpeed(), this.getPosition().getY()+this.getSpeed()));
    }
    public void move4thQ(){
        this.setPosition(new Vector2D(this.getPosition().getX()+this.getSpeed(), this.getPosition().getY()+this.getSpeed()));
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(position.getX().intValue(),position.getY().intValue(),23,23);
    }


}
