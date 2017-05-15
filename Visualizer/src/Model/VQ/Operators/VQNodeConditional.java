package Model.VQ.Operators;

import Model.VQ.VQNodeTernaryOperator;

import java.util.concurrent.Callable;

/**
 * Created by batto on 20-Apr-17.
 */
public class VQNodeConditional extends VQNodeTernaryOperator {
    @Override
    protected double calculateOperator(Callable<Double> v1, Callable<Double> v2, Callable<Double> v3) throws Exception {
        if(v1.call() != 0)
            return v2.call();
        else
            return v3.call();
    }
}