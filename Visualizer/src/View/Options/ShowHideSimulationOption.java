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
    }

    @Override
    public String getEnabledDescription() {
        return "Show Simulation " + (simulationId + 1);
    }

    @Override
    public String getDisabledDescription() {
        return "Hide Simulation " + (simulationId + 1);
    }

    @Override
    public void startAction() {
        simulations.showSimulation(simulationId);
    }

    @Override
    public void disableAction() {
        simulations.hideSimulation(simulationId);
    }
}
