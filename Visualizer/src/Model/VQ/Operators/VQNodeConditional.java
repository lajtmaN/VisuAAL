package Model.VQ.Operators;

import Model.VQ.VQNodeTernaryOperator;

/**
 * Created by batto on 20-Apr-17.
 */
public class VQNodeConditional extends VQNodeTernaryOperator {
    @Override
    protected double calculateOperator(double v1, double v2, double v3) throws Exception {
        return v1 != 0 ? v2 : v3;
    }
}