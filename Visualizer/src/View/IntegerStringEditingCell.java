package View;

import java.util.regex.Pattern;

/**
 * Created by rasmu on 27/02/2017.
 */
public class IntegerStringEditingCell<T> extends EditingCell<T, String>{
    private final Pattern intPattern = Pattern.compile("-?\\d+");

    public IntegerStringEditingCell() { }

    @Override
    protected void processEdit() {
        String text = textField.getText();
        if (intPattern.matcher(text).matches()) {
            commitEdit(text);
        } else {
            cancelEdit();
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        String value = getItem();
        if (value != null) {
            textField.setText(value);
            setGraphic(textField);
            setText(null);
        }
    }

}
