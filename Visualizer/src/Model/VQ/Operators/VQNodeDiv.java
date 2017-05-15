package Model.VQ.Operators;

import Model.VQ.VQNodeBinaryOperator;

import java.util.concurrent.Callable;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeDiv extends VQNodeBinaryOperator {
    @Override
    protected double calculateOperator(Callable<Double> v1, Callable<Double> v2) throws Exception {
        double v2value = v2.call();
        if(v2value == 0) throw new ArithmeticException("Division by 0 error");
        return v1.call() / v2value;
    }
}