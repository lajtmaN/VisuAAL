package Model;

import Helpers.Pair;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lajtman on 28-03-2017.
 */
public class Simulation implements Serializable {
    private int currentSimulationIndex = 0;

    private Map<String, Pair<Double, Double>> minMaxValueMap;
    protected List<SimulationPoint> simulationPoints;

    public Simulation(List<SimulationPoint> points) {
        this.simulationPoints = points;
        minMaxValueMap = new HashMap<>();
        for(SimulationPoint p : points) {
            minMaxValueMap.putIfAbsent(p.getTrimmedIdentifier(), new Pair<> (0.0,0.0));
            Pair<Double, Double> minmax = minMaxValueMap.get(p.getTrimmedIdentifier());
            if(p.getValue() < minmax.getFirst()){
                minmax.setFirst(p.getValue());
            }
            if(p.getValue() > minmax.getSecond()){
                minmax.setSecond(p.getValue());
            }
        }
    }

    public void initialize(double modelTimeUnit) {
        applyModelTimeUnit(modelTimeUnit);
    }

    private void applyModelTimeUnit(double modelTimeUnit) {
        if (modelTimeUnit != 1) {
            for (SimulationPoint p : simulationPoints) {
                p.setClock(p.getClock() * modelTimeUnit);
            }
        }
    }

    public Map<String, Pair<Double, Double>> getMinMaxValueMap() {
        return minMaxValueMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simulation that = (Simulation) o;

        if (currentSimulationIndex != that.currentSimulationIndex) return false;
        return simulationPoints != null ? simulationPoints.equals(that.simulationPoints) : that.simulationPoints == null;
    }

    @Override
    public int hashCode() {
        int result = currentSimulationIndex;
        result = 31 * result + (simulationPoints != null ? simulationPoints.hashCode() : 0);
        return result;
    }

    public List<? extends SimulationPoint> getSimulationPoints() {
        return simulationPoints;
    }
}