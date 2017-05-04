package Model;

/**
 * Created by batto on 02-May-17.
 */
public class SimulationMoveNodePoint extends SimulationPoint {
    Point pointValue, previousPointValue;

    public SimulationMoveNodePoint(String identifier, int time, Point value, Point previousValue) {
        super(identifier, time, 0, SimulationPointType.MoveNodePoint, 0);
        this.pointValue = value;
        this.previousPointValue = previousValue;
    }

    public Point getPointValue() {
        return pointValue;
    }

    public void setPointValue(Point pointValue) {
        this.pointValue = pointValue;
    }

    public Point getPreviousPointValue() {
        return previousPointValue;
    }

    public void setPreviousPointValue(Point previousPointValue) {
        this.previousPointValue = previousPointValue;
    }
}