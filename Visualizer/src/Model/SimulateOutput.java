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
    private final String srcDstRegex = "\\w*\\[(\\d+)\\]\\[(\\d+)\\]";


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

    public ArrayList<SimulationEdgePoint> getZippedForSimulate(int simId) {
        ArrayList<SimulationEdgePoint> result = new ArrayList<>();
        for(String key : simulationData.keySet()){
            ArrayList<ArrayList<DataPoint>> simulations = simulationData.get(key);
            if(!simulations.isEmpty()){
                for(DataPoint dp : simulations.get(simId)){
                    //TODO: if single-array parse as simulation edgePoint
                    int src = Integer.valueOf(RegexHelper.getNthMatchedValueFromRegex(srcDstRegex, key, 1));
                    int dst = Integer.valueOf(RegexHelper.getNthMatchedValueFromRegex(srcDstRegex, key, 2));
                    result.add(new SimulationEdgePoint(dp.getClock(), src, dst, dp.getValue()));
                }
            }
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
}
