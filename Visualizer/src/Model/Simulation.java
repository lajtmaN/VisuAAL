package Model;

import View.simulation.SimulationDataContainer;
import javafx.scene.layout.GridPane;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by lajtman on 28-03-2017.
 */
public class Simulation implements Serializable {
    private int currentSimulationIndex = 0;
    private final List<? extends SimulationPoint> run;
    private Simulations parent;
    private boolean shown = false;

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

    void markGraphForward(double newTimeValue, double oldTime, GridPane globalVarGridPane,
                                  SimulationDataContainer varGridPane) {
        SimulationPoint sp;
        //Make sure that more elements at same end time all are included
        while (!((sp = run.get(currentSimulationIndex)).getClock() > newTimeValue)) {
            if (sp.getClock() >= oldTime) {
                boolean shown = pointIsShown(sp, newTimeValue) && sp.getValue() > 0;
                parent.handleUpdate(sp, shown, sp.getValue(), globalVarGridPane, varGridPane);
            }
            if (currentSimulationIndex + 1 >= run.size())
                break;
            if (run.get(currentSimulationIndex + 1).getClock() <= newTimeValue)
                currentSimulationIndex++;
            else break;
        }
    }

    void markGraphBackwards(double newTimeValue, double oldTime, GridPane globalVarGridPane,
                                    SimulationDataContainer varGridPane) {
        SimulationPoint sp;
        while (!((sp = run.get(currentSimulationIndex)).getClock() < newTimeValue)) {
            if (sp.getClock() <= oldTime) {
                boolean shown = pointIsShown(sp, newTimeValue) && sp.getPreviousValue() > 0;
                parent.handleUpdate(sp, shown, sp.getPreviousValue(), globalVarGridPane, varGridPane);
            }
            if (currentSimulationIndex - 1 < 0)
                break;
            if (run.get(currentSimulationIndex - 1).getClock() >= newTimeValue)
                currentSimulationIndex--;
            else break;
        }
    }

    private boolean pointIsShown(SimulationPoint sp, double atTime) {
        return shown && sp.isShown(atTime);
    }
    private boolean pointIsShown(SimulationPoint sp) {
        return pointIsShown(sp, parent.getCurrentTime());
    }

    public void showDataFrom(OutputVariable variable) {
        List<SimulationPoint> simulationPointsForThisVar = relatedSimulationPoints(variable).collect(Collectors.toList());
        simulationPointsForThisVar.forEach(sp -> sp.showVariable());
        if (isShown())
            handleUpdate(simulationPointsForThisVar);
    }

    public void hideDataFrom(OutputVariable variable) {
        List<SimulationPoint> simulationPointsForThisVar = relatedSimulationPoints(variable).collect(Collectors.toList());
        simulationPointsForThisVar.forEach(sp -> sp.hideVariable());
        if (isShown())
            handleUpdate(simulationPointsForThisVar);
    }

    private void handleUpdate(List<? extends SimulationPoint> points) {
        points.forEach(sp -> parent.handleUpdate(sp, pointIsShown(sp)));
    }

    private Stream<? extends SimulationPoint> relatedSimulationPoints(OutputVariable variable) {
        return run.stream().filter(data ->
                data.getType() == variable.getCorrespondingSimulationPointType()
                        && data.getTrimmedIdentifier().equals(variable.getName()));
    }

    public void show() {
        shown = true;
        handleUpdate(run);
    }

    public void hide() {
        shown = false;
        handleUpdate(run);
    }

    public boolean isShown() {
        return shown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simulation that = (Simulation) o;

        if (currentSimulationIndex != that.currentSimulationIndex) return false;
        return run != null ? run.equals(that.run) : that.run == null;
    }

    @Override
    public int hashCode() {
        int result = currentSimulationIndex;
        result = 31 * result + (run != null ? run.hashCode() : 0);
        return result;
    }
}
