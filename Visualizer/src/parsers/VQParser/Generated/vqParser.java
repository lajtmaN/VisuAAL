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
		T__17=18, T__18=19, T__19=20, BOOL=21, NEG=22, ID=23, FLOAT=24, WS=25;
	public static final int
		RULE_query = 0, RULE_gradient = 1, RULE_oneGradient = 2, RULE_colors = 3, 
		RULE_color = 4, RULE_exp = 5;
	public static final String[] ruleNames = {
		"query", "gradient", "oneGradient", "colors", "color", "exp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "':'", "'*'", "'('", "')'", "'!'", "'/'", "'+'", 
		"'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'", "'?'", "'.'", 
		null, "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "BOOL", "NEG", "ID", 
		"FLOAT", "WS"
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
			setState(14);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(12);
				gradient();
				}
				break;
			case 2:
				{
				setState(13);
				colors();
				}
				break;
			}
			setState(16);
			exp(0);
			setState(17);
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
			setState(19);
			match(T__0);
			setState(20);
			oneGradient();
			setState(21);
			match(T__1);
			setState(22);
			oneGradient();
			setState(23);
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
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(ID);
				setState(26);
				match(T__3);
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEG) {
					{
					setState(27);
					match(NEG);
					}
				}

				setState(30);
				match(FLOAT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
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
		enterRule(_localctx, 6, RULE_colors);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(36); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(35);
					color();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(38); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			setState(40);
			match(ID);
			setState(41);
			match(T__3);
			setState(42);
			match(T__4);
			setState(43);
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
		enterRule(_localctx, 8, RULE_color);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(ID);
			setState(46);
			match(T__3);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(47);
				match(NEG);
				}
			}

			setState(50);
			match(FLOAT);
			setState(51);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new ParContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(54);
				match(T__5);
				setState(55);
				exp(0);
				setState(56);
				match(T__6);
				}
				break;
			case 2:
				{
				_localctx = new UnOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58);
				((UnOpContext)_localctx).op = match(NEG);
				setState(59);
				exp(13);
				}
				break;
			case 3:
				{
				_localctx = new UnOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60);
				((UnOpContext)_localctx).op = match(T__7);
				setState(61);
				exp(12);
				}
				break;
			case 4:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new IdDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				match(ID);
				setState(64);
				match(T__19);
				setState(65);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(66);
				match(FLOAT);
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(BOOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(94);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(70);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(71);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__8) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(72);
						exp(12);
						}
						break;
					case 2:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(73);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(74);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==NEG) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(75);
						exp(11);
						}
						break;
					case 3:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(76);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(77);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(78);
						exp(10);
						}
						break;
					case 4:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(79);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(80);
						((BinOpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__15) ) {
							((BinOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(81);
						exp(9);
						}
						break;
					case 5:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(82);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(83);
						((BinOpContext)_localctx).op = match(T__16);
						setState(84);
						exp(8);
						}
						break;
					case 6:
						{
						_localctx = new BinOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(85);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(86);
						((BinOpContext)_localctx).op = match(T__17);
						setState(87);
						exp(7);
						}
						break;
					case 7:
						{
						_localctx = new CondOpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(88);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(89);
						match(T__18);
						setState(90);
						exp(0);
						setState(91);
						match(T__3);
						setState(92);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(98);
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
		case 5:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33f\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\37\n\4\3\4\3\4\5\4#\n\4\3\5\3\5\6"+
		"\5\'\n\5\r\5\16\5(\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6\63\n\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7G"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7a\n\7\f\7\16\7d\13\7\3\7\2\3\f\b\2\4"+
		"\6\b\n\f\2\6\4\2\7\7\13\13\4\2\f\f\30\30\3\2\r\20\3\2\21\22r\2\20\3\2"+
		"\2\2\4\25\3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n/\3\2\2\2\fF\3\2\2\2\16\21\5"+
		"\4\3\2\17\21\5\b\5\2\20\16\3\2\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\22\3"+
		"\2\2\2\22\23\5\f\7\2\23\24\7\2\2\3\24\3\3\2\2\2\25\26\7\3\2\2\26\27\5"+
		"\6\4\2\27\30\7\4\2\2\30\31\5\6\4\2\31\32\7\5\2\2\32\5\3\2\2\2\33\34\7"+
		"\31\2\2\34\36\7\6\2\2\35\37\7\30\2\2\36\35\3\2\2\2\36\37\3\2\2\2\37 \3"+
		"\2\2\2 #\7\32\2\2!#\7\31\2\2\"\33\3\2\2\2\"!\3\2\2\2#\7\3\2\2\2$&\7\3"+
		"\2\2%\'\5\n\6\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\7"+
		"\31\2\2+,\7\6\2\2,-\7\7\2\2-.\7\5\2\2.\t\3\2\2\2/\60\7\31\2\2\60\62\7"+
		"\6\2\2\61\63\7\30\2\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65"+
		"\7\32\2\2\65\66\7\4\2\2\66\13\3\2\2\2\678\b\7\1\289\7\b\2\29:\5\f\7\2"+
		":;\7\t\2\2;G\3\2\2\2<=\7\30\2\2=G\5\f\7\17>?\7\n\2\2?G\5\f\7\16@G\7\31"+
		"\2\2AB\7\31\2\2BC\7\26\2\2CG\7\31\2\2DG\7\32\2\2EG\7\27\2\2F\67\3\2\2"+
		"\2F<\3\2\2\2F>\3\2\2\2F@\3\2\2\2FA\3\2\2\2FD\3\2\2\2FE\3\2\2\2Gb\3\2\2"+
		"\2HI\f\r\2\2IJ\t\2\2\2Ja\5\f\7\16KL\f\f\2\2LM\t\3\2\2Ma\5\f\7\rNO\f\13"+
		"\2\2OP\t\4\2\2Pa\5\f\7\fQR\f\n\2\2RS\t\5\2\2Sa\5\f\7\13TU\f\t\2\2UV\7"+
		"\23\2\2Va\5\f\7\nWX\f\b\2\2XY\7\24\2\2Ya\5\f\7\tZ[\f\7\2\2[\\\7\25\2\2"+
		"\\]\5\f\7\2]^\7\6\2\2^_\5\f\7\7_a\3\2\2\2`H\3\2\2\2`K\3\2\2\2`N\3\2\2"+
		"\2`Q\3\2\2\2`T\3\2\2\2`W\3\2\2\2`Z\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2"+
		"\2c\r\3\2\2\2db\3\2\2\2\n\20\36\"(\62F`b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}