package parsers;

import Model.CVar;
import Model.UPPAALEdge;
import Model.UPPAALTopology;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CHandler {
    private static final String TopologyRegex = "CONFIG_connected\\[.+\\n((?:[^;])+)\\};";
    private static final String TopologyFormRegex = "((?:\\{(?:\\d,)*\\d\\},)*(?:\\{(?:\\d,)*\\d\\})+)";
    private static final String ConfigVariableRegex = "CONFIG_(\\w)+(\\s)*=(\\s)*(\\d)+";
    private static final String OutputVarsRegex = "(OUTPUT_(?:\\w)+(?:\\s*\\[\\w+\\])*)";

    private static final String ConstDeclarationRegex(String type) {
        return type + "(\\s)*CONFIG((\\w)*(\\s)*=[\\d\\w*+\\-/%\\s,]*)*;"; }

    private static final String dummy = "^int";
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
        Pattern patternConstExpr = Pattern.compile(ConstDeclarationRegex(type));
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

    public static ArrayList<CVar<Integer>> getConfigVariables(String decls) {
        ArrayList<CVar<Integer>> constantNames = new ArrayList<>();

        //Pattern Name
        Pattern pVar = Pattern.compile(ConfigVariableRegex);

        for(String s : getConfigGroups(decls)) {
            Matcher mName = pVar.matcher(s);

            while(mName.find()) {
                CVar<Integer> var = new CVar();
                String[] nameAndVal = mName.group().replace(" ","").split("=");
                var.setName(nameAndVal[0]);
                var.setValue(Integer.parseInt(nameAndVal[1]));
                constantNames.add(var);
            }
        }

        return constantNames;
    }

    public static UPPAALTopology getTopology(String decls){
        UPPAALTopology result = new UPPAALTopology();
        String definitionString = RegexHelper.getFirstMatchedValueFromRegex(TopologyRegex, decls);
        if(!definitionString.equals(null)) {
            definitionString = definitionString.replace(" ", "").replace("\n", "");
            if (!RegexHelper.getFirstMatchedValueFromRegex(TopologyFormRegex, definitionString).equals(null)) {
                int source_index = 0;
                for (String s : definitionString.split("}")) {
                    String temp = s.replace(" ", "").replace("\n", "");
                    temp = temp.replace(",{", "").replace("}", "").replace("{", "");
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

    public static ArrayList<String> getOutputVars(String globalDeclarations) {
        Pattern pVar = Pattern.compile(OutputVarsRegex);
        ArrayList<String> vars = new ArrayList<>();

        Matcher mName = pVar.matcher(globalDeclarations);

        while(mName.find()) {
            vars.add(mName.group(1));
        }

        return vars;
    }
}












