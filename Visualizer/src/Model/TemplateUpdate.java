package Model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.io.Serializable;

/**
 * Created by batto on 14-Feb-17.
 */
public class TemplateUpdate implements Serializable, ObservableValue<String> {
    private IntegerProperty time,
            theValue;

    private StringProperty variable;
    private boolean used = false;

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

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void addListener(ChangeListener<? super String> listener) {

    }

    @Override
    public void removeListener(ChangeListener<? super String> listener) {

    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
