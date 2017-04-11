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

    @Test
    public void intGradient() throws Exception {
        String input = "[red:2, blue:6] y * y - (x + x)";

        VQExpression vqExpression = VQParse.parseVQ(input);

        HashMap<String, Double> map = new HashMap<>();
        map.put("y", 2.);
        map.put("x", 0.5);

        double gradient = vqExpression.getGradient(map);
        assertEquals(0.25, gradient, 0.01);
    }

    @Test
    public void intGradientNegative() throws Exception {
        String input = "[red:-2, blue:6] y * y - (x + x)";

        VQExpression vqExpression = VQParse.parseVQ(input);

        HashMap<String, Double> map = new HashMap<>();
        map.put("y", 3.);
        map.put("x", 5.);

        double gradient = vqExpression.getGradient(map);
        assertEquals(0.125, gradient, 0.01);
    }

    @Test
    public void intGradientDoubleNegative() throws Exception {
        String input = "[red:-10, blue:-6] x / y - --z";

        VQExpression vqExpression = VQParse.parseVQ(input);

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);
        map.put("z", 11.);

        double gradient = vqExpression.getGradient(map);
        assertEquals(0.25, gradient, 0.01);
    }

    @Test
    public void above1Gradient() throws Exception {
        String input = "[red:6, blue:10] 12";

        VQExpression vqExpression = VQParse.parseVQ(input);

        HashMap<String, Double> map = new HashMap<>();

        double gradient = vqExpression.getGradient(map);
        assertEquals(1, gradient, 0.01);
    }

    @Test
    public void belowZeroGradient() throws Exception {
        String input = "[red:6, blue:10] 4";

        VQExpression vqExpression = VQParse.parseVQ(input);

        HashMap<String, Double> map = new HashMap<>();

        double gradient = vqExpression.getGradient(map);
        assertEquals(0, gradient, 0.01);
    }

    @Test(expected = Exception.class)
    public void gradientException() throws Exception {
        String input = "[red:10, blue:-6] x / y - --z";
        VQExpression vqExpression = VQParse.parseVQ(input);
    }

    @Test(expected = Exception.class)
    public void valueMissingException() throws Exception {
        String input = "[red:-10, blue:-6] x / y - --z";

        VQExpression vqExpression = VQParse.parseVQ(input);

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);
        double gradient = vqExpression.getGradient(map);
    }
}