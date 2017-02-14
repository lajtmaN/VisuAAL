package View;

import Model.TemplateUpdate;
import java.util.regex.Pattern;

/**
 * Created by batto on 14-Feb-17.
 */
public class IntegerEditingCell<T> extends EditingCell<T, Integer> {
    private final Pattern intPattern = Pattern.compile("-?\\d+");

    public IntegerEditingCell() { }

    @Override
    protected void processEdit() {
        String text = textField.getText();
        if (intPattern.matcher(text).matches()) {
            commitEdit(Integer.parseInt(text));
        } else {
            cancelEdit();
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        Number value = getItem();
        if (value != null) {
            textField.setText(value.toString());
            setGraphic(textField);
            setText(null);
        }
    }

}
