package Simulation;

import Model.SimulationPoint;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by batto on 19-Apr-17.
 */
public class SimulationPointTests {
    @Test
    public void testScopedIdentifier() {
        SimulationPoint sp  = new SimulationPoint("Node(1).somevar[2]", 0, 0);
        assertEquals("Node.somevar", sp.getScopedIdentifier());

        sp  = new SimulationPoint("somevar", 0, 0);
        assertEquals("somevar", sp.getScopedIdentifier());

        sp  = new SimulationPoint("somevar[2]", 0, 0);
        assertEquals("somevar", sp.getScopedIdentifier());

        sp  = new SimulationPoint("Node(1).somevar", 0, 0);
        assertEquals("Node.somevar", sp.getScopedIdentifier());

        sp  = new SimulationPoint("Node[100].somevar[2124]", 0, 0);
        assertEquals("Node.somevar", sp.getScopedIdentifier());
    }
}
