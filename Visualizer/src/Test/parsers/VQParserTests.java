package parsers;

import Model.OutputVariable;
import Model.VQ.VQParseTree;
import org.junit.Test;
import parsers.VQParser.VQParse;

import java.util.*;

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

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
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

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0.25, gradient, 0.01);
    }

    @Test
    public void intGradientNegative() throws Exception {
        String input = "[red:-2, blue:6] y * y - (x + x)";

        HashMap<String, Double> map = new HashMap<>();
        map.put("y", 3.);
        map.put("x", 5.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
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

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0.25, gradient, 0.01);
    }

    @Test
    public void above1Gradient() throws Exception {
        String input = "[red:6, blue:10] 12";

        HashMap<String, Double> map = new HashMap<>();

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(1, gradient, 0.01);
    }

    @Test
    public void belowZeroGradient() throws Exception {
        String input = "[red:6, blue:10] 4";

        HashMap<String, Double> map = new HashMap<>();

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0, gradient, 0.01);
    }

    @Test(expected = Exception.class)
    public void gradientException() throws Exception {
        String input = "[red:10, blue:-6] 3";
        HashMap<String, Double> map = new HashMap<>();
        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);
    }

    @Test(expected = Exception.class)
    public void valueMissingException() throws Exception {
        String input = "[red:-10, blue:-6] x / y - --z";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);
    }

    @Test
    public void boolSimpleFalse() throws Exception {
        String input = "[green, gray] x < y";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 8.);
        map.put("y", 4.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
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

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
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

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
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

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0.666, gradient, 0.01);
    }

    @Test
    public void alltheBooleansAndNumbers() throws Exception {
        String input = "[green, gray] k > m && (23 * k) < m || a >= 2";

        HashMap<String, Double> map = new HashMap<>();
        map.put("a", 200.);
        map.put("m", 25.);
        map.put("k", -10.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(1, gradient, 0.01);
    }

    @Test
    public void booleanPrecedenceTest() throws Exception {
        String input = "[green, gray] 23 >= 2 && !0 || false";

        HashMap<String, Double> map = new HashMap<>();

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(1, gradient, 0.01);
    }

    @Test
    public void doNotThrowExceptionOnInvalidSyntax() throws Exception {
        List<String> vars = new ArrayList<>();
        vars.add("test");
        VQParseTree tree = VQParse.syntaxCheck("[g,", vars);
        assertFalse(tree.isValid());
        assertTrue(tree.getParseError().contains("Could not parse second gradient color"));
    }

    @Test
    public void testGetTheFirstUsedVariable() throws Exception {
        String vq = "[green, gray] bla > "; //Intentionally left undone

        Collection<String> allVars = new ArrayList<>();
        allVars.add("kuk");
        allVars.add("bla");
        allVars.add("blob");

        VQParseTree tree = VQParse.syntaxCheck(vq, allVars);
        assertFalse(tree.getParseError().isEmpty());

        String firstVar = tree.getUsedVariables().stream().findFirst().get();
        assertEquals("bla", firstVar);
    }

    @Test
    public void testCalculateTypeOfVQWithOnlyOneVariable() throws Exception {
        String vq = "[green, gray] kuk";
        List<OutputVariable> vars = new ArrayList<>();
        OutputVariable var1 = new OutputVariable("kuk");
        var1.setEdgeData(true);
        vars.add(var1);

        OutputVariable var2 = new OutputVariable("bla");
        var2.setNodeData(true);
        vars.add(var2);

        VQParseTree parsed = VQParse.parse(vq, vars);
        assertNotNull(parsed);
        assertEquals(VQParseTree.VQType.Edge, parsed.getType());

        assertTrue(VQParse.parse(vq, vars).isValid());
    }

    @Test
    public void testCalculateTypeOfVQWithTwoDifferentTypes() throws Exception {
        String vq = "[green, gray] kuk < bla";
        List<OutputVariable> vars = new ArrayList<>();
        OutputVariable var1 = new OutputVariable("kuk");
        var1.setEdgeData(true);
        vars.add(var1);

        OutputVariable var2 = new OutputVariable("bla");
        var2.setNodeData(true);
        vars.add(var2);

        assertFalse(VQParse.parse(vq, vars).isValid());
    }

    @Test
    public void testCalculateTypeOfVQWithSameTypes() throws Exception {
        String vq = "[green, gray] kuk < bla";
        List<OutputVariable> vars = new ArrayList<>();
        OutputVariable var1 = new OutputVariable("kuk");
        var1.setEdgeData(true);
        vars.add(var1);

        OutputVariable var2 = new OutputVariable("bla");
        var2.setEdgeData(true);
        vars.add(var2);

        assertTrue(VQParse.parse(vq, vars).isValid());
    }

    @Test
    public void testCalculateTypeOfVQWithSameTypesAndScope() throws Exception {
        String vq = "[green, gray] kuk < b.bla";
        List<OutputVariable> vars = new ArrayList<>();
        OutputVariable var1 = new OutputVariable("kuk");
        var1.setEdgeData(true);
        vars.add(var1);

        OutputVariable var2 = new OutputVariable("bla", "b");
        var2.setEdgeData(true);
        vars.add(var2);
        assertEquals("b.bla", var2.toString());

        assertTrue(VQParse.parse(vq, vars).isValid());
    }

    @Test
    public void testCanParseUnfinishedVQ() throws Exception {
        String vq = "[green, gray] kuk < b";
        List<OutputVariable> vars = new ArrayList<>();
        OutputVariable var1 = new OutputVariable("kuk");
        var1.setEdgeData(true);
        vars.add(var1);


        assertFalse(VQParse.parse(vq, vars).isValid());
    }

    @Test
    public void scopeTest() throws Exception {
        String input = "[green:-2, gray:6] a.b + x";

        HashMap<String, Double> map = new HashMap<>();
        map.put("a.b", 1.);
        map.put("x", 3.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0.75, gradient, 0.01);
    }

    @Test
    public void condOpTest() throws Exception {
        String input = "[green:0, gray:4] x > 0 ? y : 0";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 1.);
        map.put("y", 3.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0.75, gradient, 0.01);
    }

    @Test
    public void condOpTest2() throws Exception {
        String input = "[green:0, gray:4] x == 0 ? y : 1";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 1.);
        map.put("y", 3.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0.25, gradient, 0.01);
    }

    @Test
    public void noColorsTest() throws Exception {
        String input = "x - 3.66";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 4.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0.33, gradient, 0.01);
        assertEquals(null, tree.getFirstColor());
        assertEquals(null, tree.getSecondColor());
    }

    @Test
    public void doubleCompareTest() throws Exception {
        String input = "x > 0";

        HashMap<String, Double> map = new HashMap<>();
        map.put("x", 0.);

        VQParseTree tree = VQParse.syntaxCheck(input, map.keySet());
        double gradient = tree.getGradient(map);

        assertEquals(0., gradient, 0.01);
    }

    @Test
    public void canParseMultipleOutputParametersInTernaryOperator() throws Exception {
        String race_name = "OUTPUT_has_race";
        String data_name = "OUTPUT_current_data";

        String vq = "[blue, green] Node." + race_name + " ? Node." + data_name + " : -1";
        List<OutputVariable> vars = new ArrayList<>();
        vars.add(new OutputVariable(race_name, "Node"));
        vars.add(new OutputVariable(data_name, "Node"));

        VQParseTree tree = VQParse.parse(vq, vars);

        Map<String, Double> map = new HashMap<>();
        map.put(vars.get(0).toString(), 0.65);
        map.put(vars.get(1).toString(), 0.11);
        double gradientWhenNotZero = tree.getGradient(map);
        assertEquals(0.11, gradientWhenNotZero, 0.01);

        map.put(vars.get(0).toString(), 0.);
        double gradientWhenZero = tree.getGradient(map);
        assertEquals(0, gradientWhenZero, 0.01);
    }

    @Test
    public void parseColors() {
        String vq = "[blue:0, red:1, purple:5, yellow:*] x * y";

        List<OutputVariable> vars = new ArrayList<>();
        vars.add(new OutputVariable("x"));
        vars.add(new OutputVariable("y"));

        VQParseTree tree = VQParse.parse(vq, vars);

        assertEquals("blue", tree.getVqColors().getColorForValue(0));
        assertEquals("red", tree.getVqColors().getColorForValue(1));
        assertEquals("purple", tree.getVqColors().getColorForValue(5));
        assertEquals("yellow", tree.getVqColors().getColorForValue(3));
        assertEquals("yellow", tree.getVqColors().getColorForValue(7));
        assertEquals("yellow", tree.getVqColors().getColorForValue(-1));

        assertEquals(null, tree.getSecondColor());
    }
}






















