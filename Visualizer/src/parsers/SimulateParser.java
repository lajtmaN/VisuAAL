package parsers;

import Model.SimulateOutput;

/**
 * Created by lajtman on 07-02-2017.
 */
public class SimulateParser {
    public static String variableRegex = "^(((\\w)+\\.)?(\\w)+(\\[\\d+\\])*):";

    public static SimulateOutput parse(String[] verifytaOutput) {
        int i;
        for (i = 0; i < verifytaOutput.length; i++) {
            if (verifytaOutput[i].contains("Formula is satisfied")) {
                i++;
                break;
            }
        }
        if (i == verifytaOutput.length)
            return null;

        String variable = parseVariable(verifytaOutput[i++]);


        return null;
    }

    private static String parseVariable(String s) {
        //s must be of form:  name:

        return CHandler.getFirstMatchedValueFromRegex(variableRegex, s);
    }
}
