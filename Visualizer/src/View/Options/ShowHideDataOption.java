package View.Options;

import Model.OutputVariable;
import Model.Simulations;

/**
 * Created by lajtman on 14-03-2017.
 */
public class ShowHideDataOption extends EnableDisableSimulationOption {

    private OutputVariable variable;

    public ShowHideDataOption(OutputVariable var) {
        this.variable = var;
    }

    @Override
    public String getDescription() {
        if (onProperty().get())
            return "Show " + variable.getName();
        else
            return "Hide " + variable.getName();
    }

    @Override
    public void startAction(Simulations currentSimulations) {
        //TODO:
        currentSimulations.showDataFrom(variable);

    }

    @Override
    public void disableAction(Simulations currentSimulations) {
        //TODO:
        currentSimulations.hideDataFrom(variable);

    }
}
