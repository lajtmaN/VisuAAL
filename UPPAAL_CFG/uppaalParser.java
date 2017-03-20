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
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, ID=76, NAT=77, FLOAT=78, WS=79, BLOCK_COMMENT=80, 
		LINE_COMMENT=81;
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
		RULE_argList = 39, RULE_assignOp = 40, RULE_unaryOp = 41, RULE_rel = 42, 
		RULE_binIntOp = 43, RULE_binBoolOp = 44;
	public static final String[] ruleNames = {
		"xta", "declaration", "instantiation", "system", "parameterList", "parameter", 
		"functionDecl", "procDecl", "procBody", "states", "stateDecl", "commit", 
		"urgent", "stateList", "init", "transitions", "transition", "transitionOpt", 
		"transitionBody", "guard", "sync", "assign", "typeDecl", "typeIdList", 
		"variableDecl", "declId", "initialiser", "fieldInit", "arrayDecl", "type", 
		"fieldDecl", "fieldDeclId", "prefix", "range", "block", "statement", "caseExpr", 
		"exprList", "expression", "argList", "assignOp", "unaryOp", "rel", "binIntOp", 
		"binBoolOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "';'", "':='", "'system'", "','", "'&'", "'process'", 
		"'{'", "'}'", "'state'", "'commit'", "'urgent'", "'init'", "'trans'", 
		"'-'", "'guard'", "'sync'", "'!'", "'?'", "'assign'", "'typedef'", "':'", 
		"'['", "']'", "'struct'", "'broadcast'", "'const'", "'meta'", "'for'", 
		"'while'", "'do'", "'if'", "'else'", "'break'", "'continue'", "'switch'", 
		"'return'", "'case'", "'default'", "'true'", "'false'", "'++'", "'--'", 
		"'.'", "'''", "'exists'", "'forall'", "'+='", "'-='", "'*='", "'/='", 
		"'%='", "'|='", "'&='", "'^='", "'<<='", "'>>='", "'+'", "'<'", "'<='", 
		"'=='", "'!='", "'>='", "'>'", "'*'", "'/'", "'%'", "'|'", "'^'", "'<<'", 
		"'>>'", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "ID", "NAT", "FLOAT", "WS", "BLOCK_COMMENT", "LINE_COMMENT"
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
		public TerminalNode EOF() { return getToken(uppaalParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__13) | (1L << T__22) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0) || _la==ID) {
				{
				{
				setState(90);
				declaration();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(EOF);
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
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				variableDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				typeDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(ID);
				setState(105);
				match(T__0);
				setState(106);
				match(ID);
				setState(107);
				match(T__1);
				setState(108);
				argList();
				setState(109);
				match(T__2);
				setState(110);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(ID);
				setState(113);
				match(T__4);
				setState(114);
				match(ID);
				setState(115);
				match(T__1);
				setState(116);
				argList();
				setState(117);
				match(T__2);
				setState(118);
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
			setState(122);
			match(T__5);
			setState(123);
			match(ID);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(124);
				match(T__6);
				setState(125);
				match(ID);
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
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
			setState(133);
			match(T__1);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__26 - 14)) | (1L << (T__27 - 14)) | (1L << (T__28 - 14)) | (1L << (T__29 - 14)) | (1L << (ID - 14)))) != 0)) {
				{
				setState(134);
				parameter();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(135);
					match(T__6);
					setState(136);
					parameter();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
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
			setState(146);
			type();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(147);
				match(T__7);
				}
			}

			setState(150);
			match(ID);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(151);
				arrayDecl();
				}
				}
				setState(156);
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
			setState(157);
			type();
			setState(158);
			match(ID);
			setState(159);
			parameterList();
			setState(160);
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
			setState(162);
			match(T__8);
			setState(163);
			match(ID);
			setState(164);
			parameterList();
			setState(165);
			match(T__9);
			setState(166);
			procBody();
			setState(167);
			match(T__10);
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
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__22 - 14)) | (1L << (T__26 - 14)) | (1L << (T__27 - 14)) | (1L << (T__28 - 14)) | (1L << (T__29 - 14)) | (1L << (ID - 14)))) != 0)) {
				{
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(169);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(170);
					variableDecl();
					}
					break;
				case 3:
					{
					setState(171);
					typeDecl();
					}
					break;
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
			states();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(178);
				commit();
				}
			}

			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(181);
				urgent();
				}
			}

			setState(184);
			init();
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(185);
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
			setState(188);
			match(T__11);
			setState(189);
			stateDecl();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(190);
				match(T__6);
				setState(191);
				stateDecl();
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(197);
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
			setState(199);
			match(ID);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(200);
				match(T__9);
				setState(201);
				expression(0);
				setState(202);
				match(T__10);
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
			setState(206);
			match(T__12);
			setState(207);
			stateList();
			setState(208);
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
			setState(210);
			match(T__13);
			setState(211);
			stateList();
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
			setState(214);
			match(ID);
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(215);
				match(T__6);
				setState(216);
				match(ID);
				}
				}
				setState(221);
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
			setState(222);
			match(T__14);
			setState(223);
			match(ID);
			setState(224);
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
			setState(226);
			match(T__15);
			setState(227);
			transition();
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(228);
				match(T__6);
				setState(229);
				transitionOpt();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
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
			setState(237);
			match(ID);
			setState(238);
			match(T__16);
			setState(239);
			match(ID);
			setState(240);
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
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				transition();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				match(T__16);
				setState(244);
				match(ID);
				setState(245);
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
			setState(248);
			match(T__9);
			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(249);
				guard();
				}
			}

			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(252);
				sync();
				}
			}

			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(255);
				assign();
				}
			}

			setState(258);
			match(T__10);
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
			setState(260);
			match(T__17);
			setState(261);
			expression(0);
			setState(262);
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
			setState(264);
			match(T__18);
			setState(265);
			expression(0);
			setState(266);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__20) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(267);
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
			setState(269);
			match(T__21);
			setState(270);
			exprList();
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
			setState(273);
			match(T__22);
			setState(274);
			type();
			setState(275);
			typeIdList();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(276);
				match(T__6);
				setState(277);
				typeIdList();
				}
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(283);
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
			setState(285);
			match(ID);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(286);
				arrayDecl();
				}
				}
				setState(291);
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
			setState(292);
			type();
			setState(293);
			declId();
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(294);
				match(T__6);
				setState(295);
				declId();
				}
				}
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(301);
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
			setState(325);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				match(ID);
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(304);
					arrayDecl();
					}
					}
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(310);
					match(T__0);
					setState(311);
					initialiser();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				match(ID);
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__24) {
					{
					{
					setState(315);
					arrayDecl();
					}
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(321);
					match(T__4);
					setState(322);
					initialiser();
					}
				}

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
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__16:
			case T__19:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__47:
			case T__48:
			case T__59:
			case ID:
			case NAT:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				expression(0);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				match(T__9);
				setState(329);
				fieldInit();
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(330);
					match(T__6);
					setState(331);
					fieldInit();
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(337);
				match(T__10);
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
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(341);
				match(ID);
				setState(342);
				match(T__23);
				}
				break;
			}
			setState(345);
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
			setState(347);
			match(T__24);
			setState(348);
			expression(0);
			setState(349);
			match(T__25);
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
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				prefix();
				setState(352);
				match(ID);
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(353);
					range();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				prefix();
				setState(357);
				match(T__26);
				setState(358);
				match(T__9);
				setState(360); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(359);
					fieldDecl();
					}
					}
					setState(362); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__26 - 14)) | (1L << (T__27 - 14)) | (1L << (T__28 - 14)) | (1L << (T__29 - 14)) | (1L << (ID - 14)))) != 0) );
				setState(364);
				match(T__10);
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
			setState(368);
			type();
			setState(369);
			fieldDeclId();
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(370);
				match(T__6);
				setState(371);
				fieldDeclId();
				}
				}
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(377);
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
			setState(379);
			match(ID);
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(380);
				arrayDecl();
				}
				}
				setState(385);
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
			setState(398);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(386);
					match(T__13);
					}
				}

				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(389);
					match(T__27);
					}
				}

				}
				break;
			case 2:
				{
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__28) {
					{
					setState(392);
					match(T__28);
					}
				}

				}
				break;
			case 3:
				{
				setState(396);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(395);
					match(T__29);
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
			setState(400);
			match(T__24);
			setState(401);
			expression(0);
			setState(402);
			match(T__6);
			setState(403);
			expression(0);
			setState(404);
			match(T__25);
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
			setState(406);
			match(T__9);
			setState(411);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(409);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__13:
					case T__26:
					case T__27:
					case T__28:
					case T__29:
					case ID:
						{
						setState(407);
						variableDecl();
						}
						break;
					case T__22:
						{
						setState(408);
						typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(413);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__9) | (1L << T__16) | (1L << T__19) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__59))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
				{
				{
				setState(414);
				statement();
				}
				}
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(420);
			match(T__10);
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
		public TerminalNode ID() { return getToken(uppaalParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(424);
				expression(0);
				setState(425);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(427);
				match(T__30);
				setState(428);
				match(T__1);
				setState(429);
				exprList();
				setState(430);
				match(T__3);
				setState(431);
				exprList();
				setState(432);
				match(T__3);
				setState(433);
				exprList();
				setState(434);
				match(T__2);
				setState(435);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(437);
				match(T__30);
				setState(438);
				match(T__1);
				setState(439);
				match(ID);
				setState(440);
				match(T__23);
				setState(441);
				type();
				setState(442);
				match(T__2);
				setState(443);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(445);
				match(T__31);
				setState(446);
				match(T__1);
				setState(447);
				exprList();
				setState(448);
				match(T__2);
				setState(449);
				statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(451);
				match(T__32);
				setState(452);
				statement();
				setState(453);
				match(T__31);
				setState(454);
				match(T__1);
				setState(455);
				exprList();
				setState(456);
				match(T__2);
				setState(457);
				match(T__3);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(459);
				match(T__33);
				setState(460);
				match(T__1);
				setState(461);
				exprList();
				setState(462);
				match(T__2);
				setState(463);
				statement();
				setState(466);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(464);
					match(T__34);
					setState(465);
					statement();
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(468);
				match(T__35);
				setState(469);
				match(T__3);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(470);
				match(T__36);
				setState(471);
				match(T__3);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(472);
				match(T__37);
				setState(473);
				match(T__1);
				setState(474);
				exprList();
				setState(475);
				match(T__2);
				setState(476);
				match(T__9);
				setState(478); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(477);
					caseExpr();
					}
					}
					setState(480); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__39 || _la==T__40 );
				setState(482);
				match(T__10);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(484);
				match(T__38);
				setState(485);
				match(T__3);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(486);
				match(T__38);
				setState(487);
				expression(0);
				setState(488);
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
			setState(509);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__39:
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				match(T__39);
				setState(493);
				expression(0);
				setState(494);
				match(T__23);
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__9) | (1L << T__16) | (1L << T__19) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__59))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
					{
					{
					setState(495);
					statement();
					}
					}
					setState(500);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 2);
				{
				setState(501);
				match(T__40);
				setState(502);
				match(T__23);
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__9) | (1L << T__16) | (1L << T__19) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__59))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
					{
					{
					setState(503);
					statement();
					}
					}
					setState(508);
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
			setState(511);
			expression(0);
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(512);
				match(T__6);
				setState(513);
				expression(0);
				}
				}
				setState(518);
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
		public TerminalNode NAT() { return getToken(uppaalParser.NAT, 0); }
		public TerminalNode FLOAT() { return getToken(uppaalParser.FLOAT, 0); }
		public ArgListContext argList() {
			return getRuleContext(ArgListContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public BinIntOpContext binIntOp() {
			return getRuleContext(BinIntOpContext.class,0);
		}
		public BinBoolOpContext binBoolOp() {
			return getRuleContext(BinBoolOpContext.class,0);
		}
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
			setState(557);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(520);
				match(ID);
				}
				break;
			case 2:
				{
				setState(521);
				match(NAT);
				}
				break;
			case 3:
				{
				setState(522);
				match(FLOAT);
				}
				break;
			case 4:
				{
				setState(523);
				match(T__41);
				}
				break;
			case 5:
				{
				setState(524);
				match(T__42);
				}
				break;
			case 6:
				{
				setState(525);
				match(ID);
				setState(526);
				match(T__1);
				setState(527);
				argList();
				setState(528);
				match(T__2);
				}
				break;
			case 7:
				{
				setState(530);
				match(T__1);
				setState(531);
				expression(0);
				setState(532);
				match(T__2);
				}
				break;
			case 8:
				{
				setState(534);
				match(T__43);
				setState(535);
				expression(13);
				}
				break;
			case 9:
				{
				setState(536);
				match(T__44);
				setState(537);
				expression(11);
				}
				break;
			case 10:
				{
				setState(538);
				unaryOp();
				setState(539);
				expression(9);
				}
				break;
			case 11:
				{
				setState(541);
				match(T__47);
				setState(542);
				match(T__1);
				setState(543);
				match(ID);
				setState(544);
				match(T__23);
				setState(545);
				type();
				setState(546);
				match(T__2);
				setState(547);
				expression(2);
				}
				break;
			case 12:
				{
				setState(549);
				match(T__48);
				setState(550);
				match(T__1);
				setState(551);
				match(ID);
				setState(552);
				match(T__23);
				setState(553);
				type();
				setState(554);
				match(T__2);
				setState(555);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(597);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(595);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(559);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(560);
						assignOp();
						setState(561);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(563);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(564);
						rel();
						setState(565);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(567);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(568);
						binIntOp();
						setState(569);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(571);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(572);
						binBoolOp();
						setState(573);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(575);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(576);
						match(T__20);
						setState(577);
						expression(0);
						setState(578);
						match(T__23);
						setState(579);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(581);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(582);
						match(T__24);
						setState(583);
						expression(0);
						setState(584);
						match(T__25);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(586);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(587);
						match(T__43);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(588);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(589);
						match(T__44);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(590);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(591);
						match(T__45);
						setState(592);
						match(ID);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(593);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(594);
						match(T__46);
						}
						break;
					}
					} 
				}
				setState(599);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__16) | (1L << T__19) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__47) | (1L << T__48) | (1L << T__59))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
				{
				setState(600);
				expression(0);
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(601);
					match(T__6);
					setState(602);
					expression(0);
					}
					}
					setState(607);
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
			setState(610);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0)) ) {
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

	public static class UnaryOpContext extends ParserRuleContext {
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitUnaryOp(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__19) | (1L << T__59))) != 0)) ) {
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

	public static class RelContext extends ParserRuleContext {
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitRel(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_rel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			_la = _input.LA(1);
			if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (T__60 - 61)) | (1L << (T__61 - 61)) | (1L << (T__62 - 61)) | (1L << (T__63 - 61)) | (1L << (T__64 - 61)) | (1L << (T__65 - 61)))) != 0)) ) {
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

	public static class BinIntOpContext extends ParserRuleContext {
		public BinIntOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binIntOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterBinIntOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitBinIntOp(this);
		}
	}

	public final BinIntOpContext binIntOp() throws RecognitionException {
		BinIntOpContext _localctx = new BinIntOpContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_binIntOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__16) | (1L << T__59))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__67 - 67)) | (1L << (T__68 - 67)) | (1L << (T__69 - 67)) | (1L << (T__70 - 67)) | (1L << (T__71 - 67)) | (1L << (T__72 - 67)))) != 0)) ) {
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

	public static class BinBoolOpContext extends ParserRuleContext {
		public BinBoolOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binBoolOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterBinBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitBinBoolOp(this);
		}
	}

	public final BinBoolOpContext binBoolOp() throws RecognitionException {
		BinBoolOpContext _localctx = new BinBoolOpContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_binBoolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			_la = _input.LA(1);
			if ( !(_la==T__73 || _la==T__74) ) {
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
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 14);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u026f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\7\2^\n\2\f\2\16\2a\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5"+
		"\3i\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4{\n\4\3\5\3\5\3\5\3\5\7\5\u0081\n\5\f\5\16\5\u0084\13\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\5\6\u0091\n\6\3\6\3"+
		"\6\3\7\3\7\5\7\u0097\n\7\3\7\3\7\7\7\u009b\n\7\f\7\16\7\u009e\13\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u00af\n\n"+
		"\f\n\16\n\u00b2\13\n\3\n\3\n\5\n\u00b6\n\n\3\n\5\n\u00b9\n\n\3\n\3\n\5"+
		"\n\u00bd\n\n\3\13\3\13\3\13\3\13\7\13\u00c3\n\13\f\13\16\13\u00c6\13\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00cf\n\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\7\17\u00dc\n\17\f\17\16\17\u00df\13\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u00e9\n\21\f\21\16\21\u00ec\13"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00f9"+
		"\n\23\3\24\3\24\5\24\u00fd\n\24\3\24\5\24\u0100\n\24\3\24\5\24\u0103\n"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u0119\n\30\f\30\16\30\u011c\13"+
		"\30\3\30\3\30\3\31\3\31\7\31\u0122\n\31\f\31\16\31\u0125\13\31\3\32\3"+
		"\32\3\32\3\32\7\32\u012b\n\32\f\32\16\32\u012e\13\32\3\32\3\32\3\33\3"+
		"\33\7\33\u0134\n\33\f\33\16\33\u0137\13\33\3\33\3\33\5\33\u013b\n\33\3"+
		"\33\3\33\7\33\u013f\n\33\f\33\16\33\u0142\13\33\3\33\3\33\5\33\u0146\n"+
		"\33\5\33\u0148\n\33\3\34\3\34\3\34\3\34\3\34\7\34\u014f\n\34\f\34\16\34"+
		"\u0152\13\34\3\34\3\34\5\34\u0156\n\34\3\35\3\35\5\35\u015a\n\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u0165\n\37\3\37\3\37\3\37"+
		"\3\37\6\37\u016b\n\37\r\37\16\37\u016c\3\37\3\37\5\37\u0171\n\37\3 \3"+
		" \3 \3 \7 \u0177\n \f \16 \u017a\13 \3 \3 \3!\3!\7!\u0180\n!\f!\16!\u0183"+
		"\13!\3\"\5\"\u0186\n\"\3\"\5\"\u0189\n\"\3\"\5\"\u018c\n\"\3\"\5\"\u018f"+
		"\n\"\5\"\u0191\n\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\7$\u019c\n$\f$\16$\u019f"+
		"\13$\3$\7$\u01a2\n$\f$\16$\u01a5\13$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01d5\n%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\6%\u01e1\n%\r%\16%\u01e2\3%\3%\3%\3%\3%\3%\3%\3%\5%\u01ed\n"+
		"%\3&\3&\3&\3&\7&\u01f3\n&\f&\16&\u01f6\13&\3&\3&\3&\7&\u01fb\n&\f&\16"+
		"&\u01fe\13&\5&\u0200\n&\3\'\3\'\3\'\7\'\u0205\n\'\f\'\16\'\u0208\13\'"+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0230\n(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0256\n(\f(\16(\u0259\13(\3)\3)\3)\7)\u025e"+
		"\n)\f)\16)\u0261\13)\5)\u0263\n)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\2\3"+
		"N/\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD"+
		"FHJLNPRTVXZ\2\b\3\2\26\27\5\2\3\3\7\7\64=\5\2\23\23\26\26>>\3\2?D\6\2"+
		"\n\n\23\23>>EK\3\2LM\u029b\2_\3\2\2\2\4h\3\2\2\2\6z\3\2\2\2\b|\3\2\2\2"+
		"\n\u0087\3\2\2\2\f\u0094\3\2\2\2\16\u009f\3\2\2\2\20\u00a4\3\2\2\2\22"+
		"\u00b0\3\2\2\2\24\u00be\3\2\2\2\26\u00c9\3\2\2\2\30\u00d0\3\2\2\2\32\u00d4"+
		"\3\2\2\2\34\u00d8\3\2\2\2\36\u00e0\3\2\2\2 \u00e4\3\2\2\2\"\u00ef\3\2"+
		"\2\2$\u00f8\3\2\2\2&\u00fa\3\2\2\2(\u0106\3\2\2\2*\u010a\3\2\2\2,\u010f"+
		"\3\2\2\2.\u0113\3\2\2\2\60\u011f\3\2\2\2\62\u0126\3\2\2\2\64\u0147\3\2"+
		"\2\2\66\u0155\3\2\2\28\u0159\3\2\2\2:\u015d\3\2\2\2<\u0170\3\2\2\2>\u0172"+
		"\3\2\2\2@\u017d\3\2\2\2B\u0190\3\2\2\2D\u0192\3\2\2\2F\u0198\3\2\2\2H"+
		"\u01ec\3\2\2\2J\u01ff\3\2\2\2L\u0201\3\2\2\2N\u022f\3\2\2\2P\u0262\3\2"+
		"\2\2R\u0264\3\2\2\2T\u0266\3\2\2\2V\u0268\3\2\2\2X\u026a\3\2\2\2Z\u026c"+
		"\3\2\2\2\\^\5\4\3\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2"+
		"a_\3\2\2\2bc\7\2\2\3c\3\3\2\2\2di\5\16\b\2ei\5\62\32\2fi\5.\30\2gi\5\20"+
		"\t\2hd\3\2\2\2he\3\2\2\2hf\3\2\2\2hg\3\2\2\2i\5\3\2\2\2jk\7N\2\2kl\7\3"+
		"\2\2lm\7N\2\2mn\7\4\2\2no\5P)\2op\7\5\2\2pq\7\6\2\2q{\3\2\2\2rs\7N\2\2"+
		"st\7\7\2\2tu\7N\2\2uv\7\4\2\2vw\5P)\2wx\7\5\2\2xy\7\6\2\2y{\3\2\2\2zj"+
		"\3\2\2\2zr\3\2\2\2{\7\3\2\2\2|}\7\b\2\2}\u0082\7N\2\2~\177\7\t\2\2\177"+
		"\u0081\7N\2\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\6"+
		"\2\2\u0086\t\3\2\2\2\u0087\u0090\7\4\2\2\u0088\u008d\5\f\7\2\u0089\u008a"+
		"\7\t\2\2\u008a\u008c\5\f\7\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2"+
		"\2\2\u0090\u0088\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\7\5\2\2\u0093\13\3\2\2\2\u0094\u0096\5<\37\2\u0095\u0097\7\n\2"+
		"\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009c"+
		"\7N\2\2\u0099\u009b\5:\36\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\r\3\2\2\2\u009e\u009c\3\2\2\2"+
		"\u009f\u00a0\5<\37\2\u00a0\u00a1\7N\2\2\u00a1\u00a2\5\n\6\2\u00a2\u00a3"+
		"\5F$\2\u00a3\17\3\2\2\2\u00a4\u00a5\7\13\2\2\u00a5\u00a6\7N\2\2\u00a6"+
		"\u00a7\5\n\6\2\u00a7\u00a8\7\f\2\2\u00a8\u00a9\5\22\n\2\u00a9\u00aa\7"+
		"\r\2\2\u00aa\21\3\2\2\2\u00ab\u00af\5\16\b\2\u00ac\u00af\5\62\32\2\u00ad"+
		"\u00af\5.\30\2\u00ae\u00ab\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2"+
		"\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\5\24\13\2\u00b4\u00b6\5"+
		"\30\r\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7"+
		"\u00b9\5\32\16\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\3"+
		"\2\2\2\u00ba\u00bc\5\36\20\2\u00bb\u00bd\5 \21\2\u00bc\u00bb\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\23\3\2\2\2\u00be\u00bf\7\16\2\2\u00bf\u00c4\5\26"+
		"\f\2\u00c0\u00c1\7\t\2\2\u00c1\u00c3\5\26\f\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2"+
		"\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7\6\2\2\u00c8\25\3\2\2\2\u00c9\u00ce"+
		"\7N\2\2\u00ca\u00cb\7\f\2\2\u00cb\u00cc\5N(\2\u00cc\u00cd\7\r\2\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\27\3\2\2"+
		"\2\u00d0\u00d1\7\17\2\2\u00d1\u00d2\5\34\17\2\u00d2\u00d3\7\6\2\2\u00d3"+
		"\31\3\2\2\2\u00d4\u00d5\7\20\2\2\u00d5\u00d6\5\34\17\2\u00d6\u00d7\7\6"+
		"\2\2\u00d7\33\3\2\2\2\u00d8\u00dd\7N\2\2\u00d9\u00da\7\t\2\2\u00da\u00dc"+
		"\7N\2\2\u00db\u00d9\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00de\3\2\2\2\u00de\35\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7\21\2"+
		"\2\u00e1\u00e2\7N\2\2\u00e2\u00e3\7\6\2\2\u00e3\37\3\2\2\2\u00e4\u00e5"+
		"\7\22\2\2\u00e5\u00ea\5\"\22\2\u00e6\u00e7\7\t\2\2\u00e7\u00e9\5$\23\2"+
		"\u00e8\u00e6\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7\6\2\2\u00ee"+
		"!\3\2\2\2\u00ef\u00f0\7N\2\2\u00f0\u00f1\7\23\2\2\u00f1\u00f2\7N\2\2\u00f2"+
		"\u00f3\5&\24\2\u00f3#\3\2\2\2\u00f4\u00f9\5\"\22\2\u00f5\u00f6\7\23\2"+
		"\2\u00f6\u00f7\7N\2\2\u00f7\u00f9\5&\24\2\u00f8\u00f4\3\2\2\2\u00f8\u00f5"+
		"\3\2\2\2\u00f9%\3\2\2\2\u00fa\u00fc\7\f\2\2\u00fb\u00fd\5(\25\2\u00fc"+
		"\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u0100\5*"+
		"\26\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101"+
		"\u0103\5,\27\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0105\7\r\2\2\u0105\'\3\2\2\2\u0106\u0107\7\24\2\2\u0107\u0108"+
		"\5N(\2\u0108\u0109\7\6\2\2\u0109)\3\2\2\2\u010a\u010b\7\25\2\2\u010b\u010c"+
		"\5N(\2\u010c\u010d\t\2\2\2\u010d\u010e\7\6\2\2\u010e+\3\2\2\2\u010f\u0110"+
		"\7\30\2\2\u0110\u0111\5L\'\2\u0111\u0112\7\6\2\2\u0112-\3\2\2\2\u0113"+
		"\u0114\7\31\2\2\u0114\u0115\5<\37\2\u0115\u011a\5\60\31\2\u0116\u0117"+
		"\7\t\2\2\u0117\u0119\5\60\31\2\u0118\u0116\3\2\2\2\u0119\u011c\3\2\2\2"+
		"\u011a\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011d\u011e\7\6\2\2\u011e/\3\2\2\2\u011f\u0123\7N\2\2\u0120\u0122"+
		"\5:\36\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\61\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\5<\37"+
		"\2\u0127\u012c\5\64\33\2\u0128\u0129\7\t\2\2\u0129\u012b\5\64\33\2\u012a"+
		"\u0128\3\2\2\2\u012b\u012e\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2"+
		"\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2\2\2\u012f\u0130\7\6\2\2\u0130"+
		"\63\3\2\2\2\u0131\u0135\7N\2\2\u0132\u0134\5:\36\2\u0133\u0132\3\2\2\2"+
		"\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u013a"+
		"\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7\3\2\2\u0139\u013b\5\66\34\2"+
		"\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0148\3\2\2\2\u013c\u0140"+
		"\7N\2\2\u013d\u013f\5:\36\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0145\3\2\2\2\u0142\u0140\3\2"+
		"\2\2\u0143\u0144\7\7\2\2\u0144\u0146\5\66\34\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u0131\3\2\2\2\u0147\u013c\3\2"+
		"\2\2\u0148\65\3\2\2\2\u0149\u0156\5N(\2\u014a\u014b\7\f\2\2\u014b\u0150"+
		"\58\35\2\u014c\u014d\7\t\2\2\u014d\u014f\58\35\2\u014e\u014c\3\2\2\2\u014f"+
		"\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0153\3\2"+
		"\2\2\u0152\u0150\3\2\2\2\u0153\u0154\7\r\2\2\u0154\u0156\3\2\2\2\u0155"+
		"\u0149\3\2\2\2\u0155\u014a\3\2\2\2\u0156\67\3\2\2\2\u0157\u0158\7N\2\2"+
		"\u0158\u015a\7\32\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b"+
		"\3\2\2\2\u015b\u015c\5\66\34\2\u015c9\3\2\2\2\u015d\u015e\7\33\2\2\u015e"+
		"\u015f\5N(\2\u015f\u0160\7\34\2\2\u0160;\3\2\2\2\u0161\u0162\5B\"\2\u0162"+
		"\u0164\7N\2\2\u0163\u0165\5D#\2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2"+
		"\2\u0165\u0171\3\2\2\2\u0166\u0167\5B\"\2\u0167\u0168\7\35\2\2\u0168\u016a"+
		"\7\f\2\2\u0169\u016b\5> \2\u016a\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\7\r"+
		"\2\2\u016f\u0171\3\2\2\2\u0170\u0161\3\2\2\2\u0170\u0166\3\2\2\2\u0171"+
		"=\3\2\2\2\u0172\u0173\5<\37\2\u0173\u0178\5@!\2\u0174\u0175\7\t\2\2\u0175"+
		"\u0177\5@!\2\u0176\u0174\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2"+
		"\2\u0178\u0179\3\2\2\2\u0179\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c"+
		"\7\6\2\2\u017c?\3\2\2\2\u017d\u0181\7N\2\2\u017e\u0180\5:\36\2\u017f\u017e"+
		"\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0182\3\2\2\2\u0182"+
		"A\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0186\7\20\2\2\u0185\u0184\3\2\2\2"+
		"\u0185\u0186\3\2\2\2\u0186\u0188\3\2\2\2\u0187\u0189\7\36\2\2\u0188\u0187"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0191\3\2\2\2\u018a\u018c\7\37\2\2"+
		"\u018b\u018a\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u0191\3\2\2\2\u018d\u018f"+
		"\7 \2\2\u018e\u018d\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0191\3\2\2\2\u0190"+
		"\u0185\3\2\2\2\u0190\u018b\3\2\2\2\u0190\u018e\3\2\2\2\u0191C\3\2\2\2"+
		"\u0192\u0193\7\33\2\2\u0193\u0194\5N(\2\u0194\u0195\7\t\2\2\u0195\u0196"+
		"\5N(\2\u0196\u0197\7\34\2\2\u0197E\3\2\2\2\u0198\u019d\7\f\2\2\u0199\u019c"+
		"\5\62\32\2\u019a\u019c\5.\30\2\u019b\u0199\3\2\2\2\u019b\u019a\3\2\2\2"+
		"\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a3"+
		"\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u01a2\5H%\2\u01a1\u01a0\3\2\2\2\u01a2"+
		"\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2"+
		"\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a7\7\r\2\2\u01a7G\3\2\2\2\u01a8\u01ed"+
		"\5F$\2\u01a9\u01ed\7\6\2\2\u01aa\u01ab\5N(\2\u01ab\u01ac\7\6\2\2\u01ac"+
		"\u01ed\3\2\2\2\u01ad\u01ae\7!\2\2\u01ae\u01af\7\4\2\2\u01af\u01b0\5L\'"+
		"\2\u01b0\u01b1\7\6\2\2\u01b1\u01b2\5L\'\2\u01b2\u01b3\7\6\2\2\u01b3\u01b4"+
		"\5L\'\2\u01b4\u01b5\7\5\2\2\u01b5\u01b6\5H%\2\u01b6\u01ed\3\2\2\2\u01b7"+
		"\u01b8\7!\2\2\u01b8\u01b9\7\4\2\2\u01b9\u01ba\7N\2\2\u01ba\u01bb\7\32"+
		"\2\2\u01bb\u01bc\5<\37\2\u01bc\u01bd\7\5\2\2\u01bd\u01be\5H%\2\u01be\u01ed"+
		"\3\2\2\2\u01bf\u01c0\7\"\2\2\u01c0\u01c1\7\4\2\2\u01c1\u01c2\5L\'\2\u01c2"+
		"\u01c3\7\5\2\2\u01c3\u01c4\5H%\2\u01c4\u01ed\3\2\2\2\u01c5\u01c6\7#\2"+
		"\2\u01c6\u01c7\5H%\2\u01c7\u01c8\7\"\2\2\u01c8\u01c9\7\4\2\2\u01c9\u01ca"+
		"\5L\'\2\u01ca\u01cb\7\5\2\2\u01cb\u01cc\7\6\2\2\u01cc\u01ed\3\2\2\2\u01cd"+
		"\u01ce\7$\2\2\u01ce\u01cf\7\4\2\2\u01cf\u01d0\5L\'\2\u01d0\u01d1\7\5\2"+
		"\2\u01d1\u01d4\5H%\2\u01d2\u01d3\7%\2\2\u01d3\u01d5\5H%\2\u01d4\u01d2"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01ed\3\2\2\2\u01d6\u01d7\7&\2\2\u01d7"+
		"\u01ed\7\6\2\2\u01d8\u01d9\7\'\2\2\u01d9\u01ed\7\6\2\2\u01da\u01db\7("+
		"\2\2\u01db\u01dc\7\4\2\2\u01dc\u01dd\5L\'\2\u01dd\u01de\7\5\2\2\u01de"+
		"\u01e0\7\f\2\2\u01df\u01e1\5J&\2\u01e0\u01df\3\2\2\2\u01e1\u01e2\3\2\2"+
		"\2\u01e2\u01e0\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5"+
		"\7\r\2\2\u01e5\u01ed\3\2\2\2\u01e6\u01e7\7)\2\2\u01e7\u01ed\7\6\2\2\u01e8"+
		"\u01e9\7)\2\2\u01e9\u01ea\5N(\2\u01ea\u01eb\7\6\2\2\u01eb\u01ed\3\2\2"+
		"\2\u01ec\u01a8\3\2\2\2\u01ec\u01a9\3\2\2\2\u01ec\u01aa\3\2\2\2\u01ec\u01ad"+
		"\3\2\2\2\u01ec\u01b7\3\2\2\2\u01ec\u01bf\3\2\2\2\u01ec\u01c5\3\2\2\2\u01ec"+
		"\u01cd\3\2\2\2\u01ec\u01d6\3\2\2\2\u01ec\u01d8\3\2\2\2\u01ec\u01da\3\2"+
		"\2\2\u01ec\u01e6\3\2\2\2\u01ec\u01e8\3\2\2\2\u01edI\3\2\2\2\u01ee\u01ef"+
		"\7*\2\2\u01ef\u01f0\5N(\2\u01f0\u01f4\7\32\2\2\u01f1\u01f3\5H%\2\u01f2"+
		"\u01f1\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f4\u01f5\3\2"+
		"\2\2\u01f5\u0200\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f7\u01f8\7+\2\2\u01f8"+
		"\u01fc\7\32\2\2\u01f9\u01fb\5H%\2\u01fa\u01f9\3\2\2\2\u01fb\u01fe\3\2"+
		"\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe"+
		"\u01fc\3\2\2\2\u01ff\u01ee\3\2\2\2\u01ff\u01f7\3\2\2\2\u0200K\3\2\2\2"+
		"\u0201\u0206\5N(\2\u0202\u0203\7\t\2\2\u0203\u0205\5N(\2\u0204\u0202\3"+
		"\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"M\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020a\b(\1\2\u020a\u0230\7N\2\2\u020b"+
		"\u0230\7O\2\2\u020c\u0230\7P\2\2\u020d\u0230\7,\2\2\u020e\u0230\7-\2\2"+
		"\u020f\u0210\7N\2\2\u0210\u0211\7\4\2\2\u0211\u0212\5P)\2\u0212\u0213"+
		"\7\5\2\2\u0213\u0230\3\2\2\2\u0214\u0215\7\4\2\2\u0215\u0216\5N(\2\u0216"+
		"\u0217\7\5\2\2\u0217\u0230\3\2\2\2\u0218\u0219\7.\2\2\u0219\u0230\5N("+
		"\17\u021a\u021b\7/\2\2\u021b\u0230\5N(\r\u021c\u021d\5T+\2\u021d\u021e"+
		"\5N(\13\u021e\u0230\3\2\2\2\u021f\u0220\7\62\2\2\u0220\u0221\7\4\2\2\u0221"+
		"\u0222\7N\2\2\u0222\u0223\7\32\2\2\u0223\u0224\5<\37\2\u0224\u0225\7\5"+
		"\2\2\u0225\u0226\5N(\4\u0226\u0230\3\2\2\2\u0227\u0228\7\63\2\2\u0228"+
		"\u0229\7\4\2\2\u0229\u022a\7N\2\2\u022a\u022b\7\32\2\2\u022b\u022c\5<"+
		"\37\2\u022c\u022d\7\5\2\2\u022d\u022e\5N(\3\u022e\u0230\3\2\2\2\u022f"+
		"\u0209\3\2\2\2\u022f\u020b\3\2\2\2\u022f\u020c\3\2\2\2\u022f\u020d\3\2"+
		"\2\2\u022f\u020e\3\2\2\2\u022f\u020f\3\2\2\2\u022f\u0214\3\2\2\2\u022f"+
		"\u0218\3\2\2\2\u022f\u021a\3\2\2\2\u022f\u021c\3\2\2\2\u022f\u021f\3\2"+
		"\2\2\u022f\u0227\3\2\2\2\u0230\u0257\3\2\2\2\u0231\u0232\f\f\2\2\u0232"+
		"\u0233\5R*\2\u0233\u0234\5N(\r\u0234\u0256\3\2\2\2\u0235\u0236\f\n\2\2"+
		"\u0236\u0237\5V,\2\u0237\u0238\5N(\13\u0238\u0256\3\2\2\2\u0239\u023a"+
		"\f\t\2\2\u023a\u023b\5X-\2\u023b\u023c\5N(\n\u023c\u0256\3\2\2\2\u023d"+
		"\u023e\f\b\2\2\u023e\u023f\5Z.\2\u023f\u0240\5N(\t\u0240\u0256\3\2\2\2"+
		"\u0241\u0242\f\7\2\2\u0242\u0243\7\27\2\2\u0243\u0244\5N(\2\u0244\u0245"+
		"\7\32\2\2\u0245\u0246\5N(\b\u0246\u0256\3\2\2\2\u0247\u0248\f\22\2\2\u0248"+
		"\u0249\7\33\2\2\u0249\u024a\5N(\2\u024a\u024b\7\34\2\2\u024b\u0256\3\2"+
		"\2\2\u024c\u024d\f\20\2\2\u024d\u0256\7.\2\2\u024e\u024f\f\16\2\2\u024f"+
		"\u0256\7/\2\2\u0250\u0251\f\6\2\2\u0251\u0252\7\60\2\2\u0252\u0256\7N"+
		"\2\2\u0253\u0254\f\5\2\2\u0254\u0256\7\61\2\2\u0255\u0231\3\2\2\2\u0255"+
		"\u0235\3\2\2\2\u0255\u0239\3\2\2\2\u0255\u023d\3\2\2\2\u0255\u0241\3\2"+
		"\2\2\u0255\u0247\3\2\2\2\u0255\u024c\3\2\2\2\u0255\u024e\3\2\2\2\u0255"+
		"\u0250\3\2\2\2\u0255\u0253\3\2\2\2\u0256\u0259\3\2\2\2\u0257\u0255\3\2"+
		"\2\2\u0257\u0258\3\2\2\2\u0258O\3\2\2\2\u0259\u0257\3\2\2\2\u025a\u025f"+
		"\5N(\2\u025b\u025c\7\t\2\2\u025c\u025e\5N(\2\u025d\u025b\3\2\2\2\u025e"+
		"\u0261\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0263\3\2"+
		"\2\2\u0261\u025f\3\2\2\2\u0262\u025a\3\2\2\2\u0262\u0263\3\2\2\2\u0263"+
		"Q\3\2\2\2\u0264\u0265\t\3\2\2\u0265S\3\2\2\2\u0266\u0267\t\4\2\2\u0267"+
		"U\3\2\2\2\u0268\u0269\t\5\2\2\u0269W\3\2\2\2\u026a\u026b\t\6\2\2\u026b"+
		"Y\3\2\2\2\u026c\u026d\t\7\2\2\u026d[\3\2\2\2;_hz\u0082\u008d\u0090\u0096"+
		"\u009c\u00ae\u00b0\u00b5\u00b8\u00bc\u00c4\u00ce\u00dd\u00ea\u00f8\u00fc"+
		"\u00ff\u0102\u011a\u0123\u012c\u0135\u013a\u0140\u0145\u0147\u0150\u0155"+
		"\u0159\u0164\u016c\u0170\u0178\u0181\u0185\u0188\u018b\u018e\u0190\u019b"+
		"\u019d\u01a3\u01d4\u01e2\u01ec\u01f4\u01fc\u01ff\u0206\u022f\u0255\u0257"+
		"\u025f\u0262";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}