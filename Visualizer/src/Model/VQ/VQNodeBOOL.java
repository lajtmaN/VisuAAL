package Model.VQ;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeBOOL extends VQNode {
    private String value;

    public VQNodeBOOL(String identifier) {
        this.value = identifier;
    }

    public String getValue() {
        return value;
    }
}
