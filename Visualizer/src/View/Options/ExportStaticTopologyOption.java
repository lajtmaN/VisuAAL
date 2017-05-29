package View.Options;

import Helpers.ExtensionFilters;
import Helpers.FileHelper;
import Model.Simulations;
import java.io.*;

/**
 * Created by lajtman on 29-05-2017.
 */
public class ExportStaticTopologyOption extends SimulationOption  {
    public ExportStaticTopologyOption(Simulations simulations) {
        super(simulations);
    }

    @Override
    public String getDescription() {
        return "Static Topology...";
    }

    @Override
    public void startAction() {
        File topoFile = FileHelper.chooseFileToSave(ExtensionFilters.TopologySerializationFilter);
        if (topoFile == null)
            return;

        simulations.getTopology().save(topoFile.getPath());
    }
}