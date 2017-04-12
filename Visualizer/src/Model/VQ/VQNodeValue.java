package Model.VQ;

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
}
