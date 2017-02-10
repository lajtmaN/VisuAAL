package Helpers;

import Model.OutputVariable;
import org.junit.Test;
import parsers.UPPAALParser;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

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
}
