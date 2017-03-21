package View.topology;

import Model.topology.generator.CellOptions;
import View.DoubleTextField;
import View.IntegerTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

/**
 * Created by lajtman on 20-03-2017.
 */
public class CellOptionsController {
    @FXML private DoubleTextField txtNodesCellDeviation;
    @FXML private IntegerTextField txtAvgNodesPrCell;
    @FXML private DoubleTextField txtCellAvgRangeDeviation;
    @FXML private DoubleTextField txtCellAvgRangeMean;

    private CellOptions options;

    public CellOptions getOptions() {
        return options;
    }

    public void initWithOptions(CellOptions pOptions){
        options = pOptions;

        txtNodesCellDeviation.bindProperty(options.nodesCellDeviationProperty());
        txtAvgNodesPrCell.bindProperty(options.avgNodesPrCellProperty());
        txtCellAvgRangeDeviation.bindProperty(options.rangeDeviationProperty());
        txtCellAvgRangeMean.bindProperty(options.avgRangeProperty());

        /*txtNodesCellDeviation.focusedProperty().addListener((observable, oldValue, newValue) -> {
            //TODO make this textbox more visible from all others
        });*/

    }
}
