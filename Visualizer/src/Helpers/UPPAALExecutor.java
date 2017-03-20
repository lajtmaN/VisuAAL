package Helpers;

import Model.SimulateOutput;
import javafx.scene.control.TextInputControl;
import parsers.RegexHelper;
import parsers.SimulateParser;
import parsers.UPPAALParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

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
}
