package parsers.Declaration;

import Model.CVar;
import org.antlr.v4.runtime.tree.ParseTree;
import parsers.Declaration.ANTLRGenerated.uppaalBaseListener;
import parsers.Declaration.ANTLRGenerated.uppaalParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by batto on 24-Feb-17.
 */
public class VariableInstantiationReader extends uppaalBaseListener {
    public ArrayList<CVar> getVariables() {
        return variables;
    }

    private ArrayList<CVar> variables = new ArrayList<>();
    private CVar element = null;
    private Boolean inVariableDecl = false;
    private String currentType = "";
    private Boolean currentlyConst= false;

    @Override
    public void enterDeclId(uppaalParser.DeclIdContext ctx) {
        super.enterDeclId(ctx);
        element = new CVar();
    }

    @Override
    public void exitDeclId(uppaalParser.DeclIdContext ctx) {
        super.exitDeclId(ctx);
        element.setIsConst(currentlyConst);
        element.setType(currentType);
        element.setName(ctx.ID().getText());
        if(ctx.initialiser() != null){
            element.setValue(ctx.initialiser().getText());
        }
        variables.add(element);
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
    public void exitArrayDecl(uppaalParser.ArrayDeclContext ctx) {
        super.exitArrayDecl(ctx);
        if(inVariableDecl) {
            element.getArraySizes().add(ctx.expression().getText());
        }
    }
}
