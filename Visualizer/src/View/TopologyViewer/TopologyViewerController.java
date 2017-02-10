package View.TopologyViewer;

import Model.*;
import UPPAALHelpers.QueryGenerator;
import UPPAALHelpers.UPPAALExecutor;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import org.graphstream.ui.view.Viewer;
import parsers.UPPAALParser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TopologyViewerController implements Initializable {

    @FXML
    private TableColumn columnName;
    @FXML
    private TableColumn columnValue;
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
    private Canvas topologyViewerCanvas;

    UPPAALTopology uppaalTopology;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeTable();
    }

    private void initializeTable() {
        columnName.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.2));
        columnValue.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.8));

        columnName.setCellValueFactory( p -> {
            CVar<String> x = ((TableColumn.CellDataFeatures<CVar<String>, String>)p).getValue();
            return new SimpleStringProperty(x.getName());
        });

        columnValue.setCellValueFactory( p -> {
            CVar<Integer> x = ((TableColumn.CellDataFeatures<CVar<Integer>, String>)p).getValue();
            return new SimpleStringProperty(x.getValue().toString());
        });

        loadModelButton.prefWidthProperty().bind(horizontalGrid.widthProperty().multiply(0.2));
        modelPathField.prefWidthProperty().bind(horizontalGrid.widthProperty().multiply(0.8));
        tabPane.prefWidthProperty().bind(rootElement.widthProperty());
        viewerGridPane.prefWidthProperty().bind(tabPane.widthProperty());
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
        if(modelPathContents.length() == 0) return;

        if (!modelPathContents.endsWith(".xml")) modelPathContents += ".xml";

        File f = new File(modelPathContents);
        if (f.exists() && !f.isDirectory()) {
            addConstantsToList(UPPAALParser.getUPPAALConfigConstants(modelPathContents));
            uppaalTopology = UPPAALParser.getUPPAALTopology(modelPathContents);
            addTopologyPairsToTextArea(uppaalTopology);
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
