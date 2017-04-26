package View.topology;

import Helpers.GoogleMapsHelper;
import Helpers.Pair;
import Model.topology.LatLng;
import Model.topology.LatLngBounds;
import View.simulation.MouseClickListener;
import View.simulation.SimulationDataContainer;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.MapReadyListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import parsers.GPSLog.SeedNodes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 27-03-2017.
 */
public class TopologyViewerController implements Initializable, MapComponentInitializedListener, MapReadyListener {
    @FXML private GoogleMapView mapView;
    @FXML private SwingNode graphStreamNode;
    @FXML private ImageView backgroundView;
    public GridPane rootPane;

    private BooleanProperty showMap = new SimpleBooleanProperty(true);
    private BooleanProperty showGraph = new SimpleBooleanProperty(true);
    private BooleanProperty initialized = new SimpleBooleanProperty(false);
    private BooleanProperty mapInteractable = new SimpleBooleanProperty(true);
    private BooleanProperty showBackgroundImage = new SimpleBooleanProperty(false);
    private BooleanProperty graphDraggable = new SimpleBooleanProperty(false);

    private GoogleMap map;
    private Graph currentlyShownGraph;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
        mapView.addMapReadyListener(this);
        mapView.visibleProperty().bind(showMap);
        mapView.mouseTransparentProperty().bind(mapInteractable.not());
        backgroundView.visibleProperty().bind(showBackgroundImage);
        graphStreamNode.mouseTransparentProperty().bind(graphDraggable.not());
        graphStreamNode.visibleProperty().bind(showGraph);
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        LatLng location = GoogleMapsHelper.getDefaultLocation();
        options.center(new LatLong(location.lat, location.lng))
                .mapType(MapTypeIdEnum.TERRAIN)
                .overviewMapControl(false)
                .panControl(true)
                .rotateControl(false)
                .scaleControl(true)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(13);
        map = mapView.createMap(options);

        mapView.prefWidthProperty().bind(rootPane.widthProperty());
        mapView.prefHeightProperty().bind(rootPane.heightProperty());
        initialized.set(true);
    }

    public void showGraph(Graph g, boolean autoLayout, SimulationDataContainer nodeVarGridPane) {
        this.showGraph(g, autoLayout, nodeVarGridPane, null);
    }
    public void showGraph(Graph g, boolean autoLayout, SimulationDataContainer nodeVarGridPane, NodeMovedEventListener listener) {
        currentlyShownGraph = g;

        Viewer v = new Viewer(currentlyShownGraph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);

        if (autoLayout) v.enableAutoLayout();
        v.enableXYZfeedback(!autoLayout);

        MouseClickListener mouse = new MouseClickListener(v, currentlyShownGraph, nodeVarGridPane);
        if (listener != null) mouse.addNodesMovedListener(listener);
        mouse.start();

        ViewPanel swingView = v.addDefaultView(false);

        SwingUtilities.invokeLater(() -> {
            graphStreamNode.setContent(swingView);
        });

        if (isMapShown()) {
            Pair<Double, Double> widthAndHeight = GoogleMapsHelper.calculateSizeInMeters(getMapBounds());
            SwingUtilities.invokeLater(() -> {
                swingView.getCamera().setGraphViewport(0, 0, widthAndHeight.getFirst(), widthAndHeight.getSecond());
                swingView.getCamera().setViewCenter(widthAndHeight.getFirst() / 2, widthAndHeight.getSecond() / 2, 0);
            });
        }
    }


    public boolean isMapShown() {
        return showMap.get();
    }

    public BooleanProperty showMapProperty() {
        return showMap;
    }

    public void setShowMap(boolean showMap) {
        if(showMap && showBackgroundImage.get()) {//Mutex between map and background
            showBackgroundImage.set(false);
        }
        this.showMap.set(showMap);
    }

    public void setShowBackgroundImage(boolean showBackground) {
        if(showBackground && showMap.get()){ //Mutex between map and background
            showMap.set(false);
        }
        showBackgroundImage.set(showBackground);
    }

    public LatLngBounds getMapBounds() {
        return new LatLngBounds(map.getBounds());
    }

    public void setMapBounds(LatLngBounds bounds) {
        map.fitBounds(bounds.getAsLatLongBounds());
    }

    public BooleanProperty isInitializedProperty() {
        return initialized;
    }

    public BooleanProperty mapInteractableProperty() {
        return mapInteractable;
    }

    public void setIsMapInteractable(boolean interactable) {
        mapInteractable.set(interactable);
    }

    @Override
    public void mapReady() {
        initialized.set(true);
    }

    public void getMapSnapshot(File imageFile) throws IOException {
        WritableImage image = mapView.snapshot(new SnapshotParameters(), null);
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", imageFile);
    }

    /**
     *
     * @param image
     * @deprecated Resizing does not work as expected currently, and thus this should
     * not be used. Will be needed in future.
     */
    @Deprecated
    public void setBackgroundImage(Image image) {
        backgroundView.imageProperty().set(image);
        rootPane.resize(backgroundView.getBoundsInLocal().getWidth(), backgroundView.getBoundsInLocal().getHeight());
        setShowBackgroundImage(true);
    }

    public void setIsGraphDraggable(boolean isGraphDraggable) {
        graphDraggable.set(isGraphDraggable);
    }

    public BooleanProperty graphDraggableProperty() {
        return graphDraggable;
    }

    public BooleanProperty showGraphProperty() {
        return showGraph;
    }

    public Graph getCurrentlyShownGraph() {
        return currentlyShownGraph;
    }

    public void setSeedNodes(SeedNodes nodes) throws Exception {
        setMapBounds(nodes.getBounds());
        nodes.forEach(n -> map.addMarker(GoogleMapsHelper.createMarker(n.location, String.valueOf(n.nodeId))));
        //showGraph(nodes.asGraph(), false, null, null); //We will not detect when nodes are moved because listener is null
    }
}
