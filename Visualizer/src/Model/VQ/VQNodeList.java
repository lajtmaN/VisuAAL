package Model.VQ;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeList extends ArrayList<VQNode> {
    private double globalValue = 0, localValue = 0;
    private String unaryOperator = "", operator = "";
    private Map<String, Double> variables;

    public double calculateGradient(Map<String, Double> variables) throws Exception {
        this.variables = variables;

        //TODO: handle boolean literal, expression, rel
        for(VQNode n : this) {
            boolean isValue = true;
            if(n instanceof VQNodeFLOAT)
                localValue = ((VQNodeFLOAT)n).getValue();
            else if(n instanceof VQNodeID)
                localValue = getVarValue(((VQNodeID)n).getIdentifier());
            else if(n instanceof VQNodeNAT)
                localValue = ((VQNodeNAT)n).getValue();
            else if(n instanceof VQNodeOperator) {
                operator = ((VQNodeOperator) n).getOperator();
                isValue = false;
            }
            else if(n instanceof VQNodePar)
                localValue = ((VQNodePar)n).getNodeList().calculateGradient(variables);
            else if(n instanceof VQNodeUnaryOperator) {
                saveUnary(((VQNodeUnaryOperator) n).getOperator());
                isValue = false;
            }

            useUnaryOperator(isValue);
            if(isValue) updateGlobalValue();
        }

        return globalValue;
    }

    private void useUnaryOperator(boolean isValue) {
        if(isValue) {
            if (unaryOperator.equals("-"))
                localValue = -localValue;
            else if(unaryOperator.equals("!")) {
                if (localValue == 0)
                    localValue = 1;
                else
                    localValue = 0;
            }
        }
    }

    private void saveUnary(String operator) throws Exception {
        if(unaryOperator.equals(""))
            unaryOperator = operator;
        else if(unaryOperator.equals("-") && operator.equals("-"))
            unaryOperator = "";
        else if(unaryOperator.equals("!") && operator.equals("!"))
            unaryOperator = "";
        else throw new Exception("Boolean and number unary operators cannot be combined");
    }

    private void updateGlobalValue() throws Exception {
        switch (operator) {
            case "+":
                globalValue += localValue;
                break;
            case "-":
                globalValue -= localValue;
                break;
            case "*":
                globalValue *= localValue;
                break;
            case "/":
                if(localValue == 0)
                    throw new Exception("Division by 0 error");
                else
                    globalValue /= localValue;
                break;
            case "<":
                globalValue = globalValue < localValue ? 1 : 0;
                break;
            case "<=":
                globalValue = globalValue <= localValue ? 1 : 0;
                break;
            case "==":
                globalValue = globalValue == localValue ? 1 : 0;
                break;
            case "!=":
                globalValue = globalValue != localValue ? 1 : 0;
                break;
            case ">=":
                globalValue = globalValue >= localValue ? 1 : 0;
                break;
            case ">":
                globalValue = globalValue > localValue ? 1 : 0;
                break;
            case "&&":
                globalValue = globalValue != 0 && localValue != 0 ? 1 : 0;
                break;
            case "||":
                globalValue = globalValue != 0 || localValue != 0 ? 1 : 0;
                break;
            default: globalValue = localValue;
        }
    }

    private double getVarValue(String identifier) throws Exception {
        if(variables.containsKey(identifier))
            return variables.get(identifier);
        throw new Exception(identifier + " did not match a variable identifier");
    }
}