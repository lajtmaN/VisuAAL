package Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lajtman on 28-03-2017.
 */
public class Simulation implements Serializable {
    private int currentSimulationIndex = 0;

    protected final List<? extends SimulationPoint> simulationPoints;

    public Simulation(List<? extends SimulationPoint> points) {
        this.simulationPoints = points;
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