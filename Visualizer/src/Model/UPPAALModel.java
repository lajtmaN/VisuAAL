package Model;

import Helpers.GUIHelper;
import Helpers.UPPAALExecutor;
import View.AlertData;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputControl;
import org.xml.sax.SAXException;
import parsers.UPPAALParser;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static parsers.Declaration.VariableParser.updateTopologyAndNrNodes;

/**
 * Created by batto on 10-Feb-17.
 */
public class UPPAALModel implements Externalizable, Cloneable {
    private UPPAALTopology topology;
    private ObservableList<CVar> allConfigVars;
    private ObservableList<CVar> nonConstConfigVars;
    private ObservableList<TemplateUpdate> templateUpdates;
    private ObservableList<OutputVariable> outputVars;
    private double modelTimeUnit = 1;

    private String modelPath;
    private List<UPPAALProcess> processes;

    public UPPAALModel() {} //Only needed for Externalizable
    public UPPAALModel(String path) {
        modelPath = path;
    }

    public void load() {
        allConfigVars = FXCollections.observableArrayList(UPPAALParser.getUPPAALConfigConstants(modelPath));
        nonConstConfigVars = FXCollections.observableArrayList(UPPAALParser.getUPPAALDynamicUpdateCandidates(modelPath));
        topology = UPPAALParser.getUPPAALTopology(modelPath);
        processes = UPPAALParser.getUPPAALProcesses(modelPath, this.allConfigVars);
        modelTimeUnit = UPPAALParser.getModelTimeUnitConstant(modelPath);
        outputVars = FXCollections.observableArrayList(UPPAALParser.getUPPAALOutputVars(modelPath));
        templateUpdates = FXCollections.observableArrayList(UPPAALParser.getDynamicTemplateUpdates(modelPath));
    }

    public UPPAALTopology getTopology() {
        return topology;
    }

    public void setTopology(UPPAALTopology newTopo, boolean updateXML) {
        topology = newTopo;

        if (updateXML) {
            try {
                XmlHandler xmlHandler = new XmlHandler(modelPath);
                String globalDecls = xmlHandler.getGlobalDeclarations();
                String updatedDecls = updateTopologyAndNrNodes(globalDecls, newTopo);
                xmlHandler.setGlobalDeclarations(updatedDecls);
            } catch (Exception ignored) { }
        }
    }

    public ObservableList<CVar> getAllConfigVars() {
        return allConfigVars;
    }

    public ObservableList<CVar> getNonConstConfigVars() {
        return nonConstConfigVars;
    }

    public ObservableList<String> getDynamicTemplateVarNames() {
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

    public CompletableFuture<Simulations> runQuery(String query, TextInputControl feedbackCtrl) throws IOException {
        CompletableFuture<SimulateOutput> simulateOutput = UPPAALExecutor.startUppaalQuery(getModelPath(), query, feedbackCtrl);
        if (simulateOutput == null)
            return null;

        simulateOutput.exceptionally(throwable -> {
            Platform.runLater(() -> GUIHelper.showError(throwable.getMessage()));
            return null;
        });

        return simulateOutput.thenApply(output -> {
            if (output == null)
                return null;

            if (output.getErrorDescription() != null) {
                GUIHelper.showError(output.getErrorDescription());
                return null;
            }

            FilteredList<OutputVariable> vars = getOutputVars().filtered(outputVariable -> outputVariable.getIsSelected());

            List<Simulation> simulationPoints = output.zip(vars);
            return new Simulations(this, query, simulationPoints);
        });
    }

    public ObservableList<TemplateUpdate> getTemplateUpdates() {
        return templateUpdates;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(topology);
        out.writeObject(new ArrayList<>(allConfigVars));
        out.writeObject(new ArrayList<>(nonConstConfigVars));
        out.writeObject(new ArrayList<>(templateUpdates));
        out.writeObject(new ArrayList<>(outputVars));
        out.writeObject(modelPath);
        out.writeDouble(modelTimeUnit);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        topology = (UPPAALTopology) in.readObject();
        allConfigVars = FXCollections.observableArrayList();
        allConfigVars.setAll((ArrayList<CVar>) in.readObject());
        nonConstConfigVars = FXCollections.observableArrayList();
        nonConstConfigVars.setAll((ArrayList<CVar>) in.readObject());
        templateUpdates = FXCollections.observableArrayList();
        templateUpdates.setAll((ArrayList<TemplateUpdate>) in.readObject());
        outputVars = FXCollections.observableArrayList();
        outputVars.setAll((ArrayList<OutputVariable>) in.readObject());
        modelPath = (String) in.readObject();
        modelTimeUnit = in.readDouble();
    }

    public AlertData saveTemplateUpdatesToXml() {
        List<TemplateUpdate> updates = templateUpdates.stream().filter(
                p -> p.getVariableName().length() > 0 && p.getTheValue().length() > 0
                        && p.getTime() >= 0).collect(Collectors.toList());
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

    public List<UPPAALProcess> getProcesses() {
        return processes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPPAALModel that = (UPPAALModel) o;

        if (topology != null ? !topology.equals(that.topology) : that.topology != null) return false;
        if (allConfigVars != null ? !allConfigVars.equals(that.allConfigVars) : that.allConfigVars != null) return false;
        if (nonConstConfigVars != null ? !nonConstConfigVars.equals(that.nonConstConfigVars) : that.nonConstConfigVars != null) return false;
        if (templateUpdates != null ? !templateUpdates.equals(that.templateUpdates) : that.templateUpdates != null) return false;
        if (outputVars != null ? !outputVars.equals(that.outputVars) : that.outputVars != null) return false;
        if (modelTimeUnit  != that.modelTimeUnit) return false;
        return modelPath != null ? modelPath.equals(that.modelPath) : that.modelPath == null;
    }

    @Override
    public int hashCode() {
        int result = topology != null ? topology.hashCode() : 0;
        result = 31 * result + (allConfigVars != null ? allConfigVars.hashCode() : 0);
        result = 31 * result + (nonConstConfigVars != null ? nonConstConfigVars.hashCode() : 0);
        result = 31 * result + (templateUpdates != null ? templateUpdates.hashCode() : 0);
        result = 31 * result + (outputVars != null ? outputVars.hashCode() : 0);
        result = 31 * result + (modelPath != null ? modelPath.hashCode() : 0);
        result = 31 * result + (int)modelTimeUnit;
        return result;
    }

    protected UPPAALModel deepClone() {
        return (UPPAALModel) this.clone();
    }

    @Override
    protected Object clone() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(this);
            out.flush();
            out.close();

            //Make an input stream from the byte array and read again
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            return in.readObject();

        } catch (NotSerializableException nse) {
            GUIHelper.showError("Could not serialize following object when deep cloning UPPAALModel: " + nse.getMessage());
            return null;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
