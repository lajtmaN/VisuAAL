package Model;

import Helpers.UPPAALExecutor;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.graphstream.graph.Graph;
import parsers.RegexHelper;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lajtman on 13-02-2017.
 */
public class Simulation {

    private UPPAALModel model;
    private ArrayList<SimulationEdgePoint> run;
    private String query;

    public Simulation(UPPAALModel uppModel, String uppQuery) throws IOException {
        query = uppQuery;
        model = uppModel;
        //TODO we only use the first simulation
        run = UPPAALExecutor.provideQueryResult(uppModel.getUppaalPath(), uppQuery).getZippedForSimulate(0);
        model.getTopology().setEdges(run);
        model.getTopology().updateGraph();
        model.getTopology().unmarkAllEdges();
    }

    public Graph getGraph() {
        return model.getTopology().getGraph();
    }

    public void markEdgeAtTime(Number newValue) {
        model.getTopology().unmarkAllEdges();
        run.stream().filter(p -> p.getClock() < newValue.doubleValue() && p.getValue() > 0).forEach(p -> model.getTopology().markEdge(p));
    }

    public void markEdgesInRealTime() {
        model.getTopology().unmarkAllEdges();
        model.getTopology().startAddingEdgesOverTime(run);
    }

    public int queryTimeBound() {
        return Integer.parseInt(RegexHelper.getFirstMatchedValueFromRegex("\\[<=(\\d+)\\]", query));
    }
}
