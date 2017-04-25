package parsers.GPSLog;

import Model.topology.LatLng;

import java.util.List;

/**
 * Created by lajtman on 25-04-2017.
 */
public class SeedNode {
    public SeedNode(int nodeId, LatLng location, List<Integer> neighbors) {
        this.nodeId = nodeId;
        this.location = location;
        this.neighbors = neighbors;
    }

    public int nodeId;
    public LatLng location;
    public List<Integer> neighbors;
}
