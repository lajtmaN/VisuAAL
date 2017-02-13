package Model;

import Helpers.UPPAALExecutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import parsers.UPPAALParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel {
    private UPPAALTopology topology;
    private ArrayList<CVar<Integer>> constantVars;
    private ObservableList<OutputVariable> outputVars = FXCollections.observableArrayList();

    private String uppaalPath;

    public UPPAALModel(String path) {
        uppaalPath = path;
    }

    public void load() {
        constantVars = UPPAALParser.getUPPAALConfigConstants(uppaalPath);
        topology = UPPAALParser.getUPPAALTopology(uppaalPath);
        outputVars.setAll(UPPAALParser.getUPPAALOutputVars(uppaalPath, constantVars));
    }

    public UPPAALTopology getTopology() {
        return topology;
    }

    public ArrayList<CVar<Integer>> getConstantVars() {
        return constantVars;
    }

    public ObservableList<OutputVariable> getOutputVars() {
        return outputVars;
    }

    public SimulateOutput runSimulation(String query) throws IOException {
        return UPPAALExecutor.provideQueryResult(uppaalPath, query);
    }
}
