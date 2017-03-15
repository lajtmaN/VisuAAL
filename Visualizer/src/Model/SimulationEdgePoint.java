package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by rasmu on 09/02/2017.
 */
public class SimulationEdgePoint extends SimulationPoint implements Serializable{
    private String _source;
    private String _destination;

    public SimulationEdgePoint(String identifier, double time, String source, String destination, double value, double previousValue) {
        super(identifier, time, value, SimulationPointType.EdgePoint, previousValue);
        this._source = source;
        this._destination = destination;
    }

    public SimulationEdgePoint(double time, String source, String destination, double value) {
        this(source + "-" + destination, time, source, destination, value, 0);
    }

    public String getEdgeIdentifier() {
        return _source + "-" + _destination;
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
