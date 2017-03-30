package View.topology;

import Model.UPPAALTopology;
import Model.topology.generator.TopologyGenerator;
import View.DoubleTextField;
import View.IntegerTextField;
import View.MainWindowController;
import View.ToggleSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import sun.applet.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    @FXML private BorderPane borderPane;

    private TopologyGenerator topologyGenerator;
    private ArrayList<CellOptionsController> cellOptionsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cellOptionsList = new ArrayList<>();
        accordion.setExpandedPane(optionsPane);
        topologyGenerator = new TopologyGenerator();
        bindGlobalOptionsProperties();

        setGridSize(topologyGenerator.getOptions().getCellX(), topologyGenerator.getOptions().getCellY());

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
                    cellOptionsList.add(controller);

                    //GridPanes has origo in NorthWest, whereas we (and graphstream) have in SouthWest
                    gridPaneCells.add(cellOptionsView, x, columns-y);
                } catch (IOException ignored) {

                }
            }
        }
        setCellSizes();
        gridPaneCells.autosize();
    }

    private void setCellSizes() {
        double borderPaneCenterWidth = borderPane.getWidth() - accordion.getWidth(),
               borderPaneCenterHeight = borderPane.getHeight();

        if(borderPaneCenterHeight != 0 && borderPaneCenterWidth != 0) {
            int rowsCount = topologyGenerator.getOptions().getCellY(),
                    columnCount = topologyGenerator.getOptions().getCellX();

            double heightRatio = borderPaneCenterHeight / rowsCount,
                    widthRatio = borderPaneCenterWidth / columnCount,
                    heightAndWidth;

            if(heightRatio < widthRatio)
                heightAndWidth = (borderPaneCenterHeight-20) / rowsCount;
            else
                heightAndWidth = (borderPaneCenterWidth-20) / columnCount;

            for(CellOptionsController c : cellOptionsList)
                 c.setSize(heightAndWidth);
        }
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

    private UPPAALTopology lastGeneratedTopology;
    private void generateRandomTopology() {
        /*File backgroundImageFile = new File("simulations/background.png");
         *topologyViewerController.getMapSnapshot(backgroundImageFile); */
        lastGeneratedTopology = topologyGenerator.generateUppaalTopology(topologyViewerController.getMapBounds());
    }
    public UPPAALTopology generateTopology(boolean generateNew) {
        if (lastGeneratedTopology == null || generateNew)
            generateRandomTopology();
        return lastGeneratedTopology;
    }

    public void preview(ActionEvent actionEvent) {
        topologyViewerController.showGraph(generateTopology(true).getGraph(true), false, null);
    }
}