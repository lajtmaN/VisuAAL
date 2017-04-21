package parsers.VQParser;

import Helpers.Pair;
import Model.OutputVariable;
import Model.VQ.VQParseTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.VQParser.Generated.vqLexer;
import parsers.VQParser.Generated.vqParser;

import java.text.ParseException;
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
        return parseVQ(input, outputVars, true);
    }

    public static VQParseTree parseVQ(String input, List<OutputVariable> outputVars, boolean throwOnError) throws Exception {
        return parseVQ(input, outputVars.stream().map(OutputVariable::toString).collect(Collectors.toList()), throwOnError);
    }

    public static VQParseTree parseVQ(String input, Collection<String> variables) throws Exception {
        return parseVQ(input, variables, true);
    }

    public static VQParseTree parseVQ(String input, Collection<String> variables, boolean throwOnError) throws ParseException {
        vqParser parser = setupParser(input);
        final String[] parseError = {null};//Yes... this is ugly. But it works :-)

        parser.removeErrorListeners(); //This override prevents the parser from writing to std.err
        parser.addErrorListener(new ConsoleErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                parseError[0] = "line " + line + ":" + charPositionInLine + " " + msg;
            }
        });

        VQListener vqListener = new VQListener(variables);
        new ParseTreeWalker().walk(vqListener, parser.query());

        if (throwOnError && parseError[0] != null)
            throw new ParseException(parseError[0], 0);

        return vqListener.getParseTree();
    }

    public static VQParseTree parse(String vq, List<OutputVariable> outputVariables) {
        try {
            VQParseTree parsedVQ = parseVQ(vq, outputVariables, true);
            parsedVQ.calculateVQType(outputVariables);
            return parsedVQ;
        } catch (Exception e) {
            return null;
        }
    }

}