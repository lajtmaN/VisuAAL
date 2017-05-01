package parsers.GPSLog;

import Helpers.GoogleMapsHelper;
import Helpers.Pair;
import Model.TemplateUpdate;
import Model.UPPAALEdge;
import Model.UPPAALTopology;
import Model.topology.LatLng;
import Model.topology.LatLngBounds;
import Model.topology.generator.CellNode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogNodes {
    private Map<Integer, GPSLogNode> nodes = new HashMap<>();
    private LatLngBounds bounds;

    public GPSLogNodes() {}

    public void add(GPSLogEntry node) {
        if (node == null)
            return;

        if (!nodes.containsKey(node.nodeId)) {
            nodes.put(node.nodeId, new GPSLogNode(node.nodeId));
        }

        nodes.get(node.nodeId).add(node);

        invalidateBounds();
    }

    private void invalidateBounds() {
        bounds = null;
    }

    public void addRange(Collection<GPSLogEntry> nodeCollection) {
        nodeCollection.forEach(this::add);
    }

    public GPSLogNode getNode(int nodeId) {
        return nodes.get(nodeId);
    }

    public LatLngBounds getBounds() throws Exception {
        if (nodes.isEmpty())
            throw new Exception("Please add nodes before calculating the bounds");

        if (bounds == null)
            bounds = new LatLngBounds(southWestBounds(), northEastBounds());
        return bounds;
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

    private Double minValueFromList(Function<GPSLogEntry, Double> mapper) {
        double minScore = Double.MAX_VALUE;
        for (GPSLogNode nodeList : nodes.values()) {
            double minInList = nodeList.min(mapper);
            if (minScore > minInList)
                minScore = minInList;
        }
        return minScore;
    }

    private Double maxValueFromList(Function<GPSLogEntry, Double> mapper) {
        double maxScore = Double.MIN_VALUE;
        for (GPSLogNode nodeList : nodes.values()) {
            double maxInList = nodeList.max(mapper);
            if (maxScore < maxInList)
                maxScore = maxInList;
        }
        return maxScore;
    }

    public UPPAALTopology generateUPPAALTopologyWithBounds(LatLngBounds latLongBounds) throws Exception {
        bounds = latLongBounds;
        List<CellNode> cellNodes = generateCellNodes();
        UPPAALTopology uppaalTopology = new UPPAALTopology(cellNodes);

        addEdgesBetweenNeighborsToUPPAALTopology(uppaalTopology);
        invalidateBounds();

        return uppaalTopology;
    }

    private List<CellNode> generateCellNodes() throws Exception {
        List<CellNode> cellNodes = new ArrayList<>();
        List<GPSLogEntry> seedEntries = nodes.values().stream().map(nodes -> nodes.first()).collect(Collectors.toList());
        for (GPSLogEntry node : seedEntries) {
            Pair<Double, Double> xy = getLocationRelativeToBounds(node);
            cellNodes.add(new CellNode(0, xy.getFirst(), xy.getSecond()));
        }

        return cellNodes;
    }

    private void addEdgesBetweenNeighborsToUPPAALTopology(UPPAALTopology uppaalTopology) {
        List<GPSLogEntry> seedEntries = nodes.values().stream().map(nodes -> nodes.first()).collect(Collectors.toList());
        seedEntries.forEach(source ->
            source.neighbors.forEach(neighbor ->
                uppaalTopology.add(new UPPAALEdge(String.valueOf(source.nodeId), String.valueOf(neighbor)))));
    }

    private Pair<Double, Double> getLocationRelativeToBounds(GPSLogEntry node) throws Exception {
        //Lat is y
        //Lng is x
        LatLng southWest = getBounds().getSouthWest();

        LatLng leftForNode = new LatLng(node.location.lat, southWest.lng);
        double x = GoogleMapsHelper.distanceBetween(node.location, leftForNode);

        LatLng belowNode = new LatLng(southWest.lat, node.location.lng);
        double y = GoogleMapsHelper.distanceBetween(node.location, belowNode);

        return new Pair<>(x,y);
    }

    public void forEach(Consumer<? super GPSLogEntry> action) {
        nodes.values().forEach(nodeList -> nodeList.forEach(action));
    }

    public List<TemplateUpdate> getTopologyChanges() {
        List<TemplateUpdate> updates = new ArrayList<>();
        for (GPSLogNode nodeList : nodes.values()) {
            updates.addAll(nodeList.calculateTopologyChanges());
        }
        return updates;
    }
}
