package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by batto on 03-Apr-17.
 */
public class Heatmap extends Simulation implements Serializable {
    public Heatmap(List<Simulation> simulations) {
        super(generateHeatmap(simulations));
    }

    //O(n log(n) + 2n)
    static private List<? extends SimulationPoint> generateHeatmap(List<Simulation> simulations) {
        ArrayList<SimulationPoint> heatmapData = new ArrayList<>();

        //n = total number of simulationpoints
        //O(n)
        for(Simulation s : simulations) {
            for(SimulationPoint point : s.getSimulationPoints()) {
                heatmapData.add(point);
            }
        }

        //O(n log(n))()
        heatmapData.sort(Heatmap::compareDatapointsInTime);

        //O(n)
        heatmapData = sumHeatmapDatapoints(heatmapData);
        setPreviousValues(heatmapData);
        return heatmapData;
    }

    private static void setPreviousValues(List<SimulationPoint> heatmapData) {
        for(int i = 0; i < heatmapData.size(); i++) {
            if(i > 0) {
                heatmapData.get(i).setPreviousValue(heatmapData.get(i - 1).getValue());
            }
        }
    }

    private static ArrayList<SimulationPoint> sumHeatmapDatapoints(List<SimulationPoint> heatmapData) {
        ArrayList<SimulationPoint> result = new ArrayList<>();

        for(SimulationPoint point : heatmapData) {
            SimulationPoint current = null;
            if(result.size() > 0)
                current = result.get(result.size() - 1);
            if(result.size() == 0)
                result.add(point);
            else if(result.get(result.size() - 1).getClock() < point.getClock()) {
                point.setValue((point.getValue() - point.getPreviousValue()) + current.getValue());
                result.add(point);
            }
            else {
                current.setValue(current.getValue() + (point.getValue() - point.getPreviousValue()));
            }
        }

        return result;
    }

    public SimulationPoint getDatapoint(int index) {
        return simulationPoints.get(index);
    }

    private static int compareDatapointsInTime(SimulationPoint s1, SimulationPoint s2) {
        if(s1.getClock() > s2.getClock())
            return 1;
        if(s1.getClock() < s2.getClock())
            return -1;
        return 0;
    }
}
