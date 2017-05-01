package parsers.GPSLog;

import Helpers.GoogleMapsHelper;
import Helpers.Pair;
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
public class GPSLogNodes implements Iterable<GPSLogNode> {
    private Map<Integer, GPSLogNode> nodes = new HashMap<>();
    private LatLngBounds bounds;

    public GPSLogNodes() {}

    public void add(GPSLogNode node) {
        if (node == null)
            return;

        if (nodes.containsKey(node.nodeId))
            throw new IllegalArgumentException("Cannot add multiple nodes with same id. Tried to add new node with id: " + node.nodeId);

        nodes.put(node.nodeId, node);
        invalidateBounds();
    }

    private void invalidateBounds() {
        bounds = null;
    }

    public void addRange(Collection<GPSLogNode> nodeCollection) {
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

    private Double minValueFromList(Function<GPSLogNode, Double> mapper) {
        return Collections.min(nodes.values().stream().map(mapper).collect(Collectors.toList()));
    }

    private Double maxValueFromList(Function<GPSLogNode, Double> mapper) {
        return Collections.max(nodes.values().stream().map(mapper).collect(Collectors.toList()));
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
        for(GPSLogNode sn : nodes.values()) {
            Pair<Double, Double> xy = getLocationRelativeToBounds(sn);
            cellNodes.add(new CellNode(0, xy.getFirst(), xy.getSecond()));
        }

        return cellNodes;
    }

    private void addEdgesBetweenNeighborsToUPPAALTopology(UPPAALTopology uppaalTopology) {
        nodes.values().forEach(origin ->
                origin.neighbors.forEach(neighbor ->
                        uppaalTopology.add(new UPPAALEdge(String.valueOf(origin.nodeId), String.valueOf(neighbor)))));
    }

    private Pair<Double, Double> getLocationRelativeToBounds(GPSLogNode node) throws Exception {
        //Lat is y
        //Lng is x
        LatLng southWest = getBounds().getSouthWest();

        LatLng leftForNode = new LatLng(node.location.lat, southWest.lng);
        double x = GoogleMapsHelper.distanceBetween(node.location, leftForNode);

        LatLng belowNode = new LatLng(southWest.lat, node.location.lng);
        double y = GoogleMapsHelper.distanceBetween(node.location, belowNode);

        return new Pair<>(x,y);
    }

    @Override
    public void forEach(Consumer<? super GPSLogNode> action) {
        nodes.values().forEach(action);
    }

    @Override
    public Spliterator<GPSLogNode> spliterator() {
        return nodes.values().spliterator();
    }

    @Override
    public Iterator<GPSLogNode> iterator() {
        return nodes.values().iterator();
    }
}
