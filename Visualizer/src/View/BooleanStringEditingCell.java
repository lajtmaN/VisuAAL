package View;

import java.util.regex.Pattern;

/**
 * Created by rasmu on 27/02/2017.
 */
public class BooleanStringEditingCell<T> extends EditingCell<T, String>{

    public BooleanStringEditingCell() { }

    @Override
    protected void processEdit() {
        String text = textField.getText();
        commitEdit(text);
    }

    @Override
    public String getStringValueFromItem(String item) {
        return item;
    }
}
