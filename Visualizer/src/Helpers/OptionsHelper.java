package Helpers;

import View.Options.EnableDisableSimulationOption;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * Created by lajtman on 28-03-2017.
 */
public class OptionsHelper {
    public static Callback<ListView<EnableDisableSimulationOption>, ListCell<EnableDisableSimulationOption>> optionListCell() {
        return CheckBoxListCell.forListView(item -> item.onProperty(), new StringConverter<EnableDisableSimulationOption>() {
            @Override
            public String toString(EnableDisableSimulationOption object) {
                return object.getDescription();
            }
            @Override
            public EnableDisableSimulationOption fromString(String string) {
                return null;
            }
        });
    }
}
