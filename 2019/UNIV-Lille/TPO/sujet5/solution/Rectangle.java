/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.geom.*;

/**
 *
 * @author carre
 */
public class Rectangle extends Figure{

    Point2D.Double origine, corner;

    public Rectangle(double xorigine, double yorigine, double xcorner, double ycorner) {
        origine = new Point2D.Double(xorigine, yorigine);
        corner = new Point2D.Double(xcorner, ycorner);
    }

    Rectangle() {
    }

    public double surface() {
        return (corner.getX() - origine.getX()) * (corner.getY() - origine.getY());
    }

    @Override
    public String toString() {
        return "[Rectangle: "+ this.origine+","+this.corner+"]";
    }
}
