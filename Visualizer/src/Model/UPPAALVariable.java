package Model;

/**
 * Created by rasmu on 24/02/2017.
 */
public class UPPAALVariable {
    String type, name, value;
    Boolean isConst;

    public UPPAALVariable(String type, String name, String value, Boolean isConst) {
        this.type = type;
        this.name = name;
        this.value = value;
        this.isConst = isConst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPPAALVariable that = (UPPAALVariable) o;

        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null) return false;
        return isConst != null ? isConst.equals(that.isConst) : that.isConst == null;
    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (isConst != null ? isConst.hashCode() : 0);
        return result;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getConst() {
        return isConst;
    }

    public void setConst(Boolean aConst) {
        isConst = aConst;
    }
}
