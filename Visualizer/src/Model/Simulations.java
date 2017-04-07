package Model;

import Helpers.FileHelper;
import Helpers.GUIHelper;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.graphstream.graph.Graph;
import parsers.RegexHelper;

import java.io.*;
import java.util.*;

/**
 * Created by lajtman on 13-02-2017.
 */
public class Simulations implements Serializable {
    private UPPAALModel model;
    private final List<Simulation> simulations;
    private Simulation shownSimulation;

    private OutputVariable shownEdgeVariable, shownNodeVariable;
    private String query;
    private double currentTime = 0;

    private double minEdgeValue = 0, maxEdgeValue = 1, minNodeValue = 0, maxNodeValue = 1;
    private int currentSimulationIndex = 0;

    public Simulations(UPPAALModel uppModel, String uppQuery, List<Simulation> points) {
        query = uppQuery;
        model = uppModel.deepClone();
        model.getTopology().updateGraph();
        model.getTopology().unmarkAllEdges();

        for (Simulation s : points) {
            s.initialize(getModelTimeUnit());
        }
        simulations = points;

        showSimulation(0);
    }

    private Simulation getSimulation(int simId) {
        return simulations.get(simId);
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
        return simulations.size();
    }

    public void markGraphAtTime(Number oldTimeValue, Number newTimeValue) {
        if (simulations.size() == 0) return;

        double newTime = newTimeValue.doubleValue();
        double oldTime = oldTimeValue.doubleValue();
        if (newTime > oldTime)
            markGraphForward(newTime, oldTime);
        else if(newTime < oldTime)
            markGraphBackwards(newTime, oldTime);

        currentTime = newTime;
    }

    private boolean validSimPoint(SimulationPoint sp) {
        return shownEdgeVariable != null && shownEdgeVariable.getName().equals(sp.getTrimmedIdentifier())
                || shownNodeVariable != null && shownNodeVariable.getName().equals(sp.getTrimmedIdentifier());
    }

    void markGraphForward(double newTimeValue, double oldTime) {
        SimulationPoint sp;
        //Make sure that more elements at same end time all are included
        while (!((sp = shownSimulation.getSimulationPoints().get(currentSimulationIndex)).getClock() > newTimeValue)) {
            if (sp.getClock() >= oldTime && validSimPoint(sp)) {
                double min = getMinForSimPoint(sp),
                       max = getMaxForSimPoint(sp);
                getTopology().updateVariableGradient(sp, sp.getValue(), min, max);
            }
            if (currentSimulationIndex + 1 >= shownSimulation.getSimulationPoints().size())
                break;
            if (shownSimulation.getSimulationPoints().get(currentSimulationIndex + 1).getClock() <= newTimeValue)
                currentSimulationIndex++;
            else break;
        }
    }

    void markGraphBackwards(double newTimeValue, double oldTime) {
        SimulationPoint sp;
        while (!((sp = shownSimulation.getSimulationPoints().get(currentSimulationIndex)).getClock() < newTimeValue)) {
            if (sp.getClock() <= oldTime && validSimPoint(sp)) {
                double min = getMinForSimPoint(sp),
                       max = getMaxForSimPoint(sp);
                getTopology().updateVariableGradient(sp, sp.getPreviousValue(), min, max);
            }
            if (currentSimulationIndex - 1 < 0)
                break;
            if (shownSimulation.getSimulationPoints().get(currentSimulationIndex - 1).getClock() >= newTimeValue)
                currentSimulationIndex--;
            else break;
        }
    }

    private double getMaxForSimPoint(SimulationPoint sp) {
        if(sp.getType().equals(SimulationPoint.SimulationPointType.EdgePoint))
            return getMaxEdgeValue();
        else
            return getMaxNodeValue();
    }

    private double getMinForSimPoint(SimulationPoint sp) {
        if(sp.getType().equals(SimulationPoint.SimulationPointType.EdgePoint))
            return getMinEdgeValue();
        else
            return getMinNodeValue();
    }

    public void showSimulation(int simulationId) {
        shownSimulation = getSimulation(simulationId);
        resetToCurrentTime();
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

    double getCurrentTime() {
        return currentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simulations that = (Simulations) o;

        if (!model.equals(that.model)) return false;
        if (!simulations.equals(that.simulations)) return false;
        return query.equals(that.query);
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + simulations.hashCode();
        result = 31 * result + query.hashCode();
        return result;
    }

    public void setShownEdgeVariable(OutputVariable shownEdgeVariable) {
        this.shownEdgeVariable = shownEdgeVariable;
        resetToCurrentTime();
    }

    public void setShownNodeVariable(OutputVariable shownNodeVariable) {
        this.shownNodeVariable = shownNodeVariable;
        resetToCurrentTime();
    }

    public void resetToCurrentTime() {
        getTopology().unmarkAllEdges();
        getTopology().unmarkAllNodes();
        currentSimulationIndex = 0;
        markGraphAtTime(0, getCurrentTime());
    }

    public OutputVariable getShownEdgeVariable() {
        return shownEdgeVariable;
    }

    public OutputVariable getShownNodeVariable() {
        return shownNodeVariable;
    }

    public double getMinEdgeValue() {
        return minEdgeValue;
    }

    public void setMinEdgeValue(double minEdgeValue) {
        this.minEdgeValue = minEdgeValue;
    }

    public double getMaxEdgeValue() {
        return maxEdgeValue;
    }

    public void setMaxEdgeValue(double maxEdgeValue) {
        this.maxEdgeValue = maxEdgeValue;
    }

    public double getMinNodeValue() {
        return minNodeValue;
    }

    public void setMinNodeValue(double minNodeValue) {
        this.minNodeValue = minNodeValue;
    }

    public double getMaxNodeValue() {
        return maxNodeValue;
    }

    public void setMaxNodeValue(double maxNodeValue) {
        this.maxNodeValue = maxNodeValue;
    }
}