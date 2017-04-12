package parsers.VQParser;

import Model.VQ.VQParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.VQParser.Generated.vqLexer;
import parsers.VQParser.Generated.vqParser;

import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQParse {
    double firstGradient, secondGradient, resultValue;

    public static VQParseTree parseVQ(String input, Map<String, Double> variables) throws Exception {
        vqParser parser = setupParser(input);

        VQListener vqListener = new VQListener(variables);
        new ParseTreeWalker().walk(vqListener, parser.query());

        /*if(vq.getSecondGradient() <= vq.getFirstGradient())
            throw new Exception("The maximum gradient must be greater than the minimum gradient");*/

        return vqListener.getParseTree();
    }

    private static vqParser setupParser(String input) {
        ANTLRInputStream in = new ANTLRInputStream(input);
        vqLexer vqLexer = new vqLexer(in);
        CommonTokenStream commonTokenStream = new CommonTokenStream(vqLexer);
        return new vqParser(commonTokenStream);
    }
}