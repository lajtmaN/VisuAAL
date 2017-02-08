package parsers;

import Model.DataPoint;
import Model.SimulateOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lajtman on 07-02-2017.
 */
public class SimulateParser {
    public static String variableRegex = "^(((\\w)+\\.)?(\\w)+(\\[\\d+\\])*):";
    private static String simIdRegex = "\\[(\\d+)\\]:";

    public static SimulateOutput parse(List<String> verifytaOutput, int nrSimulations) {
        int i;
        for (i = 0; i < verifytaOutput.size(); i++) {
            if (verifytaOutput.get(i).contains("Formula is satisfied")) {
                i++;
                break;
            }
        }
        if (i == verifytaOutput.size())
            return null;

        SimulateOutput simulateOutput = new SimulateOutput(nrSimulations);

        String name = null;
        for(;i < verifytaOutput.size(); i++) {
            String outName = parseVariable(verifytaOutput.get(i));
            int outSimId = parseSimulateDataStart(verifytaOutput.get(i));

            if(outName != null) {
                name = outName;
            }
            else if (outSimId >= 0 && name != null){
                ArrayList<DataPoint> datas = RegexHelper.getDataPointsForString(verifytaOutput.get(i));
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
