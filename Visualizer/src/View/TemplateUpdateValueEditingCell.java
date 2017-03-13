package View;

import Model.CVar;
import Model.TemplateUpdate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

/**
 * Created by batto on 14-Feb-17.
 */
public class TemplateUpdateValueEditingCell extends EditingCell<TemplateUpdate, TemplateUpdate> {

    public TemplateUpdateValueEditingCell() {  }

    @Override
    public String getStringValueFromItem(TemplateUpdate item) {
        return item.getTheValue();
    }

    @Override
    protected void updateItem(TemplateUpdate item, boolean empty) {
        CVar correspondingVar = getCorrespondingCVar(item);
        setFieldTypeBasedOnCVar(correspondingVar);
        super.updateItem(item, empty);
    }

    private CVar getCorrespondingCVar(TemplateUpdate item) {
        if (item == null) return null;

        ObservableList<CVar> listOfVars = MainWindowController.getInstance().getNonConstConfigVars();
        FilteredList<CVar> filteredList = listOfVars.filtered(p -> p.getName().equals(item.getVariableName()));

        return filteredList != null && filteredList.size() > 0 ? filteredList.get(0) : null;
    }

    @Override
    protected void processEdit() {
        super.processEdit();
        MainWindowController.getInstance().constantsChanged = true;
    }

    @Override
    public void commitEdit(TemplateUpdate value) {
        super.commitEdit(value);
        value.setTheValue(getValueText());
    }
}
