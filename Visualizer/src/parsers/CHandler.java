package parsers;

import Model.CVar;
import Model.OutputVariable;
import Model.UPPAALEdge;
import Model.UPPAALTopology;
import javafx.util.Pair;
import parsers.Declaration.VariableParser;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CHandler {
    private static final String ConfigVariablePrefix = "CONFIG_";
    private static final String OutputVariablePrefix = "OUTPUT_";
    private static final String TopologyPartFormRegex = "((?:\\d,)*\\d)";
    private static final String TypedefRegex(String typedefName) {
        return "typedef\\s+int\\s*\\[\\s*(CONFIG_\\w+|\\d+)([*+-]\\d+)?,\\s*(CONFIG_\\w+|\\d+)([*+-]\\d+)?\\]\\s+" + typedefName+ "\\s*;";
    }

    private static void filterConfigVariables(List<CVar> vars) {
        vars.removeIf(var -> !var.getName().startsWith(ConfigVariablePrefix) || var.isArrayType());
    }

    private static void filterOutputVariables(List<CVar> vars) {
        vars.removeIf(var -> !var.getName().startsWith(OutputVariablePrefix));
        vars.removeIf(var -> !var.hasBuiltInType());
        vars.removeIf(var -> var.isInFuncBody());
    }

    private static void setScopeOnAll(List<CVar> vars, String scope) {
        vars.forEach(c -> c.setScope(scope));
    }

    public static ArrayList<CVar> getConfigVariables(String decls, String scope) {
        ArrayList<CVar> returnvars = VariableParser.getInstantiations(decls);
        filterConfigVariables(returnvars);
        setScopeOnAll(returnvars, scope);
        return returnvars;
    }

    public static ArrayList<CVar> getConfigVariables(HashMap<String, String> allDecls) {
        ArrayList<CVar> constantNames = new ArrayList<>();
        for (String scopeKey : allDecls.keySet()) {
            constantNames.addAll(getConfigVariables(allDecls.get(scopeKey), scopeKey));
        }
        return constantNames;
    }

    public static ArrayList<OutputVariable> getOutputVars(HashMap<String, String> declarations) {
        ArrayList<OutputVariable> outputVariables = new ArrayList<>();
        ArrayList<CVar> globalDecls = getConfigVariables(declarations.get(null), null);

        for (String scopeKey : declarations.keySet()) {
            outputVariables.addAll(getOutputVars(declarations.get(scopeKey), scopeKey, globalDecls));
        }
        return outputVariables;
    }

    public static List<OutputVariable> getOutputVars(String decls, String scope, List<CVar> globalConstants) {
        ArrayList<CVar> returnvars = VariableParser.getInstantiations(decls);
        setScopeOnAll(returnvars, scope);

        List<CVar> constants = new ArrayList<>(globalConstants);
        if (scope != null) { //If global scope, we have already parsed the constants
            ArrayList<CVar> scopedConstants = new ArrayList<>(returnvars);
            filterConfigVariables(scopedConstants);
            constants.addAll(scopedConstants);
        }

        filterOutputVariables(returnvars);

        return returnvars.stream().map(p -> parseOutputVariableArray(p, constants)).collect(Collectors.toList());
    }

    public static OutputVariable parseOutputVariableArray(CVar parsedUppaalVariable, List<CVar> constants) {
        boolean inTemplateScope = parsedUppaalVariable.getScope() != null && parsedUppaalVariable.getScope().length() > 0;

        if (!parsedUppaalVariable.isArrayType()) {
            if (!inTemplateScope)
                return new OutputVariable(parsedUppaalVariable.getName());
            else {
                OutputVariable outputVariable = new OutputVariable(parsedUppaalVariable.getName(), parsedUppaalVariable.getScope());
                outputVariable.setNodeData(true);
                return outputVariable;
            }
        }

        OutputVariable variable = new OutputVariable(parsedUppaalVariable.getName(), parsedUppaalVariable.getScope());
        int dimensionsInArray = parsedUppaalVariable.getArraySizes().size();

        if (inTemplateScope)
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

        String constantWithArraySize = parsedUppaalVariable.getArraySizes().get(0); //TODO always assumes quadratic arrays

        int plusSomeExtra = 0; //If parsing OUTPUT_idle[CONFIG_NR_NODES+1] - then we want this variable to hold the 1
        if (constantWithArraySize.contains("+")) {
            String[] splitted = constantWithArraySize.split("\\+");
            constantWithArraySize = splitted[0];
            if (splitted[1].matches("\\d"))
                plusSomeExtra = Integer.parseInt(splitted[1]);
        }

        final String configName = constantWithArraySize;
        Optional<CVar> matchedConstant = constants.stream().filter(c -> c.getName().equals(configName)).findFirst();
        if (!matchedConstant.isPresent())
            throw new IllegalArgumentException("An output variable array (" + parsedUppaalVariable.getName() + ") " +
                    "was defined with a Config parameter (" + configName + ") that was not found");

        variable.setVariableArraySize(matchedConstant.get().getValueAsInteger() + plusSomeExtra);
        return variable;
    }

    public static UPPAALTopology getTopology(String decls) throws Exception {
        ArrayList<CVar> vars = VariableParser.getInstantiations(decls);
        Optional<CVar> topologyVar = vars.stream().filter(p -> p.getName().equals("CONFIG_connected")).findFirst();
        if(!topologyVar.isPresent()){
            throw new Exception("Could not find any topology in the model. The topology should be named CONFIG_connected[CONFIG_nr_nodes][CONFIG_nr_nodes]");
        }
        String definitionString = topologyVar.get().getValue();
        if(definitionString != null) {
            return getTopologyFromInstantiation(definitionString);
        }
        return null;
    }

    public static UPPAALTopology getTopologyFromInstantiation(String definitionString) {
        UPPAALTopology result = new UPPAALTopology();
        int source_index = 0;

        definitionString = definitionString.replace(" ", "").replace("\n", "").replace("\t", "");
        String[] topologyParts = definitionString.split("}");
        for(int i = 0; i < topologyParts.length; i++) {
            topologyParts[i] = topologyParts[i].replace(",{", "").replace("}", "").replace("{", "");
            if (RegexHelper.getFirstMatchedValueFromRegex(TopologyPartFormRegex, topologyParts[i]) == null) // All parts must be correctly formed.
                return result;
        }
        for (String s : topologyParts) {
            int destination_index = 0;
            for (String element : s.split(",")) {
                if (element.equals("1")) { // TODO: Only binary relations can be defined
                    result.add(new UPPAALEdge(String.valueOf(source_index), String.valueOf(destination_index)));
                }
                destination_index++;
            }
            source_index++;
        }
        result.setNumberOfNodes(source_index);
        return result;
    }

    public static Pair<Integer, Integer> getSizesOfParam(String paramForProc, String globalDecls, List<CVar> constants) {
        String regex = TypedefRegex(paramForProc);
        String[] constantNames = new String[2];
        constantNames[0] = RegexHelper.getNthMatchedValueFromRegex(regex, globalDecls, 1); //Lower bound name
        constantNames[1] = RegexHelper.getNthMatchedValueFromRegex(regex, globalDecls, 3); // Upper bound name

        String[] optionalExpressions = new String[2];
        optionalExpressions[0] = RegexHelper.getNthMatchedValueFromRegex(regex, globalDecls, 2); //Lower bound optionalExpression
        optionalExpressions[1] = RegexHelper.getNthMatchedValueFromRegex(regex, globalDecls, 4); //Upper bound optionalExpression
        int[] resultArray = new int[2];

        for(int upperOrLower = 0; upperOrLower < 2; upperOrLower++) {
            String name = constantNames[upperOrLower];
            String expression = optionalExpressions[upperOrLower];
            Optional<CVar> matchedConstant = constants.stream().filter(p -> p.getName().equals(name)).findFirst();
            Integer constantValue = null;
            if (matchedConstant.isPresent()) {
                constantValue = Integer.parseInt(matchedConstant.get().getValue());
            } else {
                try {
                    constantValue = Integer.parseInt(name);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            if (constantValue != null) {
                if (expression != null) {
                    String operator = RegexHelper.getFirstMatchedValueFromRegex("([*+-])", expression);
                    int num = Integer.parseInt(RegexHelper.getFirstMatchedValueFromRegex("(\\d+)", expression));
                    switch (operator) {
                        case "*":
                            resultArray[upperOrLower] = constantValue * num;
                            break;
                        case "+":
                            resultArray[upperOrLower] = constantValue + num;
                            break;
                        case "-":
                            resultArray[upperOrLower] = constantValue - num;
                    }
                } else {
                    resultArray[upperOrLower] = constantValue;
                }
            }
        }
        return new Pair<>(resultArray[0],resultArray[1]);
    }

    public static String StringUPPAALTopology(UPPAALTopology top) {
        String CTopology = "";
        if(top != null) {
            CTopology = "{\n";
            top.sort(UPPAALEdge::compareTo);

            int topIndex = 0;
            UPPAALEdge edge = top.get(0);
            for (int i = 0; i < top.getNumberOfNodes(); i++) {
                CTopology += "{";
                for (int j = 0; j < top.getNumberOfNodes(); j++) {
                    if (edge.getSourceAsInt() == i && edge.getDestinationAsInt() == j) {
                        CTopology += "1";
                        if (topIndex < top.size() - 1) {
                            edge = top.get(++topIndex);
                        }
                    } else
                        CTopology += "0";

                    if (j < top.getNumberOfNodes() - 1)
                        CTopology += ",";
                }
                CTopology += "}";
                if (i < top.getNumberOfNodes() - 1)
                    CTopology += ",\n";
                else
                    CTopology += "\n}";
            }
        }
        return CTopology;
    }
}