package View;

import Model.TemplateUpdate;

/**
 * Created by lajtman on 13-03-2017.
 */
public class TemplateUpdateModelTimeEditingCell extends EditingCell<TemplateUpdate, TemplateUpdate> {

    public TemplateUpdateModelTimeEditingCell() {
        fieldType = FieldType.INT_FIELD;
    }

    @Override
    public String getStringValueFromItem(TemplateUpdate item) {
        return String.valueOf(item.getTime());
    }

    @Override
    public void commitEdit(TemplateUpdate item) {
        super.commitEdit(item);
        Integer newValue = Integer.parseInt(getValueText());
        item.setTime(newValue);
    }
}
