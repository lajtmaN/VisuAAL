// Generated from vq.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class vqParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, BOOL=23, NEG=24, ID=25, 
		FLOAT=26, WS=27;
	public static final int
		RULE_query = 0, RULE_gradient = 1, RULE_oneGradient = 2, RULE_minVar = 3, 
		RULE_maxVar = 4, RULE_colors = 5, RULE_color = 6, RULE_exp = 7;
	public static final String[] ruleNames = {
		"query", "gradient", "oneGradient", "minVar", "maxVar", "colors", "color", 
		"exp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "':'", "'min'", "'('", "')'", "'max'", "'*'", 
		"'!'", "'/'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", 
		"'||'", "'?'", "'.'", null, "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "BOOL", 
		"NEG", "ID", "FLOAT", "WS"
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
	public String getGrammarFileName() { return "vq.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public vqParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode EOF() { return getToken(vqParser.EOF, 0); }
		public GradientContext gradient() {
			return getRuleContext(GradientContext.class,0);
		}
		public ColorsContext colors() {
			return getRuleContext(ColorsContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(16);
				gradient();
				}
				break;
			case 2:
				{
				setState(17);
				colors();
				}
				break;
			}
			setState(20);
			exp(0);
			setState(21);
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

	public static class GradientContext extends ParserRuleContext {
		public List<OneGradientContext> oneGradient() {
			return getRuleContexts(OneGradientContext.class);
		}
		public OneGradientContext oneGradient(int i) {
			return getRuleContext(OneGradientContext.class,i);
		}
		public GradientContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gradient; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterGradient(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitGradient(this);
		}
	}

	public final GradientContext gradient() throws RecognitionException {
		GradientContext _localctx = new GradientContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_gradient);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			match(T__0);
			setState(24);
			oneGradient();
			setState(25);
			match(T__1);
			setState(26);
			oneGradient();
			setState(27);
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

	public static class OneGradientContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(vqParser.ID, 0); }
		public TerminalNode FLOAT() { return getToken(vqParser.FLOAT, 0); }
		public TerminalNode NEG() { return getToken(vqParser.NEG, 0); }
		public MinVarContext minVar() {
			return getRuleContext(MinVarContext.class,0);
		}
		public MaxVarContext maxVar() {
			return getRuleContext(MaxVarContext.class,0);
		}
		public OneGradientContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneGradient; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterOneGradient(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitOneGradient(this);
		}
	}

	public final OneGradientContext oneGradient() throws RecognitionException {
		OneGradientContext _localctx = new OneGradientContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_oneGradient);
		int _la;
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(ID);
				setState(30);
				match(T__3);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEG) {
					{
					setState(31);
					match(NEG);
					}
				}

				setState(34);
				match(FLOAT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				match(ID);
				setState(36);
				match(T__3);
				setState(37);
				minVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				match(ID);
				setState(39);
				match(T__3);
				setState(40);
				maxVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				match(ID);
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

	public static class MinVarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(vqParser.ID, 0); }
		public MinVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterMinVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitMinVar(this);
		}
	}

	public final MinVarContext minVar() throws RecognitionException {
		MinVarContext _localctx = new MinVarContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_minVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__4);
			setState(45);
			match(T__5);
			setState(46);
			match(ID);
			setState(47);
			match(T__6);
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

	public static class MaxVarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(vqParser.ID, 0); }
		public MaxVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterMaxVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitMaxVar(this);
		}
	}

	public final MaxVarContext maxVar() throws RecognitionException {
		MaxVarContext _localctx = new MaxVarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_maxVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__7);
			setState(50);
			match(T__5);
			setState(51);
			match(ID);
			setState(52);
			match(T__6);
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

	public static class ColorsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(vqParser.ID, 0); }
		public List<ColorContext> color() {
			return getRuleContexts(ColorContext.class);
		}
		public ColorContext color(int i) {
			return getRuleContext(ColorContext.class,i);
		}
		public ColorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterColors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitColors(this);
		}
	}

	public final ColorsContext colors() throws RecognitionException {
		ColorsContext _localctx = new ColorsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_colors);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__0);
			setState(56); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(55);
					color();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(58); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(60);
			match(ID);
			setState(61);
			match(T__3);
			setState(62);
			match(T__8);
			setState(63);
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

	public static class ColorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(vqParser.ID, 0); }
		public TerminalNode FLOAT() { return getToken(vqParser.FLOAT, 0); }
		public TerminalNode NEG() { return getToken(vqParser.NEG, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitColor(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_color);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(ID);
			setState(66);
			match(T__3);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(67);
				match(NEG);
				}
			}

			setState(70);
			match(FLOAT);
			setState(71);
			match(T__1);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitPar(this);
		}
	}
	public static class BoolContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(vqParser.BOOL, 0); }
		public BoolContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitBool(this);
		}
	}
	public static class IdDotContext extends ExpContext {
		public List<TerminalNode> ID() { return getTokens(vqParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(vqParser.ID, i);
		}
		public IdDotContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterIdDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitIdDot(this);
		}
	}
	public static class IdContext extends ExpContext {
		public TerminalNode ID() { return getToken(vqParser.ID, 0); }
		public IdContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitId(this);
		}
	}
	public static class UnOpContext extends ExpContext {
		public Token op;
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public UnOpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterUnOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitUnOp(this);
		}
	}
	public static class FloatContext extends ExpContext {
		public TerminalNode FLOAT() { return getToken(vqParser.FLOAT, 0); }
		public FloatContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitFloat(this);
		}
	}
	public static class CondOpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CondOpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterCondOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitCondOp(this);
		}
	}
	public static class BinOpContext extends ExpContext {
		public Token op;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinOpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterBinOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitBinOp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(74);
				match(T__5);
				setState(75);
				exp(0);
				setState(76);
				match(T__6);
				}
				break;
			case 2:
				{
				_localctx = new UnOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				((UnOpContext)_localctx).op = match(NEG);
				setState(79);
				exp(13);
				}
				break;
			case 3:
				{
				_localctx = new UnOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				((UnOpContext)_localctx).op = match(T__9);
				setState(81);
				exp(12);
				}
				break;
			case 4:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new IdDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(ID);
				setState(84);
				match(T__21);
				setState(85);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(FLOAT);
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(BOOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(116);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(114);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(90);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(91);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__10) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(92);
						exp(12);
						}
						break;
					case 2:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(93);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(94);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==NEG) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(95);
						exp(11);
						}
						break;
					case 3:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(96);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(97);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(98);
						exp(10);
						}
						break;
					case 4:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(99);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(100);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(101);
						exp(9);
						}
						break;
					case 5:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(102);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(103);
						((BinOpContext)_localctx).op = match(T__18);
						setState(104);
						exp(8);
						}
						break;
					case 6:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(105);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(106);
						((BinOpContext)_localctx).op = match(T__19);
						setState(107);
						exp(7);
						}
						break;
					case 7:
						{
						_localctx = new CondOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(108);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(109);
						match(T__20);
						setState(110);
						exp(0);
						setState(111);
						match(T__3);
						setState(112);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(118);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35z\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\5\2\25\n\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4#\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\6\7;\n\7\r\7\16\7<\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bG\n\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t[\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tu\n\t\f\t\16\tx\13\t\3\t\2\3\20"+
		"\n\2\4\6\b\n\f\16\20\2\6\4\2\13\13\r\r\4\2\16\16\32\32\3\2\17\22\3\2\23"+
		"\24\u0086\2\24\3\2\2\2\4\31\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n\63\3\2\2\2"+
		"\f8\3\2\2\2\16C\3\2\2\2\20Z\3\2\2\2\22\25\5\4\3\2\23\25\5\f\7\2\24\22"+
		"\3\2\2\2\24\23\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\27\5\20\t\2\27\30"+
		"\7\2\2\3\30\3\3\2\2\2\31\32\7\3\2\2\32\33\5\6\4\2\33\34\7\4\2\2\34\35"+
		"\5\6\4\2\35\36\7\5\2\2\36\5\3\2\2\2\37 \7\33\2\2 \"\7\6\2\2!#\7\32\2\2"+
		"\"!\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$-\7\34\2\2%&\7\33\2\2&\'\7\6\2\2\'-\5"+
		"\b\5\2()\7\33\2\2)*\7\6\2\2*-\5\n\6\2+-\7\33\2\2,\37\3\2\2\2,%\3\2\2\2"+
		",(\3\2\2\2,+\3\2\2\2-\7\3\2\2\2./\7\7\2\2/\60\7\b\2\2\60\61\7\33\2\2\61"+
		"\62\7\t\2\2\62\t\3\2\2\2\63\64\7\n\2\2\64\65\7\b\2\2\65\66\7\33\2\2\66"+
		"\67\7\t\2\2\67\13\3\2\2\28:\7\3\2\29;\5\16\b\2:9\3\2\2\2;<\3\2\2\2<:\3"+
		"\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7\33\2\2?@\7\6\2\2@A\7\13\2\2AB\7\5\2\2B"+
		"\r\3\2\2\2CD\7\33\2\2DF\7\6\2\2EG\7\32\2\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2"+
		"\2HI\7\34\2\2IJ\7\4\2\2J\17\3\2\2\2KL\b\t\1\2LM\7\b\2\2MN\5\20\t\2NO\7"+
		"\t\2\2O[\3\2\2\2PQ\7\32\2\2Q[\5\20\t\17RS\7\f\2\2S[\5\20\t\16T[\7\33\2"+
		"\2UV\7\33\2\2VW\7\30\2\2W[\7\33\2\2X[\7\34\2\2Y[\7\31\2\2ZK\3\2\2\2ZP"+
		"\3\2\2\2ZR\3\2\2\2ZT\3\2\2\2ZU\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[v\3\2\2\2\\"+
		"]\f\r\2\2]^\t\2\2\2^u\5\20\t\16_`\f\f\2\2`a\t\3\2\2au\5\20\t\rbc\f\13"+
		"\2\2cd\t\4\2\2du\5\20\t\fef\f\n\2\2fg\t\5\2\2gu\5\20\t\13hi\f\t\2\2ij"+
		"\7\25\2\2ju\5\20\t\nkl\f\b\2\2lm\7\26\2\2mu\5\20\t\tno\f\7\2\2op\7\27"+
		"\2\2pq\5\20\t\2qr\7\6\2\2rs\5\20\t\7su\3\2\2\2t\\\3\2\2\2t_\3\2\2\2tb"+
		"\3\2\2\2te\3\2\2\2th\3\2\2\2tk\3\2\2\2tn\3\2\2\2ux\3\2\2\2vt\3\2\2\2v"+
		"w\3\2\2\2w\21\3\2\2\2xv\3\2\2\2\n\24\",<FZtv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}