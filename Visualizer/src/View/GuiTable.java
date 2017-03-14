package View;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * Created by batto on 14-Mar-17.
 */
public class GuiTable<RowDataType> extends TableView<RowDataType> {
    public GuiTable() {}

    public <ValueType> void addColumn(String colName) {
        TableColumn<RowDataType, ValueType> col = new TableColumn(colName);
        this.getColumns().addAll(col);
    }

}