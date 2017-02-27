// Generated from uppaal.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link uppaalParser}.
 */
public interface uppaalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link uppaalParser#xta}.
	 * @param ctx the parse tree
	 */
	void enterXta(uppaalParser.XtaContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#xta}.
	 * @param ctx the parse tree
	 */
	void exitXta(uppaalParser.XtaContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(uppaalParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(uppaalParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterInstantiation(uppaalParser.InstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitInstantiation(uppaalParser.InstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#system}.
	 * @param ctx the parse tree
	 */
	void enterSystem(uppaalParser.SystemContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#system}.
	 * @param ctx the parse tree
	 */
	void exitSystem(uppaalParser.SystemContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(uppaalParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(uppaalParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(uppaalParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(uppaalParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(uppaalParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(uppaalParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void enterProcDecl(uppaalParser.ProcDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#procDecl}.
	 * @param ctx the parse tree
	 */
	void exitProcDecl(uppaalParser.ProcDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#procBody}.
	 * @param ctx the parse tree
	 */
	void enterProcBody(uppaalParser.ProcBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#procBody}.
	 * @param ctx the parse tree
	 */
	void exitProcBody(uppaalParser.ProcBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#states}.
	 * @param ctx the parse tree
	 */
	void enterStates(uppaalParser.StatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#states}.
	 * @param ctx the parse tree
	 */
	void exitStates(uppaalParser.StatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#stateDecl}.
	 * @param ctx the parse tree
	 */
	void enterStateDecl(uppaalParser.StateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#stateDecl}.
	 * @param ctx the parse tree
	 */
	void exitStateDecl(uppaalParser.StateDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#commit}.
	 * @param ctx the parse tree
	 */
	void enterCommit(uppaalParser.CommitContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#commit}.
	 * @param ctx the parse tree
	 */
	void exitCommit(uppaalParser.CommitContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#urgent}.
	 * @param ctx the parse tree
	 */
	void enterUrgent(uppaalParser.UrgentContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#urgent}.
	 * @param ctx the parse tree
	 */
	void exitUrgent(uppaalParser.UrgentContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#stateList}.
	 * @param ctx the parse tree
	 */
	void enterStateList(uppaalParser.StateListContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#stateList}.
	 * @param ctx the parse tree
	 */
	void exitStateList(uppaalParser.StateListContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(uppaalParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(uppaalParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#transitions}.
	 * @param ctx the parse tree
	 */
	void enterTransitions(uppaalParser.TransitionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#transitions}.
	 * @param ctx the parse tree
	 */
	void exitTransitions(uppaalParser.TransitionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(uppaalParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(uppaalParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#transitionOpt}.
	 * @param ctx the parse tree
	 */
	void enterTransitionOpt(uppaalParser.TransitionOptContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#transitionOpt}.
	 * @param ctx the parse tree
	 */
	void exitTransitionOpt(uppaalParser.TransitionOptContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#transitionBody}.
	 * @param ctx the parse tree
	 */
	void enterTransitionBody(uppaalParser.TransitionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#transitionBody}.
	 * @param ctx the parse tree
	 */
	void exitTransitionBody(uppaalParser.TransitionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#guard}.
	 * @param ctx the parse tree
	 */
	void enterGuard(uppaalParser.GuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#guard}.
	 * @param ctx the parse tree
	 */
	void exitGuard(uppaalParser.GuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#sync}.
	 * @param ctx the parse tree
	 */
	void enterSync(uppaalParser.SyncContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#sync}.
	 * @param ctx the parse tree
	 */
	void exitSync(uppaalParser.SyncContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(uppaalParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(uppaalParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecl(uppaalParser.TypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#typeDecl}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecl(uppaalParser.TypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdList(uppaalParser.TypeIdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdList(uppaalParser.TypeIdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(uppaalParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(uppaalParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#declId}.
	 * @param ctx the parse tree
	 */
	void enterDeclId(uppaalParser.DeclIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#declId}.
	 * @param ctx the parse tree
	 */
	void exitDeclId(uppaalParser.DeclIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void enterInitialiser(uppaalParser.InitialiserContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#initialiser}.
	 * @param ctx the parse tree
	 */
	void exitInitialiser(uppaalParser.InitialiserContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#fieldInit}.
	 * @param ctx the parse tree
	 */
	void enterFieldInit(uppaalParser.FieldInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#fieldInit}.
	 * @param ctx the parse tree
	 */
	void exitFieldInit(uppaalParser.FieldInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecl(uppaalParser.ArrayDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecl(uppaalParser.ArrayDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(uppaalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(uppaalParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(uppaalParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(uppaalParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#fieldDeclId}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclId(uppaalParser.FieldDeclIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#fieldDeclId}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclId(uppaalParser.FieldDeclIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(uppaalParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(uppaalParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(uppaalParser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(uppaalParser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(uppaalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(uppaalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(uppaalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(uppaalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#caseExpr}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpr(uppaalParser.CaseExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#caseExpr}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpr(uppaalParser.CaseExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(uppaalParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(uppaalParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(uppaalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(uppaalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(uppaalParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(uppaalParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void enterAssignOp(uppaalParser.AssignOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#assignOp}.
	 * @param ctx the parse tree
	 */
	void exitAssignOp(uppaalParser.AssignOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(uppaalParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(uppaalParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#rel}.
	 * @param ctx the parse tree
	 */
	void enterRel(uppaalParser.RelContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#rel}.
	 * @param ctx the parse tree
	 */
	void exitRel(uppaalParser.RelContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#binIntOp}.
	 * @param ctx the parse tree
	 */
	void enterBinIntOp(uppaalParser.BinIntOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#binIntOp}.
	 * @param ctx the parse tree
	 */
	void exitBinIntOp(uppaalParser.BinIntOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link uppaalParser#binBoolOp}.
	 * @param ctx the parse tree
	 */
	void enterBinBoolOp(uppaalParser.BinBoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link uppaalParser#binBoolOp}.
	 * @param ctx the parse tree
	 */
	void exitBinBoolOp(uppaalParser.BinBoolOpContext ctx);
}