package Model;

import Helpers.GUIHelper;

import java.io.*;
import java.util.Properties;

/**
 * Inspiration: http://www.mkyong.com/java/java-properties-file-examples/
 * Created by lajtman on 13-03-2017.
 */
public class Settings {
    private static final double CassiopeiaLatitude = 57.0123561D;
    private static final double CassiopeiaLongitude = 9.9913622D;

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
    private void saveChanges() {
        try (OutputStream out = new FileOutputStream(settingsFileName)) {
            properties.store(out, null);
        } catch (IOException e) {
            GUIHelper.showError("Could not save settings to file");
        }
    }

    private void set(String key, String value) {
        properties.setProperty(key, value);
        saveChanges();
    }

    private String get(String key) {
        return properties.getProperty(key);
    }
    private String getOrElse(String key, String valueIfNotPresent) {
        String original = get(key);
        if (original == null) {
            set(key, valueIfNotPresent);
        }
        return valueIfNotPresent;
    }

    public String getVerifytaLocation() {
        return get("verifytaLocation");
    }

    public void setVerifytaLocation(String verifytaLocation) {
        set("verifytaLocation", verifytaLocation);
    }

    public String getRecentLoadedModel() {
        return get("recentModel");
    }

    public void setRecentLoadedModel(String recentLoadedModel) {
        set("recentModel", recentLoadedModel);
    }

    public Double getDefaultMapLocationLatitude() {
        return Double.parseDouble(getOrElse("defaultMapLocationLatitude", String.valueOf(CassiopeiaLatitude)));
    }

    public void setDefaultMapLocationLatitude(double lat) {
        set("defaultMapLocationLatitude", String.valueOf(lat));
    }

    public Double getDefaultMapLocationLongitude() {
        return Double.parseDouble(getOrElse("getDefaultMapLocationLongitude", String.valueOf(CassiopeiaLongitude)));
    }

    public void setDefaultMCassiopeiaLongitude(double lng) {
        set("getDefaultMapLocationLongitude", String.valueOf(lng));
    }
}
