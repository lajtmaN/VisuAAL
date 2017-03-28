package View.simulation;


import Helpers.OptionsHelper;
import Model.Simulations;
import View.Options.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.StringConverter;

import java.util.Arrays;

/**
 * Created by lajtman on 08-03-2017.
 */
public class SimulationMenuController {

    @FXML private ListView<EnableDisableSimulationOption> lstSimulationOptions;
    @FXML private ListView<EnableDisableSimulationOption> lstDisplayOptions;
    @FXML private ListView<SimulationOption> lstExportOptions;

    private Simulations currentSimulations;

    public void loadWithSimulation(Simulations currentSimulations) {
        this.currentSimulations = currentSimulations;
        addOptionsToListViews();
        initializeExportOptions();
        initializeDisplayOptions();
        initializeSimulationOptions();
        setHeight();
    }

    private void addOptionsToListViews() {
        lstExportOptions.getItems().add(new ExportTopologyOption(currentSimulations));

        currentSimulations.getOutputVariables().forEach(outputVariable -> {
            if (outputVariable.getIsSelected()) //Only add all the variables that was enabled when running query
                lstDisplayOptions.getItems().add(new ShowHideDataOption(currentSimulations, outputVariable));
        });

        for (int i = 0; i < currentSimulations.getNumberOfSimulations(); i++) {
            lstSimulationOptions.getItems().add(new ShowHideSimulationOption(currentSimulations, i));
        }
    }

    private void initializeExportOptions() {
        lstExportOptions.setCellFactory(param -> new SimulationOptionCell());
        lstExportOptions.setOnMouseClicked(p -> {
            lstExportOptions.getSelectionModel().getSelectedItem().startAction();
        });
    }

    private void initializeDisplayOptions() {
        //TODO Description is not updated when the onProperty changes.
        lstDisplayOptions.setCellFactory(OptionsHelper.optionListCell());

        lstDisplayOptions.setOnMouseClicked(p -> {
            EnableDisableSimulationOption optionClicked = lstDisplayOptions.getSelectionModel().getSelectedItem();
            optionClicked.onProperty().set(!optionClicked.onProperty().get());
        });
    }

    private void initializeSimulationOptions() {
        lstSimulationOptions.setCellFactory(OptionsHelper.optionListCell());
        lstSimulationOptions.setOnMouseClicked(p -> {
            EnableDisableSimulationOption optionClicked = lstSimulationOptions.getSelectionModel().getSelectedItem();
            optionClicked.onProperty().set(!optionClicked.onProperty().get());
        });
    }

    private void setHeight() {
        Arrays.asList(lstDisplayOptions, lstExportOptions).forEach(list -> setHeight(list));
    }

    private void setHeight(ListView list) {
        list.setPrefHeight(list.getItems().size() * 24 + 2);
    }
}
