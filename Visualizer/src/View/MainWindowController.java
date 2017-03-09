package View;

import Helpers.ConnectedGraphGenerator;
import Helpers.FileHelper;
import Helpers.GUIHelper;
import Model.*;
import Helpers.QueryGenerator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.xml.sax.SAXException;
import parsers.UPPAALParser;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


    @FXML private ProgressIndicator simulationProgress;
    @FXML private TextArea txtUppaalOutput;
    @FXML private TextField txtSimulationName;
    @FXML private TextArea queryGeneratedTextField;
    @FXML private TableColumn<CVar, String> columnName;
    @FXML private TableColumn<CVar, CVar> columnValue;
    @FXML private TableColumn<CVar, String> columnScope;
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
    @FXML private TableColumn<TemplateUpdate, TemplateUpdate> dynColumnValue;
    @FXML private TableColumn<TemplateUpdate, Integer> dynColumnTime;
    @FXML private Tab configurationTab;
    @FXML private Button saveModelButton;
    @FXML private GridPane globalVarGridPane;
    @FXML private ToggleSwitch chkUseRandomTopology;


    private UPPAALModel uppaalModel;
    public boolean constantsChanged;
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
        instance = this;
        initializeConstantTableValues();
        initializeOutputVarsTable();
        initializeWidths();
        initializeDynamicTable();
    }

    private void initializeDynamicTable() {
        dynColumnValue.setCellValueFactory(p -> p.getValue().getObjectProperty());
        dynColumnValue.setCellFactory(p -> new TemplateUpdateValueEditingCell());

        dynColumnTime.setCellValueFactory(p -> p.getValue().timeProperty().asObject());
        dynColumnTime.setCellFactory(p -> new IntegerEditingCell());

        dynamicTable.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DELETE && uppaalModel.getTemplateUpdates().size() > 0){
                    uppaalModel.getTemplateUpdates().remove(dynamicTable.getSelectionModel().getSelectedItem());
                    dynamicTable.getSelectionModel().selectNext();
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
        columnScope.setCellValueFactory(cell -> ((Callback<CVar, StringProperty>) cellValue -> {
            if (cellValue.getScope() == null)
                return new SimpleStringProperty("Global");
            return cellValue.scopeProperty();
        }).call(cell.getValue()));

        columnName.setCellValueFactory(p -> p.getValue().nameProperty()); //Readonly, thus no CellFactory

        columnValue.setCellValueFactory(p -> p.getValue().getObjectProperty());
        columnValue.setCellFactory(column -> new CVarValueEditingCell());
    }

    private void initializeOutputVarsTable() {
        outputVarName.setCellValueFactory(p -> p.getValue().name());
        outputVarEdge.setCellValueFactory(p -> p.getValue().isEdgeData());
        outputVarEdge.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarNode.setCellValueFactory(p -> p.getValue().isNodeData());
        outputVarNode.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarUse.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarUse.setCellValueFactory(p -> p.getValue().isSelected());

        tableOutputVars.setSelectionModel(null);
    }

    private void initializeWithLoadedModel() {
        dynColumnName.setCellValueFactory(p -> p.getValue().variableNameProperty());
        dynColumnName.setCellFactory(ComboBoxTableCell.forTableColumn(uppaalModel.getDynamicTemplateVarNames()));
    }

    private void resetGUI() {
        Control[] controlsToReset = new Control[]{
                txtUppaalOutput, txtQuerySimulations, txtQueryTimeBound,
                txtSimulationName, queryGeneratedTextField,
                constantsTable, dynamicTable, tableOutputVars
        };

        for (Control ctrl : controlsToReset) {
            if (ctrl instanceof TextInputControl)
                ((TextInputControl)ctrl).setText("");
            if (ctrl instanceof TableView)
                ((TableView)ctrl).getItems().clear();
        }
    }

    public void loadModel(ActionEvent actionEvent) throws IOException, InterruptedException {
        File selectedFile = FileHelper.chooseFileToLoad(rootElement.getScene().getWindow(),
                FileHelper.UPPAALModelExtensionFilter, FileHelper.SimulationExtensionFilter);
        if (selectedFile == null || !selectedFile.exists() || !selectedFile.isFile())
            return;

        resetGUI();
        switch (FileHelper.getExtension(selectedFile.getName())) {
            case ".xml":
                loadNewModel(selectedFile);
                saveModelButton.setVisible(true);
                tabPane.setVisible(true);
                break;
            case ".sim":
                loadSavedSimulation(selectedFile);
                tabPane.setVisible(true);
                break;
            default:
                throw new IllegalArgumentException(selectedFile.getName() + " could not be used");
        }

    }

    public void saveModel(ActionEvent actionEvent) throws IOException, TransformerException, SAXException, ParserConfigurationException {
        setConstantTableSaveOnUnFocus();
        File selectedFile = FileHelper.chooseFileToSave(FileHelper.UPPAALModelExtensionFilter);
        if (selectedFile == null) return;
        uppaalModel.saveToPath(selectedFile.getPath());
        GUIHelper.showAlert(Alert.AlertType.INFORMATION, "Model successfully saved");
    }

    public void onLeaveConfigurationTab(Event event) {
        Tab selectedTab = (event.getSource() instanceof Tab ? (Tab)event.getSource() : null);
        if(selectedTab != null && !selectedTab.isSelected())
            setConstantTableSaveOnUnFocus();
    }

    private void setConstantTableSaveOnUnFocus() {
        constantsTable.requestFocus();
        if(constantsChanged){
            UPPAALParser.updateUPPAALConfigConstants(uppaalModel.getModelPath(), uppaalModel.getAllConfigVars());
            //TODO reload appropriate views and update. Save stuff that should not be updated (i.e. selection in outputvars)
            uppaalModel.getOutputVars().setAll(UPPAALParser.getUPPAALOutputVars(uppaalModel.getModelPath(), uppaalModel.getAllConfigVars()));
            constantsChanged = false;
        }
    }

    private void loadSavedSimulation(File selectedFile) throws IOException, InterruptedException {
        Simulation loaded = Simulation.load(selectedFile);
        if (loaded != null) {
            addNewResults(selectedFile.getName(), loaded);
        }
    }

    private void loadNewModel(File selectedFile) {
        File tempFile = null;
        try {
            tempFile = FileHelper.copyFileIntoTempFile(selectedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        uppaalModel = new UPPAALModel(tempFile.getPath());
        uppaalModel.load();
        constantsTable.setItems(uppaalModel.getAllConfigVars());
        tableOutputVars.setItems(uppaalModel.getOutputVars());
        dynamicTable.setItems(uppaalModel.getTemplateUpdates());
        initializeWithLoadedModel();
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
                    queryGeneratedTextField.setText(QueryGenerator.generateSimulationQuery(time, nrSimulations, vars, uppaalModel.getProcesses()));
                }
            } catch (Exception e) {
                GUIHelper.showAlert(Alert.AlertType.INFORMATION, "Timebound and number of simulations must be positive integers");
            }
        }
    }

    private void handleRandomTopologyIfActivated(boolean updateXML) {
        boolean useRandomTopology = chkUseRandomTopology.switchOnProperty().get();
        if (!useRandomTopology) return;

        int originalNumberOfNodes = uppaalModel.getTopology().getNumberOfNodes();
        UPPAALTopology randomTopology = ConnectedGraphGenerator.generateRandomTopology(originalNumberOfNodes);
        uppaalModel.setTopology(randomTopology, updateXML);
    }

    public void runSimulationQuery(ActionEvent actionEvent) throws InterruptedException, IOException {
        if(queryGeneratedTextField.getText().length() == 0) {
            GUIHelper.showAlert(Alert.AlertType.ERROR, "Please generate Query first");
            return;
        }

        String query = queryGeneratedTextField.getText();
        txtUppaalOutput.setText("Running following query in UPPAAL: \n" + query );

        simulationProgress.setVisible(true);
        handleRandomTopologyIfActivated(true);
        Simulation out = uppaalModel.runQuery(query); //Run in uppaal - takes long time
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
        int maxTime = (int)(run.queryTimeBound() * run.getModelTimeUnit());
        Slider timeSlider = new Slider(0, maxTime, 0);
        timeSlider.setMajorTickUnit(maxTime > 10000 ? maxTime/4 : 10000);
        timeSlider.setShowTickMarks(true);
        timeSlider.setShowTickLabels(true);
        timeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblCurrentTime.setText(String.format("%.1f ms", newValue.doubleValue()));
            run.markGraphAtTime(oldValue, newValue, globalVarGridPane);
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
        StackPane stackPane = new StackPane();
        pane.setCenter(stackPane);
        final SwingNode swingNode = new SwingNode();
        stackPane.getChildren().add(swingNode);
        initializeGlobalVarGridpane(stackPane);
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

        FXMLLoader simulationMenuLoader = new FXMLLoader(getClass().getResource("SimulationMenu.fxml"));
        Parent simulationMenuView = simulationMenuLoader.load();
        SimulationMenuController controller = simulationMenuLoader.getController();
        controller.loadWithSimulation(run);
        pane.setRight(simulationMenuView);

        //Tab
        Tab tab = new Tab();
        tab.setText(tabName);
        tab.setContent(pane);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
        return tab;
    }

    private void initializeGlobalVarGridpane(StackPane stackPane) {
        globalVarGridPane = new GridPane();
        globalVarGridPane.setPickOnBounds(false);
        globalVarGridPane.setPadding(new Insets(10,0,0,10));
        stackPane.getChildren().add(globalVarGridPane);
    }

    public void addUpdates(ActionEvent actionEvent) {
        AlertData alert = uppaalModel.saveTemplateUpdatesToXml();
        if(alert != null)
            alert.showAlert();
    }
    public ObservableList<CVar> getNonConstConfigVars(){
        return uppaalModel.getNonConstConfigVars();
    }

    public void btnAddDynamicUpdateRowClicked(ActionEvent actionEvent) {
        if (uppaalModel.getDynamicTemplateVarNames().isEmpty()) {
            GUIHelper.showInformation("There are no non-const variables prefixed with CONFIG_ in your model.");
            return;
        }

        dynamicTable.getItems().add(new TemplateUpdate());
        dynamicTable.getSelectionModel().selectLast();
    }
}
