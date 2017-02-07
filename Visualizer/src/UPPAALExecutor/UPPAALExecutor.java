package UPPAALExecutor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {

    public static String ProvideQueryResult(String uppaalPathText, String modelPathText) {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd " + uppaalPathText + "/bin-Win32 && verifyta " + modelPathText
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
