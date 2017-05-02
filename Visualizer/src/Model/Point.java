package Model;

import java.io.Serializable;

/**
 * Created by batto on 01-May-17.
 */
public class Point implements Serializable {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}