package Model.VQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by batto on 12-Apr-17.
 */
public class VQParseTree {
    private double firstGradient = 0,
                   secondGradient = 1;
    private String firstColor,
                   secondColor;
    private List<VQNode> children = new ArrayList<>();

    public double getGradient(Map<String, Double> variables) throws Exception {
        if(secondGradient <= firstGradient)
            throw new Exception("The maximum gradient must be greater than the minimum gradient");

        //TODO: Call recursive func to get result
        double gradientValue = gradientValue(firstGradient, secondGradient, 0);
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
}
