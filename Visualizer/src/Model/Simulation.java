package Model;

import View.simulation.SimulationDataContainer;
import javafx.scene.layout.GridPane;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by lajtman on 28-03-2017.
 */
public class Simulation implements Serializable {
    private int currentSimulationIndex = 0;
    private double currentTime = 0;
    private final List<? extends SimulationPoint> run;
    private Simulations parent;

    public Simulation(List<? extends SimulationPoint> points) {
        this.run = points;
    }

    public void initialize(Simulations parent, double modelTimeUnit) {
        this.parent = parent;
        applyModelTimeUnit(modelTimeUnit);
    }

    private void applyModelTimeUnit(double modelTimeUnit) {
        if (modelTimeUnit != 1) {
            for (SimulationPoint p : run) {
                p.setClock(p.getClock() * modelTimeUnit);
            }
        }
    }

    public void markGraphAtTime(Number oldTimeValue, Number newTimeValue,
                                GridPane globalVarGridPane, SimulationDataContainer varGridPane) {
        double newTime = newTimeValue.doubleValue();
        double oldTime = oldTimeValue.doubleValue();
        if (newTime > oldTime)
            markGraphForward(newTime, oldTime, globalVarGridPane, varGridPane);
        else
            markGraphBackwards(newTime, oldTime, globalVarGridPane, varGridPane);

        currentTime = newTime;
    }

    private void markGraphForward(double newTimeValue, double oldTime, GridPane globalVarGridPane,
                                  SimulationDataContainer varGridPane) {
        SimulationPoint sp;
        //Make sure that more elements at same end time all are included
        while (!((sp = run.get(currentSimulationIndex)).getClock() > newTimeValue)) {
            if (sp.getClock() >= oldTime) {
                parent.handleUpdate(sp, sp.getValue(), globalVarGridPane, varGridPane);
            }
            if (currentSimulationIndex + 1 >= run.size())
                break;
            if (run.get(currentSimulationIndex + 1).getClock() <= newTimeValue)
                currentSimulationIndex++;
            else break;
        }
    }

    private void markGraphBackwards(double newTimeValue, double oldTime, GridPane globalVarGridPane,
                                    SimulationDataContainer varGridPane) {
        SimulationPoint sp;
        while (!((sp = run.get(currentSimulationIndex)).getClock() < newTimeValue)) {
            if (sp.getClock() <= oldTime) {
                parent.handleUpdate(sp, sp.getPreviousValue(), globalVarGridPane, varGridPane);
            }
            if (currentSimulationIndex - 1 < 0)
                break;
            if (run.get(currentSimulationIndex - 1).getClock() >= newTimeValue)
                currentSimulationIndex--;
            else break;
        }
    }

    Stream<? extends SimulationPoint> relatedSimulationPoints(OutputVariable variable) {
        return run.stream().filter(data ->
                data.getType() == variable.getCorrespondingSimulationPointType()
                        && data.getTrimmedIdentifier().equals(variable.getName()));
    }

    public double getCurrentTime() {
        return currentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simulation that = (Simulation) o;

        if (currentSimulationIndex != that.currentSimulationIndex) return false;
        if (Double.compare(that.currentTime, currentTime) != 0) return false;
        return run != null ? run.equals(that.run) : that.run == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = currentSimulationIndex;
        temp = Double.doubleToLongBits(currentTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (run != null ? run.hashCode() : 0);
        return result;
    }
}
