package View.simulation;

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

import java.net.URL;
import java.util.ResourceBundle;

import Model.Simulation;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import View.simulation.*;

import javax.swing.*;

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

    private Simulation currentSimulation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindSizes();
        timeSlider.valueProperty().addListener(((observable, oldValue, newValue) -> {
            handleCurrentTimeChanged(newValue, oldValue);
        }));

    }

    public void loadWithSimulation(Simulation run) {
        currentSimulation = run;

        setupControlsBasedOnCurrentSimulation();
        initializeGraphStreamViewer();
        simulationMenuController.loadWithSimulation(currentSimulation);
        nodeVarGridPane.initialize(currentSimulation);
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
        Viewer v = new Viewer(currentSimulation.getGraph(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        v.enableAutoLayout();
        ViewPanel swingView = v.addDefaultView(false);
        SwingUtilities.invokeLater(() -> graphStreamNode.setContent(swingView));

        MouseClickListener mouse = new MouseClickListener(v, currentSimulation.getGraph(), nodeVarGridPane);
        mouse.start();
    }

    private void handleCurrentTimeChanged(Number newTime, Number oldTime) {
        lblCurrentTime.setText(String.format("%.1f ms", newTime.doubleValue()));
        currentSimulation.markGraphAtTime(oldTime, newTime, globalVarGridPane, nodeVarGridPane);
    }

    public void btnAnimateInRealtimeClicked(ActionEvent actionEvent) {
        Timeline timeline = new Timeline();
        timeline.setAutoReverse(false);
        timeSlider.setValue(0);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(maxTime()), new KeyValue(timeSlider.valueProperty(), maxTime())));
        timeline.play();
    }

    private int maxTime() {
        return (int)(currentSimulation.queryTimeBound() * currentSimulation.getModelTimeUnit());
    }
}
