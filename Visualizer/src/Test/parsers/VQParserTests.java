package parsers;

import Model.VQ.VQParseTree;
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
        String input = "[red:0, blue:4] x - 3 * 2 / (y - 8)";


        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 5.);
        map.put("y", 10.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals("red", tree.getFirstColor());
        assertEquals("blue", tree.getSecondColor());
        assertEquals(0, tree.getFirstGradient(), 0.1);
        assertEquals(4, tree.getSecondGradient(), 0.1);

        assertEquals(0.5, gradient, 0.1);
    }

    @Test
    public void intGradient() throws Exception {
        String input = "[red:2, blue:6] y * y - (x + x)";

        HashMap<String, Double> map = new HashMap<>();
        map.put("y", 2.);
        map.put("x", 0.5);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(0.25, gradient, 0.01);
    }

    @Test
    public void intGradientNegative() throws Exception {
        String input = "[red:-2, blue:6] y * y - (x + x)";

        HashMap<String, Double> map = new HashMap<>();
        map.put("y", 3.);
        map.put("x", 5.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(0.125, gradient, 0.01);
    }

    @Test
    public void intGradientDoubleNegative() throws Exception {
        String input = "[red:-10, blue:-6] x / y - --z";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);
        map.put("z", 11.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(0.25, gradient, 0.01);
    }

    @Test
    public void above1Gradient() throws Exception {
        String input = "[red:6, blue:10] 12";

        HashMap<String, Double> map = new HashMap<>();

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(1, gradient, 0.01);
    }

    @Test
    public void belowZeroGradient() throws Exception {
        String input = "[red:6, blue:10] 4";

        HashMap<String, Double> map = new HashMap<>();

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(0, gradient, 0.01);
    }

    @Test(expected = Exception.class)
    public void gradientException() throws Exception {
        String input = "[red:10, blue:-6] 3";
        HashMap<String, Double> map = new HashMap<>();
        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);
    }

    @Test(expected = Exception.class)
    public void valueMissingException() throws Exception {
        String input = "[red:-10, blue:-6] x / y - --z";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);
    }

    @Test
    public void boolSimpleFalse() throws Exception {
        String input = "[green, gray] x < y";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals("green", tree.getFirstColor());
        assertEquals("gray", tree.getSecondColor());
        assertEquals(0, tree.getFirstGradient(), 0.1);
        assertEquals(1, tree.getSecondGradient(), 0.1);

        assertEquals(0., gradient, 0.01);
    }

    @Test
    public void boolSimpleTrue() throws Exception {
        String input = "[green, gray] x > y";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(1., gradient, 0.01);
    }

    @Test
    public void boolNotXEqualY() throws Exception {
        String input = "[green, gray] !!x && (y || z)";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 1.0);
        map.put("y", 1.0);
        map.put("z", 0.0);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(1., gradient, 0.01);
    }

    @Test
    public void allTheNumbers() throws Exception {
        String input = "[green:-30, gray:0] k * (m - 23) + a / 20 * 2 - -k";

        HashMap<String, Double> map = new HashMap<>();
        map.put("a", 200.);
        map.put("m", 25.);
        map.put("k", -10.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(0.166666, gradient, 0.01);
    }

    @Test
    public void alltheBooleansAndNumbers() throws Exception {
        String input = "[green, gray] k > m && (23 * k) < m || a >= 2";

        HashMap<String, Double> map = new HashMap<>();
        map.put("a", 200.);
        map.put("m", 25.);
        map.put("k", -10.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(1, gradient, 0.01);
    }

    @Test
    public void booleanPrecedenceTest() throws Exception {
        String input = "[green, gray] 23 >= 2 && !0 || false";

        HashMap<String, Double> map = new HashMap<>();

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(1, gradient, 0.01);
    }

    @Test
    public void scopeTest() throws Exception {
        String input = "[green:-2, gray:6] a.b + x";

        HashMap<String, Double> map = new HashMap<>();
        map.put("a.b", 1.);
        map.put("x", 3.);

        VQParseTree tree = VQParse.parseVQ(input, map);
        double gradient = tree.getGradient(map);

        assertEquals(0.75, gradient, 0.01);
    }
}