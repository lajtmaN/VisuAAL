package Model.topology.generator;

/**
 * Created by rasmu on 20/03/2017.
 */
public class CellNode {
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

    @Override
    public String toString() {
        return "CellNode{" +
                "range=" + range +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
