package Model;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;

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
            //addEdgeToView(String.valueOf(edge.get_source()), String.valueOf(edge.get_destination()));
        }
    }

    private void addEdgeToView(String source, String destination){
        getGraph(false).addEdge(source+destination, source, destination);
    }

    private void addNodeToView(String id){
        getGraph(false).addNode(id);
    }

    public Graph getGraph() { return getGraph(false); }
    public Graph getGraph(Boolean updateGraph) {
        if (_graphInstance == null) {
            _graphInstance = new MultiGraph("Topology with " + _numberOfNodes + " nodes");
        }

        if (updateGraph)
            updateGraph();

        return _graphInstance;
    }

    public void startAddingEdgesOverTime(SimulationEdgePoint[] edges) throws InterruptedException {
        //Take into account model time units
        long start = System.currentTimeMillis();
        for(SimulationEdgePoint s : edges) {
            double relativeTime = s.getClock() - System.currentTimeMillis();
            if(relativeTime <= 0) {
                addEdgeToView(String.valueOf(s.get_source()), String.valueOf(s.get_destination()));
            } else {
                Thread.sleep((long)relativeTime);
            }
        }
    }
}