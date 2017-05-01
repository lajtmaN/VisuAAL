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
	 * Enter a parse tree produced by {@link vqParser#oneGradient}.
	 * @param ctx the parse tree
	 */
	void enterOneGradient(vqParser.OneGradientContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#oneGradient}.
	 * @param ctx the parse tree
	 */
	void exitOneGradient(vqParser.OneGradientContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#colors}.
	 * @param ctx the parse tree
	 */
	void enterColors(vqParser.ColorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#colors}.
	 * @param ctx the parse tree
	 */
	void exitColors(vqParser.ColorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link vqParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(vqParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link vqParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(vqParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code par}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterPar(vqParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code par}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitPar(vqParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nat}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNat(vqParser.NatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nat}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNat(vqParser.NatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBool(vqParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBool(vqParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idDot}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdDot(vqParser.IdDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idDot}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdDot(vqParser.IdDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterId(vqParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitId(vqParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unOp}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterUnOp(vqParser.UnOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unOp}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitUnOp(vqParser.UnOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code float}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterFloat(vqParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code float}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitFloat(vqParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condOp}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCondOp(vqParser.CondOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condOp}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCondOp(vqParser.CondOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binOp}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinOp(vqParser.BinOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binOp}
	 * labeled alternative in {@link vqParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinOp(vqParser.BinOpContext ctx);
}