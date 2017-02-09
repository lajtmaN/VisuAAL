package Model;

/**
 * Created by rasmu on 09/02/2017.
 */
public class SimulationEdgePoint extends DataPoint {
    private int _source;
    private int _destination;

    public SimulationEdgePoint(int _source, int _destination) {
        this._source = _source;
        this._destination = _destination;
    }

    public int get_source() {
        return _source;
    }

    public void set_source(int _source) {
        this._source = _source;
    }

    public int get_destination() {
        return _destination;
    }

    public void set_destination(int _destination) {
        this._destination = _destination;
    }
}
