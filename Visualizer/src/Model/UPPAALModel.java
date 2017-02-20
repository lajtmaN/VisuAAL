package Model;

import Helpers.GUIHelper;
import Helpers.UPPAALExecutor;
import View.AlertData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.xml.sax.SAXException;
import parsers.RegexHelper;
import parsers.UPPAALParser;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel implements Externalizable {
    private UPPAALTopology topology;
    private ArrayList<CVar<Integer>> configVars;
    //TODO: Should maybe not be transient in the future
    private ObservableList<TemplateUpdate> templateUpdates;
    private ObservableList<OutputVariable> outputVars;

    private String modelPath;

    public UPPAALModel() {} //Only needed for Externalizable
    public UPPAALModel(String path) {
        modelPath = path;
    }

    public void load() {
        configVars = UPPAALParser.getUPPAALConfigConstants(modelPath);
        topology = UPPAALParser.getUPPAALTopology(modelPath);
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll(UPPAALParser.getUPPAALOutputVars(modelPath, configVars));
        templateUpdates = FXCollections.observableArrayList();
        templateUpdates.add(new TemplateUpdate());
    }

    public UPPAALTopology getTopology() {
        return topology;
    }

    public ArrayList<CVar<Integer>> getConfigVars() {
        return configVars;
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
        if (configVars != null ? !configVars.equals(that.configVars) : that.configVars != null) return false;
        if (templateUpdates != null ? !templateUpdates.equals(that.templateUpdates) : that.templateUpdates != null)
            return false;
        if (outputVars != null ? !outputVars.equals(that.outputVars) : that.outputVars != null) return false;
        return modelPath != null ? modelPath.equals(that.modelPath) : that.modelPath == null;
    }

    @Override
    public int hashCode() {
        int result = topology != null ? topology.hashCode() : 0;
        result = 31 * result + (configVars != null ? configVars.hashCode() : 0);
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
        out.writeObject(configVars);
        out.writeObject(new ArrayList<>(templateUpdates));
        out.writeObject(new ArrayList<>(outputVars));
        out.writeObject(modelPath);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        topology = (UPPAALTopology) in.readObject();
        configVars = (ArrayList<CVar<Integer>>) in.readObject();
        templateUpdates = FXCollections.observableArrayList();
        templateUpdates.setAll((ArrayList<TemplateUpdate>) in.readObject());
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll((ArrayList<OutputVariable>) in.readObject());
        modelPath = (String) in.readObject();
    }

    public void addEmptyTemplateUpdate() {
        getTemplateUpdates().add(new TemplateUpdate());
    }

    public AlertData saveTemplateUpdatesToXml() {
        AlertData alert = null;
        String notFoundMsg = "The output variables are not found:";
        String constMsg = "The following variables are constants:";
        boolean addNotFoundMsg = false;
        boolean addIsConstMsg = false;

        try {
            XmlHandler handler = new XmlHandler(modelPath);
            ArrayList<TemplateUpdate> out = new ArrayList<>();

            for (TemplateUpdate t : this.getTemplateUpdates()) {
                boolean foundAsNonConst = false,
                        foundAsConst = false;
                for (CVar v : configVars) {
                    if (RegexHelper.variableNameMatches(t.getVariable(), v.getName())) {
                        if (v.isIsConst())
                            foundAsConst = true;
                        else
                            foundAsNonConst = true;
                    }
                }
                if (foundAsConst) {
                    addIsConstMsg = true;
                    constMsg += " " + t.getVariable();
                } else if (foundAsNonConst)
                    out.add(t);
                else if (!t.getVariable().equals("")) {
                    addNotFoundMsg = true;
                    notFoundMsg += " " + t.getVariable();
                }
            }

            String msg = "";
            if (addIsConstMsg)
                msg += constMsg;
            if (addNotFoundMsg)
                msg += "\n" + notFoundMsg;
            if (!msg.equals("")) {
                alert = new AlertData(Alert.AlertType.INFORMATION, "Invalid variables - No changes made", msg);
            } else if (out.size() != 0) {
                out.sort((o1, o2) -> o1.getTime() > o2.getTime() ? 1 : (o2.getTime() > o1.getTime() ? -1 : 0));
                handler.addTemplateUpdatesToModel(out);
                GUIHelper.showAlert(Alert.AlertType.INFORMATION, "Variables updates are added to the model", "Success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alert;
    }

    public void saveToPath(String newPath) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        XmlHandler handler = new XmlHandler(modelPath);
        modelPath = newPath;
        handler.writeXMLToFilePath(modelPath);
    }
}
