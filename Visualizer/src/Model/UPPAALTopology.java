package Model;

import Model.topology.generator.CellNode;
import javafx.scene.image.Image;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.Element;
import org.graphstream.graph.implementations.MultiGraph;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasmu on 09/02/2017.
 */
public class UPPAALTopology extends ArrayList<UPPAALEdge> implements Serializable {
    private int _numberOfNodes;
    private transient Graph _graphInstance;
    private List<CellNode> nodes;
    private String backgroundFilePath;

    public UPPAALTopology(Graph graph) {
        _graphInstance = graph;
        initializeGraph();
        this._numberOfNodes = graph.getNodeCount();
        for(Edge edge : _graphInstance.getEachEdge()){
            add(new UPPAALEdge(edge.getSourceNode().getId(), edge.getTargetNode().getId()));
        }
    }

    public UPPAALTopology(int numberOfNodes) {
        _numberOfNodes = numberOfNodes;
    }

    public UPPAALTopology(List<CellNode> cellNodes, String backgroundFilePath) {
        this(cellNodes.size());
        nodes = cellNodes;
        this.backgroundFilePath = backgroundFilePath;
    }

    public UPPAALTopology() {}

    public int getNumberOfNodes() {
        return _numberOfNodes;
    }

    public void setNumberOfNodes(int _numberOfNodes) {
        this._numberOfNodes = _numberOfNodes;
    }

    public void updateGraph() {
        for (int i = 0; i < getNumberOfNodes(); i++) {
            addNode(i);
        }
        for(UPPAALEdge s : this){
            SimulationEdgePoint sep = new SimulationEdgePoint(0, s.getSource(), s.getDestination(), 1);
            addEdge(sep);
        }
    }

    private Edge addEdge(SimulationEdgePoint s){
        Edge e = getGraph().getEdge(s.getIdentifier());
        if(e != null)
            return e;

        Edge newEdge = getGraph(false).addEdge(s.getIdentifier(), s.getSource(), s.getDestination(), true);
        return newEdge;
    }
    private Edge removeEdge(SimulationEdgePoint s) {
        Graph g = getGraph(false);
        Edge e = g.getEdge(s.getIdentifier());
        if(e == null){
            return e;
        }
        return g.removeEdge(e);
    }

    /**
     * Updates the gradient for the node
     * @param nodeId
     * @param gradientValue between 0 and 1
     */
    public void updateNodeGradient(int nodeId, double gradientValue) {
        Element e = getGraph().getNode(nodeId);
        if (e != null)
            markGradientElement(e, gradientValue);
    }

    /**
     * Updates the gradient for the edge
     * @param edgeIdentifier
     * @param gradientValue between 0 and 1
     */
    public void updateEdgeGradient(String edgeIdentifier, double gradientValue) {
        Element e = getGraph().getEdge(edgeIdentifier);
        if (e != null)
            markGradientElement(e, gradientValue);
    }

    private void markGradientElement(Element e, double gradientValue) { e.setAttribute("ui.color", gradientValue); }
    private void unmarkElement(Element e) { e.setAttribute("ui.color", 0.0);}
    private void markElement(Element e) { e.setAttribute("ui.color", 1.0); }

    public void unmarkAllNodes() {
        for(Node n : getGraph().getNodeSet())
            unmarkElement(n);
    }

    protected void unmarkAllEdges() {
        for (Edge e : getGraph().getEdgeSet())
            unmarkElement(e);
    }

    private Node addNode(Integer id){
        Node graphNode = getGraph(false).addNode(String.valueOf(id));
        showLabelOnNode(graphNode, String.valueOf(id));
        if (nodesHasSpecificLocations()) {
            graphNode.addAttribute("layout.frozen");
            graphNode.setAttribute("xyz", nodes.get(id).getX(), nodes.get(id).getY(), 0);
        }
        return graphNode;
    }

    private void showLabelOnNode(Node n, String nodeName) {
        n.addAttribute("ui.label", nodeName);
    }

    public Graph getGraph() { return getGraph(false); }
    public Graph getGraph(Boolean updateGraph) {
        if (_graphInstance == null) {
            _graphInstance = new MultiGraph("Topology with " + _numberOfNodes + " nodes");
            initializeGraph();
        }

        if (updateGraph)
            updateGraph();

        return _graphInstance;
    }

    public String getBackgroundFilePath() {
        return backgroundFilePath;
    }

    public Image getBackgroundImage() throws IOException {
        return new Image(new File(backgroundFilePath).toURI().toString());
    }

    public boolean nodesHasSpecificLocations() {
        return nodes != null;
    }

    /**
     * If the topology has been generated with nodes on a special location, they will be returned in this method
     * @return List of Nodes which has range, x, y, all measured in meters
     */
    public List<CellNode> getNodesWithSpecificLocation() {
        return nodes;
    }

    private void initializeGraph() {
        _graphInstance.setStrict(false);
        setDefaultColors();
        _graphInstance.setAutoCreate(true);
        _graphInstance.addAttribute("ui.quality");
        _graphInstance.addAttribute("ui.antialias");
    }

    public void setDefaultColors() {
        changeColors(null, null, null, null);
    }

    public void changeColors(String nodeFromColor, String nodeToColor,
                             String edgeFromColor, String edgeToColor) {

        String stylesheet = String.format(styleSheet,
                nodeFromColor == null ? "black" : nodeFromColor,
                nodeToColor == null ? "red" : nodeToColor,
                edgeFromColor == null ? "white" : edgeFromColor,
                edgeToColor == null ? "red" : edgeToColor);

        _graphInstance.setAttribute("ui.stylesheet", stylesheet);
    }

    protected String styleSheet =
            "graph {" +
                    "fill-color: rgba(0,0,0,0);" +
                    "padding: 0,0;" +
                    "}" +
            "node {" +
                    "   fill-mode: dyn-plain;" +
                    "   fill-color: %s, %s;" +
                    "   text-alignment: under;" +
                    "   text-background-mode: rounded-box;" +
                    "}" +
            "edge {" +
                    "fill-mode: dyn-plain;" +
                    "fill-color: %s, %s;" +
                    "}";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        UPPAALTopology that = (UPPAALTopology) o;

        if (_numberOfNodes != that._numberOfNodes) return false;
        return nodes != null ? nodes.equals(that.nodes) : that.nodes == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + _numberOfNodes;
        result = 31 * result + (nodes != null ? nodes.hashCode() : 0);
        return result;
    }
}