import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Get matrix for connected graph square topology. Input nr of nodes
        //String s = Helpers.ConnectedGraphGenerator.optimizedMatrix(196);

        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Parent root = FXMLLoader.load(getClass().getResource("View/MainWindow.fxml"));
        primaryStage.setTitle("UPPAAL Visualization Application");
        primaryStage.setScene(new Scene(root, 900, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
