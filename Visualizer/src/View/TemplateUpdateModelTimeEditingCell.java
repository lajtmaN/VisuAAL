package View;

import Model.TemplateUpdate;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import parsers.RegexHelper;

/**
 * Created by lajtman on 13-03-2017.
 */
public class TemplateUpdateModelTimeEditingCell extends TableCell<TemplateUpdate, Number> {

    private final TextField textField = new TextField();

    public TemplateUpdateModelTimeEditingCell() {
        textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                processEdit();
            }
        });
        textField.setOnAction(event -> processEdit());
    }

    private void processEdit() {
        String text = textField.getText();
        if (RegexHelper.isValidInt(text)) {
            commitEdit(Integer.parseInt(text));
        } else {
            cancelEdit();
        }
    }

    @Override
    public void updateItem(Number value, boolean empty) {
        super.updateItem(value, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else if (isEditing()) {
            setText(null);
            textField.setText(value.toString());
            setGraphic(textField);
        } else {
            setText(value.toString());
            setGraphic(null);
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        Number value = getItem();
        if (value != null) {
            textField.setText(value.toString());
            setGraphic(textField);
            setText(null);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem().toString());
        setGraphic(null);
    }

    // This seems necessary to persist the edit on loss of focus; not sure why:
    @Override
    public void commitEdit(Number value) {
        super.commitEdit(value);
    }
}
