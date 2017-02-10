package Model;

import parsers.UPPAALParser;

import java.util.ArrayList;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel {
    private UPPAALTopology topology;
    private ArrayList<CVar<Integer>> constantVars;
    private ArrayList<String> outputVars;

    private String uppaalPath;

    public UPPAALModel(String path) {
        uppaalPath = path;
    }

    public void load() {
        constantVars = UPPAALParser.getUPPAALConfigConstants(uppaalPath);
        topology = UPPAALParser.getUPPAALTopology(uppaalPath);
        outputVars = UPPAALParser.getUPPAALOutputVars(uppaalPath);
    }

    public UPPAALTopology getTopology() {
        return topology;
    }

    public ArrayList<CVar<Integer>> getConstantVars() {
        return constantVars;
    }

    public ArrayList<String> getOutputVars() {
        return outputVars;
    }
}
