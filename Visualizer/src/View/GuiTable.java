package View;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Created by batto on 14-Mar-17.
 */
public class GuiTable<T> extends TableView<T> {
    private GuiTable() {}


    public <S> void addColumn(String colName) {
        TableColumn<T, S> col = new TableColumn(colName);
        this.getColumns().addAll(col);
        //TODO: cellfactory
    }
}
