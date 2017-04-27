package Helpers;

import Model.OutputVariable;
import Model.UPPAALProcess;

import java.util.List;
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

    public static String generateSimulationQuery(int timebound, int nrSimulations, List<OutputVariable> outputVariables, List<UPPAALProcess> processes) {
        List<String> vars = outputVariables.stream().map(p -> QueryGenerator.generateSingleVariableQueryPart(p, processes))
                .collect(Collectors.toList());

        return generateQueryStart(nrSimulations, timebound, String.join(", ", vars));
    }

    private static String generateSingleVariableQueryPart(OutputVariable var, List<UPPAALProcess> processes) {
        boolean inScope = var.getScope() != null && var.getScope().length() > 0;
        if (inScope) {
            return handleScopedOutputVariable(var, processes);
        }

        if(var.getIsEdgeData()) {
            return generate2DQuadraticArrayQueryVariables(var.getName(), var.getVariableArraySize());
        } else if(var.getIsNodeData()) {
            return generate1DArrayQueryVariables(var.getName(), var.getVariableArraySize());
        } else {
            return var.getName();
        }
    }

    private static String handleScopedOutputVariable(OutputVariable var, List<UPPAALProcess> processes) {
        //TODO: Assumes processnames and template names are the same -> fx Template Node = process Node(1)
        Stream<String> processQueryList = processes.stream().filter(p -> p.getTemplateName().equals(var.getScope())).map(c -> c.getProcessQueryIdentifier() + "." + var.getName());
        if (var.getIsEdgeData()) {
            processQueryList = processQueryList.map(p -> generate1DArrayQueryVariables(p, var.getVariableArraySize()));
        }
        return String.join(", ", processQueryList.collect(Collectors.toList()));
    }

    private static String generate2DQuadraticArrayQueryVariables(String name, int size) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                res.append(String.format("%1$s[%2$d][%3$d]", name, i, j));
                if (i < size-1 || j < size-1)
                    res.append(", ");
            }
        return res.toString();
    }

    private static String generate1DArrayQueryVariables(String name, int size) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            res.append(String.format("%s[%d]", name, i));
            if (i < size-1)
                res.append(", ");
        }
        return res.toString();
    }
}