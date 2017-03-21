package Model.topology.generator;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by lajtman on 17-03-2017.
 */
public class GlobalOptions {
    private IntegerProperty cellX, cellY, avgNodesPrCell;
    private DoubleProperty avgRange, rangeDeviation, nodesCellDeviation;

    public GlobalOptions() {
        cellX = new SimpleIntegerProperty(this, "cellX", 4);
        cellY = new SimpleIntegerProperty(this, "cellY", 4);
        avgRange = new SimpleDoubleProperty(this, "avgRange", 0.8);
        avgNodesPrCell = new SimpleIntegerProperty(this, "avgNodesPrCell", 5);
        rangeDeviation = new SimpleDoubleProperty(this, "rangeDeviation", 0.05);
        nodesCellDeviation = new SimpleDoubleProperty(this, "nodesCellDeviation", 1);
    }

    public int getCellX() {
        return cellX.get();
    }

    public IntegerProperty cellXProperty() {
        return cellX;
    }

    public void setCellX(int cellX) {
        this.cellX.set(cellX);
    }

    public int getCellY() {
        return cellY.get();
    }

    public IntegerProperty cellYProperty() {
        return cellY;
    }

    public void setCellY(int cellY) {
        this.cellY.set(cellY);
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
