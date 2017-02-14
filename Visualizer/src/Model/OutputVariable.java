package Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import parsers.CHandler;
import parsers.RegexHelper;
import parsers.UPPAALParser;

import java.io.Serializable;
import java.util.ArrayList;

import static parsers.CHandler.getConstants;

/**
 * Created by lajtman on 10-02-2017.
 */
public class OutputVariable implements Serializable{
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
        return isEdgeData().get();
    }

    public void setEdgeData(boolean edgeData) {
        isEdgeData = new SimpleBooleanProperty(edgeData);
    }

    public BooleanProperty isNodeData() {
        return isNodeData;
    }

    public Boolean getIsNodeData() {
        return isNodeData().get();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputVariable variable = (OutputVariable) o;

        if (variableArraySize != variable.variableArraySize) return false;
        if (name != null ? !name.equals(variable.name) : variable.name != null) return false;
        if (isEdgeData != null ? !isEdgeData.equals(variable.isEdgeData) : variable.isEdgeData != null) return false;
        if (isNodeData != null ? !isNodeData.equals(variable.isNodeData) : variable.isNodeData != null) return false;
        return isSelected != null ? isSelected.equals(variable.isSelected) : variable.isSelected == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (isEdgeData != null ? isEdgeData.hashCode() : 0);
        result = 31 * result + (isNodeData != null ? isNodeData.hashCode() : 0);
        result = 31 * result + (isSelected != null ? isSelected.hashCode() : 0);
        result = 31 * result + variableArraySize;
        return result;
    }
}
