package parsers.Declaration.ANTLRGenerated;

import Model.CVar;
import Model.UPPAALVariable;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.Declaration.ANTLRGenerated.uppaalParser.XtaContext;
import parsers.Declaration.DeclarationUpdater;
import parsers.Declaration.VariableInstantiationReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rasmu on 24/02/2017.
 */
public class VariableParser {
    private static CommonTokenStream getTokenStream(String decls) {
        ANTLRInputStream in = new ANTLRInputStream(decls);
        uppaalLexer lexer = new uppaalLexer(in);
        return new CommonTokenStream(lexer);
    }

    private static uppaalParser getParser(String declarations) {
        return new uppaalParser(getTokenStream(declarations));
    }

    private static XtaContext getRootElement(String declarations) {
        return getParser(declarations).xta();
    }

    public static ArrayList<UPPAALVariable> getInstantiations(String declaration) {
        VariableInstantiationReader listener = new VariableInstantiationReader();
        new ParseTreeWalker().walk(listener, getRootElement(declaration));
        return listener.getVariables();
    }

    /**
     * Pretty prints the entire declaration and returns an updated source code with updated declarations
     * @param updatedCVars
     * @return
     */
    public static String updateAllDeclarations(String decl, List<CVar<Integer>> updatedCVars) {
        CommonTokenStream tokens = getTokenStream(decl);
        DeclarationUpdater updater = new DeclarationUpdater(tokens, updatedCVars);
        ParseTreeWalker.DEFAULT.walk(updater, new uppaalParser(tokens).xta());
        return updater.updatedDeclaration();
    }
}
