package Helpers;

import Model.CVar;
import Model.OutputVariable;
import org.junit.Test;
import parsers.UPPAALParser;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by batto on 08-Feb-17.
 */
public class QueryGeneratorTests {
    @Test
    public void createRelationshipQuery() {
        String expected = "simulate 1 [<=1000] { data[0][0] > 0, data[0][1] > 0, data[1][0] > 0, data[1][1] > 0}";
        String actual = QueryGenerator.generate2DQuadraticArrayQuery("data", 2, 1, 1000);

        assertEquals(expected, actual);
    }

    @Test
    public void testParseQuery() {
        String expected = "simulate 10 [<=3572] {OUTPUT_nr_node_relations}";

        ArrayList<OutputVariable> outVars = new ArrayList<>();
        outVars.add(new OutputVariable("OUTPUT_nr_node_relations"));
        String actual = QueryGenerator.generateSimulationQuery(3572, 10, outVars);

        assertEquals(expected, actual);
    }

    @Test
    public void testParseOuputVariableArray() {
        String expectedName = "OUTPUT_data[x]";
        int expectedSize = 10;

        ArrayList<CVar<Integer>> constants = new ArrayList<>();
        constants.add(new CVar<>("CONFIG_SIZE", expectedSize));

        OutputVariable actual = UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_SIZE]", constants);

        assertEquals(expectedSize, actual.getVariableArraySize());
        assertEquals(expectedName, actual.getName());
        assertFalse(actual.getIsEdgeData()); //false because 2d array
        assertTrue(actual.getIsNodeData());  //true because 2d array
    }

    @Test
    public void testParseOuputVariableArray_2DArray() {
        String expectedName = "OUTPUT_data[x][x]";
        int expectedSize = 10;

        ArrayList<CVar<Integer>> constants = new ArrayList<>();
        constants.add(new CVar<>("CONFIG_SIZE", expectedSize));

        OutputVariable actual = UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_SIZE][CONFIG_SIZE]", constants);

        assertEquals(expectedSize, actual.getVariableArraySize());
        assertEquals(expectedName, actual.getName());
        assertTrue(actual.getIsEdgeData());  //true because 2d array
        assertFalse(actual.getIsNodeData()); //false because 2d array
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseOutputVariableArray_3DArray() {
        UPPAALParser.parseOutputVariableArray("OUTPUT_data[CONFIG_test][CONFIG_test][CONFIG_test]", new ArrayList<>());
    }
}
