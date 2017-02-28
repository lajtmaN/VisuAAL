package Helpers;

import View.MainWindowController;
import javafx.stage.FileChooser;
import javafx.stage.Window;

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
        return generateAutoDeletedTempFile(content, getExtension(original.getName()));
    }

    public static File generateAutoDeletedTempFile(String content) throws IOException {
        return generateAutoDeletedTempFile(content, ".tmp");
    }
    public static File generateAutoDeletedTempFile(String content, String extension) throws IOException {
        File f = File.createTempFile("uppaalvisualizer_", extension);
        f.deleteOnExit();
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"))) {
            writer.write(content);
        }
        return f;
    }

    public static File chooseSaveFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select destination file");
        fileChooser.setInitialDirectory(Paths.get(".").toAbsolutePath().normalize().toFile());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("UPPAAL Model", "*.xml"));
        File selectedFile = fileChooser.showSaveDialog(MainWindowController.getInstance().getWindow());

        if (selectedFile == null) {
            return null; //abort
        }
        try {
            if (!selectedFile.exists()) {
                if (!selectedFile.createNewFile()) {
                    return null;
                }
            }
        } catch (IOException e) {
            return null;
        }
        return selectedFile;
    }

    public static File selectFileToLoad(Window window) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select UPPAAL model or simulation");
        fileChooser.setInitialDirectory(Paths.get(".").toAbsolutePath().normalize().toFile());
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("UPPAAL Model", "*.xml"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Simulation", "*.sim"));
        return fileChooser.showOpenDialog(window);
    }
 }
