package View.Options;

import Model.Simulations;

/**
 * Created by Tim on 09-03-2017.
 */
public abstract class SimulationOption {
    public abstract String getDescription();

    public abstract void startAction(Simulations currentSimulations);

    //TODO maybe add icon
}
