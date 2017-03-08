package Topology;

import Helpers.ConnectedGraphGenerator;
import Helpers.FileHelper;
import Helpers.TopologyHelper;
import Model.UPPAALTopology;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import org.graphstream.graph.*;
import parsers.CHandler;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void canSaveTopologyAndLoadAgain() throws IOException {
        UPPAALTopology topo = ConnectedGraphGenerator.generateRandomTopology(12);

        File tempFile = FileHelper.generateAutoDeletedTempFile("");
        TopologyHelper.saveTopology(tempFile, topo);

        List<String> linesInSavedFile = Files.readAllLines(tempFile.toPath());
        UPPAALTopology loadedTopo = CHandler.getTopologyFromInstantiation(String.join("\n", linesInSavedFile));

        assertEquals(topo, loadedTopo);
    }
}
