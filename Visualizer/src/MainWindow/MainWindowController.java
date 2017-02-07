package MainWindow;

import TopologyViewer.TopologyViewerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static MainWindow.Main.windowHeight;
import static MainWindow.Main.windowWidth;

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
            uppaalStage.setScene(new Scene(root, windowHeight, windowWidth));
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
            topologyViewerStage.setScene(new Scene(root, windowHeight, windowWidth));
            topologyViewerStage.show();        }
        catch (IOException e){
            //Handled
        }
    }
}
