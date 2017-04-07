package View.Options;

import Model.Simulations;

/**
 * Created by Tim on 09-03-2017.
 */
public abstract class SimulationOption {

    protected final Simulations simulations;

    SimulationOption(Simulations simulations) {
        this.simulations = simulations;
    }

    public abstract String getDescription();

    public abstract void startAction();

    public Simulations getSimulations() {
        return simulations;
    }
    //TODO maybe add icon
}
