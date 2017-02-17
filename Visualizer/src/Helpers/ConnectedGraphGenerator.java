package Helpers;

/**
 * Created by batto on 13-Feb-17.
 */
public class ConnectedGraphGenerator {
    public static void matrix(int size) {
        String s = "int CONFIG_connected[CONFIG_NR_NODES][CONFIG_NR_NODES] = {";
        for(int i= 0 ; i < size; i++) {
            s += "\n{";
            for(int j= 0 ; j < size; j++) {
                if(square(i,j, (int)Math.sqrt(size))) {
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

    public static boolean square(int my_id, int other_id, int NR_NODES_SQR_ROOT) {
        if(my_id % NR_NODES_SQR_ROOT == 0)
            return my_id-other_id == -1 || my_id-other_id == NR_NODES_SQR_ROOT || my_id-other_id == - NR_NODES_SQR_ROOT;
        if(my_id % NR_NODES_SQR_ROOT == NR_NODES_SQR_ROOT - 1)
            return my_id-other_id == 1 || my_id-other_id == NR_NODES_SQR_ROOT || my_id-other_id == - NR_NODES_SQR_ROOT;
        return my_id-other_id == -1 || my_id-other_id == 1 || my_id-other_id == NR_NODES_SQR_ROOT || my_id-other_id == - NR_NODES_SQR_ROOT;
    }
}
