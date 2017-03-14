package View.Options;

import Model.Simulation;
import Helpers.TopologyHelper;

/**
 * Created by Tim on 09-03-2017.
 */
public class ExportTopologyOption extends SimulationOption {
    @Override
    public String getDescription() {
        return "Export Topology...";
    }

    @Override
    public void startAction(Simulation currentSimulation) {
        TopologyHelper.saveTopology(currentSimulation.getTopology());
    }
}
