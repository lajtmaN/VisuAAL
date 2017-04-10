package parsers.VQParser.Generated;// Generated from vq.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link vqParser}.
 */
public interface vqListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link vqParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(vqParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(vqParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#gradient}.
	 * @param ctx the parse tree
	 */
	void enterGradient(vqParser.GradientContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#gradient}.
	 * @param ctx the parse tree
	 */
	void exitGradient(vqParser.GradientContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(vqParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(vqParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#parExpr}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(vqParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#parExpr}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(vqParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(vqParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(vqParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(vqParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(vqParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#binIntOp}.
	 * @param ctx the parse tree
	 */
	void enterBinIntOp(vqParser.BinIntOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#binIntOp}.
	 * @param ctx the parse tree
	 */
	void exitBinIntOp(vqParser.BinIntOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#binBoolOp}.
	 * @param ctx the parse tree
	 */
	void enterBinBoolOp(vqParser.BinBoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#binBoolOp}.
	 * @param ctx the parse tree
	 */
	void exitBinBoolOp(vqParser.BinBoolOpContext ctx);
}