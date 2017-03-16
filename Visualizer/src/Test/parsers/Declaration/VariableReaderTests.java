package parsers.Declaration;

import Model.CVar;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by batto on 24-Feb-17.
 */
public class VariableReaderTests {

    @Test
    public void getValueOfLocalBool() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("test_resources/topologytest.xml");
        ArrayList<CVar> vars = VariableParser.getInstantiations(handler.getAllDeclarations().get("Template"));
        CVar expectedCollision = new CVar(null, "local_bool", "false", true, "bool");
        assertTrue(vars.contains(expectedCollision));
    }

}
