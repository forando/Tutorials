package visitor;

/**
 * Created by forando on 31.07.15.
 */
public class Point2d extends Point {
    public Point2d ( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public void accept ( Visitor v ) {
        v.visit( this );
    }

    private double x;
    public double getX () { return x; }

    private double y;
    public double getY () { return y; }
}
