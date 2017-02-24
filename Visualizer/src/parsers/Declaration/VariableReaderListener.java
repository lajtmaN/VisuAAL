package parsers.Declaration;

import Model.UPPAALVariable;
import org.antlr.v4.runtime.tree.ParseTree;
import parsers.Declaration.ANTLRGenerated.uppaalBaseListener;
import parsers.Declaration.ANTLRGenerated.uppaalParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by batto on 24-Feb-17.
 */
public class VariableReaderListener extends uppaalBaseListener {
    public ArrayList<UPPAALVariable> getVariables() {
        return variables;
    }

    private ArrayList<UPPAALVariable> variables = new ArrayList<>();
    private Boolean inVariableDecl = false;
    private String currentType = "";
    private Boolean currentlyConst= false;

    @Override
    public void enterDeclId(uppaalParser.DeclIdContext ctx) {
        super.enterDeclId(ctx);
    }

    @Override
    public void exitDeclId(uppaalParser.DeclIdContext ctx) {
        super.exitDeclId(ctx);
        variables.add(new UPPAALVariable(currentType, ctx.ID().getText(), null, currentlyConst));
    }

    @Override
    public void enterVariableDecl(uppaalParser.VariableDeclContext ctx) {
        super.enterVariableDecl(ctx);
        inVariableDecl = true;
    }

    @Override
    public void exitVariableDecl(uppaalParser.VariableDeclContext ctx) {
        super.exitVariableDecl(ctx);
        inVariableDecl = false;
        currentType = "";
        currentlyConst = false;
    }

    @Override
    public void enterType(uppaalParser.TypeContext ctx) {
        super.enterType(ctx);
        if(ctx.ID() != null && inVariableDecl) {
            currentType = ctx.ID().getText();
            List<ParseTree> children = ctx.prefix().children;
            currentlyConst = children != null && children.get(0).getText().equals("const");
        }
    }

    @Override
    public void exitType(uppaalParser.TypeContext ctx) {
        super.exitType(ctx);
    }

}
