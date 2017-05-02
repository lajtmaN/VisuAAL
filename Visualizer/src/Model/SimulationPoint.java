package Model;

import java.io.Serializable;

/**
 * Created by lajtman on 23-02-2017.
 */
public class SimulationPoint extends DataPoint implements Serializable, Comparable<SimulationPoint> {
    public enum SimulationPointType {
        EdgePoint, NodePoint, Variable, MoveNodePoint;
    }
    private SimulationPointType type;

    private String identifier;
    private boolean variableShown = true; //Should match output_variable shown property default
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

    public boolean isShown(double currentTime) {
        return variableShown && getClock() <= currentTime;
    }

    public void hideVariable() {
        variableShown = false;
    }

    public void showVariable() {
        variableShown = true;
    }

    public String getTrimmedIdentifier() {
        String s = getIdentifier();
        if(s.contains("."))
            s = s.split("\\.")[1];
        s = s.split("\\[")[0];
        return s;
    }

    public String getScopedIdentifier() {
        String s = getIdentifier();
        s = s.replaceAll("\\(\\d+\\)", "");
        s = s.replaceAll("\\[\\d+\\]", "");
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

    @Override
    public int compareTo(SimulationPoint o) {
        return Double.compare(this.getClock(), o.getClock());
    }
}
