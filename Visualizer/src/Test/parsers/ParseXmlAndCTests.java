package parsers;

import org.junit.Test;
import parsers.CHandler;
import Model.CVar;
import parsers.UPPAALParser;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


/**
 * Created by batto on 07-Feb-17.
 */
public class ParseXmlAndCTests {


    @Test
    public void getXmlDeclarationsTest() {
        ArrayList<CVar<Integer>> vars = UPPAALParser.getUPPAALConfigConstants("mac_model_test.xml");

        assertEquals(5, vars.size());
        assertCVAR("CONFIG_NR_BEACON_SLOTS", 8, vars.get(0));
        assertCVAR("CONFIG_BEACON_PERIOD", 1000, vars.get(1));
        assertCVAR("CONFIG_MAX_DATA_OFFSET", 63, vars.get(2));
        assertCVAR("CONFIG_DATA_INTERVAL", 1000, vars.get(3));
        assertCVAR("CONFIG_DATA_DURATION", 1, vars.get(4));
    }

    @Test
    public void parseDeclarationsTest() {
        String declarations = "const int abc = 123," +
                "CONFIG_dhj = 234;" +
                "\n const int CONFIG_abe = 456;";
        ArrayList<CVar<Integer>> vars = CHandler.getConstants(declarations);

        assertEquals(2, vars.size());
        assertCVAR("CONFIG_dhj", 234, vars.get(0));
        assertCVAR("CONFIG_abe", 456, vars.get(1));
    }

    @Test
    public void parseOutputDataIsScheduled() {
        String expected1 = "OUTPUT_data_is_scheduled[NR_NODES][NR_NODES]";
        String expected2 = "OUTPUT_nr_node_relations";
        ArrayList<String> outputVars = UPPAALParser.getUPPAALOutputVars("mac_model_test.xml");

        assertEquals(expected1, outputVars.get(0));
        assertEquals(expected2, outputVars.get(1));
    }


    private <T> void assertCVAR(String expectedName, T expectedVal, CVar<T> actual) {
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedVal, actual.getValue());
    }
}
