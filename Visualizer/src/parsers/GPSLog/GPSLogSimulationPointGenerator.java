package parsers.GPSLog;

import Model.SimulationEdgePoint;
import Model.SimulationPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 19-05-2017.
 */
public class GPSLogSimulationPointGenerator {

    private GPSLogNodes nodes;
    private List<SimulationEdgePoint> generatedPoints = new ArrayList<>();

    public GPSLogSimulationPointGenerator(GPSLogNodes nodes) {
        this.nodes = nodes;
    }

    public List<SimulationEdgePoint> generateRSSISimulationPoints() {
        if (generatedPoints.isEmpty())
            generate();
        return generatedPoints;
    }

    private void generate() {
        nodes.forEach(entry -> generateRSSIPointsForEntry(entry));
        generatedPoints.sort(SimulationPoint::compareTo);
        addPreviousValues();
    }

    private void generateRSSIPointsForEntry(GPSLogEntry entry) {
        entry.neighbors
                .forEach(neighbor ->
                        generateRSSIPointBetweenTwoNodes(entry.nodeId, neighbor.neighborNodeID, entry.timestamp, neighbor.rssi));
    }

    private void generateRSSIPointBetweenTwoNodes(int source, int destination, int timestamp, int value) {
        String identifier = String.format("OUTPUT_RSSI[%d][%d]", source, destination);
        SimulationEdgePoint point = new SimulationEdgePoint(identifier, timestamp, String.valueOf(source), String.valueOf(destination), value, 0);
        generatedPoints.add(point);
    }

    private void addPreviousValues() {
        for (int i = 0; i < generatedPoints.size(); i++) {
            double prevValue = generatedPoints.get(i >= 1 ? i-1 : i).getValue();
            generatedPoints.get(i).setPreviousValue(prevValue);
        }
    }
}
