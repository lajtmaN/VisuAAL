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
        //simulationId is 0-indexed, but we want to start from 1 when showing
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
