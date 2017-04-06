package View.topology;

import java.util.EventObject;

/**
 * Created by lajtman on 06-04-2017.
 */
public class NodeMovedEvent extends EventObject {
    private String nodeIdentifier;
    private double newX;
    private double newY;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @param nodeIdentifier The node which is updated
     * @throws IllegalArgumentException if source is null.
     */
    public NodeMovedEvent(Object source, String nodeIdentifier, double newX, double newY) {
        super(source);
        this.nodeIdentifier = nodeIdentifier;
        this.newX = newX;
        this.newY = newY;

    }

    public String getNodeIdentifier() {
        return nodeIdentifier;
    }

    public double getNewX() {
        return newX;
    }

    public double getNewY() {
        return newY;
    }
}

