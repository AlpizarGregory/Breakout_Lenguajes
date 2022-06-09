package math;

public class Vector2D {

    private Double x,y;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Vector2D(Double x, Double y){
        this.x = x;
        this.y =y;
    }

    public Vector2D(){
        x = Double.valueOf(0);
        y = Double.valueOf(0);
    }
}
