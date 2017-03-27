package Model;

import Model.topology.generator.CellNode;
import org.graphstream.graph.*;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.MultiGraph;

import java.io.Serializable;
import java.util.*;

/**
 * Created by rasmu on 09/02/2017.
 */
public class UPPAALTopology extends ArrayList<UPPAALEdge> implements Serializable {
    private int _numberOfNodes;
    private transient Graph _graphInstance;
    private List<CellNode> nodes;

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

    public UPPAALTopology(List<CellNode> cellNodes) {
        this(cellNodes.size());
        nodes = cellNodes;
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
        //TODO: Currently only undirected
        Edge e = getGraph().getEdge(s.getIdentifier());
        if(e == null)
            return getGraph(false).addEdge(s.getIdentifier(), s.getSource(),
                    s.getDestination(), true);
        else return e;
    }
    private Edge removeEdge(SimulationEdgePoint s) {
        Graph g = getGraph(false);
        Edge e = g.getEdge(s.getIdentifier());
        if(e == null){
            return e;
        }
        return g.removeEdge(e);
    }

    protected void handleUpdate(SimulationPoint s, boolean mark) {
        mark &= s.isShown();

        switch (s.getType()) {
            case EdgePoint:
                handleEdgeEdit((SimulationEdgePoint) s, mark);
                break;
            case NodePoint:
                handleNodeEdit((SimulationNodePoint) s, mark);
                break;
        }
    }

    private void handleNodeEdit(SimulationNodePoint point, boolean mark) {
        Node node = getGraph().getNode(point.getNodeId());
        if (node == null) return;
        if (mark)
            markNode(node);
        else
            unmarkNode(node);
    }

    protected void handleEdgeEdit(SimulationEdgePoint s, boolean mark) {
        Edge edge = getGraph().getEdge(s.getEdgeIdentifier());
        if (edge == null)
            return;
        if (mark){
            markEdge(edge);
        }
        else {
            unmarkEdge(edge);
        }
    }

    protected void markEdge(Edge edge) {
        if(edge.getAttribute("ui.class") != "marked"){
            edge.setAttribute("ui.class", "marked");
        }
    }

    protected void unmarkAllEdges() {
        for (Edge e : getGraph().getEdgeSet())
            e.setAttribute("ui.class", "unmarked");
    }

    protected void unmarkEdge(Edge edge) {
        if(edge.getAttribute("ui.class") != "unmarked"){
            edge.setAttribute("ui.class", "unmarked");
        }
    }

    private Node addNode(Integer id){
        Node graphNode = getGraph(false).addNode(String.valueOf(id));
        showLabelOnNode(graphNode, String.valueOf(id));
        if (nodesHasSpecificLocations()) {
            graphNode.setAttribute("xy", nodes.get(id).getX(), nodes.get(id).getY());
        }
        return graphNode;
    }

    private void showLabelOnNode(Node n, String nodeName) {
        n.addAttribute("ui.label", nodeName);
    }

    protected void markNode(Node node) {
        if(node.getAttribute("ui.class") != "marked") {
            node.setAttribute("ui.class", "marked");
        }
    }

    protected void unmarkNode(Node node) {
        if(node.getAttribute("ui.class") != "unmarked"){
            node.setAttribute("ui.class", "unmarked");
        }
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

    public boolean nodesHasSpecificLocations() {
        return nodes != null;
    }

    private void initializeGraph() {
        _graphInstance.setStrict(false);
        _graphInstance.addAttribute("ui.stylesheet", styleSheet);
        _graphInstance.setAutoCreate(true);
        _graphInstance.addAttribute("ui.quality");
        _graphInstance.addAttribute("ui.antialias");
    }

    protected String styleSheet =
            "graph {" +
                    "fill-color: rgba(0,0,0,0);" +
                    "padding: 0,0;" +
                    "}" +
            "node {" +
                    "	fill-color: black;" +
                    "   text-alignment: under;" +
                    "   text-background-mode: rounded-box;" +
                    "}" +
            "node.marked {" +
                    "	fill-color: red;" +
                    "}" +
            "node.unmarked {"+
                    "   fill-color: black;" +
                    "}"+
            "edge {" +
                    "   fill-color: rgba(0,0,0,32);" +
                    "}" +
            "edge.marked {" +
                    "   fill-color: red;"+
                    "}" +
            "edge.unmarked {"+
                    "   fill-color: rgba(0,0,0,32);" +
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