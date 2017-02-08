package parsers;

import Model.DataPoint;
import Model.SimulateOutput;

import java.util.ArrayList;

/**
 * Created by lajtman on 07-02-2017.
 */
public class SimulateParser {
    public static String variableRegex = "^(((\\w)+\\.)?(\\w)+(\\[\\d+\\])*):";
    private static String simIdRegex = "\\[(\\d+)\\]:";

    public static SimulateOutput parse(String[] verifytaOutput, int nrSimulations) {
        int i;
        for (i = 0; i < verifytaOutput.length; i++) {
            if (verifytaOutput[i].contains("Formula is satisfied")) {
                i++;
                break;
            }
        }
        if (i == verifytaOutput.length)
            return null;

        SimulateOutput simulateOutput = new SimulateOutput(nrSimulations);

        String name = null;
        for(;i < verifytaOutput.length; i++) {
            String outName = parseVariable(verifytaOutput[i]);
            int outSimId = parseSimulateDataStart(verifytaOutput[i]);

            if(outName != null) {
                name = outName;
            }
            else if (outSimId >= 0 && name != null){
                ArrayList<DataPoint> datas = RegexHelper.getDataPointsForString(verifytaOutput[i]);
                for(DataPoint d : datas) {
                    simulateOutput.addDatapoint(name, outSimId, d);
                }
            }
        }

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

    private static ArrayList<DataPoint> parseDataPoints() {
        return null;
    }
}
