package parsers;

import Model.topology.LatLng;
import Model.topology.LatLngBounds;
import org.junit.Test;
import parsers.GPSLog.GPSLogLineParser;
import parsers.GPSLog.GPSLogParser;
import parsers.GPSLog.GPSLogNode;
import parsers.GPSLog.GPSLogNodes;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogParserTest {

    private final double GPS_PRECISION = 0.000001;

    @Test
    public void parseLineWithOneNeighbor() {
        String line = "0; 0; 57.0109391; 9.9945777; 1";
        GPSLogNode actual = new GPSLogLineParser(line).parse();
        assertEquals(0, actual.timestamp);
        assertEquals(0, actual.nodeId);
        assertEquals(57.0109391, actual.location.lat, GPS_PRECISION);
        assertEquals(9.9945777,  actual.location.lng, GPS_PRECISION);
        assertEquals(1, actual.neighbors.size());
        assertEquals(1,(int) actual.neighbors.get(0)); //The int cast is just to tell compiler not to use object equals
    }

    @Test
    public void parseLineWithMultipleNeighbor() {
        String line = "0;9811          ; 50.16541871 ; 19.956117;1 2 3 4 54";
        GPSLogNode actual = new GPSLogLineParser(line).parse();
        assertEquals(0, actual.timestamp);
        assertEquals(9811, actual.nodeId);
        assertEquals(50.16541871, actual.location.lat, GPS_PRECISION);
        assertEquals(19.956117,  actual.location.lng, GPS_PRECISION);
        assertEquals(5, actual.neighbors.size());
        assertEquals(1,(int) actual.neighbors.get(0));
        assertEquals(2,(int) actual.neighbors.get(1));
        assertEquals(3,(int) actual.neighbors.get(2));
        assertEquals(4,(int) actual.neighbors.get(3));
        assertEquals(54,(int) actual.neighbors.get(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotParseDoubleNodeId() {
        String line = "0; 0.1; 57.0109391; 9.9945777; 1";
        new GPSLogLineParser(line).parse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwOnUnfinishedLine() {
        String line = "3120; 0; 1.2; 1";
        new GPSLogLineParser(line).parse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwOnMultipleDefinedNode() {
        List<String> lines = Arrays.asList(
                "4; 0; 1.11; 2.22; 1",
                "5; 0; 3.33; 4.44; 1"
        );
        GPSLogParser.parseGPSLogLines(lines);
    }

    @Test
    public void parseCommentReturnsNull() {
        String line = "// this is a comment";
        assertTrue(new GPSLogLineParser(line).isComment());
        assertNull(new GPSLogLineParser(line).parse());
    }

    @Test
    public void GpsLogParserCanParseLine() {
        String line = "5; 0; 57.0109391; 9.9945777; 1";
        GPSLogNode expected = new GPSLogLineParser(line).parse();
        GPSLogNode actual = GPSLogParser.parseGPSLogLine(line);
        assertEquals("Timestamp", expected.timestamp, actual.timestamp);
        assertEquals("Node ID", expected.nodeId, actual.nodeId);
        assertEquals("GPS Lat", expected.location.lat, actual.location.lat, GPS_PRECISION);
        assertEquals("GPS Lng", expected.location.lng, actual.location.lng, GPS_PRECISION);
        assertArrayEquals("Neighbor IDs", expected.neighbors.toArray(), actual.neighbors.toArray());
    }

    @Test
    public void canParseLocationWithNegativeValues() {
        String line = "9865; 0; 47.6097; -122.3331; 1";
        GPSLogNode actual = new GPSLogLineParser(line).parse();
        assertEquals(9865, actual.timestamp);
        assertEquals(0, actual.nodeId);
        assertEquals(47.6097, actual.location.lat, GPS_PRECISION);
        assertEquals(-122.3331,  actual.location.lng, GPS_PRECISION);
        assertEquals(1, actual.neighbors.size());
        assertEquals(1,(int) actual.neighbors.get(0)); //The int cast is just to tell compiler not to use object equals
    }

    @Test
    public void calculateBoundsInSeedNodes() throws Exception {
        GPSLogNodes nodes = new GPSLogNodes();
        nodes.add(new GPSLogNode(0,0, new LatLng(1.13, 5.121), null));
        nodes.add(new GPSLogNode(0,1, new LatLng(5.54, 3.154), null));
        nodes.add(new GPSLogNode(0,2, new LatLng(2.52, 4.56), null));
        nodes.add(new GPSLogNode(0,3, new LatLng(3.934, 2.12), null));

        LatLngBounds actual = nodes.getBounds();
        assertEquals("South", 1.13, actual.getSouthWest().lat, GPS_PRECISION);
        assertEquals("West", 2.12, actual.getSouthWest().lng, GPS_PRECISION);

        assertEquals("North", 5.54, actual.getNorthEast().lat, GPS_PRECISION);
        assertEquals("East", 5.121, actual.getNorthEast().lng, GPS_PRECISION);
    }

    @Test
    public void canParseMultipleRows() throws IOException {
        File exampleLogFile = new File("test_resources/gpslog.txt");
        GPSLogNodes loadedNodes = GPSLogParser.parse(exampleLogFile);

        GPSLogNode node0 = loadedNodes.getNode(0);
        assertEquals(0, node0.timestamp);
        assertEquals(0, node0.nodeId);
        assertEquals(57.0109391, node0.location.lat, GPS_PRECISION);
        assertEquals(9.9945777, node0.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node0, 1);

        GPSLogNode node1 = loadedNodes.getNode(1);
        assertEquals(0, node1.timestamp);
        assertEquals(1, node1.nodeId);
        assertEquals(57.0112724, node1.location.lat, GPS_PRECISION);
        assertEquals(9.9959301, node1.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node1, 0, 2);

        GPSLogNode node2 = loadedNodes.getNode(2);
        assertEquals(0, node2.timestamp);
        assertEquals(2, node2.nodeId);
        assertEquals(57.0122048, node2.location.lat, GPS_PRECISION);
        assertEquals(9.9920329, node2.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node2, 1);
    }

    private void assertContainsNeighbors(GPSLogNode node, Integer... neighbors) {
        for (Integer neighbor : neighbors)
            assertTrue(node.neighbors.contains(neighbor));
    }
}
