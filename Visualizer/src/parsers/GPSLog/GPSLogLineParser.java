package parsers.GPSLog;

import Helpers.StringHelper;
import Model.topology.LatLng;
import parsers.RegexHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogLineParser {
    private String gpsLogLine;
    private String[] gpsLogLineParts;

    private int timestamp;
    private int nodeId;
    private LatLng gpsLocation;
    private List<GPSLogNeighbor> neighbors;

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
        int numOfSeparators = StringHelper.countOccurrences(gpsLogLine, ';');
        if (numOfSeparators != 4)
            throw new IllegalArgumentException("Expected each line to contain 4 ;, but only got '" + numOfSeparators + "'");

        String regexWhichSplitsOnSemicolonAndRemovesWhiteSpace = "\\s*;\\s*";
        this.gpsLogLineParts = gpsLogLine.trim().split(regexWhichSplitsOnSemicolonAndRemovesWhiteSpace);
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
        this.neighbors = new ArrayList<>();
        if (gpsLogLineParts.length < 5)
            return;

        String rawText = gpsLogLineParts[4];
        assertAllNeighborsGotRSSI(rawText);
        parseNeighborPairs(rawText);
        removeMyselfFromNeighborList();
    }

    private void assertAllNeighborsGotRSSI(String rawText) {
        String[] splitted = rawText.split("\\s+");
        if (splitted.length % 2 != 0)
            throw new IllegalArgumentException("Could not assume a RSSI for all neighbors");
    }

    private void parseNeighborPairs(String allRelationsFromLogFile) {
        String neighborRssiPairRegex = "(\\d+) (-?\\d+)";
        Matcher matcher = Pattern.compile(neighborRssiPairRegex).matcher(allRelationsFromLogFile);
        while (matcher.find()) {
            String neighborId = matcher.group(1);
            String rssi = matcher.group(2);
            AddNeighbor(parseNeighbor(neighborId, rssi));
        }
    }

    private void removeMyselfFromNeighborList() {
        this.neighbors.removeIf(n -> n.neighborNodeID == this.nodeId);
    }

    private void AddNeighbor(GPSLogNeighbor newGpsLogNeighbor) {
        this.neighbors.removeIf(n -> n.neighborNodeID == newGpsLogNeighbor.neighborNodeID);
        this.neighbors.add(newGpsLogNeighbor);
    }

    private GPSLogNeighbor parseNeighbor(String neighborId, String rssi) {
        if (!RegexHelper.isValidInt(neighborId))
            throw new IllegalArgumentException("Expected a node id as Integer in the neighbor list, but got '" + neighborId + "'");
        if (!RegexHelper.isValidInt(rssi))
            throw new IllegalArgumentException("Expected a neighbor rssi as Integer, but got '" + rssi + "'");

        Integer parsedNodeId = Integer.parseInt(neighborId);
        Integer parsedRssi = Integer.parseInt(rssi);

        return new GPSLogNeighbor(parsedNodeId, parsedRssi);
    }
}
