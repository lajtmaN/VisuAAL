package MainWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private WebView webView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadWebsite(null);
        System.out.println(getArborPageLocation());
    }

    public void loadWebsite(ActionEvent actionEvent) {
        webView.getEngine().load(getArborPageLocation());
    }

    public String getArborPageLocation() {
        return "file:///" + Paths.get("src", "Arbor", "index.html").normalize().toAbsolutePath().toString();
    }
}
