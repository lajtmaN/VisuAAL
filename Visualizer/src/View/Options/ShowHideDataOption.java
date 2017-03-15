package View.Options;

import Model.OutputVariable;
import Model.Simulation;

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
    public void startAction(Simulation currentSimulation) {
        //TODO:
        currentSimulation.showDataFrom(variable);

    }

    @Override
    public void disableAction(Simulation currentSimulation) {
        //TODO:
        currentSimulation.hideDataFrom(variable);

    }
}
