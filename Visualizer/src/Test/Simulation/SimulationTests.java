package Simulation;

import Helpers.FileHelper;
import Model.*;
import junit.framework.TestCase;
import org.junit.Test;
import parsers.SimulateParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lajtman on 14-02-2017.
 */
public class SimulationTests  {

    private String generateTempSimFileForTest() {
        return "TMP_" + Long.toHexString(Double.doubleToLongBits(Math.random()));
    }

    @Test
    public void testSerializeAndDeserialize(){
        String filePath = generateTempSimFileForTest();

        UPPAALModel model = new UPPAALModel("topologytest.xml");
        model.load();
        String query = "test";
        ArrayList<SimulationPoint> points = new ArrayList<>();
        points.add(new SimulationEdgePoint(0.0, "0", "1", 0.0));
        points.add(new SimulationEdgePoint(0.0, "1", "0", 0.0));
        points.add(new SimulationEdgePoint(0.2, "0", "1", 1.0));
        points.add(new SimulationEdgePoint(0.2, "1", "0", 1.0));
        Simulation sim = new Simulation(model, query, points);

        sim.save(filePath);
        Simulation sim2 = Simulation.load(filePath);

        assertEquals(sim, sim2);

        File file = new File(FileHelper.simulationFileName(filePath));
        assertTrue(file.delete());
    }

    @Test
    public void testSaveSimulationAndLoadSimulationOfDeletedModel() throws IOException {
        String simulationFileName = generateTempSimFileForTest();
        String uppaalModelFile = generateTempSimFileForTest() + ".xml";
        Files.copy(new File("topologytest.xml").toPath(), new File(uppaalModelFile).toPath(), StandardCopyOption.REPLACE_EXISTING);

        //Create simulation
        UPPAALModel model = new UPPAALModel(uppaalModelFile);
        model.load();
        String query = "test";
        ArrayList<SimulationPoint> points = new ArrayList<>();
        points.add(new SimulationEdgePoint(0.0, "0", "1", 0.0));
        points.add(new SimulationEdgePoint(0.0, "1", "0", 0.0));
        points.add(new SimulationEdgePoint(0.2, "0", "1", 1.0));
        points.add(new SimulationEdgePoint(0.2, "1", "0", 1.0));
        Simulation sim = new Simulation(model, query, points);

        //Persist to file
        sim.save(simulationFileName);

        //Delete uppaal file tested on
        assertTrue(new File(uppaalModelFile).delete());

        //Load simulation again and check if still equal
        Simulation sim2 = Simulation.load(simulationFileName);
        assertEquals(sim, sim2);

        //cleanup
        File file = new File(FileHelper.simulationFileName(simulationFileName));
        assertTrue(file.delete());

    }

    @Test
    public void testUPPAALVariableUpdateNotBinaryValues() {
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
                        "[0]: (1,0) (2,1) (3,2) \n" +
                        "P.s2:\n" +
                        "[0]: (1,0) (1,1) (2,2) \n" +
                        "P.s3:\n" +
                        "[0]: (1,0) (2,1) (2,2) \n";

        SimulateOutput output = SimulateParser.parse(Arrays.asList(sampleOutput.split("\n")), 1);

        assertEquals(3, output.getNumVariables());
        assertEquals(3, output.getSimulationForVariable("P.s1", 0).size());
        containsData("P.s1", 1, 0.0, 0, output);
        containsData("P.s1", 2, 1.0, 0, output);
        containsData("P.s1", 3, 2.0, 1, output);

        containsData("P.s2", 1, 1.0, 0, output);
        containsData("P.s2", 2, 2.0, 1, output);

        containsData("P.s3", 1, 0.0, 0, output);
        containsData("P.s3", 2, 2.0, 0, output);
    }

    private void containsData(String name, double time, double value, double previousValue, SimulateOutput simulateOutput) {
        DataPoint d = new DataPoint(time, value, previousValue);
        TestCase.assertTrue("name: " + name + ", time: " + time + " value: " + value,
                simulateOutput.getSimulationForVariable(name, 0).contains(d));
    }
}
