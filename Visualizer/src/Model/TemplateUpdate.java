package Model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.io.*;

/**
 * Created by batto on 14-Feb-17.
 */
<<<<<<< HEAD
public class TemplateUpdate implements Serializable {
=======
public class TemplateUpdate implements Externalizable {
>>>>>>> 05708853ceafbdae9e3094ad5f3fac7842909f8f
    private IntegerProperty time,
            theValue;


    private StringProperty variable;

    public TemplateUpdate(String variable, int value, int time) {
        setVariable(variable);
        setTheValue(value);
        setTime(time);
    }

    public TemplateUpdate() {
        setVariable("");
        setTheValue(0);
        setTime(0);
    }

    public int getTime() {
        return time.get();
    }

    public IntegerProperty timeProperty() {
        return time;
    }

    public void setTime(int time) {
        this.time = new SimpleIntegerProperty(time);
    }

    public String getVariable() {
        return variable.get();
    }

    public StringProperty variableProperty() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = new SimpleStringProperty(variable);
    }

    public int getTheValue() {
        return theValue.get();
    }

    public IntegerProperty theValueProperty() {
        return theValue;
    }

    public void setTheValue(int theValue) {
        this.theValue = new SimpleIntegerProperty(theValue);
    }
<<<<<<< HEAD
}
=======

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getTime());
        out.writeInt(getTheValue());
        out.writeObject(getVariable());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setTime(in.readInt());
        setTheValue(in.readInt());
        setVariable((String)in.readObject());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateUpdate that = (TemplateUpdate) o;

        if (getTime() != that.getTime()) return false;
        if (getTheValue() != that.getTheValue()) return false;
        return getVariable() != null ? getVariable().equals(that.getVariable()) : that.getVariable() == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (theValue != null ? theValue.hashCode() : 0);
        result = 31 * result + (variable != null ? variable.hashCode() : 0);
        return result;
    }
}
>>>>>>> 05708853ceafbdae9e3094ad5f3fac7842909f8f
