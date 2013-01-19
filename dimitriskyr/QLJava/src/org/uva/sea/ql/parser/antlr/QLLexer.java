// $ANTLR 3.5 C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-19 04:39:23

package org.uva.sea.ql.parser.antlr;


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
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int Bool=4;
	public static final int Comments=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int String_literal=8;
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
	@Override public String getGrammarFileName() { return "C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '!' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '!'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '!=' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '!='
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '&&' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '&&'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '(' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '('
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( ')' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: ')'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '*' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '*'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '+' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '+'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( '-' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: '-'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( '/' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: '/'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( ':' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: ':'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: ( '<' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:9: '<'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: ( '<=' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:9: '<='
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:7: ( '==' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:9: '=='
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:7: ( '>' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:9: '>'
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:7: ( '>=' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:9: '>='
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
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:7: ( 'form' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:9: 'form'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:7: ( 'if' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:9: 'if'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:7: ( '{' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:28:9: '{'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:7: ( '||' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:29:9: '||'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:7: ( '}' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:30:9: '}'
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
	// $ANTLR end "T__29"

	// $ANTLR start "Comments"
	public final void mComments() throws RecognitionException {
		try {
			int _type = Comments;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:10: ( ( '/*' ( . )* '*/' | '//' ( . )* ( '\\n' | '\\r' ) ) )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:12: ( '/*' ( . )* '*/' | '//' ( . )* ( '\\n' | '\\r' ) )
			{
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:12: ( '/*' ( . )* '*/' | '//' ( . )* ( '\\n' | '\\r' ) )
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
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:13: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:18: ( . )*
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
							// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:18: .
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
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:28: '//' ( . )* ( '\\n' | '\\r' )
					{
					match("//"); 

					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:33: ( . )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0=='\n'||LA2_0=='\r') ) {
							alt2=2;
						}
						else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:144:33: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop2;
						}
					}

					if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
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
	// $ANTLR end "Comments"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:4: ( ( ' ' | '\\t' | '\\n' | 'r' ) )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:146:6: ( ' ' | '\\t' | '\\n' | 'r' )
			{
			if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)==' '||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:5: ( ( '0' .. '9' )+ )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:7: ( '0' .. '9' )+
			{
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:148:7: ( '0' .. '9' )+
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
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
	// $ANTLR end "Int"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:5: ( ( 'true' | 'false' ) )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:7: ( 'true' | 'false' )
			{
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:7: ( 'true' | 'false' )
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
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:8: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:150:17: 'false'
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

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:152:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:152:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:152:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
					break loop6;
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

	// $ANTLR start "String_literal"
	public final void mString_literal() throws RecognitionException {
		try {
			int _type = String_literal;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:16: ( '\"' ( . )* '\"' )
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:18: '\"' ( . )* '\"'
			{
			match('\"'); 
			// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:22: ( . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\"') ) {
					alt7=2;
				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:154:22: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
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
	// $ANTLR end "String_literal"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | Comments | WS | Int | Bool | Ident | String_literal )
		int alt8=26;
		switch ( input.LA(1) ) {
		case '!':
			{
			int LA8_1 = input.LA(2);
			if ( (LA8_1=='=') ) {
				alt8=2;
			}

			else {
				alt8=1;
			}

			}
			break;
		case '&':
			{
			alt8=3;
			}
			break;
		case '(':
			{
			alt8=4;
			}
			break;
		case ')':
			{
			alt8=5;
			}
			break;
		case '*':
			{
			alt8=6;
			}
			break;
		case '+':
			{
			alt8=7;
			}
			break;
		case '-':
			{
			alt8=8;
			}
			break;
		case '/':
			{
			int LA8_8 = input.LA(2);
			if ( (LA8_8=='*'||LA8_8=='/') ) {
				alt8=21;
			}

			else {
				alt8=9;
			}

			}
			break;
		case ':':
			{
			alt8=10;
			}
			break;
		case '<':
			{
			int LA8_10 = input.LA(2);
			if ( (LA8_10=='=') ) {
				alt8=12;
			}

			else {
				alt8=11;
			}

			}
			break;
		case '=':
			{
			alt8=13;
			}
			break;
		case '>':
			{
			int LA8_12 = input.LA(2);
			if ( (LA8_12=='=') ) {
				alt8=15;
			}

			else {
				alt8=14;
			}

			}
			break;
		case 'f':
			{
			switch ( input.LA(2) ) {
			case 'o':
				{
				int LA8_32 = input.LA(3);
				if ( (LA8_32=='r') ) {
					int LA8_36 = input.LA(4);
					if ( (LA8_36=='m') ) {
						int LA8_40 = input.LA(5);
						if ( ((LA8_40 >= '0' && LA8_40 <= '9')||(LA8_40 >= 'A' && LA8_40 <= 'Z')||LA8_40=='_'||(LA8_40 >= 'a' && LA8_40 <= 'z')) ) {
							alt8=25;
						}

						else {
							alt8=16;
						}

					}

					else {
						alt8=25;
					}

				}

				else {
					alt8=25;
				}

				}
				break;
			case 'a':
				{
				int LA8_33 = input.LA(3);
				if ( (LA8_33=='l') ) {
					int LA8_37 = input.LA(4);
					if ( (LA8_37=='s') ) {
						int LA8_41 = input.LA(5);
						if ( (LA8_41=='e') ) {
							int LA8_44 = input.LA(6);
							if ( ((LA8_44 >= '0' && LA8_44 <= '9')||(LA8_44 >= 'A' && LA8_44 <= 'Z')||LA8_44=='_'||(LA8_44 >= 'a' && LA8_44 <= 'z')) ) {
								alt8=25;
							}

							else {
								alt8=24;
							}

						}

						else {
							alt8=25;
						}

					}

					else {
						alt8=25;
					}

				}

				else {
					alt8=25;
				}

				}
				break;
			default:
				alt8=25;
			}
			}
			break;
		case 'i':
			{
			int LA8_14 = input.LA(2);
			if ( (LA8_14=='f') ) {
				int LA8_34 = input.LA(3);
				if ( ((LA8_34 >= '0' && LA8_34 <= '9')||(LA8_34 >= 'A' && LA8_34 <= 'Z')||LA8_34=='_'||(LA8_34 >= 'a' && LA8_34 <= 'z')) ) {
					alt8=25;
				}

				else {
					alt8=17;
				}

			}

			else {
				alt8=25;
			}

			}
			break;
		case '{':
			{
			alt8=18;
			}
			break;
		case '|':
			{
			alt8=19;
			}
			break;
		case '}':
			{
			alt8=20;
			}
			break;
		case 'r':
			{
			int LA8_18 = input.LA(2);
			if ( ((LA8_18 >= '0' && LA8_18 <= '9')||(LA8_18 >= 'A' && LA8_18 <= 'Z')||LA8_18=='_'||(LA8_18 >= 'a' && LA8_18 <= 'z')) ) {
				alt8=25;
			}

			else {
				alt8=22;
			}

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
			alt8=23;
			}
			break;
		case 't':
			{
			int LA8_20 = input.LA(2);
			if ( (LA8_20=='r') ) {
				int LA8_35 = input.LA(3);
				if ( (LA8_35=='u') ) {
					int LA8_39 = input.LA(4);
					if ( (LA8_39=='e') ) {
						int LA8_42 = input.LA(5);
						if ( ((LA8_42 >= '0' && LA8_42 <= '9')||(LA8_42 >= 'A' && LA8_42 <= 'Z')||LA8_42=='_'||(LA8_42 >= 'a' && LA8_42 <= 'z')) ) {
							alt8=25;
						}

						else {
							alt8=24;
						}

					}

					else {
						alt8=25;
					}

				}

				else {
					alt8=25;
				}

			}

			else {
				alt8=25;
			}

			}
			break;
		case '\t':
		case '\n':
		case ' ':
			{
			alt8=22;
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
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 's':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt8=25;
			}
			break;
		case '\"':
			{
			alt8=26;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 8, 0, input);
			throw nvae;
		}
		switch (alt8) {
			case 1 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__10
				{
				mT__10(); 

				}
				break;
			case 2 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__11
				{
				mT__11(); 

				}
				break;
			case 3 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__12
				{
				mT__12(); 

				}
				break;
			case 4 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__13
				{
				mT__13(); 

				}
				break;
			case 5 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__14
				{
				mT__14(); 

				}
				break;
			case 6 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__15
				{
				mT__15(); 

				}
				break;
			case 7 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__16
				{
				mT__16(); 

				}
				break;
			case 8 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__17
				{
				mT__17(); 

				}
				break;
			case 9 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__18
				{
				mT__18(); 

				}
				break;
			case 10 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__19
				{
				mT__19(); 

				}
				break;
			case 11 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__20
				{
				mT__20(); 

				}
				break;
			case 12 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__21
				{
				mT__21(); 

				}
				break;
			case 13 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__22
				{
				mT__22(); 

				}
				break;
			case 14 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__23
				{
				mT__23(); 

				}
				break;
			case 15 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__24
				{
				mT__24(); 

				}
				break;
			case 16 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__25
				{
				mT__25(); 

				}
				break;
			case 17 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: T__26
				{
				mT__26(); 

				}
				break;
			case 18 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:112: T__27
				{
				mT__27(); 

				}
				break;
			case 19 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:118: T__28
				{
				mT__28(); 

				}
				break;
			case 20 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:124: T__29
				{
				mT__29(); 

				}
				break;
			case 21 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:130: Comments
				{
				mComments(); 

				}
				break;
			case 22 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:139: WS
				{
				mWS(); 

				}
				break;
			case 23 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:142: Int
				{
				mInt(); 

				}
				break;
			case 24 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:146: Bool
				{
				mBool(); 

				}
				break;
			case 25 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:151: Ident
				{
				mIdent(); 

				}
				break;
			case 26 :
				// C:\\Users\\User\\Desktop\\software engineering\\software construction\\GitHub\\sea-of-ql\\dimitriskyr\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:157: String_literal
				{
				mString_literal(); 

				}
				break;

		}
	}



}
