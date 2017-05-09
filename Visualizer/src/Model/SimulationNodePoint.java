package Model;

import java.io.Serializable;

/**
 * Created by lajtman on 23-02-2017.
 */
public class SimulationNodePoint extends SimulationPoint implements Serializable {
    private int nodeId;

    public SimulationNodePoint(String variableName, double time, int nodeId, double value, double previousValue) {
        super(variableName, time, value, SimulationPointType.NodePoint, previousValue);
        this.nodeId = nodeId;
    }

    public SimulationNodePoint(String variableName, double time, int nodeId, double value) {
        this(variableName, time, nodeId, value, 0);
    }

    public SimulationNodePoint(SimulationNodePoint sp) {
        this(sp.getIdentifier(), sp.getClock(), sp.getNodeId(), sp.getValue(), sp.getPreviousValue());
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) { this.nodeId = nodeId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SimulationNodePoint that = (SimulationNodePoint) o;

        if (nodeId != that.nodeId) return false;
        return super.equals(that);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + nodeId;
        return result;
    }
}
