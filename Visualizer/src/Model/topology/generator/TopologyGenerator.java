package Model.topology.generator;


import Helpers.GoogleMapsHelper;
import Helpers.MathHelpers;
import Helpers.Pair;
import Model.UPPAALEdge;
import Model.UPPAALTopology;
import Model.topology.LatLngBounds;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.LatLongBounds;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.ArrayList;
import java.util.List;
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

    public UPPAALTopology generateUppaalTopology() {
        return generateUppaalTopology(null);
    }

    public UPPAALTopology generateUppaalTopology(LatLngBounds bounds) {
        return generateUppaalTopology(bounds, null);
    }

    public UPPAALTopology generateUppaalTopology(LatLngBounds bounds, String backgroundImagePath) {
        if (bounds != null) {
            Pair<Double, Double> widthAndHeight = GoogleMapsHelper.calculateGridSizeInMeters(bounds);
            setCellWidthInMeters(widthAndHeight.getFirst() / getOptions().getCellX());
            setCellHeightInMeters(widthAndHeight.getSecond() / getOptions().getCellY());

        } else {
            setCellWidthInMeters(1);
            setCellHeightInMeters(1);
        }

        ArrayList<CellNode> nodes = generateNodes();
        return generateUppaalTopology(nodes, backgroundImagePath);
    }

    public UPPAALTopology generateUppaalTopology(List<CellNode> nodes, String backgroundImagePath) {
        UPPAALTopology result = new UPPAALTopology(nodes, backgroundImagePath);
        for(int i = 0; i < nodes.size(); i++) {
            for(int j = 0; j < nodes.size(); j++){
                if(i != j && nodes.get(i).isInRange(nodes.get(j))){
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
