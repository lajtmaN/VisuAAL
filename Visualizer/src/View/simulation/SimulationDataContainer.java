package View.simulation;

import Helpers.Pair;
import Model.OutputVariable;
import Model.Simulations;
import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.util.HashMap;

/**
 * Created by batto on 09-Mar-17.
 */
public class SimulationDataContainer extends GridPane {
    private HashMap<Integer, HashMap<String, Pair<Integer, Double>>> nodeVariableMapper;
    private HashMap<String,  Label> labels;
    private Label nodeIdLabel;

    public SimulationDataContainer() {}

    public void initialize(Simulations simulations) {
        labels = new HashMap<>();
        nodeVariableMapper = new HashMap<>();

        nodeIdLabel = new Label("Node 0");
        this.addRow(0, nodeIdLabel);

        int j = 1;
        for (OutputVariable var : simulations.getOutputVariables()) {
            if(var.getIsSelected() && var.getIsNodeData()) {
                Label zero = new Label("0");
                zero.setPadding(new Insets(0, 0, 0, 10));
                this.addRow(j++, new Label(var.getName()), zero);
                labels.put(var.getName(), zero);
            }
        }

        for (int i = 0; i < simulations.getTopology().getNumberOfNodes(); i++) {
            for (OutputVariable var : simulations.getOutputVariables()) {
                if(var.getIsSelected() && var.getIsNodeData()) {
                    addVariable(i, var.getName());
                }
            }
        }
    }

    public void nodeIsSelected(int nodeId) {
        //Prevent JavaFX from throwing illegalStateExceptions
        Platform.runLater(() -> {
            for(String key : labels.keySet()){
                labels.get(key).setText(String.valueOf(nodeVariableMapper.get(nodeId).get(key).getSecond()));
            }
            nodeIdLabel.setText("Node " + nodeId);
        });
    }

    private void addVariable(int nodeId, String variable) {
        if(!nodeVariableMapper.containsKey(nodeId)){
            nodeVariableMapper.put(nodeId, new HashMap());
        }

        HashMap<String, Pair<Integer, Double>> node = nodeVariableMapper.get(nodeId);

        if(!node.containsKey(variable)) {
            node.put(variable, new Pair(-1, 0));
        }
    }

    public void updateVariable(int nodeId, String variable, double value) {
        try {
            nodeVariableMapper.get(nodeId).get(variable).setSecond(value);
            labels.get(variable).setText(String.valueOf(value));
        }
        catch (Exception e) {
            throw new IllegalArgumentException(String.format("Could not update the variable (%s) on Node %d", variable, nodeId));
        }
    }
}
