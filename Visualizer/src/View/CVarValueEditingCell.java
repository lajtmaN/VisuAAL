package View;

import Model.CVar;

/**
 * Created by rasmu on 27/02/2017.
 */

public class CVarValueEditingCell extends EditingCell<CVar, CVar> {

    @Override
    protected void updateItem(CVar item, boolean empty) {
        setFieldTypeBasedOnCVar(item);
        super.updateItem(item, empty);
    }

    @Override
    public String getStringValueFromItem(CVar item) {
        return item.getValue();
    }

    @Override
    protected void processEdit() {
        super.processEdit();
        MainWindowController.getInstance().constantsChanged = true;
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setValueText(getItem().getValue());
    }

    @Override
    public void commitEdit(CVar value) {
        super.commitEdit(value);
        value.setValue(getValueText());
    }
}