package Model.VQ;

import com.lowagie.text.pdf.ArabicLigaturizer;

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

    public VQNodeList getChildrenRecursively() {
        VQNodeList res = new VQNodeList();

        if(children.size() == 1) {
            res.addAll(children.get(0).getChildrenRecursively());
            res.add(this);
        }
        else if(children.size() == 2) {
            res.addAll(children.get(0).getChildrenRecursively());
            res.add(this);
            res.addAll(children.get(1).getChildrenRecursively());
        }
        else
            res.add(this);

        return res;
    }
}