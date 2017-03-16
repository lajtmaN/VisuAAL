package Helpers;

import javafx.scene.control.TextInputControl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by lajtman on 16-03-2017.
 */
public class PrintStreamRedirector extends PrintStream {
    private TextInputControl textField;
    private boolean enabled = true;

    public PrintStreamRedirector(TextInputControl controlToUpdate) {
        super(new ByteArrayOutputStream());
        textField = controlToUpdate;
    }

    @Override
    public void println(String x) {
        if (x != null && x.contains("Property is satisfied"))
            enabled = false;

        if (enabled)
            textField.appendText(x + "\n");
    }
}
