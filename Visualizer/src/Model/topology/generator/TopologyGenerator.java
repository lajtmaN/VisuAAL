package Model.topology.generator;


import Helpers.Pair;
import Model.UPPAALEdge;
import Model.UPPAALTopology;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lajtman on 17-03-2017.
 */
public class TopologyGenerator {

    private GlobalOptions options;
    private CellOptions[][] cellOptions;

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
                ArrayList<CellNode> cellNodes = generateNodesForCell(xIndex, yIndex);
                for (CellNode node: cellNodes) {
                    node.setX(node.getX()+xIndex);
                    node.setY(node.getY()+yIndex);
                    result.add(node);
                }
            }
        }
        return result;
    }

    public ArrayList<CellNode> generateNodesForCell(int x, int y){
        Random rand = new Random();
        CellOptions cellOption = getOptionsForCell(x, y);
        int nodesInCell = (int)(Math.abs(rand.nextGaussian()*cellOption.getNodesCellDeviation())+cellOption.getAvgNodesPrCell());

        ArrayList<CellNode> result = new ArrayList<>();

        for(int i = 0; i < nodesInCell; i++){
            double range = Math.abs(rand.nextGaussian() * cellOption.getRangeDeviation()) + cellOption.getAvgRange();
            result.add(new CellNode(range, Math.random(), Math.random())); //New random for each number
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
        UPPAALTopology result = new UPPAALTopology(nodes.size());
        for(int i = 0; i < nodes.size(); i++) {
            for(int j = 0; j < nodes.size(); j++){
                if(i != j && isInRange(nodes.get(i), nodes.get(j))){
                    result.add(new UPPAALEdge(String.valueOf(i), String.valueOf(j)));
                }
            }
        }
        return result;
    }

    public CellOptions getOptionsForCell(int x, int y) {
        return cellOptions[x][y];
    }
}
