package parsers;

import Helpers.FileHelper;
import Model.*;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;
import static parsers.Declaration.VariableParser.updateTopologyAndNrNodes;


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
        assertTrue(outputVars.get(0).getIsNodeData()); //Current_repeat is not an array and is placed in template scope
        assertEquals("OUTPUT_current_data", outputVars.get(1).getName());
        assertEquals("OUTPUT_has_race", outputVars.get(2).getName());
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

        List<CVar> vars = uppaalModel.getAllConfigVars();

        assertEquals(3, vars.size());
        assertTrue(vars.contains(expected1));
        assertTrue(vars.contains(expected2));
        assertTrue(vars.contains(expected3));

        File tmp = FileHelper.generateAutoDeletedTempFile("");
        uppaalModel.saveToPath(tmp.getPath());

        UPPAALModel uppaalModel2 = new UPPAALModel(tmp.getPath());
        uppaalModel2.load();

        List<CVar> vars2 =uppaalModel2.getAllConfigVars();

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

        assertGlobalCVar("CONFIG_TEST_BOOLEAN", true, vars.get(0));
        assertGlobalCVar("CONFIG_TEST_DOUBLE", 0.5, vars.get(1));
    }

    @Test
    public void doNotParseFunctionVariables() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("eksempel.xml"));

        XmlHandler handler = new XmlHandler(f.getPath());
        ArrayList<CVar> vars = CHandler.getConfigVariables(handler.getAllDeclarations());

        assertFalse(vars.stream().anyMatch(p -> p.getName().equals("CONFIG_do_not_parse")));
        assertFalse(vars.stream().anyMatch(p -> p.getName().equals("CONFIG_do_not_read")));
    }

    @Test
    public void setTopologyForUPPAALTest() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        File f = FileHelper.copyFileIntoTempFile(new File("mac_model_test.xml"));
        UPPAALTopology top = new UPPAALTopology();
        top.setNumberOfNodes(4);
        top.add(new UPPAALEdge(0,1));
        top.add(new UPPAALEdge(1,2));
        top.add(new UPPAALEdge(2,3));
        top.add(new UPPAALEdge(3,0));

        XmlHandler xmlHandler = new XmlHandler(f.getPath());
        String globalDecls = xmlHandler.getGlobalDeclarations();

        String updated = updateTopologyAndNrNodes(globalDecls, top);

        xmlHandler.setGlobalDeclarations(updated);

        UPPAALTopology topologyOut = CHandler.getTopology(xmlHandler.getGlobalDeclarations());

        assertEquals(4, topologyOut.getNumberOfNodes());
        for(int i = 0; i < 4; i++) {
            assertEquals(i, topologyOut.get(i).getSource());
            assertEquals((i + 1) % 4, topologyOut.get(i).getDestination());
        }
    }

    @Test
    public void setTopologyForUPPAALMoreCasesTest() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        File f = FileHelper.copyFileIntoTempFile(new File("mac_model_test.xml"));
        UPPAALTopology top = new UPPAALTopology();
        top.setNumberOfNodes(4);
        top.add(new UPPAALEdge(2,0));
        top.add(new UPPAALEdge(1,2));
        top.add(new UPPAALEdge(2,1));
        top.add(new UPPAALEdge(1,3));

        XmlHandler xmlHandler = new XmlHandler(f.getPath());
        String globalDecls = xmlHandler.getGlobalDeclarations();
        String updated = updateTopologyAndNrNodes(globalDecls, top);
        xmlHandler.setGlobalDeclarations(updated);

        UPPAALTopology topologyOut = CHandler.getTopology(xmlHandler.getGlobalDeclarations());

        assertEquals(4, topologyOut.getNumberOfNodes());
        assertEdge(1, 2, topologyOut.get(0));
        assertEdge(1, 3, topologyOut.get(1));
        assertEdge(2, 0, topologyOut.get(2));
        assertEdge(2, 1, topologyOut.get(3));

        ArrayList<CVar> vars = CHandler.getConfigVariables(xmlHandler.getGlobalDeclarations(), null);
        for(CVar var : vars) {
            if(var.getName().equals("CONFIG_NR_NODES"))
                assertEquals("4", var.getValue());
        }
    }

    private void assertEdge(int expectedSource, int expectedDest, UPPAALEdge e) {
        assertEquals(expectedSource, e.getSource());
        assertEquals(expectedDest, e.getDestination());
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
