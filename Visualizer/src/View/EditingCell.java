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
    protected enum FieldType {UNKNOWN, INT_FIELD, BOOL_FIELD, DOUBLE_FIELD, COMBO_BOX_STRING_FIELD}
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
        //textField.setOnAction(event -> processEdit());
        //comboBox.setOnAction(event -> processEdit());
        comboBox.getItems().addAll("true", "false");


    }

    String getValueText() {
        switch (fieldType) {
            case INT_FIELD:
            case DOUBLE_FIELD:
                return textField.getText();
            case BOOL_FIELD:
            case COMBO_BOX_STRING_FIELD:
                return (String) comboBox.getValue();
            default:
                return "";
        }
    }

    void setValueText(String value) {
        switch (fieldType) {
            case INT_FIELD:
            case DOUBLE_FIELD:
                textField.setText(value);
                break;
            case COMBO_BOX_STRING_FIELD:
            case BOOL_FIELD:
                comboBox.setValue(value);
                break;
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
        if (item == null || empty) {
            setValueText(null);
            setGraphic(null);
        } else if(isEditing()){
            setValueText(getStringValueFromItem(item));
            setCorrectGraphic();
        }
    }

    protected void processEdit() {
        if (isValidText(getValueText()))
            //Works only when C is a string
            commitEdit((C)getValueText());
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

    @Override
    public void commitEdit(C value) {
        if(canValueParse(getStringValueFromItem(value))) {
            super.commitEdit(value);
            setValueText(getStringValueFromItem(value));
        }
    }

    protected boolean canValueParse(String value) {
        return true;
    }

    protected void setCorrectGraphic() {
        switch (fieldType) {
            case INT_FIELD:
            case DOUBLE_FIELD:
                setGraphic(textField);
                break;
            case COMBO_BOX_STRING_FIELD:
            case BOOL_FIELD:
                setGraphic(comboBox);
                break;
            default:
                setGraphic(null);
                break;
        }
    }

    protected T getRowObject() {
        return (T)this.getTableRow().getItem();
    }
}
