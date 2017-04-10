package Model.VQ;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeOperator extends VQNode {
    private String operator;

    public VQNodeOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
