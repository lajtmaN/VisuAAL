package View.topology;

import Helpers.Pair;
import Model.UPPAALTopology;
import Model.topology.generator.TopologyGenerator;
import View.DoubleTextField;
import View.IntegerTextField;
import View.ToggleSwitch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 17-03-2017.
 */
public class TopologyGeneratorController implements Initializable {
    @FXML private ToggleSwitch chkShowMap;
    @FXML private TopologyViewerController topologyViewerController;
    @FXML private ToggleSwitch chkShowGridSettings;
    @FXML private GridPane gridPaneCells;
    @FXML private TitledPane optionsPane;
    @FXML private Accordion accordion;
    @FXML private IntegerTextField txtNumCellsX;
    @FXML private IntegerTextField txtNumCellsY;
    @FXML private IntegerTextField txtAvgRangeMean;
    @FXML private DoubleTextField txtAvgRangeDeviation;
    @FXML private DoubleTextField txtNumNodesPrCellDeviationDefault;
    @FXML private IntegerTextField txtAvgNumNodesPrCellDefault;
    @FXML private BorderPane rootPane;

    private TopologyGenerator topologyGenerator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accordion.setExpandedPane(optionsPane);
        topologyGenerator = new TopologyGenerator();
        bindGlobalOptionsProperties();

        setGridSize(topologyGenerator.getOptions().getCellX(), topologyGenerator.getOptions().getCellY());
        enableZoom();
        chkShowGridSettings.switchOnProperty().addListener((observable, oldValue, newValue) -> {
            showGridSettingsChanged(newValue);
        });

        topologyViewerController.rootPane.prefWidthProperty().bind(gridPaneCells.widthProperty());
        topologyViewerController.rootPane.prefHeightProperty().bind(gridPaneCells.heightProperty());
        chkShowMap.switchOnProperty().bindBidirectional(topologyViewerController.showMapProperty());
    }

    private void setGridSize(int rows, int columns) {
        gridPaneCells.getChildren().clear();

        disposeOldCellControllers();

        topologyGenerator.initializeNewCellOptions(rows, columns);

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                try {
                    FXMLLoader cellOptionsLoader = new FXMLLoader(getClass().getResource("CellOptions.fxml"));
                    Parent cellOptionsView = cellOptionsLoader.load();
                    CellOptionsController controller = cellOptionsLoader.getController();
                    controller.initWithOptions(topologyGenerator.getOptionsForCell(x,y));
                    controller.showCellOptions(chkShowGridSettings.switchOnProperty().get());

                    cellOptionsView.setUserData(controller);

                    //GridPanes has origo in NorthWest, whereas we (and graphstream) have in SouthWest
                    gridPaneCells.add(cellOptionsView, x, columns-y);
                } catch (IOException ignored) {

                }
            }
        }
        gridPaneCells.autosize();
    }

    private void disposeOldCellControllers() {
        for (Node n : gridPaneCells.getChildren()) {
            if (n.getUserData() != null && n.getUserData() instanceof CellOptionsController)
                try {
                    ((CellOptionsController)n.getUserData()).close();
                } catch (Exception ignored) { }
        }
        gridPaneCells.getChildren().clear();
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

    private void showGridSettingsChanged(Boolean newValue) {
        for (Node n : gridPaneCells.getChildren()) {
            if (n.getUserData() instanceof CellOptionsController) {
                ((CellOptionsController)n.getUserData()).showCellOptions(newValue);
            }
        }
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
        Pair<Double, Double> widthAndHeight = topologyViewerController.calculateGridSizeInMeters();
        topologyGenerator.setCellWidthInMeters(widthAndHeight.getFirst()/topologyGenerator.getOptions().getCellX());
        topologyGenerator.setCellHeightInMeters(widthAndHeight.getSecond()/topologyGenerator.getOptions().getCellY());
        return topologyGenerator.generateUppaalTopology();
    }

    public void preview(ActionEvent actionEvent) {
        topologyViewerController.showGraph(generateTopology().getGraph(true), false);
    }

}