// $ANTLR 3.5 C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g 2013-01-16 21:02:29

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
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int Money=8;
	public static final int String=9;
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
	@Override public String getGrammarFileName() { return "C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g"; }

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:6:7: ( '!' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:6:9: '!'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:7:7: ( '!=' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:7:9: '!='
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:8:7: ( '&&' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:8:9: '&&'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:9:7: ( '(' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:9:9: '('
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:10:7: ( ')' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:10:9: ')'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:11:7: ( '*' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:11:9: '*'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:12:7: ( '+' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:12:9: '+'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:13:7: ( '-' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:13:9: '-'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:14:7: ( '/' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:14:9: '/'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:15:7: ( ':' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:15:9: ':'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:16:7: ( '<' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:16:9: '<'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:17:7: ( '<=' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:17:9: '<='
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:18:7: ( '==' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:18:9: '=='
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:19:7: ( '>' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:19:9: '>'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:20:7: ( '>=' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:20:9: '>='
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:21:7: ( 'if' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:21:9: 'if'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:22:7: ( '{' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:22:9: '{'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:23:7: ( '||' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:23:9: '||'
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:7: ( '}' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:9: '}'
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:141:2: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:141:4: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:145:2: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( . )* '*/' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='/') ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1=='/') ) {
					alt4=1;
				}
				else if ( (LA4_1=='*') ) {
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
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:145:4: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:145:9: (~ ( '\\n' | '\\r' ) )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:
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
							break loop1;
						}
					}

					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:145:23: ( '\\r' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0=='\r') ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:145:23: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					 _channel=HIDDEN; 
					}
					break;
				case 2 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:146:4: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:146:9: ( . )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0=='*') ) {
							int LA3_1 = input.LA(2);
							if ( (LA3_1=='/') ) {
								alt3=2;
							}
							else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
								alt3=1;
							}

						}
						else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:146:9: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop3;
						}
					}

					match("*/"); 

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

	// $ANTLR start "Boolean"
	public final void mBoolean() throws RecognitionException {
		try {
			int _type = Boolean;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:150:2: ( 'boolean' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:150:4: 'boolean'
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
	// $ANTLR end "Boolean"

	// $ANTLR start "Money"
	public final void mMoney() throws RecognitionException {
		try {
			int _type = Money;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:154:2: ( 'money' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:154:4: 'money'
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
	// $ANTLR end "Money"

	// $ANTLR start "String"
	public final void mString() throws RecognitionException {
		try {
			int _type = String;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:158:2: ( '\"' ( . )* '\"' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:158:4: '\"' ( . )* '\"'
			{
			match('\"'); 
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:158:8: ( . )*
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
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:158:8: .
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
	// $ANTLR end "String"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:
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

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:166:2: ( ( '0' .. '9' )+ )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:166:4: ( '0' .. '9' )+
			{
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:166:4: ( '0' .. '9' )+
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
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:
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

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | WS | COMMENT | Boolean | Money | String | Ident | Int )
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
		case 'i':
			{
			int LA8_13 = input.LA(2);
			if ( (LA8_13=='f') ) {
				int LA8_31 = input.LA(3);
				if ( ((LA8_31 >= '0' && LA8_31 <= '9')||(LA8_31 >= 'A' && LA8_31 <= 'Z')||LA8_31=='_'||(LA8_31 >= 'a' && LA8_31 <= 'z')) ) {
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
			break;
		case '{':
			{
			alt8=17;
			}
			break;
		case '|':
			{
			alt8=18;
			}
			break;
		case '}':
			{
			alt8=19;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt8=20;
			}
			break;
		case 'b':
			{
			int LA8_18 = input.LA(2);
			if ( (LA8_18=='o') ) {
				int LA8_32 = input.LA(3);
				if ( (LA8_32=='o') ) {
					int LA8_35 = input.LA(4);
					if ( (LA8_35=='l') ) {
						int LA8_37 = input.LA(5);
						if ( (LA8_37=='e') ) {
							int LA8_39 = input.LA(6);
							if ( (LA8_39=='a') ) {
								int LA8_41 = input.LA(7);
								if ( (LA8_41=='n') ) {
									int LA8_43 = input.LA(8);
									if ( ((LA8_43 >= '0' && LA8_43 <= '9')||(LA8_43 >= 'A' && LA8_43 <= 'Z')||LA8_43=='_'||(LA8_43 >= 'a' && LA8_43 <= 'z')) ) {
										alt8=25;
									}

									else {
										alt8=22;
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
		case 'm':
			{
			int LA8_19 = input.LA(2);
			if ( (LA8_19=='o') ) {
				int LA8_33 = input.LA(3);
				if ( (LA8_33=='n') ) {
					int LA8_36 = input.LA(4);
					if ( (LA8_36=='e') ) {
						int LA8_38 = input.LA(5);
						if ( (LA8_38=='y') ) {
							int LA8_40 = input.LA(6);
							if ( ((LA8_40 >= '0' && LA8_40 <= '9')||(LA8_40 >= 'A' && LA8_40 <= 'Z')||LA8_40=='_'||(LA8_40 >= 'a' && LA8_40 <= 'z')) ) {
								alt8=25;
							}

							else {
								alt8=23;
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

			else {
				alt8=25;
			}

			}
			break;
		case '\"':
			{
			alt8=24;
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
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'j':
		case 'k':
		case 'l':
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
			alt8=25;
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
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:10: T__11
				{
				mT__11(); 

				}
				break;
			case 2 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:16: T__12
				{
				mT__12(); 

				}
				break;
			case 3 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:22: T__13
				{
				mT__13(); 

				}
				break;
			case 4 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:28: T__14
				{
				mT__14(); 

				}
				break;
			case 5 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:34: T__15
				{
				mT__15(); 

				}
				break;
			case 6 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:40: T__16
				{
				mT__16(); 

				}
				break;
			case 7 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:46: T__17
				{
				mT__17(); 

				}
				break;
			case 8 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:52: T__18
				{
				mT__18(); 

				}
				break;
			case 9 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:58: T__19
				{
				mT__19(); 

				}
				break;
			case 10 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:64: T__20
				{
				mT__20(); 

				}
				break;
			case 11 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:70: T__21
				{
				mT__21(); 

				}
				break;
			case 12 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:76: T__22
				{
				mT__22(); 

				}
				break;
			case 13 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:82: T__23
				{
				mT__23(); 

				}
				break;
			case 14 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:88: T__24
				{
				mT__24(); 

				}
				break;
			case 15 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:94: T__25
				{
				mT__25(); 

				}
				break;
			case 16 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:100: T__26
				{
				mT__26(); 

				}
				break;
			case 17 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:106: T__27
				{
				mT__27(); 

				}
				break;
			case 18 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:112: T__28
				{
				mT__28(); 

				}
				break;
			case 19 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:118: T__29
				{
				mT__29(); 

				}
				break;
			case 20 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:124: WS
				{
				mWS(); 

				}
				break;
			case 21 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:127: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 22 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:135: Boolean
				{
				mBoolean(); 

				}
				break;
			case 23 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:143: Money
				{
				mMoney(); 

				}
				break;
			case 24 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:149: String
				{
				mString(); 

				}
				break;
			case 25 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:156: Ident
				{
				mIdent(); 

				}
				break;
			case 26 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:162: Int
				{
				mInt(); 

				}
				break;

		}
	}



}
