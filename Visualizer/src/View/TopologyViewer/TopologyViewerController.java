package View.TopologyViewer;

import Model.*;
import UPPAALHelpers.QueryGenerator;
import UPPAALHelpers.UPPAALExecutor;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.layout.GridPane;
import org.graphstream.ui.view.Viewer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TopologyViewerController implements Initializable {

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
    private TextField txtQueryTimeBound;
    @FXML
    private TextField txtQuerySimulations;

    private UPPAALModel uppaalModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
        outputVarName.setCellValueFactory(p -> p.getValue().name());
        outputVarEdge.setCellValueFactory(p -> p.getValue().isEdgeData());
        outputVarEdge.setCellFactory(p -> new CheckBoxTableCell<>());
        outputVarNode.setCellValueFactory(p -> p.getValue().isNodeData());
        outputVarNode.setCellFactory(p -> new CheckBoxTableCell<>());
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
            modelPathContents = "mac_model_test";

        if (!modelPathContents.endsWith(".xml")) modelPathContents += ".xml";

        File f = new File(modelPathContents);
        if (f.exists() && !f.isDirectory()) {
            uppaalModel = new UPPAALModel(modelPathContents);
            uppaalModel.load();
            addConstantsToList(uppaalModel.getConstantVars());
            addTopologyPairsToTextArea(uppaalModel.getTopology());
            tableOutputVars.setItems(uppaalModel.getOutputVars());
        }
    }

    public void showTopology(ActionEvent actionEvent) throws InterruptedException, IOException {
        UPPAALTopology topology = new UPPAALTopology();

                //uppaalTopology.getGraph(true).display();


        String q = QueryGenerator.Generate2DQuadraticArrayQuery("data_is_scheduled", 16, 1, 40000);
        SimulateOutput out = UPPAALExecutor.provideQueryResult("mac_model_exp.xml", q);
        ArrayList<SimulationEdgePoint> points = out.getZippedForSimulate(0);

        /*ArrayList<SimulationEdgePoint> edges = new ArrayList<>();
        int t = 0;
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                if(i!=j) {
                    edges.add(new SimulationEdgePoint(t*500, i, j, 1));
                    t++;
                }

            }
        }*/
        //viewer.disableAutoLayout();
        topology.setEdges(points);
        Viewer viewer =  topology.getGraph(true).display();

        topology.startAddingEdgesOverTime(points);
        //viewer.enableAutoLayout();
    }
}
