package Helpers;

import Model.Settings;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventTarget;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.effect.Glow;
import javafx.util.Duration;

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

    public static String getVerifytaLocationFromUser() {
        String verifytaLocation = Settings.Instance().getVerifytaLocation();

        if (verifytaLocation != null && verifytaLocation.endsWith("verifyta.exe")) {
            if (new File(verifytaLocation).exists())
                return verifytaLocation;
        }

        File verifytaFile = FileHelper.chooseFileToLoad("Select verifyta executable from UPPAAL", null, ExtensionFilters.VerifytaExtensionFilter);
        if (verifytaFile == null)
            return null;

        verifytaLocation = verifytaFile.getPath();
        Settings.Instance().setVerifytaLocation(verifytaLocation);
        Settings.Instance().saveChanges();

        return verifytaLocation;
    }
}

