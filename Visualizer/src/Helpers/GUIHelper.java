package Helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by batto on 10-Feb-17.
 */
public class GUIHelper {
    public static void showInformation(String information) {
        showAlert(Alert.AlertType.INFORMATION, information);
    }
    public static void showAlert(Alert.AlertType alertType, String message) {
        showAlert(alertType, message, "");
    }

    public static void showAlert(Alert.AlertType alertType, String message, String alertTitle){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(message);
        alert.setTitle(alertTitle);
        alert.show();
    }

    public static boolean showPrompt(String message) {return showPrompt(message, "");}
    public static boolean showPrompt(String message, String promptTitle) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);
        alert.setTitle(promptTitle);
        alert.showAndWait();
        return alert.getResult() == ButtonType.YES;
    }
}

