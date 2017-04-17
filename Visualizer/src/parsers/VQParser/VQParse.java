package parsers.VQParser;

import Model.OutputVariable;
import Model.VQ.VQParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
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

    public static VQParseTree parseVQ(String input, Collection<String> variables) throws Exception {
        vqParser parser = setupParser(input);

        VQListener vqListener = new VQListener(variables);
        new ParseTreeWalker().walk(vqListener, parser.query());

        return vqListener.getParseTree();
    }

    private static vqParser setupParser(String input) {
        ANTLRInputStream in = new ANTLRInputStream(input);
        vqLexer vqLexer = new vqLexer(in);
        CommonTokenStream commonTokenStream = new CommonTokenStream(vqLexer);
        return new vqParser(commonTokenStream);
    }

    public enum VQType { Edge, Node }

    public static boolean validVQ(String vq, List<OutputVariable> allVars) {
        try {
            parseVQ(vq, allVars.stream().map(OutputVariable::getName).collect(Collectors.toList()));
            getVQType(vq, allVars);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static VQType getVQType(String vq, List<OutputVariable> allVars) {
        //TODO: Calculate which variables is actually used in the VQ
        //TODO: Get the types from allVars and check if all is edge or all node.
        //TODO: Throw exception if mixed types
        return VQType.Edge;
    }
}