package Helpers;

/**
 * Created by batto on 08-Feb-17.
 */
public class QueryGenerator {
    public static String Generate2DQuadraticArrayQuery(String name, int size, int nrSimulations, long time) {
        String res = "";
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                res += String.format(" %1$s[%2$d][%3$d] > 0", name, i, j);
                if (i < size-1 || j < size-1) res += ",";
            }

        return GenerateQueryStart(nrSimulations, time, res);
    }

    public static String GenerateQueryStart(int nrSimulations, long time, String vars) {
        return "simulate " + nrSimulations + " [<=" + time + "] {" + vars + "}";
    }
}