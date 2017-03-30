package View.topology;

import Helpers.GoogleMapsHelper;
import Helpers.Pair;
import Model.topology.LatLngBounds;
import View.simulation.MouseClickListener;
import View.simulation.SimulationDataContainer;
import com.google.maps.model.LatLng;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.embed.swing.SwingNode;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 27-03-2017.
 */
public class TopologyViewerController implements Initializable, MapComponentInitializedListener {
    public GoogleMapView mapView;
    public SwingNode graphStreamNode;
    public GridPane rootPane;

    private BooleanProperty showMap = new SimpleBooleanProperty(true);
    private BooleanProperty initialized = new SimpleBooleanProperty(false);
    private GoogleMap map;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
        mapView.visibleProperty().bind(showMap);
    }

    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        LatLng googleLocation = GoogleMapsHelper.getCurrentLocation();
        options.center(new LatLong(googleLocation.lat, googleLocation.lng))
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
        Viewer v = new Viewer(g, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        if (autoLayout)
            v.enableAutoLayout();
        ViewPanel swingView = v.addDefaultView(false);
        SwingUtilities.invokeLater(() -> {
            graphStreamNode.setContent(swingView);
        });

        if (isMapShown()) {
            Pair<Double, Double> widthAndHeight = GoogleMapsHelper.calculateGridSizeInMeters(getMapBounds());
            SwingUtilities.invokeLater(() -> {
                swingView.getCamera().setGraphViewport(0, 0, widthAndHeight.getFirst(), widthAndHeight.getSecond());
                swingView.getCamera().setViewCenter(widthAndHeight.getFirst() / 2, widthAndHeight.getSecond() / 2, 0);
            });
        }

        if (nodeVarGridPane != null) {
            MouseClickListener mouse = new MouseClickListener(v, g, nodeVarGridPane);
            mouse.start();
        }
    }

    public boolean isMapShown() {
        return showMap.get();
    }

    public BooleanProperty showMapProperty() {
        return showMap;
    }

    public void setShowMap(boolean showMap) {
        this.showMap.set(showMap);
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
}
