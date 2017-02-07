package UPPAALExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {

    public static String ProvideQueryResult(String modelPathText) {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "lib\\verifyta.exe " + modelPathText
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
