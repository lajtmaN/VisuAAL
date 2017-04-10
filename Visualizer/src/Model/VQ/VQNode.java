package Model.VQ;

import java.util.ArrayList;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNode {
    ArrayList<VQNode> children = new ArrayList<>();
    VQNode parent;

    public ArrayList<VQNode> getChildren() {
        return children;
    }

    public void addChild(VQNode child) {
        this.children.add(child);
    }

    public VQNode getParent() {
        return parent;
    }

    public void setParent(VQNode parent) {
        this.parent = parent;
    }
}