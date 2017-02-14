package Helpers;

/**
 * Created by lajtman on 14-02-2017.
 */
public class FileHelper {
    public static String simulationFileName(String filename){
        return "simulations/"+filename+".sim";
    }

    public static String getExtension(String filename) {
        return filename.substring(filename.lastIndexOf('.'));
    }
}
