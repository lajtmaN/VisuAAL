package View;

import javafx.scene.control.TextField;
import parsers.RegexHelper;

/**
 * Created by lajtman on 17-03-2017.
 */
public class DoubleTextField extends TextField {

    public DoubleTextField() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 0 && !RegexHelper.isValidTextFieldDouble(newValue))
                setText(oldValue);
        });
    }
}
