package TopologyViewer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class TopologyViewerController implements Initializable {

    @FXML
    private WebView webView;
    @FXML
    private TableColumn columnName;
    @FXML
    private TableColumn columnValue;
    @FXML
    private TableView constantsTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadWebsite(null);
        System.out.println(getArborPageLocation());
        columnName.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.2));
        columnValue.prefWidthProperty().bind(constantsTable.widthProperty().multiply(0.8));

        columnName.setCellValueFactory( p -> {
            Pair<String,String> x = ((TableColumn.CellDataFeatures<Pair<String, String>, String>)p).getValue();
            return new SimpleStringProperty(x.getKey());
        });

        columnValue.setCellValueFactory( p -> {
            Pair<String,String> x = ((TableColumn.CellDataFeatures<Pair<String, String>, String>)p).getValue();
            return new SimpleStringProperty(x.getValue());
        });
    }

    public void addConstantsToList(List<Pair<String, String>> constants){
        constantsTable.getItems().addAll(constants);
    }

    public void loadWebsite(ActionEvent actionEvent) {
        webView.getEngine().load(getArborPageLocation());
    }

    public String getArborPageLocation() {
        return "file:///" + Paths.get("src", "Arbor", "index.html").normalize().toAbsolutePath().toString();
    }
}
