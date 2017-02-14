package Simulation;

import Model.Simulation;
import Model.SimulationEdgePoint;
import Model.UPPAALModel;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lajtman on 14-02-2017.
 */
public class SimulationTests  {

    @Test
    public void testSerializeAndDeserialize(){
        String filePath = "testFile1";

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

        File file = new File("simulations/"+filePath+".sim");
        assertTrue(file.delete());

    }
}
