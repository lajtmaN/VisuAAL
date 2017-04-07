package View.simulation;


import Helpers.GUIHelper;
import Helpers.OptionsHelper;
import Model.OutputVariable;
import Model.Simulations;
import View.DoubleTextField;
import View.IntegerTextField;
import View.Options.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Arrays;

/**
 * Created by lajtman on 08-03-2017.
 */
public class SimulationMenuController {

    @FXML public DoubleTextField minEdgeValueText;
    @FXML public DoubleTextField maxEdgeValueText;
    @FXML public DoubleTextField minNodeValueText;
    @FXML public DoubleTextField maxNodeValueText;
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
        initializeMinMaxFields();
        //TODO Description is not updated when the onProperty changes.
        lstDisplayOptions.setCellFactory(OptionsHelper.optionListCell());

        for(EnableDisableSimulationOption s : lstDisplayOptions.getItems()) {
            s.onProperty().addListener((observable, oldValue, newValue) ->
            {
                if(!(s instanceof ShowHideDataOption) || oldValue.equals(newValue))
                    return;

                ShowHideDataOption option = (ShowHideDataOption) s;
                OutputVariable v = option.getOutputVariable();
                if(newValue) {
                    //unmark other of same type
                    for (EnableDisableSimulationOption eds : this.lstDisplayOptions.getItems().filtered(
                            m -> (m instanceof ShowHideDataOption) && m != s)) {
                        OutputVariable ov = ((ShowHideDataOption) eds).getOutputVariable();
                        if (ov.getIsNodeData() && v.getIsNodeData())
                            eds.onProperty().set(false);
                        else if (ov.getIsEdgeData() && v.getIsEdgeData())
                            eds.onProperty().set(false);
                    }

                    //Set the current node or data output variable
                    if (v.getIsEdgeData()) {
                        currentSimulations.setShownEdgeVariable(v);
                    } else if(v.getIsNodeData()) {
                        currentSimulations.setShownNodeVariable(v);
                    }
                }
                else {
                    //Disable the shown variable
                    if (v.getIsEdgeData() && v == currentSimulations.getShownEdgeVariable()) {
                        currentSimulations.setShownEdgeVariable(null);
                    } else if (v.getIsNodeData() && v == currentSimulations.getShownNodeVariable()) {
                        currentSimulations.setShownNodeVariable(null);
                    }
                }
                //s.onProperty().set(newValue);
            });
        }
    }

    private void initializeMinMaxFields() {
        minEdgeValueText.setText(String.valueOf(currentSimulations.getMinEdgeValue()));
        maxEdgeValueText.setText(String.valueOf(currentSimulations.getMaxEdgeValue()));
        minNodeValueText.setText(String.valueOf(currentSimulations.getMinNodeValue()));
        maxNodeValueText.setText(String.valueOf(currentSimulations.getMaxNodeValue()));
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

    public void saveMinMaxValues(ActionEvent actionEvent) {
        if(!minEdgeValueText.getText().equals("") && !maxEdgeValueText.getText().equals("") &&
                !minNodeValueText.getText().equals("") && !maxNodeValueText.getText().equals("")) {
            double minEdge = Double.valueOf(minEdgeValueText.getText()),
                   maxEdge = Double.valueOf(maxEdgeValueText.getText()),
                   minNode = Double.valueOf(minNodeValueText.getText()),
                   maxNode = Double.valueOf(maxNodeValueText.getText());

            if(maxEdge > minEdge && maxNode > minNode) {
                currentSimulations.setMinEdgeValue(minEdge);
                currentSimulations.setMaxEdgeValue(maxEdge);
                currentSimulations.setMinNodeValue(minNode);
                currentSimulations.setMaxNodeValue(maxNode);
                currentSimulations.resetToCurrentTime();
            }
            else
                GUIHelper.showError("Maximum fields must be larger than the corresponding minimum field");
        }
        else
            GUIHelper.showError("All fields must have a value");
    }
}
