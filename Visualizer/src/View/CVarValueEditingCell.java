package View;

import Model.CVar;
import parsers.RegexHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rasmu on 27/02/2017.
 */

public class CVarValueEditingCell extends EditingCell<CVar, CVar> {

    @Override
    protected void updateItem(CVar item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            if (item.hasIntType() || item.hasDoubleType()){
                fieldType = item.hasIntType() ? FieldType.INT_FIELD : FieldType.DOUBLE_FIELD;
                setValueText(item.getValue());
                setGraphic(textField);
            } else if (item.hasBoolType()) {
                fieldType = FieldType.BOOL_FIELD;
                setValueText(item.getValue());
                setGraphic(comboBox);
            } else {
                setValueText("N/A");
                setGraphic(null);
            }
        } else {
            setValueText(null);
            setGraphic(null);
        }
    }

    @Override
    public void commitEdit(CVar value) {
        super.commitEdit(value);
        value.setValue(getValueText());
    }

    @Override
    protected void processEdit() {
        CVar var = getItem();
        MainWindowController.getInstance().constantsChanged = true;

        switch (fieldType) {
            case INT_FIELD:
                if(RegexHelper.isValidInt(getValueText())) commitEdit(var);
                else cancelEdit();
                break;
            case DOUBLE_FIELD:
                if(RegexHelper.isValidDouble(getValueText())) commitEdit(var);
                else cancelEdit();
                break;
            case BOOL_FIELD:
                commitEdit(var);
                break;
            default:
                throw new IllegalArgumentException("Unknown field type");
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        CVar var = getItem();
        if (var != null) {
            setValueText(var.getValue());
            if(fieldType == FieldType.BOOL_FIELD)
                setGraphic(comboBox);
            else {
                setGraphic(textField);
            }
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setValueText(getItem().getValue());
    }
}