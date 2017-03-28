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
    public void startAction() {
        simulations.showDataFrom(variable);
    }

    @Override
    public void disableAction() {
        simulations.hideDataFrom(variable);
    }
}
