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
        handleVariableTypes(item);
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