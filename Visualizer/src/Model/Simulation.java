package Model;

import Helpers.FileHelper;
import Helpers.GUIHelper;
import javafx.scene.control.Alert;
import org.graphstream.graph.Graph;
import parsers.RegexHelper;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by lajtman on 13-02-2017.
 */
public class Simulation implements Serializable {
    private UPPAALModel model;
    private final List<? extends SimulationPoint> run;
    private String query;
    private int currentSimulationIndex = 0;

    public Simulation(UPPAALModel uppModel, String uppQuery, List<SimulationPoint> points) {
        query = uppQuery;
        model = uppModel;
        model.getTopology().updateGraph();
        model.getTopology().unmarkAllEdges();

        if (getModelTimeUnit() != 1) {
            for (SimulationPoint p : points) {
                p.setClock(p.getClock() * getModelTimeUnit());
            }
        }

        run = points;
    }

    public Graph getGraph() {
        return model.getTopology().getGraph();
    }

    public double getModelTimeUnit() {
        return model.getModelTimeUnit();
    }

    public List<? extends SimulationPoint> getRun() {
        return run;
    }

    public void markGraphAtTime(Number oldTimeValue, Number newTimeValue) {
        double newTime = newTimeValue.doubleValue();
        double oldTime = oldTimeValue.doubleValue();
        if (newTime > oldTime)
            markGraphForward(newTime, oldTime);
        else
            markGraphBackwards(newTime, oldTime);
    }

    private void markGraphForward(double newTimeValue, double oldTime) {
        SimulationPoint sp;
        while((sp = run.get(currentSimulationIndex)).getClock() < newTimeValue) {
            if(sp.getClock() > oldTime) {
                model.getTopology().handleUpdate(sp, sp.getValue() > 0);
            }
            if (currentSimulationIndex + 1 >= run.size())
                break;
            if (run.get(currentSimulationIndex + 1).getClock() <= newTimeValue)
                currentSimulationIndex++;
            else break;
        }
    }

    private void markGraphBackwards(double newTimeValue, double oldTime) {
        SimulationPoint sp;
        while((sp = run.get(currentSimulationIndex)).getClock() > newTimeValue) {
            if(sp.getClock() < oldTime) {
                model.getTopology().handleUpdate(sp, sp.getValue() == 0);
            }
            if (currentSimulationIndex - 1 < 0)
                break;
            if (run.get(currentSimulationIndex - 1).getClock() >= newTimeValue)
                currentSimulationIndex--;
            else break;
        }
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
            sim.model.getTopology().updateGraph();
            sim.model.getTopology().unmarkAllEdges();
            return sim;
        } catch(InvalidClassException i) {
            GUIHelper.showAlert(Alert.AlertType.ERROR, "The simulation that you tried to load was created by an older version of this program.");
        } catch (Exception ignored) {

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
