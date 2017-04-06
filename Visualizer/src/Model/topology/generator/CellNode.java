package Model.topology.generator;

import java.io.Serializable;

/**
 * Created by rasmu on 20/03/2017.
 */
public class CellNode implements Serializable {
    double range;
    double x;
    double y;

    public CellNode(double range, double x, double y) {
        this.range = range;
        this.x = x;
        this.y = y;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isInRange(CellNode node2) {
        double nodeDistance = Math.pow(this.getX() - node2.getX(), 2) + Math.pow(this.getY() - node2.getY(), 2);
        return (Math.pow(this.getRange(), 2) > nodeDistance);
    }

    public static boolean isInRange(CellNode node1, CellNode node2) {
        return node1.isInRange(node2);
    }

    @Override
    public String toString() {
        return "CellNode{" +
                "range=" + range +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
