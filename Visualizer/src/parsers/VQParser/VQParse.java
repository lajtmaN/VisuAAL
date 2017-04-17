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
        return parseVQ(input, outputVars.stream().map(OutputVariable::getName).collect(Collectors.toList()));
    }

    public static VQParseTree parseVQ(String input, Collection<String> variables) throws Exception {
        vqParser parser = setupParser(input);
        final boolean[] anyErrors = {false};

        parser.removeErrorListeners(); //This override prevents the parser from writing to std.err
        parser.addErrorListener(new ConsoleErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                anyErrors[0] = true;
            }
        });

        VQListener vqListener = new VQListener(variables);
        new ParseTreeWalker().walk(vqListener, parser.query());

        if (anyErrors[0])
            throw new Exception();

        return vqListener.getParseTree();
    }

    public enum VQType { Edge, Node }

    public static Pair<VQParseTree, VQType> parse(String vq, List<OutputVariable> outputVariables) {
        try {
            VQParseTree parsedVQ = parseVQ(vq, outputVariables.stream().map(OutputVariable::getName).collect(Collectors.toList()));
            VQType type = getVQType(vq, outputVariables);
            return new Pair<>(parsedVQ, type);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean validVQ(String vq, List<OutputVariable> allVars) {
        return parse(vq, allVars) != null;
    }

    public static VQType getVQType(String vq, List<OutputVariable> allVars) {
        //TODO: Calculate which variables is actually used in the VQ
        //TODO: Get the types from allVars and check if all is edge or all node.
        //TODO: Throw exception if mixed types
        return VQType.Edge;
    }
}