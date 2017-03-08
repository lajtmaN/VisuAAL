package View;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 08-03-2017.
 */
public class SimulationMenuController implements Initializable {

    @FXML private ListView<String> lstExportOptions;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeExportOptions();
    }

    private void initializeExportOptions() {
        lstExportOptions.setCellFactory(param -> new ListCell<String>());
        

        lstExportOptions.getItems().add("TEST");
        lstExportOptions.getItems().add("YOO");
    }
}
