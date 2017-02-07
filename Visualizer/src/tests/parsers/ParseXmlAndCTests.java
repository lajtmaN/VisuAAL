package tests.parsers;

import org.junit.jupiter.api.*;
import org.xml.sax.SAXException;
import parsers.CHandler;
import parsers.CVar;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Created by batto on 07-Feb-17.
 */
public class ParseXmlAndCTests {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init(){


    }

    @Test
    void getXmlDeclarationsTest() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler xmlHandler = new XmlHandler("mac_model_test.xml");
        String declarations = xmlHandler.getGlobalDeclarations();
        ArrayList<CVar<Integer>> vars = CHandler.getConstants(declarations);
        

    }

    @Test
    void parseDeclarationsTest() {
        String declarations = "const int abc = 123," +
                "CONFIG_dhj = 234;" +
                "\n const int CONFIG_abe = 456;";
        ArrayList<CVar<Integer>> vars = CHandler.getConstants(declarations);

        assertEquals(2, vars.size(), "3 Variables expected");
        assertCVAR("CONFIG_dhj", 234, vars.get(0));
        assertCVAR("CONFIG_abe", 456, vars.get(1));
    }


    private <T> void assertCVAR(String expectedName, T expectedVal, CVar<T> actual) {
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedVal, actual.getValue());
    }
}
