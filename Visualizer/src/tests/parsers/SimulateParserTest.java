package tests.parsers;

import Model.SimulateOutput;
import org.junit.jupiter.api.*;
import parsers.CHandler;
import parsers.SimulateParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by lajtman on 07-02-2017.
 */
public class SimulateParserTest {
/*
Options for the verification:
  Generating no trace
  Search order is breadth first
  Using conservative space optimisation
  Seed is 1486472853
  State space representation uses minimal constraint systems
uppaalquery.q:1: [error] Unknown identifier: as.
uppaalquery.q:1: [error] syntax error: unexpected end, expecting ',' or '}'.

 */
    @Test
    public void failingTest() {
        assertEquals("nope", "jeps");
    }

    @Test
    public void parseSimpleVariable() {
        String variableDef = "P.s1:";
        String variableName = CHandler.getFirstMatchedValueFromRegex(SimulateParser.variableRegex, variableDef);
        assertEquals("P.s1", variableName);
    }


    @Test
    public void parseAdvancedVariable() {
        String variableDef = "Paber.data_is_scheduled[30][2]:";
        String variableName = CHandler.getFirstMatchedValueFromRegex(SimulateParser.variableRegex, variableDef);
        assertEquals("Paber.data_is_scheduled[30][2]", variableName);
    }

    @Test
    public void parseSimulateResult() {
        String sampleOutput =
                "Options for the verification:\n" +
                "  Generating no trace\n" +
                "  Search order is breadth first\n" +
                "  Using conservative space optimisation\n" +
                "  Seed is 1486472788\n" +
                "  State space representation uses minimal constraint systems\n" +
                "[2K\n" +
                "Verifying formula 1 at line 1\n" +
                "[2K -- Formula is satisfied.\n" +
                "P.s1:\n" +
                "[0]: (0,1) (2,1) (2,0) (6,0) (6,1) (8,1) (8,0) (12,0) (12,1) (14,1) (14,0) (18,0) (18,1) (20,1) " +
                        "(20,0) (24,0) (24,1) (26,1) (26,0) (30,0) (30,1) (32,1) (32,0) (36,0) (36,1) (38,1) (38,0) (42,0)\n" +
                "P.s2:\n" +
                "[0]: (0,0) (2,0) (2,1) (4,1) (4,0) (8,0) (8,1) (10,1) (10,0) (14,0) (14,1) (16,1) (16,0) " +
                        "(20,0) (20,1) (22,1) (22,0) (26,0) (26,1) (28,1) (28,0) (32,0) (32,1) (34,1) (34,0) (38,0) " +
                        "(38,1) (40,1) (40,0) (42,0)\n";

        SimulateOutput output = SimulateParser.parse(sampleOutput.split("\n"), 2);


        assertEquals(2, output.getNumVariables());

    }
}
