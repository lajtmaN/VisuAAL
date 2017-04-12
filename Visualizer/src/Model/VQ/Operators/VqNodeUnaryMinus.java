package Model.VQ.Operators;

import Model.VQ.VQNodeUnaryOperator;

/**
 * Created by batto on 12-Apr-17.
 */
public class VqNodeUnaryMinus extends VQNodeUnaryOperator {
    @Override
    protected double calculateOperator(double v1) throws Exception {
        return -v1;
    }
}
