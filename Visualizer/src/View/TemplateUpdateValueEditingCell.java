package View;

import Model.CVar;
import Model.TemplateUpdate;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import parsers.RegexHelper;

/**
 * Created by batto on 14-Feb-17.
 */
public class TemplateUpdateValueEditingCell extends TableCell<TemplateUpdate, String> {
    private final TextField textField = new TextField();
    private final ComboBox comboBox = new ComboBox();

    public TemplateUpdateValueEditingCell() {
        /*this.getTableRow().focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue) {
                chooseGraphic(getTemplateUpdate().getTheValue());
            }
        });*/
        textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                processEdit();
            }
        });
        textField.setOnAction(event -> processEdit());
        comboBox.setOnAction(event -> processEdit());

        comboBox.getItems().addAll("true", "false");
    }

    private void chooseGraphic(String value) {
        if(isBooleanType()) {
            setGraphic(comboBox);
            textField.setText(value);
        } else {
            setGraphic(textField);
            comboBox.setValue(value.toString());
        }
    }

    private void processEdit() {
        if(!isBooleanType())
            commitEdit(textField.getText());
        else
            commitEdit(comboBox.getValue().toString());
    }

    @Override
    public void updateItem(String value, boolean empty) {
        super.updateItem(value, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else if (isEditing()) {
            setText(null);
            chooseGraphic(value);
        } else {
            setText(value.toString());
            setGraphic(null);
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        String value = getItem();
        if (value != null) {
            chooseGraphic(value);
            setText(null);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem());
        setGraphic(null);
    }

    // This seems necessary to persist the edit on loss of focus; not sure why:
    @Override
    public void commitEdit(String value) {
        if(canValueParse(value)) {
            super.commitEdit(value);
            getTemplateUpdate().setTheValue(value);
        }
    }

    private boolean canValueParse(String value) {
        TemplateUpdate t = getTemplateUpdate();
        CVar cVar= getCorrespondingCVar(t);
        return (cVar.hasDoubleType() && RegexHelper.isValidDouble(value)
                || cVar.hasIntType() && RegexHelper.isValidInt(value)
                || cVar.hasBoolType() && (value.equals("true") || value.equals("false")));
    }

    private TemplateUpdate getTemplateUpdate() {
       return ((TemplateUpdate)this.getTableRow().getItem());
    }

    private CVar getCorrespondingCVar(TemplateUpdate item) {
        if (item == null) return null;

        ObservableList<CVar> listOfVars = MainWindowController.getInstance().getNonConstConfigVars();
        FilteredList<CVar> filteredList = listOfVars.filtered(p -> p.getName().equals(item.getVariableName()));

        return filteredList != null && filteredList.size() > 0 ? filteredList.get(0) : null;
    }

    private boolean isBooleanType() {
        CVar c = getCorrespondingCVar(getTemplateUpdate());
        if(c != null)
            return c.hasBoolType();
        return false;
    }
}