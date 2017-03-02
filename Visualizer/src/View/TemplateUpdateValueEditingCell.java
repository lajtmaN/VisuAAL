package View;

import Model.CVar;
import Model.TemplateUpdate;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import parsers.RegexHelper;

import java.util.regex.Pattern;

/**
 * Created by batto on 14-Feb-17.
 */
public class TemplateUpdateValueEditingCell extends EditingCell<TemplateUpdate, TemplateUpdate> {

    public TemplateUpdateValueEditingCell() {  }

    @Override
    protected void updateItem(TemplateUpdate item, boolean empty) {
        super.updateItem(item, empty);
        ObservableList<CVar> listOfVars = MainWindowController.getInstance().getNonConstConfigVars();
        CVar correspondingVar = null;
        if (getItem() != null) {
            FilteredList<CVar> filteredList = listOfVars.filtered(p -> p.getName().equals(getItem().getVariableName()));
            if(filteredList != null && filteredList.size() > 0) {
                correspondingVar = filteredList.get(0);
            }
        }
        handleVariableTypes(correspondingVar);
        if(getItem() != null) {
            setValueText(String.valueOf(getItem().getTheValue()));
        }
    }

    @Override
    protected void processEdit() {
        TemplateUpdate var = getItem();
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
        TemplateUpdate value = getItem();
        if (value != null) {
            setValueText(value.getTheValue());
            setCorrectGraphic();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setValueText(String.valueOf(getItem().getTheValue()));
    }
}
