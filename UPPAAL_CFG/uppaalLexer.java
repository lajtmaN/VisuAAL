// Generated from uppaal.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class uppaalLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
		"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "T__63", "T__64", 
		"T__65", "T__66", "T__67", "T__68", "T__69", "T__70", "T__71", "T__72", 
		"T__73", "T__74", "ID", "NAT", "FLOAT", "WS", "BLOCK_COMMENT", "LINE_COMMENT"
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


	public uppaalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "uppaal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2S\u020b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3"+
		")\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3"+
		"-\3-\3-\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\3:\3:"+
		"\3:\3;\3;\3;\3<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3?\3?\3?\3@\3@\3@\3A\3A\3A"+
		"\3B\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3I\3J\3J\3J\3K\3K"+
		"\3K\3L\3L\3L\3M\3M\7M\u01d5\nM\fM\16M\u01d8\13M\3N\6N\u01db\nN\rN\16N"+
		"\u01dc\3O\6O\u01e0\nO\rO\16O\u01e1\3O\3O\6O\u01e6\nO\rO\16O\u01e7\5O\u01ea"+
		"\nO\3P\6P\u01ed\nP\rP\16P\u01ee\3P\3P\3Q\3Q\3Q\3Q\7Q\u01f7\nQ\fQ\16Q\u01fa"+
		"\13Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\7R\u0205\nR\fR\16R\u0208\13R\3R\3R\3\u01f8"+
		"\2S\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1"+
		"R\u00a3S\3\2\7\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\4"+
		"\2\f\f\17\17\u0212\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\3\u00a5\3\2\2"+
		"\2\5\u00a7\3\2\2\2\7\u00a9\3\2\2\2\t\u00ab\3\2\2\2\13\u00ad\3\2\2\2\r"+
		"\u00b0\3\2\2\2\17\u00b7\3\2\2\2\21\u00b9\3\2\2\2\23\u00bb\3\2\2\2\25\u00bd"+
		"\3\2\2\2\27\u00c5\3\2\2\2\31\u00c7\3\2\2\2\33\u00c9\3\2\2\2\35\u00cf\3"+
		"\2\2\2\37\u00d6\3\2\2\2!\u00dd\3\2\2\2#\u00e2\3\2\2\2%\u00e8\3\2\2\2\'"+
		"\u00ea\3\2\2\2)\u00f0\3\2\2\2+\u00f5\3\2\2\2-\u00f7\3\2\2\2/\u00f9\3\2"+
		"\2\2\61\u0100\3\2\2\2\63\u0108\3\2\2\2\65\u010a\3\2\2\2\67\u010c\3\2\2"+
		"\29\u010e\3\2\2\2;\u0115\3\2\2\2=\u011f\3\2\2\2?\u0125\3\2\2\2A\u012a"+
		"\3\2\2\2C\u012e\3\2\2\2E\u0134\3\2\2\2G\u0137\3\2\2\2I\u013a\3\2\2\2K"+
		"\u013f\3\2\2\2M\u0145\3\2\2\2O\u014e\3\2\2\2Q\u0155\3\2\2\2S\u015c\3\2"+
		"\2\2U\u0161\3\2\2\2W\u0169\3\2\2\2Y\u016e\3\2\2\2[\u0174\3\2\2\2]\u0177"+
		"\3\2\2\2_\u017a\3\2\2\2a\u017c\3\2\2\2c\u017e\3\2\2\2e\u0185\3\2\2\2g"+
		"\u018c\3\2\2\2i\u018f\3\2\2\2k\u0192\3\2\2\2m\u0195\3\2\2\2o\u0198\3\2"+
		"\2\2q\u019b\3\2\2\2s\u019e\3\2\2\2u\u01a1\3\2\2\2w\u01a4\3\2\2\2y\u01a8"+
		"\3\2\2\2{\u01ac\3\2\2\2}\u01ae\3\2\2\2\177\u01b1\3\2\2\2\u0081\u01b4\3"+
		"\2\2\2\u0083\u01b7\3\2\2\2\u0085\u01ba\3\2\2\2\u0087\u01bc\3\2\2\2\u0089"+
		"\u01be\3\2\2\2\u008b\u01c0\3\2\2\2\u008d\u01c2\3\2\2\2\u008f\u01c4\3\2"+
		"\2\2\u0091\u01c6\3\2\2\2\u0093\u01c9\3\2\2\2\u0095\u01cc\3\2\2\2\u0097"+
		"\u01cf\3\2\2\2\u0099\u01d2\3\2\2\2\u009b\u01da\3\2\2\2\u009d\u01df\3\2"+
		"\2\2\u009f\u01ec\3\2\2\2\u00a1\u01f2\3\2\2\2\u00a3\u0200\3\2\2\2\u00a5"+
		"\u00a6\7?\2\2\u00a6\4\3\2\2\2\u00a7\u00a8\7*\2\2\u00a8\6\3\2\2\2\u00a9"+
		"\u00aa\7+\2\2\u00aa\b\3\2\2\2\u00ab\u00ac\7=\2\2\u00ac\n\3\2\2\2\u00ad"+
		"\u00ae\7<\2\2\u00ae\u00af\7?\2\2\u00af\f\3\2\2\2\u00b0\u00b1\7u\2\2\u00b1"+
		"\u00b2\7{\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5\7g\2\2"+
		"\u00b5\u00b6\7o\2\2\u00b6\16\3\2\2\2\u00b7\u00b8\7.\2\2\u00b8\20\3\2\2"+
		"\2\u00b9\u00ba\7>\2\2\u00ba\22\3\2\2\2\u00bb\u00bc\7(\2\2\u00bc\24\3\2"+
		"\2\2\u00bd\u00be\7r\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7q\2\2\u00c0\u00c1"+
		"\7e\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7u\2\2\u00c3\u00c4\7u\2\2\u00c4"+
		"\26\3\2\2\2\u00c5\u00c6\7}\2\2\u00c6\30\3\2\2\2\u00c7\u00c8\7\177\2\2"+
		"\u00c8\32\3\2\2\2\u00c9\u00ca\7u\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7"+
		"c\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7g\2\2\u00ce\34\3\2\2\2\u00cf\u00d0"+
		"\7e\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7o\2\2\u00d2\u00d3\7o\2\2\u00d3"+
		"\u00d4\7k\2\2\u00d4\u00d5\7v\2\2\u00d5\36\3\2\2\2\u00d6\u00d7\7w\2\2\u00d7"+
		"\u00d8\7t\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7p\2\2"+
		"\u00db\u00dc\7v\2\2\u00dc \3\2\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7p\2"+
		"\2\u00df\u00e0\7k\2\2\u00e0\u00e1\7v\2\2\u00e1\"\3\2\2\2\u00e2\u00e3\7"+
		"v\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7c\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7"+
		"\7u\2\2\u00e7$\3\2\2\2\u00e8\u00e9\7/\2\2\u00e9&\3\2\2\2\u00ea\u00eb\7"+
		"i\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7c\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef"+
		"\7f\2\2\u00ef(\3\2\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2\7{\2\2\u00f2\u00f3"+
		"\7p\2\2\u00f3\u00f4\7e\2\2\u00f4*\3\2\2\2\u00f5\u00f6\7#\2\2\u00f6,\3"+
		"\2\2\2\u00f7\u00f8\7A\2\2\u00f8.\3\2\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb"+
		"\7u\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7i\2\2\u00fe"+
		"\u00ff\7p\2\2\u00ff\60\3\2\2\2\u0100\u0101\7v\2\2\u0101\u0102\7{\2\2\u0102"+
		"\u0103\7r\2\2\u0103\u0104\7g\2\2\u0104\u0105\7f\2\2\u0105\u0106\7g\2\2"+
		"\u0106\u0107\7h\2\2\u0107\62\3\2\2\2\u0108\u0109\7<\2\2\u0109\64\3\2\2"+
		"\2\u010a\u010b\7]\2\2\u010b\66\3\2\2\2\u010c\u010d\7_\2\2\u010d8\3\2\2"+
		"\2\u010e\u010f\7u\2\2\u010f\u0110\7v\2\2\u0110\u0111\7t\2\2\u0111\u0112"+
		"\7w\2\2\u0112\u0113\7e\2\2\u0113\u0114\7v\2\2\u0114:\3\2\2\2\u0115\u0116"+
		"\7d\2\2\u0116\u0117\7t\2\2\u0117\u0118\7q\2\2\u0118\u0119\7c\2\2\u0119"+
		"\u011a\7f\2\2\u011a\u011b\7e\2\2\u011b\u011c\7c\2\2\u011c\u011d\7u\2\2"+
		"\u011d\u011e\7v\2\2\u011e<\3\2\2\2\u011f\u0120\7e\2\2\u0120\u0121\7q\2"+
		"\2\u0121\u0122\7p\2\2\u0122\u0123\7u\2\2\u0123\u0124\7v\2\2\u0124>\3\2"+
		"\2\2\u0125\u0126\7o\2\2\u0126\u0127\7g\2\2\u0127\u0128\7v\2\2\u0128\u0129"+
		"\7c\2\2\u0129@\3\2\2\2\u012a\u012b\7h\2\2\u012b\u012c\7q\2\2\u012c\u012d"+
		"\7t\2\2\u012dB\3\2\2\2\u012e\u012f\7y\2\2\u012f\u0130\7j\2\2\u0130\u0131"+
		"\7k\2\2\u0131\u0132\7n\2\2\u0132\u0133\7g\2\2\u0133D\3\2\2\2\u0134\u0135"+
		"\7f\2\2\u0135\u0136\7q\2\2\u0136F\3\2\2\2\u0137\u0138\7k\2\2\u0138\u0139"+
		"\7h\2\2\u0139H\3\2\2\2\u013a\u013b\7g\2\2\u013b\u013c\7n\2\2\u013c\u013d"+
		"\7u\2\2\u013d\u013e\7g\2\2\u013eJ\3\2\2\2\u013f\u0140\7d\2\2\u0140\u0141"+
		"\7t\2\2\u0141\u0142\7g\2\2\u0142\u0143\7c\2\2\u0143\u0144\7m\2\2\u0144"+
		"L\3\2\2\2\u0145\u0146\7e\2\2\u0146\u0147\7q\2\2\u0147\u0148\7p\2\2\u0148"+
		"\u0149\7v\2\2\u0149\u014a\7k\2\2\u014a\u014b\7p\2\2\u014b\u014c\7w\2\2"+
		"\u014c\u014d\7g\2\2\u014dN\3\2\2\2\u014e\u014f\7u\2\2\u014f\u0150\7y\2"+
		"\2\u0150\u0151\7k\2\2\u0151\u0152\7v\2\2\u0152\u0153\7e\2\2\u0153\u0154"+
		"\7j\2\2\u0154P\3\2\2\2\u0155\u0156\7t\2\2\u0156\u0157\7g\2\2\u0157\u0158"+
		"\7v\2\2\u0158\u0159\7w\2\2\u0159\u015a\7t\2\2\u015a\u015b\7p\2\2\u015b"+
		"R\3\2\2\2\u015c\u015d\7e\2\2\u015d\u015e\7c\2\2\u015e\u015f\7u\2\2\u015f"+
		"\u0160\7g\2\2\u0160T\3\2\2\2\u0161\u0162\7f\2\2\u0162\u0163\7g\2\2\u0163"+
		"\u0164\7h\2\2\u0164\u0165\7c\2\2\u0165\u0166\7w\2\2\u0166\u0167\7n\2\2"+
		"\u0167\u0168\7v\2\2\u0168V\3\2\2\2\u0169\u016a\7v\2\2\u016a\u016b\7t\2"+
		"\2\u016b\u016c\7w\2\2\u016c\u016d\7g\2\2\u016dX\3\2\2\2\u016e\u016f\7"+
		"h\2\2\u016f\u0170\7c\2\2\u0170\u0171\7n\2\2\u0171\u0172\7u\2\2\u0172\u0173"+
		"\7g\2\2\u0173Z\3\2\2\2\u0174\u0175\7-\2\2\u0175\u0176\7-\2\2\u0176\\\3"+
		"\2\2\2\u0177\u0178\7/\2\2\u0178\u0179\7/\2\2\u0179^\3\2\2\2\u017a\u017b"+
		"\7\60\2\2\u017b`\3\2\2\2\u017c\u017d\7)\2\2\u017db\3\2\2\2\u017e\u017f"+
		"\7g\2\2\u017f\u0180\7z\2\2\u0180\u0181\7k\2\2\u0181\u0182\7u\2\2\u0182"+
		"\u0183\7v\2\2\u0183\u0184\7u\2\2\u0184d\3\2\2\2\u0185\u0186\7h\2\2\u0186"+
		"\u0187\7q\2\2\u0187\u0188\7t\2\2\u0188\u0189\7c\2\2\u0189\u018a\7n\2\2"+
		"\u018a\u018b\7n\2\2\u018bf\3\2\2\2\u018c\u018d\7-\2\2\u018d\u018e\7?\2"+
		"\2\u018eh\3\2\2\2\u018f\u0190\7/\2\2\u0190\u0191\7?\2\2\u0191j\3\2\2\2"+
		"\u0192\u0193\7,\2\2\u0193\u0194\7?\2\2\u0194l\3\2\2\2\u0195\u0196\7\61"+
		"\2\2\u0196\u0197\7?\2\2\u0197n\3\2\2\2\u0198\u0199\7\'\2\2\u0199\u019a"+
		"\7?\2\2\u019ap\3\2\2\2\u019b\u019c\7~\2\2\u019c\u019d\7?\2\2\u019dr\3"+
		"\2\2\2\u019e\u019f\7(\2\2\u019f\u01a0\7?\2\2\u01a0t\3\2\2\2\u01a1\u01a2"+
		"\7`\2\2\u01a2\u01a3\7?\2\2\u01a3v\3\2\2\2\u01a4\u01a5\7>\2\2\u01a5\u01a6"+
		"\7>\2\2\u01a6\u01a7\7?\2\2\u01a7x\3\2\2\2\u01a8\u01a9\7@\2\2\u01a9\u01aa"+
		"\7@\2\2\u01aa\u01ab\7?\2\2\u01abz\3\2\2\2\u01ac\u01ad\7-\2\2\u01ad|\3"+
		"\2\2\2\u01ae\u01af\7>\2\2\u01af\u01b0\7?\2\2\u01b0~\3\2\2\2\u01b1\u01b2"+
		"\7?\2\2\u01b2\u01b3\7?\2\2\u01b3\u0080\3\2\2\2\u01b4\u01b5\7#\2\2\u01b5"+
		"\u01b6\7?\2\2\u01b6\u0082\3\2\2\2\u01b7\u01b8\7@\2\2\u01b8\u01b9\7?\2"+
		"\2\u01b9\u0084\3\2\2\2\u01ba\u01bb\7@\2\2\u01bb\u0086\3\2\2\2\u01bc\u01bd"+
		"\7,\2\2\u01bd\u0088\3\2\2\2\u01be\u01bf\7\61\2\2\u01bf\u008a\3\2\2\2\u01c0"+
		"\u01c1\7\'\2\2\u01c1\u008c\3\2\2\2\u01c2\u01c3\7~\2\2\u01c3\u008e\3\2"+
		"\2\2\u01c4\u01c5\7`\2\2\u01c5\u0090\3\2\2\2\u01c6\u01c7\7>\2\2\u01c7\u01c8"+
		"\7>\2\2\u01c8\u0092\3\2\2\2\u01c9\u01ca\7@\2\2\u01ca\u01cb\7@\2\2\u01cb"+
		"\u0094\3\2\2\2\u01cc\u01cd\7(\2\2\u01cd\u01ce\7(\2\2\u01ce\u0096\3\2\2"+
		"\2\u01cf\u01d0\7~\2\2\u01d0\u01d1\7~\2\2\u01d1\u0098\3\2\2\2\u01d2\u01d6"+
		"\t\2\2\2\u01d3\u01d5\t\3\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7\u009a\3\2\2\2\u01d8\u01d6\3\2"+
		"\2\2\u01d9\u01db\t\4\2\2\u01da\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u009c\3\2\2\2\u01de\u01e0\t\4"+
		"\2\2\u01df\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u01e9\3\2\2\2\u01e3\u01e5\7\60\2\2\u01e4\u01e6\t"+
		"\4\2\2\u01e5\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7"+
		"\u01e8\3\2\2\2\u01e8\u01ea\3\2\2\2\u01e9\u01e3\3\2\2\2\u01e9\u01ea\3\2"+
		"\2\2\u01ea\u009e\3\2\2\2\u01eb\u01ed\t\5\2\2\u01ec\u01eb\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2"+
		"\2\2\u01f0\u01f1\bP\2\2\u01f1\u00a0\3\2\2\2\u01f2\u01f3\7\61\2\2\u01f3"+
		"\u01f4\7,\2\2\u01f4\u01f8\3\2\2\2\u01f5\u01f7\13\2\2\2\u01f6\u01f5\3\2"+
		"\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9"+
		"\u01fb\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01fc\7,\2\2\u01fc\u01fd\7\61"+
		"\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\bQ\2\2\u01ff\u00a2\3\2\2\2\u0200"+
		"\u0201\7\61\2\2\u0201\u0202\7\61\2\2\u0202\u0206\3\2\2\2\u0203\u0205\n"+
		"\6\2\2\u0204\u0203\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206"+
		"\u0207\3\2\2\2\u0207\u0209\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020a\bR"+
		"\2\2\u020a\u00a4\3\2\2\2\13\2\u01d6\u01dc\u01e1\u01e7\u01e9\u01ee\u01f8"+
		"\u0206\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}