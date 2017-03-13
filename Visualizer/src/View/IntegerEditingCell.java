package View;

/**
 * Created by batto on 14-Feb-17.
 */

/**
 * IntegerEditingCell
 * @param <T> Type that contains the Integer property
*  @deprecated This class does not work. It will update the binded property..
 */
@Deprecated
public class IntegerEditingCell<T> extends EditingCell<T, Integer> {

    public IntegerEditingCell() {
        fieldType = FieldType.INT_FIELD;
        startEdit();
    }

    @Override
    public String getStringValueFromItem(Integer item) {
        return String.valueOf(item);
    }

    @Override
    public void commitEdit(Integer oldValue) {
        Integer newValue = Integer.parseInt(getValueText());
        super.commitEdit(newValue);
        itemProperty().setValue(newValue);
    }
}
