package parsers;

import Helpers.FileHelper;
import Model.OutputVariable;
import Model.UPPAALModel;
import com.sun.org.apache.xerces.internal.xni.XMLDTDHandler;
import org.junit.Test;
import Model.CVar;
import org.xml.sax.SAXException;
import scala.xml.XML;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


/**
 * Created by batto on 07-Feb-17.
 */
public class ParseXmlAndCTests {


    @Test
    public void getXmlDeclarationsTest() {
        ArrayList<CVar> vars = UPPAALParser.getUPPAALConfigConstants("mac_model_test.xml");

        assertEquals(12, vars.size());
        int i = 0;
        assertGlobalCVar("CONFIG_TEST_BOOLEAN", "true", vars.get(i++));
        assertGlobalCVar("CONFIG_TEST_DOUBLE", "0.5", vars.get(i++));
        assertGlobalCVar("CONFIG_NR_NODES", 36, vars.get(i++));
        assertGlobalCVar("CONFIG_NR_BEACON_SLOTS", 8, vars.get(i++));
        assertGlobalCVar("CONFIG_BEACON_PERIOD", 1000, vars.get(i++));
        assertGlobalCVar("CONFIG_MAX_DATA_OFFSET", 63, vars.get(i++));
        assertGlobalCVar("CONFIG_DATA_INTERVAL", 1000, vars.get(i++));
        assertGlobalCVar("CONFIG_DATA_DURATION", 1, vars.get(i++));
        assertGlobalCVar("CONFIG_BCN_LOST_PROB", 1, vars.get(i++));
        assertGlobalCVar("CONFIG_BCN_NOT_LOST_PROB", 99, vars.get(i++));
        assertGlobalCVar("CONFIG_DATA_LOST_PROB", 1, vars.get(i++));
        assertGlobalCVar("CONFIG_DATA_NOT_LOST_PROB", 99, vars.get(i++));
    }

    @Test
    public void parseDeclarationsTest() {
        String declarations = "const int CONFIG_abc = 123," +
                "dhj = 234;" +
                "\n const int CONFIG_abe = 456," +
                "abc_config_abc = 12;";
        ArrayList<CVar> vars = CHandler.getConfigVariables(declarations, null);

        assertEquals(2, vars.size());
        assertGlobalCVar("CONFIG_abc", 123, vars.get(0));
        assertGlobalCVar("CONFIG_abe", 456, vars.get(1));
    }

    @Test
    public void parseDeclarationsMultipleScopesTest() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("eksempel.xml");
        HashMap<String, String> declarations = handler.getAllDeclarations();

        ArrayList<CVar> globalConfigVariables = CHandler.getConfigVariables(declarations.get(null), null);
        assertEquals(1, globalConfigVariables.size());
        CVar actualGlobalVar = globalConfigVariables.get(0);

        assertCVar(null, "CONFIG_global_test", 11, actualGlobalVar);

        ArrayList<CVar> localConfigVariables = CHandler.getConfigVariables(declarations.get("Template"), "Template");
        assertEquals(1, localConfigVariables.size());
        CVar actualLocalVar = localConfigVariables.get(0);

        assertCVar("Template", "CONFIG_local_test", 10, actualLocalVar);
    }

    @Test
    public void parseDeclarationsMultipleScopesHashmapTest() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("eksempel.xml");
        HashMap<String, String> declarations = handler.getAllDeclarations();

        ArrayList<CVar> configVariables = CHandler.getConfigVariables(declarations);
        assertEquals(2, configVariables.size());

        assertTrue(configVariables.contains(new CVar(null, "CONFIG_global_test", "11", false, "int")));
        assertTrue(configVariables.contains(new CVar("Template", "CONFIG_local_test", "10", false,"int")));
    }

    @Test
    public void parseOutputDataIsScheduled() {
        String expected1 = "OUTPUT_data_is_scheduled";
        String expected2 = "OUTPUT_nr_node_relations";

        ArrayList<CVar> constants = new ArrayList<>();
        constants.add(new CVar("CONFIG_NR_NODES", "2"));
        ArrayList<OutputVariable> outputVars = UPPAALParser.getUPPAALOutputVars("mac_model_test.xml", constants);

        assertEquals(expected1, outputVars.get(0).getName());
        assertEquals(expected2, outputVars.get(1).getName());
    }

    @Test
    public void parseScopedOutputVariables() {
        ArrayList<CVar> constants = new ArrayList<>();
        ArrayList<OutputVariable> outputVars = UPPAALParser.getUPPAALOutputVars("RoutingWithPathTracking.xml", constants);

        assertEquals(3, outputVars.size());
        assertEquals("OUTPUT_current_repeat", outputVars.get(0).getName());
        assertEquals("OUTPUT_current_data", outputVars.get(1).getName());
        assertEquals("OUTPUT_has_race", outputVars.get(2).getName());
    }

    @Test
    public void updateVariableInText() {
        String decls =
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
                "          DATA_DURATION = 1;";
        ArrayList<CVar> orginalVars = CHandler.getConfigVariables(decls,null);
        assertEquals(2, orginalVars.size());
        assertGlobalCVar("CONFIG_NR_NODES_SQR_ROOT", 4, orginalVars.get(0));
        assertGlobalCVar("CONFIG_NR_NODES", 16, orginalVars.get(1));

        //Update "XML" with new value to CONFIG_NR_NODES
        String actual = CHandler.updateIntConfigVar("CONFIG_NR_NODES", 300, decls);

        ArrayList<CVar> updatedVars = CHandler.getConfigVariables(actual, null);
        assertEquals(2, updatedVars.size());
        assertGlobalCVar("CONFIG_NR_NODES_SQR_ROOT", 4, updatedVars.get(0));
        assertGlobalCVar("CONFIG_NR_NODES", 300, updatedVars.get(1));

    }

    @Test
    public void updateVariablesInXMLFile() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("topologytest.xml"));
        ArrayList<CVar> orgConfigs = UPPAALParser.getUPPAALConfigConstants(f.getPath());
        assertEquals(3, orgConfigs.size());

        assertTrue(orgConfigs.contains(new CVar(null,"CONFIG_TESTING_CONSTANT", "1337", true,"int")));
        assertTrue(orgConfigs.contains(new CVar("Template", "CONFIG_LOCAL", "123", true, "int")));
        assertTrue(orgConfigs.contains(new CVar("Template2", "CONFIG_LOCAL2", "123", true, "int")));


        //Update value on config var
        CVar updatedCVar = orgConfigs.get(
                orgConfigs.indexOf(new CVar(null, "CONFIG_TESTING_CONSTANT", "1337", true, "int")));
        updatedCVar.setValue("1000");
        CVar updatedLocalCVar = orgConfigs.get(
                orgConfigs.indexOf(new CVar("Template", "CONFIG_LOCAL", "123", true, "int")));
        updatedLocalCVar.setValue("999");
        UPPAALParser.updateUPPAALConfigConstants(f.getPath(), orgConfigs);

        //assert updated
        ArrayList<CVar> updatedConfigs = UPPAALParser.getUPPAALConfigConstants(f.getPath());
        assertEquals(3, updatedConfigs.size());

        assertTrue(updatedConfigs.contains(new CVar(null, "CONFIG_TESTING_CONSTANT", "1000", true, "int")));
        assertTrue(updatedConfigs.contains(new CVar("Template", "CONFIG_LOCAL", "999", true, "int")));
        assertTrue(updatedConfigs.contains(new CVar("Template2", "CONFIG_LOCAL2", "123", true, "int")));
    }

    @Test
    public void parseLocalConfigVarsInXMLFile() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("topologytest.xml"));
        ArrayList<CVar> vars = UPPAALParser.getUPPAALConfigConstants(f.getPath());
        assertEquals(3, vars.size());
        assertTrue(vars.contains(new CVar(null, "CONFIG_TESTING_CONSTANT", "1337", true, "int")));
        assertTrue(vars.contains(new CVar("Template", "CONFIG_LOCAL", "123", true, "int")));
        assertTrue(vars.contains(new CVar("Template2", "CONFIG_LOCAL2", "123", true, "int")));
    }

    @Test
    public void parseModel_ChangeAndSaveAsNewFile() throws IOException, TransformerException, SAXException, ParserConfigurationException {
        File f = FileHelper.copyFileIntoTempFile(new File("topologytest.xml"));
        UPPAALModel uppaalModel = new UPPAALModel(f.getPath());
        uppaalModel.load();
        CVar expected1 = new CVar(null, "CONFIG_TESTING_CONSTANT", "1337", true, "int");
        CVar expected2 = new CVar("Template", "CONFIG_LOCAL", "123", true, "int");
        CVar expected3 = new CVar("Template2", "CONFIG_LOCAL2", "123", true, "int");

        List<CVar> vars = uppaalModel.getConstConfigVars();

        assertEquals(3, vars.size());
        assertTrue(vars.contains(expected1));
        assertTrue(vars.contains(expected2));
        assertTrue(vars.contains(expected3));

        File tmp = FileHelper.generateAutoDeletedTempFile("");
        uppaalModel.saveToPath(tmp.getPath());

        UPPAALModel uppaalModel2 = new UPPAALModel(tmp.getPath());
        uppaalModel2.load();

        List<CVar> vars2 =uppaalModel2.getConstConfigVars();

        assertEquals(3, vars2.size());
        assertTrue(vars2.contains(expected1));
        assertTrue(vars2.contains(expected2));
        assertTrue(vars2.contains(expected3));
    }

    @Test
    public void parseModelTimeUnitConstantsDefaultsTo1() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("eksempel.xml"));

        double constant = UPPAALParser.getModelTimeUnitConstant(f.getPath());

        assertEquals(1, constant, 0.001);
    }

    @Test
    public void parseModelTimeUnitConstants() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("RoutingWithPathTracking.xml"));

        UPPAALModel model = new UPPAALModel(f.getPath());
        model.load();

        assertEquals(20, model.getModelTimeUnit(), 0.001);
    }

    @Test
    public void getProcessesFromModel() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("RoutingWithPathTracking.xml"));

        UPPAALModel model = new UPPAALModel(f.getPath());
        model.load();

        assertEquals(37, model.getProcesses().size());
        assertEquals("Node(0)", model.getProcesses().get(0));
        assertEquals("Node(35)", model.getProcesses().get(35));
        assertEquals("SetupTemplate", model.getProcesses().get(36));
    }

    @Test
    public void getSystemDeclarationFromFile() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("topologytest.xml"));
        List<String> actual = UPPAALParser.getUPPAALProcesses(f.getPath(), UPPAALParser.getUPPAALConfigConstants(f.getPath()));
        assertEquals("Template", actual.get(0));
    }

    @Test
    public void getParameterFromTemplate() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("RoutingWithPathTracking.xml"));
        XmlHandler handler = new XmlHandler(f.getPath());
        String actual = handler.getParamaterForTemplate("Node");
        assertEquals("node_id", actual);

        assertNull(handler.getParamaterForTemplate("SetupTemplate"));
        assertNull(handler.getParamaterForTemplate("BLA"));
    }

    @Test
    public void calculateCorrectParameterSize() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("RoutingWithPathTracking.xml"));

        int expected = 35;

        XmlHandler handler = new XmlHandler(f.getPath());
        String parameter = handler.getParamaterForTemplate("Node");
        int actual = CHandler.getSizeOfParam(parameter, handler.getGlobalDeclarations(), UPPAALParser.getUPPAALConfigConstants(f.getPath()));
        assertEquals(expected, actual);
    }

    @Test
    public void getBoolAndDoubleGlobalVars() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("mac_model_test.xml");
        String globalDecls = handler.getGlobalDeclarations();
        ArrayList<CVar> vars = CHandler.getConfigVariables(globalDecls, null);

        /*assertGlobalCVar("CONFIG_TEST_BOOLEAN", true, vars.get(0));
        assertGlobalCVar("CONFIG_TEST_DOUBLE", 0.5, vars.get(1));*/
    }


    private <T> void assertCVar(String expectedScope, String expectedName, T expectedVal, CVar actual) {
        assertEquals(expectedScope, actual.getScope());
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedVal.toString(), actual.getValue());
    }

    private <T> void assertGlobalCVar(String expectedName, T expectedVal, CVar actual) {
        assertCVar(null, expectedName, expectedVal, actual);
    }

}
