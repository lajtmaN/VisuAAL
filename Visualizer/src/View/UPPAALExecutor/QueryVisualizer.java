package View.UPPAALExecutor;

import Model.SimulateOutput;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by batto on 07-Feb-17.
 */
public class QueryVisualizer {
    @FXML
    private TextField ModelPathField;

    @FXML
    private TextField UppaalQuery;

    @FXML
    private TextArea ResultArea;


    public void ExecuteQuery(ActionEvent event){
        String modelPathText = ModelPathField.getText();
        if (!modelPathText.endsWith(".xml"))
            modelPathText += ".xml";

        String query = UppaalQuery.getText();
        if (!query.startsWith("simulate")) {
            ResultArea.setText("Vi understøter kun simulate indtil videre :-)");
            return;
        }
        try {
            SimulateOutput result = UPPAALExecutor.provideQueryResult(modelPathText, UppaalQuery.getText());

            if(result != null) {
                ResultArea.setText(result.toString());
            }
            else {
                //TODO Hvis queriet ikke er satisfiet/kan ikke compile, så håndter den fejl uppaal giver og print den i stedet.
                ResultArea.setText("UPPAAL kan ikke compile!");
            }
        }
        catch (Exception e) {
            ResultArea.setText("FEJL!");
        }
    }
}
