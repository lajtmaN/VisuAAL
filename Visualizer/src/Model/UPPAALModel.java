package Model;

import Helpers.GUIHelper;
import Helpers.UPPAALExecutor;
import com.lowagie.text.Paragraph;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import parsers.RegexHelper;
import parsers.UPPAALParser;
import parsers.XmlHandler;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel implements Externalizable {
    private UPPAALTopology topology;
    private ArrayList<CVar<Integer>> constantVars;
    //TODO: Should maybe not be transient in the future
    private ObservableList<TemplateUpdate> templateUpdates;
    private ObservableList<OutputVariable> outputVars;

    private String modelPath;

    public UPPAALModel() {} //Only needed for Externalizable
    public UPPAALModel(String path) {
        modelPath = path;
    }

    public void load() {
        constantVars = UPPAALParser.getUPPAALConfigConstants(modelPath);
        topology = UPPAALParser.getUPPAALTopology(modelPath);
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll(UPPAALParser.getUPPAALOutputVars(modelPath, constantVars));
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

    public String getModelPath() {
        return modelPath;
    }

    public Simulation runSimulation(String query) throws IOException {
        //TODO we only use the first simulation
        SimulateOutput simulateOutput = UPPAALExecutor.provideQueryResult(getModelPath(), query);
        //TODO use errorState on simulateOutput
        ArrayList<SimulationEdgePoint> points = simulateOutput.getZippedForSimulate(0);
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
        return modelPath != null ? modelPath.equals(that.modelPath) : that.modelPath == null;
    }

    @Override
    public int hashCode() {
        int result = topology != null ? topology.hashCode() : 0;
        result = 31 * result + (constantVars != null ? constantVars.hashCode() : 0);
        result = 31 * result + (templateUpdates != null ? templateUpdates.hashCode() : 0);
        result = 31 * result + (outputVars != null ? outputVars.hashCode() : 0);
        result = 31 * result + (modelPath != null ? modelPath.hashCode() : 0);
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
        out.writeObject(modelPath);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        topology = (UPPAALTopology) in.readObject();
        constantVars = (ArrayList<CVar<Integer>>) in.readObject();
        templateUpdates = FXCollections.observableArrayList();
        templateUpdates.setAll((ArrayList<TemplateUpdate>) in.readObject());
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll((ArrayList<OutputVariable>) in.readObject());
        modelPath = (String) in.readObject();
    }

    public void addEmptyTemplateUpdate() {
        getTemplateUpdates().add(new TemplateUpdate());
    }

    public void saveTemplateUpdatesToXml() {
        String errorMsg = "The output variables are not found:";

        try{
            XmlHandler handler = new XmlHandler(modelPath);
            ArrayList<TemplateUpdate> out = new ArrayList<>();
            ArrayList<TemplateUpdate> notFound = new ArrayList<>();

            for (TemplateUpdate t : this.getTemplateUpdates()) {
                boolean exists = false;
                for (OutputVariable v : outputVars) {
                    if(RegexHelper.variableNameMatches(t.getVariable(), v.getName()))
                        exists = true;
                }
                if(exists)
                    out.add(t);
                else {
                    notFound.add(t);
                    errorMsg += " " + t.getVariable() + " ";
                }
            }

            GUIHelper.showAlert(Alert.AlertType.INFORMATION, errorMsg);
            if(out.size() > 0)
                handler.addTemplateUpdatesToModel(out);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
