package Model.VQ.Operators;

import Model.VQ.VQNodeBinaryOperator;

import java.util.concurrent.Callable;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeMinus extends VQNodeBinaryOperator {
    @Override
    protected double calculateOperator(Callable<Double> v1, Callable<Double> v2) throws Exception {
        return v1.call() - v2.call();
    }
}
