package Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.*;

/**
 * Created by lajtman on 10-02-2017.
 */
public class OutputVariable implements Externalizable{
    private StringProperty name;
    private StringProperty scope;
    private BooleanProperty isEdgeData;
    private BooleanProperty isNodeData;
    private BooleanProperty isSelected;

    //Only used when it represents an edge or node
    private int variableArraySize;

    //Only used for externalization
    public OutputVariable() {}
    public OutputVariable(String pName) {
        this(pName, null);
    }
    public OutputVariable(String pName, String pScope) {
        setName(pName);
        setScope(pScope);
        setEdgeData(false);
        setNodeData(false);
        setIsSelected(true);
    }

    public BooleanProperty isSelected() {
        return isSelected;
    }

    public boolean getIsSelected() {return isSelected().get();}

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

    public String getScope() {
        return scope.get();
    }

    public StringProperty scopeProperty() {
        return scope;
    }

    public void setScope(String newScope) {
        scope = new SimpleStringProperty(newScope);
    }

    public SimulationPoint.SimulationPointType getCorrespondingSimulationPointType() {
        if (getIsEdgeData())
            return SimulationPoint.SimulationPointType.EdgePoint;
        else if (getIsNodeData())
            return SimulationPoint.SimulationPointType.NodePoint;
        else
            return SimulationPoint.SimulationPointType.Variable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputVariable variable = (OutputVariable) o;

        if (variableArraySize != variable.variableArraySize) return false;
        if (getName() != null ? !getName().equals(variable.getName()) : variable.getName() != null) return false;
        if (getScope() != null ? !getScope().equals(variable.getScope()) : variable.getScope() != null) return false;
        if (getIsEdgeData() != variable.getIsEdgeData()) return false;
        if (getIsNodeData() != variable.getIsNodeData()) return false;
        return getIsSelected() == variable.getIsSelected();
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        result = 31 * result + (isEdgeData != null ? isEdgeData.hashCode() : 0);
        result = 31 * result + (isNodeData != null ? isNodeData.hashCode() : 0);
        result = 31 * result + (isSelected != null ? isSelected.hashCode() : 0);
        result = 31 * result + variableArraySize;
        return result;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeObject(getScope());
        out.writeBoolean(getIsEdgeData());
        out.writeBoolean(getIsNodeData());
        out.writeBoolean(getIsSelected());
        out.writeInt(getVariableArraySize());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String) in.readObject());
        setScope((String) in.readObject());
        setEdgeData(in.readBoolean());
        setNodeData(in.readBoolean());
        setIsSelected(in.readBoolean());
        setVariableArraySize(in.readInt());
    }

    @Override
    public String toString() {
        return getScope() == null ? getName() : getScope() + "." + getName();
    }
}
