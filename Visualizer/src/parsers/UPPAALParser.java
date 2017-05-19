package parsers;

import Model.*;
import javafx.util.Pair;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.Declaration.ANTLRGenerated.uppaalLexer;
import parsers.Declaration.ANTLRGenerated.uppaalParser;
import parsers.Declaration.SystemDeclParser;
import parsers.Declaration.VariableParser;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 07-02-2017.
 */
public class UPPAALParser {

    public static ArrayList<CVar> getUPPAALConfigConstants(String uppaalFilename) throws Exception {
        XmlHandler handler = new XmlHandler(uppaalFilename);
        ArrayList<CVar> allConfigVars = CHandler.getConfigVariables(handler.getAllDeclarations());
        checkIfConfigNrNodesIsIncluded(allConfigVars);
        return allConfigVars;
    }

    private static void checkIfConfigNrNodesIsIncluded(ArrayList<CVar> allConfigVars) throws Exception {
        allConfigVars.stream()
                .filter(c -> c.getName().equals("CONFIG_NR_NODES"))
                .findFirst()
                .orElseThrow(() -> new Exception("Could not find a variable called CONFIG_NR_NODES"));
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


    public static UPPAALTopology getUPPAALTopology(String uppaalFilename) throws Exception {
        XmlHandler handler = new XmlHandler(uppaalFilename);
        return CHandler.getTopology(handler.getGlobalDeclarations());
    }

    public static File generateQueryFile(String query) throws IOException {
        File tempFile = new File("uppaalquery.q");
        Writer writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(query);
        writer.close();
        return tempFile;
    }

    public static ArrayList<OutputVariable> getUPPAALOutputVars(String uppaalFilePath) {
        try {
            HashMap<String, String> allDecls = new XmlHandler(uppaalFilePath).getAllDeclarations();
            return CHandler.getOutputVars(allDecls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
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

    private static CommonTokenStream getTokenStream(String decls) {
        ANTLRInputStream in = new ANTLRInputStream(decls);
        uppaalLexer lexer = new uppaalLexer(in);
        return new CommonTokenStream(lexer);
    }

    private static uppaalParser getParser(String declarations) {
        return new uppaalParser(getTokenStream(declarations));
    }

    private static uppaalParser.SystemBlockContext getRootElement(String declarations) {
        return getParser(declarations).systemBlock();
    }

    public static List<UPPAALProcess> getUPPAALProcesses(String path, List<CVar> constants) {
        try {
            ArrayList<UPPAALProcess> out = new ArrayList<>();

            XmlHandler handler = new XmlHandler(path);
            String systemDecl = handler.getSystemDeclaration();

            SystemDeclParser listener = new SystemDeclParser();

            new ParseTreeWalker().walk(listener, getRootElement(systemDecl));
            ArrayList<UPPAALProcess> procs = listener.getProcesses();
            for(UPPAALProcess proc : procs){
                String parameterInTemplate = handler.getParamaterForTemplate(proc.getTemplateName());
                if(!proc.isInstantiatedProcess() && parameterInTemplate !=null) {
                    Pair<Integer, Integer> sizesOfParam = CHandler.getSizesOfParam(parameterInTemplate,
                            handler.getGlobalDeclarations(), constants);
                    for(int i = sizesOfParam.getKey(); i <= sizesOfParam.getValue(); i++) { //Add parametrised version of process. Still not instantiated
                        out.add(new UPPAALProcess(proc.getTemplateName(), proc.getProcessName(), String.valueOf(i)));
                    }
                }
                else {
                    out.add(proc);
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

    public static List<CVar> getUPPAALDynamicUpdateCandidates(String modelPath) throws Exception {
        return getUPPAALConfigConstants(modelPath).stream().filter(p -> !p.getIsConst() && p.getScope() == null && !p.isInFuncBody()).collect(Collectors.toList());
    }
}
