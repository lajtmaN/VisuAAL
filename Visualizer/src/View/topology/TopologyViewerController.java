package View.topology;

import Helpers.GoogleMapsHelper;
import Helpers.Pair;
import View.simulation.MouseClickListener;
import com.google.maps.model.LatLng;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import javafx.embed.swing.SwingNode;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import org.graphstream.graph.Graph;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 27-03-2017.
 */
public class TopologyViewerController implements Initializable, MapComponentInitializedListener {
    public GoogleMapView mapView;
    public SwingNode graphStreamNode;
    public GridPane rootPane;

    private GoogleMap map;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapView.addMapInializedListener(this);
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
    }

    public void showGraph(Graph g, boolean autoLayout) {
        Pair<Double, Double> widthAndHeight = calculateGridSizeInMeters();

        Viewer v = new Viewer(g, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        if (autoLayout)
            v.enableAutoLayout();
        ViewPanel swingView = v.addDefaultView(false);
        SwingUtilities.invokeLater(() -> {
            //swingView.getCamera().setBounds(0,0,0, 8000, 8000, 0);
            swingView.getCamera().setGraphViewport(0,0, widthAndHeight.getFirst(), widthAndHeight.getSecond());
            swingView.getCamera().setViewCenter(widthAndHeight.getFirst()/2, widthAndHeight.getSecond()/2, 0);
            graphStreamNode.setContent(swingView);
        });
        //MouseClickListener mouse = new MouseClickListener(v, g, nodeVarGridPane);
        //mouse.start();
    }

    Pair<Double, Double> calculateGridSizeInMeters() {
        LatLongBounds bounds = map.getBounds();
        LatLong sw = bounds.getSouthWest();
        LatLong ne = bounds.getNorthEast();
        LatLong nw = new LatLong(ne.getLatitude(), sw.getLongitude());

        double widthOnAllCells = GoogleMapsHelper.distanceBetween(nw, ne);
        double heightOnAllCells = GoogleMapsHelper.distanceBetween(nw, sw);
        return new Pair<Double, Double>(widthOnAllCells, heightOnAllCells);
    }
}
