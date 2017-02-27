package parsers.Declaration;

import Model.CVar;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.Declaration.ANTLRGenerated.uppaalLexer;
import parsers.Declaration.ANTLRGenerated.uppaalParser;
import parsers.Declaration.ANTLRGenerated.uppaalParser.XtaContext;

import java.util.ArrayList;

/**
 * Created by rasmu on 24/02/2017.
 */
public class VariableParser {
    private static XtaContext getRootElement(String declarations) {
        ANTLRInputStream in = new ANTLRInputStream(declarations);
        uppaalLexer lexer = new uppaalLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        uppaalParser parser = new uppaalParser(tokens);
        return parser.xta();
    }

    public static ArrayList<CVar> getInstantiations(String declaration) {
        VariableInstantiationReader listener = new VariableInstantiationReader();
        new ParseTreeWalker().walk(listener, getRootElement(declaration));
        return listener.getVariables();
    }
}
