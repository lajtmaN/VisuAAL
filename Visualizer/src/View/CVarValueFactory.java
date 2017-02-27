package View;

import Model.CVar;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.util.Pair;


/**
 * Created by rasmu on 27/02/2017.
 */
public class CVarValueFactory implements Callback<TableColumn.CellDataFeatures<CVar, CVar>, ObservableValue<CVar>> {
        @SuppressWarnings("unchecked")
        @Override
        public ObservableValue<CVar> call(TableColumn.CellDataFeatures<CVar, CVar> data) {
            Object value = data.getValue();
            return ((CVar)value).getObjectProperty();
        }
    }
