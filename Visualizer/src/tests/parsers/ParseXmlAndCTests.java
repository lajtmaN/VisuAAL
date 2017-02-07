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
    void init() throws IOException, SAXException, ParserConfigurationException {


    }

    @Test
    void getXmlDeclarationsTest() {
        /*XmlHandler xmlHandler = new XmlHandler("mac_model_test.xml");
        String declarations = xmlHandler.getGlobalDeclarations();
        ArrayList<CVar<int>> vars = CHandler.getConstants(declarations);*/


    }

    @Test
    void parseDeclarationsTest() {
        String declarations = "const int abc = 123," +
                "dhj = 234;" +
                "\n const int abe = 456;";
        ArrayList<CVar<Integer>> vars = CHandler.getConstants(declarations);

        assertEquals(3, vars.size(), "3 Variables expected");
        assertEquals("abc", vars.get(0).getName(), "Expected other name");
        assertEquals("dhj", vars.get(1).getName(), "Expected other name");
        assertEquals("abe", vars.get(2).getName(), "Expected other name");

        assertEquals(123, (int)vars.get(0).getValue(), "Expected other value");
        assertEquals(234, (int)vars.get(1).getValue(), "Expected other value");
        assertEquals(456, (int)vars.get(2).getValue(), "Expected other value");
    }


    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
}
