package View.simulation;

import Model.SimulationEdgePoint;
import Model.SimulationNodePoint;
import Model.SimulationPoint;
import Model.Simulations;
import View.DoubleTextField;
import View.MainWindowController;
import View.topology.TopologyViewerController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
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
        timeline.setOnFinished(e -> play.setText("Play"));

        timeSlider.valueProperty().addListener(((observable, oldValue, newValue) -> {
            handleCurrentTimeChanged(newValue, oldValue);
            if (timeline.getStatus() != Animation.Status.RUNNING)
                timeline.jumpTo(Duration.millis((double)newValue));
        }));
    }

    public void loadWithSimulation(Simulations run) {
        currentSimulations = run;

        setupControlsBasedOnCurrentSimulation();
        simulationMenuController.loadWithSimulation(currentSimulations);
        nodeVarGridPane.initialize(currentSimulations);

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
    }

    private void resizeTopologyViewer() {
        double height = MainWindowController.getInstance().getTabHeight() - timeSlider.getHeight() - play.getHeight();
        double width = MainWindowController.getInstance().getTabWidth() - simulationMenuController.root.getWidth();
        topologyViewerController.rootPane.setMaxSize(width, height);
        topologyViewerController.rootPane.setMinSize(width, height);
    }

    private void handleCurrentTimeChanged(Number newTime, Number oldTime) {
        lblCurrentTime.setText(String.format("%.1f ms", newTime.doubleValue()));
        currentSimulations.markGraphAtTime(oldTime, newTime);
    }

    public void btnAnimateInRealTimeClicked(ActionEvent actionEvent) {
        if(timeline.getKeyFrames().isEmpty()){
            timeline.getKeyFrames().add(new KeyFrame((Duration.millis(maxTime() - timeSlider.getValue())), new KeyValue(timeSlider.valueProperty(), maxTime())));
        }

        if(!rate.getText().isEmpty())
            timeline.setRate(Double.parseDouble(rate.getText()));

        if(play.getText().equals("Play")) {
            if((maxTime() - timeSlider.getValue()) <= 0.1)
            {
                timeSlider.setValue(0.0);
                timeline.play();
                play.setText("Pause");
            }
            else {
                timeline.play();
                play.setText("Pause");
            }
        }
        else {
            timeline.pause();
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
        if(!(sp instanceof SimulationNodePoint) && !(sp instanceof SimulationEdgePoint)) {
            updateGridVars(sp.getIdentifier(), String.valueOf(value));
        }
        if(sp instanceof SimulationNodePoint) {
            nodeVarGridPane.updateVariable(((SimulationNodePoint) sp).getNodeId(), sp.getScopedIdentifier(), value);
        }
    }
}
