package Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import parsers.CHandler;
import parsers.RegexHelper;
import parsers.UPPAALParser;

import java.util.ArrayList;

import static parsers.CHandler.getConstants;

/**
 * Created by lajtman on 10-02-2017.
 */
public class OutputVariable {
    private StringProperty name;
    private BooleanProperty isEdgeData;
    private BooleanProperty isNodeData;
    private BooleanProperty isSelected;

    //Only used when it represents an edge or node
    private int variableArraySize;

    public OutputVariable(String pName) {
        setName(pName);
        setEdgeData(false);
        setNodeData(false);
        setIsSelected(false);
    }

    public BooleanProperty isSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = new SimpleBooleanProperty(isSelected);
    }

    public StringProperty name() {
        return name;
    }

    public String getName() { return name.get(); }

    public void setName(String pName) {
        this.name = new SimpleStringProperty(pName);
    }

    public BooleanProperty isEdgeData() {
        return isEdgeData;
    }

    public Boolean getIsEdgeData() {
        return isEdgeData.get();
    }

    public void setEdgeData(boolean edgeData) {
        isEdgeData = new SimpleBooleanProperty(edgeData);
    }

    public BooleanProperty isNodeData() {
        return isNodeData;
    }

    public Boolean getIsNodeData() {
        return isNodeData.get();
    }

    public void setNodeData(boolean nodeData) {
        isNodeData = new SimpleBooleanProperty(nodeData);
    }

    public void setVariableArraySize(int size) {
        variableArraySize = size;
    }

    public int getVariableArraySize() {
        return variableArraySize;
    }
}
