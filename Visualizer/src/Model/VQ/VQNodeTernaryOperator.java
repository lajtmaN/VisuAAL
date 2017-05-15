package Model.VQ;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by batto on 20-Apr-17.
 */
public class VQNodeTernaryOperator extends VQNode {
    @Override
    protected double calculateNodeValue(Map<String, Double> variables) throws Exception {
        return calculateOperator(() -> children.get(0).calculateNodeValue(variables),
                                 () -> children.get(1).calculateNodeValue(variables),
                                 () -> children.get(2).calculateNodeValue(variables));
    }

    protected double calculateOperator(Callable<Double> v1, Callable<Double> v2, Callable<Double> v3) throws Exception {
        throw new Exception("This class should not be used directly. Override in specific operators");
    }
}