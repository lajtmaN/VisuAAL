package Model;

import Helpers.UPPAALExecutor;
import View.AlertData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;
import org.xml.sax.SAXException;
import parsers.UPPAALParser;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel implements Externalizable {
    private UPPAALTopology topology;
    private ObservableList<CVar<Integer>> constConfigVars;
    private ObservableList<CVar<Integer>> nonConstConfigVars;
    private ObservableList<TemplateUpdate> templateUpdates;
    private ObservableList<OutputVariable> outputVars;
    private double modelTimeUnit = 1;

    private String modelPath;
    private List<String> processes;

    public UPPAALModel() {} //Only needed for Externalizable
    public UPPAALModel(String path) {
        modelPath = path;
    }

    public void load() {
        ArrayList<CVar<Integer>> allConfigVars = UPPAALParser.getUPPAALConfigConstants(modelPath);
        constConfigVars = FXCollections.observableArrayList(allConfigVars.stream().filter(p -> p.isIsConst()).collect(Collectors.toList()));
        nonConstConfigVars = FXCollections.observableArrayList(allConfigVars.stream().filter(p -> !p.isIsConst()).collect(Collectors.toList()));
        topology = UPPAALParser.getUPPAALTopology(modelPath);
        processes = UPPAALParser.getUPPAALProcesses(modelPath, constConfigVars);
        modelTimeUnit = UPPAALParser.getModelTimeUnitConstant(modelPath);
        outputVars = FXCollections.observableArrayList(UPPAALParser.getUPPAALOutputVars(modelPath, allConfigVars));

        templateUpdates = FXCollections.observableArrayList(UPPAALParser.getDynamicTemplateUpdates(modelPath));
        templateUpdates.add(new TemplateUpdate());
    }

    public UPPAALTopology getTopology() {
        return topology;
    }

    public ObservableList<CVar<Integer>> getConstConfigVars() {
        return constConfigVars;
    }

    public ObservableList<CVar<Integer>> getNonConstConfigVars() {
        return nonConstConfigVars;
    }

    public ObservableList<String> getNonConstConfigVarNames() {
        return FXCollections.observableArrayList(nonConstConfigVars.stream().map(p -> p.getName()).collect(Collectors.toList()));
    }

    public ObservableList<OutputVariable> getOutputVars() {
        return outputVars;
    }

    public String getModelPath() {
        return modelPath;
    }

    public double getModelTimeUnit() {
        return modelTimeUnit;
    }

    public Simulation runSimulation(String query) throws IOException {
        FilteredList<OutputVariable> vars = getOutputVars().filtered(outputVariable -> outputVariable.getIsSelected());
        if (vars.size() > 2)
            throw new InvalidObjectException("We cannot handle multiple outputs yet.");

        OutputVariable variable = vars.get(0);

        SimulateOutput simulateOutput = UPPAALExecutor.provideQueryResult(getModelPath(), query);
        //TODO use errorState on simulateOutput

        //TODO we only use the first simulation
        if (variable.getIsEdgeData()) {
            ArrayList<? extends SimulationPoint> edgePoints = simulateOutput.getZippedForSimulate(0);
            return new Simulation(this, query, edgePoints);
        }
        else if (variable.getIsNodeData()) {
            ArrayList<? extends SimulationPoint> nodePoints = simulateOutput.getZippedNodePoints(0);
            return new Simulation(this, query, nodePoints);
        }
        else
            throw new InvalidObjectException("We do not support showing this yet");
    }

    public ObservableList<TemplateUpdate> getTemplateUpdates() {
        return templateUpdates;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(topology);
        out.writeObject(new ArrayList<>(constConfigVars));
        out.writeObject(new ArrayList<>(nonConstConfigVars));
        out.writeObject(new ArrayList<>(templateUpdates));
        out.writeObject(new ArrayList<>(outputVars));
        out.writeObject(modelPath);
        out.writeDouble(modelTimeUnit);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        topology = (UPPAALTopology) in.readObject();
        constConfigVars = FXCollections.observableArrayList();
        constConfigVars.setAll((ArrayList<CVar<Integer>>) in.readObject());
        nonConstConfigVars = FXCollections.observableArrayList();
        nonConstConfigVars.setAll((ArrayList<CVar<Integer>>) in.readObject());
        templateUpdates = FXCollections.observableArrayList();
        templateUpdates.setAll((ArrayList<TemplateUpdate>) in.readObject());
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll((ArrayList<OutputVariable>) in.readObject());
        modelPath = (String) in.readObject();
        modelTimeUnit = in.readDouble();
    }

    public void addEmptyTemplateUpdate() {
        getTemplateUpdates().add(new TemplateUpdate());
    }

    public AlertData saveTemplateUpdatesToXml() {
        List<TemplateUpdate> updates = templateUpdates.stream().filter(p -> p.getVariable().length() > 0).collect(Collectors.toList());
        if (updates.size() != 0) {
            updates.sort((o1, o2) -> Integer.compare(o1.getTime(), o2.getTime()));

            try {
                XmlHandler handler = new XmlHandler(modelPath);
                handler.addTemplateUpdatesToModel(updates);
            } catch (Exception e) {
                return new AlertData(Alert.AlertType.ERROR, "Error", "Could not save updates to the model");
            }
        }
        return new AlertData(Alert.AlertType.INFORMATION, "Success", "Updates successfully saved to the model");
    }

    public void saveToPath(String newPath) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        XmlHandler handler = new XmlHandler(modelPath);
        handler.writeXMLToFilePath(newPath);
    }

    public List<String> getProcesses() {
        return processes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPPAALModel that = (UPPAALModel) o;

        if (topology != null ? !topology.equals(that.topology) : that.topology != null) return false;
        if (constConfigVars != null ? !constConfigVars.equals(that.constConfigVars) : that.constConfigVars != null) return false;
        if (nonConstConfigVars != null ? !nonConstConfigVars.equals(that.nonConstConfigVars) : that.nonConstConfigVars != null) return false;
        if (templateUpdates != null ? !templateUpdates.equals(that.templateUpdates) : that.templateUpdates != null) return false;
        if (outputVars != null ? !outputVars.equals(that.outputVars) : that.outputVars != null) return false;
        if (modelTimeUnit  != that.modelTimeUnit) return false;
        return modelPath != null ? modelPath.equals(that.modelPath) : that.modelPath == null;
    }

    @Override
    public int hashCode() {
        int result = topology != null ? topology.hashCode() : 0;
        result = 31 * result + (constConfigVars != null ? constConfigVars.hashCode() : 0);
        result = 31 * result + (nonConstConfigVars != null ? nonConstConfigVars.hashCode() : 0);
        result = 31 * result + (templateUpdates != null ? templateUpdates.hashCode() : 0);
        result = 31 * result + (outputVars != null ? outputVars.hashCode() : 0);
        result = 31 * result + (modelPath != null ? modelPath.hashCode() : 0);
        result = 31 * result + (int)modelTimeUnit;
        return result;
    }
}
