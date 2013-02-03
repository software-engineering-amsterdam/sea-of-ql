// $ANTLR 3.5 C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g 2013-02-03 12:26:25

package org.uva.sea.ql.parsers.antlr; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int BOOL=4;
	public static final int COMMENT=5;
	public static final int IDENT=6;
	public static final int INT=7;
	public static final int STRING=8;
	public static final int WS=9;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public QLLexer() {} 
	public QLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public QLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g"; }

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:6:7: ( '!' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:6:9: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:7:7: ( '!=' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:7:9: '!='
			{
			match("!="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:8:7: ( '&&' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:8:9: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:9:7: ( '(' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:9:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:10:7: ( ')' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:10:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:11:7: ( '*' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:11:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:12:7: ( '+' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:12:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:13:7: ( '-' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:13:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:14:7: ( '/' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:14:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:15:7: ( '<' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:15:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:16:7: ( '<=' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:16:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:17:7: ( '==' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:17:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:18:7: ( '>' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:18:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:19:7: ( '>=' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:19:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:20:7: ( '||' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:20:9: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:94:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:94:7: ( ' ' | '\\t' | '\\n' | '\\r' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:98:6: ( '/*' ( . )* '*/' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:98:8: '/*' ( . )* '*/'
			{
			match("/*"); 

			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:98:13: ( . )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='*') ) {
					int LA1_1 = input.LA(2);
					if ( (LA1_1=='/') ) {
						alt1=2;
					}
					else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
						alt1=1;
					}

				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:98:13: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop1;
				}
			}

			match("*/"); 

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "BOOL"
	public final void mBOOL() throws RecognitionException {
		try {
			int _type = BOOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:102:3: ( 'true' | 'false' | 'TRUE' | 'FALSE' )
			int alt2=4;
			switch ( input.LA(1) ) {
			case 't':
				{
				alt2=1;
				}
				break;
			case 'f':
				{
				alt2=2;
				}
				break;
			case 'T':
				{
				alt2=3;
				}
				break;
			case 'F':
				{
				alt2=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:102:5: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:103:5: 'false'
					{
					match("false"); 

					}
					break;
				case 3 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:104:5: 'TRUE'
					{
					match("TRUE"); 

					}
					break;
				case 4 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:105:5: 'FALSE'
					{
					match("FALSE"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOL"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:108:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:108:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:108:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop3;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:110:4: ( ( '0' .. '9' )+ )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:110:6: ( '0' .. '9' )+
			{
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:110:6: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:112:7: ( '\"' ( . )* '\"' )
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:112:9: '\"' ( . )* '\"'
			{
			match('\"'); 
			// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:112:13: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\"') ) {
					alt5=2;
				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:112:13: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | WS | COMMENT | BOOL | IDENT | INT | STRING )
		int alt6=21;
		switch ( input.LA(1) ) {
		case '!':
			{
			int LA6_1 = input.LA(2);
			if ( (LA6_1=='=') ) {
				alt6=2;
			}

			else {
				alt6=1;
			}

			}
			break;
		case '&':
			{
			alt6=3;
			}
			break;
		case '(':
			{
			alt6=4;
			}
			break;
		case ')':
			{
			alt6=5;
			}
			break;
		case '*':
			{
			alt6=6;
			}
			break;
		case '+':
			{
			alt6=7;
			}
			break;
		case '-':
			{
			alt6=8;
			}
			break;
		case '/':
			{
			int LA6_8 = input.LA(2);
			if ( (LA6_8=='*') ) {
				alt6=17;
			}

			else {
				alt6=9;
			}

			}
			break;
		case '<':
			{
			int LA6_9 = input.LA(2);
			if ( (LA6_9=='=') ) {
				alt6=11;
			}

			else {
				alt6=10;
			}

			}
			break;
		case '=':
			{
			alt6=12;
			}
			break;
		case '>':
			{
			int LA6_11 = input.LA(2);
			if ( (LA6_11=='=') ) {
				alt6=14;
			}

			else {
				alt6=13;
			}

			}
			break;
		case '|':
			{
			alt6=15;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt6=16;
			}
			break;
		case 't':
			{
			int LA6_14 = input.LA(2);
			if ( (LA6_14=='r') ) {
				int LA6_29 = input.LA(3);
				if ( (LA6_29=='u') ) {
					int LA6_33 = input.LA(4);
					if ( (LA6_33=='e') ) {
						int LA6_37 = input.LA(5);
						if ( ((LA6_37 >= '0' && LA6_37 <= '9')||(LA6_37 >= 'A' && LA6_37 <= 'Z')||LA6_37=='_'||(LA6_37 >= 'a' && LA6_37 <= 'z')) ) {
							alt6=19;
						}

						else {
							alt6=18;
						}

					}

					else {
						alt6=19;
					}

				}

				else {
					alt6=19;
				}

			}

			else {
				alt6=19;
			}

			}
			break;
		case 'f':
			{
			int LA6_15 = input.LA(2);
			if ( (LA6_15=='a') ) {
				int LA6_30 = input.LA(3);
				if ( (LA6_30=='l') ) {
					int LA6_34 = input.LA(4);
					if ( (LA6_34=='s') ) {
						int LA6_38 = input.LA(5);
						if ( (LA6_38=='e') ) {
							int LA6_42 = input.LA(6);
							if ( ((LA6_42 >= '0' && LA6_42 <= '9')||(LA6_42 >= 'A' && LA6_42 <= 'Z')||LA6_42=='_'||(LA6_42 >= 'a' && LA6_42 <= 'z')) ) {
								alt6=19;
							}

							else {
								alt6=18;
							}

						}

						else {
							alt6=19;
						}

					}

					else {
						alt6=19;
					}

				}

				else {
					alt6=19;
				}

			}

			else {
				alt6=19;
			}

			}
			break;
		case 'T':
			{
			int LA6_16 = input.LA(2);
			if ( (LA6_16=='R') ) {
				int LA6_31 = input.LA(3);
				if ( (LA6_31=='U') ) {
					int LA6_35 = input.LA(4);
					if ( (LA6_35=='E') ) {
						int LA6_39 = input.LA(5);
						if ( ((LA6_39 >= '0' && LA6_39 <= '9')||(LA6_39 >= 'A' && LA6_39 <= 'Z')||LA6_39=='_'||(LA6_39 >= 'a' && LA6_39 <= 'z')) ) {
							alt6=19;
						}

						else {
							alt6=18;
						}

					}

					else {
						alt6=19;
					}

				}

				else {
					alt6=19;
				}

			}

			else {
				alt6=19;
			}

			}
			break;
		case 'F':
			{
			int LA6_17 = input.LA(2);
			if ( (LA6_17=='A') ) {
				int LA6_32 = input.LA(3);
				if ( (LA6_32=='L') ) {
					int LA6_36 = input.LA(4);
					if ( (LA6_36=='S') ) {
						int LA6_40 = input.LA(5);
						if ( (LA6_40=='E') ) {
							int LA6_43 = input.LA(6);
							if ( ((LA6_43 >= '0' && LA6_43 <= '9')||(LA6_43 >= 'A' && LA6_43 <= 'Z')||LA6_43=='_'||(LA6_43 >= 'a' && LA6_43 <= 'z')) ) {
								alt6=19;
							}

							else {
								alt6=18;
							}

						}

						else {
							alt6=19;
						}

					}

					else {
						alt6=19;
					}

				}

				else {
					alt6=19;
				}

			}

			else {
				alt6=19;
			}

			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt6=19;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt6=20;
			}
			break;
		case '\"':
			{
			alt6=21;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:10: T__10
				{
				mT__10(); 

				}
				break;
			case 2 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:16: T__11
				{
				mT__11(); 

				}
				break;
			case 3 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:22: T__12
				{
				mT__12(); 

				}
				break;
			case 4 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:28: T__13
				{
				mT__13(); 

				}
				break;
			case 5 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:34: T__14
				{
				mT__14(); 

				}
				break;
			case 6 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:40: T__15
				{
				mT__15(); 

				}
				break;
			case 7 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:46: T__16
				{
				mT__16(); 

				}
				break;
			case 8 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:52: T__17
				{
				mT__17(); 

				}
				break;
			case 9 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:58: T__18
				{
				mT__18(); 

				}
				break;
			case 10 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:64: T__19
				{
				mT__19(); 

				}
				break;
			case 11 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:70: T__20
				{
				mT__20(); 

				}
				break;
			case 12 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:76: T__21
				{
				mT__21(); 

				}
				break;
			case 13 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:82: T__22
				{
				mT__22(); 

				}
				break;
			case 14 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:88: T__23
				{
				mT__23(); 

				}
				break;
			case 15 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:94: T__24
				{
				mT__24(); 

				}
				break;
			case 16 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:100: WS
				{
				mWS(); 

				}
				break;
			case 17 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:103: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 18 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:111: BOOL
				{
				mBOOL(); 

				}
				break;
			case 19 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:116: IDENT
				{
				mIDENT(); 

				}
				break;
			case 20 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:122: INT
				{
				mINT(); 

				}
				break;
			case 21 :
				// C:\\Tubis\\School\\Software Construction\\WorkSpace\\sea-of-ql\\tubakaya\\QLJava\\src\\org\\uva\\sea\\ql\\parsers\\antlr\\QL.g:1:126: STRING
				{
				mSTRING(); 

				}
				break;

		}
	}



}
