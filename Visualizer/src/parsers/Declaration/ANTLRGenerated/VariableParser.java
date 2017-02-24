package parsers.Declaration.ANTLRGenerated;

import Model.UPPAALVariable;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.Declaration.ANTLRGenerated.uppaalParser.XtaContext;
import parsers.Declaration.VariableReaderListener;

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

    public static ArrayList<UPPAALVariable> getDeclarations(String declaration) {
        VariableReaderListener listener = new VariableReaderListener();
        new ParseTreeWalker().walk(listener, getRootElement(declaration));
        return listener.getVariables();
    }
    
}
