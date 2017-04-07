package View.simulation;

import Model.SimulateOutput;
import Model.SimulationPoint;

/**
 * Created by batto on 07-Apr-17.
 */
public interface VariableUpdateObserver {
    void update(SimulationPoint sp, double value);
}
