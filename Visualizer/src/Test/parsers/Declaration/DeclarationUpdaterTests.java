package parsers.Declaration;

import java.io.*;
import java.util.ArrayList;

import Helpers.FileHelper;
import Model.CVar;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsers.CHandler;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by lajtman on 27-02-2017.
 */
public class DeclarationUpdaterTests {

    @Test
    public void doesNotAlterFileIfNoUpdates() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));

        XmlHandler handler = new XmlHandler(f.getPath());
        String originalDecls = handler.getGlobalDeclarations();

        String updatedDecls = VariableParser.updateAllDeclarations(originalDecls, new ArrayList<>());

        assertEquals(originalDecls, updatedDecls);
    }

    @Test
    public void canUpdateDeclarationsCorrectly() throws IOException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));
        XmlHandler handler = new XmlHandler(f.getPath());
        String orgDecls = handler.getGlobalDeclarations();

        ArrayList<CVar> cvars = CHandler.getConfigVariables(orgDecls, null);
        assertNotNull(cvars);
        //update some of them
        cvars.get(0).setValue("12345");

        String updatedDecls = VariableParser.updateAllDeclarations(orgDecls, cvars);
        assertNotNull(updatedDecls);
        ArrayList<CVar> newCvars = CHandler.getConfigVariables(updatedDecls, null);
        assertNotNull(newCvars);

        assertEquals(cvars.size(), newCvars.size());
        for (int i = 0; i < cvars.size(); i++) {
            assertEquals(cvars.get(i), newCvars.get(i));
        }
    }
}
