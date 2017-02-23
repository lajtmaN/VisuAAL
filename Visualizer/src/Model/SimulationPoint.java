package Model;

import java.io.Serializable;

/**
 * Created by lajtman on 23-02-2017.
 */
public abstract class SimulationPoint extends DataPoint implements Serializable {

    public enum SimulationPointType {
        EdgePoint, NodePoint
    }

    private SimulationPointType type;

    SimulationPoint(double time, double value, SimulationPointType pType) {
        super(time, value);
        type = pType;
    }

    abstract String getIdentifier();

    SimulationPointType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SimulationPoint that = (SimulationPoint) o;

        if (getClock() != that.getClock()) return false;
        if (getValue() != that.getValue()) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
