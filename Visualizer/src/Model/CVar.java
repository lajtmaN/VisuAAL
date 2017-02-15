package Model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.*;

public class CVar<T> implements Externalizable {

    private StringProperty name;
    private Property<T> value;

    public CVar(String name, T value) {
        setName(name);
        setValue(value);
    }

    public CVar() {
        this(null, null);
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

    public T getValue() {
        return value.getValue();
    }

    public Property<T> valueProperty() {
        return value;
    }

    public void setValue(T value) {
        this.value = new SimpleObjectProperty<>(value);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getName());
        out.writeObject(getValue());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setName((String)in.readObject());
        setValue((T)in.readObject());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CVar<?> cVar = (CVar<?>) o;
        if (getName() != null ? !getName().equals(cVar.getName()) : cVar.getName() != null) return false;
        return getValue() != null ? getValue().equals(cVar.getValue()) : cVar.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

}
