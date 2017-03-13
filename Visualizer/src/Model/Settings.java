package Model;

import Helpers.GUIHelper;

import java.io.*;
import java.util.Properties;

/**
 * Inspiration: http://www.mkyong.com/java/java-properties-file-examples/
 * Created by lajtman on 13-03-2017.
 */
public class Settings {
    public static final String settingsFileName = "settings.properties";

    private static Settings _instance;
    public static Settings Instance() {
        return _instance;
    }

    static {
        _instance = new Settings();
    }

    private Settings() {
        load();
    }

    private Properties properties;

    private void load() {
        try {
            File propertiesFile = new File(settingsFileName);

            if (!propertiesFile.exists())
                propertiesFile.createNewFile();

            properties = new Properties();
            properties.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            GUIHelper.showError(e.getMessage());
            System.exit(1);
        }
    }
    public void saveChanges() {
        try (OutputStream out = new FileOutputStream(settingsFileName)) {
            properties.store(out, null);
        } catch (IOException e) {
            GUIHelper.showError("Could not save settings to file");
        }
    }

    public String getVerifytaLocation() {
        return properties.getProperty("verifytaLocation");
    }

    public void setVerifytaLocation(String verifytaLocation) {
        properties.setProperty("verifytaLocation", verifytaLocation);
    }
}
