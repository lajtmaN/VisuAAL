package Model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.beans.property.*;

import java.io.*;
import java.util.ArrayList;

public class CVar implements Externalizable {
    private StringProperty scope;
    private StringProperty name;
    private StringProperty value;
    private BooleanProperty isConst;
    private ArrayList<String> arraySizes;
    private String type;

    public ArrayList<String> getArraySizes() {
        return arraySizes;
    }

    public void setArraySizes(ArrayList<String> arraySizes) {
        this.arraySizes = arraySizes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CVar(String scope, String name, String value, Boolean isConst, String type) {
        this(scope, name, value, isConst);
        setType(type);
    }

    public CVar(String scope, String name, String value, Boolean isConst) {
        this(scope, name, value);
        setIsConst(isConst);
    }

    public CVar(String scope, String name, String value) {
        this(name, value);
        setScope(scope);
    }

    public CVar(String name, String value) {
        setScope(null);
        setName(name);
        setValue(value);
        arraySizes = new ArrayList<>();
    }

    public CVar() {
        this(null, null, null);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getValue() {
        return value.getValue();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value = new SimpleStringProperty(value);
    }

    public Integer getValueAsInteger() throws NumberFormatException{
        return Integer.parseInt(getValue());
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

    public boolean getIsConst() {
        return isConst.get();
    }

    public BooleanProperty isConstProperty() {
        return isConst;
    }

    public void setIsConst(boolean isConst) {
        this.isConst = new SimpleBooleanProperty(isConst);
    }

    public boolean hasIntType(){
        return type.equals("int");
    }

    public boolean isArrayType() {
        return arraySizes.size() > 0;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getScope());
        out.writeObject(getName());
        out.writeObject(getValue());
        out.writeObject(getIsConst());
        out.writeObject(getArraySizes());
        out.writeObject(getType());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setScope((String)in.readObject());
        setName((String)in.readObject());
        setValue((String) in.readObject());
        setIsConst((Boolean) in.readObject());
        setArraySizes((ArrayList<String>) in.readObject());
        setType((String) in.readObject());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CVar cVar = (CVar) o;

        if (getScope() != null ? !getScope().equals(cVar.getScope()) : cVar.getScope() != null) return false;
        if (getName() != null ? !getName().equals(cVar.getName()) : cVar.getName() != null) return false;
        if (getValue() != null ? !getValue().equals(cVar.getValue()) : cVar.getValue() != null) return false;
        if (getIsConst() != cVar.getIsConst()) return false;
        if (getArraySizes() != null ? !getArraySizes().equals(cVar.getArraySizes()) : cVar.getArraySizes() != null)
            return false;
        return getType() != null ? getType().equals(cVar.getType()) : cVar.getType() == null;
    }

    @Override
    public int hashCode() {
        int result = getScope() != null ? getScope().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getArraySizes() != null ? getArraySizes().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

}