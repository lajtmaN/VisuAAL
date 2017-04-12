package View.Options;

import Model.Simulations;
import Model.VQ.VQExpression;

/**
 * Created by lajtman on 12-04-2017.
 */
public class VQOption extends EnableDisableSimulationOption {

    private VQExpression expression;

    public VQOption(Simulations simulations, VQExpression expression) {
        super(simulations);
    }

    @Override
    public void startAction() {

    }

    @Override
    public void disableAction() {

    }

    @Override
    public String getEnabledDescription() {
        return "TEST!";
    }

    @Override
    public String getDisabledDescription() {
        return "TEST!";
    }
}
