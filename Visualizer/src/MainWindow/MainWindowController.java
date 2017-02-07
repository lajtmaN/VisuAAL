package MainWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private Stage uppaalStage;
    private Stage topologyViewerStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        topologyViewerStage = new Stage();
        uppaalStage = new Stage();
    }

    public void showExecutor(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../UPPAALExecutor/QueryVisualizer.fxml"));
            uppaalStage.setTitle("UPPAAL Executor");
            uppaalStage.setScene(new Scene(root, 300, 275));
            uppaalStage.show();
        }
        catch (IOException e){
            //Handled
        }
    }

    public void showTopologyViewer(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../TopologyViewer/TopologyViewer.fxml"));
            topologyViewerStage.setTitle("Topology Viewer");
            topologyViewerStage.setScene(new Scene(root, 300, 275));
            topologyViewerStage.show();        }
        catch (IOException e){
            //Handled
        }
    }
}
