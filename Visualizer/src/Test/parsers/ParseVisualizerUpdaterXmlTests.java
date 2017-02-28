package parsers;

import Model.TemplateUpdate;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by batto on 22-Feb-17.
 */
public class ParseVisualizerUpdaterXmlTests {

    @Test
    public void parseVisualizerUpdater() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("mac_model_test.xml");

        ArrayList<TemplateUpdate> updates = handler.getVisualizerUpdates();

        TemplateUpdate expected0 = new TemplateUpdate("CONFIG_BCN_LOST_PROB", "10000", 10000);
        TemplateUpdate expected1 = new TemplateUpdate("CONFIG_DATA_LOST_PROB", "10000", 10000);
        TemplateUpdate expected2 = new TemplateUpdate("CONFIG_BCN_LOST_PROB", "1", 20000);
        TemplateUpdate expected3 = new TemplateUpdate("CONFIG_DATA_LOST_PROB", "1", 20000);

        assertEquals(4, updates.size());

        assertEquals(expected0, updates.get(0));
        assertEquals(expected1, updates.get(1));
        assertEquals(expected2, updates.get(2));
        assertEquals(expected3, updates.get(3));
    }
}