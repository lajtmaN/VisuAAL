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
		T__17=18, BOOL=19, NEG=20, ID=21, NAT=22, FLOAT=23, WS=24;
	public static final int
		RULE_query = 0, RULE_gradient = 1, RULE_oneGradient = 2, RULE_expression = 3, 
		RULE_parExpr = 4, RULE_unaryOp = 5, RULE_rel = 6, RULE_binIntOp = 7, RULE_binBoolOp = 8;
	public static final String[] ruleNames = {
		"query", "gradient", "oneGradient", "expression", "parExpr", "unaryOp", 
		"rel", "binIntOp", "binBoolOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "','", "']'", "':'", "'('", "')'", "'!'", "'<'", "'<='", 
		"'=='", "'!='", "'>='", "'>'", "'+'", "'*'", "'/'", "'&&'", "'||'", null, 
		"'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "BOOL", "NEG", "ID", "NAT", 
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(vqParser.EOF, 0); }
		public GradientContext gradient() {
			return getRuleContext(GradientContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(18);
				gradient();
				}
			}

			setState(21);
			expression(0);
			setState(22);
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
			setState(24);
			match(T__0);
			setState(25);
			oneGradient();
			setState(26);
			match(T__1);
			setState(27);
			oneGradient();
			setState(28);
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
		public TerminalNode NAT() { return getToken(vqParser.NAT, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(ID);
			setState(31);
			match(T__3);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(32);
				match(NEG);
				}
			}

			setState(35);
			match(NAT);
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
		public TerminalNode ID() { return getToken(vqParser.ID, 0); }
		public TerminalNode NAT() { return getToken(vqParser.NAT, 0); }
		public TerminalNode FLOAT() { return getToken(vqParser.FLOAT, 0); }
		public TerminalNode BOOL() { return getToken(vqParser.BOOL, 0); }
		public ParExprContext parExpr() {
			return getRuleContext(ParExprContext.class,0);
		}
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public RelContext rel() {
			return getRuleContext(RelContext.class,0);
		}
		public BinBoolOpContext binBoolOp() {
			return getRuleContext(BinBoolOpContext.class,0);
		}
		public BinIntOpContext binIntOp() {
			return getRuleContext(BinIntOpContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitExpression(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(38);
				match(ID);
				}
				break;
			case NAT:
				{
				setState(39);
				match(NAT);
				}
				break;
			case FLOAT:
				{
				setState(40);
				match(FLOAT);
				}
				break;
			case BOOL:
				{
				setState(41);
				match(BOOL);
				}
				break;
			case T__4:
				{
				setState(42);
				parExpr();
				}
				break;
			case T__6:
			case NEG:
				{
				setState(43);
				unaryOp();
				setState(44);
				expression(4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(60);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(48);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(49);
						rel();
						setState(50);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(52);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(53);
						binBoolOp();
						setState(54);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(56);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(57);
						binIntOp();
						setState(58);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ParExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitParExpr(this);
		}
	}

	public final ParExprContext parExpr() throws RecognitionException {
		ParExprContext _localctx = new ParExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__4);
			setState(66);
			expression(0);
			setState(67);
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

	public static class UnaryOpContext extends ParserRuleContext {
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitUnaryOp(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==NEG) ) {
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
			if ( listener instanceof vqListener ) ((vqListener)listener).enterRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitRel(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
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
			if ( listener instanceof vqListener ) ((vqListener)listener).enterBinIntOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitBinIntOp(this);
		}
	}

	public final BinIntOpContext binIntOp() throws RecognitionException {
		BinIntOpContext _localctx = new BinIntOpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_binIntOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NEG))) != 0)) ) {
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
			if ( listener instanceof vqListener ) ((vqListener)listener).enterBinBoolOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof vqListener ) ((vqListener)listener).exitBinBoolOp(this);
		}
	}

	public final BinBoolOpContext binBoolOp() throws RecognitionException {
		BinBoolOpContext _localctx = new BinBoolOpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binBoolOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__17) ) {
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
		case 3:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32P\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\5\2\26"+
		"\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4$\n\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\61\n\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\2\3\b\13\2\4\6\b\n\f\16\20\22\2\6\4\2"+
		"\t\t\26\26\3\2\n\17\4\2\20\22\26\26\3\2\23\24P\2\25\3\2\2\2\4\32\3\2\2"+
		"\2\6 \3\2\2\2\b\60\3\2\2\2\nC\3\2\2\2\fG\3\2\2\2\16I\3\2\2\2\20K\3\2\2"+
		"\2\22M\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\25\26\3\2\2\2\26\27\3\2\2\2"+
		"\27\30\5\b\5\2\30\31\7\2\2\3\31\3\3\2\2\2\32\33\7\3\2\2\33\34\5\6\4\2"+
		"\34\35\7\4\2\2\35\36\5\6\4\2\36\37\7\5\2\2\37\5\3\2\2\2 !\7\27\2\2!#\7"+
		"\6\2\2\"$\7\26\2\2#\"\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\30\2\2&\7\3\2\2"+
		"\2\'(\b\5\1\2(\61\7\27\2\2)\61\7\30\2\2*\61\7\31\2\2+\61\7\25\2\2,\61"+
		"\5\n\6\2-.\5\f\7\2./\5\b\5\6/\61\3\2\2\2\60\'\3\2\2\2\60)\3\2\2\2\60*"+
		"\3\2\2\2\60+\3\2\2\2\60,\3\2\2\2\60-\3\2\2\2\61@\3\2\2\2\62\63\f\5\2\2"+
		"\63\64\5\16\b\2\64\65\5\b\5\6\65?\3\2\2\2\66\67\f\4\2\2\678\5\22\n\28"+
		"9\5\b\5\59?\3\2\2\2:;\f\3\2\2;<\5\20\t\2<=\5\b\5\4=?\3\2\2\2>\62\3\2\2"+
		"\2>\66\3\2\2\2>:\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\t\3\2\2\2B@\3"+
		"\2\2\2CD\7\7\2\2DE\5\b\5\2EF\7\b\2\2F\13\3\2\2\2GH\t\2\2\2H\r\3\2\2\2"+
		"IJ\t\3\2\2J\17\3\2\2\2KL\t\4\2\2L\21\3\2\2\2MN\t\5\2\2N\23\3\2\2\2\7\25"+
		"#\60>@";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}