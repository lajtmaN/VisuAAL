package Model;

import java.util.*;

/**
 * Created by lajtman on 07-02-2017.
 */

public class SimulateOutput extends UPPAALOutput {

    /**
     * Key: observed variable
     * Value: List of simulations
     *        Each list contains list of datapoints
     */
    private Map<String, ArrayList<ArrayList<DataPoint>>> simulationData;
    private int nrSimulations;

    public SimulateOutput(int numberOfSimulations) {
        simulationData = new HashMap<>();
        nrSimulations = numberOfSimulations;
    }

    private void addVariable(String variable) {
        simulationData.put(variable, new ArrayList<>());
        for(int i = 0; i < nrSimulations; i++) {
            simulationData.get(variable).add(i, new ArrayList<DataPoint>());
        }
    }

    public void addDatapoint(String variable, int simNumber, DataPoint data) {
        if (!simulationData.containsKey(variable))
            addVariable(variable);

        simulationData.get(variable).get(simNumber).add(data);
    }

    public int getNumVariables(){
        return simulationData.size();
    }

    public ArrayList<DataPoint> getSimulationForVariable(String var, int simId) {
        return simulationData.get(var).get(simId);
    }

    public ArrayList<ArrayList<DataPoint>> getSimulationForVariable(String var) {
        return simulationData.get(var);
    }
}
