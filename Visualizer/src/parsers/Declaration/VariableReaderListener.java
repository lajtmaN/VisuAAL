package parsers.Declaration;

import parsers.Declaration.ANTLRGenerated.uppaalBaseListener;
import parsers.Declaration.ANTLRGenerated.uppaalParser;

/**
 * Created by batto on 24-Feb-17.
 */
public class VariableReaderListener extends uppaalBaseListener {
    @Override
    public void enterVariableDecl(uppaalParser.VariableDeclContext ctx) {
        super.enterVariableDecl(ctx);
        for(uppaalParser.DeclIdContext id : ctx.declId()) {
            System.out.println(id.ID());
        }
    }


}