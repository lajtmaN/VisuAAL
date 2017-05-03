package View.topology;

import Helpers.ExtensionFilters;
import Helpers.FileHelper;
import Helpers.GUIHelper;
import Model.SimulationMoveNodePoint;
import Model.UPPAALTopology;
import Model.topology.LatLngBounds;
import Model.topology.generator.CellNode;
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
import org.graphstream.graph.Graph;
import parsers.GPSLog.GPSLogParser;
import parsers.GPSLog.GPSLogNodes;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 17-03-2017.
 */
public class TopologyGeneratorController implements Initializable, NodeMovedEventListener {
    @FXML private ToggleSwitch chkFreezeMap;
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
    private List<SimulationMoveNodePoint> simulationMoveNodePoints;
    private LatLngBounds latLngBounds;

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

        setupTopologyViewer();
    }

    private void setupTopologyViewer() {
        topologyViewerController.rootPane.prefWidthProperty().bind(gridPaneCells.widthProperty());
        topologyViewerController.rootPane.prefHeightProperty().bind(gridPaneCells.heightProperty());
        chkShowMap.switchOnProperty().bindBidirectional(topologyViewerController.showMapProperty());
        topologyViewerController.mapInteractableProperty().bind(chkFreezeMap.switchOnProperty().not());
        topologyViewerController.graphDraggableProperty().bind(chkFreezeMap.switchOnProperty());
        topologyViewerController.showGraphProperty().bind(chkShowGridSettings.switchOnProperty().not());
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
    }

    public void autoResize() {
        setCellSizes();
        gridPaneCells.autosize();
    }

    private void setCellSizes() {
        double mainWindowWidth = MainWindowController.getInstance().getTabWidth() - accordion.getWidth();
        double mainWindowHeight = MainWindowController.getInstance().getTabHeight();

        if(mainWindowHeight != 0 && mainWindowWidth != 0) {
            int rowsCount = topologyGenerator.getOptions().getCellY(),
                    columnCount = topologyGenerator.getOptions().getCellX();

            double heightRatio = mainWindowHeight / rowsCount,
                    widthRatio = mainWindowWidth / columnCount,
                    heightAndWidth;

            if(heightRatio < widthRatio)
                heightAndWidth = (mainWindowHeight-20) / rowsCount;
            else
                heightAndWidth = (mainWindowWidth-20) / columnCount;

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
        MainWindowController.getInstance().enableDisableUseTopologyFromTopologyGenerator(true);
        simulationMoveNodePoints = null;
        lastGeneratedTopology = topologyGenerator.generateUppaalTopology(topologyViewerController.getMapBounds());
    }
    public UPPAALTopology generateTopology(boolean generateNew) {
        if (lastGeneratedTopology == null || generateNew)
            generateRandomTopology();
        return lastGeneratedTopology;
    }

    public void preview(ActionEvent actionEvent) {
        autoResize();
        Graph graph = generateTopology(true).getGraph(true);
        showGraph(graph, true);
        chkFreezeMap.switchOnProperty().set(true);
        chkShowGridSettings.switchOnProperty().set(false);
    }

    private void showGraph(Graph g, boolean canDragNodes) {
        topologyViewerController.showGraph(g, false, null, canDragNodes ? this : null);
    }

    @Override
    public void onNodeMoved(NodeMovedEvent evt) {
        int nodeId = Integer.parseInt(evt.getNodeIdentifier());
        List<CellNode> cellNodes = lastGeneratedTopology.getNodesWithSpecificLocation();
        CellNode updatedNode = cellNodes.get(nodeId);
        updatedNode.setX(evt.getNewX());
        updatedNode.setY(evt.getNewY());
        cellNodes.set(nodeId, updatedNode);

        //TODO generateUppaalTopology might be overkill to use here. It calculate ALL edges for ALL nodes.
        //Now we know the x,y we could figure out what grid it could affect (of course using the range as well)
        //and then only update the edges in the affected cells?
        lastGeneratedTopology = topologyGenerator.generateUppaalTopology(cellNodes);
        showGraph(lastGeneratedTopology.getGraph(true), true);
    }

    public void loadGPSLog(ActionEvent actionEvent) {
        File gpsLogFile = FileHelper.chooseFileToLoad("Select the GPS Log file", null, ExtensionFilters.GPSLogExtensionFilter);
        if (gpsLogFile == null)
            return;
        try {
            autoResize();

            GPSLogNodes nodes = GPSLogParser.parse(gpsLogFile);
            topologyViewerController.setMapBounds(nodes.getBounds());
            this.latLngBounds = nodes.getBounds();
            UPPAALTopology loadedTopology = nodes.generateUPPAALTopologyWithBounds(topologyViewerController.getMapBounds());

            simulationMoveNodePoints = nodes.generateSimulationMoveNodePoints();

            loadedTopology.updateGraph();
            showGraph(loadedTopology.getGraph(), false); //We will not detect when nodes are moved because listener is null
            chkFreezeMap.switchOnProperty().set(true);
            chkShowGridSettings.switchOnProperty().set(false);
            lastGeneratedTopology = loadedTopology;

            MainWindowController.getInstance().getUppaalModel().replaceTopologyChanges(nodes.getTopologyChanges());
            MainWindowController.getInstance().enableDisableUseTopologyFromTopologyGenerator(true);
        }
        catch (Exception e) {
            GUIHelper.showError("Could not load the GPS Log file." + System.lineSeparator() + e.getMessage());
        }
    }

    public List<SimulationMoveNodePoint> getSimulationMoveNodePoints() {
        return simulationMoveNodePoints;
    }

    public LatLngBounds getLatLngBounds() {
        return latLngBounds;
    }
}