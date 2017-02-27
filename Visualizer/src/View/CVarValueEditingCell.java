package View;

import Model.CVar;

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
    protected void processEdit() {
        CVar var = getItem();
        MainWindowController.getInstance().constantsChanged = true;
        var.setValue(getValueText());
        commitEdit(var);
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
}