package parsers.Declaration;

import Model.UPPAALVariable;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsers.Declaration.ANTLRGenerated.VariableParser;
import parsers.Declaration.ANTLRGenerated.uppaalLexer;
import parsers.Declaration.ANTLRGenerated.uppaalParser;
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
        ArrayList<UPPAALVariable> vars = VariableParser.getDeclarations(handler.getGlobalDeclarations());
        assertEquals(40, vars.size());
        assertEquals(new UPPAALVariable("int","NR_NODES_SQR_ROOT", null, true), vars.get(0));
        assertEquals(new UPPAALVariable("int", "CONFIG_NR_BEACON_SLOTS", null, true), vars.get(2));
        assertEquals(new UPPAALVariable("int", "CONFIG_BCN_LOST_PROB", null, false), vars.get(12));
        assertEquals(new UPPAALVariable("beacon_data", "sent_beacon", null, false), vars.get(16));
        assertEquals(new UPPAALVariable("bool", "is_busy", null, false), vars.get(33));
    }

    @Test
    public void typedefLine() {
        VariableParser.getDeclarations("typedef int[0, CONFIG_NR_NODES-1] id_t;");
    }

}
