package Model.VQ.Operators;

import Model.VQ.VQNodeBinaryOperator;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeDiv extends VQNodeBinaryOperator {
    @Override
    protected double calculateOperator(double v1, double v2) throws Exception {
        if(v2 == 0) throw new Exception("Division by 0 error");
        return v1 / v2;
    }
}
