package parsers;

import org.junit.Test;

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
}
