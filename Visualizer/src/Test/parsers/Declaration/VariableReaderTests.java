package parsers.Declaration;

import Model.UPPAALVariable;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsers.Declaration.ANTLRGenerated.VariableParser;
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
        assertEquals(40, vars.size());
        assertEquals(new UPPAALVariable("int","NR_NODES_SQR_ROOT", "8", true), vars.get(0));
        assertEquals(new UPPAALVariable("int", "CONFIG_NR_BEACON_SLOTS", "8", true), vars.get(2));
        assertEquals(new UPPAALVariable("int", "CONFIG_BCN_LOST_PROB", "1", false), vars.get(12));
        assertEquals(new UPPAALVariable("beacon_data", "sent_beacon", null, false), vars.get(16));
        assertEquals( new UPPAALVariable("bool", "is_busy", null, false), vars.get(33));
        assertEquals(1, vars.get(33).getArraySizes().size());
        assertEquals("CONFIG_NR_NODES", vars.get(33).getArraySizes().get(0));
        assertEquals(new UPPAALVariable("int", "OUTPUT_data_is_scheduled", null, false), vars.get(34));

        ArrayList<String> arraySizes = vars.get(34).getArraySizes();
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
