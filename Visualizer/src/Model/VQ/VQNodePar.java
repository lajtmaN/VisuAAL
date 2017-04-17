package Model.VQ;

import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodePar extends VQNode {
    @Override
    protected double calculateNodeValue(Map<String, Double> variables) throws Exception {
        return children.get(0).calculateNodeValue(variables);
    }
}