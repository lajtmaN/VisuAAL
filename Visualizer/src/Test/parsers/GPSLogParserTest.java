package parsers;

import org.junit.Test;
import parsers.GPSLog.GPSLogLineParser;
import parsers.GPSLog.GPSLogParser;
import parsers.GPSLog.SeedNode;
import java.io.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogParserTest {

    private final double GPS_PRECISION = 0.000001;

    @Test
    public void parseLineWithOneNeighbor() {
        String line = "0; 57.0109391; 9.9945777; 1";
        SeedNode actual = new GPSLogLineParser(line).parse();
        assertEquals(0, actual.nodeId);
        assertEquals(57.0109391, actual.location.lat, GPS_PRECISION);
        assertEquals(9.9945777,  actual.location.lng, GPS_PRECISION);
        assertEquals(1, actual.neighbors.size());
        assertEquals(1,(int) actual.neighbors.get(0)); //The int cast is just to tell compiler not to use object equals
    }

    @Test
    public void parseLineWithMultipleNeighbor() {
        String line = "9811          ; 50.16541871 ; 19.956117;1 2 3 4 54";
        SeedNode actual = new GPSLogLineParser(line).parse();
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
        String line = "0.1; 57.0109391; 9.9945777; 1";
        new GPSLogLineParser(line).parse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwOnUnfinishedLine() {
        String line = "0; 1.2; 1";
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
        String line = "0; 57.0109391; 9.9945777; 1";
        SeedNode expected = new GPSLogLineParser(line).parse();
        SeedNode actual = GPSLogParser.parseGPSLogLine(line);
        assertEquals("Node ID", expected.nodeId, actual.nodeId);
        assertEquals("GPS Lat", expected.location.lat, actual.location.lat, GPS_PRECISION);
        assertEquals("GPS Lng", expected.location.lng, actual.location.lng, GPS_PRECISION);
        assertArrayEquals("Neighbor IDs", expected.neighbors.toArray(), actual.neighbors.toArray());
    }

    @Test
    public void canParseMultipleRows() throws IOException {
        File exampleLogFile = new File("test_resources/gpslog.log");
        List<SeedNode> loadedNodes = GPSLogParser.parse(exampleLogFile);

        SeedNode node0 = loadedNodes.get(0);
        assertEquals(0, node0.nodeId);
        assertEquals(57.0109391, node0.location.lat, GPS_PRECISION);
        assertEquals(9.9945777, node0.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node0, 1);

        SeedNode node1 = loadedNodes.get(1);
        assertEquals(1, node1.nodeId);
        assertEquals(57.0112724, node1.location.lat, GPS_PRECISION);
        assertEquals(9.9959301, node1.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node1, 0, 2);

        SeedNode node2 = loadedNodes.get(2);
        assertEquals(2, node2.nodeId);
        assertEquals(57.0122048, node2.location.lat, GPS_PRECISION);
        assertEquals(9.9920329, node2.location.lng, GPS_PRECISION);
        assertContainsNeighbors(node2, 1);
    }

    private void assertContainsNeighbors(SeedNode node, Integer... neighbors) {
        for (Integer neighbor : neighbors)
            assertTrue(node.neighbors.contains(neighbor));
    }
}
