package View.Simulation;

import Model.OutputVariable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.List;

/**
 * Created by batto on 09-Mar-17.
 */
public class SimulationDataContainer extends GridPane {
    private HashMap<Integer, HashMap<String, Label>> nodeVariableMapper;

    public SimulationDataContainer(List<OutputVariable> nodeVariableNames, int topologySize) {
        this.nodeVariableMapper = new HashMap();
        for (int i = 0; i < topologySize; i++) {
            for (OutputVariable var : nodeVariableNames) {
                if(var.isNodeData().getValue()) {
                    addVariable(i, var.getName());
                }
            }
        }
    }

    public void nodeIsSelected(int nodeId) {
        System.out.println("node:" + nodeId);
        /*this.getChildren().clear();
        HashMap<String, Label> innerMap = nodeVariableMapper.get(nodeId);
        int i = 0;
        for(String key : innerMap.keySet()) {
            Label nameLabel = new Label(key);
            nameLabel.setPadding(new Insets(0,10, 0, 0));
            this.addRow(i++, nameLabel, innerMap.get(key));
        }*/
    }

    private void addVariable(int nodeId, String variable) {
        if(!nodeVariableMapper.containsKey(nodeId)){
            nodeVariableMapper.put(nodeId, new HashMap());
        }

        HashMap<String, Label> node = nodeVariableMapper.get(nodeId);

        if(!node.containsKey(variable)) {
            node.put(variable, new Label());
        }

        node.get(variable).setText("0");
    }

    public void updateVariable(int nodeId, String variable, double value) {
        nodeVariableMapper.get(nodeId).get(variable).setText(String.valueOf(value));
    }
}
