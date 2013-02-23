// $ANTLR 3.5 C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-19 20:08:06

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int Assign=4;
	public static final int COMMENT=5;
	public static final int Form=6;
	public static final int FormIdent=7;
	public static final int Ident=8;
	public static final int Int=9;
	public static final int LEFTBR=10;
	public static final int LEFTCBR=11;
	public static final int RIGHTBR=12;
	public static final int RIGHTCBR=13;
	public static final int String=14;
	public static final int WS=15;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:7: ( '!' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:9: '!'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:7: ( '!=' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:9: '!='
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:7: ( '&&' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:9: '&&'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:7: ( '*' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:9: '*'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:7: ( '+' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:9: '+'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '-' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '-'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '/' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '/'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '<' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '<'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '<=' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '<='
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( '==' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: '=='
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '>' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '>'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '>=' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '>='
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( 'boolean' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: 'boolean'
			{
			match("boolean"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( 'if' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( 'integer' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: 'integer'
			{
			match("integer"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: ( 'money' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:9: 'money'
			{
			match("money"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: ( 'string' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:9: 'string'
			{
			match("string"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:7: ( '||' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:9: '||'
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
	// $ANTLR end "T__33"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:6: ( '/*' ( . )* '*/' | '//' (~ '\\n' )* )
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:10: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:15: ( . )*
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
							// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:149:15: .
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
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:10: '//' (~ '\\n' )*
					{
					match("//"); 

					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:15: (~ '\\n' )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:153:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:153:8: ( ' ' | '\\t' | '\\n' | '\\r' )
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

	// $ANTLR start "Form"
	public final void mForm() throws RecognitionException {
		try {
			int _type = Form;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:155:7: ( 'form' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:155:9: 'form'
			{
			match("form"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Form"

	// $ANTLR start "FormIdent"
	public final void mFormIdent() throws RecognitionException {
		try {
			int _type = FormIdent;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:156:10: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:156:12: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			{
			matchRange('A','Z'); 
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:156:21: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
	// $ANTLR end "FormIdent"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:7: ( ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:12: ( 'a' .. 'z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:157:22: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
					break loop5;
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

	// $ANTLR start "String"
	public final void mString() throws RecognitionException {
		try {
			int _type = String;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:158:8: ( '\"' ( . )* '\"' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:158:10: '\"' ( . )* '\"'
			{
			match('\"'); 
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:158:14: ( . )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\"') ) {
					alt6=2;
				}
				else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:158:14: .
					{
					matchAny(); 
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

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:160:6: ( ( '0' .. '9' )+ )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:160:9: ( '0' .. '9' )+
			{
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:160:9: ( '0' .. '9' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
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

	// $ANTLR start "Assign"
	public final void mAssign() throws RecognitionException {
		try {
			int _type = Assign;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:161:9: ( ':' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:161:11: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Assign"

	// $ANTLR start "LEFTCBR"
	public final void mLEFTCBR() throws RecognitionException {
		try {
			int _type = LEFTCBR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:163:9: ( '{' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:163:11: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFTCBR"

	// $ANTLR start "RIGHTCBR"
	public final void mRIGHTCBR() throws RecognitionException {
		try {
			int _type = RIGHTCBR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:164:9: ( '}' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:164:11: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHTCBR"

	// $ANTLR start "LEFTBR"
	public final void mLEFTBR() throws RecognitionException {
		try {
			int _type = LEFTBR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:165:9: ( '(' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:165:11: '('
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
	// $ANTLR end "LEFTBR"

	// $ANTLR start "RIGHTBR"
	public final void mRIGHTBR() throws RecognitionException {
		try {
			int _type = RIGHTBR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:166:9: ( ')' )
			// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:166:11: ')'
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
	// $ANTLR end "RIGHTBR"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | COMMENT | WS | Form | FormIdent | Ident | String | Int | Assign | LEFTCBR | RIGHTCBR | LEFTBR | RIGHTBR )
		int alt8=30;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__16
				{
				mT__16(); 

				}
				break;
			case 2 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__17
				{
				mT__17(); 

				}
				break;
			case 3 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__18
				{
				mT__18(); 

				}
				break;
			case 4 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__19
				{
				mT__19(); 

				}
				break;
			case 5 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__20
				{
				mT__20(); 

				}
				break;
			case 6 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__21
				{
				mT__21(); 

				}
				break;
			case 7 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__22
				{
				mT__22(); 

				}
				break;
			case 8 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__23
				{
				mT__23(); 

				}
				break;
			case 9 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__24
				{
				mT__24(); 

				}
				break;
			case 10 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__25
				{
				mT__25(); 

				}
				break;
			case 11 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__26
				{
				mT__26(); 

				}
				break;
			case 12 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__27
				{
				mT__27(); 

				}
				break;
			case 13 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__28
				{
				mT__28(); 

				}
				break;
			case 14 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__29
				{
				mT__29(); 

				}
				break;
			case 15 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__30
				{
				mT__30(); 

				}
				break;
			case 16 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__31
				{
				mT__31(); 

				}
				break;
			case 17 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: T__32
				{
				mT__32(); 

				}
				break;
			case 18 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:112: T__33
				{
				mT__33(); 

				}
				break;
			case 19 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:118: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 20 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:126: WS
				{
				mWS(); 

				}
				break;
			case 21 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:129: Form
				{
				mForm(); 

				}
				break;
			case 22 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:134: FormIdent
				{
				mFormIdent(); 

				}
				break;
			case 23 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:144: Ident
				{
				mIdent(); 

				}
				break;
			case 24 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:150: String
				{
				mString(); 

				}
				break;
			case 25 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:157: Int
				{
				mInt(); 

				}
				break;
			case 26 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:161: Assign
				{
				mAssign(); 

				}
				break;
			case 27 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:168: LEFTCBR
				{
				mLEFTCBR(); 

				}
				break;
			case 28 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:176: RIGHTCBR
				{
				mRIGHTCBR(); 

				}
				break;
			case 29 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:185: LEFTBR
				{
				mLEFTBR(); 

				}
				break;
			case 30 :
				// C:\\Users\\don\\workspace\\sea-of-ql-repo-3\\ckonig\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:192: RIGHTBR
				{
				mRIGHTBR(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\33\4\uffff\1\35\1\37\1\uffff\1\41\4\22\2\uffff\1\22\21\uffff"+
		"\1\22\1\51\5\22\1\uffff\10\22\1\67\2\22\1\72\1\22\1\uffff\2\22\1\uffff"+
		"\1\76\1\77\1\100\3\uffff";
	static final String DFA8_eofS =
		"\101\uffff";
	static final String DFA8_minS =
		"\1\11\1\75\4\uffff\1\52\1\75\1\uffff\1\75\1\157\1\146\1\157\1\164\2\uffff"+
		"\1\157\21\uffff\1\157\1\60\1\164\1\156\2\162\1\154\1\uffff\2\145\1\151"+
		"\1\155\1\145\1\147\1\171\1\156\1\60\1\141\1\145\1\60\1\147\1\uffff\1\156"+
		"\1\162\1\uffff\3\60\3\uffff";
	static final String DFA8_maxS =
		"\1\175\1\75\4\uffff\1\57\1\75\1\uffff\1\75\1\157\1\156\1\157\1\164\2\uffff"+
		"\1\157\21\uffff\1\157\1\172\1\164\1\156\2\162\1\154\1\uffff\2\145\1\151"+
		"\1\155\1\145\1\147\1\171\1\156\1\172\1\141\1\145\1\172\1\147\1\uffff\1"+
		"\156\1\162\1\uffff\3\172\3\uffff";
	static final String DFA8_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\2\uffff\1\12\5\uffff\1\22\1\24\1\uffff\1\26\1"+
		"\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\2\1\1\1\23\1\7\1\11\1\10\1\14"+
		"\1\13\7\uffff\1\16\15\uffff\1\25\2\uffff\1\20\3\uffff\1\21\1\15\1\17";
	static final String DFA8_specialS =
		"\101\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\17\2\uffff\1\17\22\uffff\1\17\1\1\1\23\3\uffff\1\2\1\uffff\1\30\1"+
			"\31\1\3\1\4\1\uffff\1\5\1\uffff\1\6\12\24\1\25\1\uffff\1\7\1\10\1\11"+
			"\2\uffff\32\21\6\uffff\1\22\1\12\3\22\1\20\2\22\1\13\3\22\1\14\5\22\1"+
			"\15\7\22\1\26\1\16\1\27",
			"\1\32",
			"",
			"",
			"",
			"",
			"\1\34\4\uffff\1\34",
			"\1\36",
			"",
			"\1\40",
			"\1\42",
			"\1\43\7\uffff\1\44",
			"\1\45",
			"\1\46",
			"",
			"",
			"\1\47",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\50",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\70",
			"\1\71",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\1\73",
			"",
			"\1\74",
			"\1\75",
			"",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32\22",
			"",
			"",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | COMMENT | WS | Form | FormIdent | Ident | String | Int | Assign | LEFTCBR | RIGHTCBR | LEFTBR | RIGHTBR );";
		}
	}

}
