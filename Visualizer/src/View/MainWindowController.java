package View;

import Helpers.FileHelper;
import Helpers.GUIHelper;
import Model.*;
import Helpers.QueryGenerator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import parsers.UPPAALParser;
import sun.applet.Main;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


    @FXML private ProgressIndicator simulationProgress;
    @FXML private TextArea txtUppaalOutput;
    @FXML private TextField txtSimulationName;
    @FXML private TextArea queryGeneratedTextField;
    @FXML private TableColumn<CVar<Integer>, String> columnName;
    @FXML private TableColumn<CVar<Integer>, Integer> columnValue;
    @FXML private TableColumn<CVar<Integer>, String> columnScope;
    @FXML private TableView constantsTable;
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
    @FXML private Tab configurationTab;


    private UPPAALModel uppaalModel;
    private boolean constantsChanged;
    private static MainWindowController instance;

    public static MainWindowController getInstance(){
        return instance;
    }

    public Window getWindow() {
        return rootElement.getScene().getWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.setVisible(false);
        simulationProgress.setVisible(false);
        initializeConstantTableValues();
        initializeOutputVarsTable();
        initializeWidths();
        initializeDynamicTable();
        instance = this;
    }

    private void initializeDynamicTable() {
        dynColumnName.setCellValueFactory(p -> p.getValue().variableProperty());
        dynColumnName.setCellFactory(p -> new StringEditingCell());

        dynColumnValue.setCellValueFactory(p -> p.getValue().theValueProperty().asObject());
        dynColumnValue.setCellFactory(p -> new IntegerEditingCell());

        dynColumnTime.setCellValueFactory(p -> p.getValue().timeProperty().asObject());
        dynColumnTime.setCellFactory(p -> new IntegerEditingCell());

        dynamicTable.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if(event.getButton() == MouseButton.PRIMARY) {
                            TemplateUpdate last = uppaalModel.getTemplateUpdates().get(uppaalModel.getTemplateUpdates().size()-1);
                            if(last.getVariable() != "")
                                uppaalModel.addEmptyTemplateUpdate();
                        }
                    }
                }
        );

        dynamicTable.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DELETE && uppaalModel.getTemplateUpdates().size() > 1){
                    TemplateUpdate focusedItem = dynamicTable.getFocusModel().getFocusedItem();
                    uppaalModel.getTemplateUpdates().remove(focusedItem);
                }
                if (event.getCode() == KeyCode.TAB){

                }
            }
        });
    }

    private void initializeWidths() {
        columnScope.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.2));
        columnName.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.2));
        columnValue.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.6));
        outputVarName.prefWidthProperty().bind(tableOutputVars.widthProperty().multiply(0.5));
        tabPane.prefWidthProperty().bind(rootElement.widthProperty());
        tableOutputVars.prefWidthProperty().bind(rootElement.widthProperty());
    }

    private void initializeConstantTableValues() {
        columnScope.setCellValueFactory(cell -> ((Callback<CVar<Integer>, StringProperty>) cellValue -> {
            if (cellValue.getScope() == null)
                return new SimpleStringProperty("Global");
            return cellValue.scopeProperty();
        }).call(cell.getValue()));
        columnName.setCellValueFactory(p -> p.getValue().nameProperty()); //Readonly, thus no CellFactory
        columnValue.setCellValueFactory(p -> p.getValue().valueProperty());
        columnValue.setCellFactory(p -> new IntegerEditingCell());
        columnValue.addEventHandler(TableColumn.CellEditEvent.ANY, p -> constantsChanged = true);
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

    public void loadModel(ActionEvent actionEvent) throws IOException, InterruptedException {
        constantsTable.getItems().clear();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select UPPAAL model or simulation");
        fileChooser.setInitialDirectory(Paths.get(".").toAbsolutePath().normalize().toFile());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("UPPAAL Model", "*.xml"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Simulation", "*.sim"));
        File selectedFile = fileChooser.showOpenDialog(rootElement.getScene().getWindow());
        if (selectedFile == null)
            return;

        if (selectedFile.exists() && selectedFile.isFile()) {
            switch (FileHelper.getExtension(selectedFile.getName())) {
                case ".xml":
                    loadNewModel(selectedFile);
                    break;
                case ".sim":
                    loadSavedSimulation(selectedFile);
                    break;
                default:
                    throw new IllegalArgumentException(selectedFile.getName() + " could not be used");
            }

            tabPane.setVisible(true);
        }
    }

    private void loadSavedSimulation(File selectedFile) throws IOException, InterruptedException {
        Simulation loaded = Simulation.load(selectedFile);
        addNewResults(selectedFile.getName(), loaded);
    }

    private void loadNewModel(File selectedFile) {
        uppaalModel = new UPPAALModel(selectedFile.getPath());
        uppaalModel.load();
        addConstantsToList(uppaalModel.getConfigVars());
        tableOutputVars.setItems(uppaalModel.getOutputVars());
        dynamicTable.setItems(uppaalModel.getTemplateUpdates());
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
        out.save(simulationName);
    }

    private Tab addNewResults(String tabName, Simulation run) throws InterruptedException, IOException {
        BorderPane pane = new BorderPane();

        //Value Label
        Label lblCurrentTime = new Label("0.0 ms");
        //Slider
        int maxTime = run.queryTimeBound();
        Slider timeSlider = new Slider(0, maxTime, 0);
        timeSlider.setMajorTickUnit(maxTime > 10000 ? maxTime/4 : 10000);
        timeSlider.setShowTickMarks(true);
        timeSlider.setShowTickLabels(true);
        timeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            //TODO oldValue could be used to only add/remove the edges not already up-to-date
            lblCurrentTime.setText(String.format("%.1f ms", newValue.doubleValue()));
            run.markEdgeAtTime(oldValue, newValue);
        });
        timeSlider.prefWidthProperty().bind(pane.widthProperty().multiply(0.8));
        lblCurrentTime.prefWidthProperty().bind(pane.widthProperty().multiply(0.1));

        HBox sliderBox = new HBox();
        sliderBox.prefWidthProperty().bind(pane.widthProperty());
        sliderBox.getChildren().add(timeSlider);
        sliderBox.getChildren().add(lblCurrentTime);
        sliderBox.setAlignment(Pos.TOP_CENTER);
        pane.setTop(sliderBox);

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
        AlertData alert = uppaalModel.saveTemplateUpdatesToXml();
        if(alert != null)
            alert.showAlert();
    }

    public void onLeaveConfigurationTab(Event event) {
        Tab selectedTab = (event.getSource() instanceof Tab ? (Tab)event.getSource() : null);
        if(selectedTab != null && !selectedTab.isSelected() && constantsChanged){
            UPPAALParser.updateUPPAALConfigConstants(uppaalModel.getModelPath(), uppaalModel.getConfigVars());
            //TODO reload appropriate views and update. Save stuff that should not be updated (i.e. selection in outputvars)
            uppaalModel.getOutputVars().setAll(UPPAALParser.getUPPAALOutputVars(uppaalModel.getModelPath(), uppaalModel.getConfigVars()));
            constantsChanged = false;
        }
    }
}
