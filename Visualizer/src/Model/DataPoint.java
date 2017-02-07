package Model;

/**
 * Created by lajtman on 07-02-2017.
 */
public class DataPoint {
    public double getClock() {
        return clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    private double clock;
    private double value;
}
