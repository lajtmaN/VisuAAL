package View.simulation;


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

    @FXML private ListView<EnableDisableSimulationOption> lstDisplayOptions;
    @FXML private ListView<SimulationOption> lstExportOptions;

    private Simulations currentSimulations;

    public void loadWithSimulation(Simulations currentSimulations) {
        this.currentSimulations = currentSimulations;
        addOptionsToListViews();
        initializeExportOptions();
        initializeDisplayOptions();
        setHeight();
    }

    private void addOptionsToListViews() {
        lstExportOptions.getItems().add(new ExportTopologyOption());

        currentSimulations.getOutputVariables().forEach(outputVariable -> {
            if (outputVariable.getIsSelected()) //Only add all the variables that was enabled when running query
                lstDisplayOptions.getItems().add(new ShowHideDataOption(outputVariable));
        });
    }

    private void initializeExportOptions() {
        lstExportOptions.setCellFactory(param -> new SimulationOptionCell());
        lstExportOptions.setOnMouseClicked(p -> {
            lstExportOptions.getSelectionModel().getSelectedItem().startAction(currentSimulations);
        });
    }

    private void initializeDisplayOptions() {
        //TODO Description is not updated when the onProperty changes.
        lstDisplayOptions.setCellFactory(CheckBoxListCell.forListView(item -> item.onProperty(), new StringConverter<EnableDisableSimulationOption>() {
            @Override
            public String toString(EnableDisableSimulationOption object) {
                return object.getDescription();
            }
            @Override
            public EnableDisableSimulationOption fromString(String string) {
                return null;
            }
        }));

        lstDisplayOptions.setOnMouseClicked(p -> {
            EnableDisableSimulationOption optionClicked = lstDisplayOptions.getSelectionModel().getSelectedItem();
            optionClicked.onProperty().set(!optionClicked.onProperty().get());
        });

        lstDisplayOptions.getItems().forEach(option -> option.onProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                option.startAction(currentSimulations);
            } else {
                option.disableAction(currentSimulations);
            }
        }));
    }

    private void setHeight() {
        Arrays.asList(lstDisplayOptions, lstExportOptions).forEach(list -> setHeight(list));
    }

    private void setHeight(ListView list) {
        list.setPrefHeight(list.getItems().size() * 24 + 2);
    }
}
