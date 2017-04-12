package Model.VQ.Operators;

import Model.VQ.VQNodeBinaryOperator;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeGreaterThanEq extends VQNodeBinaryOperator {
    @Override
    protected double calculateOperator(double v1, double v2) throws Exception {
        if(v1 >= v2) return 1;
        return 0;
    }
}
