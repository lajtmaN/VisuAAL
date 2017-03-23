package View.topology;

import Helpers.GoogleMapsHelper;
import Model.UPPAALTopology;
import Model.topology.generator.CellOptions;
import Model.topology.generator.TopologyGenerator;
import View.DoubleTextField;
import View.IntegerTextField;
import View.simulation.SimulationResultController;
import com.google.maps.model.LatLng;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

/**
 * Created by lajtman on 17-03-2017.
 */
public class TopologyGeneratorController implements Initializable, MapComponentInitializedListener {
    @FXML private GoogleMapView mapView;
    @FXML private GridPane gridPaneCells;
    @FXML private TitledPane optionsPane;
    @FXML private Accordion accordion;
    @FXML private IntegerTextField txtNumCellsX;
    @FXML private IntegerTextField txtNumCellsY;
    @FXML private DoubleTextField txtAvgRangeMean;
    @FXML private DoubleTextField txtAvgRangeDeviation;
    @FXML private DoubleTextField txtNumNodesPrCellDeviationDefault;
    @FXML private IntegerTextField txtAvgNumNodesPrCellDefault;
    @FXML private BorderPane rootPane;

    private GoogleMap map;
    private TopologyGenerator topologyGenerator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accordion.setExpandedPane(optionsPane);
        topologyGenerator = new TopologyGenerator();
        bindGlobalOptionsProperties();

        setGridSize(topologyGenerator.getOptions().getCellX(), topologyGenerator.getOptions().getCellY());
        enableZoom();
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
               .zoomControl(true)
               .zoom(12);
        map = mapView.createMap(options);

        mapView.prefWidthProperty().bind(gridPaneCells.widthProperty());
        mapView.prefHeightProperty().bind(gridPaneCells.heightProperty());
    }

    private void setGridSize(int rows, int columns) {
        gridPaneCells.getChildren().clear();

        topologyGenerator.initializeNewCellOptions(rows, columns);

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                try {
                    FXMLLoader cellOptionsLoader = new FXMLLoader(getClass().getResource("CellOptions.fxml"));
                    Parent cellOptionsView = cellOptionsLoader.load();
                    CellOptionsController controller = cellOptionsLoader.getController();
                    controller.initWithOptions(topologyGenerator.getOptionsForCell(x,y));

                    gridPaneCells.add(cellOptionsView, x, y);
                } catch (IOException ignored) {

                }
            }
        }
    }

    private void enableZoom() {
        rootPane.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override public void handle(ScrollEvent event) {
                event.consume();

                if (event.getDeltaY() == 0) {
                    return;
                }

                double scaleFactor =
                        (event.getDeltaY() > 0)
                                ? 1.1
                                : 1/1.1;

                gridPaneCells.setScaleX(gridPaneCells.getScaleX() * scaleFactor);
                gridPaneCells.setScaleY(gridPaneCells.getScaleY() * scaleFactor);
            }
        });
    }

    private void bindGlobalOptionsProperties() {
        txtNumCellsX.bindProperty(topologyGenerator.getOptions().cellXProperty());
        txtNumCellsY.bindProperty(topologyGenerator.getOptions().cellYProperty());
        txtAvgRangeMean.bindProperty(topologyGenerator.getOptions().avgRangeProperty());
        txtAvgNumNodesPrCellDefault.bindProperty(topologyGenerator.getOptions().avgNodesPrCellProperty());
        txtAvgRangeDeviation.bindProperty(topologyGenerator.getOptions().rangeDeviationProperty());
        txtNumNodesPrCellDeviationDefault.bindProperty(topologyGenerator.getOptions().nodesCellDeviationProperty());
    }

    public void updateGlobalOptions(ActionEvent actionEvent) {
        setGridSize(topologyGenerator.getOptions().getCellX(), topologyGenerator.getOptions().getCellY());
    }

    public UPPAALTopology generateTopology() {
        return topologyGenerator.generateUppaalTopology();
    }

    public void preview(ActionEvent actionEvent) {
        generateTopology().getGraph(true).display();
    }

}