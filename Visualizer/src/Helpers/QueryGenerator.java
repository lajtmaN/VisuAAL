package Helpers;

import Model.OutputVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by batto on 08-Feb-17.
 */
public class QueryGenerator {
    public static String generate2DQuadraticArrayQuery(String name, int size, int nrSimulations, long time) {
        String res = generate2DQuadraticArrayQueryVariables(name, size);
        return generateQueryStart(nrSimulations, time, res);
    }


    private static String generateQueryStart(int nrSimulations, long time, String vars) {
        return "simulate " + nrSimulations + " [<=" + time + "] { " + vars + " }";
    }

    public static String generateSimulationQuery(int timebound, int nrSimulations, List<OutputVariable> outputVariables) {
        List<String> vars = outputVariables.stream().map(p -> QueryGenerator.generateSingleVariableQueryPart(p))
                .collect(Collectors.toList());

        return generateQueryStart(nrSimulations, timebound, String.join(", ", vars));
    }

    private static String generateSingleVariableQueryPart(OutputVariable var) {
        if(var.getIsEdgeData()) {
            return generate2DQuadraticArrayQueryVariables(var.getName(), var.getVariableArraySize());
        } else if(var.getIsNodeData()) {
            return generate1DArrayQueryVariables(var.getName(), var.getVariableArraySize());
        } else {
            return var.getName();
        }
    }

    private static String generate2DQuadraticArrayQueryVariables(String name, int size) {
        String res = "";
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                res += String.format("%1$s[%2$d][%3$d] > 0", name, i, j);
                if (i < size-1 || j < size-1) res += ", ";
            }

        return res;
    }

    private static String generate1DArrayQueryVariables(String name, int size) {
        String res = "";
        for (int i = 0; i < size; i++) {
            res += String.format("%s[%d] > 0", name, i);
            if (i < size-1)
                res += ", ";
        }
        return res;
    }
}