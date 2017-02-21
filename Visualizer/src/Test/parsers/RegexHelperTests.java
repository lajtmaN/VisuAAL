package parsers;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
/**
 * Created by batto on 16-Feb-17.
 */
public class RegexHelperTests {

    @Test
    public void testVariableMather() {
        String s1 = "hest[2][3]";
        String s2 = "hest";

        assert(RegexHelper.variableNameMatches(s1, s2));
    }

    @Test
    public void testGetAllMatchedGroups(){
        String input = "// Place template instantiations here.\n" +
                "\n" +
                "// List one or more processes to be composed into a system.\n" +
                "system mabe, hest, tis, hej;\n" +
                "//use this system vas;";
        List<String> actual = RegexHelper.parseProcessesFromSystem(input);
        assertEquals(4, actual.size());
        assertEquals("mabe", actual.get(0));
        assertEquals("hest", actual.get(1));
        assertEquals("tis", actual.get(2));
        assertEquals("hej", actual.get(3));
    }
}
