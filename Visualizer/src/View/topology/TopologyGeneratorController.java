package View.topology;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 17-03-2017.
 */
public class TopologyGeneratorController implements Initializable {
    @FXML private TextField txtNumCellsX;
    @FXML private TextField txtNumCellsY;
    @FXML private TextField txtAvgRangeMean;
    @FXML private TextField txtAvgRangeDeviation;
    @FXML private TextField txtNumNodesPrCellDeviationDefault;
    @FXML private TextField txtAvgNumNodesPrCellDefault;
    @FXML private BorderPane rootPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
