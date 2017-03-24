package parsers.Declaration;

import Model.UPPAALProcess;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rasmu on 24/03/2017.
 */
public class ProcessInstantiationReaderTests {
    @Test
    public void testGetQueryRepresentationInstantiated() {
        //node = Node(0);
        //system node;
        UPPAALProcess up = new UPPAALProcess("Node", "node", "0");
        assertEquals("node",up.getProcessQueryIdentifier());
    }

    @Test
    public void testGetQueryRepresentationNonInstantiated() {
        //Template Node - No parameters
        //system Node;
        UPPAALProcess up = new UPPAALProcess("Node", null, null);
        assertEquals("Node", up.getProcessQueryIdentifier());
    }

    @Test
    public void testGetQueryRepresentationNonInstantiatedParameters() {
        //Template Node - parameter int[0,0]
        //system Node;
        UPPAALProcess up = new UPPAALProcess("Node", null, "0");
        assertEquals("Node(0)",up.getProcessQueryIdentifier());
    }
}
