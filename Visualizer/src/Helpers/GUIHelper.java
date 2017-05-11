package Helpers;

import Model.Settings;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.File;

/**
 * Created by batto on 10-Feb-17.
 */
public class GUIHelper {
    public static void showError(String error) {showAlert(Alert.AlertType.ERROR, error); }
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

    public static void showExtendedInformation(String title, String resume, String largeDescription) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(resume);
        TextArea largeDescriptionField = new TextArea(largeDescription);
        largeDescriptionField.setEditable(false);
        largeDescriptionField.setWrapText(true);
        largeDescriptionField.setMaxWidth(Double.MAX_VALUE);
        largeDescriptionField.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(largeDescriptionField, Priority.ALWAYS);
        GridPane.setHgrow(largeDescriptionField, Priority.ALWAYS);

        alert.getDialogPane().setExpandableContent(largeDescriptionField);

        alert.showAndWait();
    }

    public static String getVerifytaLocationFromUser() {
        String verifytaLocation = Settings.Instance().getVerifytaLocation();

        if (verifytaLocation != null && (
                verifytaLocation.endsWith("verifyta") || verifytaLocation.endsWith("verifyta.exe") //Win & Linux
        )) {
            if (new File(verifytaLocation).exists())
                return verifytaLocation;
        }

        File verifytaFile = FileHelper.chooseFileToLoad("Select verifyta executable from UPPAAL", null, ExtensionFilters.VerifytaExtensionFilter);
        if (verifytaFile == null)
            return null;

        verifytaLocation = verifytaFile.getPath();
        Settings.Instance().setVerifytaLocation(verifytaLocation);

        return verifytaLocation;
    }
}

