package View;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
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

    public void bindProperty(IntegerProperty intProperty) {
        textProperty().bindBidirectional(intProperty, new NumberStringConverter());
    }
}
