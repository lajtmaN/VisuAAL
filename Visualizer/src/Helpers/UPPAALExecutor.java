package Helpers;

import Model.SimulateOutput;
import parsers.RegexHelper;
import parsers.SimulateParser;
import parsers.UPPAALParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {

    //TODO Refactor and use CompletableFuture<T> to run async
    public static SimulateOutput provideQueryResult(String modelPath, String query) throws IOException {
        String simulateCountString = RegexHelper.getFirstMatchedValueFromRegex("simulate (\\d+)", query);
        if (simulateCountString == null)
            return null;

        int simulateCount = Integer.parseInt(simulateCountString);

        File queryFile = UPPAALParser.generateQueryFile(query);

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "lib\\verifyta.exe \"" + modelPath + "\" " + queryFile
        );
        builder.redirectErrorStream(true);
        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = r.readLine()) != null) {
                lines.add(line);
            }

            return SimulateParser.parse(lines, simulateCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
