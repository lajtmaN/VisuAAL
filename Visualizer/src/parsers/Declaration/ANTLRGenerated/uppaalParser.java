package parsers.Declaration.ANTLRGenerated;// Generated from uppaal.g4 by ANTLR 4.6
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
		RULE_xta = 0, RULE_declaration = 1, RULE_instantiation = 2, RULE_systemBlock = 3, 
		RULE_system = 4, RULE_parameterList = 5, RULE_parameter = 6, RULE_functionDecl = 7, 
		RULE_procDecl = 8, RULE_procBody = 9, RULE_states = 10, RULE_stateDecl = 11, 
		RULE_commit = 12, RULE_urgent = 13, RULE_stateList = 14, RULE_init = 15, 
		RULE_transitions = 16, RULE_transition = 17, RULE_transitionOpt = 18, 
		RULE_transitionBody = 19, RULE_guard = 20, RULE_sync = 21, RULE_assign = 22, 
		RULE_typeDecl = 23, RULE_typeIdList = 24, RULE_variableDecl = 25, RULE_declId = 26, 
		RULE_initialiser = 27, RULE_fieldInit = 28, RULE_arrayDecl = 29, RULE_type = 30, 
		RULE_fieldDecl = 31, RULE_fieldDeclId = 32, RULE_prefix = 33, RULE_range = 34, 
		RULE_block = 35, RULE_statement = 36, RULE_caseExpr = 37, RULE_exprList = 38, 
		RULE_expression = 39, RULE_argList = 40, RULE_assignOp = 41, RULE_unaryOp = 42, 
		RULE_rel = 43, RULE_binIntOp = 44, RULE_binBoolOp = 45;
	public static final String[] ruleNames = {
		"xta", "declaration", "instantiation", "systemBlock", "system", "parameterList", 
		"parameter", "functionDecl", "procDecl", "procBody", "states", "stateDecl", 
		"commit", "urgent", "stateList", "init", "transitions", "transition", 
		"transitionOpt", "transitionBody", "guard", "sync", "assign", "typeDecl", 
		"typeIdList", "variableDecl", "declId", "initialiser", "fieldInit", "arrayDecl", 
		"type", "fieldDecl", "fieldDeclId", "prefix", "range", "block", "statement", 
		"caseExpr", "exprList", "expression", "argList", "assignOp", "unaryOp", 
		"rel", "binIntOp", "binBoolOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "';'", "':='", "'system'", "','", "'<'", "'&'", 
		"'process'", "'{'", "'}'", "'state'", "'commit'", "'urgent'", "'init'", 
		"'trans'", "'-'", "'guard'", "'sync'", "'!'", "'?'", "'assign'", "'typedef'", 
		"':'", "'['", "']'", "'struct'", "'broadcast'", "'const'", "'meta'", "'for'", 
		"'while'", "'do'", "'if'", "'else'", "'break'", "'continue'", "'switch'", 
		"'return'", "'case'", "'default'", "'true'", "'false'", "'++'", "'--'", 
		"'.'", "'''", "'exists'", "'forall'", "'+='", "'-='", "'*='", "'/='", 
		"'%='", "'|='", "'&='", "'^='", "'<<='", "'>>='", "'+'", "'<='", "'=='", 
		"'!='", "'>='", "'>'", "'*'", "'/'", "'%'", "'|'", "'^'", "'<<'", "'>>'", 
		"'&&'", "'||'"
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__14) | (1L << T__23) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30))) != 0) || _la==ID) {
				{
				{
				setState(92);
				declaration();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
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
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				variableDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				typeDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(103);
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
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(ID);
				setState(107);
				match(T__0);
				setState(108);
				match(ID);
				setState(109);
				match(T__1);
				setState(110);
				argList();
				setState(111);
				match(T__2);
				setState(112);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(ID);
				setState(115);
				match(T__4);
				setState(116);
				match(ID);
				setState(117);
				match(T__1);
				setState(118);
				argList();
				setState(119);
				match(T__2);
				setState(120);
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

	public static class SystemBlockContext extends ParserRuleContext {
		public SystemContext system() {
			return getRuleContext(SystemContext.class,0);
		}
		public List<InstantiationContext> instantiation() {
			return getRuleContexts(InstantiationContext.class);
		}
		public InstantiationContext instantiation(int i) {
			return getRuleContext(InstantiationContext.class,i);
		}
		public SystemBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).enterSystemBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof uppaalListener ) ((uppaalListener)listener).exitSystemBlock(this);
		}
	}

	public final SystemBlockContext systemBlock() throws RecognitionException {
		SystemBlockContext _localctx = new SystemBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_systemBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(124);
				instantiation();
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
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
		enterRule(_localctx, 8, RULE_system);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__5);
			setState(133);
			match(ID);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6 || _la==T__7) {
				{
				{
				setState(134);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(135);
				match(ID);
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
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
		enterRule(_localctx, 10, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__1);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (T__14 - 15)) | (1L << (T__27 - 15)) | (1L << (T__28 - 15)) | (1L << (T__29 - 15)) | (1L << (T__30 - 15)) | (1L << (ID - 15)))) != 0)) {
				{
				setState(144);
				parameter();
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(145);
					match(T__6);
					setState(146);
					parameter();
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(154);
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
		enterRule(_localctx, 12, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			type();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(157);
				match(T__8);
				}
			}

			setState(160);
			match(ID);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(161);
				arrayDecl();
				}
				}
				setState(166);
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
		enterRule(_localctx, 14, RULE_functionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			type();
			setState(168);
			match(ID);
			setState(169);
			parameterList();
			setState(170);
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
		enterRule(_localctx, 16, RULE_procDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__9);
			setState(173);
			match(ID);
			setState(174);
			parameterList();
			setState(175);
			match(T__10);
			setState(176);
			procBody();
			setState(177);
			match(T__11);
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
		enterRule(_localctx, 18, RULE_procBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (T__14 - 15)) | (1L << (T__23 - 15)) | (1L << (T__27 - 15)) | (1L << (T__28 - 15)) | (1L << (T__29 - 15)) | (1L << (T__30 - 15)) | (1L << (ID - 15)))) != 0)) {
				{
				setState(182);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(179);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(180);
					variableDecl();
					}
					break;
				case 3:
					{
					setState(181);
					typeDecl();
					}
					break;
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(187);
			states();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(188);
				commit();
				}
			}

			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(191);
				urgent();
				}
			}

			setState(194);
			init();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(195);
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
		enterRule(_localctx, 20, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__12);
			setState(199);
			stateDecl();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(200);
				match(T__6);
				setState(201);
				stateDecl();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
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
		enterRule(_localctx, 22, RULE_stateDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(ID);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(210);
				match(T__10);
				setState(211);
				expression(0);
				setState(212);
				match(T__11);
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
		enterRule(_localctx, 24, RULE_commit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(T__13);
			setState(217);
			stateList();
			setState(218);
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
		enterRule(_localctx, 26, RULE_urgent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__14);
			setState(221);
			stateList();
			setState(222);
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
		enterRule(_localctx, 28, RULE_stateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(ID);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(225);
				match(T__6);
				setState(226);
				match(ID);
				}
				}
				setState(231);
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
		enterRule(_localctx, 30, RULE_init);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__15);
			setState(233);
			match(ID);
			setState(234);
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
		enterRule(_localctx, 32, RULE_transitions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__16);
			setState(237);
			transition();
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(238);
				match(T__6);
				setState(239);
				transitionOpt();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245);
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
		enterRule(_localctx, 34, RULE_transition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(ID);
			setState(248);
			match(T__17);
			setState(249);
			match(ID);
			setState(250);
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
		enterRule(_localctx, 36, RULE_transitionOpt);
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				transition();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(T__17);
				setState(254);
				match(ID);
				setState(255);
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
		enterRule(_localctx, 38, RULE_transitionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__10);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(259);
				guard();
				}
			}

			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(262);
				sync();
				}
			}

			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(265);
				assign();
				}
			}

			setState(268);
			match(T__11);
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
		enterRule(_localctx, 40, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__18);
			setState(271);
			expression(0);
			setState(272);
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
		enterRule(_localctx, 42, RULE_sync);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__19);
			setState(275);
			expression(0);
			setState(276);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__21) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(277);
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
		enterRule(_localctx, 44, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__22);
			setState(280);
			exprList();
			setState(281);
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
		enterRule(_localctx, 46, RULE_typeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__23);
			setState(284);
			type();
			setState(285);
			typeIdList();
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(286);
				match(T__6);
				setState(287);
				typeIdList();
				}
				}
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(293);
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
		enterRule(_localctx, 48, RULE_typeIdList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(ID);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(296);
				arrayDecl();
				}
				}
				setState(301);
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
		enterRule(_localctx, 50, RULE_variableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			type();
			setState(303);
			declId();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(304);
				match(T__6);
				setState(305);
				declId();
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
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
		enterRule(_localctx, 52, RULE_declId);
		int _la;
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				match(ID);
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__25) {
					{
					{
					setState(314);
					arrayDecl();
					}
					}
					setState(319);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(320);
					match(T__0);
					setState(321);
					initialiser();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				match(ID);
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__25) {
					{
					{
					setState(325);
					arrayDecl();
					}
					}
					setState(330);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(331);
					match(T__4);
					setState(332);
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
		enterRule(_localctx, 54, RULE_initialiser);
		int _la;
		try {
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__17:
			case T__20:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__48:
			case T__49:
			case T__60:
			case ID:
			case NAT:
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				expression(0);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				match(T__10);
				setState(339);
				fieldInit();
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(340);
					match(T__6);
					setState(341);
					fieldInit();
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(347);
				match(T__11);
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
		enterRule(_localctx, 56, RULE_fieldInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(351);
				match(ID);
				setState(352);
				match(T__24);
				}
				break;
			}
			setState(355);
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
		enterRule(_localctx, 58, RULE_arrayDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(T__25);
			setState(358);
			expression(0);
			setState(359);
			match(T__26);
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
		enterRule(_localctx, 60, RULE_type);
		int _la;
		try {
			setState(376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				prefix();
				setState(362);
				match(ID);
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(363);
					range();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				prefix();
				setState(367);
				match(T__27);
				setState(368);
				match(T__10);
				setState(370); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(369);
					fieldDecl();
					}
					}
					setState(372); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 15)) & ~0x3f) == 0 && ((1L << (_la - 15)) & ((1L << (T__14 - 15)) | (1L << (T__27 - 15)) | (1L << (T__28 - 15)) | (1L << (T__29 - 15)) | (1L << (T__30 - 15)) | (1L << (ID - 15)))) != 0) );
				setState(374);
				match(T__11);
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
		enterRule(_localctx, 62, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			type();
			setState(379);
			fieldDeclId();
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(380);
				match(T__6);
				setState(381);
				fieldDeclId();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
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
		enterRule(_localctx, 64, RULE_fieldDeclId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(ID);
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(390);
				arrayDecl();
				}
				}
				setState(395);
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
		enterRule(_localctx, 66, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(396);
					match(T__14);
					}
				}

				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__28) {
					{
					setState(399);
					match(T__28);
					}
				}

				}
				break;
			case 2:
				{
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__29) {
					{
					setState(402);
					match(T__29);
					}
				}

				}
				break;
			case 3:
				{
				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(405);
					match(T__30);
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
		enterRule(_localctx, 68, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(T__25);
			setState(411);
			expression(0);
			setState(412);
			match(T__6);
			setState(413);
			expression(0);
			setState(414);
			match(T__26);
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
		enterRule(_localctx, 70, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			match(T__10);
			setState(421);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(419);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__14:
					case T__27:
					case T__28:
					case T__29:
					case T__30:
					case ID:
						{
						setState(417);
						variableDecl();
						}
						break;
					case T__23:
						{
						setState(418);
						typeDecl();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(423);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__17) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__48) | (1L << T__49) | (1L << T__60))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
				{
				{
				setState(424);
				statement();
				}
				}
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(430);
			match(T__11);
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
		enterRule(_localctx, 72, RULE_statement);
		int _la;
		try {
			setState(500);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(434);
				expression(0);
				setState(435);
				match(T__3);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
				match(T__31);
				setState(438);
				match(T__1);
				setState(439);
				exprList();
				setState(440);
				match(T__3);
				setState(441);
				exprList();
				setState(442);
				match(T__3);
				setState(443);
				exprList();
				setState(444);
				match(T__2);
				setState(445);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(447);
				match(T__31);
				setState(448);
				match(T__1);
				setState(449);
				match(ID);
				setState(450);
				match(T__24);
				setState(451);
				type();
				setState(452);
				match(T__2);
				setState(453);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(455);
				match(T__32);
				setState(456);
				match(T__1);
				setState(457);
				exprList();
				setState(458);
				match(T__2);
				setState(459);
				statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(461);
				match(T__33);
				setState(462);
				statement();
				setState(463);
				match(T__32);
				setState(464);
				match(T__1);
				setState(465);
				exprList();
				setState(466);
				match(T__2);
				setState(467);
				match(T__3);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(469);
				match(T__34);
				setState(470);
				match(T__1);
				setState(471);
				exprList();
				setState(472);
				match(T__2);
				setState(473);
				statement();
				setState(476);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(474);
					match(T__35);
					setState(475);
					statement();
					}
					break;
				}
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(478);
				match(T__36);
				setState(479);
				match(T__3);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(480);
				match(T__37);
				setState(481);
				match(T__3);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(482);
				match(T__38);
				setState(483);
				match(T__1);
				setState(484);
				exprList();
				setState(485);
				match(T__2);
				setState(486);
				match(T__10);
				setState(488); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(487);
					caseExpr();
					}
					}
					setState(490); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__40 || _la==T__41 );
				setState(492);
				match(T__11);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(494);
				match(T__39);
				setState(495);
				match(T__3);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(496);
				match(T__39);
				setState(497);
				expression(0);
				setState(498);
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
		enterRule(_localctx, 74, RULE_caseExpr);
		int _la;
		try {
			setState(519);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(502);
				match(T__40);
				setState(503);
				expression(0);
				setState(504);
				match(T__24);
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__17) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__48) | (1L << T__49) | (1L << T__60))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
					{
					{
					setState(505);
					statement();
					}
					}
					setState(510);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 2);
				{
				setState(511);
				match(T__41);
				setState(512);
				match(T__24);
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__10) | (1L << T__17) | (1L << T__20) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__48) | (1L << T__49) | (1L << T__60))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
					{
					{
					setState(513);
					statement();
					}
					}
					setState(518);
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
		enterRule(_localctx, 76, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			expression(0);
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(522);
				match(T__6);
				setState(523);
				expression(0);
				}
				}
				setState(528);
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
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(530);
				match(ID);
				}
				break;
			case 2:
				{
				setState(531);
				match(NAT);
				}
				break;
			case 3:
				{
				setState(532);
				match(FLOAT);
				}
				break;
			case 4:
				{
				setState(533);
				match(T__42);
				}
				break;
			case 5:
				{
				setState(534);
				match(T__43);
				}
				break;
			case 6:
				{
				setState(535);
				match(ID);
				setState(536);
				match(T__1);
				setState(537);
				argList();
				setState(538);
				match(T__2);
				}
				break;
			case 7:
				{
				setState(540);
				match(T__1);
				setState(541);
				expression(0);
				setState(542);
				match(T__2);
				}
				break;
			case 8:
				{
				setState(544);
				match(T__44);
				setState(545);
				expression(13);
				}
				break;
			case 9:
				{
				setState(546);
				match(T__45);
				setState(547);
				expression(11);
				}
				break;
			case 10:
				{
				setState(548);
				unaryOp();
				setState(549);
				expression(9);
				}
				break;
			case 11:
				{
				setState(551);
				match(T__48);
				setState(552);
				match(T__1);
				setState(553);
				match(ID);
				setState(554);
				match(T__24);
				setState(555);
				type();
				setState(556);
				match(T__2);
				setState(557);
				expression(2);
				}
				break;
			case 12:
				{
				setState(559);
				match(T__49);
				setState(560);
				match(T__1);
				setState(561);
				match(ID);
				setState(562);
				match(T__24);
				setState(563);
				type();
				setState(564);
				match(T__2);
				setState(565);
				expression(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(607);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(605);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(569);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(570);
						assignOp();
						setState(571);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(573);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(574);
						rel();
						setState(575);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(577);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(578);
						binIntOp();
						setState(579);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(581);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(582);
						binBoolOp();
						setState(583);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(585);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(586);
						match(T__21);
						setState(587);
						expression(0);
						setState(588);
						match(T__24);
						setState(589);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(591);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(592);
						match(T__25);
						setState(593);
						expression(0);
						setState(594);
						match(T__26);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(596);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(597);
						match(T__44);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(598);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(599);
						match(T__45);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(600);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(601);
						match(T__46);
						setState(602);
						match(ID);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(603);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(604);
						match(T__47);
						}
						break;
					}
					} 
				}
				setState(609);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
		enterRule(_localctx, 80, RULE_argList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__17) | (1L << T__20) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__48) | (1L << T__49) | (1L << T__60))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (ID - 76)) | (1L << (NAT - 76)) | (1L << (FLOAT - 76)))) != 0)) {
				{
				setState(610);
				expression(0);
				setState(615);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(611);
					match(T__6);
					setState(612);
					expression(0);
					}
					}
					setState(617);
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
		enterRule(_localctx, 82, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59))) != 0)) ) {
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
		enterRule(_localctx, 84, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__20) | (1L << T__60))) != 0)) ) {
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
		enterRule(_localctx, 86, RULE_rel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			_la = _input.LA(1);
			if ( !(((((_la - 8)) & ~0x3f) == 0 && ((1L << (_la - 8)) & ((1L << (T__7 - 8)) | (1L << (T__61 - 8)) | (1L << (T__62 - 8)) | (1L << (T__63 - 8)) | (1L << (T__64 - 8)) | (1L << (T__65 - 8)))) != 0)) ) {
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
		enterRule(_localctx, 88, RULE_binIntOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__17) | (1L << T__60))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (T__66 - 67)) | (1L << (T__67 - 67)) | (1L << (T__68 - 67)) | (1L << (T__69 - 67)) | (1L << (T__70 - 67)) | (1L << (T__71 - 67)) | (1L << (T__72 - 67)))) != 0)) ) {
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
		enterRule(_localctx, 90, RULE_binBoolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
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
		case 39:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u0279\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\7\2`\n\2\f\2\16\2c\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\5\3k\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4}\n\4\3\5\7\5\u0080\n\5\f\5\16\5\u0083\13\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\7\6\u008b\n\6\f\6\16\6\u008e\13\6\3\6\3\6\3\7\3\7\3\7\3\7\7"+
		"\7\u0096\n\7\f\7\16\7\u0099\13\7\5\7\u009b\n\7\3\7\3\7\3\b\3\b\5\b\u00a1"+
		"\n\b\3\b\3\b\7\b\u00a5\n\b\f\b\16\b\u00a8\13\b\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u00b9\n\13\f\13\16\13\u00bc"+
		"\13\13\3\13\3\13\5\13\u00c0\n\13\3\13\5\13\u00c3\n\13\3\13\3\13\5\13\u00c7"+
		"\n\13\3\f\3\f\3\f\3\f\7\f\u00cd\n\f\f\f\16\f\u00d0\13\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00d9\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\7\20\u00e6\n\20\f\20\16\20\u00e9\13\20\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\7\22\u00f3\n\22\f\22\16\22\u00f6\13\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u0103\n\24\3\25"+
		"\3\25\5\25\u0107\n\25\3\25\5\25\u010a\n\25\3\25\5\25\u010d\n\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\7\31\u0123\n\31\f\31\16\31\u0126\13\31\3\31\3"+
		"\31\3\32\3\32\7\32\u012c\n\32\f\32\16\32\u012f\13\32\3\33\3\33\3\33\3"+
		"\33\7\33\u0135\n\33\f\33\16\33\u0138\13\33\3\33\3\33\3\34\3\34\7\34\u013e"+
		"\n\34\f\34\16\34\u0141\13\34\3\34\3\34\5\34\u0145\n\34\3\34\3\34\7\34"+
		"\u0149\n\34\f\34\16\34\u014c\13\34\3\34\3\34\5\34\u0150\n\34\5\34\u0152"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\7\35\u0159\n\35\f\35\16\35\u015c\13\35"+
		"\3\35\3\35\5\35\u0160\n\35\3\36\3\36\5\36\u0164\n\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3 \3 \3 \5 \u016f\n \3 \3 \3 \3 \6 \u0175\n \r \16 \u0176"+
		"\3 \3 \5 \u017b\n \3!\3!\3!\3!\7!\u0181\n!\f!\16!\u0184\13!\3!\3!\3\""+
		"\3\"\7\"\u018a\n\"\f\"\16\"\u018d\13\"\3#\5#\u0190\n#\3#\5#\u0193\n#\3"+
		"#\5#\u0196\n#\3#\5#\u0199\n#\5#\u019b\n#\3$\3$\3$\3$\3$\3$\3%\3%\3%\7"+
		"%\u01a6\n%\f%\16%\u01a9\13%\3%\7%\u01ac\n%\f%\16%\u01af\13%\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u01df\n"+
		"&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\6&\u01eb\n&\r&\16&\u01ec\3&\3&\3&\3&\3"+
		"&\3&\3&\3&\5&\u01f7\n&\3\'\3\'\3\'\3\'\7\'\u01fd\n\'\f\'\16\'\u0200\13"+
		"\'\3\'\3\'\3\'\7\'\u0205\n\'\f\'\16\'\u0208\13\'\5\'\u020a\n\'\3(\3(\3"+
		"(\7(\u020f\n(\f(\16(\u0212\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\5)\u023a\n)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)"+
		"\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u0260\n)"+
		"\f)\16)\u0263\13)\3*\3*\3*\7*\u0268\n*\f*\16*\u026b\13*\5*\u026d\n*\3"+
		"+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\2\3P\60\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\t\3\2\t\n\3\2\27"+
		"\30\5\2\3\3\7\7\65>\5\2\24\24\27\27??\4\2\n\n@D\6\2\13\13\24\24??EK\3"+
		"\2LM\u02a5\2a\3\2\2\2\4j\3\2\2\2\6|\3\2\2\2\b\u0081\3\2\2\2\n\u0086\3"+
		"\2\2\2\f\u0091\3\2\2\2\16\u009e\3\2\2\2\20\u00a9\3\2\2\2\22\u00ae\3\2"+
		"\2\2\24\u00ba\3\2\2\2\26\u00c8\3\2\2\2\30\u00d3\3\2\2\2\32\u00da\3\2\2"+
		"\2\34\u00de\3\2\2\2\36\u00e2\3\2\2\2 \u00ea\3\2\2\2\"\u00ee\3\2\2\2$\u00f9"+
		"\3\2\2\2&\u0102\3\2\2\2(\u0104\3\2\2\2*\u0110\3\2\2\2,\u0114\3\2\2\2."+
		"\u0119\3\2\2\2\60\u011d\3\2\2\2\62\u0129\3\2\2\2\64\u0130\3\2\2\2\66\u0151"+
		"\3\2\2\28\u015f\3\2\2\2:\u0163\3\2\2\2<\u0167\3\2\2\2>\u017a\3\2\2\2@"+
		"\u017c\3\2\2\2B\u0187\3\2\2\2D\u019a\3\2\2\2F\u019c\3\2\2\2H\u01a2\3\2"+
		"\2\2J\u01f6\3\2\2\2L\u0209\3\2\2\2N\u020b\3\2\2\2P\u0239\3\2\2\2R\u026c"+
		"\3\2\2\2T\u026e\3\2\2\2V\u0270\3\2\2\2X\u0272\3\2\2\2Z\u0274\3\2\2\2\\"+
		"\u0276\3\2\2\2^`\5\4\3\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2"+
		"\2\2ca\3\2\2\2de\7\2\2\3e\3\3\2\2\2fk\5\20\t\2gk\5\64\33\2hk\5\60\31\2"+
		"ik\5\22\n\2jf\3\2\2\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2k\5\3\2\2\2lm\7N\2"+
		"\2mn\7\3\2\2no\7N\2\2op\7\4\2\2pq\5R*\2qr\7\5\2\2rs\7\6\2\2s}\3\2\2\2"+
		"tu\7N\2\2uv\7\7\2\2vw\7N\2\2wx\7\4\2\2xy\5R*\2yz\7\5\2\2z{\7\6\2\2{}\3"+
		"\2\2\2|l\3\2\2\2|t\3\2\2\2}\7\3\2\2\2~\u0080\5\6\4\2\177~\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0084\u0085\5\n\6\2\u0085\t\3\2\2\2\u0086\u0087"+
		"\7\b\2\2\u0087\u008c\7N\2\2\u0088\u0089\t\2\2\2\u0089\u008b\7N\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\6\2\2\u0090"+
		"\13\3\2\2\2\u0091\u009a\7\4\2\2\u0092\u0097\5\16\b\2\u0093\u0094\7\t\2"+
		"\2\u0094\u0096\5\16\b\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u009a\u0092\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\7\5\2\2\u009d\r\3\2\2\2\u009e\u00a0\5> \2\u009f\u00a1\7\13\2\2"+
		"\u00a0\u009f\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a6"+
		"\7N\2\2\u00a3\u00a5\5<\37\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\17\3\2\2\2\u00a8\u00a6\3\2\2"+
		"\2\u00a9\u00aa\5> \2\u00aa\u00ab\7N\2\2\u00ab\u00ac\5\f\7\2\u00ac\u00ad"+
		"\5H%\2\u00ad\21\3\2\2\2\u00ae\u00af\7\f\2\2\u00af\u00b0\7N\2\2\u00b0\u00b1"+
		"\5\f\7\2\u00b1\u00b2\7\r\2\2\u00b2\u00b3\5\24\13\2\u00b3\u00b4\7\16\2"+
		"\2\u00b4\23\3\2\2\2\u00b5\u00b9\5\20\t\2\u00b6\u00b9\5\64\33\2\u00b7\u00b9"+
		"\5\60\31\2\u00b8\u00b5\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2"+
		"\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00bf\5\26\f\2\u00be\u00c0\5\32\16"+
		"\2\u00bf\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00c3"+
		"\5\34\17\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2"+
		"\u00c4\u00c6\5 \21\2\u00c5\u00c7\5\"\22\2\u00c6\u00c5\3\2\2\2\u00c6\u00c7"+
		"\3\2\2\2\u00c7\25\3\2\2\2\u00c8\u00c9\7\17\2\2\u00c9\u00ce\5\30\r\2\u00ca"+
		"\u00cb\7\t\2\2\u00cb\u00cd\5\30\r\2\u00cc\u00ca\3\2\2\2\u00cd\u00d0\3"+
		"\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d2\7\6\2\2\u00d2\27\3\2\2\2\u00d3\u00d8\7N\2\2"+
		"\u00d4\u00d5\7\r\2\2\u00d5\u00d6\5P)\2\u00d6\u00d7\7\16\2\2\u00d7\u00d9"+
		"\3\2\2\2\u00d8\u00d4\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\31\3\2\2\2\u00da"+
		"\u00db\7\20\2\2\u00db\u00dc\5\36\20\2\u00dc\u00dd\7\6\2\2\u00dd\33\3\2"+
		"\2\2\u00de\u00df\7\21\2\2\u00df\u00e0\5\36\20\2\u00e0\u00e1\7\6\2\2\u00e1"+
		"\35\3\2\2\2\u00e2\u00e7\7N\2\2\u00e3\u00e4\7\t\2\2\u00e4\u00e6\7N\2\2"+
		"\u00e5\u00e3\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\37\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00eb\7\22\2\2\u00eb"+
		"\u00ec\7N\2\2\u00ec\u00ed\7\6\2\2\u00ed!\3\2\2\2\u00ee\u00ef\7\23\2\2"+
		"\u00ef\u00f4\5$\23\2\u00f0\u00f1\7\t\2\2\u00f1\u00f3\5&\24\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\7\6\2\2\u00f8#\3\2\2\2"+
		"\u00f9\u00fa\7N\2\2\u00fa\u00fb\7\24\2\2\u00fb\u00fc\7N\2\2\u00fc\u00fd"+
		"\5(\25\2\u00fd%\3\2\2\2\u00fe\u0103\5$\23\2\u00ff\u0100\7\24\2\2\u0100"+
		"\u0101\7N\2\2\u0101\u0103\5(\25\2\u0102\u00fe\3\2\2\2\u0102\u00ff\3\2"+
		"\2\2\u0103\'\3\2\2\2\u0104\u0106\7\r\2\2\u0105\u0107\5*\26\2\u0106\u0105"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u010a\5,\27\2\u0109"+
		"\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u010d\5."+
		"\30\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u010f\7\16\2\2\u010f)\3\2\2\2\u0110\u0111\7\25\2\2\u0111\u0112\5P)\2"+
		"\u0112\u0113\7\6\2\2\u0113+\3\2\2\2\u0114\u0115\7\26\2\2\u0115\u0116\5"+
		"P)\2\u0116\u0117\t\3\2\2\u0117\u0118\7\6\2\2\u0118-\3\2\2\2\u0119\u011a"+
		"\7\31\2\2\u011a\u011b\5N(\2\u011b\u011c\7\6\2\2\u011c/\3\2\2\2\u011d\u011e"+
		"\7\32\2\2\u011e\u011f\5> \2\u011f\u0124\5\62\32\2\u0120\u0121\7\t\2\2"+
		"\u0121\u0123\5\62\32\2\u0122\u0120\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126\u0124\3\2\2\2\u0127"+
		"\u0128\7\6\2\2\u0128\61\3\2\2\2\u0129\u012d\7N\2\2\u012a\u012c\5<\37\2"+
		"\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e"+
		"\3\2\2\2\u012e\63\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\5> \2\u0131"+
		"\u0136\5\66\34\2\u0132\u0133\7\t\2\2\u0133\u0135\5\66\34\2\u0134\u0132"+
		"\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\7\6\2\2\u013a\65\3\2\2"+
		"\2\u013b\u013f\7N\2\2\u013c\u013e\5<\37\2\u013d\u013c\3\2\2\2\u013e\u0141"+
		"\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0144\3\2\2\2\u0141"+
		"\u013f\3\2\2\2\u0142\u0143\7\3\2\2\u0143\u0145\58\35\2\u0144\u0142\3\2"+
		"\2\2\u0144\u0145\3\2\2\2\u0145\u0152\3\2\2\2\u0146\u014a\7N\2\2\u0147"+
		"\u0149\5<\37\2\u0148\u0147\3\2\2\2\u0149\u014c\3\2\2\2\u014a\u0148\3\2"+
		"\2\2\u014a\u014b\3\2\2\2\u014b\u014f\3\2\2\2\u014c\u014a\3\2\2\2\u014d"+
		"\u014e\7\7\2\2\u014e\u0150\58\35\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2"+
		"\2\2\u0150\u0152\3\2\2\2\u0151\u013b\3\2\2\2\u0151\u0146\3\2\2\2\u0152"+
		"\67\3\2\2\2\u0153\u0160\5P)\2\u0154\u0155\7\r\2\2\u0155\u015a\5:\36\2"+
		"\u0156\u0157\7\t\2\2\u0157\u0159\5:\36\2\u0158\u0156\3\2\2\2\u0159\u015c"+
		"\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015d\u015e\7\16\2\2\u015e\u0160\3\2\2\2\u015f\u0153\3"+
		"\2\2\2\u015f\u0154\3\2\2\2\u01609\3\2\2\2\u0161\u0162\7N\2\2\u0162\u0164"+
		"\7\33\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0165\3\2\2\2"+
		"\u0165\u0166\58\35\2\u0166;\3\2\2\2\u0167\u0168\7\34\2\2\u0168\u0169\5"+
		"P)\2\u0169\u016a\7\35\2\2\u016a=\3\2\2\2\u016b\u016c\5D#\2\u016c\u016e"+
		"\7N\2\2\u016d\u016f\5F$\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2\2\2\u016f"+
		"\u017b\3\2\2\2\u0170\u0171\5D#\2\u0171\u0172\7\36\2\2\u0172\u0174\7\r"+
		"\2\2\u0173\u0175\5@!\2\u0174\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0174"+
		"\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\7\16\2\2"+
		"\u0179\u017b\3\2\2\2\u017a\u016b\3\2\2\2\u017a\u0170\3\2\2\2\u017b?\3"+
		"\2\2\2\u017c\u017d\5> \2\u017d\u0182\5B\"\2\u017e\u017f\7\t\2\2\u017f"+
		"\u0181\5B\"\2\u0180\u017e\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2"+
		"\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185"+
		"\u0186\7\6\2\2\u0186A\3\2\2\2\u0187\u018b\7N\2\2\u0188\u018a\5<\37\2\u0189"+
		"\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018cC\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0190\7\21\2\2\u018f\u018e"+
		"\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\3\2\2\2\u0191\u0193\7\37\2\2"+
		"\u0192\u0191\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u019b\3\2\2\2\u0194\u0196"+
		"\7 \2\2\u0195\u0194\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u019b\3\2\2\2\u0197"+
		"\u0199\7!\2\2\u0198\u0197\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019b\3\2"+
		"\2\2\u019a\u018f\3\2\2\2\u019a\u0195\3\2\2\2\u019a\u0198\3\2\2\2\u019b"+
		"E\3\2\2\2\u019c\u019d\7\34\2\2\u019d\u019e\5P)\2\u019e\u019f\7\t\2\2\u019f"+
		"\u01a0\5P)\2\u01a0\u01a1\7\35\2\2\u01a1G\3\2\2\2\u01a2\u01a7\7\r\2\2\u01a3"+
		"\u01a6\5\64\33\2\u01a4\u01a6\5\60\31\2\u01a5\u01a3\3\2\2\2\u01a5\u01a4"+
		"\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8"+
		"\u01ad\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ac\5J&\2\u01ab\u01aa\3\2\2"+
		"\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0"+
		"\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\7\16\2\2\u01b1I\3\2\2\2\u01b2"+
		"\u01f7\5H%\2\u01b3\u01f7\7\6\2\2\u01b4\u01b5\5P)\2\u01b5\u01b6\7\6\2\2"+
		"\u01b6\u01f7\3\2\2\2\u01b7\u01b8\7\"\2\2\u01b8\u01b9\7\4\2\2\u01b9\u01ba"+
		"\5N(\2\u01ba\u01bb\7\6\2\2\u01bb\u01bc\5N(\2\u01bc\u01bd\7\6\2\2\u01bd"+
		"\u01be\5N(\2\u01be\u01bf\7\5\2\2\u01bf\u01c0\5J&\2\u01c0\u01f7\3\2\2\2"+
		"\u01c1\u01c2\7\"\2\2\u01c2\u01c3\7\4\2\2\u01c3\u01c4\7N\2\2\u01c4\u01c5"+
		"\7\33\2\2\u01c5\u01c6\5> \2\u01c6\u01c7\7\5\2\2\u01c7\u01c8\5J&\2\u01c8"+
		"\u01f7\3\2\2\2\u01c9\u01ca\7#\2\2\u01ca\u01cb\7\4\2\2\u01cb\u01cc\5N("+
		"\2\u01cc\u01cd\7\5\2\2\u01cd\u01ce\5J&\2\u01ce\u01f7\3\2\2\2\u01cf\u01d0"+
		"\7$\2\2\u01d0\u01d1\5J&\2\u01d1\u01d2\7#\2\2\u01d2\u01d3\7\4\2\2\u01d3"+
		"\u01d4\5N(\2\u01d4\u01d5\7\5\2\2\u01d5\u01d6\7\6\2\2\u01d6\u01f7\3\2\2"+
		"\2\u01d7\u01d8\7%\2\2\u01d8\u01d9\7\4\2\2\u01d9\u01da\5N(\2\u01da\u01db"+
		"\7\5\2\2\u01db\u01de\5J&\2\u01dc\u01dd\7&\2\2\u01dd\u01df\5J&\2\u01de"+
		"\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01f7\3\2\2\2\u01e0\u01e1\7\'"+
		"\2\2\u01e1\u01f7\7\6\2\2\u01e2\u01e3\7(\2\2\u01e3\u01f7\7\6\2\2\u01e4"+
		"\u01e5\7)\2\2\u01e5\u01e6\7\4\2\2\u01e6\u01e7\5N(\2\u01e7\u01e8\7\5\2"+
		"\2\u01e8\u01ea\7\r\2\2\u01e9\u01eb\5L\'\2\u01ea\u01e9\3\2\2\2\u01eb\u01ec"+
		"\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee"+
		"\u01ef\7\16\2\2\u01ef\u01f7\3\2\2\2\u01f0\u01f1\7*\2\2\u01f1\u01f7\7\6"+
		"\2\2\u01f2\u01f3\7*\2\2\u01f3\u01f4\5P)\2\u01f4\u01f5\7\6\2\2\u01f5\u01f7"+
		"\3\2\2\2\u01f6\u01b2\3\2\2\2\u01f6\u01b3\3\2\2\2\u01f6\u01b4\3\2\2\2\u01f6"+
		"\u01b7\3\2\2\2\u01f6\u01c1\3\2\2\2\u01f6\u01c9\3\2\2\2\u01f6\u01cf\3\2"+
		"\2\2\u01f6\u01d7\3\2\2\2\u01f6\u01e0\3\2\2\2\u01f6\u01e2\3\2\2\2\u01f6"+
		"\u01e4\3\2\2\2\u01f6\u01f0\3\2\2\2\u01f6\u01f2\3\2\2\2\u01f7K\3\2\2\2"+
		"\u01f8\u01f9\7+\2\2\u01f9\u01fa\5P)\2\u01fa\u01fe\7\33\2\2\u01fb\u01fd"+
		"\5J&\2\u01fc\u01fb\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe"+
		"\u01ff\3\2\2\2\u01ff\u020a\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u0202\7,"+
		"\2\2\u0202\u0206\7\33\2\2\u0203\u0205\5J&\2\u0204\u0203\3\2\2\2\u0205"+
		"\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207\u020a\3\2"+
		"\2\2\u0208\u0206\3\2\2\2\u0209\u01f8\3\2\2\2\u0209\u0201\3\2\2\2\u020a"+
		"M\3\2\2\2\u020b\u0210\5P)\2\u020c\u020d\7\t\2\2\u020d\u020f\5P)\2\u020e"+
		"\u020c\3\2\2\2\u020f\u0212\3\2\2\2\u0210\u020e\3\2\2\2\u0210\u0211\3\2"+
		"\2\2\u0211O\3\2\2\2\u0212\u0210\3\2\2\2\u0213\u0214\b)\1\2\u0214\u023a"+
		"\7N\2\2\u0215\u023a\7O\2\2\u0216\u023a\7P\2\2\u0217\u023a\7-\2\2\u0218"+
		"\u023a\7.\2\2\u0219\u021a\7N\2\2\u021a\u021b\7\4\2\2\u021b\u021c\5R*\2"+
		"\u021c\u021d\7\5\2\2\u021d\u023a\3\2\2\2\u021e\u021f\7\4\2\2\u021f\u0220"+
		"\5P)\2\u0220\u0221\7\5\2\2\u0221\u023a\3\2\2\2\u0222\u0223\7/\2\2\u0223"+
		"\u023a\5P)\17\u0224\u0225\7\60\2\2\u0225\u023a\5P)\r\u0226\u0227\5V,\2"+
		"\u0227\u0228\5P)\13\u0228\u023a\3\2\2\2\u0229\u022a\7\63\2\2\u022a\u022b"+
		"\7\4\2\2\u022b\u022c\7N\2\2\u022c\u022d\7\33\2\2\u022d\u022e\5> \2\u022e"+
		"\u022f\7\5\2\2\u022f\u0230\5P)\4\u0230\u023a\3\2\2\2\u0231\u0232\7\64"+
		"\2\2\u0232\u0233\7\4\2\2\u0233\u0234\7N\2\2\u0234\u0235\7\33\2\2\u0235"+
		"\u0236\5> \2\u0236\u0237\7\5\2\2\u0237\u0238\5P)\3\u0238\u023a\3\2\2\2"+
		"\u0239\u0213\3\2\2\2\u0239\u0215\3\2\2\2\u0239\u0216\3\2\2\2\u0239\u0217"+
		"\3\2\2\2\u0239\u0218\3\2\2\2\u0239\u0219\3\2\2\2\u0239\u021e\3\2\2\2\u0239"+
		"\u0222\3\2\2\2\u0239\u0224\3\2\2\2\u0239\u0226\3\2\2\2\u0239\u0229\3\2"+
		"\2\2\u0239\u0231\3\2\2\2\u023a\u0261\3\2\2\2\u023b\u023c\f\f\2\2\u023c"+
		"\u023d\5T+\2\u023d\u023e\5P)\r\u023e\u0260\3\2\2\2\u023f\u0240\f\n\2\2"+
		"\u0240\u0241\5X-\2\u0241\u0242\5P)\13\u0242\u0260\3\2\2\2\u0243\u0244"+
		"\f\t\2\2\u0244\u0245\5Z.\2\u0245\u0246\5P)\n\u0246\u0260\3\2\2\2\u0247"+
		"\u0248\f\b\2\2\u0248\u0249\5\\/\2\u0249\u024a\5P)\t\u024a\u0260\3\2\2"+
		"\2\u024b\u024c\f\7\2\2\u024c\u024d\7\30\2\2\u024d\u024e\5P)\2\u024e\u024f"+
		"\7\33\2\2\u024f\u0250\5P)\b\u0250\u0260\3\2\2\2\u0251\u0252\f\22\2\2\u0252"+
		"\u0253\7\34\2\2\u0253\u0254\5P)\2\u0254\u0255\7\35\2\2\u0255\u0260\3\2"+
		"\2\2\u0256\u0257\f\20\2\2\u0257\u0260\7/\2\2\u0258\u0259\f\16\2\2\u0259"+
		"\u0260\7\60\2\2\u025a\u025b\f\6\2\2\u025b\u025c\7\61\2\2\u025c\u0260\7"+
		"N\2\2\u025d\u025e\f\5\2\2\u025e\u0260\7\62\2\2\u025f\u023b\3\2\2\2\u025f"+
		"\u023f\3\2\2\2\u025f\u0243\3\2\2\2\u025f\u0247\3\2\2\2\u025f\u024b\3\2"+
		"\2\2\u025f\u0251\3\2\2\2\u025f\u0256\3\2\2\2\u025f\u0258\3\2\2\2\u025f"+
		"\u025a\3\2\2\2\u025f\u025d\3\2\2\2\u0260\u0263\3\2\2\2\u0261\u025f\3\2"+
		"\2\2\u0261\u0262\3\2\2\2\u0262Q\3\2\2\2\u0263\u0261\3\2\2\2\u0264\u0269"+
		"\5P)\2\u0265\u0266\7\t\2\2\u0266\u0268\5P)\2\u0267\u0265\3\2\2\2\u0268"+
		"\u026b\3\2\2\2\u0269\u0267\3\2\2\2\u0269\u026a\3\2\2\2\u026a\u026d\3\2"+
		"\2\2\u026b\u0269\3\2\2\2\u026c\u0264\3\2\2\2\u026c\u026d\3\2\2\2\u026d"+
		"S\3\2\2\2\u026e\u026f\t\4\2\2\u026fU\3\2\2\2\u0270\u0271\t\5\2\2\u0271"+
		"W\3\2\2\2\u0272\u0273\t\6\2\2\u0273Y\3\2\2\2\u0274\u0275\t\7\2\2\u0275"+
		"[\3\2\2\2\u0276\u0277\t\b\2\2\u0277]\3\2\2\2<aj|\u0081\u008c\u0097\u009a"+
		"\u00a0\u00a6\u00b8\u00ba\u00bf\u00c2\u00c6\u00ce\u00d8\u00e7\u00f4\u0102"+
		"\u0106\u0109\u010c\u0124\u012d\u0136\u013f\u0144\u014a\u014f\u0151\u015a"+
		"\u015f\u0163\u016e\u0176\u017a\u0182\u018b\u018f\u0192\u0195\u0198\u019a"+
		"\u01a5\u01a7\u01ad\u01de\u01ec\u01f6\u01fe\u0206\u0209\u0210\u0239\u025f"+
		"\u0261\u0269\u026c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}