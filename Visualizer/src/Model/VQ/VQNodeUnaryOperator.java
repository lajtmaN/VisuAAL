package Model.VQ;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeUnaryOperator extends VQNode {
    private String operator;

    public VQNodeUnaryOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}