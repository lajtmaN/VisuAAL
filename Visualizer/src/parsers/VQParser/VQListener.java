package parsers.VQParser;

import Model.VQ.*;
import Model.VQ.Operators.*;
import View.IntegerTextField;
import org.antlr.v4.runtime.ParserRuleContext;
import parsers.VQParser.Generated.vqBaseListener;
import parsers.VQParser.Generated.vqParser;

import java.util.Collection;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQListener extends vqBaseListener {
    private Collection<String> variables;
    private VQParseTree parseTree = new VQParseTree();
    private VQNode currentNode;

    public VQListener(Collection<String> variables) {
        this.variables = variables;
    }

    private void addError(String error) {
        parseTree.addToParseError(error);
    }

    private boolean ensureAndLogError(boolean expr, String error) {
        if (!expr)
            addError(error);
        return expr;
    }

    @Override
    public void enterGradient(vqParser.GradientContext ctx) {
        super.exitGradient(ctx);

        vqParser.OneGradientContext firstGradient = ctx.oneGradient(0),
                                    secondGradient = ctx.oneGradient(1);

        //Set gradient colors
        if(!ensureAndLogError(firstGradient != null && firstGradient.ID() != null, "Could not parse first gradient color"))
            return;
        if(!ensureAndLogError(secondGradient != null && secondGradient.ID() != null, "Could not parse second gradient color"))
            return;
        parseTree.setFirstColor(firstGradient.ID().getText());
        parseTree.setSecondColor(secondGradient.ID().getText());

        if(firstGradient.NAT() != null)
            parseTree.setFirstGradient(Double.parseDouble(firstGradient.NAT().getText()),
                firstGradient.NEG() != null);
        if(secondGradient.NAT() != null)
            parseTree.setSecondGradient(Double.parseDouble(secondGradient.NAT().getText()),
                secondGradient.NEG() != null);
        ensureAndLogError(parseTree.getFirstGradient() < parseTree.getSecondGradient(), "First gradient value must be less than second gradient value");
    }

    @Override
    public void enterColors(vqParser.ColorsContext ctx) {
        super.enterColors(ctx);


        if(!ensureAndLogError(ctx.ID() != null, "Missing default color")
                || !ensureAndLogError(ctx.color() != null, "Missing colors"))
            return;

        VQColors colors = new VQColors();
        for(vqParser.ColorContext color : ctx.color()) {
            if(color != null) {
                int value = Integer.parseInt(color.NAT().getText());
                if(color.NEG() != null)
                    value = -value;
                colors.addColor(color.ID().getText(), value);
            }
        }
        colors.setDefaultColor(ctx.ID().getText());
        parseTree.setVqColors(colors);
    }

    @Override
    public void exitQuery(vqParser.QueryContext ctx) {
        super.exitQuery(ctx);
        parseTree.setRoot(currentNode);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
        if(currentNode != null && currentNode.getParent() != null)
            currentNode = currentNode.getParent();
    }

    @Override
    public void enterPar(vqParser.ParContext ctx) {
        super.enterPar(ctx);
        addNewChild(new VQNodePar());
    }

    //Unary
    @Override
    public void enterUnOp(vqParser.UnOpContext ctx) {
        super.enterUnOp(ctx);
        if(ctx.op.getText().equals("-"))
            addNewChild(new VqNodeUnaryMinus());
        else if(ctx.op.getText().equals("!")) {
            addNewChild(new VqNodeUnaryNot());
        }
    }

    //Binary
    @Override
    public void enterBinOp(vqParser.BinOpContext ctx) {
        super.enterBinOp(ctx);
        String operator = ctx.op.getText();
        VQNode node = null;

        switch (operator) {
            case "+":
                node = new VQNodePlus();
                break;
            case "-":
                node = new VQNodeMinus();
                break;
            case "*":
                node = new VQNodeMult();
                break;
            case "/":
                node = new VQNodeDiv();
                break;
            case "<":
                node = new VQNodeLessThan();
                break;
            case "<=":
                node = new VQNodeLessThanEq();
                break;
            case "==":
                node = new VQNodeEqual();
                break;
            case "!=":
                node = new VQNodeNotEqual();
                break;
            case ">":
                node = new VQNodeGreaterThan();
                break;
            case ">=":
                node = new VQNodeGreaterThanEq();
                break;
            case "&&":
                node = new VQNodeAnd();
                break;
            case "||":
                node = new VQNodeOr();
                break;
        }

        addNewChild(node);
    }

    //Ternary


    @Override
    public void enterCondOp(vqParser.CondOpContext ctx) {
        super.enterCondOp(ctx);
        VQNodeConditional vqNodeConditional = new VQNodeConditional();
        addNewChild(vqNodeConditional);
    }

    //Atoms
    @Override
    public void enterId(vqParser.IdContext ctx) {
        super.enterId(ctx);
        String id = ctx.ID().getText();
        parseTree.addUsedVariable(id);

        if(variables.contains(id)) {
            VQNodeId node = new VQNodeId(id);
            addNewChild(node);
        } else {
            ensureAndLogError(false, "Variable \""+ id +"\" does not exist");
        }
    }

    @Override
    public void enterIdDot(vqParser.IdDotContext ctx) {
        super.enterIdDot(ctx);
        String scope = ctx.ID(0).getText();
        String id = ctx.ID(1).getText();
        String scopedVar = scope+"."+id;
        parseTree.addUsedVariable(scopedVar);

        if(variables.contains(scopedVar)) {
            VQNodeId node = new VQNodeId(scopedVar);
            addNewChild(node);
        } else {
            ensureAndLogError(false, "Variable \""+ id +"\" does not exist in scope \"" + scope+"\"");
        }
    }

    @Override
    public void enterNat(vqParser.NatContext ctx) {
        super.enterNat(ctx);
        addNewChild(new VQNodeValue(Double.valueOf(ctx.NAT().getText())));
    }

    @Override
    public void enterFloat(vqParser.FloatContext ctx) {
        super.enterFloat(ctx);
        addNewChild(new VQNodeValue(Double.valueOf(ctx.FLOAT().getText())));
    }

    @Override
    public void enterBool(vqParser.BoolContext ctx) {
        super.enterBool(ctx);
        String b = ctx.BOOL().getText();
        if(b.equals("true"))
            addNewChild(new VQNodeValue(1.));
        else
            addNewChild(new VQNodeValue(0.));
    }

    private void addNewChild(VQNode node) {
        if(currentNode != null) {
            currentNode.addChild(node);
            node.setParent(currentNode);
        }
        currentNode = node;
    }

    public VQParseTree getParseTree() {
        return parseTree;
    }
}






