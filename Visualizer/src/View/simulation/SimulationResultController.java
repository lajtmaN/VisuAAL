package View.simulation;

import Model.Simulations;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Tim on 09-03-2017.
 */
public class SimulationResultController implements Initializable {
    @FXML private HBox sliderBox;
    @FXML private BorderPane rootPane;
    @FXML private GridPane globalVarGridPane;
    @FXML private SimulationDataContainer nodeVarGridPane;
    @FXML private Slider timeSlider;
    @FXML private Label lblCurrentTime;
    @FXML private SwingNode graphStreamNode;
    @FXML private SimulationMenuController simulationMenuController;

    private Simulations currentSimulations;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindSizes();
        timeSlider.valueProperty().addListener(((observable, oldValue, newValue) -> {
            handleCurrentTimeChanged(newValue, oldValue);
        }));
    }

    public void loadWithSimulation(Simulations run) {
        currentSimulations = run;

        setupControlsBasedOnCurrentSimulation();
        initializeGraphStreamViewer();
        simulationMenuController.loadWithSimulation(currentSimulations);
        nodeVarGridPane.initialize(currentSimulations);
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
        Viewer v = new Viewer(currentSimulations.getGraph(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        if (!currentSimulations.getTopology().nodesHasSpecificLocations())
            v.enableAutoLayout();
        ViewPanel swingView = v.addDefaultView(false);
        SwingUtilities.invokeLater(() -> graphStreamNode.setContent(swingView));

        MouseClickListener mouse = new MouseClickListener(v, currentSimulations.getGraph(), nodeVarGridPane);
        mouse.start();
    }

    private void handleCurrentTimeChanged(Number newTime, Number oldTime) {
        lblCurrentTime.setText(String.format("%.1f ms", newTime.doubleValue()));
        currentSimulations.markGraphAtTime(0, oldTime, newTime, globalVarGridPane, nodeVarGridPane);
    }

    public void btnAnimateInRealtimeClicked(ActionEvent actionEvent) {
        Timeline timeline = new Timeline();
        timeline.setAutoReverse(false);
        timeSlider.setValue(0);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(maxTime()), new KeyValue(timeSlider.valueProperty(), maxTime())));
        timeline.play();
    }

    private int maxTime() {
        return (int)(currentSimulations.queryTimeBound() * currentSimulations.getModelTimeUnit());
    }
}
