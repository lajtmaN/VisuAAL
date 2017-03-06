package parsers.Declaration;

import Model.CVar;
import Model.UPPAALTopology;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import parsers.CHandler;
import parsers.Declaration.ANTLRGenerated.uppaalLexer;
import parsers.Declaration.ANTLRGenerated.uppaalParser;
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

    public static ArrayList<CVar> getInstantiations(String declaration) {
        VariableInstantiationReader listener = new VariableInstantiationReader();
        new ParseTreeWalker().walk(listener, getRootElement(declaration));
        return listener.getVariables();
    }


    public static String updateAllDeclarations(String decl, List<CVar> updatedCVars) {
        return updateAllDeclarations(decl, updatedCVars, null);
    }

    public static String updateTopologyAndNrNodes(String globalDecls, UPPAALTopology top) {
        return updateAllDeclarations(globalDecls, new ArrayList<>(), top);
    }

    /**
     * Pretty prints the entire declaration and returns an updated source code with updated declarations
     * @param updatedCVars
     * @return
     */
    public static String updateAllDeclarations(String decl, List<CVar> updatedCVars, UPPAALTopology topology) {
        CommonTokenStream tokens = getTokenStream(decl);
        String topologyString = CHandler.StringUPPAALTopology(topology);

        if(updatedCVars == null)
            updatedCVars = new ArrayList<>();
        if(topology != null)
            updatedCVars = updateNrNodes(updatedCVars, topology.getNumberOfNodes());

        DeclarationUpdater updater = new DeclarationUpdater(tokens, updatedCVars, topologyString);
        ParseTreeWalker.DEFAULT.walk(updater, new uppaalParser(tokens).xta());
        return updater.updatedDeclaration();
    }

    private static List<CVar> updateNrNodes(List<CVar> updatedCVars, int nrNodesValue) {
        boolean foundNrNodes = false;
        for (CVar v : updatedCVars) {
            if (v.getName().equals("CONFIG_NR_NODES")) {
                v.setValue(String.valueOf(nrNodesValue));
                foundNrNodes = true;
                break;
            }
        }
        if(!foundNrNodes)
            updatedCVars.add(new CVar("CONFIG_NR_NODES", String.valueOf(nrNodesValue)));

        return updatedCVars;
    }
}
