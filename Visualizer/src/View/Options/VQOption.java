package View.Options;

import Model.Simulations;
import Model.UPPAALTopology;
import Model.VQ.VQParseTree;
import View.simulation.SimulationMenuController;
import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
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
        //TODO: Fast and ugly hack. Cannot call the disable action when changing variables.
        if(SimulationMenuController.doGraphReset) {
            switch (type) {
                case Edge:
                    for (Edge e : simulations.getTopology().getGraph().getEdgeSet()) {
                        e.addAttribute("ui.style", "fill-color:" + "black" + ";");
                    }
                    //TODO: create a real method for this.
                    simulations.setMinEdgeValue(0);
                    break;
                case Node:
                    for (Node n : simulations.getTopology().getGraph().getNodeSet()) {
                        n.addAttribute("ui.style", "fill-color:" + "black" + ";");
                    }
                    //TODO: create a real method for this.
                    simulations.setMinNodeValue(0);
                    break;
            }
        }
    }

    @Override
    public String getDescription() {
        return rawVQExpression; //TODO: Maybe only show what comes after the []
    }

    public VQParseTree.VQType getType() {
        return type;
    }
}
