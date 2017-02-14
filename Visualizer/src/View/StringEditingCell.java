package View;

/**
 * Created by batto on 14-Feb-17.
 */
public class StringEditingCell<T> extends EditingCell<T, String>{

    public StringEditingCell(){
        super();


    }
    @Override
    protected void processEdit() {
        String text = textField.getText();
        commitEdit(text);
    }

    @Override
    public void startEdit() {
        super.startEdit();
        String string = getItem();
        if (string != null) {
            textField.setText(string);
            setGraphic(textField);
            setText(null);
        }

    }
}


