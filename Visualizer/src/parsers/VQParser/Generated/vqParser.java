package parsers.VQParser.Generated;// Generated from vq.g4 by ANTLR 4.6
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
		RULE_query = 0, RULE_gradient = 1, RULE_oneGradient = 2, RULE_min = 3, 
		RULE_max = 4, RULE_colors = 5, RULE_color = 6, RULE_exp = 7;
	public static final String[] ruleNames = {
		"query", "gradient", "oneGradient", "min", "max", "colors", "color", "exp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "':'", "'min'", "'max'", "'*'", "'('", "')'", 
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
		public MinContext min() {
			return getRuleContext(MinContext.class,0);
		}
		public MaxContext max() {
			return getRuleContext(MaxContext.class,0);
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
				min();
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
				max();
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

	public static class MinContext extends ParserRuleContext {
		public MinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_min; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitMin(this);
		}
	}

	public final MinContext min() throws RecognitionException {
		MinContext _localctx = new MinContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_min);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__4);
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

	public static class MaxContext extends ParserRuleContext {
		public MaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitMax(this);
		}
	}

	public final MaxContext max() throws RecognitionException {
		MaxContext _localctx = new MaxContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_max);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__5);
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
			setState(48);
			match(T__0);
			setState(50); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(49);
					color();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(52); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(54);
			match(ID);
			setState(55);
			match(T__3);
			setState(56);
			match(T__6);
			setState(57);
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
			setState(59);
			match(ID);
			setState(60);
			match(T__3);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(61);
				match(NEG);
				}
			}

			setState(64);
			match(FLOAT);
			setState(65);
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
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(68);
				match(T__7);
				setState(69);
				exp(0);
				setState(70);
				match(T__8);
				}
				break;
			case 2:
				{
				_localctx = new UnOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				((UnOpContext)_localctx).op = match(NEG);
				setState(73);
				exp(13);
				}
				break;
			case 3:
				{
				_localctx = new UnOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				((UnOpContext)_localctx).op = match(T__9);
				setState(75);
				exp(12);
				}
				break;
			case 4:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(76);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new IdDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(ID);
				setState(78);
				match(T__21);
				setState(79);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(FLOAT);
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(BOOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(108);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(84);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(85);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__10) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(86);
						exp(12);
						}
						break;
					case 2:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(87);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(88);
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
						setState(89);
						exp(11);
						}
						break;
					case 3:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(90);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(91);
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
						setState(92);
						exp(10);
						}
						break;
					case 4:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(93);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(94);
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
						setState(95);
						exp(9);
						}
						break;
					case 5:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(96);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(97);
						((BinOpContext)_localctx).op = match(T__18);
						setState(98);
						exp(8);
						}
						break;
					case 6:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(99);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(100);
						((BinOpContext)_localctx).op = match(T__19);
						setState(101);
						exp(7);
						}
						break;
					case 7:
						{
						_localctx = new CondOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(102);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(103);
						match(T__20);
						setState(104);
						exp(0);
						setState(105);
						match(T__3);
						setState(106);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(112);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35t\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\5\2\25\n\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4#\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\5\3\5\3\6\3\6\3\7\3\7\6\7\65\n\7\r\7\16"+
		"\7\66\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\bA\n\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tU\n\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\3\t\2\3\20\n\2\4\6\b\n\f\16\20"+
		"\2\6\4\2\t\t\r\r\4\2\16\16\32\32\3\2\17\22\3\2\23\24\u0080\2\24\3\2\2"+
		"\2\4\31\3\2\2\2\6,\3\2\2\2\b.\3\2\2\2\n\60\3\2\2\2\f\62\3\2\2\2\16=\3"+
		"\2\2\2\20T\3\2\2\2\22\25\5\4\3\2\23\25\5\f\7\2\24\22\3\2\2\2\24\23\3\2"+
		"\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26\27\5\20\t\2\27\30\7\2\2\3\30\3\3\2"+
		"\2\2\31\32\7\3\2\2\32\33\5\6\4\2\33\34\7\4\2\2\34\35\5\6\4\2\35\36\7\5"+
		"\2\2\36\5\3\2\2\2\37 \7\33\2\2 \"\7\6\2\2!#\7\32\2\2\"!\3\2\2\2\"#\3\2"+
		"\2\2#$\3\2\2\2$-\7\34\2\2%&\7\33\2\2&\'\7\6\2\2\'-\5\b\5\2()\7\33\2\2"+
		")*\7\6\2\2*-\5\n\6\2+-\7\33\2\2,\37\3\2\2\2,%\3\2\2\2,(\3\2\2\2,+\3\2"+
		"\2\2-\7\3\2\2\2./\7\7\2\2/\t\3\2\2\2\60\61\7\b\2\2\61\13\3\2\2\2\62\64"+
		"\7\3\2\2\63\65\5\16\b\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67"+
		"\3\2\2\2\678\3\2\2\289\7\33\2\29:\7\6\2\2:;\7\t\2\2;<\7\5\2\2<\r\3\2\2"+
		"\2=>\7\33\2\2>@\7\6\2\2?A\7\32\2\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7\34"+
		"\2\2CD\7\4\2\2D\17\3\2\2\2EF\b\t\1\2FG\7\n\2\2GH\5\20\t\2HI\7\13\2\2I"+
		"U\3\2\2\2JK\7\32\2\2KU\5\20\t\17LM\7\f\2\2MU\5\20\t\16NU\7\33\2\2OP\7"+
		"\33\2\2PQ\7\30\2\2QU\7\33\2\2RU\7\34\2\2SU\7\31\2\2TE\3\2\2\2TJ\3\2\2"+
		"\2TL\3\2\2\2TN\3\2\2\2TO\3\2\2\2TR\3\2\2\2TS\3\2\2\2Up\3\2\2\2VW\f\r\2"+
		"\2WX\t\2\2\2Xo\5\20\t\16YZ\f\f\2\2Z[\t\3\2\2[o\5\20\t\r\\]\f\13\2\2]^"+
		"\t\4\2\2^o\5\20\t\f_`\f\n\2\2`a\t\5\2\2ao\5\20\t\13bc\f\t\2\2cd\7\25\2"+
		"\2do\5\20\t\nef\f\b\2\2fg\7\26\2\2go\5\20\t\thi\f\7\2\2ij\7\27\2\2jk\5"+
		"\20\t\2kl\7\6\2\2lm\5\20\t\7mo\3\2\2\2nV\3\2\2\2nY\3\2\2\2n\\\3\2\2\2"+
		"n_\3\2\2\2nb\3\2\2\2ne\3\2\2\2nh\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2"+
		"q\21\3\2\2\2rp\3\2\2\2\n\24\",\66@Tnp";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}