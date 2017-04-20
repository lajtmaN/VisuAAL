package View.Options;

import Model.Simulations;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Created by lajtman on 14-03-2017.
 */
public abstract class EnableDisableSimulationOption extends SimulationOption  {

    public EnableDisableSimulationOption(Simulations simulations) {
        super(simulations);
        onProperty.addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                startAction();
            } else {
                disableAction();
            }
        });
    }

    private BooleanProperty onProperty = new SimpleBooleanProperty(false);

    public BooleanProperty onProperty() {
        return onProperty;
    }

    public abstract void disableAction();
}