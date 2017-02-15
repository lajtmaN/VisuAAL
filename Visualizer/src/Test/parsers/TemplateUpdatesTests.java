package parsers;

import Model.TemplateUpdate;
import Model.UPPAALModel;
import org.junit.Test;

/**
 * Created by batto on 15-Feb-17.
 */
public class TemplateUpdatesTests {

    @Test
    public void RemoveTemplateAndAddNew() {
        String uppaalPath = "mac_model_exp.xml";
        UPPAALModel uppaalModel = new UPPAALModel(uppaalPath);
        uppaalModel.load();
        uppaalModel.getTemplateUpdates().add(new TemplateUpdate("test", 17, 21));

        try {
            XmlHandler handler = new XmlHandler(uppaalPath);
            handler.addTemplateUpdatesToModel(uppaalModel.getTemplateUpdates());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Asserts
    }
}