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

        vqParser.OneGradientContext firstGradient = ctx.oneGradient(0),
                                    secondGradient = ctx.oneGradient(1);

        vqExpression.setFirstColor(firstGradient.ID().getText());
        vqExpression.setSecondColor(secondGradient.ID().getText());

        if(firstGradient.NAT() != null)
            vqExpression.setFirstGradient(Double.parseDouble(firstGradient.NAT().getText()),
                firstGradient.NEG() != null);
        if(secondGradient.NAT() != null)
            vqExpression.setSecondGradient(Double.parseDouble(secondGradient.NAT().getText()),
                secondGradient.NEG() != null);
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






