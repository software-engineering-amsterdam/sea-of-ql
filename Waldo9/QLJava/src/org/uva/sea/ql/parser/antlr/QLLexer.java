// $ANTLR 3.5 C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g 2013-01-12 16:05:37

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__9=9;
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
	public static final int COMMENT=4;
	public static final int Ident=5;
	public static final int Int=6;
	public static final int NEWLINE=7;
	public static final int WS=8;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g"; }

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:6:6: ( '!' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:6:8: '!'
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
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:7:7: ( '!=' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:7:9: '!='
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:8:7: ( '&&' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:8:9: '&&'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:9:7: ( '(' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:9:9: '('
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:10:7: ( ')' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:10:9: ')'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:11:7: ( '*' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:11:9: '*'
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:12:7: ( '+' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:12:9: '+'
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:13:7: ( '-' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:13:9: '-'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:14:7: ( '/' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:14:9: '/'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:15:7: ( '<' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:15:9: '<'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:16:7: ( '<=' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:16:9: '<='
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:17:7: ( '==' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:17:9: '=='
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:18:7: ( '>' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:18:9: '>'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:19:7: ( '>=' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:19:9: '>='
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:20:7: ( '||' )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:20:9: '||'
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
	// $ANTLR end "T__23"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:88:5: ( ( ' ' | '\\t' | NEWLINE ) )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:88:7: ( ' ' | '\\t' | NEWLINE )
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
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:6: ( ( '/*' ( . )* '*/' | '//' (~ ( NEWLINE ) )* ) )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:8: ( '/*' ( . )* '*/' | '//' (~ ( NEWLINE ) )* )
			{
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:8: ( '/*' ( . )* '*/' | '//' (~ ( NEWLINE ) )* )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='/') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='*') ) {
					alt3=1;
				}
				else if ( (LA3_1=='/') ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:9: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:14: ( . )*
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
							// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:14: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop1;
						}
					}

					match("*/"); 

					}
					break;
				case 2 :
					// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:24: '//' (~ ( NEWLINE ) )*
					{
					match("//"); 

					// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:92:29: (~ ( NEWLINE ) )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
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
							break loop2;
						}
					}

					}
					break;

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
	// $ANTLR end "COMMENT"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:95:2: ( ( '\\n' | '\\r' ) )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:
			{
			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:97:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:97:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:97:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:
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
					break loop4;
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
	// $ANTLR end "Ident"

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:99:4: ( ( '0' .. '9' )+ )
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:99:6: ( '0' .. '9' )+
			{
			// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:99:6: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Int"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | WS | COMMENT | Ident | Int )
		int alt6=19;
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
			if ( (LA6_8=='*'||LA6_8=='/') ) {
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
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
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
		case 'T':
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
		case 'f':
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
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt6=18;
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
			alt6=19;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 6, 0, input);
			throw nvae;
		}
		switch (alt6) {
			case 1 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:10: T__9
				{
				mT__9(); 

				}
				break;
			case 2 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:15: T__10
				{
				mT__10(); 

				}
				break;
			case 3 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:21: T__11
				{
				mT__11(); 

				}
				break;
			case 4 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:27: T__12
				{
				mT__12(); 

				}
				break;
			case 5 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:33: T__13
				{
				mT__13(); 

				}
				break;
			case 6 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:39: T__14
				{
				mT__14(); 

				}
				break;
			case 7 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:45: T__15
				{
				mT__15(); 

				}
				break;
			case 8 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:51: T__16
				{
				mT__16(); 

				}
				break;
			case 9 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:57: T__17
				{
				mT__17(); 

				}
				break;
			case 10 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:63: T__18
				{
				mT__18(); 

				}
				break;
			case 11 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:69: T__19
				{
				mT__19(); 

				}
				break;
			case 12 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:75: T__20
				{
				mT__20(); 

				}
				break;
			case 13 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:81: T__21
				{
				mT__21(); 

				}
				break;
			case 14 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:87: T__22
				{
				mT__22(); 

				}
				break;
			case 15 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:93: T__23
				{
				mT__23(); 

				}
				break;
			case 16 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:99: WS
				{
				mWS(); 

				}
				break;
			case 17 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:102: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 18 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:110: Ident
				{
				mIdent(); 

				}
				break;
			case 19 :
				// C:\\Users\\Wouter Kwakernaak\\Desktop\\QL.g:1:116: Int
				{
				mInt(); 

				}
				break;

		}
	}



}
