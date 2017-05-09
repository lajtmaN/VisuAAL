package Model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by batto on 03-Apr-17.
 */
public class Heatmap extends Simulation implements Serializable {
    public Heatmap(List<Simulation> simulations) {
        super(generateHeatmap(simulations));
    }

    static private List<SimulationPoint> generateHeatmap(List<Simulation> simulations) {
        ArrayList<SimulationPoint> heatmapData = new ArrayList<>();

        HashMap<String, List<SimulationPoint>> variables = new HashMap<>();

        for(Simulation s : simulations) {
            for(SimulationPoint point : s.getSimulationPoints()) {
                if(point.getType() != SimulationPoint.SimulationPointType.MoveNodePoint) {
                    if (!variables.containsKey(point.getIdentifier()))
                        variables.put(point.getIdentifier(), new ArrayList<>());
                    variables.get(point.getIdentifier()).add(point);
                }
            }
        }

        for(List<SimulationPoint> points : variables.values()) {
            points.sort(Heatmap::compareDatapointsInTime);
            ArrayList<SimulationPoint> variableHeatmapData = avgHeatmapDatapoints(points, simulations.size());
            setPreviousValues(variableHeatmapData);
            heatmapData.addAll(variableHeatmapData);
        }

        heatmapData.sort(Heatmap::compareDatapointsInTime);
        return heatmapData;
    }

    private static void setPreviousValues(List<SimulationPoint> heatmapData) {
        for(int i = 0; i < heatmapData.size(); i++) {
            if(i > 0) {
                heatmapData.get(i).setPreviousValue(heatmapData.get(i - 1).getValue());
            }
        }
    }

    private static ArrayList<SimulationPoint> avgHeatmapDatapoints(List<SimulationPoint> heatmapData, int nrSimulations) {
        ArrayList<SimulationPoint> result = new ArrayList<>();
        if(nrSimulations <= 0) throw new IllegalArgumentException("There are no simulations to create a heatmap from");
        double valueMultiplier = 1 / (double) nrSimulations;

        for(SimulationPoint sp : heatmapData) {
            SimulationPoint current = null;
            SimulationPoint point = createNewSimulationPoint(sp);
            point.setValue(point.getValue()*valueMultiplier); //Account for Average
            point.setPreviousValue(point.getPreviousValue()*valueMultiplier);

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

    private static SimulationPoint createNewSimulationPoint(SimulationPoint sp) {
        switch (sp.getType()) {
            case EdgePoint: return new SimulationEdgePoint((SimulationEdgePoint) sp);
            case NodePoint: return new SimulationNodePoint((SimulationNodePoint) sp);
            case Variable: return new SimulationPoint(sp);
            default: throw new IllegalArgumentException("Heat maps can only edge, node and variable types");
        }
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
