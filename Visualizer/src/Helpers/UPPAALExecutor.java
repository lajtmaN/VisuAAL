package Helpers;

import Model.SimulateOutput;
import com.uppaal.model.core2.Document;
import com.uppaal.model.core2.PrototypeDocument;
import com.uppaal.model.system.UppaalSystem;
import parsers.RegexHelper;
import parsers.SimulateParser;
import parsers.UPPAALParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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

        Document uppaalDocument = new PrototypeDocument().load(new URL("file", null, modelPath));
        UppaalSystem upp = new UppaalSystem(uppaalDocument);


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
