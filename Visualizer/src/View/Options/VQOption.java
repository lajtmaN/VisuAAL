package View.Options;

import Model.Simulations;
import Model.VQ.VQParseTree;
import parsers.VQParser.VQParse;

/**
 * Created by lajtman on 12-04-2017.
 */
public class VQOption extends EnableDisableSimulationOption {

    private String rawVQExpression;
    private VQParseTree parsedVQ;
    private VQParseTree.VQType type;

    public VQOption(Simulations simulations, String rawVQ) {
        super(simulations);
        rawVQExpression = rawVQ;
        VQParseTree parsed = VQParse.parse(rawVQ, simulations.getOutputVariables());
        parsedVQ = parsed;
        type = parsed.getType();
    }

    @Override
    public void startAction() {
        switch (type) {
            case Edge:
                simulations.setShownEdgeVariable(parsedVQ);
                break;
            case Node:
                simulations.setShownNodeVariable(parsedVQ);
                break;
        }
    }

    @Override
    public void disableAction() {
        //TODO: Should anything happen when a option is disabled?
    }

    @Override
    public String getDescription() {
        return rawVQExpression; //TODO: Maybe only show what comes after the []
    }

    public VQParseTree.VQType getType() {
        return type;
    }
}
