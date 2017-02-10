package parsers;

import Model.UPPAALEdge;
import Model.UPPAALTopology;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

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

    private UPPAALTopology generateTopology(int dimension){
        UPPAALTopology result = new UPPAALTopology(dimension*dimension);
        for(int y_index = 0; y_index < dimension; y_index++) {
            for(int x_index = 0; x_index < dimension; x_index++){
                int node_number = x_index+y_index*dimension;
                if(y_index != 0)
                    result.add(new UPPAALEdge(node_number, node_number-dimension));
                if(x_index != 0)
                    result.add(new UPPAALEdge(node_number, node_number-1));
                if (x_index != dimension-1)
                    result.add(new UPPAALEdge(node_number, node_number+1));
                if(y_index != dimension-1)
                    result.add(new UPPAALEdge(node_number, node_number+dimension));
            }
        }
        return result;
    }

    public void assertUPPAALTopology(UPPAALTopology expected, UPPAALTopology actual){
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.getNumberOfNodes(), actual.getNumberOfNodes());
        for (int i = 0; i < expected.size(); i++) {
            assertUPPAALEdge(expected.get(i), actual.get(i));
        }
    }

    public void assertUPPAALEdge(UPPAALEdge expected, UPPAALEdge actual) {
        assertEquals(expected.get_source(), actual.get_source());
        assertEquals(expected.get_destination(), actual.get_destination());
    }
}
