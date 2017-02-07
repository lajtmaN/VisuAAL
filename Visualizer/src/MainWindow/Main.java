package MainWindow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static int windowHeight = 600;
    public static int windowWidth = 600;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, windowHeight, windowWidth));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
