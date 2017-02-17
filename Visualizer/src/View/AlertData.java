package View;

import Helpers.GUIHelper;
import javafx.scene.control.Alert;

/**
 * Created by batto on 17-Feb-17.
 */
public class AlertData {
    javafx.scene.control.Alert.AlertType alertType;
    String title;
    String msg;

    public AlertData(javafx.scene.control.Alert.AlertType alertType, String title, String msg) {
        this.alertType = alertType;
        this.title = title;
        this.msg = msg;
    }

    public AlertData() {}

    public javafx.scene.control.Alert.AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(javafx.scene.control.Alert.AlertType alertType) {
        this.alertType = alertType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void showAlert() {
        GUIHelper.showAlert(getAlertType(), getMsg(), getTitle());
    }
}
