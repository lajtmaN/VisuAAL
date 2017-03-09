package View.Options;

import Model.Simulation;

/**
 * Created by Tim on 09-03-2017.
 */
public abstract class SimulationOption {
    public abstract String getDescription();

    public abstract void performAction(Simulation currentSimulation);
}
