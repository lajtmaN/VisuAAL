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
    private ArrayList<SimulationEdgePoint> _edges;

    public UPPAALTopology(int numberOfNodes) {
        this._numberOfNodes = numberOfNodes;
    }
    public UPPAALTopology() {
        this(0);
    }

    public void setEdges(ArrayList<SimulationEdgePoint> edges){
        _edges = edges;
    }

    public int getNumberOfNodes() {
        return _numberOfNodes;
    }

    public void setNumberOfNodes(int _numberOfNodes) {
        this._numberOfNodes = _numberOfNodes;
    }

    public void updateGraph() {
        for (int i = 0; i < getNumberOfNodes(); i++) {
            addNode(String.valueOf(i));
        }
        for(SimulationEdgePoint s : _edges){
            if(s.getValue() == 1)
                addEdge(s);
        }
    }

    private Edge addEdge(SimulationEdgePoint s){
        //TODO: Currently only undirected
        Edge e = getGraph().getEdge(s.getIdentifier());
        if(e == null)
            return getGraph(false).addEdge(s.getIdentifier(), String.valueOf(s.getSource()),
                    String.valueOf(s.getDestination()), true);
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

    private Node addNode(String id){
        return getGraph(false).addNode(id);
    }

    protected void markNode(Node node) {
        node.setAttribute("ui.class", "marked");
    }

    protected void markEdge(SimulationEdgePoint s) {
        Edge edge = getGraph().getEdge(s.getIdentifier());
        if (edge != null){
            if(edge.getAttribute("ui.class") != "marked"){
                edge.setAttribute("ui.class", "marked");
            }
        }
    }

    protected void unmarkEdge(SimulationEdgePoint s) {
        Graph g = getGraph(false);
        Edge e = g.getEdge(s.getIdentifier());
        if(e != null){
            if(e.getAttribute("ui.class") != "unmarked"){
                e.setAttribute("ui.class", "unmarked");
            }
        }
    }

    public Graph getGraph() { return getGraph(false); }
    public Graph getGraph(Boolean updateGraph) {
        if (_graphInstance == null) {
            _graphInstance = new MultiGraph("Topology with " + _numberOfNodes + " nodes");
            _graphInstance.setStrict(false);
            _graphInstance.addAttribute("ui.stylesheet", styleSheet);
            _graphInstance.setAutoCreate(true);
            _graphInstance.addAttribute("ui.quality");
            _graphInstance.addAttribute("ui.antialias");
        }

        if (updateGraph)
            updateGraph();

        return _graphInstance;
    }

    public void startAddingEdgesOverTime(ArrayList<SimulationEdgePoint> edges) throws InterruptedException {
        //TODO: Take into account model time units
        long start = System.currentTimeMillis();
        for(SimulationEdgePoint s : edges) { //Assumed to be sorted on time.
            double relativeTime = s.getClock() - (System.currentTimeMillis() - start);
            while (relativeTime >= 0) {
                relativeTime = s.getClock() - (System.currentTimeMillis() - start);
                Thread.sleep(100);
            }
            if(s.getValue() == 1 ) {
                markEdge(s);
            }
            else {
                unmarkEdge(s);
            }
        }
    }
    protected String styleSheet =
            "node {" +
                    "	fill-color: black;" +
                    "}" +
            "node.marked {" +
                    "	fill-color: red;" +
                    "}" +
            "edge {" +
                    "   fill-color: rgba(0,0,0,32);" +
                    "}" +
            "edge.marked {" +
                    "   fill-color: red;"+
                    "}" +
            "edge.unmarked {"+
                    "   fill-color: rgba(0,0,0,32);" +
                    "}";
}