package Model.VQ;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public abstract class VQNode {
    ArrayList<VQNode> children = new ArrayList<>();
    VQNode parent;

    public void addChild(VQNode child) {
        this.children.add(child);
    }

    public VQNode getParent() {
        return parent;
    }

    public void setParent(VQNode parent) {
        this.parent = parent;
    }

    protected abstract double calculateNodeValue(Map<String, Double> variables) throws Exception;
}