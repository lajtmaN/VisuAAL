package View.Options;

import Model.Simulations;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Created by lajtman on 14-03-2017.
 */
public abstract class EnableDisableSimulationOption extends SimulationOption  {

    private BooleanProperty onProperty;

    public BooleanProperty onProperty() {
        if (onProperty == null)
            onProperty = new SimpleBooleanProperty(true);
        return onProperty;
    }

    public abstract void disableAction(Simulations currentSimulations);
}
