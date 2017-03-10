package View.simulation;

import org.graphstream.graph.Graph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

public class MouseClickListener extends Thread implements ViewerListener {
    protected boolean loop = true;
    ViewerPipe fromViewer;
    SimulationDataContainer simulationDataContainer;

    public MouseClickListener(Viewer viewer, Graph graph, SimulationDataContainer simulationDataContainer) {
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(graph);
        this.simulationDataContainer = simulationDataContainer;
    }

    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
        simulationDataContainer.nodeIsSelected(Integer.valueOf(id));
    }

    @Override
    public void buttonReleased(String s) {}

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
}