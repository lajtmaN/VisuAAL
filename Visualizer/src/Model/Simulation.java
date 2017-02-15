package Model;

import Helpers.FileHelper;
import org.graphstream.graph.Graph;
import parsers.RegexHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

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

    public static Simulation load(String fileName) {
        return load(new File(FileHelper.simulationFileName(fileName)));
    }
    public static Simulation load(File file){
        if (!Objects.equals(FileHelper.getExtension(file.getName()), ".sim"))
            throw new IllegalArgumentException("Only files with named *.sim can be loaded");

        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Simulation sim = (Simulation) in.readObject();
            in.close();
            fileIn.close();
            //sim.model.load();
            sim.model.getTopology().setEdges(sim.run);
            sim.model.getTopology().updateGraph();
            sim.model.getTopology().unmarkAllEdges();
            return sim;
        } catch(Exception i) {
            i.printStackTrace();

        }
        return null;
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
