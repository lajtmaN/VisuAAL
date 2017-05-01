package parsers;
import Model.Point;
import Model.topology.LatLng;
import Model.topology.LatLngBounds;
import com.lynden.gmapsfx.javascript.object.LatLongBounds;
import org.junit.Test;
import parsers.GPSLog.GPSLogEntry;
import parsers.GPSLog.GPSLogNode;
import parsers.GPSLog.GPSLogNodes;
import parsers.GPSLog.NodeToLocationMapper;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by batto on 01-May-17.
 */
public class NodeLocationMapperTest {
    @Test
    public void findLocationFor3Nodes() throws Exception {
        GPSLogNodes gpsLogNodes = new GPSLogNodes();
        gpsLogNodes.add(new GPSLogEntry(0, 0, new LatLng(1.5, 1.7), new ArrayList<>()));
        gpsLogNodes.add(new GPSLogEntry(5000, 0, new LatLng(2.5, 2.7), new ArrayList<>()));
        gpsLogNodes.add(new GPSLogEntry(10000, 0, new LatLng(3.5, 3.7), new ArrayList<>()));

        NodeToLocationMapper nodeToLocationMapper =
                new NodeToLocationMapper(gpsLogNodes.getNode(0), gpsLogNodes.getBounds());

        Point p1 = nodeToLocationMapper.getLocationAtTime(2500);

        assertEquals(0.0, p1.x, 0.01);
        assertEquals(0.0, p1.y, 0.01);
    }
}
