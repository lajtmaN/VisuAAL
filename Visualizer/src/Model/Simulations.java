package Model;

import Helpers.FileHelper;
import Helpers.GUIHelper;
import View.simulation.SimulationDataContainer;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.graphstream.graph.Graph;
import parsers.RegexHelper;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by lajtman on 13-02-2017.
 */
public class Simulations implements Serializable {
    private UPPAALModel model;
    private final List<Simulation> runs;
    private String query;

    public Simulations(UPPAALModel uppModel, String uppQuery, List<Simulation> points) {
        query = uppQuery;
        model = uppModel.deepClone();
        model.getTopology().updateGraph();
        model.getTopology().unmarkAllEdges();

        for (Simulation s : points) {
            s.initialize(this, getModelTimeUnit());
        }
        runs = points;
        runs.get(0).show();
    }

    private Simulation getSimulation(int simId) {
        return runs.get(simId);
    }

    public Graph getGraph() {
        return getTopology().getGraph();
    }

    public UPPAALTopology getTopology() { return model.getTopology(); }

    public List<OutputVariable> getOutputVariables() { return model.getOutputVars(); }

    public double getModelTimeUnit() {
        return model.getModelTimeUnit();
    }

    public int getNumberOfSimulations() {
        return runs.size();
    }

    public void markGraphAtTime(Number oldTimeValue, Number newTimeValue,
                                GridPane globalVarGridPane, SimulationDataContainer varGridPane) {
        if (runs.size() == 0) return;

        runs.stream()
                .filter(run -> run.isShown())
                .forEach(run -> run.markGraphAtTime(oldTimeValue, newTimeValue, globalVarGridPane, varGridPane));}

    void handleUpdate(SimulationPoint sp, double valueOfSp, GridPane globalVarGridPane, SimulationDataContainer varGridPane) {
        if (sp.getType() == SimulationPoint.SimulationPointType.Variable)
            updateGlobalVariableInGridPane(sp.getIdentifier(), String.valueOf(valueOfSp), globalVarGridPane);

        if (sp.getType() == SimulationPoint.SimulationPointType.NodePoint)
            varGridPane.updateVariable(((SimulationNodePoint)sp).getNodeId(), sp.getTrimmedIdentifier(), valueOfSp);

        handleUpdate(sp, valueOfSp > 0);
    }

    void handleUpdate(SimulationPoint sp, boolean mark) {
        model.getTopology().handleUpdate(sp, mark);
    }

    public void showDataFrom(OutputVariable variable) {
        runs.forEach(run -> run.showDataFrom(variable));
    }

    public void hideDataFrom(OutputVariable variable) {
        runs.forEach(run -> run.hideDataFrom(variable));
    }

    public void showSimulation(int simulationId) {
        getSimulation(simulationId).show();
    }

    public void hideSimulation(int simulationId) {
        getSimulation(simulationId).hide();
    }

    public int queryTimeBound() {
        return Integer.parseInt(RegexHelper.getFirstMatchedValueFromRegex("\\[<=(\\d+)\\]", query));
    }

    public void save(String fileName){
        try {
            File file = new File(FileHelper.simulationFileName(fileName));
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file,false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static Simulations load(String fileName) {
        return load(new File(FileHelper.simulationFileName(fileName)));
    }
    public static Simulations load(File file){
        if (!Objects.equals(FileHelper.getExtension(file.getName()), ".sim"))
            throw new IllegalArgumentException("Only files with named *.sim can be loaded");

        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Simulations sim = (Simulations) in.readObject();
            in.close();
            fileIn.close();
            sim.model.getTopology().updateGraph();
            sim.model.getTopology().unmarkAllEdges();
            return sim;
        } catch(InvalidClassException i) {
            GUIHelper.showAlert(Alert.AlertType.ERROR, "The simulation that you tried to load was created by an older version of this program.");
        } catch (Exception ignored) {

        }
        return null;
    }

    private void addGlobalVariableToGridPane(String name, String value, GridPane globalVarGridPane) {
        int nrRows = globalVarGridPane.getChildren().size() / 2;
        Label labelName = new Label(name);
        Label labelValue = new Label(value);
        labelName.setPadding(new Insets(0,10, 0, 0));

        globalVarGridPane.add(labelName, 0, nrRows);
        globalVarGridPane.add(labelValue, 1, nrRows);
    }

    private void updateGlobalVariableInGridPane(String name, String value, GridPane globalVarGridPane) {
        boolean foundLabel = false;
        for(Node n : globalVarGridPane.getChildren()){
            Label label = (Label) n;
            if(foundLabel) {
                label.setText(value);
                break;
            }
            if(label.getText().equals(name)) {
                foundLabel = true;
            }
        }
        if(!foundLabel) {
            addGlobalVariableToGridPane(name, value, globalVarGridPane);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simulations that = (Simulations) o;

        if (!model.equals(that.model)) return false;
        if (!runs.equals(that.runs)) return false;
        return query.equals(that.query);
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + runs.hashCode();
        result = 31 * result + query.hashCode();
        return result;
    }
}
