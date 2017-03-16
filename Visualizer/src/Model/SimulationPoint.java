package Model;

import java.io.Serializable;

/**
 * Created by lajtman on 23-02-2017.
 */
public class SimulationPoint extends DataPoint implements Serializable {
    public enum SimulationPointType {
        EdgePoint, NodePoint, Variable
    }

    private SimulationPointType type;
    private String identifier;
    private boolean shown = true;

    SimulationPoint(String identifier, double time, double value, SimulationPointType pType, double previousValue) {
        super(time, value, previousValue);
        type = pType;
        this.identifier = identifier;
    }

    public SimulationPoint(String identifier, double time, double value, double previousValue) {
        this(identifier, time, value, SimulationPointType.Variable, previousValue);
    }

    public SimulationPoint(String identifier, double time, double value) {
        this(identifier, time, value, 0);
    }

    public String getIdentifier() {
        return identifier;
    }

    SimulationPointType getType() {
        return type;
    }

    public boolean isShown() {
        return shown;
    }

    public void hide() {
        shown = false;
    }

    public void show() {
        shown = true;
    }

    public String getTrimmedIdentifier() {
        String s = getIdentifier();
        if(s.contains("."))
            s = s.split("\\.")[1];
        s = s.split("\\[")[0];
        return s;
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
