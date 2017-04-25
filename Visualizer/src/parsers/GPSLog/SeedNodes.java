package parsers.GPSLog;

import Model.topology.LatLng;
import Model.topology.LatLngBounds;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 25-04-2017.
 */
public class SeedNodes {
    private Map<Integer, SeedNode> nodes = new HashMap<>();

    public SeedNodes() {}

    public void add(SeedNode node) {
        if (node != null)
            nodes.put(node.nodeId, node);
    }

    public void addRange(Collection<SeedNode> nodeCollection) {
        nodeCollection.forEach(this::add);
    }

    public SeedNode getNode(int nodeId) {
        return nodes.get(nodeId);
    }

    public LatLngBounds getBounds() {
        return new LatLngBounds(southWestBounds(), northEastBounds());
    }

    private LatLng southWestBounds() {
        //Lat is y
        //Lng is x

        Double south = minValueFromList(n -> n.location.lat);
        Double west = minValueFromList(n -> n.location.lng);
        return new LatLng(south, west);
    }

    private LatLng northEastBounds() {
        Double north = maxValueFromList(n -> n.location.lat);
        Double east = maxValueFromList(n -> n.location.lng);
        return new LatLng(north, east);
    }

    private Double minValueFromList(Function<SeedNode, Double> mapper) {
        return Collections.min(nodes.values().stream().map(mapper).collect(Collectors.toList()));
    }

    private Double maxValueFromList(Function<SeedNode, Double> mapper) {
        return Collections.max(nodes.values().stream().map(mapper).collect(Collectors.toList()));
    }
}
