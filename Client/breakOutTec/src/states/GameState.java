package states;
// Control de todo
import gameObjects.*;
import graphics.Assets;
import math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameState extends State{
    private Boolean over = false;

    private Player player;


    private Block[][] blocksMatrix;
    public Double blockX = -90.0;
    public Double blockY = 0.0;
    public Integer disabledBlocks = 0;


    //public GameObject balle = Factory.getMovableObject("ball");

    public Ball ball;
    List<Ball> ballList;
    public Random random = new Random();

    private Info info;

    public GameState(){

        player = new Player(new Vector2D(100.0,580.0));

        blocksMatrix = new Block[8][10];

        ball = new Ball(new Vector2D(random.nextDouble(800.0-200.0) + 200.0,270.0));
        //ball.setPosition();
        ball.setDirection(random.nextInt(5-1) + 1);

        Factory.getMovableObject("ball");

        ballList = new ArrayList<Ball>();

        ballList.add(ball);
        //ballList.add(new Ball(1.0,new Vector2D(700.0,500.0),2));

        info = Info.getInfo();
        //info = new Info();


        for(Integer i = 0; i<blocksMatrix.length; i++){
            for(Integer j = 0; j<10; j++){
                blocksMatrix[i][j] = new Block();
                blocksMatrix[i][j].setPosition(new Vector2D(blockX+=90.0,blockY));
                blocksMatrix[i][j].setState("enabled");

                if (i<2){
                    blocksMatrix[i][j].setColor(Color.red);
                } else if (i<4){
                    blocksMatrix[i][j].setColor(Color.orange);
                } else if (i<6){
                    blocksMatrix[i][j].setColor(Color.yellow);
                } else if (i<8){
                    blocksMatrix[i][j].setColor(Color.green);
                }

            }
            blockX = -90.0;
            blockY += 30.0;
        }

        blocksMatrix[7][0].setValue(5);
        blocksMatrix[7][1].setValue(10);
        blocksMatrix[7][2].setValue(15);
        blocksMatrix[7][3].setValue(20);
        //blocksMatrix[7][8].setState("moreSpeed");
        //blocksMatrix[7][9].setState("moreSpeed");
    }

    public void gameOver(){
        over = true;
    }
    public void newLevel(){
        disabledBlocks = 0;
        blockX = -90.0;
        blockY = 0.0;
        for(Integer i = 0; i<blocksMatrix.length; i++){
            for(Integer j = 0; j<10; j++){
                blocksMatrix[i][j].setState("enabled");
                blocksMatrix[i][j].setPosition(new Vector2D(blockX+=90.0,blockY));
            }
            blockX = -90.0;
            blockY += 30.0;
        }
        ballList.clear();
        ballList.add(ball);
        ///////////////////////////////////////////////
        ball.setSpeed(ball.getSpeed()+1.0);
        ball.setPosition(new Vector2D(random.nextDouble(800.0-200.0) + 200.0,270.0));
        ball.setDirection(random.nextInt(5-1) + 1);
        //////////////////////////////////////////////

        info.setLevel(info.getLevel()+1);
    }
    public void update(){
        player.update();

        if (disabledBlocks == (80)){

            newLevel();
        }
        if (player.getLives()==0){
            gameOver();
        }


        for(Integer i = 0; i<blocksMatrix.length; i++){
            for(Integer j = 0; j<10; j++){
                blocksMatrix[i][j].update();
                for(Integer k = 0; k<ballList.size(); k++) {

                    if (ballList.get(k).getPosition().getX() + 23.0 >= blocksMatrix[i][j].getPosition().getX() & ballList.get(k).getPosition().getX() <= blocksMatrix[i][j].getPosition().getX() + 80.0 & ballList.get(k).getPosition().getY() + 23.0 >= blocksMatrix[i][j].getPosition().getY() & ballList.get(k).getPosition().getY() <= blocksMatrix[i][j].getPosition().getY() + 20.0) {

                        if (blocksMatrix[i][j].getState() == "moreSpeed") {
                            ballList.get(k).setSpeed(ballList.get(k).getSpeed() + 0.3);
                        }
                        if (blocksMatrix[i][j].getState() == "lessSpeed") {
                            ballList.get(k).setSpeed(ballList.get(k).getSpeed() - 0.3);
                        }
                        if (blocksMatrix[i][j].getState() == "doubleSize") {
                            player.setPlayerSize(player.getPlayerSize() * 2);
                        }
                        if (blocksMatrix[i][j].getState() == "halfSize") {
                            player.setPlayerSize(player.getPlayerSize() / 2);
                        }
                        if (blocksMatrix[i][j].getState() == "addBall") {
                            ballList.add(new Ball(ball.getSpeed(),new Vector2D(random.nextDouble(800.0-200.0) + 200.0,270.0),random.nextInt(5-1) + 1));
                        }
                        if (blocksMatrix[i][j].getState() == "addLive") {
                            player.setLives(player.getLives() + 1);

                            info.setLives(player.getLives());
                        }

                        info.setPoints(info.getPoints()+blocksMatrix[i][j].getValue());

                        blocksMatrix[i][j].setPosition(new Vector2D(-100.0, -100.0)); // Destructor // ///////////////////
                        blocksMatrix[i][j].setState("disabled");
                        disabledBlocks += 1;
                        if (ballList.get(k).getDirection() == 2) {
                            ballList.get(k).setDirection(3);
                        } else if (ballList.get(k).getDirection() == 1) {
                            ballList.get(k).setDirection(4);
                        } else if (ballList.get(k).getDirection() == 3) {
                            ballList.get(k).setDirection(4);
                        } else if (ballList.get(k).getDirection() == 4) {
                            ballList.get(k).setDirection(3);
                        }
                    }
                }
            }
        }
        //-------------------------------------------------------------BOLA

        for(Integer k = 0; k<ballList.size(); k++) {
            if (ballList.get(k).getPosition().getX() <= 0) {
                if (ballList.get(k).getDirection() == 2) {
                    ballList.get(k).setDirection(1);
                } else if (ballList.get(k).getDirection() == 3) {
                    ballList.get(k).setDirection(4);
                }
            }
            if (ballList.get(k).getPosition().getX() + 23.0 >= 900) {
                if (ballList.get(k).getDirection() == 1) {
                    ballList.get(k).setDirection(2);
                } else if (ballList.get(k).getDirection() == 4) {
                    ballList.get(k).setDirection(3);
                }
            }
            if (ballList.get(k).getPosition().getY() <= 0) {
                if (ballList.get(k).getDirection() == 1) {
                    ballList.get(k).setDirection(4);
                } else if (ballList.get(k).getDirection() == 2) {
                    ballList.get(k).setDirection(3);
                }
            }
            if (ballList.get(k).getPosition().getY() + 23.0 >= 650) { // LOST // .......................................
                if (ballList.get(k).getDirection() == 3) {
                    ballList.get(k).setDirection(2);
                } else if (ballList.get(k).getDirection() == 4) {
                    ballList.get(k).setDirection(1);
                }
                ballList.get(k).setPosition(new Vector2D(random.nextDouble(800.0 - 200.0) + 200.0, 350.0));

                player.setLives(player.getLives() - 1);
                info.setLives(player.getLives());

            }

            if (ballList.get(k).getPosition().getY() + 23.0 >= player.getPosition().getY() & ballList.get(k).getPosition().getX() + 23.0 >= player.getPosition().getX() & ballList.get(k).getPosition().getX() <= player.getPosition().getX() + player.getPlayerSize()) {
                if (ballList.get(k).getDirection() == 3) {
                    ballList.get(k).setDirection(2);
                } else if (ballList.get(k).getDirection() == 4) {
                    ballList.get(k).setDirection(1);
                }
            }
        }
        //-------------------------------------------------------------BOLA

        for(Integer i = 0; i<ballList.size(); i++){
            ballList.get(i).update();
        }
        //ball.update();

        info.update();
    }

    public void draw(Graphics g){
        player.draw(g);

        for(Integer i = 0; i<blocksMatrix.length; i++){
            for(Integer j = 0; j<10; j++){
                blocksMatrix[i][j].draw(g);
            }
        }

        for(Integer i = 0; i<ballList.size(); i++){
            ballList.get(i).draw(g);
        }
        if (over){
            g.drawImage(Assets.gameOver, 85, 54, null);
        }

        //g.drawImage(Assets.gameOver, 0, 0, null);

        //ball.draw(g);

        info.draw(g);
    }
}
