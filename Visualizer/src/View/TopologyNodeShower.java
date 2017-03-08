package View;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.ui.spriteManager.Sprite;
import org.graphstream.ui.spriteManager.SpriteManager;

/**
 * Created by batto on 08-Mar-17.
 */
public class TopologyNodeShower {
    SpriteManager manager;

    public TopologyNodeShower(Graph graph) {
        this.manager = new SpriteManager(graph);
    }

    public void addNodeView(String nodeId) {
        Sprite sprite = manager.addSprite("s1");
        sprite.attachToNode(nodeId);
        sprite.setAttribute("ui.class", "color");
    }
}
