package parsers.GPSLog;

import Helpers.GoogleMapsHelper;
import Helpers.Pair;
import Model.topology.LatLng;
import Model.topology.LatLngBounds;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 25-04-2017.
 */
public class SeedNodes implements Iterable<SeedNode> {
    private Map<Integer, SeedNode> nodes = new HashMap<>();
    private LatLngBounds bounds;

    public SeedNodes() {}

    public void add(SeedNode node) {
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

    public void addRange(Collection<SeedNode> nodeCollection) {
        nodeCollection.forEach(this::add);
    }

    public SeedNode getNode(int nodeId) {
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

    private Double minValueFromList(Function<SeedNode, Double> mapper) {
        return Collections.min(nodes.values().stream().map(mapper).collect(Collectors.toList()));
    }

    private Double maxValueFromList(Function<SeedNode, Double> mapper) {
        return Collections.max(nodes.values().stream().map(mapper).collect(Collectors.toList()));
    }

    public Graph asGraph() throws Exception {
        Graph graph = new MultiGraph("SeedNodes");
        addNodesToGraph(graph);
        addEdgesBetweenNeighborsToGraph(graph);
        setLocationOnNodesOnGraph(graph);

        return graph;
    }

    private void addNodesToGraph(Graph graph) {
        nodes.values().forEach(n -> graph.addNode(String.valueOf(n.nodeId)));
    }

    private void addEdgesBetweenNeighborsToGraph(Graph graph) {
        nodes.values().forEach(origin ->
                origin.neighbors.forEach(neighbor ->
                        graph.addEdge(origin.nodeId + "-" + neighbor,
                                origin.nodeId, neighbor, true)));
    }

    private void setLocationOnNodesOnGraph(Graph graph) throws Exception {
        for (SeedNode n : nodes.values()) {
            Pair<Double, Double> xy = getLocationRelativeToBounds(n);
            Node graphNode = graph.getNode(String.valueOf(n.nodeId));
            graphNode.setAttribute("xy", xy.getFirst(), xy.getSecond());
        }
    }

    private Pair<Double, Double> getLocationRelativeToBounds(SeedNode node) throws Exception {
        //Lat is y
        //Lng is x
        LatLng northEast = getBounds().getNorthEast();

        LatLng leftForNode = new LatLng(northEast.lat, node.location.lng);
        double x = GoogleMapsHelper.distanceBetween(node.location, leftForNode);

        LatLng aboveNode = new LatLng(node.location.lat, northEast.lng);
        double y = GoogleMapsHelper.distanceBetween(node.location, aboveNode);

        return new Pair<>(x,y);
    }

    @Override
    public void forEach(Consumer<? super SeedNode> action) {
        nodes.values().forEach(action);
    }

    @Override
    public Spliterator<SeedNode> spliterator() {
        return nodes.values().spliterator();
    }

    @Override
    public Iterator<SeedNode> iterator() {
        return nodes.values().iterator();
    }
}
