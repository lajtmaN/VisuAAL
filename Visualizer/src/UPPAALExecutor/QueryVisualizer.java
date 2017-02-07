package UPPAALExecutor;

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
    private TextArea ResultArea;

    public void ExecuteQuery(ActionEvent event){
        String modelPathText = ModelPathField.getText();

        String result = UPPAALExecutor.ProvideQueryResult(modelPathText);
        if(result != null) {
            ResultArea.setText(result);
        }
    }
}
