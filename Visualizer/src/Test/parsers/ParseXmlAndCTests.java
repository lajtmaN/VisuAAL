package parsers;

import Helpers.FileHelper;
import Model.OutputVariable;
import org.junit.Test;
import Model.CVar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by batto on 07-Feb-17.
 */
public class ParseXmlAndCTests {


    @Test
    public void getXmlDeclarationsTest() {
        ArrayList<CVar<Integer>> vars = UPPAALParser.getUPPAALConfigConstants("mac_model_test.xml");

        assertEquals(6, vars.size());
        assertCVAR(null, "CONFIG_NR_NODES", 64, vars.get(0));
        assertCVAR(null, "CONFIG_NR_BEACON_SLOTS", 8, vars.get(1));
        assertCVAR(null, "CONFIG_BEACON_PERIOD", 1000, vars.get(2));
        assertCVAR(null, "CONFIG_MAX_DATA_OFFSET", 63, vars.get(3));
        assertCVAR(null, "CONFIG_DATA_INTERVAL", 1000, vars.get(4));
        assertCVAR(null, "CONFIG_DATA_DURATION", 1, vars.get(5));
    }

    @Test
    public void parseDeclarationsTest() {
        String declarations = "const int CONFIG_abc = 123," +
                "dhj = 234;" +
                "\n const int CONFIG_abe = 456;";
        ArrayList<CVar<Integer>> vars = CHandler.getConfigVariables(declarations);

        assertEquals(2, vars.size());
        assertCVAR(null, "CONFIG_abc", 123, vars.get(0));
        assertCVAR(null, "CONFIG_abe", 456, vars.get(1));
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

    @Test
    public void updateVariableInText() {
        String decls = "<nta><declaration>\n" +
                "const int CONFIG_NR_NODES_SQR_ROOT = 4,\n" +
                "          CONFIG_NR_NODES = 16,\n" +
                "          NR_BEACON_SLOTS = 8,\n" +
                "          MAX_BEACON_NUMBER = 17;\n" +
                "const int BEACON_PERIOD = 1000,\n" +
                "          BEACON_SLOT = 1,\n" +
                "          BEACON_SCAN = BEACON_SLOT * NR_BEACON_SLOTS,\n" +
                "          BEACON_SCAN_INTERVAL = 500,\n" +
                "          MAX_INIT_DELAY = 512,\n" +
                "          MAX_DATA_OFFSET = 63, // Multiplied later by 4 to get mS\n" +
                "          DATA_INTERVAL = 1000,\n" +
                "          DATA_DURATION = 1;\n" +
                "</declaration></nta>";
        ArrayList<CVar<Integer>> orginalVars = CHandler.getConfigVariables(decls);
        assertEquals(2, orginalVars.size());
        assertCVAR(null, "CONFIG_NR_NODES_SQR_ROOT", 4, orginalVars.get(0));
        assertCVAR(null, "CONFIG_NR_NODES", 16, orginalVars.get(1));

        //Update "XML" with new value to CONFIG_NR_NODES
        String actual = CHandler.updateIntConfigVar("CONFIG_NR_NODES", 300, decls);

        ArrayList<CVar<Integer>> updatedVars = CHandler.getConfigVariables(actual);
        assertEquals(2, updatedVars.size());
        assertCVAR(null, "CONFIG_NR_NODES_SQR_ROOT", 4, updatedVars.get(0));
        assertCVAR(null, "CONFIG_NR_NODES", 300, updatedVars.get(1));

    }

    @Test
    public void updateVariablesInXMLFile() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("topologytest.xml"));
        ArrayList<CVar<Integer>> orgConfigs = UPPAALParser.getUPPAALConfigConstants(f.getPath());
        assertEquals(3, orgConfigs.size());

        assertTrue(orgConfigs.contains(new CVar<>(null,"CONFIG_TESTING_CONSTANT", 1337)));
        assertTrue(orgConfigs.contains(new CVar<>("Template", "CONFIG_LOCAL", 123)));
        assertTrue(orgConfigs.contains(new CVar<>("Template2", "CONFIG_LOCAL2", 123)));


        //Update value on config var
        CVar<Integer> updatedCVar = orgConfigs.get(
                orgConfigs.indexOf(new CVar<>(null, "CONFIG_TESTING_CONSTANT", 1337)));
        updatedCVar.setValue(1000);
        CVar<Integer> updatedLocalCVar = orgConfigs.get(
                orgConfigs.indexOf(new CVar<>("Template", "CONFIG_LOCAL", 123)));
        updatedLocalCVar.setValue(999);
        UPPAALParser.updateUPPAALConfigConstants(f.getPath(), orgConfigs);

        //assert updated
        ArrayList<CVar<Integer>> updatedConfigs = UPPAALParser.getUPPAALConfigConstants(f.getPath());
        assertEquals(3, updatedConfigs.size());

        assertTrue(updatedConfigs.contains(new CVar<>(null, "CONFIG_TESTING_CONSTANT", 1000)));
        assertTrue(updatedConfigs.contains(new CVar<>("Template", "CONFIG_LOCAL", 999)));
        assertTrue(updatedConfigs.contains(new CVar<>("Template2", "CONFIG_LOCAL2", 123)));
    }

    @Test
    public void parseLocalConfigVarsInXMLFile() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("topologytest.xml"));
        ArrayList<CVar<Integer>> vars = UPPAALParser.getUPPAALConfigConstants(f.getPath());
        assertEquals(3, vars.size());
        assertTrue(vars.contains(new CVar<>(null, "CONFIG_TESTING_CONSTANT", 1337)));
        assertTrue(vars.contains(new CVar<>("Template", "CONFIG_LOCAL", 123)));
        assertTrue(vars.contains(new CVar<>("Template2", "CONFIG_LOCAL2", 123)));
    }

    private <T> void assertCVAR(String expectedScope, String expectedName, T expectedVal, CVar<T> actual) {
        assertEquals(expectedScope, actual.getScope());
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedVal, actual.getValue());
    }
}
