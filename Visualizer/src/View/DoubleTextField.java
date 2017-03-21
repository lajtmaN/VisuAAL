package View;

import javafx.beans.property.DoubleProperty;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import parsers.RegexHelper;

import java.util.Locale;

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

    public void bindProperty(DoubleProperty doubleProperty) {
        textProperty().bindBidirectional(doubleProperty, new NumberStringConverter(Locale.US));
    }
}
