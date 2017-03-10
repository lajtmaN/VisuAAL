package View.simulation;


import Model.Simulation;
import View.Options.ExportTopologyOption;
import View.Options.SimulationOption;
import View.Options.SimulationOptionCell;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by lajtman on 08-03-2017.
 */
public class SimulationMenuController implements Initializable {

    @FXML private ListView lstDisplayOptions;
    @FXML private ListView<SimulationOption> lstExportOptions;

    private Simulation currentSimulation;

    public void loadWithSimulation(Simulation currentSimulation) {
        this.currentSimulation = currentSimulation;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addOptionsToListViews();
        initializeExportOptions();
        initializeDisplayOptions();
    }

    private void addOptionsToListViews() {
        lstExportOptions.getItems().add(new ExportTopologyOption());
    }

    private void initializeExportOptions() {
        lstExportOptions.setCellFactory(param -> new SimulationOptionCell());
        lstExportOptions.setOnMouseClicked(p -> {
            lstExportOptions.getSelectionModel().getSelectedItem().performAction(currentSimulation);
        });

        setHeight(lstExportOptions);
    }

    private void initializeDisplayOptions() {
        setHeight(lstDisplayOptions);
    }

    private void setHeight(ListView list) {
        list.setPrefHeight(list.getItems().size() * 24 + 2);
    }
}
