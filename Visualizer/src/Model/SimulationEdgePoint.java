package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by rasmu on 09/02/2017.
 */
public class SimulationEdgePoint extends SimulationPoint implements Serializable{
    private String _source;
    private String _destination;

    public SimulationEdgePoint(double time, String source, String destination, double value, double previousValue) {
        super(source+"-"+destination, time, value, SimulationPointType.EdgePoint);
        this._source = source;
        this._destination = destination;
        this.setPreviousValue(previousValue);
    }

    public SimulationEdgePoint(double time, String source, String destination, double value) {
        this(time, source, destination, value, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SimulationEdgePoint that = (SimulationEdgePoint) o;

        if (!Objects.equals(getSource(), that.getSource())) return false;
        if (!Objects.equals(getDestination(), that.getDestination())) return false;
        return super.equals(that);
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String _source) {
        this._source = _source;
    }

    public String getDestination() {
        return _destination;
    }

    public void setDestination(String _destination) {
        this._destination = _destination;
    }
}
