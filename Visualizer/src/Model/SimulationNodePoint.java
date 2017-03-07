package Model;

import java.io.Serializable;

/**
 * Created by lajtman on 23-02-2017.
 */
public class SimulationNodePoint extends SimulationPoint implements Serializable {
    private int nodeId;

    public SimulationNodePoint(double time, int nodeId, double value, double previousValue) {
        super(String.valueOf(nodeId), time, value, SimulationPointType.NodePoint);
        this.nodeId = nodeId;
    }

    public SimulationNodePoint(double time, int nodeId, double value) {
        this(time, nodeId, value, 0);
    }

    public int getNodeId() {
        return nodeId;
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
