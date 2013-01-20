// $ANTLR 3.5 /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-19 22:15:10

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int T__26=26;
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int NEWLINE=8;
	public static final int SpecialChars=9;
	public static final int String=10;
	public static final int WS=11;

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
	@Override public String getGrammarFileName() { return "/Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '!' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '!'
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '!=' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '!='
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '&&' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '&&'
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '(' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '('
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( ')' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: ')'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '*' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '*'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '+' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '+'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '-' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '-'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '/' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '/'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '<' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '<'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '<=' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '<='
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( '==' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: '=='
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( '>' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:9: '>'
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( '>=' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:9: '>='
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( '||' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: '||'
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
	// $ANTLR end "T__26"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:8: ( ( '\\n' | '\\r' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:3: ( ( ' ' | '\\t' | NEWLINE ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:97:5: ( ' ' | '\\t' | NEWLINE )
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:8: ( '/*' ( . )* '*/' | '//' (~ ( NEWLINE ) )* ( '\\r' )? '\\n' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='/') ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1=='*') ) {
					alt4=1;
				}
				else if ( (LA4_1=='/') ) {
					alt4=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:10: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:15: ( . )*
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
							// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:99:15: .
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:10: '//' (~ ( NEWLINE ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:15: (~ ( NEWLINE ) )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:27: ( '\\r' )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( (LA3_0=='\r') ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:27: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
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

	// $ANTLR start "SpecialChars"
	public final void mSpecialChars() throws RecognitionException {
		try {
			int _type = SpecialChars;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:13: ( ( '!' | '?' | ',' | '.' | '(' | ')' | '{' | '}' | '<' | '>' | '~' | '=' | '+' | '-' | '[' | ']' | '|' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			if ( input.LA(1)=='!'||(input.LA(1) >= '(' && input.LA(1) <= ')')||(input.LA(1) >= '+' && input.LA(1) <= '.')||(input.LA(1) >= '<' && input.LA(1) <= '?')||input.LA(1)=='['||input.LA(1)==']'||(input.LA(1) >= '{' && input.LA(1) <= '~') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SpecialChars"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:5: ( ( 'true' | 'false' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:7: ( 'true' | 'false' )
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:7: ( 'true' | 'false' )
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:8: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:17: 'false'
					{
					match("false"); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Bool"

	// $ANTLR start "String"
	public final void mString() throws RecognitionException {
		try {
			int _type = String;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:7: ( '\"' ( Ident | WS | Int | SpecialChars )* '\"' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:9: '\"' ( Ident | WS | Int | SpecialChars )* '\"'
			{
			match('\"'); 
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:13: ( Ident | WS | Int | SpecialChars )*
			loop6:
			while (true) {
				int alt6=5;
				switch ( input.LA(1) ) {
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
					alt6=1;
					}
					break;
				case '\t':
				case '\n':
				case '\r':
				case ' ':
					{
					alt6=2;
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
					alt6=3;
					}
					break;
				case '!':
				case '(':
				case ')':
				case '+':
				case ',':
				case '-':
				case '.':
				case '<':
				case '=':
				case '>':
				case '?':
				case '[':
				case ']':
				case '{':
				case '|':
				case '}':
				case '~':
					{
					alt6=4;
					}
					break;
				}
				switch (alt6) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:14: Ident
					{
					mIdent(); 

					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:22: WS
					{
					mWS(); 

					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:27: Int
					{
					mInt(); 

					}
					break;
				case 4 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:106:33: SpecialChars
					{
					mSpecialChars(); 

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
	// $ANTLR end "String"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:108:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:4: ( ( '0' .. '9' )+ )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:6: ( '0' .. '9' )+
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:110:6: ( '0' .. '9' )+
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | NEWLINE | WS | COMMENT | SpecialChars | Bool | String | Ident | Int )
		int alt9=23;
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
				alt9=18;
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
			int LA9_10 = input.LA(2);
			if ( (LA9_10=='=') ) {
				alt9=12;
			}

			else {
				alt9=19;
			}

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
			int LA9_12 = input.LA(2);
			if ( (LA9_12=='|') ) {
				alt9=15;
			}

			else {
				alt9=19;
			}

			}
			break;
		case '\n':
		case '\r':
			{
			alt9=16;
			}
			break;
		case '\t':
		case ' ':
			{
			alt9=17;
			}
			break;
		case ',':
		case '.':
		case '?':
		case '[':
		case ']':
		case '{':
		case '}':
		case '~':
			{
			alt9=19;
			}
			break;
		case 't':
			{
			int LA9_16 = input.LA(2);
			if ( (LA9_16=='r') ) {
				int LA9_36 = input.LA(3);
				if ( (LA9_36=='u') ) {
					int LA9_38 = input.LA(4);
					if ( (LA9_38=='e') ) {
						int LA9_40 = input.LA(5);
						if ( ((LA9_40 >= '0' && LA9_40 <= '9')||(LA9_40 >= 'A' && LA9_40 <= 'Z')||LA9_40=='_'||(LA9_40 >= 'a' && LA9_40 <= 'z')) ) {
							alt9=22;
						}

						else {
							alt9=20;
						}

					}

					else {
						alt9=22;
					}

				}

				else {
					alt9=22;
				}

			}

			else {
				alt9=22;
			}

			}
			break;
		case 'f':
			{
			int LA9_17 = input.LA(2);
			if ( (LA9_17=='a') ) {
				int LA9_37 = input.LA(3);
				if ( (LA9_37=='l') ) {
					int LA9_39 = input.LA(4);
					if ( (LA9_39=='s') ) {
						int LA9_41 = input.LA(5);
						if ( (LA9_41=='e') ) {
							int LA9_43 = input.LA(6);
							if ( ((LA9_43 >= '0' && LA9_43 <= '9')||(LA9_43 >= 'A' && LA9_43 <= 'Z')||LA9_43=='_'||(LA9_43 >= 'a' && LA9_43 <= 'z')) ) {
								alt9=22;
							}

							else {
								alt9=20;
							}

						}

						else {
							alt9=22;
						}

					}

					else {
						alt9=22;
					}

				}

				else {
					alt9=22;
				}

			}

			else {
				alt9=22;
			}

			}
			break;
		case '\"':
			{
			alt9=21;
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
			alt9=22;
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
			alt9=23;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 9, 0, input);
			throw nvae;
		}
		switch (alt9) {
			case 1 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__12
				{
				mT__12(); 

				}
				break;
			case 2 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__13
				{
				mT__13(); 

				}
				break;
			case 3 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__14
				{
				mT__14(); 

				}
				break;
			case 4 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__15
				{
				mT__15(); 

				}
				break;
			case 5 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__16
				{
				mT__16(); 

				}
				break;
			case 6 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__17
				{
				mT__17(); 

				}
				break;
			case 7 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__18
				{
				mT__18(); 

				}
				break;
			case 8 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__19
				{
				mT__19(); 

				}
				break;
			case 9 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__20
				{
				mT__20(); 

				}
				break;
			case 10 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__21
				{
				mT__21(); 

				}
				break;
			case 11 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__22
				{
				mT__22(); 

				}
				break;
			case 12 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__23
				{
				mT__23(); 

				}
				break;
			case 13 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__24
				{
				mT__24(); 

				}
				break;
			case 14 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__25
				{
				mT__25(); 

				}
				break;
			case 15 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__26
				{
				mT__26(); 

				}
				break;
			case 16 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 17 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:108: WS
				{
				mWS(); 

				}
				break;
			case 18 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:111: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 19 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:119: SpecialChars
				{
				mSpecialChars(); 

				}
				break;
			case 20 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:132: Bool
				{
				mBool(); 

				}
				break;
			case 21 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:137: String
				{
				mString(); 

				}
				break;
			case 22 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:144: Ident
				{
				mIdent(); 

				}
				break;
			case 23 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:150: Int
				{
				mInt(); 

				}
				break;

		}
	}



}
