package Model;

import Helpers.UPPAALExecutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Slider;
import parsers.UPPAALParser;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel implements Serializable {
    private UPPAALTopology topology;
    private ArrayList<CVar<Integer>> constantVars;
    //TODO: Should maybe not be transient in the future
    private transient ObservableList<TemplateUpdate> templateUpdates;
    private transient ObservableList<OutputVariable> outputVars;

    private String uppaalPath;

    public UPPAALModel(String path) {
        uppaalPath = path;
    }

    public void load() {
        constantVars = UPPAALParser.getUPPAALConfigConstants(uppaalPath);
        topology = UPPAALParser.getUPPAALTopology(uppaalPath);
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll(UPPAALParser.getUPPAALOutputVars(uppaalPath, constantVars));
        templateUpdates = FXCollections.observableArrayList();
        templateUpdates.add(new TemplateUpdate());
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

    public String getUppaalPath() {
        return uppaalPath;
    }

    public Simulation runSimulation(String query) throws IOException {
        //TODO we only use the first simulation
        ArrayList<SimulationEdgePoint> points = UPPAALExecutor.provideQueryResult(getUppaalPath(), query)
                .getZippedForSimulate(0);
        return new Simulation(this, query, points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPPAALModel that = (UPPAALModel) o;

        if (!topology.equals(that.topology)) return false;
        if (!constantVars.equals(that.constantVars)) return false;
        return uppaalPath.equals(that.uppaalPath);
    }

    @Override
    public int hashCode() {
        int result = topology.hashCode();
        result = 31 * result + constantVars.hashCode();
        result = 31 * result + outputVars.hashCode();
        result = 31 * result + uppaalPath.hashCode();
        return result;
    }

    public void updateUpdates(ObservableList<TemplateUpdate> items) {
        templateUpdates = items;
    }

    public ObservableList<TemplateUpdate> getTemplateUpdates() {
        return templateUpdates;
    }
}
