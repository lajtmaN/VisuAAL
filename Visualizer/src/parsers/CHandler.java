package parsers;

import Model.CVar;
import Model.OutputVariable;
import Model.UPPAALEdge;
import Model.UPPAALTopology;
import parsers.Declaration.VariableParser;

import java.util.*;
import java.util.stream.Collectors;

public class CHandler {
    private static final String ConfigVariablePrefix = "CONFIG_";
    private static final String OutputVariablePrefix = "OUTPUT_";
    private static final String TopologyRegex = "CONFIG_connected\\[.+\\n((?:[^;])+)\\};";
    private static final String TopologyFormRegex = "((?:\\{(?:\\d,)*\\d\\},)*(?:\\{(?:\\d,)*\\d\\})+)";
    private static final String TypedefRegex(String typedefName) {
        return "typedef\\s+int\\s+\\[\\s*0,\\s*(CONFIG_\\w+)([*+-]\\d+)?\\]\\s+" + typedefName;
    }

    public static ArrayList<CVar> getConfigVariables(String decls, String scope) {
        ArrayList<CVar> returnvars = VariableParser.getInstantiations(decls);
        returnvars.removeIf(var -> !var.getName().startsWith(ConfigVariablePrefix) || var.isArrayType());
        returnvars.forEach(var -> var.setScope(scope));
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
        for (String scopeKey : declarations.keySet()) {
            outputVariables.addAll(getOutputVars(declarations.get(scopeKey), scopeKey));
        }
        return outputVariables;
    }

    public static List<OutputVariable> getOutputVars(String decls, String scope) {
        ArrayList<CVar> returnvars = VariableParser.getInstantiations(decls);
        returnvars.forEach(var -> var.setScope(scope));

        ArrayList<CVar> constants = new ArrayList<>(returnvars);
        constants.removeIf(var -> !var.getName().startsWith(ConfigVariablePrefix) || var.isArrayType());

        returnvars.removeIf(var -> !var.getName().startsWith(OutputVariablePrefix));
        returnvars.removeIf(var -> !var.hasIntType()); // TODO OUTPUT variables are limited to int only right now

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
        Optional<CVar> matchedConstant = constants.stream().filter(c -> c.getName().equals(constantWithArraySize)).findFirst();
        if (!matchedConstant.isPresent())
            throw new IllegalArgumentException("An output variable array was defined with a Config parameter that was not found");

        variable.setVariableArraySize(matchedConstant.get().getValueAsInteger());
        return variable;
    }

    public static UPPAALTopology getTopology(String decls){
        UPPAALTopology result = new UPPAALTopology();
        String definitionString = RegexHelper.getFirstMatchedValueFromRegex(TopologyRegex, decls);
        if(definitionString != null) {
            definitionString = definitionString.replace(" ", "").replace("\n", "").replace("\t", "");
            if (RegexHelper.getFirstMatchedValueFromRegex(TopologyFormRegex, definitionString) != null) {
                int source_index = 0;
                for (String s : definitionString.split("}")) {
                    String temp = s.replace(",{", "").replace("}", "").replace("{", "");
                    int destination_index = 0;
                    for (String element : temp.split(",")) {
                        if (element.equals("1")) { // TODO: Only binary relations can be defined
                            result.add(new UPPAALEdge(String.valueOf(source_index), String.valueOf(destination_index)));
                        }
                        destination_index++;
                    }
                    if (result.getNumberOfNodes() == 0) {
                        result.setNumberOfNodes(destination_index);
                    }
                    source_index++;
                }
            }
        }
        return result;
    }

    public static int getSizeOfParam(String paramForProc, String globalDecls, List<CVar> constants) {
        String regex = TypedefRegex(paramForProc);
        String constantName = RegexHelper.getNthMatchedValueFromRegex(regex, globalDecls, 1);
        String optionalExpression = RegexHelper.getNthMatchedValueFromRegex(regex, globalDecls, 2);

        Optional<CVar> matchedConstant = constants.stream().filter(p -> p.getName().equals(constantName)).findFirst();
        if (matchedConstant.isPresent()) {
            int constValue = Integer.parseInt(matchedConstant.get().getValue());

            if (optionalExpression != null) {
                String operator = RegexHelper.getFirstMatchedValueFromRegex("([*+-])", optionalExpression);
                int num = Integer.parseInt(RegexHelper.getFirstMatchedValueFromRegex("(\\d+)", optionalExpression));
                switch (operator) {
                    case "*":
                        return constValue * num;
                    case "+":
                        return constValue + num;
                    case "-":
                        return constValue - num;
                }
            }
            return constValue;
        }
        return 0;
    }
}