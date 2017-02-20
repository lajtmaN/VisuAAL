package Helpers;

import View.MainWindowController;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static File copyFileIntoTempFile(File original) throws IOException {
        String content = "";
        for (String s : Files.readAllLines(original.toPath())) {
            content += s + "\n";
        }
        return generateAutoDeletedTempFile(content);
    }
    public static File generateAutoDeletedTempFile(String content) throws IOException {
        File f = File.createTempFile("uppaalvisualizer_", ".tmp");
        f.deleteOnExit();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"))) {
            writer.write(content);
        }
        return f;
    }

    public static File chooseSaveFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select destination file");
        fileChooser.setInitialDirectory(Paths.get(".").toAbsolutePath().normalize().toFile());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("UPPAAL Model", "*.xml"));
        File selectedFile = fileChooser.showSaveDialog(MainWindowController.getInstance().getWindow());
        if(!selectedFile.exists()){
            selectedFile.createNewFile();
        }
        if(selectedFile == null || !selectedFile.exists()) {
            throw new IOException("Error in file creation. File does not exist.");
        }
        return selectedFile;
    }
 }
