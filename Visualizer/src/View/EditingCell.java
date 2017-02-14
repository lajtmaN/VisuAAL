package View;

import Model.TemplateUpdate;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by batto on 14-Feb-17.
 */
public class EditingCell<T, C> extends TextFieldTableCell<T, C> {
    protected final TextField textField = new TextField();

    public EditingCell() {
        super();
        textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                processEdit();
            }
        });
        textField.setOnAction(event -> processEdit());
    }


    protected void processEdit() { }

    @Override
    public void commitEdit(C value) {
        super.commitEdit(value);
    }

    @Override
    public void startEdit() {
        super.startEdit();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem().toString());
        setGraphic(null);
    }
}
