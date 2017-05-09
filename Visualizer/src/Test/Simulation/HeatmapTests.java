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
public class HeatmapTests {

    @Test
    public void TwoBoolSimulationsToHeatmap() {
        ArrayList<SimulationPoint> points1 = new ArrayList<>(),
                                   points2 = new ArrayList<>();

        points1.add(new SimulationPoint("test1", 0, 1, 0));
        points1.add(new SimulationPoint("test1", 1, 0, 1));
        points1.add(new SimulationPoint("test1", 2, 1, 0));
        points1.add(new SimulationPoint("test1", 3, 0, 1));
        points1.add(new SimulationPoint("test1", 4, 1, 0));
        points1.add(new SimulationPoint("test1", 5, 0, 1));
        points1.add(new SimulationPoint("test1", 6, 1, 0));
        points1.add(new SimulationPoint("test1", 7, 0, 1));

        points2.add(new SimulationPoint("test1", 0, 1, 0));
        points2.add(new SimulationPoint("test1", 2, 0, 1));
        points2.add(new SimulationPoint("test1", 4, 1, 0));
        points2.add(new SimulationPoint("test1", 7, 0, 1));

        Simulation sim1 = new Simulation(points1),
                   sim2 = new Simulation(points2);

        ArrayList<Simulation> simulations = new ArrayList<>();
        simulations.add(sim1);
        simulations.add(sim2);

        Heatmap heatmap = new Heatmap(simulations);

        equalsData(0, 1, 0, heatmap.getDatapoint(0));
        equalsData(1, 0.5, 1, heatmap.getDatapoint(1));
        equalsData(2, 0.5, 0.5, heatmap.getDatapoint(2));
        equalsData(3, 0, 0.5, heatmap.getDatapoint(3));
        equalsData(4, 1, 0, heatmap.getDatapoint(4));
        equalsData(5, 0.5, 1, heatmap.getDatapoint(5));
        equalsData(6, 1, 0.5, heatmap.getDatapoint(6));
        equalsData(7, 0, 1, heatmap.getDatapoint(7));
    }

    @Test
    public void ThreeIntSimulationsToHeatmap() {
        ArrayList<SimulationPoint> points1 = new ArrayList<>(),
                points2 = new ArrayList<>(),
                points3 = new ArrayList<>();

        points1.add(new SimulationPoint("test2", 0, 8, 0));
        points1.add(new SimulationPoint("test2", 1, 10, 8));
        points1.add(new SimulationPoint("test2", 2, 2, 10));
        points1.add(new SimulationPoint("test2", 5, -2, 2));
        points1.add(new SimulationPoint("test2", 6, 10, -2));

        points2.add(new SimulationPoint("test2", 0, 6, 0));
        points2.add(new SimulationPoint("test2", 1, 4, 6));
        points2.add(new SimulationPoint("test2", 5, 0, 4));
        points2.add(new SimulationPoint("test2", 6, 3, 0));


        points3.add(new SimulationPoint("test2", 0, 0, 0));
        points3.add(new SimulationPoint("test2", 2, 5, 0));
        points3.add(new SimulationPoint("test2", 5, -1, 5));
        points3.add(new SimulationPoint("test2", 6, 15, -1));


        Simulation sim1 = new Simulation(points1),
                sim2 = new Simulation(points2),
                sim3 = new Simulation(points3);

        ArrayList<Simulation> simulations = new ArrayList<>();
        simulations.add(sim1);
        simulations.add(sim2);
        simulations.add(sim3);

        Heatmap heatmap = new Heatmap(simulations);

        equalsData(0, 14/3.0, 0/3.0, heatmap.getDatapoint(0));
        equalsData(1, 14/3.0, 14/3.0, heatmap.getDatapoint(1));
        equalsData(2, 11/3.0, 14/3.0, heatmap.getDatapoint(2));
        equalsData(5, -3/3.0, 11/3.0, heatmap.getDatapoint(3));
        equalsData(6, 28/3.0, -3/3.0, heatmap.getDatapoint(4));
    }


    private void equalsData(int expectedTime, double expectedValue, double expectedPreviousValue, SimulationPoint point) {
        assertEquals(expectedTime, point.getClock(), 0.1);
        assertEquals(expectedValue, point.getValue(), 0.1);
        assertEquals(expectedPreviousValue, point.getPreviousValue(), 0.1);
    }
}