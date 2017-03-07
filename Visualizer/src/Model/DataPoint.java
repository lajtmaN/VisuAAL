package Model;

import java.io.Serializable;

/**
 * Created by lajtman on 07-02-2017.
 */
public class DataPoint implements Serializable{
    public DataPoint() {
    }

    public DataPoint(double time, double value) {
        setClock(time);
        setValue(value);
    }

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
    private double previousValue;

    public double getPreviousValue(){ return previousValue; }
    public void setPreviousValue(double value) { this.previousValue = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataPoint dataPoint = (DataPoint) o;

        if (Double.compare(dataPoint.clock, clock) != 0) return false;
        return Double.compare(dataPoint.value, value) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(clock);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "("+clock+":"+value+")";
    }
}
