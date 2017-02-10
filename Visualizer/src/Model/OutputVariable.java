package Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by lajtman on 10-02-2017.
 */
public class OutputVariable {
    private StringProperty name;
    private BooleanProperty isEdgeData;
    private BooleanProperty isNodeData;

    public OutputVariable(String pName) {
        setName(pName);
        setEdgeData(true);
        setNodeData(false);
    }

    public StringProperty name() {
        return name;
    }

    public void setName(String pName) {
        this.name = new SimpleStringProperty(pName);
    }

    public BooleanProperty isEdgeData() {
        return isEdgeData;
    }

    public void setEdgeData(boolean edgeData) {
        isEdgeData = new SimpleBooleanProperty(edgeData);
    }

    public BooleanProperty isNodeData() {
        return isNodeData;
    }

    public void setNodeData(boolean nodeData) {
        isNodeData = new SimpleBooleanProperty(nodeData);
    }
}
