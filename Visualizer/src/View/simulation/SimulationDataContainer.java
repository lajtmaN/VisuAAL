package View.simulation;

import Helpers.Pair;
import Model.OutputVariable;
import Model.Simulations;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.HashMap;

/**
 * Created by batto on 09-Mar-17.
 */
public class SimulationDataContainer extends GridPane {
    private HashMap<Integer, HashMap<String, Double>> nodeVariableMapper;
    private HashMap<String,  Label> labels;
    private Label nodeIdLabel;
    private int currentNodeId = 0;

    public SimulationDataContainer() {}

    public void initialize(Simulations simulations) {
        labels = new HashMap<>();
        nodeVariableMapper = new HashMap<>();

        nodeIdLabel = new Label("Node 0");
        this.addRow(0, nodeIdLabel);
        this.setPadding(new Insets(5, 0, 0, 5));

        int j = 1;
        for (OutputVariable var : simulations.getOutputVariables()) {
            if(var.getIsSelected() && var.getIsNodeData()) {
                Label zero = new Label("0");
                zero.setPadding(new Insets(0, 0, 0, 5));
                this.addRow(j++, new Label(var.toString()), zero);
                labels.put(var.toString(), zero);
            }
        }

        for (int i = 0; i < simulations.getTopology().getNumberOfNodes(); i++) {
            for (OutputVariable var : simulations.getOutputVariables()) {
                if(var.getIsSelected() && var.getIsNodeData()) {
                    addVariable(i, var.toString());
                }
            }
        }
    }

    public void nodeIsSelected(int nodeId) {
        //Prevent JavaFX from throwing illegalStateExceptions
        Platform.runLater(() -> {
            for(String key : labels.keySet()){
                setLabelValue(labels.get(key), nodeVariableMapper.get(nodeId).get(key));
            }
            nodeIdLabel.setText("Node " + nodeId);
            currentNodeId = nodeId;
        });
    }

    private void addVariable(int nodeId, String variable) {
        if(!nodeVariableMapper.containsKey(nodeId)){
            nodeVariableMapper.put(nodeId, new HashMap());
        }

        HashMap<String, Double> node = nodeVariableMapper.get(nodeId);

        if(!node.containsKey(variable)) {
            node.put(variable, 0.0);
        }
    }

    public void updateVariable(int nodeId, String variable, double value) {
        try {
            nodeVariableMapper.get(nodeId).put(variable, value);
            if(nodeId == currentNodeId) {
                setLabelValue(labels.get(variable), value);
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException(String.format("Could not update the variable (%s) on Node %d", variable, nodeId));
        }
    }

    private void setLabelValue(Label label, double value) {
        if(String.valueOf(value).length() > 12)
            label.setText(String.format("%6.3e", value));
        else
            label.setText(String.valueOf(value));
    }
}