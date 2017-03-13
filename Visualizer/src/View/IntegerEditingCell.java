package View;

import Model.TemplateUpdate;
import java.util.regex.Pattern;

/**
 * Created by batto on 14-Feb-17.
 */
public class IntegerEditingCell<T> extends EditingCell<T, Integer> {

    public IntegerEditingCell() {
        fieldType = FieldType.INT_FIELD;
    }

    @Override
    protected void updateItem(Integer item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setStyle("");
            setGraphic(null);
        } else {
            setGraphic(textField);
            setValueText(getStringValueFromItem(item));
        }
    }

    @Override
    public String getStringValueFromItem(Integer item) {
        return String.valueOf(item);
    }

    @Override
    public void commitEdit(Integer oldValue) {
        Integer newValue = Integer.parseInt(getValueText());
        super.commitEdit(newValue);
        itemProperty().setValue(newValue);
    }
}
