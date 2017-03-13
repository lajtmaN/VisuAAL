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

    protected String getValueText() {
        if(fieldType == FieldType.INT_FIELD || fieldType == FieldType.DOUBLE_FIELD) {
            return textField.getText();
        }
        else if(fieldType == FieldType.BOOL_FIELD) {
            return comboBox.getValue().toString();
        }
        return "";
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

    protected void setValueText(String value) {
        if(fieldType == FieldType.INT_FIELD || fieldType == FieldType.DOUBLE_FIELD) {
            textField.setText(value);
        }
        else if(fieldType == FieldType.BOOL_FIELD) {
            comboBox.setValue(value);
        }
    }

    protected void handleVariableTypes(CVar correspondingVar) {
        if (correspondingVar != null) {
            if (correspondingVar.hasIntType() || correspondingVar.hasDoubleType()){
                fieldType = correspondingVar.hasIntType() ? FieldType.INT_FIELD : FieldType.DOUBLE_FIELD;
                setValueText(correspondingVar.getValue());
            } else if (correspondingVar.hasBoolType()) {
                fieldType = FieldType.BOOL_FIELD;
                setValueText(correspondingVar.getValue());
            } else {
                setValueText("N/A");
            }

            setCorrectGraphic();
        } else {
            setValueText(null);
            setGraphic(null);
        }
    }

    protected void processEdit() {
        C var = getItem();
        switch (fieldType) {
            case INT_FIELD:
                if(RegexHelper.isValidInt(getValueText()))
                    commitEdit(var);
                else
                    cancelEdit();
                break;
            case DOUBLE_FIELD:
                if(RegexHelper.isValidDouble(getValueText()))
                    commitEdit(var);
                else
                    cancelEdit();
                break;
            case BOOL_FIELD:
                commitEdit(var);
                break;
            default:
                throw new IllegalArgumentException("Unknown field type");
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        if (getItem() != null)
            setValueText(getStringValueFromItem(getItem()));
    }

    protected void setCorrectGraphic() {
        switch (fieldType) {
            case BOOL_FIELD:
                setGraphic(comboBox);
                break;
            case INT_FIELD:
            case DOUBLE_FIELD:
                setGraphic(textField);
                break;
            default:
                setGraphic(null);
                break;
        }
    }
}
