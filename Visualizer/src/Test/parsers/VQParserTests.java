package parsers;

import Model.VQ.VQExpression;
import org.junit.Test;
import parsers.VQParser.VQParse;
import static org.junit.Assert.*;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQParserTests {
    @Test
    public void initialSimpleTest() {
        String input = "[red:-5, blue:15] var1 > 3";

        VQExpression vqExpression = VQParse.parseVQ(input);

        assertEquals(vqExpression.getFirstColor(), "red");
        assertEquals(vqExpression.getSecondColor(), "blue");
        assertEquals(vqExpression.getFirstGradient(), -5);
        assertEquals(vqExpression.getSecondGradient(), 15);
    }
}