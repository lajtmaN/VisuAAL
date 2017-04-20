package Model.VQ;

import java.util.Map;

/**
 * Created by batto on 20-Apr-17.
 */
public class VQNodeTernaryOperator extends VQNode {
    @Override
    protected double calculateNodeValue(Map<String, Double> variables) throws Exception {
        return calculateOperator(children.get(0).calculateNodeValue(variables),
                                 children.get(1).calculateNodeValue(variables),
                                 children.get(2).calculateNodeValue(variables));
    }

    protected double calculateOperator(double v1, double v2, double v3) throws Exception {
        throw new Exception("This class should not be used directly. Override in specific operators");
    }
}