package parsers;

import Model.OutputVariable;
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

        assertEquals(6, vars.size());
        assertCVAR("CONFIG_NR_NODES", 64, vars.get(0));
        assertCVAR("CONFIG_NR_BEACON_SLOTS", 8, vars.get(1));
        assertCVAR("CONFIG_BEACON_PERIOD", 1000, vars.get(2));
        assertCVAR("CONFIG_MAX_DATA_OFFSET", 63, vars.get(3));
        assertCVAR("CONFIG_DATA_INTERVAL", 1000, vars.get(4));
        assertCVAR("CONFIG_DATA_DURATION", 1, vars.get(5));
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
        String expected1 = "OUTPUT_data_is_scheduled";
        String expected2 = "OUTPUT_nr_node_relations";
        ArrayList<CVar<Integer>> constants = new ArrayList<>();
        constants.add(new CVar<>("CONFIG_NR_NODES", 5));

        ArrayList<OutputVariable> outputVars = UPPAALParser.getUPPAALOutputVars("mac_model_test.xml", constants);

        assertEquals(expected1, outputVars.get(0).getName());
        assertEquals(expected2, outputVars.get(1).getName());
    }


    private <T> void assertCVAR(String expectedName, T expectedVal, CVar<T> actual) {
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedVal, actual.getValue());
    }
}
