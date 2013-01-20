// $ANTLR 3.5 C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g 2013-01-20 16:29:00

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
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int BOOLEAN=4;
	public static final int COMMENT=5;
	public static final int IDENT=6;
	public static final int INT=7;
	public static final int MONEY=8;
	public static final int STRING=9;
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:21:7: ( 'boolean' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:21:9: 'boolean'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:22:7: ( 'form' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:22:9: 'form'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:23:7: ( 'if' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:23:9: 'if'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:7: ( 'integer' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:24:9: 'integer'
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:25:7: ( 'money' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:25:9: 'money'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:26:7: ( 'string' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:26:9: 'string'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:27:7: ( '{' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:27:9: '{'
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:28:7: ( '||' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:28:9: '||'
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

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:29:7: ( '}' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:29:9: '}'
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
	// $ANTLR end "T__34"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:158:2: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:158:4: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:2: ( '//' ( . )* ( '\\r' )? '\\n' | '/*' ( . )* '*/' )
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
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:4: '//' ( . )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:9: ( . )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0=='\r') ) {
							alt1=2;
						}
						else if ( (LA1_0=='\n') ) {
							alt1=2;
						}
						else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:9: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop1;
						}
					}

					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:12: ( '\\r' )?
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0=='\r') ) {
						alt2=1;
					}
					switch (alt2) {
						case 1 :
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:162:12: '\\r'
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
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:163:4: '/*' ( . )* '*/'
					{
					match("/*"); 

					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:163:9: ( . )*
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
							// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:163:9: .
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

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:167:2: ( '\"' ( . )* '\"' )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:167:4: '\"' ( . )* '\"'
			{
			match('\"'); 
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:167:8: ( . )*
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
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:167:8: .
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

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:171:2: ( 'true' | 'false' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='t') ) {
				alt6=1;
			}
			else if ( (LA6_0=='f') ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:171:4: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:172:4: 'false'
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
	// $ANTLR end "BOOLEAN"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:176:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:176:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:176:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
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
	// $ANTLR end "IDENT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:180:2: ( ( '0' .. '9' )+ )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:180:4: ( '0' .. '9' )+
			{
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:180:4: ( '0' .. '9' )+
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
	// $ANTLR end "INT"

	// $ANTLR start "MONEY"
	public final void mMONEY() throws RecognitionException {
		try {
			int _type = MONEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:184:2: ( ( '0' .. '9' )+ '.' ( '0' .. '9' ) ( '0' .. '9' ) )
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:184:4: ( '0' .. '9' )+ '.' ( '0' .. '9' ) ( '0' .. '9' )
			{
			// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:184:4: ( '0' .. '9' )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
					alt9=1;
				}

				switch (alt9) {
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
					if ( cnt9 >= 1 ) break loop9;
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			match('.'); 
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
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
	// $ANTLR end "MONEY"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | WS | COMMENT | STRING | BOOLEAN | IDENT | INT | MONEY )
		int alt10=31;
		alt10 = dfa10.predict(input);
		switch (alt10) {
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
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:124: T__30
				{
				mT__30(); 

				}
				break;
			case 21 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:130: T__31
				{
				mT__31(); 

				}
				break;
			case 22 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:136: T__32
				{
				mT__32(); 

				}
				break;
			case 23 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:142: T__33
				{
				mT__33(); 

				}
				break;
			case 24 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:148: T__34
				{
				mT__34(); 

				}
				break;
			case 25 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:154: WS
				{
				mWS(); 

				}
				break;
			case 26 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:157: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 27 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:165: STRING
				{
				mSTRING(); 

				}
				break;
			case 28 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:172: BOOLEAN
				{
				mBOOLEAN(); 

				}
				break;
			case 29 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:180: IDENT
				{
				mIDENT(); 

				}
				break;
			case 30 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:186: INT
				{
				mINT(); 

				}
				break;
			case 31 :
				// C:\\Users\\Laurens.ZORGNED\\Desktop\\ANTLR\\Prototype(2)\\QL.g:1:190: MONEY
				{
				mMONEY(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\1\uffff\1\33\6\uffff\1\35\1\uffff\1\37\1\uffff\1\41\5\30\5\uffff\1\30"+
		"\1\uffff\1\52\10\uffff\3\30\1\57\4\30\2\uffff\3\30\1\uffff\5\30\1\74\4"+
		"\30\1\101\1\30\1\uffff\1\101\1\30\1\104\1\30\1\uffff\2\30\1\uffff\1\110"+
		"\1\111\1\112\3\uffff";
	static final String DFA10_eofS =
		"\113\uffff";
	static final String DFA10_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\157\1\141\1\146\1"+
		"\157\1\164\5\uffff\1\162\1\uffff\1\56\10\uffff\1\157\1\162\1\154\1\60"+
		"\1\164\1\156\1\162\1\165\2\uffff\1\154\1\155\1\163\1\uffff\2\145\1\151"+
		"\2\145\1\60\1\145\1\147\1\171\1\156\1\60\1\141\1\uffff\1\60\1\145\1\60"+
		"\1\147\1\uffff\1\156\1\162\1\uffff\3\60\3\uffff";
	static final String DFA10_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\2\157\1\156\1\157\1"+
		"\164\5\uffff\1\162\1\uffff\1\71\10\uffff\1\157\1\162\1\154\1\172\1\164"+
		"\1\156\1\162\1\165\2\uffff\1\154\1\155\1\163\1\uffff\2\145\1\151\2\145"+
		"\1\172\1\145\1\147\1\171\1\156\1\172\1\141\1\uffff\1\172\1\145\1\172\1"+
		"\147\1\uffff\1\156\1\162\1\uffff\3\172\3\uffff";
	static final String DFA10_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\6\uffff\1"+
		"\26\1\27\1\30\1\31\1\33\1\uffff\1\35\1\uffff\1\2\1\1\1\32\1\11\1\14\1"+
		"\13\1\17\1\16\10\uffff\1\36\1\37\3\uffff\1\22\14\uffff\1\21\4\uffff\1"+
		"\34\2\uffff\1\24\3\uffff\1\25\1\20\1\23";
	static final String DFA10_specialS =
		"\113\uffff}>";
	static final String[] DFA10_transitionS = {
			"\2\25\2\uffff\1\25\22\uffff\1\25\1\1\1\26\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\31\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\30\6\uffff\1\30\1\15\3\30\1\16\2\30\1\17\3\30\1\20\5\30\1\21"+
			"\1\27\6\30\1\22\1\23\1\24",
			"\1\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\34\4\uffff\1\34",
			"",
			"\1\36",
			"",
			"\1\40",
			"\1\42",
			"\1\44\15\uffff\1\43",
			"\1\45\7\uffff\1\46",
			"\1\47",
			"\1\50",
			"",
			"",
			"",
			"",
			"",
			"\1\51",
			"",
			"\1\53\1\uffff\12\31",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\54",
			"\1\55",
			"\1\56",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"",
			"",
			"\1\64",
			"\1\65",
			"\1\66",
			"",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\102",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\103",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\105",
			"",
			"\1\106",
			"\1\107",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			""
	};

	static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
	static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
	static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
	static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
	static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
	static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
	static final short[][] DFA10_transition;

	static {
		int numStates = DFA10_transitionS.length;
		DFA10_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
		}
	}

	protected class DFA10 extends DFA {

		public DFA10(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 10;
			this.eot = DFA10_eot;
			this.eof = DFA10_eof;
			this.min = DFA10_min;
			this.max = DFA10_max;
			this.accept = DFA10_accept;
			this.special = DFA10_special;
			this.transition = DFA10_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | WS | COMMENT | STRING | BOOLEAN | IDENT | INT | MONEY );";
		}
	}

}
