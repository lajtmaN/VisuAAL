package View.simulation;

import Model.SimulateOutput;
import Model.SimulationPoint;
import javafx.event.Event;

/**
 * Created by batto on 07-Apr-17.
 */
public interface VariablesUpdateObservable {
    void addListener(VariableUpdateObserver observer);
    void removeListener(VariableUpdateObserver observer);
    void updateAllObservers(SimulationPoint sp, double value);
}