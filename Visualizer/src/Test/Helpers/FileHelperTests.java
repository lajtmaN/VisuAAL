package Helpers;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test(timeout=1000)
    public void testGetUppaalDTDFile() throws IOException {
        URL url = new URL("http://www.it.uu.se/research/group/darts/uppaal/flat-1_2.dtd");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        int responseCode = con.getResponseCode();
        assertEquals(HttpURLConnection.HTTP_OK, responseCode);
    }

    @Test
    @Ignore
    public void canUploadFileToUPPAALWebService() {
        List<String> output = UPPAALExecutor.runUppaalRemotely(
                "http://localhost:60000/queue",
                "C:\\UNI\\P9\\uppaal\\Routing\\RoutingWithDataSinkProb.xml",
                "simulate 1 [<=2000] { Node(0).latest_received_data }");
        assertNotNull(output);
        output.forEach(System.out::println);
        assertTrue(output.size() > 8);
    }
}
