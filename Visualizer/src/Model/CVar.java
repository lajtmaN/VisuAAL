package Model;

import javafx.beans.property.*;

import java.io.*;

public class CVar<T> implements Externalizable {
    private StringProperty scope;
    private StringProperty name;
    private Property<T> value;
    private BooleanProperty isConst;

    public CVar(String scope, String name, T value, Boolean isConst) {
        this(scope, name, value);
        setIsConst(isConst);
    }

    public CVar(String scope, String name, T value) {
        this(name, value);
        setScope(scope);
    }

    public CVar(String name, T value) {
        setScope(null);
        setName(name);
        setValue(value);
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

    public T getValue() {
        return value.getValue();
    }

    public Property<T> valueProperty() {
        return value;
    }

    public void setValue(T value) {
        this.value = new SimpleObjectProperty<>(value);
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(getScope());
        out.writeObject(getName());
        out.writeObject(getValue());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setScope((String)in.readObject());
        setName((String)in.readObject());
        setValue((T)in.readObject());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CVar<?> cVar = (CVar<?>) o;
        if (getName() != null ? !getName().equals(cVar.getName()) : cVar.getName() != null) return false;
        if (getScope() != null ? !getScope().equals(cVar.getScope()) : cVar.getScope() != null) return false;
        return getValue() != null ? getValue().equals(cVar.getValue()) : cVar.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        return result;
    }

    public boolean isIsConst() {
        return isConst.get();
    }

    public BooleanProperty isConstProperty() {
        return isConst;
    }

    public void setIsConst(boolean isConst) {
        this.isConst = new SimpleBooleanProperty(isConst);
    }
}