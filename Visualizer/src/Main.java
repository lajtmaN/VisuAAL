import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Parent root = FXMLLoader.load(getClass().getResource("View/TopologyViewer/TopologyViewer.fxml"));
        primaryStage.setTitle("UPPAAL Visualization Application");
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();

        matrix();
    }

    private static void matrix() {
        int size = 16;
        String s = "int connected[NR_NODES][NR_NODES] = {";
        for(int i= 0 ; i < size; i++) {
            s += "\n{";
            for(int j= 0 ; j < size; j++) {
                if(square(i,j)) {
                    s += "1";
                } else {
                    s += "0";
                }
                if(j < size-1)
                    s+=",";
            }
            s += "}";
            if(i < size-1) {
                s += ",";
            }
        }
        s+= "\n};";
        System.out.println(s);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean square(int my_id, int other_id) {
        int NR_NODES_SQR_ROOT = 4;
        if(my_id % NR_NODES_SQR_ROOT == 0)
            return my_id-other_id == -1 || my_id-other_id == NR_NODES_SQR_ROOT || my_id-other_id == - NR_NODES_SQR_ROOT;
        if(my_id % NR_NODES_SQR_ROOT == NR_NODES_SQR_ROOT - 1)
            return my_id-other_id == 1 || my_id-other_id == NR_NODES_SQR_ROOT || my_id-other_id == - NR_NODES_SQR_ROOT;
        return my_id-other_id == -1 || my_id-other_id == 1 || my_id-other_id == NR_NODES_SQR_ROOT || my_id-other_id == - NR_NODES_SQR_ROOT;
    }
}
