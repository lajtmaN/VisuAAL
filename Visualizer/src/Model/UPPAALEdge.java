package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by rasmu on 08/02/2017.
 */
public class UPPAALEdge implements Serializable {
    public String getSource() {
        return _source;
    }

    public String getDestination() {
        return _destination;
    }

    private String _source, _destination;
    public UPPAALEdge(String source, String destination) {
        _source = source;
        _destination = destination;
    }

    @Override
    public String toString() {
        return _source + "->"+ _destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPPAALEdge that = (UPPAALEdge) o;

        if (!_source.equals(that._source)) return false;
        return _destination.equals(that._destination);
    }

    @Override
    public int hashCode() {
        int result = _source.hashCode();
        result = 31 * result + _destination.hashCode();
        return result;
    }
}
