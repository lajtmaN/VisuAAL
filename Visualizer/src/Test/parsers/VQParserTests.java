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
        assertEquals(-5, vqExpression.getFirstGradient(), 0.1);
        assertEquals(15, vqExpression.getSecondGradient(), 0.1);

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 5.);
        map.put("y", 10.);

        double gradient = vqExpression.getResultFromVQ(map);
        assertEquals(2.0, gradient, 0.1);
    }

    @Test
    public void gradientTest() throws Exception {
        String input = "[red:0, blue:4] x - 3 * 2 / (y - 8)";

        VQExpression vqExpression = VQParse.parseVQ(input);

        assertEquals("red", vqExpression.getFirstColor());
        assertEquals("blue", vqExpression.getSecondColor());
        assertEquals(0, vqExpression.getFirstGradient(), 0.1);
        assertEquals(4, vqExpression.getSecondGradient(), 0.1);

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 5.);
        map.put("y", 10.);

        double gradient = vqExpression.getGradient(map);
        assertEquals(0.5, gradient, 0.1);
    }
}