package parsers;

import Model.CVar;
import Model.UPPAALEdge;
import Model.UPPAALTopology;
import Model.UPPAALVariable;
import parsers.Declaration.VariableParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CHandler {
    private static final String ConfigVariablePrefix = "CONFIG_";
    private static final String TopologyRegex = "CONFIG_connected\\[.+\\n((?:[^;])+)\\};";
    private static final String TopologyFormRegex = "((?:\\{(?:\\d,)*\\d\\},)*(?:\\{(?:\\d,)*\\d\\})+)";
    private static final String ConfigVariableRegex = "CONFIG_(\\w)+(\\s)*=(\\s)*(\\d)+";
    private static final String OutputVarsRegex = "int\\s+(OUTPUT_(?:\\w)+(?:\\s*\\[\\w+\\])*)";
    private static final String ConfigDeclarationRegex(String type) {
        return "(const\\s)?" + type + "(\\s)*((\\w)*(\\s)*=[\\d\\w*+\\-/%\\s,]*)+;"; }
    private static final String TypedefRegex(String typedefName) {
        return "typedef\\s+int\\s+\\[\\s*0,\\s*(CONFIG_\\w+)([*+-]\\d+)?\\]\\s+" + typedefName;
    }

    private static final String ConstRegex(String type) {
        return "const\\s+" + type + "\\s+(\\w)+(\\s)*=(\\s)*(\\d)+";
    }
    /**
     * Update a var in the XML decls
     * @param name of the variable
     * @param value new value
     * @param decls string containing declarations
     * @return the updated declarations
     */
    public static String updateIntConfigVar(String name, int value, String decls) {
        if(isCorrectType("int", name, decls)) {
            //Update value of the variable
            return decls.replaceFirst(name + "\\s*=\\s*(\\d)+\\s*", name + " = " + String.valueOf(value));
        }
        throw new IllegalArgumentException("The variable does not exist or must be the same type as the input variable");
    }

    //Works for int only current. Regex can be updated to match different types
    private static boolean isCorrectType(String type, String name, String decls) {
        //Match full const expression
        Matcher matcher = getConfigMatcher(type, decls);

        //Match 'name' var
        Pattern patternVar = Pattern.compile(name + "( )*=");

        //Isolate const definition expressions
        while(matcher.find()) {
            String s = matcher.group();
            //System.out.println(s);

            //If type and variable mathces, return true
            Matcher mVar = patternVar.matcher(s);
            if(mVar.find()) {
                //System.out.println(mVar.group());
                return true;
            }
        }
        return false;
    }

    private static Matcher getConfigMatcher(String type, String decls) {
        Pattern patternConstExpr = Pattern.compile(ConfigDeclarationRegex(type));
        return patternConstExpr.matcher(decls);
    }

    private static ArrayList<String> getConfigGroups(String decls) {
        ArrayList<String> groups = new ArrayList<>();
        Matcher matcher = getConfigMatcher("int", decls);
        while(matcher.find()) {
            groups.add(matcher.group());
        }
        return groups;
    }

    public static ArrayList<CVar> getConfigVariables(String decls, String scope) {
        ArrayList<CVar> returnvals = new ArrayList<>();
        ArrayList<UPPAALVariable> vars = VariableParser.getInstantiations(decls);
        vars.removeIf(uppaalVariable -> !uppaalVariable.getName().startsWith(ConfigVariablePrefix));
        for(UPPAALVariable var : vars){
            try {
                if(var.getType().equals("int") && var.getArraySizes().size() == 0) {
                    returnvals.add(new CVar(scope, var.getName(), var.getValue(), var.getConst(), "int"));
                }
            } catch (NumberFormatException e) {}
        }
        return returnvals;
    }
    public static ArrayList<CVar> getConfigVariables(HashMap<String, String> allDecls) {
        ArrayList<CVar> constantNames = new ArrayList<>();
        for (String scopeKey : allDecls.keySet()) {
            constantNames.addAll(getConfigVariables(allDecls.get(scopeKey), scopeKey));
        }

        return constantNames;
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
                            result.add(new UPPAALEdge(source_index, destination_index));
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

    public static ArrayList<String> getOutputVars(String declarations) {
        Pattern pVar = Pattern.compile(OutputVarsRegex);
        ArrayList<String> vars = new ArrayList<>();

        Matcher mName = pVar.matcher(declarations);

        while(mName.find()) {
            vars.add(mName.group(1));
        }

        return vars;
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