package Model;

import Helpers.FileHelper;
import Helpers.GUIHelper;
import Model.VQ.VQParseTree;
import View.simulation.VariableUpdateObserver;
import View.simulation.VariablesUpdateObservable;
import javafx.beans.*;
import javafx.scene.control.Alert;
import org.graphstream.graph.Graph;
import parsers.RegexHelper;

import java.io.*;
import java.util.*;

/**
 * Created by lajtman on 13-02-2017.
 */
public class Simulations implements Serializable, VariablesUpdateObservable {
    private UPPAALModel model;
    private final List<Simulation> simulations;
    private GraphValueMapper graphValueMapper = new GraphValueMapper();
    private VQParseTree parseTreeNode, parseTreeEdge;

    private Simulation shownSimulation;
    private ArrayList<VariableUpdateObserver> observers = new ArrayList<>();

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

    private boolean validNodeSimPoint(SimulationPoint sp) {
        if(parseTreeNode == null)
            return false;
        boolean isNode = sp.getType().equals(SimulationPoint.SimulationPointType.NodePoint),
                containsIdentifier = parseTreeNode.getUsedVariables().contains(sp.getScopedIdentifier());
        return isNode && containsIdentifier;
    }

    private boolean validEdgeSimPoint(SimulationPoint sp) {
        if(parseTreeEdge == null)
            return false;
        boolean isEdge = sp.getType().equals(SimulationPoint.SimulationPointType.EdgePoint),
                containsIdentifier = parseTreeEdge.getUsedVariables().contains(sp.getScopedIdentifier());
        return isEdge && containsIdentifier;
    }

    void markGraphForward(double newTimeValue, double oldTime) {
        SimulationPoint sp;
        //Make sure that more elements at same end time all are included
        while (!((sp = shownSimulation.getSimulationPoints().get(currentSimulationIndex)).getClock() > newTimeValue)) {
            if (sp.getClock() >= oldTime) {
                handleUpdateForSimulationPoint(sp, sp.getValue());
                updateAllObservers(sp, sp.getValue());
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
            if (sp.getClock() <= oldTime) {
                handleUpdateForSimulationPoint(sp, sp.getPreviousValue());
                updateAllObservers(sp, sp.getPreviousValue());
            }
            if (currentSimulationIndex - 1 < 0)
                break;
            if (shownSimulation.getSimulationPoints().get(currentSimulationIndex - 1).getClock() >= newTimeValue)
                currentSimulationIndex--;
            else break;
        }
    }

    /**
     * Update for either forward or backward
     * @param sp
     * @param simulationPointValue own value or previous value (forward / backwards)
     */
    private void handleUpdateForSimulationPoint(SimulationPoint sp, double simulationPointValue) {
        try {
            if (validEdgeSimPoint(sp)) {
                SimulationEdgePoint sep = (SimulationEdgePoint) sp;

                double gradient = handleUpdateForSimulationPoint(sp, sep.getEdgeIdentifier(),
                        simulationPointValue, parseTreeEdge);
                getTopology().updateEdgeGradient(sep.getEdgeIdentifier(), gradient);
            }
            else if (validNodeSimPoint(sp)) {
                SimulationNodePoint snp = (SimulationNodePoint) sp;
                double gradient =handleUpdateForSimulationPoint(sp, String.valueOf(snp.getNodeId()),
                        simulationPointValue, parseTreeNode);
                getTopology().updateNodeGradient(snp.getNodeId(), gradient);
            }
        }
         catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private double handleUpdateForSimulationPoint(SimulationPoint sp, String simulationPointidentifier,
                                                  double simulationPointValue, VQParseTree vqParseTree) throws Exception {

        graphValueMapper.updateNodeVariable(simulationPointidentifier, sp.getScopedIdentifier(), simulationPointValue);
        return vqParseTree.getGradient(graphValueMapper.getNodeOrEdgeVariableMap(simulationPointidentifier));
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


    public void setShownEdgeVariable(VQParseTree parsedVQ) {
        parseTreeEdge = parsedVQ;
        resetToCurrentTime();
    }

    public void setShownNodeVariable(VQParseTree parsedVQ) {
        parseTreeNode = parsedVQ;
        resetToCurrentTime();
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

    @Override
    public void updateAllObservers(SimulationPoint sp, double value) {
        for(VariableUpdateObserver o : observers) {
            o.update(sp, value);
        }
    }

    @Override
    public void addListener(VariableUpdateObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeListener(VariableUpdateObserver observer) {
        observers.remove(observer);
    }

}