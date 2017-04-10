package Model.VQ;

import Helpers.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQExpression {
    private String firstColor, secondColor;
    private int firstGradient, secondGradient;
    private VQNodeList nodes;

    public double getGradientForNode(Map<String, Double> variables) throws Exception {
        return nodes.calculateGradient(variables, firstGradient, secondGradient);
    }

    public void saveExpression(VQNode rootNode) {
        VQNodeList resNodes = rootNode.getChildrenRecursively();
        resNodes.remove(resNodes.size() - 1);
        this.nodes = resNodes;
    }

    public String getFirstColor() {
        return firstColor;
    }

    public void setFirstColor(String firstColor) {
        this.firstColor = firstColor;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }

    public int getFirstGradient() {
        return firstGradient;
    }

    public void setFirstGradient(int firstGradient) {
        this.firstGradient = firstGradient;
    }

    public void setFirstGradient(int firstGradient, boolean negative) {
        setFirstGradient(negative ? -firstGradient : firstGradient);
    }

    public int getSecondGradient() {
        return secondGradient;
    }

    public void setSecondGradient(int secondGradient) {
        this.secondGradient = secondGradient;
    }

    public void setSecondGradient(int secondGradient, boolean negative) {
        setSecondGradient(negative ? -secondGradient : secondGradient);
    }
}