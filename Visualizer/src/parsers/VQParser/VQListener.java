package parsers.VQParser;

import Model.VQ.*;
import parsers.VQParser.Generated.vqBaseListener;
import parsers.VQParser.Generated.vqParser;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQListener extends vqBaseListener {
    private VQExpression vqExpression = new VQExpression();
    private VQNode currentNode = new VQNode();

    public VQExpression getVQExpression() {
        return vqExpression;
    }

    @Override
    public void enterGradient(vqParser.GradientContext ctx) {
        super.exitGradient(ctx);
        vqExpression.setFirstColor(ctx.ID(0).getText());
        vqExpression.setSecondColor(ctx.ID(1).getText());
        vqExpression.setFirstGradient(Double.parseDouble(ctx.NAT(0).getText()), ctx.NEG(0) != null);
        vqExpression.setSecondGradient(Integer.parseInt(ctx.NAT(1).getText()), ctx.NEG(1) != null);
    }

    @Override
    public void exitQuery(vqParser.QueryContext ctx) {
        super.exitQuery(ctx);
        vqExpression.saveExpression(currentNode);
    }

    @Override
    public void enterExpression(vqParser.ExpressionContext ctx) {
        super.enterExpression(ctx);
        VQNode vqNode = null;

        if(ctx.ID() != null)
            vqNode = new VQNodeID(ctx.ID().getText());
        else if(ctx.NAT() != null)
            vqNode = new VQNodeNAT(Integer.valueOf(ctx.NAT().getText()));
        else if(ctx.FLOAT() != null)
            vqNode = new VQNodeFLOAT(Double.valueOf(ctx.FLOAT().getText()));
        else if(ctx.BOOL() != null)
            vqNode = new VQNodeBOOL(ctx.BOOL().getText());
        else if(ctx.unaryOp() != null)
            vqNode = new VQNodeUnaryOperator(ctx.unaryOp().getText());
        else if(ctx.rel() != null)
            vqNode = new VQNodeOperator(ctx.rel().getText());
        else if(ctx.binBoolOp() != null)
            vqNode = new VQNodeOperator(ctx.binBoolOp().getText());
        else if(ctx.binIntOp() != null)
            vqNode = new VQNodeOperator(ctx.binIntOp().getText());

        if(vqNode != null) {
            vqNode.setParent(currentNode);
            currentNode.addChild(vqNode);
            currentNode = vqNode;
        }
    }

    @Override
    public void exitExpression(vqParser.ExpressionContext ctx) {
        super.exitExpression(ctx);
        currentNode = currentNode.getParent();
    }

    @Override
    public void enterParExpr(vqParser.ParExprContext ctx) {
        super.enterParExpr(ctx);

        VQNodePar vqNodePar = new VQNodePar();
        vqNodePar.setParent(currentNode);
        currentNode.addChild(vqNodePar);
        currentNode = vqNodePar;
    }
}






