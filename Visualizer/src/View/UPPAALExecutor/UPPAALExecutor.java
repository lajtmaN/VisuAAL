package View.UPPAALExecutor;

import parsers.UPPAALParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {

    public static String provideQueryResult(String modelPath, String query) throws IOException {
        File queryFile = UPPAALParser.generateQueryFile(query);

        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "lib\\verifyta.exe " + modelPath + " " + queryFile
        );
        builder.redirectErrorStream(true);
        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String result = "";
            while (true) {
                try {
                    String line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    result += line + "\n";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
