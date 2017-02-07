package UPPAALExecutor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {

    @FXML
    private TextField ModelPathField;
    @FXML
    private TextField ModelNameField;
    @FXML
    private TextArea ResultArea;

    public void ExecuteQuery(ActionEvent event){
        String modelNameText = ModelNameField.getText();
        String modelPathText = ModelPathField.getText();
        if(modelNameText.length() == 0 || modelPathText.length() == 0) //Invalid input parameters
        {
            return;
        }
        ResultArea.setText("Calculating");

        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "cd " + modelPathText + " && verifyta " + modelNameText
        );
        builder.redirectErrorStream(true);
        try{
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String result = "";
        while(true){
            try {
                String line = r.readLine();
                if(line==null) {break;}
                result += line + "\n";
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        ResultArea.setText(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
