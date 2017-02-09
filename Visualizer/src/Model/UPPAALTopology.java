package Model;

import java.util.ArrayList;

/**
 * Created by rasmu on 09/02/2017.
 */
public class UPPAALTopology extends ArrayList<UPPAALEdge> {
    private int _numberOfNodes;

    public UPPAALTopology(int numberOfNodes) {
        this._numberOfNodes = numberOfNodes;
    }
    public UPPAALTopology() {
        this(0);
    }

    public int get_numberOfNodes() {
        return _numberOfNodes;
    }

    public void set_numberOfNodes(int _numberOfNodes) {
        this._numberOfNodes = _numberOfNodes;
    }
}
