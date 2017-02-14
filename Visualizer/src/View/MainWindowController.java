package View;

import Helpers.GUIHelper;
import Model.*;
import Helpers.QueryGenerator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML private ProgressIndicator simulationProgress;
    @FXML private TextArea txtUppaalOutput;
    @FXML private TextField txtSimulationName;
    @FXML private TextArea queryGeneratedTextField;
    @FXML private TableColumn<CVar<String>, String> columnName;
    @FXML private TableColumn<CVar<Integer>, String> columnValue;
    @FXML private TableView constantsTable;
    @FXML private TextField modelPathField;
    @FXML private GridPane horizontalGrid;
    @FXML private TabPane tabPane;
    @FXML private GridPane rootElement;
    @FXML private TableView<OutputVariable> tableOutputVars;
    @FXML private TableColumn<OutputVariable, String> outputVarName;
    @FXML private TableColumn<OutputVariable, Boolean> outputVarEdge;
    @FXML private TableColumn<OutputVariable, Boolean> outputVarNode;
    @FXML private TableColumn<OutputVariable, Boolean> outputVarUse;
    @FXML private TextField txtQueryTimeBound;
    @FXML private TextField txtQuerySimulations;
    @FXML private TableView<TemplateUpdate> dynamicTable;
    @FXML private TableColumn<TemplateUpdate, String> dynColumnName;
    @FXML private TableColumn<TemplateUpdate, Integer> dynColumnValue;
    @FXML private TableColumn<TemplateUpdate, Integer> dynColumnTime;


    private UPPAALModel uppaalModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.setVisible(false);
        simulationProgress.setVisible(false);
        initializeConstantTableValues();
        initializeOutputVarsTable();
        initializeWidths();
        initializeDynamicTable();
    }

    private void initializeDynamicTable() {
        dynColumnName.setCellValueFactory(p -> p.getValue().variableProperty());
        dynColumnName.setCellFactory(TextFieldTableCell.forTableColumn());
        dynColumnName.setOnEditCommit(
                (TableColumn.CellEditEvent<TemplateUpdate, String> t)
                -> (t.getTableView().getItems().get(t.getTablePosition().getRow())).setVariable(t.getNewValue()));

        dynColumnValue.setCellValueFactory(p -> p.getValue().theValueProperty().asObject());
        dynColumnValue.setCellFactory(p -> new IntegerEditingCell());

        dynColumnTime.setCellValueFactory(p -> p.getValue().timeProperty().asObject());
        dynColumnTime.setCellFactory(p -> new IntegerEditingCell());
    }

    private void initializeWidths() {
        columnName.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.2));
        columnValue.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.8));
        modelPathField.prefWidthProperty().bind(horizontalGrid.widthProperty().multiply(0.8));
        outputVarName.prefWidthProperty().bind(tableOutputVars.widthProperty().multiply(0.5));
        tabPane.prefWidthProperty().bind(rootElement.widthProperty());
        tableOutputVars.prefWidthProperty().bind(rootElement.widthProperty());
    }

    private void initializeConstantTableValues() {
        columnName.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));
        columnValue.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getValue().toString()));
    }

    private void initializeOutputVarsTable() {
        //TODO: Only 2d arrays should be able to mark edge and 1d to mark node
        outputVarName.setCellValueFactory(p -> p.getValue().name());
        outputVarEdge.setCellValueFactory(p -> p.getValue().isEdgeData());
        outputVarEdge.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarNode.setCellValueFactory(p -> p.getValue().isNodeData());
        outputVarNode.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarUse.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarUse.setCellValueFactory(p -> p.getValue().isSelected());

        tableOutputVars.setSelectionModel(null);
    }

    public void addConstantsToList(ArrayList<CVar<Integer>> constants){
        constantsTable.getItems().addAll(constants);
    }

    public void loadModel(ActionEvent actionEvent) {
        constantsTable.getItems().clear();

        String modelPathContents = modelPathField.getText();
        if(modelPathContents.length() == 0)
            modelPathContents = "mac_model_exp";

        if (!modelPathContents.endsWith(".xml")) modelPathContents += ".xml";

        File f = new File(modelPathContents);
        if (f.exists() && !f.isDirectory()) {
            uppaalModel = new UPPAALModel(modelPathContents);
            uppaalModel.load();
            addConstantsToList(uppaalModel.getConstantVars());
            tableOutputVars.setItems(uppaalModel.getOutputVars());
            tabPane.setVisible(true);
            dynamicTable.setItems(uppaalModel.getTemplateUpdates());
        }
    }

    public void generateQuery(ActionEvent actionEvent) {
        FilteredList<OutputVariable> vars = tableOutputVars.getItems().filtered(
                outputVariable -> outputVariable.isSelected().getValue());
        if(vars == null || vars.size() == 0) {
            GUIHelper.showAlert(Alert.AlertType.INFORMATION, "No output variables selected");
        } else {
            try{
                int time = Integer.parseInt(txtQueryTimeBound.getText());
                int nrSimulations = Integer.parseInt(txtQuerySimulations.getText());

                if(time > 0  && nrSimulations > 0) {
                    queryGeneratedTextField.setText(QueryGenerator.generateSimulationQuery(time, nrSimulations, vars));
                }
            } catch (Exception e) {
                GUIHelper.showAlert(Alert.AlertType.INFORMATION, "Timebound and number of simulations must be positive integers");
            }
        }
    }

    public void runSimulationQuery(ActionEvent actionEvent) throws InterruptedException, IOException {
        if(queryGeneratedTextField.getText().length() == 0) {
            GUIHelper.showAlert(Alert.AlertType.ERROR, "Please generate Query first");
            return;
        }

        String query = queryGeneratedTextField.getText();
        txtUppaalOutput.setText("Running following query in UPPAAL: \n" + query );

        simulationProgress.setVisible(true);
        Simulation out = uppaalModel.runSimulation(query); //Run in uppaal - takes long time
        simulationProgress.setVisible(false);

        String simulationName = txtSimulationName.getText();
        if (simulationName.length() == 0) simulationName = "Result";

        addNewResults(simulationName, out);
    }

    private Tab addNewResults(String tabName, Simulation run) throws InterruptedException, IOException {
        BorderPane pane = new BorderPane();

        //Slider
        int maxTime = run.queryTimeBound();
        Slider timeSlider = new Slider(0, maxTime, 0);
        timeSlider.setBlockIncrement(maxTime/500);
        timeSlider.setMajorTickUnit(maxTime/5);
        timeSlider.setShowTickMarks(true);
        timeSlider.setSnapToTicks(true);
        timeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            //TODO oldValue could be used to only add/remove the edges not already up-to-date
            run.markEdgeAtTime(newValue);
        });
        pane.setTop(timeSlider);

        //Topology
        final SwingNode swingNode = new SwingNode();
        pane.setCenter(swingNode);
        Viewer v = new Viewer(run.getGraph(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        v.enableAutoLayout();
        ViewPanel swingView = v.addDefaultView(false);
        SwingUtilities.invokeLater(() -> swingNode.setContent(swingView));

        //Animate button
        Button animateBtn = new Button("Animate in real-time");
        animateBtn.setOnAction(p -> {
            Timeline timeline = new Timeline();
            timeline.setAutoReverse(false);
            timeSlider.setValue(0);
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(maxTime), new KeyValue(timeSlider.valueProperty(), maxTime)));
            timeline.play();
        });
        pane.setBottom(animateBtn);
        pane.setAlignment(animateBtn, Pos.BOTTOM_CENTER);

        //Tab
        Tab tab = new Tab();
        tab.setText(tabName);
        tab.setContent(pane);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
        return tab;
    }

    public void addUpdates(ActionEvent actionEvent) {
        //Add to template ..
        uppaalModel.updateUpdates(dynamicTable.getItems());
    }
}
