package View.Options;

import Model.OutputVariable;
import Model.Simulations;

/**
 * Created by lajtman on 14-03-2017.
 */
public class ShowHideDataOption extends EnableDisableSimulationOption {

    private OutputVariable variable;

    public ShowHideDataOption(Simulations simulations, OutputVariable var) {
        super(simulations);
        this.variable = var;
        this.onProperty().setValue(false);
    }

    @Override
    public String getEnabledDescription() {
        return "Show " + variable.getName();
    }

    @Override
    public String getDisabledDescription() {
        return "Hide " + variable.getName();
    }

    @Override
    public void startAction() {}

    @Override
    public void disableAction() {}

    public OutputVariable getOutputVariable() {
        return variable;
    }
}
