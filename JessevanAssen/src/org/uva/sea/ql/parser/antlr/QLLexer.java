// $ANTLR 3.5 \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-08 21:21:46

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int T__25=25;
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int NewLine=8;
	public static final int Str=9;
	public static final int WS=10;

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
	@Override public String getGrammarFileName() { return "\\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:7: ( '!' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:9: '!'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:7: ( '!=' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:9: '!='
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:7: ( '&&' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:9: '&&'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:7: ( '(' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:9: '('
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:7: ( ')' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:9: ')'
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '*' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '*'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '+' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '+'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '-' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '-'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '/' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '/'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( '<' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: '<'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '<=' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '<='
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '==' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '=='
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( '>' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: '>'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( '>=' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: '>='
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( '||' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: '||'
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
	// $ANTLR end "T__25"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:90:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:5: ( '/*' ( . )* '*/' | '//' (~ NewLine )* )
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
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:7: '/*' ( . )* '*/'
					{
					match("/*"); 

					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:12: ( . )*
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
							// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:94:12: .
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
					break;
				case 2 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:7: '//' (~ NewLine )*
					{
					match("//"); 

					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:12: (~ NewLine )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:12: ~ NewLine
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\u0007')||(input.LA(1) >= '\t' && input.LA(1) <= '\uFFFF') ) {
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

					_channel=HIDDEN;
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
	// $ANTLR end "COMMENT"

	// $ANTLR start "NewLine"
	public final void mNewLine() throws RecognitionException {
		try {
			int _type = NewLine;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:8: ( '\\n' | '\\r\\n' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\n') ) {
				alt4=1;
			}
			else if ( (LA4_0=='\r') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:10: '\\n'
					{
					match('\n'); 
					}
					break;
				case 2 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:17: '\\r\\n'
					{
					match("\r\n"); 

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
	// $ANTLR end "NewLine"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:5: ( 'true' | 'false' )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='t') ) {
				alt5=1;
			}
			else if ( (LA5_0=='f') ) {
				alt5=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:7: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:14: 'false'
					{
					match("false"); 

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
	// $ANTLR end "Bool"

	// $ANTLR start "Str"
	public final void mStr() throws RecognitionException {
		try {
			int _type = Str;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:4: ( '\\\"' ( '\\\\\"' |~ '\\\"' )* '\\\"' )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:6: '\\\"' ( '\\\\\"' |~ '\\\"' )* '\\\"'
			{
			match('\"'); 
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:11: ( '\\\\\"' |~ '\\\"' )*
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\\') ) {
					int LA6_2 = input.LA(2);
					if ( (LA6_2=='\"') ) {
						int LA6_4 = input.LA(3);
						if ( ((LA6_4 >= '\u0000' && LA6_4 <= '\uFFFF')) ) {
							alt6=1;
						}
						else {
							alt6=2;
						}

					}
					else if ( ((LA6_2 >= '\u0000' && LA6_2 <= '!')||(LA6_2 >= '#' && LA6_2 <= '\uFFFF')) ) {
						alt6=2;
					}

				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '[')||(LA6_0 >= ']' && LA6_0 <= '\uFFFF')) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:12: '\\\\\"'
					{
					match("\\\""); 

					}
					break;
				case 2 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:18: ~ '\\\"'
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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
					break loop6;
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
	// $ANTLR end "Str"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
					break loop7;
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
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:4: ( ( '0' .. '9' )+ )
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:6: ( '0' .. '9' )+
			{
			// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:106:6: ( '0' .. '9' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
		// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | WS | COMMENT | NewLine | Bool | Str | Ident | Int )
		int alt9=22;
		switch ( input.LA(1) ) {
		case '!':
			{
			int LA9_1 = input.LA(2);
			if ( (LA9_1=='=') ) {
				alt9=2;
			}

			else {
				alt9=1;
			}

			}
			break;
		case '&':
			{
			alt9=3;
			}
			break;
		case '(':
			{
			alt9=4;
			}
			break;
		case ')':
			{
			alt9=5;
			}
			break;
		case '*':
			{
			alt9=6;
			}
			break;
		case '+':
			{
			alt9=7;
			}
			break;
		case '-':
			{
			alt9=8;
			}
			break;
		case '/':
			{
			int LA9_8 = input.LA(2);
			if ( (LA9_8=='*'||LA9_8=='/') ) {
				alt9=17;
			}

			else {
				alt9=9;
			}

			}
			break;
		case '<':
			{
			int LA9_9 = input.LA(2);
			if ( (LA9_9=='=') ) {
				alt9=11;
			}

			else {
				alt9=10;
			}

			}
			break;
		case '=':
			{
			alt9=12;
			}
			break;
		case '>':
			{
			int LA9_11 = input.LA(2);
			if ( (LA9_11=='=') ) {
				alt9=14;
			}

			else {
				alt9=13;
			}

			}
			break;
		case '|':
			{
			alt9=15;
			}
			break;
		case '\n':
			{
			alt9=16;
			}
			break;
		case '\r':
			{
			int LA9_14 = input.LA(2);
			if ( (LA9_14=='\n') ) {
				alt9=18;
			}

			else {
				alt9=16;
			}

			}
			break;
		case '\t':
		case ' ':
			{
			alt9=16;
			}
			break;
		case 't':
			{
			int LA9_16 = input.LA(2);
			if ( (LA9_16=='r') ) {
				int LA9_30 = input.LA(3);
				if ( (LA9_30=='u') ) {
					int LA9_32 = input.LA(4);
					if ( (LA9_32=='e') ) {
						int LA9_34 = input.LA(5);
						if ( ((LA9_34 >= '0' && LA9_34 <= '9')||(LA9_34 >= 'A' && LA9_34 <= 'Z')||LA9_34=='_'||(LA9_34 >= 'a' && LA9_34 <= 'z')) ) {
							alt9=21;
						}

						else {
							alt9=19;
						}

					}

					else {
						alt9=21;
					}

				}

				else {
					alt9=21;
				}

			}

			else {
				alt9=21;
			}

			}
			break;
		case 'f':
			{
			int LA9_17 = input.LA(2);
			if ( (LA9_17=='a') ) {
				int LA9_31 = input.LA(3);
				if ( (LA9_31=='l') ) {
					int LA9_33 = input.LA(4);
					if ( (LA9_33=='s') ) {
						int LA9_35 = input.LA(5);
						if ( (LA9_35=='e') ) {
							int LA9_37 = input.LA(6);
							if ( ((LA9_37 >= '0' && LA9_37 <= '9')||(LA9_37 >= 'A' && LA9_37 <= 'Z')||LA9_37=='_'||(LA9_37 >= 'a' && LA9_37 <= 'z')) ) {
								alt9=21;
							}

							else {
								alt9=19;
							}

						}

						else {
							alt9=21;
						}

					}

					else {
						alt9=21;
					}

				}

				else {
					alt9=21;
				}

			}

			else {
				alt9=21;
			}

			}
			break;
		case '\"':
			{
			alt9=20;
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
			alt9=21;
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
			alt9=22;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 9, 0, input);
			throw nvae;
		}
		switch (alt9) {
			case 1 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__11
				{
				mT__11(); 

				}
				break;
			case 2 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__12
				{
				mT__12(); 

				}
				break;
			case 3 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__13
				{
				mT__13(); 

				}
				break;
			case 4 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__14
				{
				mT__14(); 

				}
				break;
			case 5 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__15
				{
				mT__15(); 

				}
				break;
			case 6 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__16
				{
				mT__16(); 

				}
				break;
			case 7 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__17
				{
				mT__17(); 

				}
				break;
			case 8 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__18
				{
				mT__18(); 

				}
				break;
			case 9 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__19
				{
				mT__19(); 

				}
				break;
			case 10 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__20
				{
				mT__20(); 

				}
				break;
			case 11 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__21
				{
				mT__21(); 

				}
				break;
			case 12 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__22
				{
				mT__22(); 

				}
				break;
			case 13 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__23
				{
				mT__23(); 

				}
				break;
			case 14 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__24
				{
				mT__24(); 

				}
				break;
			case 15 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__25
				{
				mT__25(); 

				}
				break;
			case 16 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: WS
				{
				mWS(); 

				}
				break;
			case 17 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:103: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 18 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:111: NewLine
				{
				mNewLine(); 

				}
				break;
			case 19 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:119: Bool
				{
				mBool(); 

				}
				break;
			case 20 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:124: Str
				{
				mStr(); 

				}
				break;
			case 21 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:128: Ident
				{
				mIdent(); 

				}
				break;
			case 22 :
				// \\\\pc-jesse\\c$\\Users\\Jesse\\workspace\\sea-of-ql\\JessevanAssen\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:134: Int
				{
				mInt(); 

				}
				break;

		}
	}



}
