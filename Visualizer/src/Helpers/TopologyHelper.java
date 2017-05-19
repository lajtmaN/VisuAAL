package Helpers;

import java.io.*;
import Model.UPPAALTopology;
import javafx.scene.control.Alert;
import parsers.CHandler;

/**
 * Created by lajtman on 08-03-2017.
 */
public class TopologyHelper {
    public static void saveTopology(File fileToSaveIn, UPPAALTopology topology) {
        String topologyAsString = CHandler.StringUPPAALTopology(topology);
        try {
            FileHelper.writeContentToFile(fileToSaveIn, topologyAsString);
        } catch (IOException e) {
            GUIHelper.showAlert(Alert.AlertType.WARNING, "Could not save topology to file");
        }
    }

    public static void saveTopology(UPPAALTopology topology) {
        File f = FileHelper.chooseFileToSave(ExtensionFilters.TopologyExtensionFilter);
        if (f != null)
            saveTopology(f, topology);
    }

    public static UPPAALTopology loadFromIncidenseMatrix(File fileToLoadFrom) {
        StringBuilder lines = new StringBuilder();
        String line;
        try (
                InputStream fis = new FileInputStream(fileToLoadFrom);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
        ) {
            while ((line = br.readLine()) != null) {
                lines.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CHandler.getTopologyFromInstantiation(lines.toString());
    }
}
