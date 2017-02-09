package Model;

/**
 * Created by rasmu on 08/02/2017.
 */
public class UPPAALEdge {
    public int get_source() {
        return _source;
    }

    public int get_destination() {
        return _destination;
    }

    private int _source, _destination;
    public UPPAALEdge(int source, int destination) {
        _source = source;
        _destination = destination;
    }

    @Override
    public String toString() {
        return _source + "->"+ _destination;
    }
}
