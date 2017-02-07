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
    private Map<String, ArrayList<ArrayList<DataPoint>>> evaluations;
    private int nrSimulations;

    public SimulateOutput(int numberOfSimulations) {
        evaluations = new HashMap<>();
        nrSimulations = numberOfSimulations;
    }

    private void addVariable(String variable) {
        evaluations.put(variable, new ArrayList<>());
        for(int i = 0; i < nrSimulations; i++) {
            evaluations.get(variable).set(i, new ArrayList<DataPoint>());
        }
    }

    public void addDatapoint(String variable, int simNumber, DataPoint data) {
        if (!evaluations.containsKey(variable))
            addVariable(variable);

        evaluations.get(variable).get(simNumber).add(data);
    }

    public int getNumVariables(){
        return evaluations.size();
    }
}
