package Model;

import java.io.Serializable;

/**
 * Created by rasmu on 08/02/2017.
 */
public class UPPAALEdge implements Serializable, Comparable<UPPAALEdge> {
    public int getSource() {
        return _source;
    }

    public int getDestination() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPPAALEdge that = (UPPAALEdge) o;

        if (_source != that._source) return false;
        return _destination == that._destination;
    }

    @Override
    public int hashCode() {
        int result = _source;
        result = 31 * result + _destination;
        return result;
    }

    @Override
    public int compareTo(UPPAALEdge o) {
        if(this.getSource() < o.getSource()
                || this.getSource() == o.getSource()
                && this.getDestination() < o.getDestination())
            return -1;
        else if(this.getSource() == o.getSource() && this.getDestination() == o.getDestination())
            return 0;
        else return 1;
    }
}