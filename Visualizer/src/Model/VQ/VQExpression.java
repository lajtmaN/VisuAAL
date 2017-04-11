package Model.VQ;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQExpression {
    private String firstColor, secondColor;
    private VQNodeList nodes;
    private double firstGradient, secondGradient;

    public double getGradient(Map<String, Double> variables) throws Exception {
        if(secondGradient <= firstGradient)
            throw new Exception("The maximum gradient must be greater than the minimum gradient");

        double gradientValue = gradientValue(firstGradient, secondGradient, getResultFromVQ(variables));
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

    public double getResultFromVQ(Map<String, Double> variables) throws Exception {
        return nodes.calculateGradient(variables);
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

    public double getFirstGradient() {
        return firstGradient;
    }

    public double getSecondGradient() {
        return secondGradient;
    }

    public void setFirstGradient(double firstGradient) {
        this.firstGradient = firstGradient;
    }

    public void setFirstGradient(double firstGradient, boolean negative) {
        setFirstGradient(negative ? -firstGradient : firstGradient);
    }

    public void setSecondGradient(double secondGradient) {
        this.secondGradient = secondGradient;
    }

    public void setSecondGradient(double secondGradient, boolean negative) {
        setSecondGradient(negative ? -secondGradient : secondGradient);
    }
}