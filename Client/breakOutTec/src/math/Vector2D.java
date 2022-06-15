package math;

/**
 * Clase vector en 2D
 */
public class Vector2D {

    private Double x,y;

    /**
     * Obtener el x del vector
     * @return Double x del vector
     */
    public Double getX() {
        return x;
    }

    /**
     * Asignar posicion x del vector
     * @param x : posicion en el eje x
     */
    public void setX(Double x) {
        this.x = x;
    }
    /**
     * Obtener el y del vector
     * @return Double y del vector
     */
    public Double getY() {
        return y;
    }
    /**
     * Asignar posicion y del vector
     * @param y : posicion en el eje y
     */
    public void setY(Double y) {
        this.y = y;
    }

    /**
     * Constructor
     * @param x : posicion en el eje x
     * @param y : posicion en el eje y
     */
    public Vector2D(Double x, Double y){
        this.x = x;
        this.y =y;
    }
    /**
     * Constructor
     */
    public Vector2D(){
        x = Double.valueOf(0);
        y = Double.valueOf(0);
    }
}
