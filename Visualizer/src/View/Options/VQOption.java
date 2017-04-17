package View.Options;

import Model.Simulations;

/**
 * Created by lajtman on 12-04-2017.
 */
public class VQOption extends EnableDisableSimulationOption {

    private String rawVQExpression;

    public VQOption(Simulations simulations, String rawVQ) {
        super(simulations);
        rawVQExpression = rawVQ;
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
