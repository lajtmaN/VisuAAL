package parsers.VQParser;

import Model.VQ.*;
import Model.VQ.Operators.*;
import org.antlr.v4.runtime.ParserRuleContext;
import parsers.VQParser.Generated.vqBaseListener;
import parsers.VQParser.Generated.vqParser;
import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQListener extends vqBaseListener {
    private Map<String, Double> variables;
    private VQParseTree parseTree = new VQParseTree();
    private VQNode currentNode;

    public VQListener(Map<String, Double> variables) {
        this.variables = variables;
    }

    @Override
    public void enterGradient(vqParser.GradientContext ctx) {
        super.exitGradient(ctx);

        vqParser.OneGradientContext firstGradient = ctx.oneGradient(0),
                                    secondGradient = ctx.oneGradient(1);

        //Set gradient colors
        parseTree.setFirstColor(firstGradient.ID().getText());
        parseTree.setSecondColor(secondGradient.ID().getText());

        if(firstGradient.NAT() != null)
            parseTree.setFirstGradient(Double.parseDouble(firstGradient.NAT().getText()),
                firstGradient.NEG() != null);
        if(secondGradient.NAT() != null)
            parseTree.setSecondGradient(Double.parseDouble(secondGradient.NAT().getText()),
                secondGradient.NEG() != null);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
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
        if(ctx.op.equals("-"))
            addNewChild(new VqNodeUnaryMinus());
        else if(ctx.op.equals("!")) {
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
            case ">=":
                node = new VQNodeGreaterThan();
                break;
            case ">":
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

    //Atoms
    @Override
    public void enterId(vqParser.IdContext ctx) {
        super.enterId(ctx);
        String id = ctx.ID().getText();
        if(variables.containsKey(id)) {
            VQNodeValue node = new VQNodeValue(variables.get(id));
            addNewChild(node);
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
        currentNode.addChild(node);
        node.setParent(currentNode);
        currentNode = node;
    }

    public VQParseTree getParseTree() {
        return parseTree;
    }
}






