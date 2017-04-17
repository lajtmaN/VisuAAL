package Model.VQ.Operators;

import Model.VQ.VQNodeBinaryOperator;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeOr extends VQNodeBinaryOperator {
    @Override
    protected double calculateOperator(double v1, double v2) throws Exception {
        if(v1 != 0 || v2 != 0) return 1;
        return 0;
    }
}
