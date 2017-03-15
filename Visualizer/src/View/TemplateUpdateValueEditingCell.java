package View;

import Model.CVar;
import Model.TemplateUpdate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import parsers.RegexHelper;

/**
 * Created by batto on 14-Feb-17.
 */
public class TemplateUpdateValueEditingCell extends EditingCell<TemplateUpdate, String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        setFieldTypeBasedOnCVar(getCorrespondingCVar(getRowObject()));
        super.updateItem(item, empty);
    }

    @Override
    public String getStringValueFromItem(String item) {
        return item;
    }

    // This seems necessary to persist the edit on loss of focus; not sure why:

    @Override
    protected boolean canValueParse(String value) {
        TemplateUpdate t = getRowObject();
        CVar cVar= getCorrespondingCVar(t);
        return (cVar.hasDoubleType() && RegexHelper.isValidDouble(value)
                || cVar.hasIntType() && RegexHelper.isValidInt(value)
                || cVar.hasBoolType() && (value.equals("true") || value.equals("false")));
    }

    @Override
    public void commitEdit(String value) {
        super.commitEdit(value);
        setValueText(value);
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setValueText(getItem());
    }

    private CVar getCorrespondingCVar(TemplateUpdate item) {
        if (item == null) return null;

        ObservableList<CVar> listOfVars = MainWindowController.getInstance().getNonConstConfigVars();
        FilteredList<CVar> filteredList = listOfVars.filtered(p -> p.getName().equals(item.getVariableName()));

        return filteredList != null && filteredList.size() > 0 ? filteredList.get(0) : null;
    }
}