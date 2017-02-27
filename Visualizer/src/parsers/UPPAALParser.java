package parsers;

import Model.CVar;
import Model.OutputVariable;
import Model.TemplateUpdate;
import Model.UPPAALTopology;
import parsers.Declaration.VariableParser;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 07-02-2017.
 */
public class UPPAALParser {

    public static ArrayList<CVar> getUPPAALConfigConstants(String uppaalFilename) {
        try {
            XmlHandler handler = new XmlHandler(uppaalFilename);
            return CHandler.getConfigVariables(handler.getAllDeclarations());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateUPPAALConfigConstants(String uppaalFilename, Collection<CVar> cvarsWithNewVal ) {
        try {
            XmlHandler handler = new XmlHandler(uppaalFilename);
            HashMap<String, String> allDecls = handler.getAllDeclarations();

            List<CVar> globalCVars = cvarsWithNewVal.stream().filter(p -> p.getScope() == null).collect(Collectors.toList());
            if (!globalCVars.isEmpty()) {
                String updatedGlobal = VariableParser.updateAllDeclarations(allDecls.get(null), globalCVars);
                allDecls.replace(null, updatedGlobal);
            }

            Map<String, List<CVar>> scopeAndRelatedCVars = cvarsWithNewVal.stream()
                    .filter(p -> p.getScope() != null).collect(Collectors.groupingBy(p -> p.getScope()));

            for (String scope : scopeAndRelatedCVars.keySet()) {
                if (!scopeAndRelatedCVars.get(scope).isEmpty()) {
                    String updatedDecls = VariableParser.updateAllDeclarations(allDecls.get(scope), scopeAndRelatedCVars.get(scope));
                    allDecls.replace(scope, updatedDecls);
                }
            }
            handler.setDeclarations(allDecls);
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

    public static ArrayList<OutputVariable> getUPPAALOutputVars(String uppaalFilePath, List<CVar> constants) {
        try {
            ArrayList<OutputVariable> outVars = new ArrayList<>();
            HashMap<String, String> allDecls = new XmlHandler(uppaalFilePath).getAllDeclarations();
            for (String key : allDecls.keySet()) {
                ArrayList<String> vars = CHandler.getOutputVars(allDecls.get(key));
                if (vars != null) {
                    for (String s : vars)
                        outVars.add(parseOutputVariableArray(s, key, constants));
                }
            }
            return outVars;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static OutputVariable parseOutputVariableArray(String name, String scope, List<CVar> constants) {
        boolean inScope = scope != null && scope.length() > 0;
        String ArrayRegex = "(?:\\[(\\w+)\\])\\1*";
        String matchedConstantSize = RegexHelper.getFirstMatchedValueFromRegex(ArrayRegex, name);
        boolean isArray = matchedConstantSize != null && matchedConstantSize.length() > 0;
        if (!isArray && !inScope)
            return new OutputVariable(name);

        if (!isArray && inScope) {
            OutputVariable outputVariable = new OutputVariable(name, scope);
            outputVariable.setNodeData(true);
            return outputVariable;
        }

        String modifiedName = name.substring(0, name.indexOf('[')); //only keep actual name - remove array def
        OutputVariable variable = new OutputVariable(modifiedName, scope);
        int dimensionsInArray = (int)name.chars().filter(p -> p == '[').count(); //count [

        if (inScope)
            dimensionsInArray++;

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

        Integer constantValue = constants.stream().filter(p -> p.getName().equals(matchedConstantSize)).findFirst().get().getValueAsInteger();
        variable.setVariableArraySize(constantValue);
        return variable;
    }


    /**
     * Get the CONFIG_MODEL_TIME_UNIT constant from model.
     * CONFIG_MODEL_TIME_UNIT * 1ms = real-time
     * @param path uppaal file
     * @return The constant specified in the model or 1 as default if not present
     */
    public static double getModelTimeUnitConstant(String path) {

        String ModelTimeUnitConstantRegex = "const\\s+double\\s+CONFIG_MODEL_TIME_UNIT\\s+=\\s+(\\d+(?:\\.\\d+)?)\\s*;";
        try {
            XmlHandler handler = new XmlHandler(path);
            String globalDecls = handler.getGlobalDeclarations();
            String res = RegexHelper.getFirstMatchedValueFromRegex(ModelTimeUnitConstantRegex, globalDecls);
            if (res != null && res.length() > 0)
                return Double.parseDouble(res);
        } catch(Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    public static List<String> getUPPAALProcesses(String path, List<CVar> constants) {
        try {
            ArrayList<String> out = new ArrayList<>();

            XmlHandler handler = new XmlHandler(path);
            String systemDecl = handler.getSystemDeclaration();
            for (String proc : RegexHelper.parseProcessesFromSystem(systemDecl)) {
                String paramForProc = handler.getParamaterForTemplate(proc);
                if (paramForProc == null)
                    out.add(proc);
                else {
                    int sizeOfParam = CHandler.getSizeOfParam(paramForProc, handler.getGlobalDeclarations(), constants);
                    for (int i = 0; i <= sizeOfParam; i++) {
                        out.add(String.format("%s(%d)", proc, i));
                    }
                }
            }

            return out;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<TemplateUpdate> getDynamicTemplateUpdates(String modelPath) {
        try {
            XmlHandler handler = new XmlHandler(modelPath);
            if(handler.existVisualizerTemplate())
                return handler.getVisualizerUpdates();
            else
                return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
