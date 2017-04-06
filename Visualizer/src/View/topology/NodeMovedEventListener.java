package View.topology;

import java.util.EventListener;

public interface NodeMovedEventListener extends EventListener {
    void onNodeMoved(NodeMovedEvent evt);
}
