package parsers.Declaration;

import Model.CVar;
import org.antlr.v4.runtime.*;
import parsers.Declaration.ANTLRGenerated.uppaalBaseListener;
import parsers.Declaration.ANTLRGenerated.uppaalParser;

import java.util.List;
import java.util.Optional;

/**
 * Created by lajtman on 27-02-2017.
 */
public class DeclarationUpdater extends uppaalBaseListener {

    public DeclarationUpdater(CommonTokenStream tokens, List<CVar> updatedCVars) {
        tokStream = tokens;
        rewriter = new TokenStreamRewriter(tokens);

        cvarsToUpdate = updatedCVars;
    }

    private List<CVar> cvarsToUpdate;
    private CommonTokenStream tokStream;
    private TokenStreamRewriter rewriter;

    public String updatedDeclaration() { return rewriter.getText(); }

    private Optional<CVar> cvarToUpdate(String declName) {
        return cvarsToUpdate.stream().filter(p -> p.getName().equals(declName)).findFirst();
    }

    @Override
    public void exitDeclId(uppaalParser.DeclIdContext ctx) {
        String declName = ctx.ID().getText();
        Optional<CVar> cvar = cvarToUpdate(declName);
        if (cvar.isPresent()) {
            Token initializeToken = ctx.initialiser().getStart();
            rewriter.replace(initializeToken, cvar.get().getValue());
        }
    }



//    @Override
//    public void exitXta(uppaalParser.XtaContext ctx) {
//        Token semi = ctx.getStop();
//        int tokIndex = semi.getTokenIndex();
//        List<Token> cmtChannel = tokStream.getHiddenTokensToRight(tokIndex, uppaalLexer.HIDDEN);
//        if (cmtChannel != null) {
//            Token cmt = cmtChannel.get(0);
//            if (cmt != null) {
//                rewriter.insertAfter(semi, cmt.getText());
//            }
//        }
//    }

}
