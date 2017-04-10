package parsers;

import Model.VQ.VQExpression;
import org.junit.Test;
import parsers.VQParser.VQParse;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQParserTests {
    @Test
    public void initialSimpleIntTest() throws Exception {
        String input = "[red:-5, blue:15] x - 3 * 2 / (y - 8)";

        VQExpression vqExpression = VQParse.parseVQ(input);

        assertEquals("red", vqExpression.getFirstColor());
        assertEquals("blue", vqExpression.getSecondColor());
        assertEquals(-5, vqExpression.getFirstGradient());
        assertEquals(15, vqExpression.getSecondGradient());

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 5.);
        map.put("y", 10.);

        double gradient = vqExpression.getGradientForNode(map);
        assertEquals(2.0, gradient, 0.1);
    }
}