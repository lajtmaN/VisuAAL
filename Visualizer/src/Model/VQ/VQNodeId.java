package Model.VQ;

import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodeId extends VQNode {
    private String identifier;

    public VQNodeId(String id) {
        super();
        identifier = id;
    }

    @Override
    protected double calculateNodeValue(Map<String, Double> variables) throws Exception {
        if(variables.containsKey(identifier))
            return variables.get(identifier);
        throw new Exception("The identifier: " + identifier + " does not exist. It might be discovered later.");
    }
}