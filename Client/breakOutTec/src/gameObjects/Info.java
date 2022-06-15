package gameObjects;
import math.Vector2D;
import java.awt.*;

/**
 * Clase de la informacion mostrada en el juego
 */
public class Info {

    public Vector2D position;
    public Integer lives;

    public Integer level;

    public Integer points;

    private static Info info;

    /**
     * Singleton
     * @return la unica instancia del objeto Info
     */
    public  static Info getInfo() {

        if (info == null) {

            info = new Info();
        }
        return info;
    }

    /**
     * COnstructor
     */
    private Info() {
        this.lives = 3;
        this.level = 1;
        this.points = 0;

    }

    /**
     * Actualizar informacion de juego
     */
    public void update() {
        if (getLives()>3){
            setLives(3);
        }
        if (getLives()<1){
            setLives(0);
        }
        this.lives = this.lives;
    }

    /**
     * Obtener vidas de jugador
     * @return Integer vidas del jugador
     */
    public Integer getLives() {
        return lives;
    }

    /**
     * Asignar informacion de vidas del jugador
     * @param lives : vidas del jugador
     */
    public void setLives(Integer lives) {
        this.lives = lives;
    }

    /**
     * Obtener informacion del nivel de juego
     * @return Integer nivel de juego
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Asignar informacion de nivel del jugador
     * @param level : nivel del juego
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Obtener informacion de los puntos del jugador
     * @return INteger puntuacion del jugador
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * Asignar informacion de puntos del jugador
     * @param points : puntos del jugador
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * Dibujar la informacion de juego
     * @param g Graphics
     */
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
