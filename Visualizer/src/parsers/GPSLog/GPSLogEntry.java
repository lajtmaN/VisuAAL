package parsers.GPSLog;

import Model.topology.LatLng;

import java.util.List;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogEntry {
    public GPSLogEntry(int timestamp, int nodeId, LatLng location, List<Integer> neighbors) {
        this.timestamp = timestamp;
        this.nodeId = nodeId;
        this.location = location;
        this.neighbors = neighbors;
    }

    public int timestamp;
    public int nodeId;
    public LatLng location;
    public List<Integer> neighbors;
}
