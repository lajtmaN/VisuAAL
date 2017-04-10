package Helpers;

import Model.SimulateOutput;
import exceptions.UPPAALFailedException;
import javafx.scene.control.TextInputControl;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import parsers.RegexHelper;
import parsers.SimulateParser;
import parsers.UPPAALParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {
    
    public static CompletableFuture<SimulateOutput> startUppaalQuery(String modelPath, String query, TextInputControl feedbackCtrl) throws IOException {
        String verifytaLocation = GUIHelper.getVerifytaLocationFromUser();
        if (verifytaLocation == null)
            return null;

        String simulateCountString = RegexHelper.getFirstMatchedValueFromRegex("simulate (\\d+)", query);
        if (simulateCountString == null)
            return null;

        int simulateCount = Integer.parseInt(simulateCountString);

        File queryFile = UPPAALParser.generateQueryFile(query);

        return CompletableFuture.supplyAsync(() -> runUppaal(modelPath, verifytaLocation, queryFile.getPath(), simulateCount, feedbackCtrl));
    }

    private static SimulateOutput runUppaal(String modelPath, String verifytaLocation, String queryFile, int simulateCount, TextInputControl feedbackCtrl) { {
        try {
            ProcessBuilder builder = new ProcessBuilder(verifytaLocation, modelPath, queryFile);
            Process p = builder.start();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            redirect(p.getInputStream(), new PrintStream(buffer), new PrintStreamRedirector(feedbackCtrl));

            p.waitFor();

            if (p.exitValue() > 0)
                throw new UPPAALFailedException();

            String uppaalOutput = new String(buffer.toByteArray(), StandardCharsets.UTF_8);
            if (uppaalOutput.length() == 0)
                return null;

            List<String> lines = Arrays.asList(uppaalOutput.split("\n"));
            return SimulateParser.parse(lines, simulateCount);

        } catch (InterruptedException | IOException e) {
            return null;
        }
    }}

    private static void redirect(final InputStream src, final PrintStream... dest) {
         new Thread(() -> {
            Scanner sc = new Scanner(src);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                for (PrintStream p : dest)
                    p.println(line);
            }
        }).start();
    }
    public static List<String> runUppaalRemotely(String pathToWebservice, String modelPath, String query) {
       try {
            File file = new File(modelPath);
            HttpPost post = new HttpPost(pathToWebservice);

            MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            reqEntity.addPart("upload-file", new FileBody(file));
            reqEntity.addPart("query", new StringBody(query));
            post.setEntity(reqEntity);

            HttpResponse response = HttpClients.createDefault().execute(post);
            InputStream uppaalOutput = response.getEntity().getContent();
            return new BufferedReader(new InputStreamReader(uppaalOutput)).lines().parallel().collect(Collectors.toList());
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }
}
