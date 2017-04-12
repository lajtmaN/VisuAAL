package parsers.VQParser;

import Model.VQ.VQParseTree;
import parsers.VQParser.Generated.vqBaseListener;
import parsers.VQParser.Generated.vqParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQListener extends vqBaseListener {
    private Map<String, Double> variables;
    private List<Double> values = new ArrayList<>();
    private List<String> errors = new ArrayList<>();
    private VQParseTree parseTree = new VQParseTree();


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

    //Operators
    @Override
    public void exitUnOp(vqParser.UnOpContext ctx) {
        super.exitUnOp(ctx);
        int lastIndex = values.size() - 1;
        double v = values.remove(lastIndex);
        if(ctx.op.equals("-"))
            values.add(-v);
        else if(ctx.op.equals("!")) {
            if(v != 0)
                values.add(0.);
            else
                values.add(1.);
        }
    }

    @Override
    public void exitBinOp(vqParser.BinOpContext ctx) {
        super.exitBinOp(ctx);
        doBinaryOperation(ctx.op.getText());
    }

    //Atoms
    @Override
    public void exitId(vqParser.IdContext ctx) {
        super.exitId(ctx);
        if(variables.containsKey(ctx.ID().getText()))
            values.add(variables.get(ctx.ID().getText()));
        else
            errors.add("The variable " + ctx.ID().getText() + " does not exist");
    }

    @Override
    public void exitNat(vqParser.NatContext ctx) {
        super.exitNat(ctx);
        values.add(Double.valueOf(ctx.NAT().getText()));
    }

    @Override
    public void exitFloat(vqParser.FloatContext ctx) {
        super.exitFloat(ctx);
        values.add(Double.valueOf(ctx.FLOAT().getText()));
    }

    @Override
    public void exitBool(vqParser.BoolContext ctx) {
        super.exitBool(ctx);
        if(ctx.BOOL().getText().equals("true"))
            values.add(1.);
        else
            values.add(0.);
    }

    private void doBinaryOperation(String operator) {
        int lastIndex = values.size() - 1;
        double v1 = values.remove(lastIndex), v0 = values.remove(lastIndex-1), result = 0;

        switch (operator) {
            case "+":
                result = v0 + v1;
                break;
            case "-":
                result = v0 - v1;
                break;
            case "*":
                result = v0 * v1;
                break;
            case "/":
                if(v1 != 0)
                    result = v0 / v1;
                else
                    errors.add("Division by 0 error");
                break;
            case "<":
                result = v0 < v1 ? 1 : 0;
                break;
            case "<=":
                result = v0 <= v1 ? 1 : 0;
                break;
            case "==":
                result = v0 == v1 ? 1 : 0;
                break;
            case "!=":
                result = v0 != v1 ? 1 : 0;
                break;
            case ">=":
                result = v0 >= v1 ? 1 : 0;
                break;
            case ">":
                result = v0 > v1 ? 1 : 0;
                break;
            case "&&":
                result = v0 != 0 && v1 != 0 ? 1 : 0;
                break;
            case "||":
                result = v0 != 0 || v1 != 0 ? 1 : 0;
                break;
        }

        values.add(result);
    }

    public double getResultValue() {
        if(values.size() != 1)
            errors.add("Wrong number of final results: " + values.size());
        if(values.size() == 1)
            return values.get(0);
        else return 0;
    }

    public VQParseTree getParseTree() {
        return parseTree;
    }
}






