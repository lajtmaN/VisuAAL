package parsers.GPSLog;

import Model.topology.LatLng;
import parsers.RegexHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogLineParser {
    private String gpsLogLine;
    private String[] gpsLogLineParts;

    private int nodeId;
    private LatLng gpsLocation;
    private List<Integer> neighbors;

    public GPSLogLineParser(String gpsLogLine) {
        this.gpsLogLine = gpsLogLine;
    }

    public SeedNode parse() throws IllegalArgumentException {
        if (isComment())
            return null;

        splitLineInParts();
        parseEachSectionInGpsLogLine();
        return createSeedNodeObject();
    }

    public boolean isComment() {
        return gpsLogLine.startsWith("//");
    }

    private void splitLineInParts() throws IllegalArgumentException {
        String regexWhichSplitsOnSemicolonAndRemovesWhiteSpace = "\\s*;\\s*";
        this.gpsLogLineParts = gpsLogLine.trim().split(regexWhichSplitsOnSemicolonAndRemovesWhiteSpace);

        if (gpsLogLineParts.length != 4)
            throw new IllegalArgumentException("Expected each line to contain 3 ;, but only got '" + (gpsLogLineParts.length - 1) + "'");
    }

    private void parseEachSectionInGpsLogLine() throws IllegalArgumentException {
        parseNodeId();
        parseGpsLocation();
        parseNeighbors();
    }

    private SeedNode createSeedNodeObject() {
        return new SeedNode(nodeId, gpsLocation, neighbors);
    }

    private void parseNodeId() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[0];
        if (!RegexHelper.isValidInt(rawText))
            throw new IllegalArgumentException("Expected a node id in Integer, but got '" + rawText + "'");

        this.nodeId = Integer.parseInt(rawText);
    }

    private void parseGpsLocation() {
        this.gpsLocation = new LatLng();
        parseGpsLatitude();
        parseGpsLongitude();
    }

    private void parseNeighbors() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[3];
        String[] neighborIds = rawText.split("\\s+");
        List<Integer> neighbors = new ArrayList<>(neighborIds.length);
        for (String neighbor : neighborIds) {
            if (!RegexHelper.isValidInt(neighbor))
                throw new IllegalArgumentException("Expected a node id as Integer in the neighbor list, but got '" + neighbor + "'");

            neighbors.add(Integer.parseInt(neighbor));
        }
        this.neighbors = neighbors;
    }

    private void parseGpsLatitude() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[1];
        if (!RegexHelper.isValidDouble(rawText))
            throw new IllegalArgumentException("Expected a GPS Latitude in Double, but got '" + rawText + "'");

        this.gpsLocation.lat = Double.parseDouble(rawText);
    }

    private void parseGpsLongitude() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[2];
        if (!RegexHelper.isValidDouble(rawText))
            throw new IllegalArgumentException("Expected a node id in Integer, but got " + rawText);

        this.gpsLocation.lng = Double.parseDouble(rawText);
    }
}
