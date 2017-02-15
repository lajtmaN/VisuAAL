package parsers;

import Model.CVar;
import Model.OutputVariable;
import Model.UPPAALTopology;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lajtman on 07-02-2017.
 */
public class UPPAALParser {

    public static ArrayList<CVar<Integer>> getUPPAALConfigConstants(String uppaalFilename) {
        try {
            XmlHandler handler = new XmlHandler(uppaalFilename);
            return CHandler.getConfigVariables(handler.getGlobalDeclarations());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateUPPAALConfigConstants(String uppaalFilename, CVar<Integer> cvarWithNewVal) {
        try {
            XmlHandler handler = new XmlHandler(uppaalFilename);
            String newDecls = CHandler.updateIntConfigVar(cvarWithNewVal.getName(), cvarWithNewVal.getValue(), handler.getGlobalDeclarations());
            handler.setGlobalDeclarations(newDecls);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static UPPAALTopology getUPPAALTopology(String uppaalFilename){
        try{
            XmlHandler handler = new XmlHandler(uppaalFilename);
            return CHandler.getTopology(handler.getGlobalDeclarations());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static File generateQueryFile(String query) throws IOException {
        File tempFile = new File("uppaalquery.q");
        Writer writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(query);
        writer.close();
        return tempFile;
    }

    public static ArrayList<OutputVariable> getUPPAALOutputVars(String uppaalFilePath, ArrayList<CVar<Integer>> constants) {
        try {
            ArrayList<String> vars = CHandler.getOutputVars(new XmlHandler(uppaalFilePath).getGlobalDeclarations());
            if (vars != null) {
                ArrayList<OutputVariable> outVars = new ArrayList<>();
                for(String s : vars)
                    outVars.add(parseOutputVariableArray(s, constants));
                    return outVars;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static OutputVariable parseOutputVariableArray(String name, List<CVar<Integer>> constants) {
        String ArrayRegex = "(?:\\[(\\w+)\\])\\1*";
        String matchedConstantSize = RegexHelper.getFirstMatchedValueFromRegex(ArrayRegex, name);
        if (matchedConstantSize == null)
            return new OutputVariable(name);


        String modifiedName = name.substring(0, name.indexOf('[')); //only keep actual name - remove array def
        OutputVariable variable = new OutputVariable(modifiedName);
        int dimensionsInArray = (int)name.chars().filter(p -> p == '[').count(); //count [
        switch (dimensionsInArray) {
            case 1:
                variable.setNodeData(true);
                break;
            case 2:
                variable.setEdgeData(true);
                break;
            default:
                throw new IllegalArgumentException("Could not parse ouput variable with " + dimensionsInArray + " dimensions");
        }

        Integer constantValue = constants.stream().filter(p -> p.getName().equals(matchedConstantSize)).findFirst().get().getValue();
        variable.setVariableArraySize(constantValue);


        return variable;
    }
}
