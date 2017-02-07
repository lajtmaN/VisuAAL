package parsers;

import Model.CVar;
import com.sun.corba.se.impl.io.TypeMismatchException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CHandler {
    private static final String ConfigVariableRegex = "CONFIG_(\\w)+(\\s)*=(\\s)*(\\d)+";
    private static final String ConstDeclarationRegex(String type) {
        return "const " + type + "(\\s)*((\\w)*(\\s)*=[\\d\\w*+\\-/%\\s,]*)*;"; }

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
            return decls.replaceFirst(name + "( )*=( )*(\\d)*", name + " = " + String.valueOf(value));
        }
        throw new TypeMismatchException("The variable does not exist or must be the same type as the input variable!");
    }

    //Works for int only current. Regex can be updated to match different types
    private static boolean isCorrectType(String type, String name, String decls) {
        //Match full const expression
        Matcher matcher = getConstMatcher(type, decls);

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

    private static Matcher getConstMatcher(String type, String decls) {
        Pattern patternConstExpr = Pattern.compile(ConstDeclarationRegex(type));
        return patternConstExpr.matcher(decls);
    }

    private static ArrayList<String> getConstantGroups(String decls) {
        ArrayList<String> groups = new ArrayList<>();
        Matcher matcher = getConstMatcher("int", decls);
        while(matcher.find()) {
            groups.add(matcher.group());
        }
        return groups;
    }

    public static ArrayList<CVar<Integer>> getConstants(String decls) {
        ArrayList<CVar<Integer>> constantNames = new ArrayList<>();

        //Pattern Name
        Pattern pVar = Pattern.compile(ConfigVariableRegex);

        for(String s : getConstantGroups(decls)) {
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

    public static String getFirstMatchedValueFromRegex(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find())
            return matcher.group(1);
        return "";
    }
}












