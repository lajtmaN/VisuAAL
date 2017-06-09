package View.simulation;

import Helpers.GoogleMapsHelper;
import Model.SimulationNodePoint;
import Model.SimulationPoint;
import Model.Simulations;
import Model.UPPAALTopology;
import View.DoubleTextField;
import View.MainWindowController;
import View.topology.TopologyViewerController;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Tim on 09-03-2017.
 */
public class SimulationResultController implements Initializable, VariableUpdateObserver {
    @FXML private HBox sliderBox;
    @FXML private DoubleTextField rate;
    @FXML private BorderPane rootPane;
    @FXML private GridPane globalVarGridPane;
    @FXML private Button play;
    @FXML private SimulationDataContainer nodeVarGridPane;
    @FXML private Slider timeSlider;
    @FXML private Label lblCurrentTime;
    @FXML private SimulationMenuController simulationMenuController;
    @FXML private TopologyViewerController topologyViewerController;

    private Simulations currentSimulations;
    private Timeline timeline;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindSizes();
        timeline = new Timeline();
        timeline.setAutoReverse(false);
        timeSlider.setValue(0);
        timeline.setOnFinished(e -> finishedTimeLine());

        timeSlider.valueProperty().addListener(((observable, oldValue, newValue) -> {
            handleCurrentTimeChanged(newValue, oldValue);
        }));
    }

    private void finishedTimeLine() {
        play.setText("Play");
        timeline.stop();
        timeline.getKeyFrames().clear();
    }

    public void loadWithSimulation(Simulations run) {
        currentSimulations = run;

        setupControlsBasedOnCurrentSimulation();
        simulationMenuController.loadWithSimulation(currentSimulations);
        nodeVarGridPane.initialize(currentSimulations);

        if(topologyViewerController.isInitializedProperty().getValue()) {
            initializeGraphStreamViewer();
        }
        topologyViewerController.isInitializedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue)
                initializeGraphStreamViewer();
        });

        currentSimulations.addListener(this);
    }

    private void bindSizes() {
        timeSlider.prefWidthProperty().bind(rootPane.widthProperty().multiply(0.8));
        lblCurrentTime.prefWidthProperty().bind(rootPane.widthProperty().multiply(0.1));
        sliderBox.prefWidthProperty().bind(rootPane.widthProperty());
    }

    private void setupControlsBasedOnCurrentSimulation() {
        timeSlider.setMax(maxTime());
        timeSlider.setMajorTickUnit(maxTime() > 10000 ? maxTime()/4 : 10000);
    }

    private void initializeGraphStreamViewer() {
        topologyViewerController.setIsMapInteractable(false);
        topologyViewerController.setIsGraphDraggable(true);
        topologyViewerController.setShowMap(false);
        resizeTopologyViewer();

        //TODO: Add background if needed

        boolean autolayout = !currentSimulations.getTopology().nodesHasSpecificLocations();
        topologyViewerController.showGraph(currentSimulations.getGraph(), autolayout, nodeVarGridPane);
        if(currentSimulations.getLatLngBounds() != null)
            topologyViewerController.setGraphViewport(GoogleMapsHelper.calculateSizeInMeters(currentSimulations.getLatLngBounds()));


        boolean anyActiveTopology = MainWindowController.getInstance().topologyGeneratorController.anyActiveTopoolgy();
        if (anyActiveTopology) { //assumes that we used the topology directly from topology generator. will not work with save
            UPPAALTopology currentTopology = MainWindowController.getInstance().topologyGeneratorController.generateTopology(false);
            if (currentTopology.getNumberOfNodes() == currentSimulations.getTopology().getNumberOfNodes()) {
                Image currentBackgroundInTopologyGenerator =
                        MainWindowController.getInstance().topologyGeneratorController.getScreenshotOfCurrentlyShownMap();
                topologyViewerController.setBackgroundImage(currentBackgroundInTopologyGenerator);
            }
        }
    }

    private void resizeTopologyViewer() {
        double height = MainWindowController.getInstance().getTabHeight() - timeSlider.getPrefHeight() - play.getPrefHeight();
        double width = MainWindowController.getInstance().getTabWidth() - simulationMenuController.root.getPrefWidth();
        topologyViewerController.rootPane.setMaxSize(width, height);
        topologyViewerController.rootPane.setMinSize(width, height);
    }

    private void handleCurrentTimeChanged(Number newTime, Number oldTime) {
        lblCurrentTime.setText(String.format("%.1f ms", newTime.doubleValue()));
        currentSimulations.markGraphAtTime(oldTime, newTime);
    }

    public void btnAnimateInRealTimeClicked(ActionEvent actionEvent) {
        if(!rate.getText().isEmpty())
            timeline.setRate(Double.parseDouble(rate.getText()));
        else{
            timeline.setRate(1.0);
        }

        if(play.getText().equals("Play")) {
            play.setText("Pause");
            KeyValue kv = new KeyValue(timeSlider.valueProperty(), maxTime());
            if(timeSlider.getValue() > maxTime() - 0.01) {
                timeSlider.setValue(0.0);
                timeline.getKeyFrames().add(new KeyFrame((Duration.millis(maxTime())),
                        kv));
            }
            else {
                timeline.getKeyFrames().add(new KeyFrame((Duration.millis(maxTime() - timeSlider.getValue())),
                        kv));
            }
            timeline.play();
        }
        else {
            timeline.pause();
            Double value = timeSlider.getValue();
            timeline.stop();
            timeline.getKeyFrames().clear();
            timeSlider.setValue(value);
            play.setText("Play");
        }
    }

    public void btnStop(ActionEvent actionEvent) {
        timeline.stop();
        timeSlider.setValue(0.0);
        if(play.getText().equals("Pause"))
            play.setText("Play");
    }

    private int maxTime() {
        return (int)(currentSimulations.queryTimeBound() * currentSimulations.getModelTimeUnit());
    }

    private void addGlobalVariableToGridPane(String name, String value) {
        int nrRows = globalVarGridPane.getChildren().size() / 2;
        Label labelName = new Label(name);
        Label labelValue = new Label(value);
        labelName.setPadding(new Insets(0,10, 0, 0));

        globalVarGridPane.add(labelName, 0, nrRows);
        globalVarGridPane.add(labelValue, 1, nrRows);
    }

    public void updateGridVars(String name, String value) {
        boolean foundLabel = false;
        for(Node n : globalVarGridPane.getChildren()){
            Label label = (Label) n;
            if(foundLabel) {
                label.setText(value);
                break;
            }
            if(label.getText().equals(name)) {
                foundLabel = true;
            }
        }
        if(!foundLabel) {
            addGlobalVariableToGridPane(name, value);
        }
    }

    @Override
    public void update(SimulationPoint sp, double value) {
        if(sp.getType() == SimulationPoint.SimulationPointType.Variable) {
            updateGridVars(sp.getIdentifier(), String.valueOf(value));
        }
        if(sp instanceof SimulationNodePoint) {
            nodeVarGridPane.updateVariable(((SimulationNodePoint) sp).getNodeId(), sp.getScopedIdentifier(), value);
        }
    }
}
