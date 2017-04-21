package parsers.VQParser;

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

    public static VQParseTree parse(String vq, List<OutputVariable> outputVariables) {
        VQParseTree parsedVQ = syntaxCheck(vq, outputVariables.stream().map(OutputVariable::toString).collect(Collectors.toList()));
        parsedVQ.calculateVQType(outputVariables);
        return parsedVQ;
    }

    public static VQParseTree syntaxCheck(String input, Collection<String> variables) {
        vqParser parser = setupParser(input);
        final String[] parseError = {null};//Yes... this is ugly. But it works :-)

        parser.removeErrorListeners(); //This override prevents the parser from writing to std.err
        parser.addErrorListener(new ConsoleErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                parseError[0] = "At " + charPositionInLine + ": " + msg;
            }
        });

        VQListener vqListener = new VQListener(variables);
        new ParseTreeWalker().walk(vqListener, parser.query());

        if (parseError[0] != null)
            vqListener.getParseTree().addToParseError(parseError[0]);

        return vqListener.getParseTree();
    }
}