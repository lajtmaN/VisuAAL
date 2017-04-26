package Topology;

import Helpers.ConnectedGraphGenerator;
import Helpers.FileHelper;
import Helpers.Pair;
import Helpers.TopologyHelper;
import Model.UPPAALTopology;
import Model.topology.generator.CellNode;
import Model.topology.generator.GlobalOptions;
import Model.topology.generator.TopologyGenerator;
import jdk.nashorn.internal.objects.Global;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.graphstream.graph.*;
import parsers.CHandler;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void generateNodesOneCellForTopologyGenerator() {
        TopologyGenerator topologyGenerator = new TopologyGenerator();
        topologyGenerator.getOptions().setAvgNodesPrCell(4);
        topologyGenerator.getOptions().setNodesCellDeviation(0.5);

        ArrayList<CellNode> nodes = topologyGenerator.generateNodesForCell(0,0);
        assertNotNull(nodes);
    }

    @Test
    public void generate100NodeDistributions() {
        int sum = 0, numRuns = 100;
        TopologyGenerator topologyGenerator = new TopologyGenerator();
        int xCells = 4;
        int yCells = 4;
        int avgNodesPerCell = 4;
        topologyGenerator.getOptions().setCellX(xCells);
        topologyGenerator.getOptions().setCellY(yCells);

        topologyGenerator.getOptions().setAvgNodesPrCell(avgNodesPerCell);
        topologyGenerator.getOptions().setNodesCellDeviation(0.5);

        topologyGenerator.initializeNewCellOptions(xCells,yCells);

        for(int i = 0; i< numRuns; i++) {
            sum+=topologyGenerator.generateNodes().size();
        }

        //If we have more than 1000 deviation from average, assume something is wrong. This might have to be fiddled with.
        int DELTA=640;//Expected 6400
        assertIntDelta(xCells*yCells*avgNodesPerCell*numRuns, sum, DELTA);
    }

    @Test
    public void generateNodesForTopologyGenerator() {
        TopologyGenerator topologyGenerator = new TopologyGenerator();
        topologyGenerator.getOptions().setAvgNodesPrCell(4);
        topologyGenerator.getOptions().setNodesCellDeviation(0.5);

        ArrayList<CellNode> nodes = topologyGenerator.generateNodes();
        assertNotNull(nodes);
    }

    @Test
    public void generateTopologyFromDistributions() {
        TopologyGenerator topologyGenerator = new TopologyGenerator();

        topologyGenerator.getOptions().setAvgNodesPrCell(1);
        topologyGenerator.getOptions().setNodesCellDeviation(0.5);
        topologyGenerator.getOptions().setAvgRange(1);
        topologyGenerator.getOptions().setRangeDeviation(0);
        topologyGenerator.initializeNewCellOptions(4,4);

        UPPAALTopology topo = topologyGenerator.generateUppaalTopology();
        assertNotNull(topo);
    }

    @Test
    public void generate100EdgeDistributions() {
        int sum = 0, numRuns = 100;
        TopologyGenerator topologyGenerator = new TopologyGenerator();
        int xCells = 2;
        int yCells = 2;
        int avgNodesPerCell = 2;
        topologyGenerator.getOptions().setCellX(xCells);
        topologyGenerator.getOptions().setCellY(yCells);

        topologyGenerator.getOptions().setAvgNodesPrCell(avgNodesPerCell);
        topologyGenerator.getOptions().setNodesCellDeviation(0);

        topologyGenerator.getOptions().setAvgRange(1);
        topologyGenerator.getOptions().setRangeDeviation(0);

        topologyGenerator.initializeNewCellOptions(xCells,yCells);

        for(int i = 0; i< numRuns; i++) {
            sum+=topologyGenerator.generateUppaalTopology().size();
        }

        int DELTA=280;//Expected 2400
        assertIntDelta(3*8*numRuns, sum, DELTA);
    }

    @Test
    public void generate100EdgeDistributions3by3() {
        int sum = 0, numRuns = 100;
        TopologyGenerator topologyGenerator = new TopologyGenerator();
        int xCells = 3;
        int yCells = 3;
        int avgNodesPerCell = 2;
        topologyGenerator.getOptions().setCellX(xCells);
        topologyGenerator.getOptions().setCellY(yCells);

        topologyGenerator.getOptions().setAvgNodesPrCell(avgNodesPerCell);
        topologyGenerator.getOptions().setNodesCellDeviation(0);

        topologyGenerator.getOptions().setAvgRange(1);
        topologyGenerator.getOptions().setRangeDeviation(0);

        topologyGenerator.initializeNewCellOptions(xCells,yCells);

        for(int i = 0; i< numRuns; i++) {
            sum+=topologyGenerator.generateUppaalTopology().size();
        }

        int DELTA=660;//Expected 6600
        //4 corners: 3 nodes
        //4 edges: 4 nodes
        //1 middle: 5 nodes
        assertIntDelta(((4*3+4*4+1*5)*2*numRuns), sum, DELTA);
    }

    @Test
    public void nodesPlacedCorrectlyWhenGridInMetersAreChanged() {
        TopologyGenerator gen = new TopologyGenerator();
        gen.setCellWidthInMeters(500);
        gen.setCellHeightInMeters(500);
        List<CellNode> nodes = gen.generateNodesForCell(1,2);
        assertFalse(nodes.isEmpty());
        for (CellNode n : nodes) {
            assertTrue("x position too low: " + n.getX(), n.getX() > 500);
            assertTrue("x position too high: " + n.getX(), n.getX() < 1000);
            assertTrue("y position too low: " + n.getY(), n.getY() > 1000);
            assertTrue("y position too high: " + n.getY(), n.getY() < 1500);
        }
    }

    private void assertIntDelta(int expected, int actual, int DELTA) {
        assertTrue("Too few: e: "+ expected + " a: " + actual, expected > actual - DELTA);
        assertTrue("Too many: e: "+ expected + " a: " + actual,expected < actual + DELTA);
    }
}
