package View;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

/**
 * Created by batto on 14-Feb-17.
 */
public class EditingCell<T, C> extends TableCell<T, C> {
    protected TextField textField = new TextField();
    protected ComboBox comboBox = new ComboBox();
    protected enum FieldType {UNKNOWN, INT_FIELD, BOOL_FIELD, DOUBLE_FIELD}
    protected FieldType fieldType = FieldType.UNKNOWN;

    public EditingCell() {
        super();
        textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                processEdit();
            }
        });
        comboBox.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                processEdit();
            }
        });
        textField.setOnAction(event -> processEdit());
        comboBox.getItems().addAll("true", "false");
    }

    protected String getValueText() {
        if(fieldType == FieldType.INT_FIELD || fieldType == FieldType.DOUBLE_FIELD) {
            return textField.getText();
        }
        else if(fieldType == FieldType.BOOL_FIELD) {
            return comboBox.getValue().toString();
        }
        return "";
    }

    protected void setValueText(String value) {
        if(fieldType == FieldType.INT_FIELD || fieldType == FieldType.DOUBLE_FIELD) {
            textField.setText(value);
        }
        else if(fieldType == FieldType.BOOL_FIELD) {
            comboBox.setValue(value);
        }
    }

    protected void processEdit() { }

    @Override
    public void commitEdit(C value) {
        super.commitEdit(value);
    }

    @Override
    public void startEdit() {
        super.startEdit();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setValueText(getItem().toString());
        //setGraphic(null);
    }
}
