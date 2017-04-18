package Helpers;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

import static org.junit.Assert.*;

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

    @Ignore
    @Test(timeout=1000)
    public void testGetUppaalDTDFile() throws IOException {
        URL url = new URL("http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        int responseCode = con.getResponseCode();
        assertEquals(HttpURLConnection.HTTP_OK, responseCode);
    }
}
