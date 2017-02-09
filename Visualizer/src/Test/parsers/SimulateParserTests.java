package parsers;

import Model.DataPoint;
import Model.SimulateOutput;
import Model.SimulationEdgePoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by lajtman on 07-02-2017.
 */
public class SimulateParserTests {
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
    public void parseSimpleVariable() {
        String variableDef = "P.s1:";
        String variableName = RegexHelper.getFirstMatchedValueFromRegex(SimulateParser.variableRegex, variableDef);
        assertEquals("P.s1", variableName);
    }


    @Test
    public void parseAdvancedVariable() {
        String variableDef = "Paber.data_is_scheduled[30][2]:";
        String variableName = RegexHelper.getFirstMatchedValueFromRegex(SimulateParser.variableRegex, variableDef);
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

        SimulateOutput output = SimulateParser.parse(Arrays.asList(sampleOutput.split("\n")), 1);

        assertEquals(2, output.getNumVariables());
        assertEquals(28, output.getSimulationForVariable("P.s1", 0).size());
        containsData("P.s1", 12, 1.0, output);
        containsData("P.s1", 36, 1.0, output);
        containsData("P.s2", 42, 0.0, output);
        containsData("P.s2", 34, 1.0, output);


    }

    private void containsData(String name, double time, double value, SimulateOutput simulateOutput) {
        DataPoint d = new DataPoint(time, value);
        assertTrue("name: " + name + ", time: " + time + " value: " + value,
                simulateOutput.getSimulationForVariable(name, 0).contains(d));
    }
    @Test
    public void zipOutput(){
        SimulateOutput simOut = new SimulateOutput(1);
        String from1to2 = "data[1][2]";
        String from2to1 = "data[2][1]";
        ArrayList<DataPoint> datas = new ArrayList<>();
        datas.add(new DataPoint(1,5));
        datas.add(new DataPoint(2,4));
        datas.add(new DataPoint(3,3));
        datas.add(new DataPoint(4,2));
        datas.add(new DataPoint(5,1));

        simOut.addDatapoint(from1to2, 0, datas.get(0));
        simOut.addDatapoint(from1to2, 0, datas.get(3));
        simOut.addDatapoint(from1to2, 0, datas.get(4));
        simOut.addDatapoint(from2to1, 0, datas.get(1));
        simOut.addDatapoint(from2to1, 0, datas.get(2));

        ArrayList<SimulationEdgePoint> expected = new ArrayList<>();
        expected.add(new SimulationEdgePoint(1,1,2,5));
        expected.add(new SimulationEdgePoint(2,2,1,4));
        expected.add(new SimulationEdgePoint(3,2,1,3));
        expected.add(new SimulationEdgePoint(4,1,2,2));
        expected.add(new SimulationEdgePoint(5,1,2,1));
        ArrayList<SimulationEdgePoint> actual = simOut.getZippedForSimulate(0);

        AssertArrayList(expected, actual);
    }

    @Test
    public void zipOutputMultipleSims(){
        SimulateOutput simOut = new SimulateOutput(2);
        String from1to2 = "data[1][2]";
        String from2to1 = "data[2][1]";
        ArrayList<DataPoint> datas = new ArrayList<>();
        datas.add(new DataPoint(1,10));
        datas.add(new DataPoint(2,9));
        datas.add(new DataPoint(3,8));
        datas.add(new DataPoint(4,7));
        datas.add(new DataPoint(5,6));
        datas.add(new DataPoint(6,5));
        datas.add(new DataPoint(7,4));
        datas.add(new DataPoint(8,3));
        datas.add(new DataPoint(9,2));
        datas.add(new DataPoint(10,1));

        simOut.addDatapoint(from1to2, 0, datas.get(5));
        simOut.addDatapoint(from1to2, 0, datas.get(6));
        simOut.addDatapoint(from1to2, 0, datas.get(7));
        simOut.addDatapoint(from2to1, 0, datas.get(8));
        simOut.addDatapoint(from2to1, 0, datas.get(9));
        simOut.addDatapoint(from1to2, 1, datas.get(0));
        simOut.addDatapoint(from1to2, 1, datas.get(3));
        simOut.addDatapoint(from1to2, 1, datas.get(4));
        simOut.addDatapoint(from2to1, 1, datas.get(1));
        simOut.addDatapoint(from2to1, 1, datas.get(2));

        ArrayList<SimulationEdgePoint> expected = new ArrayList<>();
        expected.add(new SimulationEdgePoint(1,1,2,10));
        expected.add(new SimulationEdgePoint(2,2,1,9));
        expected.add(new SimulationEdgePoint(3,2,1,8));
        expected.add(new SimulationEdgePoint(4,1,2,7));
        expected.add(new SimulationEdgePoint(5,1,2,6));


        ArrayList<SimulationEdgePoint> actual = simOut.getZippedForSimulate(1);

        AssertArrayList(expected, actual);
    }

    private void AssertArrayList(ArrayList<SimulationEdgePoint> expected, ArrayList<SimulationEdgePoint> actual){
        assertEquals(expected.size(), actual.size());
        for (int i = 0;i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
