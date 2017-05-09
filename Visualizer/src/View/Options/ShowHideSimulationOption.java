package View.Options;

import Model.Simulations;

/**
 * Created by lajtman on 28-03-2017.
 */
public class ShowHideSimulationOption extends EnableDisableSimulationOption {
    private final int simulationId;

    public ShowHideSimulationOption(Simulations simulations, int simulationId) {
        super(simulations);
        this.simulationId = simulationId;

        if (simulationId == 0) //Only the first simulation is marked as shown at start
            onProperty().set(true);
    }

    @Override
    public String getDescription() {
        return simulationId == 0 ? "Average Of Simulations" : "Simulation " + simulationId;
    }

    @Override
    public void startAction() {
        simulations.showSimulation(simulationId);
    }

    @Override
    public void disableAction() {
        //simulations.hideSimulation(simulationId);
    }

    public int getSimulationId() {
        return simulationId;
    }
}
