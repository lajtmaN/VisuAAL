package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by batto on 19-Apr-17.
 */
public class GraphValueMapper implements Serializable {
    Map<String, Map<String, Double>> nodeVarValueMap = new HashMap<>();

    /**
     * Updates a nodes variables value
     * @param nodeOrEdgeIdentifier
     * @param varIdentifier includes scope if any
     * @param value new value
     */
    public void updateNodeVariable(String nodeOrEdgeIdentifier, String varIdentifier, double value) {
        initilizeNodeOrEdgeIdentifier(nodeOrEdgeIdentifier);
        nodeVarValueMap.get(nodeOrEdgeIdentifier).put(varIdentifier, value);
    }

    private void initilizeNodeOrEdgeIdentifier(String nodeOrEdgeIdentifier) {
        if(!nodeVarValueMap.containsKey(nodeOrEdgeIdentifier))
            nodeVarValueMap.put(nodeOrEdgeIdentifier, new HashMap<>());
    }

    /**
     * Get map for specific node or edge
     * @param nodeOrEdgeIdentifier
     * @return the map
     */
    public Map<String, Double> getNodeOrEdgeVariableMap(String nodeOrEdgeIdentifier) {
        initilizeNodeOrEdgeIdentifier(nodeOrEdgeIdentifier);
        return nodeVarValueMap.get(nodeOrEdgeIdentifier);
    }
}