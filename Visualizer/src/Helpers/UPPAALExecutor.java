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

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {

    //TODO Refactor and use CompletableFuture<T> to run async
    public static SimulateOutput provideQueryResult(String modelPath, String query, TextInputControl feedbackCtrl) throws IOException {
        String verifytaLocation = GUIHelper.getVerifytaLocationFromUser();
        if (verifytaLocation == null)
            return null;

        String simulateCountString = RegexHelper.getFirstMatchedValueFromRegex("simulate (\\d+)", query);
        if (simulateCountString == null)
            return null;

        int simulateCount = Integer.parseInt(simulateCountString);

        File queryFile = UPPAALParser.generateQueryFile(query);

        try {
            String uppaalOutput = runUppaal(modelPath, verifytaLocation, queryFile.getPath(), feedbackCtrl);
            if (uppaalOutput == null || uppaalOutput.length() == 0)
                return null;

            List<String> lines = Arrays.asList(uppaalOutput.split("\n"));
            return SimulateParser.parse(lines, simulateCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String runUppaal(String modelPath, String verifytaLocation, String queryFile, TextInputControl feedbackCtrl) throws IOException, InterruptedException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        new Thread(() -> {
            try {
                ProcessBuilder builder = new ProcessBuilder(verifytaLocation, modelPath, queryFile);
                Process p = builder.start();
                redirect(p.getInputStream(), new PrintStreamRedirector(feedbackCtrl), new PrintStream(buffer));

                p.waitFor();
            } catch (Exception ignored) {

            }
        }).start();

        return new String(buffer.toByteArray(), StandardCharsets.UTF_8);
    }

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
