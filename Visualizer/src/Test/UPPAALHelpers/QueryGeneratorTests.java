package UPPAALHelpers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by batto on 08-Feb-17.
 */
public class QueryGeneratorTests {
    @Test
    public void createRelationshipQuery() {
        String expected = "simulate 1 [<=1000] {\ndata[0][0] > 0,\ndata[0][1] > 0,\ndata[1][0] > 0,\ndata[1][1] > 0}";
        String actual = QueryGenerator.Generate2DQuadraticArrayQuery("data", 2, 1, 1000);

        assertEquals(expected, actual);
    }
}
