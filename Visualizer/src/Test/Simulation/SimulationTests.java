package Simulation;

import Model.Heatmap;
import Model.Simulation;
import Model.SimulationPoint;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

/**
 * Created by batto on 03-Apr-17.
 */
public class SimulationTests {


    @Test
    public void minAndMaxValueTest() {
        ArrayList<SimulationPoint> points1 = new ArrayList<>();

        points1.add(new SimulationPoint("test1", 0, 1));
        points1.add(new SimulationPoint("test1", 1, 0));
        points1.add(new SimulationPoint("test1", 2, 1));
        points1.add(new SimulationPoint("test1", 3, -5));
        points1.add(new SimulationPoint("test1", 4, 1));
        points1.add(new SimulationPoint("test1", 5, 0));
        points1.add(new SimulationPoint("test1", 6, 10));
        points1.add(new SimulationPoint("test1", 7, 0));


        Simulation sim1 = new Simulation(points1);

        double expectedMin = -5, expectedMax = 10;

        assertEquals(expectedMin, sim1.getMinValue(), 0.1);
        assertEquals(expectedMax, sim1.getMaxValue(), 0.1);

    }
}
