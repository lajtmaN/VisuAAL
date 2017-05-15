package Model.VQ.Operators;

import Model.VQ.VQNodeUnaryOperator;

/**
 * Created by batto on 12-Apr-17.
 */
public class VqNodeUnaryNot extends VQNodeUnaryOperator {
    @Override
    protected double calculateOperator(double v1) throws Exception {
        return v1 != 0 ? 0 : 1;
    }
}