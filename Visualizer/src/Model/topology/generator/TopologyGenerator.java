package Model.topology.generator;


import Helpers.MathHelpers;
import Helpers.Pair;
import Model.UPPAALEdge;
import Model.UPPAALTopology;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lajtman on 17-03-2017.
 */
public class TopologyGenerator {

    private GlobalOptions options;
    private CellOptions[][] cellOptions;
    private double cellWidthInMeters = 1;
    private double cellHeightInMeters = 1;


    public TopologyGenerator() {
        options = new GlobalOptions();
        initializeNewCellOptions(options.getCellX(), options.getCellY());
    }

    public GlobalOptions getOptions() {
        return options;
    }

    public void initializeNewCellOptions(int x, int y) {
        //TODO maybe save the old values from cellOptions array

        cellOptions = new CellOptions[x][y];

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                cellOptions[i][j] = new CellOptions(options);
    }

    public ArrayList<CellNode> generateNodes() {
        ArrayList<CellNode> result = new ArrayList<>();
        for(int xIndex = 0; xIndex < options.getCellX(); xIndex++){
            for(int yIndex = 0; yIndex < options.getCellY(); yIndex++){
                result.addAll(generateNodesForCell(xIndex, yIndex));
            }
        }
        return result;
    }

    public ArrayList<CellNode> generateNodesForCell(int x, int y){
        CellOptions cellOption = getOptionsForCell(x, y);
        int nodesInCell = (int) MathHelpers.gaussian(cellOption.getAvgNodesPrCell(), cellOption.getNodesCellDeviation());

        ArrayList<CellNode> result = new ArrayList<>();

        for(int i = 0; i < nodesInCell; i++){
            double range = MathHelpers.gaussian(cellOption.getAvgRange(), cellOption.getRangeDeviation());
            double nodeX = (Math.random() + x) * cellWidthInMeters;
            double nodeY = (Math.random() + y) * cellHeightInMeters;
            result.add(new CellNode(range, nodeX, nodeY)); //New random for each number
        }
        return result;
    }

    public boolean isInRange(CellNode node1, CellNode node2) {
        double nodeDistance = Math.pow(node1.getX() - node2.getX(), 2) + Math.pow(node1.getY() - node2.getY(), 2);
        return (Math.pow(node1.getRange(), 2) > nodeDistance);
    }

    public UPPAALTopology generateUppaalTopology() {
        ArrayList<CellNode> nodes = generateNodes();
        return generateUppaalTopology(nodes);
    }

    public UPPAALTopology generateUppaalTopology(ArrayList<CellNode> nodes) {
        UPPAALTopology result = new UPPAALTopology(nodes);
        for(int i = 0; i < nodes.size(); i++) {
            for(int j = 0; j < nodes.size(); j++){
                if(i != j && isInRange(nodes.get(i), nodes.get(j))){
                    result.add(new UPPAALEdge(String.valueOf(i), String.valueOf(j)));
                }
            }
        }
        return result;
    }
    public void setCellWidthInMeters(double cellWidthInMeters) {
        this.cellWidthInMeters = cellWidthInMeters;
    }

    public void setCellHeightInMeters(double cellHeightInMeters) {
        this.cellHeightInMeters = cellHeightInMeters;
    }

    public CellOptions getOptionsForCell(int x, int y) {
        return cellOptions[x][y];
    }
}
