package Model;

import Helpers.FileHelper;
import org.graphstream.graph.Graph;
import parsers.RegexHelper;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by lajtman on 13-02-2017.
 */
public class Simulation implements Serializable {
    private UPPAALModel model;
    private ArrayList<SimulationEdgePoint> run;
    private String query;

    public Simulation(UPPAALModel uppModel, String uppQuery, ArrayList<SimulationEdgePoint> points) {
        query = uppQuery;
        model = uppModel;
        run = points;
        model.getTopology().setEdges(run);
        model.getTopology().updateGraph();
        model.getTopology().unmarkAllEdges();
    }

    public Graph getGraph() {
        return model.getTopology().getGraph();
    }

    public void markEdgeAtTime(Number newValue) {
        model.getTopology().unmarkAllEdges();
        run.stream().filter(p -> p.getClock() < newValue.doubleValue() && p.getValue() > 0).forEach(p -> model.getTopology().markEdge(p));
    }

    public void markEdgesInRealTime() {
        model.getTopology().unmarkAllEdges();
        model.getTopology().startAddingEdgesOverTime(run);
    }

    public int queryTimeBound() {
        return Integer.parseInt(RegexHelper.getFirstMatchedValueFromRegex("\\[<=(\\d+)\\]", query));
    }

    public void save(String fileName){
        try {
            File file = new File(FileHelper.simulationFileName(fileName));
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileOutputStream fileOut = new FileOutputStream(file,false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }
    public static Simulation load(String fileName){
        Simulation sim = null;
        try {
            FileInputStream fileIn = new FileInputStream(FileHelper.simulationFileName(fileName));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sim = (Simulation) in.readObject();
            in.close();
            fileIn.close();
            sim.model.load();
            sim.model.getTopology().setEdges(sim.run);
            sim.model.getTopology().updateGraph();
            sim.model.getTopology().unmarkAllEdges();
        }catch(Exception i) {
            i.printStackTrace();
            return null;
        }
        return sim;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Simulation that = (Simulation) o;

        if (!model.equals(that.model)) return false;
        if (!run.equals(that.run)) return false;
        return query.equals(that.query);
    }

    @Override
    public int hashCode() {
        int result = model.hashCode();
        result = 31 * result + run.hashCode();
        result = 31 * result + query.hashCode();
        return result;
    }

}
