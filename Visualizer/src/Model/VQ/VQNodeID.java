package Model.VQ;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeID extends VQNode {
    private String identifier;

    public VQNodeID(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
