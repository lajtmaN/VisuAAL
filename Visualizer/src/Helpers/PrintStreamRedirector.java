package Helpers;

import javafx.application.Platform;
import javafx.scene.control.TextInputControl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by lajtman on 16-03-2017.
 */
public class PrintStreamRedirector extends PrintStream {
    private TextInputControl textField;
    private boolean enabled = false;

    public PrintStreamRedirector(TextInputControl controlToUpdate) {
        super(new ByteArrayOutputStream());
        textField = controlToUpdate;
    }

    @Override
    public void println(String x) {
        if (x != null && x.contains("Verifying formula 1")) {
            enabled = true;
            return; //We don't want to print this line
        }
        else if (x != null && x.contains("Formula is satisfied.")) {
            enabled = false;
            String finishedMessage = "UPPAAL finished... " + System.lineSeparator() + "Crunching numbers..." + System.lineSeparator();
            Platform.runLater(() -> textField.appendText(finishedMessage));
        }

        if (enabled)
            Platform.runLater(() -> textField.appendText(x + System.lineSeparator()));
    }
}
