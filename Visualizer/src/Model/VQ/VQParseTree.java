package Model.VQ;

import Helpers.Pair;
import Model.OutputVariable;
import parsers.VQParser.VQParse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by battow on 12-Apr-17.
 */
public class VQParseTree {
    private double firstGradient = 0, secondGradient = 1;
    private String firstColor, secondColor;
    private VQNode root;
    private VQType type = null;
    private Collection<String> usedVariables = new ArrayList<>();

    public enum VQType { Edge, Node, Unknown}

    public double getGradient(Map<String, Double> variables) throws Exception {
        if(secondGradient <= firstGradient)
            throw new Exception("The maximum gradient must be greater than the minimum gradient");

        double gradientValue = gradientValue(firstGradient, secondGradient, root.calculateNodeValue(variables));
        if (gradientValue >= 1.0)
            return 1.0;
        else if (gradientValue <= 0.0)
            return 0.0;

        return gradientValue;
    }

    double gradientValue(double min, double max, double value) {
        double diff = max - min;
        if (diff > 0)
            return (value - min) / diff;
        return 0;
    }

    //Getters & setters
    public void setFirstGradient(double firstGradient, boolean neg) {
        if(neg)
            this.firstGradient = -firstGradient;
        else
            this.firstGradient = firstGradient;
    }

    public void setSecondGradient(double secondGradient, boolean neg) {
        if(neg)
            this.secondGradient = -secondGradient;
        else
            this.secondGradient = secondGradient;
    }

    public void setFirstColor(String firstColor) {
        this.firstColor = firstColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }

    public double getFirstGradient() {
        return firstGradient;
    }

    public double getSecondGradient() {
        return secondGradient;
    }

    public String getFirstColor() {
        return firstColor;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public VQNode getRoot() {
        return root;
    }

    public void setRoot(VQNode root) {
        this.root = root;
    }

    public Collection<String> getUsedVariables() {
        return usedVariables;
    }

    public void addUsedVariable(String var) {
        usedVariables.add(var);
    }

    public VQType getType() {
        return type;
    }

    public void calculateVQType(List<OutputVariable> allVars) throws Exception {
        VQType foundType = VQType.Unknown;
        for (String varInVQ : getUsedVariables()) {
            OutputVariable usedVar = allVars.stream()
                    .filter(o -> o.toString().equals(varInVQ))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Could not find variable" + varInVQ));

            if (usedVar.getIsNodeData()) {
                if (foundType == VQType.Edge)
                    throw new Exception("Mixed both Edge and Node types");

                foundType = VQType.Node;
            }
            else if (usedVar.getIsEdgeData()) {
                if (foundType == VQType.Node)
                    throw new Exception("Mixed both Edge and Node types");

                foundType = VQType.Edge;
            }
            else {
                throw new Exception("Cannot use global variables");
            }
        }
        type = foundType;
    }

    public static boolean validVQ(String vq, List<OutputVariable> allVars) {
        VQParseTree parsed = VQParse.parse(vq, allVars);
        return validVQ(parsed);
    }

    public static boolean validVQ(VQParseTree parsedVQ) {
        return parsedVQ != null && parsedVQ.getType() != VQType.Unknown;
    }
}
