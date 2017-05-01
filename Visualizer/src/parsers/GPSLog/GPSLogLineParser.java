package parsers.GPSLog;

import Model.topology.LatLng;
import parsers.RegexHelper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogLineParser {
    private String gpsLogLine;
    private String[] gpsLogLineParts;

    private int timestamp;
    private int nodeId;
    private LatLng gpsLocation;
    private List<Integer> neighbors;

    public GPSLogLineParser(String gpsLogLine) {
        this.gpsLogLine = gpsLogLine;
    }

    public GPSLogEntry parse() throws IllegalArgumentException {
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

        if (gpsLogLineParts.length != 5)
            throw new IllegalArgumentException("Expected each line to contain 4 ;, but only got '" + (gpsLogLineParts.length - 1) + "'");
    }

    private void parseEachSectionInGpsLogLine() throws IllegalArgumentException {
        parseTimestamp();
        parseNodeId();
        parseGpsLocation();
        parseNeighbors();
    }

    private GPSLogEntry createSeedNodeObject() {
        return new GPSLogEntry(timestamp, nodeId, gpsLocation, neighbors);
    }

    private void parseTimestamp() {
        String rawText = gpsLogLineParts[0];
        if (!RegexHelper.isValidInt(rawText))
            throw new IllegalArgumentException("Expected a timestamp in Integer, but got '" + rawText + "'");

        this.timestamp = Integer.parseInt(rawText);
    }

    private void parseNodeId() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[1];
        if (!RegexHelper.isValidInt(rawText))
            throw new IllegalArgumentException("Expected a node id in Integer, but got '" + rawText + "'");

        this.nodeId = Integer.parseInt(rawText);
    }

    private void parseGpsLocation() {
        this.gpsLocation = new LatLng();
        parseGpsLatitude();
        parseGpsLongitude();
    }

    private void parseGpsLatitude() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[2];
        if (!RegexHelper.isValidDouble(rawText))
            throw new IllegalArgumentException("Expected a GPS Latitude in Double, but got '" + rawText + "'");

        this.gpsLocation.lat = Double.parseDouble(rawText);
    }

    private void parseGpsLongitude() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[3];
        if (!RegexHelper.isValidDouble(rawText))
            throw new IllegalArgumentException("Expected a node id in Integer, but got " + rawText);

        this.gpsLocation.lng = Double.parseDouble(rawText);
    }

    private void parseNeighbors() throws IllegalArgumentException {
        String rawText = gpsLogLineParts[4];
        String[] neighborIds = rawText.split("\\s+");
        this.neighbors = Arrays.stream(neighborIds).map(this::parseNeighbor).collect(Collectors.toList());
    }

    private int parseNeighbor(String neighborId) {
        if (!RegexHelper.isValidInt(neighborId))
            throw new IllegalArgumentException("Expected a node id as Integer in the neighbor list, but got '" + neighborId + "'");

        return Integer.parseInt(neighborId);
    }
}
