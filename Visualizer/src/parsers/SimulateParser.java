package parsers;

import Helpers.FileHelper;
import Model.DataPoint;
import Model.SimulateOutput;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lajtman on 07-02-2017.
 */
public class SimulateParser {
    public static String variableRegex = "^((\\w+(?:\\[\\d+\\])?\\.)?\\w+(\\[\\d+\\])*).*:";
    private static String simIdRegex = "\\[(\\d+)\\]:";

    public static SimulateOutput parse(List<String> verifytaOutput, int nrSimulations) {
        int i;
        String temp = "";
        for(String s : verifytaOutput) temp += s;

        for (i = 0; i < verifytaOutput.size(); i++) {
            if (verifytaOutput.get(i).contains("Formula is satisfied")) {
                i++;
                break;
            }
        }
        if (i == verifytaOutput.size())
            return parseUPPAALError(verifytaOutput);

        SimulateOutput simulateOutput = new SimulateOutput(nrSimulations);

        String name = null;
        for (; i < verifytaOutput.size(); i++) {
            String outName = parseVariable(verifytaOutput.get(i));
            int outSimId = parseSimulateDataStart(verifytaOutput.get(i));

            if (outName != null) {
                name = outName;
            }
            else if (outSimId >= 0 && name != null) {
                ArrayList<DataPoint> datas = RegexHelper.getDataPointsForString(verifytaOutput.get(i));
                datas.removeIf(d -> d.getClock() == 0 && d.getValue() == 0);

                DataPoint justAddedPoint = null;
                for (int j = 0; j < datas.size(); j++){
                    DataPoint startPointOfTimeStep = datas.get(j);
                    while(j+1 < datas.size() && datas.get(j+1).getClock() == startPointOfTimeStep.getClock()){
                        j++;
                    }
                    DataPoint endPointOfTimeStep = datas.get(j);
                    if (justAddedPoint == null || justAddedPoint.getValue() != endPointOfTimeStep.getValue()) {
                        simulateOutput.addDatapoint(name, outSimId, endPointOfTimeStep);
                        justAddedPoint = endPointOfTimeStep;
                    }
                }
            }
        }

        simulateOutput.addPreviousDataValues();
        return simulateOutput;
    }

    private static int parseSimulateDataStart(String s) {
        String res = RegexHelper.getFirstMatchedValueFromRegex(simIdRegex, s);
        if (res != null)
            return Integer.parseInt(res);
        return -1;
    }

    private static String parseVariable(String s) {
        //s must be of form:  name:

        return RegexHelper.getFirstMatchedValueFromRegex(variableRegex, s);
    }

    private static SimulateOutput parseUPPAALError(List<String> verifytaOutput) {
        /*
        Options for the verification:
          Generating no trace
          Search order is breadth first
          Using conservative space optimisation
          Seed is 1486472853
          State space representation uses minimal constraint systems
        uppaalquery.q:1: [error] Unknown identifier: as.
        uppaalquery.q:1: [error] syntax error: unexpected end, expecting ',' or '}'.

         */
        int i;
        for (i = 0; i < verifytaOutput.size(); i++) {
            if (verifytaOutput.get(i).contains("[error]")) {
                break;
            }
        }
        if (i == verifytaOutput.size())
            throw new IllegalArgumentException("Expected an UPPAAL error, but could not parse any");

        String uppaalError = "";

        for (; i < verifytaOutput.size(); i++) {
            uppaalError += RegexHelper.getFirstMatchedValueFromRegex("\\[error\\]\\s?(.*)", verifytaOutput.get(i));
            if (i < verifytaOutput.size() - 1)
                uppaalError += "\n";
        }

        SimulateOutput output = new SimulateOutput(0);
        output.setErrorDescription(uppaalError);
        return output;
    }
}
