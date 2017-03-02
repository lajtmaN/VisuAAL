package Simulation;

import Helpers.FileHelper;
import Model.Simulation;
import Model.SimulationEdgePoint;
import Model.UPPAALModel;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

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
        ArrayList<SimulationEdgePoint> points = new ArrayList<>();
        points.add(new SimulationEdgePoint(0.0, 0, 1, 0.0));
        points.add(new SimulationEdgePoint(0.0, 1, 0, 0.0));
        points.add(new SimulationEdgePoint(0.2, 0, 1, 1.0));
        points.add(new SimulationEdgePoint(0.2, 1, 0, 1.0));
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
        ArrayList<SimulationEdgePoint> points = new ArrayList<>();
        points.add(new SimulationEdgePoint(0.0, 0, 1, 0.0));
        points.add(new SimulationEdgePoint(0.0, 1, 0, 0.0));
        points.add(new SimulationEdgePoint(0.2, 0, 1, 1.0));
        points.add(new SimulationEdgePoint(0.2, 1, 0, 1.0));
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
    public void testRunAndReverseRunAreActuallyReversed(){

        UPPAALModel model = new UPPAALModel("topologytest.xml");
        model.load();
        String query = "test";
        ArrayList<SimulationEdgePoint> points = new ArrayList<>();
        points.add(new SimulationEdgePoint(0.0, 0, 1, 0.0));
        points.add(new SimulationEdgePoint(0.1, 1, 0, 0.0));
        points.add(new SimulationEdgePoint(0.2, 0, 1, 1.0));
        points.add(new SimulationEdgePoint(0.3, 1, 0, 1.0));
        Simulation sim = new Simulation(model, query, points);

        for (int i = 0; i < points.size(); i++) {
            assertEquals(points.get(points.size()-i-1), sim.getReverseRun().get(i));
            assertEquals(points.get(i), sim.getRun().get(i));
        }
    }

}
