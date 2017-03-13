package View;

import Model.CVar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import parsers.RegexHelper;

/**
 * Created by batto on 14-Feb-17.
 */
public abstract class EditingCell<T, C> extends TableCell<T, C> {
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

    String getValueText() {
        switch (fieldType) {
            case INT_FIELD:
            case DOUBLE_FIELD:
                return textField.getText();
            case BOOL_FIELD:
                return comboBox.getValue().toString();
            default:
                return "";
        }
    }

    void setValueText(String value) {
        switch (fieldType) {
            case INT_FIELD:
            case DOUBLE_FIELD:
                textField.setText(value);
            case BOOL_FIELD:
                comboBox.setValue(value);
        }
    }

    public abstract String getStringValueFromItem(C item);

    @Override
    public void startEdit() {
        super.startEdit();
        C var = getItem();
        if (var != null) {
            setValueText(getStringValueFromItem(var));
            setCorrectGraphic();
        }
    }

    void setFieldTypeBasedOnCVar(CVar correspondingVar) {
        if (correspondingVar != null) {
            if (correspondingVar.hasIntType() || correspondingVar.hasDoubleType()) {
                fieldType = correspondingVar.hasIntType() ? FieldType.INT_FIELD : FieldType.DOUBLE_FIELD;
            } else if (correspondingVar.hasBoolType()) {
                fieldType = FieldType.BOOL_FIELD;
            } else {
                throw new IllegalArgumentException("Could not init cell for CVar: " + correspondingVar.getName());
            }
        }
    }

    @Override
    protected void updateItem(C item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null) {
            setValueText(null);
            setGraphic(null);
        } else {
            setValueText(getStringValueFromItem(item));
            setCorrectGraphic();
        }
    }

    protected void processEdit() {
        if (isValidText(getValueText()))
            commitEdit(getItem());
        else
            cancelEdit();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        if (getItem() != null)
            setValueText(getStringValueFromItem(getItem()));
    }

    private boolean isValidText(String text) {
        switch (fieldType) {
            case INT_FIELD:
                return RegexHelper.isValidInt(text);
            case DOUBLE_FIELD:
                return RegexHelper.isValidDouble(text);
            default:
                return true;
        }
    }

    private void setCorrectGraphic() {
        switch (fieldType) {
            case INT_FIELD:
            case DOUBLE_FIELD:
                setGraphic(textField);
                break;
            case BOOL_FIELD:
                setGraphic(comboBox);
                break;
            default:
                setGraphic(null);
                break;
        }
    }
}
