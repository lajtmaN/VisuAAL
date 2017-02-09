package Model;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.MultiGraph;

import java.util.*;

/**
 * Created by rasmu on 09/02/2017.
 */
public class UPPAALTopology extends ArrayList<UPPAALEdge> {
    private int _numberOfNodes;
    private Graph _graphInstance;

    public UPPAALTopology(int numberOfNodes) {
        this._numberOfNodes = numberOfNodes;
    }
    public UPPAALTopology() {
        this(0);
    }

    public int get_numberOfNodes() {
        return _numberOfNodes;
    }

    public void set_numberOfNodes(int _numberOfNodes) {
        this._numberOfNodes = _numberOfNodes;
    }

        public void updateGraph() {
        for (int i = 0; i < get_numberOfNodes(); i++) {
            addNodeToView(String.valueOf(i));
        }
        for (UPPAALEdge edge : this) {
            addEdgeToView(String.valueOf(edge.get_source()), String.valueOf(edge.get_destination()));
        }
    }

    private Edge addEdgeToView(String source, String destination){
        return getGraph(false).addEdge(source+destination, source, destination);
    }

    private Node addNodeToView(String id){
        return getGraph(false).addNode(id);
    }

    protected void markNode(Node node) {
        node.setAttribute("ui.class", "marked");
    }

    public Graph getGraph() { return getGraph(false); }
    public Graph getGraph(Boolean updateGraph) {
        if (_graphInstance == null) {
            _graphInstance = new MultiGraph("Topology with " + _numberOfNodes + " nodes");
            _graphInstance.setStrict(false);
            _graphInstance.addAttribute("ui.stylesheet", styleSheet);
            _graphInstance.setAutoCreate(true);
        }

        if (updateGraph)
            updateGraph();

        return _graphInstance;
    }

    protected String styleSheet =
            "node {" +
            "	fill-color: black;" +
            "}" +
            "node.marked {" +
            "	fill-color: red;" +
            "}";
}
