package parsers.Declaration;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.xml.sax.SAXException;
import parsers.Declaration.ANTLRGenerated.uppaalLexer;
import parsers.Declaration.ANTLRGenerated.uppaalParser;
import parsers.XmlHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by batto on 24-Feb-17.
 */
public class VariableReaderTests {

    public static void setupParser(String declaration) {
        ANTLRInputStream in = new ANTLRInputStream(declaration);

        uppaalLexer lexer = new uppaalLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        uppaalParser parser = new uppaalParser(tokens);
        uppaalParser.XtaContext context = parser.xta();

        ParseTreeWalker walker = new ParseTreeWalker();
        VariableReaderListener listener = new VariableReaderListener();
        walker.walk(listener, context);
    }

    @Test
    public void parseMacVars() throws IOException, SAXException, ParserConfigurationException {
        XmlHandler handler = new XmlHandler("mac_model_test.xml");
        setupParser(handler.getGlobalDeclarations());
    }

    @Test
    public void typedefLine() {
        setupParser("typedef int[0, CONFIG_NR_NODES-1] id_t;");
    }

}
