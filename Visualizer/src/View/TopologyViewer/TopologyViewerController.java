package View.TopologyViewer;

import Helpers.GUIHelper;
import Model.*;
import Helpers.QueryGenerator;
import Helpers.UPPAALExecutor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.GridPane;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TopologyViewerController implements Initializable {

    @FXML
    private SwingNode embeddedSwingNode;
    @FXML
    private TextArea queryGeneratedTextField;
    @FXML
    private TableColumn<CVar<String>, String> columnName;
    @FXML
    private TableColumn<CVar<Integer>, String> columnValue;
    @FXML
    private TableView constantsTable;
    @FXML
    private TextField modelPathField;
    @FXML
    private Button loadModelButton;
    @FXML
    private GridPane horizontalGrid;
    @FXML
    private TabPane tabPane;
    @FXML
    private GridPane rootElement;
    @FXML
    private GridPane viewerGridPane;
    @FXML
    private TextArea tempTopologyTextArea;
    @FXML
    private TableView<OutputVariable> tableOutputVars;
    @FXML
    private TableColumn<OutputVariable, String> outputVarName;
    @FXML
    private TableColumn<OutputVariable, Boolean> outputVarEdge;
    @FXML
    private TableColumn<OutputVariable, Boolean> outputVarNode;
    @FXML
    private TableColumn<OutputVariable, Boolean> outputVarUse;
    @FXML
    private TextField txtQueryTimeBound;
    @FXML
    private TextField txtQuerySimulations;

    private UPPAALModel uppaalModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.setVisible(false);
        initializeConstantTableValues();
        initializeOutputVarsTable();
        initializeWidths();
    }

    private void initializeWidths() {
        columnName.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.2));
        columnValue.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.8));
        modelPathField.prefWidthProperty().bind(horizontalGrid.widthProperty().multiply(0.8));
        outputVarName.prefWidthProperty().bind(tableOutputVars.widthProperty().multiply(0.5));
        tabPane.prefWidthProperty().bind(rootElement.widthProperty());
        viewerGridPane.prefWidthProperty().bind(tabPane.widthProperty());
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

    public void addTopologyPairsToTextArea(UPPAALTopology topology) {//TODO: Smid ind i webviewet i stedet - temp, smid i textarea!
        tempTopologyTextArea.clear();
        tempTopologyTextArea.setText("#Nodes: " + String.valueOf(topology.getNumberOfNodes())+"\n");
        for (UPPAALEdge e: topology) {
            tempTopologyTextArea.setText(tempTopologyTextArea.getText()+ e.toString() + "\n");
        }
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
            addTopologyPairsToTextArea(uppaalModel.getTopology());
            tableOutputVars.setItems(uppaalModel.getOutputVars());
            tabPane.setVisible(true);
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

    public void showTopology(ActionEvent actionEvent) throws InterruptedException, IOException {
        if(queryGeneratedTextField.getText().length() == 0) {
            GUIHelper.showAlert(Alert.AlertType.ERROR, "Please generate Query first");
            return;
        }

        String query = queryGeneratedTextField.getText();
        SimulateOutput out = uppaalModel.runSimulation(query);
        ArrayList<SimulationEdgePoint> points = out.getZippedForSimulate(0);

        UPPAALTopology topology = uppaalModel.getTopology();
        topology.setEdges(points);
        topology.updateGraph();
        Viewer v = new Viewer(topology.getGraph(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        ViewPanel swingView = v.addDefaultView(false);
        SwingUtilities.invokeLater(() -> {
            embeddedSwingNode.setContent(swingView);
        });
        topology.startAddingEdgesOverTime(points);

    }
}
