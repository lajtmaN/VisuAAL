package parsers;

import Helpers.FileHelper;
import Model.TemplateUpdate;
import Model.UPPAALModel;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by batto on 15-Feb-17.
 */
public class TemplateUpdatesTests {

    @Test
    public void RemoveTemplateAndAddNew() throws IOException {
        File f = FileHelper.copyFileIntoTempFile(new File("mac_model_exo.xml"));
        String uppaalPath = f.getPath();
        UPPAALModel uppaalModel = new UPPAALModel(uppaalPath);
        uppaalModel.load();
        uppaalModel.getTemplateUpdates().add(new TemplateUpdate("test", 17, 21));

        try {
            XmlHandler handler = new XmlHandler(uppaalPath);
            handler.addTemplateUpdatesToModel(uppaalModel.getTemplateUpdates());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Asserts. Evt tæl antal templates før og efter fjernelse af template
    }
}