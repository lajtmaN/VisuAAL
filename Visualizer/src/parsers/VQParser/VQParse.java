package parsers.VQParser;

import Helpers.Pair;
import Model.OutputVariable;
import Model.VQ.VQParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.VQParser.Generated.vqLexer;
import parsers.VQParser.Generated.vqParser;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQParse {

    private static vqParser setupParser(String input) {
        ANTLRInputStream in = new ANTLRInputStream(input);
        vqLexer vqLexer = new vqLexer(in);
        CommonTokenStream commonTokenStream = new CommonTokenStream(vqLexer);
        return new vqParser(commonTokenStream);
    }

    public static VQParseTree parseVQ(String input, List<OutputVariable> outputVars) throws Exception {
        return parseVQ(input, outputVars, true);
    }

    public static VQParseTree parseVQ(String input, List<OutputVariable> outputVars, boolean throwOnError) throws Exception {
        return parseVQ(input, outputVars.stream().map(OutputVariable::toString).collect(Collectors.toList()), throwOnError);
    }

    public static VQParseTree parseVQ(String input, Collection<String> variables) throws Exception {
        return parseVQ(input, variables, true);
    }

    public static VQParseTree parseVQ(String input, Collection<String> variables, boolean throwOnError) throws Exception {
        vqParser parser = setupParser(input);
        final boolean[] anyErrors = {false}; //Yes... this is ugly. But it works :-)

        parser.removeErrorListeners(); //This override prevents the parser from writing to std.err
        parser.addErrorListener(new ConsoleErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                anyErrors[0] = true;
            }
        });

        VQListener vqListener = new VQListener(variables);
        new ParseTreeWalker().walk(vqListener, parser.query());

        if (throwOnError && anyErrors[0])
            throw new Exception();

        return vqListener.getParseTree();
    }

    public enum VQType { Edge, Node, Unknown}

    public static Pair<VQParseTree, VQType> parse(String vq, List<OutputVariable> outputVariables) {
        try {
            VQParseTree parsedVQ = parseVQ(vq, outputVariables, true);
            VQType type = getVQType(parsedVQ, outputVariables);
            return new Pair<>(parsedVQ, type);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean validVQ(String vq, List<OutputVariable> allVars) {
        Pair<VQParseTree, VQType> parsed = parse(vq, allVars);
        return validVQ(parsed);
    }

    public static boolean validVQ(Pair<VQParseTree, VQType> parsedVQ) {
        return parsedVQ != null && parsedVQ.getSecond() != VQType.Unknown;
    }

    public static VQType getVQType(VQParseTree vq, List<OutputVariable> allVars) throws Exception {
        VQType foundType = VQType.Unknown;
        for (String varInVQ : vq.getUsedVariables()) {
            OutputVariable usedVar = allVars.stream()
                    .filter(o -> o.toString().equals(varInVQ))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Could not find variable" + varInVQ));

            if (usedVar.getIsNodeData()) {
                if (foundType == VQType.Edge)
                    throw new Exception("Mixed both Edge and Node types");

                foundType = VQType.Node;
            }
            else if (usedVar.getIsEdgeData()) {
                if (foundType == VQType.Node)
                    throw new Exception("Mixed both Edge and Node types");

                foundType = VQType.Edge;
            }
            else {
                throw new Exception("Cannot use global variables");
            }
        }
        return foundType;
    }
}