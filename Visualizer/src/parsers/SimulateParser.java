package parsers;

import Model.DataPoint;
import Model.SimulateOutput;

import javax.xml.crypto.Data;
import java.util.ArrayList;

/**
 * Created by lajtman on 07-02-2017.
 */
public class SimulateParser {
    public static String variableRegex = "^(((\\w)+\\.)?(\\w)+(\\[\\d+\\])*):";

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

        for(;i < verifytaOutput.length; i++) {
            String name;
            DataPoint dataPoint;
            String currentParameter;
            if((name = parseVariable(verifytaOutput[i])) != null) {
                i++;
            }
            else if (){

            }
        }

        return null;
    }

    private static String parseVariable(String s) {
        //s must be of form:  name:

        return CHandler.getFirstMatchedValueFromRegex(variableRegex, s);
    }

    private static ArrayList<DataPoint> parseDataPoints() {
        return null;
    }
}
