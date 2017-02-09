package Topology;

import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.junit.Test;

import org.graphstream.graph.*;

/**
 * Created by lajtman on 09-02-2017.
 */
public class TopologyTests {
    @Test
    public void canGenerateGraph() {
        Graph graph = new SingleGraph("test");
        graph.addNode("A" );
        graph.addNode("B" );
        graph.addNode("C" );
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
    }
}
