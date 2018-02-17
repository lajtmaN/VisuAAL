package parsers.GPSLog;

import Helpers.Pair;
import Model.TemplateUpdate;

import java.util.*;
import java.util.function.Function;

/**
 * Created by lajtman on 01-05-2017.
 */
public class GPSLogNode extends ArrayList<GPSLogEntry> {

    private int nodeId;
    private boolean isSorted = true;

    public GPSLogNode(int nodeId) {
        this.nodeId = nodeId;
    }

    @Override
    public boolean add(GPSLogEntry gpsLogEntry) {
        if (nodeId != gpsLogEntry.nodeId)
            throw new IllegalArgumentException("Cannot add that GPS Log Entry. The node id does not match.");

        isSorted = false;
        return super.add(gpsLogEntry);
    }

    public double min(Function<GPSLogEntry, Number> mapper) {
        double minScore = Double.MAX_VALUE;
        for (GPSLogEntry node : this) {
            if (mapper.apply(node).doubleValue() < minScore)
                minScore = mapper.apply(node).doubleValue();
        }
        return minScore;
    }

    public double max(Function<GPSLogEntry, Number> mapper) {
        double maxScore = Double.MIN_VALUE;
        for (GPSLogEntry node : this) {
            if (mapper.apply(node).doubleValue() > maxScore)
                maxScore = mapper.apply(node).doubleValue();
        }
        return maxScore;
    }

    @Override
    public void sort(Comparator<? super GPSLogEntry> c) {
        if (!isSorted)
            super.sort(c);
        isSorted = true;
    }

    public GPSLogEntry first() {
        this.sort(GPSLogEntry::compareTo);
        return this.get(0);
    }

    public List<TemplateUpdate> calculateTopologyChanges() {
        this.sort(GPSLogEntry::compareTo);

        List<TemplateUpdate> updates = new ArrayList<>();
        List<Integer> currentNeighborIds = new ArrayList<>();
        for (GPSLogEntry entry : this) {
            List<Pair<Integer, String>> neighborUpdates = newNeighborConnections(entry, currentNeighborIds);
            for (Pair<Integer, String> p : neighborUpdates) {
                String variableName = String.format("CONFIG_connected[%d][%d]", this.nodeId, p.getFirst());
                updates.add(new TemplateUpdate(variableName, p.getSecond(), entry.timestamp));
            }
            currentNeighborIds = entry.neighborNodeIds();
        }
        return updates;
    }

    private List<Pair<Integer, String>> newNeighborConnections(GPSLogEntry entry, List<Integer> lastTimeNeighbors) {
        List<Pair<Integer, String>> neighborsToUpdate = new ArrayList<>();

        for(Integer curNeighbor : entry.neighborNodeIds()) {
            if (!lastTimeNeighbors.contains(curNeighbor))
                neighborsToUpdate.add(new Pair<>(curNeighbor, "1"));
        }
        for (int lastNeighbor : lastTimeNeighbors) {
            if (!entry.neighborNodeIds().contains(lastNeighbor))
                neighborsToUpdate.add(new Pair<>(lastNeighbor, "0"));
        }

        return neighborsToUpdate;
    }

    public List<Integer> getAllNeighborsOverTime() {
        List<Integer> neigborIds = new ArrayList<>();
        for (GPSLogEntry e: this) {
            neigborIds.addAll(e.neighborNodeIds());
        }
        return neigborIds;
    }
}
