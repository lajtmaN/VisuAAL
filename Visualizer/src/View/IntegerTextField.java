package View;

import javafx.scene.control.TextField;
import parsers.RegexHelper;

/**
 * Created by lajtman on 17-03-2017.
 */
public class IntegerTextField extends TextField {

    public IntegerTextField() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 0 && !RegexHelper.isValidInt(newValue))
                setText(oldValue);
        });
    }
}
