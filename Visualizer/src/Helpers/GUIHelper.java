package Helpers;

import javafx.scene.control.Alert;

/**
 * Created by batto on 10-Feb-17.
 */
public class GUIHelper {
    public static void showAlert(Alert.AlertType alertType, String message) {
        showAlert(alertType, message, "");
    }

    public static void showAlert(Alert.AlertType alertType, String message, String alertTitle){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(message);
        alert.setTitle(alertTitle);
        alert.show();
    }
}

