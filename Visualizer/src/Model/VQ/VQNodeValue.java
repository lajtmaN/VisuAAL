package Model.VQ;

import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeValue extends VQNode {
    private double value;

    public VQNodeValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    protected double calculateNodeValue(Map<String, Double> variables) {
        return value;
    }
}