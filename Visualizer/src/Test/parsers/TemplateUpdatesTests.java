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

import static org.junit.Assert.assertEquals;

/**
 * Created by batto on 15-Feb-17.
 */
public class TemplateUpdatesTests {

    @Test
    public void RemoveTemplateAndAddNew() throws IOException, TransformerException, ParserConfigurationException, SAXException {
        File f = FileHelper.copyFileIntoTempFile(new File("mac_model_exp.xml"));
        String uppaalPath = f.getPath();
        UPPAALModel uppaalModel = new UPPAALModel(uppaalPath);
        uppaalModel.load();
        uppaalModel.getTemplateUpdates().add(new TemplateUpdate("test", "17", 21));

        XmlHandler handler = new XmlHandler(uppaalPath);

        assertEquals(7, handler.getTemplateCount());

        handler.addTemplateUpdatesToModel(uppaalModel.getTemplateUpdates());

        assertEquals(8, handler.getTemplateCount());
        assertEquals(true, handler.existVisualizerTemplate());

        uppaalModel.getTemplateUpdates().add(new TemplateUpdate("test2", "21", 37));

        handler.addTemplateUpdatesToModel(uppaalModel.getTemplateUpdates());

        assertEquals(8, handler.getTemplateCount());
    }
}