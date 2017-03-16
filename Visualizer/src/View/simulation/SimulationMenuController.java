package View.simulation;


import Model.Simulation;
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

    private Simulation currentSimulation;

    public void loadWithSimulation(Simulation currentSimulation) {
        this.currentSimulation = currentSimulation;
        addOptionsToListViews();
        initializeExportOptions();
        initializeDisplayOptions();
        setHeight();
    }

    private void addOptionsToListViews() {
        lstExportOptions.getItems().add(new ExportTopologyOption());

        currentSimulation.getOutputVariables().forEach(outputVariable -> {
            if (outputVariable.getIsSelected()) //Only add all the variables that was enabled when running query
                lstDisplayOptions.getItems().add(new ShowHideDataOption(outputVariable));
        });
    }

    private void initializeExportOptions() {
        lstExportOptions.setCellFactory(param -> new SimulationOptionCell());
        lstExportOptions.setOnMouseClicked(p -> {
            lstExportOptions.getSelectionModel().getSelectedItem().startAction(currentSimulation);
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
                option.startAction(currentSimulation);
            } else {
                option.disableAction(currentSimulation);
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
