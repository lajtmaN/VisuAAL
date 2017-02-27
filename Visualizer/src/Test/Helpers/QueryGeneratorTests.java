package Helpers;

import Model.CVar;
import Model.OutputVariable;
import org.junit.Test;
import parsers.UPPAALParser;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by batto on 08-Feb-17.
 */
public class QueryGeneratorTests {
    @Test
    public void createRelationshipQuery() {
        String expected = "simulate 1 [<=1000] { data[0][0] > 0, data[0][1] > 0, data[1][0] > 0, data[1][1] > 0 }";
        String actual = QueryGenerator.generate2DQuadraticArrayQuery("data", 2, 1, 1000);

        assertEquals(expected, actual);
    }

    @Test
    public void testParseQuery() {
        String expected = "simulate 10 [<=3572] { OUTPUT_nr_node_relations }";

        ArrayList<OutputVariable> outVars = new ArrayList<>();
        outVars.add(new OutputVariable("OUTPUT_nr_node_relations"));
        String actual = QueryGenerator.generateSimulationQuery(3572, 10, outVars, new ArrayList<>());

        assertEquals(expected, actual);
    }

    @Test
    public void testParseQueryWithProcessNames() {
        String expected = "simulate 1 [<=100] { Node(0).OUTPUT_test, Node(1).OUTPUT_test, OUTPUT_nr_node_relations }";

        //Setup
        ArrayList<OutputVariable> outVars = new ArrayList<>();
        OutputVariable out = new OutputVariable("OUTPUT_test", "Node");
        out.setNodeData(true);
        outVars.add(out);

        outVars.add(new OutputVariable("OUTPUT_nr_node_relations"));

        ArrayList<String> processes = new ArrayList<>();
        processes.add("Node(0)");
        processes.add("Node(1)");

        //ACT
        String actual = QueryGenerator.generateSimulationQuery(100, 1, outVars, processes);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testParseArrayQueryWithProcessNames() {
        String expected = "simulate 1 [<=100] { Node(0).OUTPUT_test[0] > 0, Node(0).OUTPUT_test[1] > 0, Node(1).OUTPUT_test[0] > 0, Node(1).OUTPUT_test[1] > 0, OUTPUT_nr_node_relations }";

        //Setup
        ArrayList<CVar> constants = new ArrayList<>();
        constants.add(new CVar("CONFIG_SIZE", "2"));

        ArrayList<OutputVariable> outVars = new ArrayList<>();
        outVars.add(UPPAALParser.parseOutputVariableArray("OUTPUT_test[CONFIG_SIZE]", "Node", constants));
        outVars.add(new OutputVariable("OUTPUT_nr_node_relations"));

        ArrayList<String> processes = new ArrayList<>();
        processes.add("Node(0)");
        processes.add("Node(1)");

        //ACT
        String actual = QueryGenerator.generateSimulationQuery(100, 1, outVars, processes);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testParseOuputVariableArray() {
        String expectedName = "OUTPUT_data";
        int expectedSize = 10;

        ArrayList<CVar> constants = new ArrayList<>();
        constants.add(new CVar("CONFIG_SIZE", String.valueOf(expectedSize)));

        OutputVariable actual = UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_SIZE]", null, constants);

        assertEquals(expectedSize, actual.getVariableArraySize());
        assertEquals(expectedName, actual.getName());
        assertFalse(actual.getIsEdgeData()); //false because 2d array
        assertTrue(actual.getIsNodeData());  //true because 2d array
    }

    @Test
    public void testParseScopedOuputVariable() {
        String expectedName = "OUTPUT_data";
        int expectedSize = 12;

        ArrayList<CVar> constants = new ArrayList<>();
        constants.add(new CVar("CONFIG_SIZE", String.valueOf(expectedSize)));

        OutputVariable actual = UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_SIZE]", "Node", constants);

        assertEquals(expectedSize, actual.getVariableArraySize());
        assertEquals(expectedName, actual.getName());
        assertTrue(actual.getIsEdgeData()); //true because scoped array
        assertFalse(actual.getIsNodeData());
    }

    @Test
    public void testParseOuputVariableArray_2DArray() {
        String expectedName = "OUTPUT_data";
        int expectedSize = 10;

        ArrayList<CVar> constants = new ArrayList<>();
        constants.add(new CVar("CONFIG_SIZE", String.valueOf(expectedSize)));

        OutputVariable actual = UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_SIZE][CONFIG_SIZE]", null, constants);

        assertEquals(expectedSize, actual.getVariableArraySize());
        assertEquals(expectedName, actual.getName());
        assertTrue(actual.getIsEdgeData());  //true because 2d array
        assertFalse(actual.getIsNodeData()); //false because 2d array
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseOutputVariableArray_3DArray() {
        UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_test][CONFIG_test][CONFIG_test]", null, new ArrayList<>());
    }

    @Test
    public void testParseQueryVariableArray() {
        String expectedSimulationQuery = "simulate 5 [<=123] { OUTPUT_data[0] > 0, OUTPUT_data[1] > 0, OUTPUT_data[2] > 0 }";
        String name = "OUTPUT_data";
        int constantSize = 3;

        ArrayList<CVar> constants = new ArrayList<>();
        constants.add(new CVar("CONFIG_SIZE", String.valueOf(constantSize)));

        OutputVariable outVar = UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_SIZE]", null, constants);

        String actualQuery = QueryGenerator.generateSimulationQuery(123, 5, Arrays.asList(outVar), new ArrayList<>());
        assertEquals(expectedSimulationQuery, actualQuery);
    }
}
