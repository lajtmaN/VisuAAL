package parsers.Declaration;

import Model.CVar;
import org.antlr.v4.runtime.*;
import parsers.Declaration.ANTLRGenerated.uppaalBaseListener;
import parsers.Declaration.ANTLRGenerated.uppaalParser;

import java.util.List;

/**
 * Created by lajtman on 27-02-2017.
 */
public class DeclarationUpdater extends uppaalBaseListener {

    public DeclarationUpdater(CommonTokenStream tokens, List<CVar<Integer>> updatedCVars) {
        tokStream = tokens;
        rewriter = new TokenStreamRewriter(tokens);

        cvarsToUpdate = updatedCVars;
    }

    private List<CVar<Integer>> cvarsToUpdate;
    private CommonTokenStream tokStream;
    private TokenStreamRewriter rewriter;

    public String updatedDeclaration() { return rewriter.getText(); }

    private boolean shouldUpdate(String declName) {
        return cvarsToUpdate.stream().anyMatch(p -> p.getName().equals(declName));
    }

    @Override
    public void exitDeclId(uppaalParser.DeclIdContext ctx) {
        //if (shouldUpdate(ctx.ID().getText())) {
            Token declNameToken = ctx.getStart();
            rewriter.replace(declNameToken, "TEST");
        //}
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
