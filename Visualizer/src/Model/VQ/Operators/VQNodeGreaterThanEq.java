package Model.VQ.Operators;

import Model.VQ.VQNodeBinaryOperator;

import java.util.concurrent.Callable;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeGreaterThanEq extends VQNodeBinaryOperator {
    @Override
    protected double calculateOperator(Callable<Double> v1, Callable<Double> v2) throws Exception {
        if(v1.call() >= v2.call()) return 1;
        return 0;
    }
}