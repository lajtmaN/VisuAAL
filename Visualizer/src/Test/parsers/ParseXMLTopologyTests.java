package parsers;

import Helpers.ConnectedGraphGenerator;
import Model.UPPAALEdge;
import Model.UPPAALTopology;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by rasmu on 08/02/2017.
 */
public class ParseXMLTopologyTests {

    @Test
    public void parse3by3Topology() {
        String uppaalFileName = "topologytest.xml";
        UPPAALTopology expected = generateTopology(3);
        UPPAALTopology actual = UPPAALParser.getUPPAALTopology(uppaalFileName);
        assertUPPAALTopology(expected, actual);
    }

    @Test
    public void generateSquareTopology() throws InterruptedException {
        String uppaalFileName = "topologytest.xml";
        UPPAALTopology expected = UPPAALParser.getUPPAALTopology(uppaalFileName);
        UPPAALTopology actual = ConnectedGraphGenerator.generateSquareTopology(3);
        assertUPPAALTopology(expected, actual);
    }

    @Test
    public void generateRandomTopologyCorrectSize() throws InterruptedException {
        int expectedSize = 20;
        UPPAALTopology topo = ConnectedGraphGenerator.generateRandomTopology(expectedSize);
        assertEquals(expectedSize, topo.getNumberOfNodes());
    }

    @Test
    public void generateRandomTopologyOnSize3Allowed() {
        assertNotNull(ConnectedGraphGenerator.generateRandomTopology(3));
    }

    @Test
    public void generateRandomTopologyThrowsExceptionFor2Nodes() {
        UPPAALTopology topo = Helpers.ConnectedGraphGenerator.generateRandomTopology(2);

        assertEquals(2, topo.getGraph().getNodeCount());
        assertEquals("0", topo.getGraph().getNode(0).getId());
        assertEquals("1", topo.getGraph().getNode(1).getId());
        assertEquals(1, topo.getGraph().getEdgeCount());
        assertEquals("0-1", topo.getGraph().getEdge(0).getId());
    }

    @Test
    public void generateRandomTopologyThrowsExceptionFor1Node() {
        UPPAALTopology topo = Helpers.ConnectedGraphGenerator.generateRandomTopology(1);

        assertEquals(1, topo.getGraph().getNodeCount());
        assertEquals("0", topo.getGraph().getNode(0).getId());
        assertEquals(0, topo.getGraph().getEdgeCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateRandomTopologyThrowsExceptionFor0Nodes() {
        ConnectedGraphGenerator.generateRandomTopology(0);
    }

    private UPPAALTopology generateTopology(int dimension){
        UPPAALTopology result = new UPPAALTopology();
        result.setNumberOfNodes(dimension*dimension);
        for(int y_index = 0; y_index < dimension; y_index++) {
            for(int x_index = 0; x_index < dimension; x_index++){
                int node_number = x_index+y_index*dimension;
                if(y_index != 0)
                    result.add(new UPPAALEdge(String.valueOf(node_number), String.valueOf(node_number-dimension)));
                if(x_index != 0)
                    result.add(new UPPAALEdge(String.valueOf(node_number), String.valueOf(node_number-1)));
                if (x_index != dimension-1)
                    result.add(new UPPAALEdge(String.valueOf(node_number), String.valueOf(node_number+1)));
                if(y_index != dimension-1)
                    result.add(new UPPAALEdge(String.valueOf(node_number), String.valueOf(node_number+dimension)));
            }
        }
        return result;
    }

    public void assertUPPAALTopology(UPPAALTopology expected, UPPAALTopology actual){
        assertEquals("Number of edges", expected.size(), actual.size());
        assertEquals("Number of nodes", expected.getNumberOfNodes(), actual.getNumberOfNodes());
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(actual.contains(expected.get(i)));
        }
    }
}
