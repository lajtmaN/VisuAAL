package parsers;

import Model.CVar;
import Model.OutputVariable;
import Model.UPPAALEdge;
import Model.UPPAALTopology;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by lajtman on 07-02-2017.
 */
public class UPPAALParser {

    public static ArrayList<CVar<Integer>> getUPPAALConfigConstants(String uppaalFilename) {
        try {
            XmlHandler handler = new XmlHandler(uppaalFilename);
            return CHandler.getConstants(handler.getGlobalDeclarations());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UPPAALTopology getUPPAALTopology(String uppaalFilename){
        try{
            XmlHandler handler = new XmlHandler(uppaalFilename);
            return CHandler.getTopology(handler.getGlobalDeclarations());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static File generateQueryFile(String query) throws IOException {
        File tempFile = new File("uppaalquery.q");
        Writer writer = new BufferedWriter(new FileWriter(tempFile));
        writer.write(query);
        writer.close();
        return tempFile;
    }

    public static ArrayList<OutputVariable> getUPPAALOutputVars(String uppaalFilePath) {
        try {
            ArrayList<String> vars = CHandler.getOutputVars(new XmlHandler(uppaalFilePath).getGlobalDeclarations());
            if(vars != null) {
                ArrayList<OutputVariable> outVars = new ArrayList<>();
                for(String s : vars)
                    outVars.add(new OutputVariable(s));
                return outVars;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
