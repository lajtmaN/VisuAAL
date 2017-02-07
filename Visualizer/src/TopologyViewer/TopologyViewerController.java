package TopologyViewer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;
import parsers.CVar;
import parsers.UPPAALParser;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static parsers.UPPAALParser.getUPPAALConfigConstants;

public class TopologyViewerController implements Initializable {

    @FXML
    private WebView webView;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadWebsite(null);
        System.out.println(getArborPageLocation());
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
        webView.prefWidthProperty().bind(viewerGridPane.widthProperty());
    }

    public void addConstantsToList(ArrayList<CVar<Integer>> constants){
        constantsTable.getItems().addAll(constants);
    }

    public void loadModel(ActionEvent actionEvent) {
        constantsTable.getItems().clear();

        String modelPathContents = modelPathField.getText();
        if(modelPathContents.length() == 0) return;

        addConstantsToList(UPPAALParser.getUPPAALConfigConstants(modelPathContents));
    }

    public void loadWebsite(ActionEvent actionEvent) {
        webView.getEngine().load(getArborPageLocation());
    }

    public String getArborPageLocation() {
        return "file:///" + Paths.get("src", "Arbor", "index.html").normalize().toAbsolutePath().toString();
    }
}
