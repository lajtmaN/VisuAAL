package parsers.GPSLog;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by lajtman on 01-05-2017.
 */
public class GPSLogNode extends ArrayList<GPSLogEntry> {

    public double min(Function<GPSLogEntry, Double> mapper) {
        double minScore = Double.MAX_VALUE;
        for (GPSLogEntry node : this) {
            if (mapper.apply(node) < minScore)
                minScore = mapper.apply(node);
        }
        return minScore;
    }

    public double max(Function<GPSLogEntry, Double> mapper) {
        double maxScore = Double.MIN_VALUE;
        for (GPSLogEntry node : this) {
            if (mapper.apply(node) > maxScore)
                maxScore = mapper.apply(node);
        }
        return maxScore;
    }
}
