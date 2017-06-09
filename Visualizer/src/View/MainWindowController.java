package View;

import Helpers.*;
import Model.*;
import View.simulation.SimulationResultController;
import View.topology.TopologyGeneratorController;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;
import javafx.util.Callback;
import org.xml.sax.SAXException;
import parsers.UPPAALParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;

public class MainWindowController implements Initializable {
    @FXML public Button cancelButton;
    @FXML private ProgressIndicator simulationProgress;
    @FXML private TextArea txtUppaalOutput;
    @FXML private TextField txtSimulationName;
    @FXML private TableColumn<CVar, String> columnName;
    @FXML private TableColumn<CVar, CVar> columnValue;
    @FXML private TableColumn<CVar, String> columnScope;
    @FXML private TableView constantsTable;
    @FXML private GridPane horizontalGrid;
    @FXML private TabPane tabPane;
    @FXML private GridPane rootElement;
    @FXML private TableView<OutputVariable> tableOutputVars;
    @FXML private TableColumn<OutputVariable, String> outputVarName;
    @FXML private TableColumn<OutputVariable, String> outputVarScope;
    @FXML private TableColumn<OutputVariable, Boolean> outputVarEdge;
    @FXML private TableColumn<OutputVariable, Boolean> outputVarNode;
    @FXML private TableColumn<OutputVariable, Boolean> outputVarUse;
    @FXML private TextField txtQueryTimeBound;
    @FXML private TextField txtQuerySimulations;
    @FXML private TableView<TemplateUpdate> dynamicTable;
    @FXML private TableColumn<TemplateUpdate, String> dynColumnName;
    @FXML private TableColumn<TemplateUpdate, String> dynColumnValue;
    @FXML private TableColumn<TemplateUpdate, Number> dynColumnTime;
    @FXML private Tab configurationTab;
    @FXML private Button saveModelButton;
    @FXML private ToggleSwitch chkUseRandomTopology;
    @FXML private Tab topologyGeneratorTab;
    @FXML public TopologyGeneratorController topologyGeneratorController;

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
        cancelButton.disableProperty().bind(UPPAALExecutor.simulationsActiveProperty().not());
    }

    private void initializeDynamicTable() {
        dynamicTable.setEditable(true);
        dynColumnName.setCellValueFactory(p -> p.getValue().variableNameProperty());
        dynColumnValue.setCellValueFactory(p -> p.getValue().theValueProperty());
        dynColumnTime.setCellValueFactory(p -> p.getValue().timeProperty());

        dynColumnValue.setCellFactory(p -> new TemplateUpdateValueEditingCell());
        dynColumnTime.setCellFactory(p -> new TemplateUpdateModelTimeEditingCell());

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

    private void initializeWithLoadedModel() {
        dynColumnName.setCellFactory(p -> new TemplateUpdateNameEditingCell());
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
        outputVarScope.setCellValueFactory(cell -> ((Callback<OutputVariable, StringProperty>) cellValue -> {
            if (cellValue.getScope() == null)
                return new SimpleStringProperty("Global");
            return cellValue.scopeProperty();
        }).call(cell.getValue()));

        outputVarEdge.setCellValueFactory(p -> p.getValue().isEdgeData());
        outputVarEdge.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarNode.setCellValueFactory(p -> p.getValue().isNodeData());
        outputVarNode.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarUse.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarUse.setCellValueFactory(p -> p.getValue().isSelected());

        tableOutputVars.setSelectionModel(null);
    }

    private void resetGUI() {
        Control[] controlsToReset = new Control[]{
                txtUppaalOutput, txtQuerySimulations, txtQueryTimeBound,
                txtSimulationName, constantsTable, dynamicTable, tableOutputVars
        };

        for (Control ctrl : controlsToReset) {
            if (ctrl instanceof TextInputControl)
                ((TextInputControl)ctrl).setText("");
            if (ctrl instanceof TableView)
                ((TableView)ctrl).getItems().clear();
        }
    }

    public double getTabHeight() {
        return tabPane.getHeight() - tabPane.getTabMaxHeight();
    }

    public double getTabWidth() {
        return tabPane.getWidth();
    }

    public void loadModel(ActionEvent actionEvent) throws IOException, InterruptedException {
        File selectedFile = FileHelper.chooseFileToLoad("Select UPPAAL model or simulation",
                Settings.Instance().getRecentLoadedModel(), ExtensionFilters.UPPAALModelExtensionFilter,
                ExtensionFilters.SimulationExtensionFilter);
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
        constantsChanged = true;
        updateModelFileWithChanges();
        File selectedFile = FileHelper.chooseFileToSave(ExtensionFilters.UPPAALModelExtensionFilter);
        if (selectedFile == null) return;
        uppaalModel.saveToPath(selectedFile.getPath());
        GUIHelper.showAlert(Alert.AlertType.INFORMATION, "Model successfully saved");
    }

    private void setConstantTableSaveOnUnFocus() {
        constantsTable.requestFocus();
        if(constantsChanged){
            UPPAALParser.updateUPPAALConfigConstants(uppaalModel.getModelPath(), uppaalModel.getAllConfigVars());
            reloadOutputVariables();
            constantsChanged = false;
        }
    }

    private void loadSavedSimulation(File selectedFile) throws IOException, InterruptedException {
        Simulations loaded = Simulations.load(selectedFile);
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
        Settings.Instance().setRecentLoadedModel(selectedFile.getPath());

        try {
            uppaalModel = new UPPAALModel(tempFile.getPath());
            uppaalModel.load();
            constantsTable.setItems(uppaalModel.getAllConfigVars());
            tableOutputVars.setItems(uppaalModel.getOutputVars());
            dynamicTable.setItems(uppaalModel.getTemplateUpdates());
            initializeWithLoadedModel();
        } catch (Exception e) {
            GUIHelper.showError("Could not load model." + System.lineSeparator() + "Error Message: " + e.getMessage());
        }
    }

    private String generateQuery() {
        FilteredList<OutputVariable> vars = tableOutputVars.getItems().filtered(
                outputVariable -> outputVariable.isSelected().getValue());
        if(vars == null || vars.size() == 0) {
            GUIHelper.showAlert(Alert.AlertType.INFORMATION, "No output variables selected");
        } else {
            try{
                int time = Integer.parseInt(txtQueryTimeBound.getText());
                int nrSimulations = Integer.parseInt(txtQuerySimulations.getText());

                if(time <= 0 || nrSimulations <= 0){
                    GUIHelper.showAlert(Alert.AlertType.INFORMATION, "Timebound and number of simulations must be positive integers");
                }
                else if (time > 0  && nrSimulations > 0) {
                    return QueryGenerator.generateSimulationQuery(time, nrSimulations, vars, uppaalModel.getProcesses(), uppaalModel.getTopology().getNumberOfNodes());
                }
            } catch (Exception e) {
                GUIHelper.showAlert(Alert.AlertType.INFORMATION, "Timebound and number of simulations must be positive integers");
            }
        }
        return null;
    }

    private void handleRandomTopologyIfActivated(boolean updateXML) {
        boolean useRandomTopology = chkUseRandomTopology.switchOnProperty().get();
        if (!useRandomTopology) return;

        UPPAALTopology randomTopology = topologyGeneratorController.generateTopology(false);
        uppaalModel.setTopology(randomTopology, updateXML);
    }

    private void reloadOutputVariables() {
        uppaalModel.getOutputVars().setAll(UPPAALParser.getUPPAALOutputVars(uppaalModel.getModelPath()));
    }

    public void runSimulationQuery(ActionEvent actionEvent) throws InterruptedException, IOException {
        updateModelFileWithChanges();

        if (uppaalModel.getTopology() == null) {
            GUIHelper.showInformation("Please create a topology in Topology Creator tab first");
            return;
        }

        String query = generateQuery();
        if (query == null)
            return;

        txtUppaalOutput.setText("Running query in UPPAAL..." + System.lineSeparator());

        simulationProgress.setVisible(true);
        String simulationName = txtSimulationName.getText().length() > 0 ? txtSimulationName.getText() : "Result";

        CompletableFuture<Simulations> out = uppaalModel.runQuery(query, txtUppaalOutput); //Run in uppaal - takes long time
        out.exceptionally(th -> {
            simulationProgress.setVisible(false);
            if(th.getCause() != null && th.getCause().getClass() != CancellationException.class) { //ignore cancellation
                Platform.runLater(() -> GUIHelper.showError("Simulations failed: " + System.lineSeparator() + th.getMessage()));
                th.printStackTrace();
            }
            return null;
        });
        out.thenAccept(simulations -> {
            simulationProgress.setVisible(false);
            if (simulations != null) {
                if(topologyGeneratorController.getGPSLogRelatedSimulationPoints() != null)
                    simulations.addAndSortSimulationPoints(topologyGeneratorController.getGPSLogRelatedSimulationPoints(),
                            topologyGeneratorController.getLatLngBounds());
                Platform.runLater(() -> addNewResults(simulationName, simulations));
                simulations.save(simulationName);
            }
        });
    }

    private void updateModelFileWithChanges() {
        setConstantTableSaveOnUnFocus();
        handleRandomTopologyIfActivated(true);
        reloadOutputVariables();

        AlertData alert = uppaalModel.saveTemplateUpdatesToXml();
        if(alert != null && alert.getAlertType() == Alert.AlertType.ERROR)
            alert.showAlert();
    }

    private void addNewResults(String simulationName, Simulations out) {
        Parent simulationResultView = null;
        try {
            FXMLLoader simulationResultLoader = new FXMLLoader(getClass().getResource("simulation/SimulationResult.fxml"));
            simulationResultView = simulationResultLoader.load();
            SimulationResultController controller = simulationResultLoader.getController();
            controller.loadWithSimulation(out);
        } catch (IOException e) {
            GUIHelper.showError("Could not load results");
            return;
        }

        //Tab
        Tab tab = new Tab();
        tab.setText(simulationName);
        tab.setContent(simulationResultView);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
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

    public UPPAALModel getUppaalModel() {
        return this.uppaalModel;
    }

    private boolean hasEnteredTopologyGenerator = false;
    public void onEnterTopologyGenerator(Event event) {
        if (!hasEnteredTopologyGenerator) {
            topologyGeneratorController.autoResize();
            hasEnteredTopologyGenerator = true;
        }
    }

    public void enableDisableUseTopologyFromTopologyGenerator(boolean active) {
        chkUseRandomTopology.switchOnProperty().set(active);
    }

    public void cancelSimulations(ActionEvent actionEvent) {
        UPPAALExecutor.cancelProcesses();
    }
}