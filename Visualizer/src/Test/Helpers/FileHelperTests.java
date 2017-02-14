package Helpers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by lajtman on 14-02-2017.
 */
public class FileHelperTests {
    @Test
    public void testGetExtension() {
        String filename = "tester.xml";
        String extension = FileHelper.getExtension(filename);
        assertEquals(".xml", extension);
    }
}
