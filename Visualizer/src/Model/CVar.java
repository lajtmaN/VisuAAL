package Model;

public class CVar<T> {
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
}
