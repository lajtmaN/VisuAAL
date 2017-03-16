package Model;

import javafx.beans.property.*;

import java.io.*;

/**
 * Created by batto on 14-Feb-17.
 */
public class TemplateUpdate implements Externalizable {
    private IntegerProperty time;
    private StringProperty variable, theValue;

    private SimpleObjectProperty<TemplateUpdate> propertyInstance;

    public TemplateUpdate(String variable, String value, int time) {
        this.variable = new SimpleStringProperty(this, "variable", variable);
        this.theValue = new SimpleStringProperty(this, "theValue", value);
        this.time = new SimpleIntegerProperty(this, "time", time);
    }

    public TemplateUpdate() {
        this("", "", 0);
    }

    public int getTime() {
        return time.get();
    }

    public IntegerProperty timeProperty() {
        return time;
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public String getVariableName() {
        return variable.get();
    }

    public StringProperty variableNameProperty() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable.set(variable);
    }

    public String getTheValue() {
        return theValue.get();
    }

    public StringProperty theValueProperty() {
        return theValue;
    }

    public void setTheValue(String theValue) {
        this.theValue.set(theValue);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getTime());
        out.writeObject(getTheValue());
        out.writeObject(getVariableName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setTime(in.readInt());
        setTheValue((String)in.readObject());
        setVariable((String)in.readObject());
        propertyInstance = new SimpleObjectProperty<>(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateUpdate that = (TemplateUpdate) o;

        if (getTime()!=that.getTime()) return false;
        if (getVariableName() != null ? !getVariableName().equals(that.getVariableName()) : that.getVariableName() != null) return false;
        return getTheValue()!= null ? getTheValue().equals(that.getTheValue()) : that.getTheValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getTime();
        result = 31 * result + (getVariableName() != null ? getVariableName().hashCode() : 0);
        result = 31 * result + (getTheValue() != null ? getTheValue().hashCode() : 0);
        return result;
    }
}
