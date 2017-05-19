package parsers.GPSLog;

/**
 * Created by lajtman on 19-05-2017.
 */
public class GPSLogNeighbor {
    public GPSLogNeighbor(int neighborNodeID, int rssi) {
        this.neighborNodeID = neighborNodeID;
        this.rssi = rssi;
    }

    public int neighborNodeID;
    public int rssi;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GPSLogNeighbor that = (GPSLogNeighbor) o;

        if (neighborNodeID != that.neighborNodeID) return false;
        return rssi == that.rssi;
    }

    @Override
    public int hashCode() {
        int result = neighborNodeID;
        result = 31 * result + rssi;
        return result;
    }
}
