package Model;

import parsers.RegexHelper;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * Created by lajtman on 07-02-2017.
 */

public class SimulateOutput extends UPPAALOutput {

    /**
     * Key: observed variable
     * Value: List of simulations
     * Each list contains list of datapoints
     */
    private Map<String, ArrayList<ArrayList<DataPoint>>> simulationData;
    private int nrSimulations;
    private final String sourceDestinationRegex = "\\w*\\[(\\d+)\\]\\[(\\d+)\\]";
    private final String nodeIdRegex = "\\w*\\[(\\d+)\\]";


    public SimulateOutput(int numberOfSimulations) {
        simulationData = new HashMap<>();
        nrSimulations = numberOfSimulations;
    }

    private void addVariable(String variable) {
        simulationData.put(variable, new ArrayList<>());
        for (int i = 0; i < nrSimulations; i++) {
            simulationData.get(variable).add(i, new ArrayList<DataPoint>());
        }
    }

    public void addDatapoint(String variable, int simNumber, DataPoint data) {
        if (!simulationData.containsKey(variable))
            addVariable(variable);

        simulationData.get(variable).get(simNumber).add(data);
    }

    public int getNumVariables() {
        return simulationData.size();
    }

    public ArrayList<DataPoint> getSimulationForVariable(String var, int simId) {
        return simulationData.get(var).get(simId);
    }

    public ArrayList<ArrayList<DataPoint>> getSimulationForVariable (String var){
        return simulationData.get(var);
    }

    public List<SimulationPoint> zip(List<OutputVariable> outputVars, int simId) {
        ArrayList<SimulationPoint> result = new ArrayList<>();

        for (String variable : simulationData.keySet()) {
            //TODO consider calculating where to insert values in array to prevent sorting everything afterwards
            OutputVariable outputVar = getMatchingVariable(outputVars, variable);
            if (outputVar.getIsEdgeData()) {
                result.addAll(getZippedEdgePoints(variable, simId));
            }
            else if (outputVar.getIsNodeData()) {
                result.addAll(getZippedNodePoints(variable, simId));
            }
            else {
                result.addAll(getZippedVariablePoints(variable, simId));
            }
        }

        result.sort((o1, o2) -> o1.getClock() < o2.getClock() ? -1 : (o1.getClock() > o2.getClock() ? 1 : 0));
        return result;
    }

    private List<SimulationPoint> getZippedVariablePoints(String key, int simId) {
        ArrayList<SimulationPoint> result = new ArrayList<>();
        for(DataPoint dp : simulationData.get(key).get(simId)){
            result.add(new SimulationPoint(key, dp.getClock(), dp.getValue(), dp.getPreviousValue()));
        }
        return  result;
    }

    private OutputVariable getMatchingVariable(List<OutputVariable> outputVars, String variable) {
        int indexOfArraySign = variable.indexOf("[");
        String nameWithoutArray = indexOfArraySign > 0 ? variable.substring(0, indexOfArraySign) : variable;

        Optional<OutputVariable> var = outputVars.stream().filter(p -> p.getName().equals(nameWithoutArray)).findFirst();
        if (var.isPresent())
            return var.get();
        else
            throw new IllegalArgumentException(nameWithoutArray + " was not present in list of outputVars");
    }

    public List<SimulationEdgePoint> getZippedEdgePoints(String key, int simId) {
        ArrayList<SimulationEdgePoint> result = new ArrayList<>();
        for(DataPoint dp : simulationData.get(key).get(simId)){
            int source = Integer.valueOf(RegexHelper.getNthMatchedValueFromRegex(sourceDestinationRegex, key, 1));
            int destination = Integer.valueOf(RegexHelper.getNthMatchedValueFromRegex(sourceDestinationRegex, key, 2));
            result.add(new SimulationEdgePoint(dp.getClock(), String.valueOf(source),
                    String.valueOf(destination), dp.getValue(), dp.getPreviousValue()));
        }
        return  result;
    }

    public ArrayList<SimulationEdgePoint> getZippedEdgePoints(int simId) {
        ArrayList<SimulationEdgePoint> result = new ArrayList<>();
        for(String key : simulationData.keySet()){
            result.addAll(getZippedEdgePoints(key, simId));
        }
        result.sort((o1, o2) -> o1.getClock() < o2.getClock() ? -1 : (o1.getClock() > o2.getClock() ? 1 : 0));
        return result;
    }


    public List<SimulationNodePoint> getZippedNodePoints(String key, int simId) {
        ArrayList<SimulationNodePoint> result = new ArrayList<>();
        for (DataPoint dp : simulationData.get(key).get(simId)){
            int nodeId = Integer.valueOf(RegexHelper.getFirstMatchedValueFromRegex(nodeIdRegex, key));
            result.add(new SimulationNodePoint(dp.getClock(), nodeId, dp.getValue(), dp.getPreviousValue()));
        }
        return result;
    }

    public ArrayList<SimulationNodePoint> getZippedNodePoints(int simId) {
        ArrayList<SimulationNodePoint> result = new ArrayList<>();
        for(String key : simulationData.keySet()){
            result.addAll(getZippedNodePoints(key, simId));
        }
        result.sort((o1, o2) -> o1.getClock() < o2.getClock() ? -1 : (o1.getClock() > o2.getClock() ? 1 : 0));
        return result;
    }

    @Override
    public String toString() {
        int simulationIndex = 0;
        String result = "";
        for (ArrayList<ArrayList<DataPoint>> simulationsPerVariable : simulationData.values()) {
            for (ArrayList<DataPoint> simulation : simulationsPerVariable) {
                result += "Sim " + simulationIndex++ + ":\n";
                for (DataPoint dataPoint : simulation) {
                    result += dataPoint.toString() + "\n";
                }
            }
        }
        return result;
    }

    public void replaceValueOfLastDataPoint(String variable, int simNumber, DataPoint data) {
        if (!simulationData.containsKey(variable))
            addVariable(variable);

        ArrayList<DataPoint> points = simulationData.get(variable).get(simNumber);
        points.get(points.size()-1).setValue(data.getValue()); //Replace datapoint with same clock
    }

    public void addPreviousDataValues() {
        for(String key : simulationData.keySet()) {
            ArrayList<ArrayList<DataPoint>> simulationArrays = simulationData.get(key);
            for(ArrayList<DataPoint> varData : simulationArrays) {
                DataPoint previous = null;
                for(DataPoint d : varData) {
                    if(previous != null) {
                        d.setPreviousValue(previous.getValue());
                    }
                    else
                        d.setPreviousValue(0);
                    previous = d;
                }
            }
        }
    }

}
