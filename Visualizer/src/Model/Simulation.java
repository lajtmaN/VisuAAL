package Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lajtman on 28-03-2017.
 */
public class Simulation implements Serializable {
    private int currentSimulationIndex = 0;

    protected final List<? extends SimulationPoint> simulationPoints;
    private Simulations parentSimulations;
    private boolean shown = false;

    public Simulation(List<? extends SimulationPoint> points) {
        this.simulationPoints = points;
        calculateMinMaxValues();
    }

    public void initialize(Simulations parent, double modelTimeUnit) {
        this.parentSimulations = parent;
        applyModelTimeUnit(modelTimeUnit);
    }

    private void applyModelTimeUnit(double modelTimeUnit) {
        if (modelTimeUnit != 1) {
            for (SimulationPoint p : simulationPoints) {
                p.setClock(p.getClock() * modelTimeUnit);
            }
        }
    }

    public void updateVariable(SimulationPoint sp, double min, double max) {
        /*if (sp.getType() == SimulationPoint.SimulationPointType.Variable)
            updateGlobalVariableInGridPane(sp.getIdentifier(), String.valueOf(sp.getValue()), globalVarGridPane);

        if (sp.getType() == SimulationPoint.SimulationPointType.NodePoint)
                varGridPane.updateVariable(((SimulationNodePoint)sp).getNodeId(), sp.getTrimmedIdentifier(), sp.getValue());*/

        parentSimulations.getTopology().updateVariableGradient(sp, sp.getValue(), min, max);
    }

    private boolean pointIsShown(SimulationPoint sp, double atTime) {
        return shown && sp.isShown(atTime);
    }
    private boolean pointIsShown(SimulationPoint sp) {
        return pointIsShown(sp, parentSimulations.getCurrentTime());
    }

    /*public void showDataFor(OutputVariable variable) {
        List<SimulationPoint> simulationPointsForThisVar = relatedSimulationPoints(variable).collect(Collectors.toList());
        simulationPointsForThisVar.forEach(sp -> sp.showVariable());
        if (isShown())
            handleUpdate(simulationPointsForThisVar);
    }

    public void hideDataFor(OutputVariable variable) {
        List<SimulationPoint> simulationPointsForThisVar = relatedSimulationPoints(variable).collect(Collectors.toList());
        simulationPointsForThisVar.forEach(sp -> sp.hideVariable());
        if (isShown())
            handleUpdate(simulationPointsForThisVar);
    }

    private Stream<? extends SimulationPoint> relatedSimulationPoints(OutputVariable variable) {
        return simulationPoints.stream().filter(data ->
                data.getType() == variable.getCorrespondingSimulationPointType()
                        && data.getTrimmedIdentifier().equals(variable.getName()));
    }*/

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

    private void calculateMinMaxValues(){
        /*minValue= Double.MAX_VALUE;
        maxValue = Double.MIN_VALUE;

        for (SimulationPoint sp : simulationPoints)
        {
            if (sp.getValue() < minValue){
                minValue = sp.getValue();
            }
            if(sp.getValue() > maxValue){
                maxValue = sp.getValue();
            }
        }*/
    }
}