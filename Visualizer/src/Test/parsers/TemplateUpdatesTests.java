package parsers;

import Helpers.FileHelper;
import Model.TemplateUpdate;
import Model.UPPAALModel;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by batto on 15-Feb-17.
 */
public class TemplateUpdatesTests {

    @Test
    public void RemoveTemplateAndAddNew() throws IOException, TransformerException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("test_resources/topologytest.xml"));

        TemplateUpdate update1 = new TemplateUpdate("test", "17", 21);
        TemplateUpdate update2 = new TemplateUpdate("test2", "21", 37);

        String uppaalPath = f.getPath();
        UPPAALModel uppaalModel = new UPPAALModel(uppaalPath);
        uppaalModel.load();
        uppaalModel.getTemplateUpdates().add(update1);

        XmlHandler handler = new XmlHandler(uppaalPath);

        assertEquals(2, handler.getTemplateCount());

        handler.addTemplateUpdatesToModel(uppaalModel.getTemplateUpdates());

        assertEquals(3, handler.getTemplateCount());
        assertEquals(true, handler.existVisualizerTemplate());

        uppaalModel.getTemplateUpdates().add(update2);

        handler.addTemplateUpdatesToModel(uppaalModel.getTemplateUpdates());

        assertEquals(3, handler.getTemplateCount()); //should not add new, but rather overwrite


        /* Now try to load again */
        ArrayList<TemplateUpdate> updates = handler.getVisualizerUpdates();

        assertEquals(2, updates.size());

        assertEquals(update1, updates.get(0));
        assertEquals(update2, updates.get(1));
    }
}