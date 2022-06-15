package main;

import gameObjects.Block;
import input.KeyBoard;
import input.MouseInput;
import math.Vector2D;
import states.GameState;
import graphics.Assets;
import states.MenuState;
import states.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.lang.Integer;
import java.lang.Boolean;
import java.lang.*;

/**
 * Clase main
 */
public class Window extends JFrame implements Runnable {

    public static final Integer width = 900, height = 650;
    public static final Integer height2 = 730;
    private Canvas canvas;
    //hilo
    private Thread thread;
    private Boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    //private Graphics g2;

    private final Integer fps = 60;
    private Double targetTime = Double.valueOf(1000000000/fps);
    private Double delta = Double.valueOf(0); //cambio
    private Integer averageFPS = fps;  //fps

    //private GameState gameState;

    private KeyBoard keyBoard;
    private MouseInput mouseInput;

    /**
     * Constructor de la ventana main
     */
    public Window(){

        setTitle("Break Out Tec");
        setSize(width,height2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        keyBoard = new KeyBoard();
        mouseInput = new MouseInput();

        canvas.setPreferredSize(new Dimension(width,height2));
        canvas.setMaximumSize(new Dimension(width,height2));
        canvas.setMinimumSize(new Dimension(width,height2));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        new Window().start();

    }

    //Integer x = 0;

    /**
     * Actualizar los eventos y el estado actual
     */
    private void update(){ // temodo que actualiza todo
        //x++;
        keyBoard.update();
        State.getCurrentSTate().update();
        //gameState.update();
    }

    /**
     * DIbujar el canvas de la ventana
     */
    private void draw(){
        bs = canvas.getBufferStrategy();
        if (bs == null){
            canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //-----------------------------
        //g.clearRect(0,0,width,height);// limpiar pantalla
        //g.drawRect(x,0,100,100);
        //g.drawImage(Assets.player, 100, 100, null);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height2);
        //g2 = bs.getDrawGraphics();
        //g2.setColor(Color.LIGHT_GRAY);
        //g2.fillRect(0,640,900,80);
        State.getCurrentSTate().draw(g);
        //gameState.draw(g);
        //g.setFont(new Font( "Arial",Font.BOLD,20));
        //g.drawString(""+averageFPS, 100,100);
        //-----------------------------
        g.dispose();
        bs.show();
    }

    /**
     * Inicializar los recursos y el estado menu
     */
    private void init(){ // Se inicializan los recursos y todo que se llama una vez
        Assets.init();
        State.changeState(new MenuState());
        //gameState = new GameState();
    }

    /**
     * Obtener fps
     */
    @Override
    public void run() {

        Long now = Long.valueOf(0);
        Long lastTime = System.nanoTime();
        Integer frames = 0;
        Long time = Long.valueOf(0);

        init();
        while (running){

            now = System.nanoTime();
            delta += ((now-  lastTime)/targetTime);
            time += (now-  lastTime);
            lastTime = now;

            if (delta >= 1){
                update();
                draw();
                delta--;
                frames++;
            }
            if (time >= 1000000000){
                averageFPS = frames;
                //System.out.println(frames);
                frames = 0;
                time = Long.valueOf(0);
            }
        }
        stop();

    }
    // iniciar y detener hilo

    /**
     * Iniciar el hilo
     */
    private void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /**
     * Detener el hilo
     */
    private void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
