package Model;

/**
 * Created by rasmu on 09/02/2017.
 */
public class SimulationEdgePoint extends DataPoint {
    private int _source;
    private int _destination;

    public SimulationEdgePoint(double time, int _source, int _destination, double value) {
        super(time, value);
        this._source = _source;
        this._destination = _destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SimulationEdgePoint that = (SimulationEdgePoint) o;

        if (getSource() != that.getSource()) return false;
        if (getClock() != that.getClock()) return false;
        if (getValue() != that.getValue()) return false;
        return getDestination() == that.getDestination();
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
