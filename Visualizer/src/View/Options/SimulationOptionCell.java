package View.Options;

import javafx.scene.control.ListCell;

/**
 * Created by Tim on 09-03-2017.
 */
public class SimulationOptionCell extends ListCell<SimulationOption> {

    @Override
    protected void updateItem(SimulationOption item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null)
            setText(item.getDescription());
    }
}
