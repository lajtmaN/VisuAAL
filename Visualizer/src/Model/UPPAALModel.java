package Model;

import Helpers.UPPAALExecutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Slider;
import parsers.UPPAALParser;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel implements Externalizable {
    private UPPAALTopology topology;
    private ArrayList<CVar<Integer>> constantVars;
    //TODO: Should maybe not be transient in the future
    private ObservableList<TemplateUpdate> templateUpdates;
    private ObservableList<OutputVariable> outputVars;

    private String uppaalPath;

    public UPPAALModel() {} //Only needed for Externalizable
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

        if (topology != null ? !topology.equals(that.topology) : that.topology != null) return false;
        if (constantVars != null ? !constantVars.equals(that.constantVars) : that.constantVars != null) return false;
        if (templateUpdates != null ? !templateUpdates.equals(that.templateUpdates) : that.templateUpdates != null)
            return false;
        if (outputVars != null ? !outputVars.equals(that.outputVars) : that.outputVars != null) return false;
        return uppaalPath != null ? uppaalPath.equals(that.uppaalPath) : that.uppaalPath == null;
    }

    @Override
    public int hashCode() {
        int result = topology != null ? topology.hashCode() : 0;
        result = 31 * result + (constantVars != null ? constantVars.hashCode() : 0);
        result = 31 * result + (templateUpdates != null ? templateUpdates.hashCode() : 0);
        result = 31 * result + (outputVars != null ? outputVars.hashCode() : 0);
        result = 31 * result + (uppaalPath != null ? uppaalPath.hashCode() : 0);
        return result;
    }

    public void updateUpdates(ObservableList<TemplateUpdate> items) {
        templateUpdates = items;
    }

    public ObservableList<TemplateUpdate> getTemplateUpdates() {
        return templateUpdates;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(topology);
        out.writeObject(constantVars);
        out.writeObject(new ArrayList<>(templateUpdates));
        out.writeObject(new ArrayList<>(outputVars));
        out.writeObject(uppaalPath);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        topology = (UPPAALTopology) in.readObject();
        constantVars = (ArrayList<CVar<Integer>>) in.readObject();
        templateUpdates = FXCollections.observableArrayList();
        templateUpdates.setAll((ArrayList<TemplateUpdate>) in.readObject());
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll((ArrayList<OutputVariable>) in.readObject());
        uppaalPath = (String) in.readObject();
    }

    public void addEmptyTemplateUpdate() {
        getTemplateUpdates().add(new TemplateUpdate());
    }
}
