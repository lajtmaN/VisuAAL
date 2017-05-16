package Helpers;

import Model.SimulateOutput;
import exceptions.UPPAALFailedException;
import javafx.scene.control.TextInputControl;
import parsers.RegexHelper;
import parsers.SimulateParser;
import parsers.UPPAALParser;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.CompletableFuture;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {
    private static boolean cancelled = false;
    private static Collection<CompletableFuture<SimulateOutput>> futures = new ArrayList<>();
    private static Collection<Process> verifytaProcesses = new ArrayList<>();

    public static CompletableFuture<SimulateOutput> startUppaalQuery(String modelPath, String query, TextInputControl feedbackCtrl) throws IOException {
        setCancelled(false);
        String verifytaLocation = GUIHelper.getVerifytaLocationFromUser();
        if (verifytaLocation == null)
            return null;

        String simulateCountString = RegexHelper.getFirstMatchedValueFromRegex("simulate (\\d+)", query);
        if (simulateCountString == null)
            return null;

        int simulateCount = Integer.parseInt(simulateCountString);

        File queryFile = UPPAALParser.generateQueryFile(query);

        CompletableFuture<SimulateOutput> simulateOutputCompletableFuture = CompletableFuture.supplyAsync(() -> runUppaal(modelPath, verifytaLocation, queryFile.getPath(), simulateCount, feedbackCtrl));
        futures.add(simulateOutputCompletableFuture);
        simulateOutputCompletableFuture.thenApply(p -> futures.remove(simulateOutputCompletableFuture));
        return simulateOutputCompletableFuture;
    }

    public static void cancelProcesses() {
        setCancelled(true);
        for(CompletableFuture<SimulateOutput> future : futures){
            future.cancel(true);
        }
        for(Process p : verifytaProcesses) {
            p.destroy();
        }
        verifytaProcesses.clear();
    }

    private static void setCancelled(boolean cancelled) {
        UPPAALExecutor.cancelled = cancelled;
    }

    private static boolean isCancelled() {
        return cancelled;
    }

    private static SimulateOutput runUppaal(String modelPath, String verifytaLocation, String queryFile, int simulateCount, TextInputControl feedbackCtrl) { {
        try {
            ProcessBuilder builder = new ProcessBuilder(verifytaLocation, modelPath, queryFile);
            long startTime = System.currentTimeMillis();
            Process p = builder.start();
            verifytaProcesses.add(p);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            redirect(p.getInputStream(), new PrintStream(buffer), new PrintStreamRedirector(feedbackCtrl));

            p.waitFor();
            verifytaProcesses.remove(p);

            if(isCancelled())
                return null;

            if (p.exitValue() > 0)
                throw new UPPAALFailedException();



            String uppaalOutput = new String(buffer.toByteArray(), StandardCharsets.UTF_8);
            if (uppaalOutput.length() == 0)
                return null;


            List<String> lines = Arrays.asList(uppaalOutput.split("\n"));
            long endTime = System.currentTimeMillis();
            feedbackCtrl.setText( feedbackCtrl.getText()+"This took: "+String.valueOf(endTime-startTime)+" ms");
            return SimulateParser.parse(lines, simulateCount);

        } catch (InterruptedException | IOException e) {
            return null;
        }
    }}

    private static void redirect(final InputStream src, final PrintStream... dest) {
         new Thread(() -> {
            Scanner sc = new Scanner(src);
            while (sc.hasNextLine() && !isCancelled()) {
                String line = sc.nextLine();
                for (PrintStream p : dest)
                    p.println(line);
            }
        }).start();
    }
}
