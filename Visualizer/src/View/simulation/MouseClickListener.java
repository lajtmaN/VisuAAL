package View.simulation;

import View.topology.NodeMovedEvent;
import View.topology.NodeMovedEventListener;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

import java.util.ArrayList;
import java.util.List;


public class MouseClickListener extends Thread implements ViewerListener {
    private boolean loop = true;
    private ViewerPipe fromViewer;
    private SimulationDataContainer simulationDataContainer;
    private Graph graph;

    private List<NodeMovedEventListener> eventListeners = new ArrayList<>();


    private MouseClickListener(Viewer viewer, Graph graph) {
        this.graph = graph;
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(graph);
    }

    /**
     * This constructor will update the SimulationDataContainer when a node is pressed
     * @param viewer The graph viewer
     * @param graph The graph object shown
     * @param simulationDataContainer container with data from each node
     */
    public MouseClickListener(Viewer viewer, Graph graph, SimulationDataContainer simulationDataContainer) {
        this(viewer, graph);
        this.simulationDataContainer = simulationDataContainer;
    }

    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
        if (simulationDataContainer != null)
            simulationDataContainer.nodeIsSelected(Integer.valueOf(id));
    }

    @Override
    public void buttonReleased(String id) {
        if (!eventListeners.isEmpty()) {
            Object[] newXYZ = graph.getNode(id).getAttribute("xyz");
            NodeMovedEvent evt = new NodeMovedEvent(this, id, (double)newXYZ[0], (double)newXYZ[1]);

            eventListeners.forEach(l -> l.onNodeMoved(evt));
        }
    }

    @Override
    public void run() {
        super.run();
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fromViewer.pump();
        }
    }

    public void addNodesMovedListener(NodeMovedEventListener listener) {
        eventListeners.add(listener);
    }
}