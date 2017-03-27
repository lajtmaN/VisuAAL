package parsers;

import Helpers.ConnectedGraphGenerator;
import Helpers.FileHelper;
import Helpers.QueryGenerator;
import Model.*;
import javafx.util.Pair;
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
        ArrayList<CVar> vars = UPPAALParser.getUPPAALConfigConstants("test_resources/eksempel.xml");

        assertEquals(7, vars.size());
        int i = 0;
        assertGlobalCVar("CONFIG_TEST_BOOLEAN", "true", vars.get(i++));
        assertGlobalCVar("CONFIG_TEST_DOUBLE", "0.5", vars.get(i++));
        assertGlobalCVar("CONFIG_MODEL_TIME_UNIT", "20.0", vars.get(i++));
        assertGlobalCVar("CONFIG_global_test", 11, vars.get(i++));
        assertGlobalCVar("CONFIG_parse", 0, vars.get(i++));
        assertCVar("Template", "CONFIG_local_test", 10, vars.get(i++));
        assertCVar("Template", "CONFIG_do_read", 0, vars.get(i++));
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
        XmlHandler handler = new XmlHandler("test_resources/eksempel.xml");
        HashMap<String, String> declarations = handler.getAllDeclarations();

        ArrayList<CVar> globalConfigVariables = CHandler.getConfigVariables(declarations.get(null), null);
        assertEquals(5, globalConfigVariables.size());
        Optional<CVar> actualGlobalVar = globalConfigVariables.stream().filter(c -> c.getName().equals("CONFIG_global_test")).findFirst();
        assertTrue(actualGlobalVar.isPresent());

        assertCVar(null, "CONFIG_global_test", 11, actualGlobalVar.get());

        ArrayList<CVar> localConfigVariables = CHandler.getConfigVariables(declarations.get("Template"), "Template");
        assertEquals(2, localConfigVariables.size());
        CVar actualLocalVar = localConfigVariables.get(0);
        CVar actualLocalFuncVar = localConfigVariables.get(1);

        assertCVar("Template", "CONFIG_local_test", 10, actualLocalVar);
        assertCVar("Template", "CONFIG_do_read", 0, actualLocalFuncVar);
    }

    @Test
    public void parseDeclarationsMultipleScopesHashmapTest() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("test_resources/eksempel.xml");
        HashMap<String, String> declarations = handler.getAllDeclarations();

        ArrayList<CVar> configVariables = CHandler.getConfigVariables(declarations);
        assertEquals(7, configVariables.size());

        assertTrue(configVariables.contains(new CVar(null, "CONFIG_global_test", "11", false, "int")));
        assertTrue(configVariables.contains(new CVar("Template", "CONFIG_local_test", "10", false,"int")));
    }


    @Test
    public void parseScopedOutputVariableFromScopeWithArraySizeDefinedInGlobal() {
        ArrayList<OutputVariable> outputVars = UPPAALParser.getUPPAALOutputVars("test_resources/topologytest.xml");

        assertEquals(3, outputVars.size());
        assertEquals("OUTPUT_test", outputVars.get(0).getName());

        assertEquals("OUTPUT_node_data", outputVars.get(1).getName());
        assertTrue(outputVars.get(1).getIsNodeData());

        assertEquals("OUTPUT_variable", outputVars.get(2).getName());
        assertEquals(1337, outputVars.get(2).getVariableArraySize());
        assertTrue(outputVars.get(2).getIsEdgeData());

    }

    @Test
    public void updateVariablesInXMLFile() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
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
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
        ArrayList<CVar> vars = UPPAALParser.getUPPAALConfigConstants(f.getPath());
        assertEquals(3, vars.size());
        assertTrue(vars.contains(new CVar(null, "CONFIG_TESTING_CONSTANT", "1337", true, "int")));
        assertTrue(vars.contains(new CVar("Template", "CONFIG_LOCAL", "123", true, "int")));
        assertTrue(vars.contains(new CVar("Template2", "CONFIG_LOCAL2", "123", true, "int")));
    }

    @Test
    public void parseModel_ChangeAndSaveAsNewFile() throws IOException, TransformerException, SAXException, ParserConfigurationException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
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
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));

        double constant = UPPAALParser.getModelTimeUnitConstant(f.getPath());

        assertEquals(1, constant, 0.001);
    }

    @Test
    public void parseModelTimeUnitConstants() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/eksempel.xml"));

        UPPAALModel model = new UPPAALModel(f.getPath());
        model.load();

        assertEquals(20, model.getModelTimeUnit(), 0.001);
    }

    @Test
    public void getProcessesFromModel() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/MultipleTemplatesMultipleParameterTypesSystemInstantiated.xml"));

        UPPAALModel model = new UPPAALModel(f.getPath());
        model.load();

        assertEquals(3, model.getProcesses().size());
        assertEquals("t0", model.getProcesses().get(0).getProcessName());
        assertEquals("t1", model.getProcesses().get(1).getProcessName());
        assertEquals("t2", model.getProcesses().get(2).getProcessName());
    }

    @Test
    public void getSystemDeclarationFromFile() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
        List<UPPAALProcess> actual = UPPAALParser.getUPPAALProcesses(f.getPath(), UPPAALParser.getUPPAALConfigConstants(f.getPath()));
        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertNull(actual.get(0).getProcessName());
        assertEquals("Template", actual.get(0).getTemplateName());
    }

    @Test
    public void getParameterFromTemplate() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/MultipleTemplatesMultipleParameterTypes.xml"));
        XmlHandler handler = new XmlHandler(f.getPath());
        String actual = handler.getParamaterForTemplate("Template0");
        assertEquals("id_tt", actual);

        assertNull(handler.getParamaterForTemplate("SetupTemplate"));
        assertNull(handler.getParamaterForTemplate("BLA"));
    }

    @Test
    public void calculateCorrectParameterSize() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/MultipleTemplatesMultipleParameterTypes.xml"));

        int expectedlhs = 1;
        int expectedrhs = 2;

        XmlHandler handler = new XmlHandler(f.getPath());
        String parameter = handler.getParamaterForTemplate("Template0");
        Pair<Integer,Integer> actualbounds = CHandler.getSizesOfParam(parameter, handler.getGlobalDeclarations(), UPPAALParser.getUPPAALConfigConstants(f.getPath()));
        assertEquals(expectedlhs, actualbounds.getKey().intValue());
        assertEquals(expectedrhs, actualbounds.getValue().intValue());
    }

    @Test
    public void getBoolAndDoubleGlobalVars() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("test_resources/eksempel.xml");
        String globalDecls = handler.getGlobalDeclarations();
        ArrayList<CVar> vars = CHandler.getConfigVariables(globalDecls, null);

        assertGlobalCVar("CONFIG_TEST_BOOLEAN", true, vars.get(0));
        assertGlobalCVar("CONFIG_TEST_DOUBLE", 0.5, vars.get(1));
    }

    @Test
    public void ParseFunctionVariables() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/eksempel.xml"));

        XmlHandler handler = new XmlHandler(f.getPath());
        ArrayList<CVar> vars = CHandler.getConfigVariables(handler.getAllDeclarations());

        assertTrue(vars.stream().anyMatch(p -> p.getName().equals("CONFIG_parse")));
        assertTrue(vars.stream().anyMatch(p -> p.getName().equals("CONFIG_do_read")));
    }

    @Test
    public void setTopologyForUPPAALTest() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
        UPPAALTopology top = new UPPAALTopology();
        top.setNumberOfNodes(4);
        top.add(new UPPAALEdge("0","1"));
        top.add(new UPPAALEdge("1","2"));
        top.add(new UPPAALEdge("2","3"));
        top.add(new UPPAALEdge("3","0"));

        XmlHandler xmlHandler = new XmlHandler(f.getPath());
        String globalDecls = xmlHandler.getGlobalDeclarations();

        String updated = updateTopologyAndNrNodes(globalDecls, top);

        xmlHandler.setGlobalDeclarations(updated);

        UPPAALTopology topologyOut = CHandler.getTopology(xmlHandler.getGlobalDeclarations());

        assertEquals(4, topologyOut.getNumberOfNodes());
        for(int i = 0; i < 4; i++) {
            assertEquals(i, topologyOut.get(i).getSourceAsInt());
            assertEquals((i + 1) % 4, topologyOut.get(i).getDestinationAsInt());
        }
    }

    @Test
    public void getTopologySizeMultipleCommentedTopologies() throws IOException, TransformerException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/declarationMultipleTopoDecls.xml"));

        XmlHandler xmlHandler = new XmlHandler(f.getPath());

        UPPAALTopology topologyOut = CHandler.getTopology(xmlHandler.getGlobalDeclarations());

        assertEquals(5, topologyOut.getNumberOfNodes());
    }

    @Test
    public void setRandomTopologyForUPPAALTest() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
        UPPAALTopology top = ConnectedGraphGenerator.generateRandomTopology(36);

        XmlHandler xmlHandler = new XmlHandler(f.getPath());
        String globalDecls = xmlHandler.getGlobalDeclarations();
        String updatedGlobalDecls = updateTopologyAndNrNodes(globalDecls, top);
        xmlHandler.setGlobalDeclarations(updatedGlobalDecls);

        UPPAALTopology topologyOut = CHandler.getTopology(xmlHandler.getGlobalDeclarations());

        assertEquals(36, topologyOut.getNumberOfNodes());
        for(int i = 0; i < 36; i++) {
            assertEquals(top.get(i), topologyOut.get(i));
        }
    }

    @Test
    public void setTopologyForUPPAALMoreCasesTest() throws IOException, ParserConfigurationException, SAXException, TransformerException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
        UPPAALTopology top = new UPPAALTopology();
        top.setNumberOfNodes(4);
        top.add(new UPPAALEdge("2","0"));
        top.add(new UPPAALEdge("1","2"));
        top.add(new UPPAALEdge("2","1"));
        top.add(new UPPAALEdge("1","3"));

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

    @Test
    public void parseTemplatesFromModelsWithTwoTypesOfNodes() throws IOException, SAXException, ParserConfigurationException {
        UPPAALModel model = new UPPAALModel(new File("test_resources/MultipleTemplatesMultipleParameterTypes.xml").getPath());
        model.load();
        assertNotNull(model);
        assertNotNull(model.getProcesses());
        assertEquals("Wrong number of templates",3, model.getProcesses().size());
        List<String> processParameterList = new ArrayList<>();
        for (UPPAALProcess up: model.getProcesses()) {
            processParameterList.add(up.getProcessQueryIdentifier());
        }
        assertTrue("Template1(0) does not exist",processParameterList.contains("Template1(0)"));
        assertTrue("Template0(1) does not exist",processParameterList.contains("Template0(1)"));
        assertTrue("Template0(2) does not exist",processParameterList.contains("Template0(2)"));
        assertNotNull(model);
    }

    @Test
    public void generateQueryTwoTemplates() {
        List<String> expectedSimulationQueryParts = new ArrayList<>();
        expectedSimulationQueryParts.add("simulate 5 [<=123] {");
        expectedSimulationQueryParts.add("Template1(0).OUTPUT_TEST");
        expectedSimulationQueryParts.add("Template0(1).OUTPUT_TEST");
        expectedSimulationQueryParts.add("Template0(2).OUTPUT_TEST");
        expectedSimulationQueryParts.add("}");

        UPPAALModel model = new UPPAALModel(new File("test_resources/MultipleTemplatesMultipleParameterTypes.xml").getPath());
        model.load();
        assertNotNull(model);
        assertNotNull(model.getProcesses());
        assertEquals("Wrong number of templates",3, model.getProcesses().size());

        String actualQuery = QueryGenerator.generateSimulationQuery(123, 5, model.getOutputVars(), model.getProcesses());
        assertTrue(actualQuery.startsWith(expectedSimulationQueryParts.get(0)));
        for(String part : expectedSimulationQueryParts) {
            assertTrue(actualQuery.contains(part));
        }
        assertTrue(actualQuery.endsWith(expectedSimulationQueryParts.get(4)));
    }

    @Test
    public void parseTemplatesFromModelsWithTwoTypesOfNodesSystemInstantiated() throws IOException, SAXException, ParserConfigurationException {
        UPPAALModel model = new UPPAALModel(new File("test_resources/MultipleTemplatesMultipleParameterTypesSystemInstantiated.xml").getPath());
        model.load();
        assertNotNull(model);
        assertNotNull(model.getProcesses());
        assertEquals("Wrong number of templates",3, model.getProcesses().size());

        List<String> processParameterList = new ArrayList<>();
        for (UPPAALProcess up: model.getProcesses()) {
            processParameterList.add(up.getProcessQueryIdentifier());
        }
        assertTrue("t0 does not exist",processParameterList.contains("t0"));
        assertTrue("t1 does not exist",processParameterList.contains("t1"));
        assertTrue("t2 does not exist",processParameterList.contains("t2"));
    }

    @Test
    public void parseProcessesInstantiatedButNotUsed() throws IOException, SAXException, ParserConfigurationException {
        UPPAALModel model = new UPPAALModel(new File("test_resources/ProcessesInstantiatedButNotUsed.xml").getPath());
        model.load();
        assertNotNull(model);
        assertNotNull(model.getProcesses());
        assertEquals("Wrong number of templates",3, model.getProcesses().size());

        List<String> processParameterList = new ArrayList<>();
        for (UPPAALProcess up: model.getProcesses()) {
            processParameterList.add(up.getProcessQueryIdentifier());
        }
        assertTrue("Node(0) does not exist",processParameterList.contains("Node(0)"));
        assertTrue("Node(1) does not exist",processParameterList.contains("Node(1)"));
        assertTrue("Node(2) does not exist",processParameterList.contains("Node(2)"));
    }



    @Test
    public void generateQueryTwoTemplatesNonOverlappingParameters() {
        List<String> expectedSimulationQueryParts = new ArrayList<>();
        expectedSimulationQueryParts.add("simulate 5 [<=123] {");
        expectedSimulationQueryParts.add("t0.OUTPUT_TEST");
        expectedSimulationQueryParts.add("t1.OUTPUT_TEST");
        expectedSimulationQueryParts.add("t2.OUTPUT_TEST");
        expectedSimulationQueryParts.add("}");

        UPPAALModel model = new UPPAALModel(new File("test_resources/MultipleTemplatesMultipleParameterTypesSystemInstantiated.xml").getPath());
        model.load();
        assertNotNull(model);
        assertNotNull(model.getProcesses());
        assertEquals("Wrong number of templates",3, model.getProcesses().size());

        String actualQuery = QueryGenerator.generateSimulationQuery(123, 5, model.getOutputVars(), model.getProcesses());
        assertTrue(actualQuery.startsWith(expectedSimulationQueryParts.get(0)));
        for(String part : expectedSimulationQueryParts) {
            assertTrue(actualQuery.contains(part));
        }
        assertTrue(actualQuery.endsWith(expectedSimulationQueryParts.get(4)));
    }



    private void assertEdge(int expectedSource, int expectedDest, UPPAALEdge e) {
        assertEquals(expectedSource, e.getSourceAsInt());
        assertEquals(expectedDest, e.getDestinationAsInt());
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
