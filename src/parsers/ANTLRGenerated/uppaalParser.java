// Generated from uppaal.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class uppaalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, UnaryOp=55, Rel=56, BinIntOp=57, BinBoolOp=58, ID=59, 
		WS=60;
	public static final int
		RULE_xta = 0, RULE_declaration = 1, RULE_instantiation = 2, RULE_system = 3, 
		RULE_parameterList = 4, RULE_parameter = 5, RULE_functionDecl = 6, RULE_procDecl = 7, 
		RULE_procBody = 8, RULE_states = 9, RULE_stateDecl = 10, RULE_commit = 11, 
		RULE_urgent = 12, RULE_stateList = 13, RULE_init = 14, RULE_transitions = 15, 
		RULE_transition = 16, RULE_transitionOpt = 17, RULE_transitionBody = 18, 
		RULE_guard = 19, RULE_sync = 20, RULE_assign = 21, RULE_typeDecl = 22, 
		RULE_typeIdList = 23, RULE_variableDecl = 24, RULE_declId = 25, RULE_initialiser = 26, 
		RULE_fieldInit = 27, RULE_arrayDecl = 28, RULE_type = 29, RULE_fieldDecl = 30, 
		RULE_fieldDeclId = 31, RULE_prefix = 32, RULE_range = 33, RULE_block = 34, 
		RULE_statement = 35, RULE_caseExpr = 36, RULE_exprList = 37, RULE_expression = 38, 
		RULE_argList = 39, RULE_assignOp = 40;
	public static final String[] ruleNames = {
		"xta", "declaration", "instantiation", "system", "parameterList", "parameter", 
		"functionDecl", "procDecl", "procBody", "states", "stateDecl", "commit", 
		"urgent", "stateList", "init", "transitions", "transition", "transitionOpt", 
		"transitionBody", "guard", "sync", "assign", "typeDecl", "typeIdList", 
		"variableDecl", "declId", "initialiser", "fieldInit", "arrayDecl", "type", 
		"fieldDecl", "fieldDeclId", "prefix", "range", "block", "statement", "caseExpr", 
		"exprList", "expression", "argList", "assignOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "';'", "'system'", "','", "'&'", "'process'", 
		"'{'", "'}'", "'state'", "'commit'", "'urgent'", "'init'", "'trans'", 
		"'-'", "'guard'", "'sync'", "'!'", "'?'", "'assign'", "'typedef'", "':'", 
		"'['", "']'", "'struct'", "'broadcast'", "'const'", "'for'", "'while'", 
		"'do'", "'if'", "'else'", "'break'", "'continue'", "'switch'", "'return'", 
		"'case'", "'default'", "'true'", "'false'", "'++'", "'--'", "'.'", "'+='", 
		"'-='", "'*='", "'/='", "'%='", "'|='", "'&='", "'^='", "'<<='", "'>>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "UnaryOp", "Rel", "BinIntOp", 
		"BinBoolOp", "ID", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "uppaal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public uppaalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class XtaContext extends ParserRuleContext {
		public SystemContext system() {
			return getRuleContext(SystemContext.class,0);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<InstantiationContext> instantiation() {
			return getRuleContexts(InstantiationContext.class);
		}
		public InstantiationContext instantiation(int i) {
			return getRuleContext(InstantiationContext.class,i);
		}
		public XtaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterXta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitXta(this);
		}
	}

	public final XtaContext xta() throws RecognitionException {
		XtaContext _localctx = new XtaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xta);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(82);
					declaration();
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(88);
				instantiation();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			system();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public TypeDeclContext typeDecl() {
			return getRuleContext(TypeDeclContext.class,0);
		}
		public ProcDeclContext procDecl() {
			return getRuleContext(ProcDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				variableDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				typeDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				procDecl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstantiationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(uppaalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(uppaalParser.ID, i);
		}
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public InstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitInstantiation(this);
		}
	}

	public final InstantiationContext instantiation() throws RecognitionException {
		InstantiationContext _localctx = new InstantiationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instantiation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(ID);
			setState(103);
			match(T__0);
			setState(104);
			match(ID);
			setState(105);
			match(T__1);
			setState(106);
			argList();
			setState(107);
			match(T__2);
			setState(108);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SystemContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(uppaalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(uppaalParser.ID, i);
		}
		public SystemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_system; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterSystem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitSystem(this);
		}
	}

	public final SystemContext system() throws RecognitionException {
		SystemContext _localctx = new SystemContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__4);
			setState(111);
			match(ID);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(112);
				match(T__5);
				setState(113);
				match(ID);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__1);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << ID))) != 0)) {
				{
				setState(122);
				parameter();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(123);
					match(T__5);
					setState(124);
					parameter();
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(132);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			type();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(135);
				match(T__6);
				}
			}

			setState(138);
			match(ID);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(139);
				arrayDecl();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitFunctionDecl(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			type();
			setState(146);
			match(ID);
			setState(147);
			parameterList();
			setState(148);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ProcBodyContext procBody() {
			return getRuleContext(ProcBodyContext.class,0);
		}
		public ProcDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterProcDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitProcDecl(this);
		}
	}

	public final ProcDeclContext procDecl() throws RecognitionException {
		ProcDeclContext _localctx = new ProcDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__7);
			setState(151);
			match(ID);
			setState(152);
			parameterList();
			setState(153);
			match(T__8);
			setState(154);
			procBody();
			setState(155);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcBodyContext extends ParserRuleContext {
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public CommitContext commit() {
			return getRuleContext(CommitContext.class,0);
		}
		public UrgentContext urgent() {
			return getRuleContext(UrgentContext.class,0);
		}
		public TransitionsContext transitions() {
			return getRuleContext(TransitionsContext.class,0);
		}
		public ProcBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterProcBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitProcBody(this);
		}
	}

	public final ProcBodyContext procBody() throws RecognitionException {
		ProcBodyContext _localctx = new ProcBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_procBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__21) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << ID))) != 0)) {
				{
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(157);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(158);
					variableDecl();
					}
					break;
				case 3:
					{
					setState(159);
					typeDecl();
					}
					break;
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			states();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(166);
				commit();
				}
			}

			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(169);
				urgent();
				}
			}

			setState(172);
			init();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(173);
				transitions();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatesContext extends ParserRuleContext {
		public List<StateDeclContext> stateDecl() {
			return getRuleContexts(StateDeclContext.class);
		}
		public StateDeclContext stateDecl(int i) {
			return getRuleContext(StateDeclContext.class,i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitStates(this);
		}
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__10);
			setState(177);
			stateDecl();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(178);
				match(T__5);
				setState(179);
				stateDecl();
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterStateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitStateDecl(this);
		}
	}

	public final StateDeclContext stateDecl() throws RecognitionException {
		StateDeclContext _localctx = new StateDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stateDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(ID);
			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(188);
				match(T__8);
				setState(189);
				expression(0);
				setState(190);
				match(T__9);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommitContext extends ParserRuleContext {
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public CommitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterCommit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitCommit(this);
		}
	}

	public final CommitContext commit() throws RecognitionException {
		CommitContext _localctx = new CommitContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_commit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__11);
			setState(195);
			stateList();
			setState(196);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UrgentContext extends ParserRuleContext {
		public StateListContext stateList() {
			return getRuleContext(StateListContext.class,0);
		}
		public UrgentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_urgent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterUrgent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitUrgent(this);
		}
	}

	public final UrgentContext urgent() throws RecognitionException {
		UrgentContext _localctx = new UrgentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_urgent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__12);
			setState(199);
			stateList();
			setState(200);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(uppaalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(uppaalParser.ID, i);
		}
		public StateListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stateList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterStateList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitStateList(this);
		}
	}

	public final StateListContext stateList() throws RecognitionException {
		StateListContext _localctx = new StateListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(ID);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(203);
				match(T__5);
				setState(204);
				match(ID);
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__13);
			setState(211);
			match(ID);
			setState(212);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionsContext extends ParserRuleContext {
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public List<TransitionOptContext> transitionOpt() {
			return getRuleContexts(TransitionOptContext.class);
		}
		public TransitionOptContext transitionOpt(int i) {
			return getRuleContext(TransitionOptContext.class,i);
		}
		public TransitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterTransitions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitTransitions(this);
		}
	}

	public final TransitionsContext transitions() throws RecognitionException {
		TransitionsContext _localctx = new TransitionsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_transitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(T__14);
			setState(215);
			transition();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(216);
				match(T__5);
				setState(217);
				transitionOpt();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(uppaalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(uppaalParser.ID, i);
		}
		public TransitionBodyContext transitionBody() {
			return getRuleContext(TransitionBodyContext.class,0);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ID);
			setState(226);
			match(T__15);
			setState(227);
			match(ID);
			setState(228);
			transitionBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionOptContext extends ParserRuleContext {
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public TransitionBodyContext transitionBody() {
			return getRuleContext(TransitionBodyContext.class,0);
		}
		public TransitionOptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionOpt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterTransitionOpt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitTransitionOpt(this);
		}
	}

	public final TransitionOptContext transitionOpt() throws RecognitionException {
		TransitionOptContext _localctx = new TransitionOptContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_transitionOpt);
		try {
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				transition();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(T__15);
				setState(232);
				match(ID);
				setState(233);
				transitionBody();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TransitionBodyContext extends ParserRuleContext {
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public SyncContext sync() {
			return getRuleContext(SyncContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public TransitionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transitionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterTransitionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitTransitionBody(this);
		}
	}

	public final TransitionBodyContext transitionBody() throws RecognitionException {
		TransitionBodyContext _localctx = new TransitionBodyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_transitionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__8);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(237);
				guard();
				}
			}

			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(240);
				sync();
				}
			}

			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(243);
				assign();
				}
			}

			setState(246);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuardContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitGuard(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(T__16);
			setState(249);
			expression(0);
			setState(250);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SyncContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SyncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sync; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterSync(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitSync(this);
		}
	}

	public final SyncContext sync() throws RecognitionException {
		SyncContext _localctx = new SyncContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sync);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__17);
			setState(253);
			expression(0);
			setState(254);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__19) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(255);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__20);
			setState(258);
			exprList();
			setState(259);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TypeIdListContext> typeIdList() {
			return getRuleContexts(TypeIdListContext.class);
		}
		public TypeIdListContext typeIdList(int i) {
			return getRuleContext(TypeIdListContext.class,i);
		}
		public TypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitTypeDecl(this);
		}
	}

	public final TypeDeclContext typeDecl() throws RecognitionException {
		TypeDeclContext _localctx = new TypeDeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__21);
			setState(262);
			type();
			setState(263);
			typeIdList();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(264);
				match(T__5);
				setState(265);
				typeIdList();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(271);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdListContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public TypeIdListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterTypeIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitTypeIdList(this);
		}
	}

	public final TypeIdListContext typeIdList() throws RecognitionException {
		TypeIdListContext _localctx = new TypeIdListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(ID);
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(274);
				arrayDecl();
				}
				}
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<DeclIdContext> declId() {
			return getRuleContexts(DeclIdContext.class);
		}
		public DeclIdContext declId(int i) {
			return getRuleContext(DeclIdContext.class,i);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitVariableDecl(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_variableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			type();
			setState(281);
			declId();
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(282);
				match(T__5);
				setState(283);
				declId();
				}
				}
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(289);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public InitialiserContext initialiser() {
			return getRuleContext(InitialiserContext.class,0);
		}
		public DeclIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterDeclId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitDeclId(this);
		}
	}

	public final DeclIdContext declId() throws RecognitionException {
		DeclIdContext _localctx = new DeclIdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_declId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(ID);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(292);
				arrayDecl();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(298);
				match(T__0);
				setState(299);
				initialiser();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitialiserContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<FieldInitContext> fieldInit() {
			return getRuleContexts(FieldInitContext.class);
		}
		public FieldInitContext fieldInit(int i) {
			return getRuleContext(FieldInitContext.class,i);
		}
		public InitialiserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initialiser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterInitialiser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitInitialiser(this);
		}
	}

	public final InitialiserContext initialiser() throws RecognitionException {
		InitialiserContext _localctx = new InitialiserContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_initialiser);
		int _la;
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case UnaryOp:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				expression(0);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(T__8);
				setState(304);
				fieldInit();
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(305);
					match(T__5);
					setState(306);
					fieldInit();
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(312);
				match(T__9);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldInitContext extends ParserRuleContext {
		public InitialiserContext initialiser() {
			return getRuleContext(InitialiserContext.class,0);
		}
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public FieldInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterFieldInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitFieldInit(this);
		}
	}

	public final FieldInitContext fieldInit() throws RecognitionException {
		FieldInitContext _localctx = new FieldInitContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fieldInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(316);
				match(ID);
				setState(317);
				match(T__22);
				}
				break;
			}
			setState(320);
			initialiser();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDeclContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterArrayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitArrayDecl(this);
		}
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(T__23);
			setState(323);
			expression(0);
			setState(324);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_type);
		int _la;
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				prefix();
				setState(327);
				match(ID);
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__23) {
					{
					setState(328);
					range();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				prefix();
				setState(332);
				match(T__25);
				setState(333);
				match(T__8);
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(334);
					fieldDecl();
					}
					}
					setState(337); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << ID))) != 0) );
				setState(339);
				match(T__9);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FieldDeclIdContext> fieldDeclId() {
			return getRuleContexts(FieldDeclIdContext.class);
		}
		public FieldDeclIdContext fieldDeclId(int i) {
			return getRuleContext(FieldDeclIdContext.class,i);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitFieldDecl(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			type();
			setState(344);
			fieldDeclId();
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(345);
				match(T__5);
				setState(346);
				fieldDeclId();
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDeclIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public FieldDeclIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterFieldDeclId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitFieldDeclId(this);
		}
	}

	public final FieldDeclIdContext fieldDeclId() throws RecognitionException {
		FieldDeclIdContext _localctx = new FieldDeclIdContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_fieldDeclId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(ID);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__23) {
				{
				{
				setState(355);
				arrayDecl();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitPrefix(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(361);
					match(T__12);
					}
				}

				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__26) {
					{
					setState(364);
					match(T__26);
					}
				}

				}
				break;
			case 2:
				{
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(367);
					match(T__27);
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitRange(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(T__23);
			setState(373);
			expression(0);
			setState(374);
			match(T__5);
			setState(375);
			expression(0);
			setState(376);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public List<TypeDeclContext> typeDecl() {
			return getRuleContexts(TypeDeclContext.class);
		}
		public TypeDeclContext typeDecl(int i) {
			return getRuleContext(TypeDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(T__8);
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(381);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__12:
					case T__25:
					case T__26:
					case T__27:
					case ID:
						{
						setState(379);
						variableDecl();
						}
						break;
					case T__21:
						{
						setState(380);
						typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__8) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << UnaryOp) | (1L << ID))) != 0)) {
				{
				{
				setState(386);
				statement();
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ExprListContext> exprList() {
			return getRuleContexts(ExprListContext.class);
		}
		public ExprListContext exprList(int i) {
			return getRuleContext(ExprListContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<CaseExprContext> caseExpr() {
			return getRuleContexts(CaseExprContext.class);
		}
		public CaseExprContext caseExpr(int i) {
			return getRuleContext(CaseExprContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_statement);
		int _la;
		try {
			setState(454);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(395);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(396);
				expression(0);
				setState(397);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(399);
				match(T__28);
				setState(400);
				match(T__1);
				setState(401);
				exprList();
				setState(402);
				match(T__3);
				setState(403);
				exprList();
				setState(404);
				match(T__3);
				setState(405);
				exprList();
				setState(406);
				match(T__2);
				setState(407);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(409);
				match(T__29);
				setState(410);
				match(T__1);
				setState(411);
				exprList();
				setState(412);
				match(T__2);
				setState(413);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(415);
				match(T__30);
				setState(416);
				statement();
				setState(417);
				match(T__29);
				setState(418);
				match(T__1);
				setState(419);
				exprList();
				setState(420);
				match(T__2);
				setState(421);
				match(T__3);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(423);
				match(T__31);
				setState(424);
				match(T__1);
				setState(425);
				exprList();
				setState(426);
				match(T__2);
				setState(427);
				statement();
				setState(430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(428);
					match(T__32);
					setState(429);
					statement();
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(432);
				match(T__33);
				setState(433);
				match(T__3);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(434);
				match(T__34);
				setState(435);
				match(T__3);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(436);
				match(T__35);
				setState(437);
				match(T__1);
				setState(438);
				exprList();
				setState(439);
				match(T__2);
				setState(440);
				match(T__8);
				setState(442); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(441);
					caseExpr();
					}
					}
					setState(444); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__37 || _la==T__38 );
				setState(446);
				match(T__9);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(448);
				match(T__36);
				setState(449);
				match(T__3);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(450);
				match(T__36);
				setState(451);
				expression(0);
				setState(452);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CaseExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CaseExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterCaseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitCaseExpr(this);
		}
	}

	public final CaseExprContext caseExpr() throws RecognitionException {
		CaseExprContext _localctx = new CaseExprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_caseExpr);
		int _la;
		try {
			setState(473);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__37:
				enterOuterAlt(_localctx, 1);
				{
				setState(456);
				match(T__37);
				setState(457);
				expression(0);
				setState(458);
				match(T__22);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__8) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << UnaryOp) | (1L << ID))) != 0)) {
					{
					{
					setState(459);
					statement();
					}
					}
					setState(464);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(465);
				match(T__38);
				setState(466);
				match(T__22);
				setState(470);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__8) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << UnaryOp) | (1L << ID))) != 0)) {
					{
					{
					setState(467);
					statement();
					}
					}
					setState(472);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			expression(0);
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(476);
				match(T__5);
				setState(477);
				expression(0);
				}
				}
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode UnaryOp() { return getToken(uppaalParser.UnaryOp, 0); }
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public TerminalNode Rel() { return getToken(uppaalParser.Rel, 0); }
		public TerminalNode BinIntOp() { return getToken(uppaalParser.BinIntOp, 0); }
		public TerminalNode BinBoolOp() { return getToken(uppaalParser.BinBoolOp, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(484);
				match(ID);
				}
				break;
			case 2:
				{
				setState(485);
				match(T__39);
				}
				break;
			case 3:
				{
				setState(486);
				match(T__40);
				}
				break;
			case 4:
				{
				setState(487);
				match(ID);
				setState(488);
				match(T__1);
				setState(489);
				argList();
				setState(490);
				match(T__2);
				}
				break;
			case 5:
				{
				setState(492);
				match(T__1);
				setState(493);
				expression(0);
				setState(494);
				match(T__2);
				}
				break;
			case 6:
				{
				setState(496);
				match(T__41);
				setState(497);
				expression(10);
				}
				break;
			case 7:
				{
				setState(498);
				match(T__42);
				setState(499);
				expression(8);
				}
				break;
			case 8:
				{
				setState(500);
				match(UnaryOp);
				setState(501);
				expression(6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(537);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(535);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(504);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(505);
						assignOp();
						setState(506);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(508);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(509);
						match(Rel);
						setState(510);
						expression(6);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(511);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(512);
						match(BinIntOp);
						setState(513);
						expression(5);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(514);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(515);
						match(BinBoolOp);
						setState(516);
						expression(4);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(517);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(518);
						match(T__19);
						setState(519);
						expression(0);
						setState(520);
						match(T__22);
						setState(521);
						expression(3);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(523);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(524);
						match(T__23);
						setState(525);
						expression(0);
						setState(526);
						match(T__24);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(528);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(529);
						match(T__41);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(530);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(531);
						match(T__42);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(532);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(533);
						match(T__43);
						setState(534);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(539);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitArgList(this);
		}
	}

	public final ArgListContext argList() throws RecognitionException {
		ArgListContext _localctx = new ArgListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << UnaryOp) | (1L << ID))) != 0)) {
				{
				setState(540);
				expression(0);
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(541);
					match(T__5);
					setState(542);
					expression(0);
					}
					}
					setState(547);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignOpContext extends ParserRuleContext {
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitAssignOp(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 38:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3>\u022b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\7\2"+
		"V\n\2\f\2\16\2Y\13\2\3\2\7\2\\\n\2\f\2\16\2_\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\5\3g\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5u\n\5"+
		"\f\5\16\5x\13\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\u0080\n\6\f\6\16\6\u0083\13"+
		"\6\5\6\u0085\n\6\3\6\3\6\3\7\3\7\5\7\u008b\n\7\3\7\3\7\7\7\u008f\n\7\f"+
		"\7\16\7\u0092\13\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\7\n\u00a3\n\n\f\n\16\n\u00a6\13\n\3\n\3\n\5\n\u00aa\n\n\3\n\5"+
		"\n\u00ad\n\n\3\n\3\n\5\n\u00b1\n\n\3\13\3\13\3\13\3\13\7\13\u00b7\n\13"+
		"\f\13\16\13\u00ba\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00c3\n\f\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u00d0\n\17\f\17"+
		"\16\17\u00d3\13\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00dd"+
		"\n\21\f\21\16\21\u00e0\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\5\23\u00ed\n\23\3\24\3\24\5\24\u00f1\n\24\3\24\5\24\u00f4"+
		"\n\24\3\24\5\24\u00f7\n\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u010d\n\30"+
		"\f\30\16\30\u0110\13\30\3\30\3\30\3\31\3\31\7\31\u0116\n\31\f\31\16\31"+
		"\u0119\13\31\3\32\3\32\3\32\3\32\7\32\u011f\n\32\f\32\16\32\u0122\13\32"+
		"\3\32\3\32\3\33\3\33\7\33\u0128\n\33\f\33\16\33\u012b\13\33\3\33\3\33"+
		"\5\33\u012f\n\33\3\34\3\34\3\34\3\34\3\34\7\34\u0136\n\34\f\34\16\34\u0139"+
		"\13\34\3\34\3\34\5\34\u013d\n\34\3\35\3\35\5\35\u0141\n\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u014c\n\37\3\37\3\37\3\37\3\37"+
		"\6\37\u0152\n\37\r\37\16\37\u0153\3\37\3\37\5\37\u0158\n\37\3 \3 \3 \3"+
		" \7 \u015e\n \f \16 \u0161\13 \3 \3 \3!\3!\7!\u0167\n!\f!\16!\u016a\13"+
		"!\3\"\5\"\u016d\n\"\3\"\5\"\u0170\n\"\3\"\5\"\u0173\n\"\5\"\u0175\n\""+
		"\3#\3#\3#\3#\3#\3#\3$\3$\3$\7$\u0180\n$\f$\16$\u0183\13$\3$\7$\u0186\n"+
		"$\f$\16$\u0189\13$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01b1"+
		"\n%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\6%\u01bd\n%\r%\16%\u01be\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\5%\u01c9\n%\3&\3&\3&\3&\7&\u01cf\n&\f&\16&\u01d2\13&\3&"+
		"\3&\3&\7&\u01d7\n&\f&\16&\u01da\13&\5&\u01dc\n&\3\'\3\'\3\'\7\'\u01e1"+
		"\n\'\f\'\16\'\u01e4\13\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\5(\u01f9\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u021a\n(\f(\16(\u021d"+
		"\13(\3)\3)\3)\7)\u0222\n)\f)\16)\u0225\13)\5)\u0227\n)\3*\3*\3*\2\3N+"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH"+
		"JLNPR\2\4\3\2\25\26\4\2\3\3/8\u0250\2W\3\2\2\2\4f\3\2\2\2\6h\3\2\2\2\b"+
		"p\3\2\2\2\n{\3\2\2\2\f\u0088\3\2\2\2\16\u0093\3\2\2\2\20\u0098\3\2\2\2"+
		"\22\u00a4\3\2\2\2\24\u00b2\3\2\2\2\26\u00bd\3\2\2\2\30\u00c4\3\2\2\2\32"+
		"\u00c8\3\2\2\2\34\u00cc\3\2\2\2\36\u00d4\3\2\2\2 \u00d8\3\2\2\2\"\u00e3"+
		"\3\2\2\2$\u00ec\3\2\2\2&\u00ee\3\2\2\2(\u00fa\3\2\2\2*\u00fe\3\2\2\2,"+
		"\u0103\3\2\2\2.\u0107\3\2\2\2\60\u0113\3\2\2\2\62\u011a\3\2\2\2\64\u0125"+
		"\3\2\2\2\66\u013c\3\2\2\28\u0140\3\2\2\2:\u0144\3\2\2\2<\u0157\3\2\2\2"+
		">\u0159\3\2\2\2@\u0164\3\2\2\2B\u0174\3\2\2\2D\u0176\3\2\2\2F\u017c\3"+
		"\2\2\2H\u01c8\3\2\2\2J\u01db\3\2\2\2L\u01dd\3\2\2\2N\u01f8\3\2\2\2P\u0226"+
		"\3\2\2\2R\u0228\3\2\2\2TV\5\4\3\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2"+
		"\2\2X]\3\2\2\2YW\3\2\2\2Z\\\5\6\4\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3"+
		"\2\2\2^`\3\2\2\2_]\3\2\2\2`a\5\b\5\2a\3\3\2\2\2bg\5\16\b\2cg\5\62\32\2"+
		"dg\5.\30\2eg\5\20\t\2fb\3\2\2\2fc\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\5\3\2\2"+
		"\2hi\7=\2\2ij\7\3\2\2jk\7=\2\2kl\7\4\2\2lm\5P)\2mn\7\5\2\2no\7\6\2\2o"+
		"\7\3\2\2\2pq\7\7\2\2qv\7=\2\2rs\7\b\2\2su\7=\2\2tr\3\2\2\2ux\3\2\2\2v"+
		"t\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\6\2\2z\t\3\2\2\2{\u0084\7"+
		"\4\2\2|\u0081\5\f\7\2}~\7\b\2\2~\u0080\5\f\7\2\177}\3\2\2\2\u0080\u0083"+
		"\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084|\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2"+
		"\u0086\u0087\7\5\2\2\u0087\13\3\2\2\2\u0088\u008a\5<\37\2\u0089\u008b"+
		"\7\t\2\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u0090\7=\2\2\u008d\u008f\5:\36\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\r\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0094\5<\37\2\u0094\u0095\7=\2\2\u0095\u0096\5\n\6\2\u0096"+
		"\u0097\5F$\2\u0097\17\3\2\2\2\u0098\u0099\7\n\2\2\u0099\u009a\7=\2\2\u009a"+
		"\u009b\5\n\6\2\u009b\u009c\7\13\2\2\u009c\u009d\5\22\n\2\u009d\u009e\7"+
		"\f\2\2\u009e\21\3\2\2\2\u009f\u00a3\5\16\b\2\u00a0\u00a3\5\62\32\2\u00a1"+
		"\u00a3\5.\30\2\u00a2\u009f\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2"+
		"\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\5\24\13\2\u00a8\u00aa\5"+
		"\30\r\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab"+
		"\u00ad\5\32\16\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3"+
		"\2\2\2\u00ae\u00b0\5\36\20\2\u00af\u00b1\5 \21\2\u00b0\u00af\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\23\3\2\2\2\u00b2\u00b3\7\r\2\2\u00b3\u00b8\5\26\f"+
		"\2\u00b4\u00b5\7\b\2\2\u00b5\u00b7\5\26\f\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\6\2\2\u00bc\25\3\2\2\2\u00bd\u00c2"+
		"\7=\2\2\u00be\u00bf\7\13\2\2\u00bf\u00c0\5N(\2\u00c0\u00c1\7\f\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00be\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\27\3\2\2"+
		"\2\u00c4\u00c5\7\16\2\2\u00c5\u00c6\5\34\17\2\u00c6\u00c7\7\6\2\2\u00c7"+
		"\31\3\2\2\2\u00c8\u00c9\7\17\2\2\u00c9\u00ca\5\34\17\2\u00ca\u00cb\7\6"+
		"\2\2\u00cb\33\3\2\2\2\u00cc\u00d1\7=\2\2\u00cd\u00ce\7\b\2\2\u00ce\u00d0"+
		"\7=\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\35\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7\20\2"+
		"\2\u00d5\u00d6\7=\2\2\u00d6\u00d7\7\6\2\2\u00d7\37\3\2\2\2\u00d8\u00d9"+
		"\7\21\2\2\u00d9\u00de\5\"\22\2\u00da\u00db\7\b\2\2\u00db\u00dd\5$\23\2"+
		"\u00dc\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df"+
		"\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\6\2\2\u00e2"+
		"!\3\2\2\2\u00e3\u00e4\7=\2\2\u00e4\u00e5\7\22\2\2\u00e5\u00e6\7=\2\2\u00e6"+
		"\u00e7\5&\24\2\u00e7#\3\2\2\2\u00e8\u00ed\5\"\22\2\u00e9\u00ea\7\22\2"+
		"\2\u00ea\u00eb\7=\2\2\u00eb\u00ed\5&\24\2\u00ec\u00e8\3\2\2\2\u00ec\u00e9"+
		"\3\2\2\2\u00ed%\3\2\2\2\u00ee\u00f0\7\13\2\2\u00ef\u00f1\5(\25\2\u00f0"+
		"\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f4\5*"+
		"\26\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5"+
		"\u00f7\5,\27\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00f9\7\f\2\2\u00f9\'\3\2\2\2\u00fa\u00fb\7\23\2\2\u00fb\u00fc"+
		"\5N(\2\u00fc\u00fd\7\6\2\2\u00fd)\3\2\2\2\u00fe\u00ff\7\24\2\2\u00ff\u0100"+
		"\5N(\2\u0100\u0101\t\2\2\2\u0101\u0102\7\6\2\2\u0102+\3\2\2\2\u0103\u0104"+
		"\7\27\2\2\u0104\u0105\5L\'\2\u0105\u0106\7\6\2\2\u0106-\3\2\2\2\u0107"+
		"\u0108\7\30\2\2\u0108\u0109\5<\37\2\u0109\u010e\5\60\31\2\u010a\u010b"+
		"\7\b\2\2\u010b\u010d\5\60\31\2\u010c\u010a\3\2\2\2\u010d\u0110\3\2\2\2"+
		"\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e"+
		"\3\2\2\2\u0111\u0112\7\6\2\2\u0112/\3\2\2\2\u0113\u0117\7=\2\2\u0114\u0116"+
		"\5:\36\2\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\61\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\5<\37"+
		"\2\u011b\u0120\5\64\33\2\u011c\u011d\7\b\2\2\u011d\u011f\5\64\33\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0123\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7\6\2\2\u0124"+
		"\63\3\2\2\2\u0125\u0129\7=\2\2\u0126\u0128\5:\36\2\u0127\u0126\3\2\2\2"+
		"\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012e"+
		"\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7\3\2\2\u012d\u012f\5\66\34\2"+
		"\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\65\3\2\2\2\u0130\u013d"+
		"\5N(\2\u0131\u0132\7\13\2\2\u0132\u0137\58\35\2\u0133\u0134\7\b\2\2\u0134"+
		"\u0136\58\35\2\u0135\u0133\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013b\7\f\2\2\u013b\u013d\3\2\2\2\u013c\u0130\3\2\2\2\u013c\u0131\3\2"+
		"\2\2\u013d\67\3\2\2\2\u013e\u013f\7=\2\2\u013f\u0141\7\31\2\2\u0140\u013e"+
		"\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\5\66\34\2"+
		"\u01439\3\2\2\2\u0144\u0145\7\32\2\2\u0145\u0146\5N(\2\u0146\u0147\7\33"+
		"\2\2\u0147;\3\2\2\2\u0148\u0149\5B\"\2\u0149\u014b\7=\2\2\u014a\u014c"+
		"\5D#\2\u014b\u014a\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u0158\3\2\2\2\u014d"+
		"\u014e\5B\"\2\u014e\u014f\7\34\2\2\u014f\u0151\7\13\2\2\u0150\u0152\5"+
		"> \2\u0151\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0151\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\7\f\2\2\u0156\u0158\3\2"+
		"\2\2\u0157\u0148\3\2\2\2\u0157\u014d\3\2\2\2\u0158=\3\2\2\2\u0159\u015a"+
		"\5<\37\2\u015a\u015f\5@!\2\u015b\u015c\7\b\2\2\u015c\u015e\5@!\2\u015d"+
		"\u015b\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2"+
		"\2\2\u0160\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\7\6\2\2\u0163"+
		"?\3\2\2\2\u0164\u0168\7=\2\2\u0165\u0167\5:\36\2\u0166\u0165\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169A\3\2\2\2"+
		"\u016a\u0168\3\2\2\2\u016b\u016d\7\17\2\2\u016c\u016b\3\2\2\2\u016c\u016d"+
		"\3\2\2\2\u016d\u016f\3\2\2\2\u016e\u0170\7\35\2\2\u016f\u016e\3\2\2\2"+
		"\u016f\u0170\3\2\2\2\u0170\u0175\3\2\2\2\u0171\u0173\7\36\2\2\u0172\u0171"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u016c\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0175C\3\2\2\2\u0176\u0177\7\32\2\2\u0177\u0178\5N(\2\u0178"+
		"\u0179\7\b\2\2\u0179\u017a\5N(\2\u017a\u017b\7\33\2\2\u017bE\3\2\2\2\u017c"+
		"\u0181\7\13\2\2\u017d\u0180\5\62\32\2\u017e\u0180\5.\30\2\u017f\u017d"+
		"\3\2\2\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0187\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\5H"+
		"%\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\7\f"+
		"\2\2\u018bG\3\2\2\2\u018c\u01c9\5F$\2\u018d\u01c9\7\6\2\2\u018e\u018f"+
		"\5N(\2\u018f\u0190\7\6\2\2\u0190\u01c9\3\2\2\2\u0191\u0192\7\37\2\2\u0192"+
		"\u0193\7\4\2\2\u0193\u0194\5L\'\2\u0194\u0195\7\6\2\2\u0195\u0196\5L\'"+
		"\2\u0196\u0197\7\6\2\2\u0197\u0198\5L\'\2\u0198\u0199\7\5\2\2\u0199\u019a"+
		"\5H%\2\u019a\u01c9\3\2\2\2\u019b\u019c\7 \2\2\u019c\u019d\7\4\2\2\u019d"+
		"\u019e\5L\'\2\u019e\u019f\7\5\2\2\u019f\u01a0\5H%\2\u01a0\u01c9\3\2\2"+
		"\2\u01a1\u01a2\7!\2\2\u01a2\u01a3\5H%\2\u01a3\u01a4\7 \2\2\u01a4\u01a5"+
		"\7\4\2\2\u01a5\u01a6\5L\'\2\u01a6\u01a7\7\5\2\2\u01a7\u01a8\7\6\2\2\u01a8"+
		"\u01c9\3\2\2\2\u01a9\u01aa\7\"\2\2\u01aa\u01ab\7\4\2\2\u01ab\u01ac\5L"+
		"\'\2\u01ac\u01ad\7\5\2\2\u01ad\u01b0\5H%\2\u01ae\u01af\7#\2\2\u01af\u01b1"+
		"\5H%\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\u01c9\3\2\2\2\u01b2"+
		"\u01b3\7$\2\2\u01b3\u01c9\7\6\2\2\u01b4\u01b5\7%\2\2\u01b5\u01c9\7\6\2"+
		"\2\u01b6\u01b7\7&\2\2\u01b7\u01b8\7\4\2\2\u01b8\u01b9\5L\'\2\u01b9\u01ba"+
		"\7\5\2\2\u01ba\u01bc\7\13\2\2\u01bb\u01bd\5J&\2\u01bc\u01bb\3\2\2\2\u01bd"+
		"\u01be\3\2\2\2\u01be\u01bc\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c0\3\2"+
		"\2\2\u01c0\u01c1\7\f\2\2\u01c1\u01c9\3\2\2\2\u01c2\u01c3\7\'\2\2\u01c3"+
		"\u01c9\7\6\2\2\u01c4\u01c5\7\'\2\2\u01c5\u01c6\5N(\2\u01c6\u01c7\7\6\2"+
		"\2\u01c7\u01c9\3\2\2\2\u01c8\u018c\3\2\2\2\u01c8\u018d\3\2\2\2\u01c8\u018e"+
		"\3\2\2\2\u01c8\u0191\3\2\2\2\u01c8\u019b\3\2\2\2\u01c8\u01a1\3\2\2\2\u01c8"+
		"\u01a9\3\2\2\2\u01c8\u01b2\3\2\2\2\u01c8\u01b4\3\2\2\2\u01c8\u01b6\3\2"+
		"\2\2\u01c8\u01c2\3\2\2\2\u01c8\u01c4\3\2\2\2\u01c9I\3\2\2\2\u01ca\u01cb"+
		"\7(\2\2\u01cb\u01cc\5N(\2\u01cc\u01d0\7\31\2\2\u01cd\u01cf\5H%\2\u01ce"+
		"\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2"+
		"\2\2\u01d1\u01dc\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3\u01d4\7)\2\2\u01d4"+
		"\u01d8\7\31\2\2\u01d5\u01d7\5H%\2\u01d6\u01d5\3\2\2\2\u01d7\u01da\3\2"+
		"\2\2\u01d8\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da"+
		"\u01d8\3\2\2\2\u01db\u01ca\3\2\2\2\u01db\u01d3\3\2\2\2\u01dcK\3\2\2\2"+
		"\u01dd\u01e2\5N(\2\u01de\u01df\7\b\2\2\u01df\u01e1\5N(\2\u01e0\u01de\3"+
		"\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3"+
		"M\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01e6\b(\1\2\u01e6\u01f9\7=\2\2\u01e7"+
		"\u01f9\7*\2\2\u01e8\u01f9\7+\2\2\u01e9\u01ea\7=\2\2\u01ea\u01eb\7\4\2"+
		"\2\u01eb\u01ec\5P)\2\u01ec\u01ed\7\5\2\2\u01ed\u01f9\3\2\2\2\u01ee\u01ef"+
		"\7\4\2\2\u01ef\u01f0\5N(\2\u01f0\u01f1\7\5\2\2\u01f1\u01f9\3\2\2\2\u01f2"+
		"\u01f3\7,\2\2\u01f3\u01f9\5N(\f\u01f4\u01f5\7-\2\2\u01f5\u01f9\5N(\n\u01f6"+
		"\u01f7\79\2\2\u01f7\u01f9\5N(\b\u01f8\u01e5\3\2\2\2\u01f8\u01e7\3\2\2"+
		"\2\u01f8\u01e8\3\2\2\2\u01f8\u01e9\3\2\2\2\u01f8\u01ee\3\2\2\2\u01f8\u01f2"+
		"\3\2\2\2\u01f8\u01f4\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9\u021b\3\2\2\2\u01fa"+
		"\u01fb\f\t\2\2\u01fb\u01fc\5R*\2\u01fc\u01fd\5N(\n\u01fd\u021a\3\2\2\2"+
		"\u01fe\u01ff\f\7\2\2\u01ff\u0200\7:\2\2\u0200\u021a\5N(\b\u0201\u0202"+
		"\f\6\2\2\u0202\u0203\7;\2\2\u0203\u021a\5N(\7\u0204\u0205\f\5\2\2\u0205"+
		"\u0206\7<\2\2\u0206\u021a\5N(\6\u0207\u0208\f\4\2\2\u0208\u0209\7\26\2"+
		"\2\u0209\u020a\5N(\2\u020a\u020b\7\31\2\2\u020b\u020c\5N(\5\u020c\u021a"+
		"\3\2\2\2\u020d\u020e\f\17\2\2\u020e\u020f\7\32\2\2\u020f\u0210\5N(\2\u0210"+
		"\u0211\7\33\2\2\u0211\u021a\3\2\2\2\u0212\u0213\f\r\2\2\u0213\u021a\7"+
		",\2\2\u0214\u0215\f\13\2\2\u0215\u021a\7-\2\2\u0216\u0217\f\3\2\2\u0217"+
		"\u0218\7.\2\2\u0218\u021a\7=\2\2\u0219\u01fa\3\2\2\2\u0219\u01fe\3\2\2"+
		"\2\u0219\u0201\3\2\2\2\u0219\u0204\3\2\2\2\u0219\u0207\3\2\2\2\u0219\u020d"+
		"\3\2\2\2\u0219\u0212\3\2\2\2\u0219\u0214\3\2\2\2\u0219\u0216\3\2\2\2\u021a"+
		"\u021d\3\2\2\2\u021b\u0219\3\2\2\2\u021b\u021c\3\2\2\2\u021cO\3\2\2\2"+
		"\u021d\u021b\3\2\2\2\u021e\u0223\5N(\2\u021f\u0220\7\b\2\2\u0220\u0222"+
		"\5N(\2\u0221\u021f\3\2\2\2\u0222\u0225\3\2\2\2\u0223\u0221\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0227\3\2\2\2\u0225\u0223\3\2\2\2\u0226\u021e\3\2"+
		"\2\2\u0226\u0227\3\2\2\2\u0227Q\3\2\2\2\u0228\u0229\t\3\2\2\u0229S\3\2"+
		"\2\2\67W]fv\u0081\u0084\u008a\u0090\u00a2\u00a4\u00a9\u00ac\u00b0\u00b8"+
		"\u00c2\u00d1\u00de\u00ec\u00f0\u00f3\u00f6\u010e\u0117\u0120\u0129\u012e"+
		"\u0137\u013c\u0140\u014b\u0153\u0157\u015f\u0168\u016c\u016f\u0172\u0174"+
		"\u017f\u0181\u0187\u01b0\u01be\u01c8\u01d0\u01d8\u01db\u01e2\u01f8\u0219"+
		"\u021b\u0223\u0226";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}