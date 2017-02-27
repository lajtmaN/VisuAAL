package parsers.Declaration;

import Model.UPPAALVariable;
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
        ArrayList<UPPAALVariable> vars = VariableParser.getInstantiations(handler.getGlobalDeclarations());
        assertEquals(42, vars.size());
        int i = 0;
        assertEquals(new UPPAALVariable("bool","CONFIG_TEST_BOOLEAN", "true", false), vars.get(i));
        assertEquals(new UPPAALVariable("double", "CONFIG_TEST_DOUBLE", "0.5", false), vars.get(++i));
        assertEquals(new UPPAALVariable("int","NR_NODES_SQR_ROOT", "8", true), vars.get(++i));
        assertEquals(new UPPAALVariable("int", "CONFIG_NR_BEACON_SLOTS", "8", true), vars.get(i += 2));
        assertEquals(new UPPAALVariable("int", "CONFIG_BCN_LOST_PROB", "1", false), vars.get(i += 10));
        assertEquals(new UPPAALVariable("beacon_data", "sent_beacon", null, false), vars.get(i += 4));
        assertEquals( new UPPAALVariable("bool", "is_busy", null, false), vars.get(i += 17));
        assertEquals(1, vars.get(i).getArraySizes().size());
        assertEquals("CONFIG_NR_NODES", vars.get(i++).getArraySizes().get(0));
        assertEquals(new UPPAALVariable("int", "OUTPUT_data_is_scheduled", null, false), vars.get(i));

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
        ArrayList<UPPAALVariable> vars = VariableParser.getInstantiations(handler.getAllDeclarations().get("full_beacon_scan"));
        assertEquals(new UPPAALVariable("bool", "collision", "false", false), vars.get(2));
    }

}
