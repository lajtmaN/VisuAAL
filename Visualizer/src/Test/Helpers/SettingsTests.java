package Helpers;

import Model.Settings;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by lajtman on 13-03-2017.
 */
public class SettingsTests {

    @Test
    public void canSaveAndLoadVerifytaLocation() throws IOException {
        String verifytaLocation = "C:\\Program Files (x86)\\UPPAAL\\uppaal-4.1.19\\bin-Linux\\verifyta";

        Settings settings = Settings.Instance();
        settings.setVerifytaLocation(verifytaLocation);

        String actualLoaded = settings.getVerifytaLocation();
        assertEquals(verifytaLocation, actualLoaded);
    }
}
