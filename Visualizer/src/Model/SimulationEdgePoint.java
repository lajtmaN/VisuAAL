package Model;

import java.io.Serializable;

/**
 * Created by rasmu on 09/02/2017.
 */
public class SimulationEdgePoint extends SimulationPoint implements Serializable{
    private int _source;
    private int _destination;

    public SimulationEdgePoint(double time, int source, int destination, double value) {
        super(source+"-"+destination, time, value, SimulationPointType.EdgePoint);
        this._source = source;
        this._destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SimulationEdgePoint that = (SimulationEdgePoint) o;

        if (getSource() != that.getSource()) return false;
        if (getDestination() != that.getDestination()) return false;
        return super.equals(that);
    }

    public int getSource() {
        return _source;
    }

    public void setSource(int _source) {
        this._source = _source;
    }

    public int getDestination() {
        return _destination;
    }

    public void setDestination(int _destination) {
        this._destination = _destination;
    }
}
