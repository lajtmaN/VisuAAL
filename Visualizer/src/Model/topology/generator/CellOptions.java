package Model.topology.generator;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by lajtman on 20-03-2017.
 */
public class CellOptions {
    private IntegerProperty avgNodesPrCell;
    private DoubleProperty avgRange, rangeDeviation, nodesCellDeviation;

    public CellOptions(GlobalOptions options) {
        avgRange = new SimpleDoubleProperty(this, "avgRange", options.getAvgRange());
        avgNodesPrCell = new SimpleIntegerProperty(this, "avgNodesPrCell", options.getAvgNodesPrCell());
        rangeDeviation = new SimpleDoubleProperty(this, "rangeDeviation", options.getRangeDeviation());
        nodesCellDeviation = new SimpleDoubleProperty(this, "nodesCellDeviation", options.getNodesCellDeviation());
    }

    public double getAvgRange() {
        return avgRange.get();
    }

    public DoubleProperty avgRangeProperty() {
        return avgRange;
    }

    public void setAvgRange(double avgRange) {
        this.avgRange.set(avgRange);
    }

    public int getAvgNodesPrCell() {
        return avgNodesPrCell.get();
    }

    public IntegerProperty avgNodesPrCellProperty() {
        return avgNodesPrCell;
    }

    public void setAvgNodesPrCell(int avgNodesPrCell) {
        this.avgNodesPrCell.set(avgNodesPrCell);
    }

    public double getRangeDeviation() {
        return rangeDeviation.get();
    }

    public DoubleProperty rangeDeviationProperty() {
        return rangeDeviation;
    }

    public void setRangeDeviation(double rangeDeviation) {
        this.rangeDeviation.set(rangeDeviation);
    }

    public double getNodesCellDeviation() {
        return nodesCellDeviation.get();
    }

    public DoubleProperty nodesCellDeviationProperty() {
        return nodesCellDeviation;
    }

    public void setNodesCellDeviation(double nodesCellDeviation) {
        this.nodesCellDeviation.set(nodesCellDeviation);
    }
}
