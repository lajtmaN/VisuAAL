package Model.VQ;

import java.util.ArrayList;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQNodePar extends VQNode {
    private VQNodeList subNodes = new VQNodeList();

    @Override
    public VQNodeList getChildrenRecursively() {
        subNodes = super.getChildrenRecursively();
        subNodes.remove(this);
        VQNodeList node = new VQNodeList();
        node.add(this);
        return node;
    }

    public VQNodeList getNodeList() {
        return subNodes;
    }
}
