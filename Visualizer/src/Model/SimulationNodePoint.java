package Model;

import java.io.Serializable;

/**
 * Created by lajtman on 23-02-2017.
 */
public class SimulationNodePoint extends SimulationPoint implements Serializable {
    private int nodeId;

    public SimulationNodePoint(double time, int node, double value) {
        super(time, value, SimulationPointType.NodePoint);
        nodeId = node;
    }

    public int getNodeId() {
        return nodeId;
    }

    public String getIdentifier() {
        return String.valueOf(nodeId);
    }

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
