package View;

import Model.TemplateUpdate;
import javafx.scene.control.cell.ComboBoxTableCell;

/**
 * Created by batto on 16-Mar-17.
 */
public class  TemplateUpdateNameEditingCell extends ComboBoxTableCell<TemplateUpdate, String> {

    public TemplateUpdateNameEditingCell() {
        super();
        updateComboValues();
    }

    private void updateComboValues() {
        this.getItems().clear();
        this.getItems().addAll(MainWindowController.getInstance().getUppaalModel().getDynamicTemplateVarNames());
    }

    @Override
    public void startEdit() {
        //TODO: Can be optimized to only call when new models are loaded.
        updateComboValues();
        super.startEdit();
    }

    @Override
    public void commitEdit(String newValue) {
        boolean updateValueField = isEditing();
        super.commitEdit(newValue);
        if(updateValueField)
            updateValueGraphic(newValue);
    }

    private void updateValueGraphic(String value) {
        ((TemplateUpdateValueEditingCell)this.getTableRow().getChildrenUnmodifiable().get(1)).setGraphicIfTypeChanged(value);
    }
}
