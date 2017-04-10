package parsers.VQParser;

import Model.VQ.VQExpression;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.VQParser.Generated.vqLexer;
import parsers.VQParser.Generated.vqParser;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQParse {
    public static VQExpression parseVQ(String input) {
        vqParser parser = setupParser(input);

        VQListener vqListener = new VQListener();
        new ParseTreeWalker().walk(vqListener, parser.query());
        return vqListener.getVQExpression();
    }

    private static vqParser setupParser(String input) {
        ANTLRInputStream in = new ANTLRInputStream(input);
        vqLexer vqLexer = new vqLexer(in);
        CommonTokenStream commonTokenStream = new CommonTokenStream(vqLexer);
        return new vqParser(commonTokenStream);
    }
}