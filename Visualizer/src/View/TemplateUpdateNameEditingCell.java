package View;

import Model.TemplateUpdate;

/**
 * Created by batto on 15-Mar-17.
 */
public class TemplateUpdateNameEditingCell extends EditingCell<TemplateUpdate, String> {

    public TemplateUpdateNameEditingCell() {
        super();
        fieldType = FieldType.COMBO_BOX_STRING_FIELD;
        setCorrectGraphic();
        comboBox.getItems().clear();
        comboBox.getItems().addAll(MainWindowController.getInstance().getUppaalModel().getDynamicTemplateVarNames());

        //TODO: How to set the initial value?
        setValueText(getRowObject().getVariableName());
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
    }

    @Override
    public String getStringValueFromItem(String item) {
        return item;
    }

    // This seems necessary to persist the edit on loss of focus; not sure why:

    @Override
    public void commitEdit(String value) {
        super.commitEdit(value);
        //setValueText(value);
    }

    private void setValueField() {
        this.getTableRow().getChildrenUnmodifiable();
    }
}