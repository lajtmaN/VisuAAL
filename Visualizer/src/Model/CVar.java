package Model;

import java.io.Serializable;

public class CVar<T> implements Serializable{
    public CVar(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public CVar() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private String name;
    private T value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CVar<?> cVar = (CVar<?>) o;

        if (name != null ? !name.equals(cVar.name) : cVar.name != null) return false;
        return value != null ? value.equals(cVar.value) : cVar.value == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
