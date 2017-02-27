package parsers.Declaration;

import Model.CVar;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by batto on 24-Feb-17.
 */
public class VariableReaderTests {

    @Test
    public void parseMacVars() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("mac_model_test.xml");
        ArrayList<CVar> vars = VariableParser.getInstantiations(handler.getGlobalDeclarations());
        assertEquals(42, vars.size());
        int i = 0;
        assertEquals(new CVar(null,"CONFIG_TEST_BOOLEAN", "true", false, "bool"), vars.get(i));
        assertEquals(new CVar(null,"CONFIG_TEST_DOUBLE", "0.5", false, "double" ), vars.get(++i));
        assertEquals(new CVar(null,"NR_NODES_SQR_ROOT", "8", true, "int"), vars.get(++i));
        assertEquals(new CVar(null,"CONFIG_NR_BEACON_SLOTS", "8", true, "int" ), vars.get(i += 2));
        assertEquals(new CVar(null,"CONFIG_BCN_LOST_PROB", "1", false, "int" ), vars.get(i += 10));
        assertEquals(new CVar(null,"sent_beacon", null, false, "beacon_data" ), vars.get(i += 4));

        CVar expectedIsBusy = new CVar(null, "is_busy", null, false, "bool");
        expectedIsBusy.getArraySizes().add("CONFIG_NR_NODES");
        assertEquals(expectedIsBusy, vars.get(i += 17));

        CVar expectedDataIsScheduled = new CVar(null, "OUTPUT_data_is_scheduled", null, false, "int");
        expectedDataIsScheduled.getArraySizes().add("CONFIG_NR_NODES");
        expectedDataIsScheduled.getArraySizes().add("CONFIG_NR_NODES");
        assertEquals(expectedDataIsScheduled, vars.get(++i));

        ArrayList<String> arraySizes = vars.get(i).getArraySizes();
        int size = arraySizes.size();
        assertEquals(2, size);
        for (String arraySize : arraySizes) {
            assertEquals("CONFIG_NR_NODES", arraySize);
        }
    }

    @Test
    public void typedefLine() {
        VariableParser.getInstantiations("typedef int[0, CONFIG_NR_NODES-1] id_t;");
    }

    @Test
    public void getValueOfLocalBool() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("mac_model_test.xml");
        ArrayList<CVar> vars = VariableParser.getInstantiations(handler.getAllDeclarations().get("full_beacon_scan"));
        CVar expectedCollision = new CVar(null, "collision", "false", false, "bool");
        assertEquals(expectedCollision, vars.get(2));
    }

}
