package parsers;

import Model.SimulationMoveNodePoint;
import Model.TemplateUpdate;
import Model.topology.LatLng;
import Model.topology.LatLngBounds;
import org.junit.Test;
import parsers.GPSLog.*;

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
        GPSLogEntry actual = new GPSLogLineParser(line).parse();
        assertEquals(0, actual.timestamp);
        assertEquals(0, actual.nodeId);
        assertEquals(57.0109391, actual.location.lat, GPS_PRECISION);
        assertEquals(9.9945777,  actual.location.lng, GPS_PRECISION);
        assertEquals(1, actual.neighbors.size());
        assertEquals(1,(int) actual.neighbors.get(0)); //The int cast is just to tell compiler not to use object equals
    }

    @Test
    public void parseLineWithNoNeighbors() {
        String line = "0; 0; 57.0109391; 9.9945777; ";
        GPSLogEntry actual = new GPSLogLineParser(line).parse();
        assertEquals(0, actual.timestamp);
        assertEquals(0, actual.nodeId);
        assertEquals(57.0109391, actual.location.lat, GPS_PRECISION);
        assertEquals(9.9945777,  actual.location.lng, GPS_PRECISION);
        assertEquals(0, actual.neighbors.size());
    }

    @Test
    public void parseLineWithMultipleNeighbor() {
        String line = "0;9811          ; 50.16541871 ; 19.956117;1 2 3 4 54";
        GPSLogEntry actual = new GPSLogLineParser(line).parse();
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

    @Test
    public void parseCommentReturnsNull() {
        String line = "// this is a comment";
        assertTrue(new GPSLogLineParser(line).isComment());
        assertNull(new GPSLogLineParser(line).parse());
    }

    @Test
    public void GpsLogParserCanParseLine() {
        String line = "5; 0; 57.0109391; 9.9945777; 1";
        GPSLogEntry expected = new GPSLogLineParser(line).parse();
        GPSLogEntry actual = GPSLogParser.parseGPSLogLine(line);
        assertEquals("Timestamp", expected.timestamp, actual.timestamp);
        assertEquals("Node ID", expected.nodeId, actual.nodeId);
        assertEquals("GPS Lat", expected.location.lat, actual.location.lat, GPS_PRECISION);
        assertEquals("GPS Lng", expected.location.lng, actual.location.lng, GPS_PRECISION);
        assertArrayEquals("Neighbor IDs", expected.neighbors.toArray(), actual.neighbors.toArray());
    }

    @Test
    public void canParseLocationWithNegativeValues() {
        String line = "9865; 0; 47.6097; -122.3331; 1";
        GPSLogEntry actual = new GPSLogLineParser(line).parse();
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
        nodes.add(new GPSLogEntry(0,0, new LatLng(1.13, 5.121), null));
        nodes.add(new GPSLogEntry(0,1, new LatLng(5.54, 3.154), null));
        nodes.add(new GPSLogEntry(0,2, new LatLng(2.52, 4.56), null));
        nodes.add(new GPSLogEntry(0,3, new LatLng(3.934, 2.12), null));

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

        GPSLogNode pointsForNode0 = loadedNodes.getNode(0);
        assertEquals(1, pointsForNode0.size());
        GPSLogEntry node0 = pointsForNode0.get(0);
        assertEquals(0, node0.timestamp);
        assertEquals(0, node0.nodeId);
        assertEquals(57.0109391, node0.location.lat, GPS_PRECISION);
        assertEquals(9.9945777, node0.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node0, 1);

        GPSLogNode pointsForNode1 = loadedNodes.getNode(1);
        assertEquals(1, pointsForNode1.size());
        GPSLogEntry node1 = pointsForNode1.get(0);
        assertEquals(0, node1.timestamp);
        assertEquals(1, node1.nodeId);
        assertEquals(57.0112724, node1.location.lat, GPS_PRECISION);
        assertEquals(9.9959301, node1.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node1, 0, 2);

        GPSLogNode pointsForNode2 = loadedNodes.getNode(2);
        assertEquals(1, pointsForNode2.size());
        GPSLogEntry node2 = pointsForNode2.get(0);
        assertEquals(0, node2.timestamp);
        assertEquals(2, node2.nodeId);
        assertEquals(57.0122048, node2.location.lat, GPS_PRECISION);
        assertEquals(9.9920329, node2.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node2, 1);
    }

    @Test
    public void generateTemplateUpdatesFromGPSLog() throws IOException {
        File exampleLogFile = new File("test_resources/gpslog.txt");
        GPSLogNodes loadedNodes = GPSLogParser.parse(exampleLogFile);
        List<TemplateUpdate> updates = loadedNodes.getTopologyChanges();
        assertEquals(4, updates.size());

        TemplateUpdate expected1 = new TemplateUpdate("CONFIG_connected[0][1]", "1", 0);
        TemplateUpdate expected2 = new TemplateUpdate("CONFIG_connected[1][0]", "1", 0);
        TemplateUpdate expected3 = new TemplateUpdate("CONFIG_connected[1][2]", "1", 0);
        TemplateUpdate expected4 = new TemplateUpdate("CONFIG_connected[2][1]", "1", 0);

        assertTrue(expected1.getVariableName(), updates.contains(expected1));
        assertTrue(expected2.getVariableName(), updates.contains(expected2));
        assertTrue(expected3.getVariableName(), updates.contains(expected3));
        assertTrue(expected4.getVariableName(), updates.contains(expected4));
    }

    @Test
    public void generateTemplateUpdatesFromGPSLogWithChangingTopology() throws IOException {
        File exampleLogFile = new File("test_resources/gpslog_with_updates.txt");
        GPSLogNodes loadedNodes = GPSLogParser.parse(exampleLogFile);
        List<TemplateUpdate> updates = loadedNodes.getTopologyChanges();
        assertEquals(8, updates.size());

        TemplateUpdate expected1 = new TemplateUpdate("CONFIG_connected[0][1]", "1", 0);
        TemplateUpdate expected2 = new TemplateUpdate("CONFIG_connected[1][0]", "1", 0);
        TemplateUpdate expected3 = new TemplateUpdate("CONFIG_connected[1][2]", "1", 0);
        TemplateUpdate expected4 = new TemplateUpdate("CONFIG_connected[2][1]", "1", 0);
        TemplateUpdate expected5 = new TemplateUpdate("CONFIG_connected[1][2]", "0", 8);
        TemplateUpdate expected6 = new TemplateUpdate("CONFIG_connected[2][1]", "0", 8);
        TemplateUpdate expected7 = new TemplateUpdate("CONFIG_connected[0][1]", "0", 10);
        TemplateUpdate expected8 = new TemplateUpdate("CONFIG_connected[1][0]", "0", 10);

        assertTrue(expected1.getVariableName(), updates.contains(expected1));
        assertTrue(expected2.getVariableName(), updates.contains(expected2));
        assertTrue(expected3.getVariableName(), updates.contains(expected3));
        assertTrue(expected4.getVariableName(), updates.contains(expected4));
        assertTrue(expected5.getVariableName(), updates.contains(expected5));
        assertTrue(expected6.getVariableName(), updates.contains(expected6));
        assertTrue(expected7.getVariableName(), updates.contains(expected7));
        assertTrue(expected8.getVariableName(), updates.contains(expected8));
    }

    @Test
    public void generateSimulationMoveNodePoints() throws Exception {
        File exampleLogFile = new File("test_resources/gpslog_with_updates.txt");
        GPSLogNodes loadedNodes = GPSLogParser.parse(exampleLogFile);
        List<SimulationMoveNodePoint> points = loadedNodes.generateSimulationMoveNodePoints();

        assertEquals(9, points.size());

        assertEquals("0", points.get(1).getIdentifier());
        assertEquals(455.8122801035139, points.get(1).getPreviousPointValue().x, 0.001);
        assertEquals(267.3237231461489, points.get(1).getPreviousPointValue().y, 0.001);

        assertEquals("1", points.get(4).getIdentifier());
        assertEquals(602.9260664248344, points.get(4).getPointValue().x, 0.001);
        assertEquals(435.8841124467606, points.get(4).getPointValue().y, 0.001);

        assertEquals("2", points.get(8).getIdentifier());
        assertEquals(0, points.get(8).getPointValue().x, 0.001);
        assertEquals(587.776382242929, points.get(8).getPointValue().y, 0.001);
    }

    private void assertContainsNeighbors(GPSLogEntry node, Integer... neighbors) {
        for (Integer neighbor : neighbors)
            assertTrue(node.neighbors.contains(neighbor));
    }
}
