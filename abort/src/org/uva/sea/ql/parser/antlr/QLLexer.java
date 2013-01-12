// $ANTLR 3.5 /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-12 17:28:15

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int Bool=4;
	public static final int COMMENT=5;
	public static final int EscapedCharacterSequence=6;
	public static final int Ident=7;
	public static final int Int=8;
	public static final int Money=9;
	public static final int String=10;
	public static final int Type=11;
	public static final int WS=12;

	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException(e.getMessage()); 
	  }


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
	@Override public String getGrammarFileName() { return "/Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '!' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '!'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '!=' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '!='
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '&&' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '&&'
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '(' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: '('
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( ')' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: ')'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '*' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '*'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '+' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '+'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '-' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '-'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '/' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '/'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '<' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '<'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( '<=' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: '<='
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( '==' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:23:9: '=='
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( '>' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:24:9: '>'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( '>=' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: '>='
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:26:7: ( 'if' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:26:9: 'if'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:27:7: ( '{' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:27:9: '{'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:28:7: ( '||' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:28:9: '||'
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:29:7: ( '}' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:29:9: '}'
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
	// $ANTLR end "T__30"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:121:6: ( '/*' ( . )* '*/' | '//' (~ ( '\\n' | '\\r' ) )* )
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:121:8: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:121:13: ( . )*
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
							// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:121:13: .
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:122:8: '//' (~ ( '\\n' | '\\r' ) )*
					{
					match("//"); 

					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:122:13: (~ ( '\\n' | '\\r' ) )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:125:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:125:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:132:5: ( ( 'TRUE' | 'FALSE' | 'true' | 'false' ) )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:132:7: ( 'TRUE' | 'FALSE' | 'true' | 'false' )
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:132:7: ( 'TRUE' | 'FALSE' | 'true' | 'false' )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 'T':
				{
				alt4=1;
				}
				break;
			case 'F':
				{
				alt4=2;
				}
				break;
			case 't':
				{
				alt4=3;
				}
				break;
			case 'f':
				{
				alt4=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:132:8: 'TRUE'
					{
					match("TRUE"); 

					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:132:17: 'FALSE'
					{
					match("FALSE"); 

					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:132:27: 'true'
					{
					match("true"); 

					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:132:36: 'false'
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

	// $ANTLR start "Type"
	public final void mType() throws RecognitionException {
		try {
			int _type = Type;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:134:5: ( 'string' | 'integer' | 'boolean' | 'money' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 's':
				{
				alt5=1;
				}
				break;
			case 'i':
				{
				alt5=2;
				}
				break;
			case 'b':
				{
				alt5=3;
				}
				break;
			case 'm':
				{
				alt5=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:134:7: 'string'
					{
					match("string"); 

					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:134:18: 'integer'
					{
					match("integer"); 

					}
					break;
				case 3 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:134:30: 'boolean'
					{
					match("boolean"); 

					}
					break;
				case 4 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:134:42: 'money'
					{
					match("money"); 

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
	// $ANTLR end "Type"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:136:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:136:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:136:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:4: ( ( '0' .. '9' )+ )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:6: ( '0' .. '9' )+
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:138:6: ( '0' .. '9' )+
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:
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

	// $ANTLR start "Money"
	public final void mMoney() throws RecognitionException {
		try {
			int _type = Money;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:140:6: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:140:8: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
			{
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:140:8: ( '0' .. '9' )+
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
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:
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

			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:140:20: ( '.' ( '0' .. '9' )+ )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='.') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:140:21: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:140:25: ( '0' .. '9' )+
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
							// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:
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
	// $ANTLR end "Money"

	// $ANTLR start "String"
	public final void mString() throws RecognitionException {
		try {
			int _type = String;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:145:7: ( '\"' ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )* '\"' )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:145:9: '\"' ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:145:13: ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )*
			loop11:
			while (true) {
				int alt11=3;
				int LA11_0 = input.LA(1);
				if ( (LA11_0=='\\') ) {
					alt11=1;
				}
				else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '[')||(LA11_0 >= ']' && LA11_0 <= '\uFFFF')) ) {
					alt11=2;
				}

				switch (alt11) {
				case 1 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:145:14: EscapedCharacterSequence
					{
					mEscapedCharacterSequence(); 

					}
					break;
				case 2 :
					// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:145:41: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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
					break loop11;
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

	// $ANTLR start "EscapedCharacterSequence"
	public final void mEscapedCharacterSequence() throws RecognitionException {
		try {
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:148:25: ( '\\\\' ( '\\\"' | '\\\\' ) )
			// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:148:27: '\\\\' ( '\\\"' | '\\\\' )
			{
			match('\\'); 
			if ( input.LA(1)=='\"'||input.LA(1)=='\\' ) {
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
	// $ANTLR end "EscapedCharacterSequence"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | COMMENT | WS | Bool | Type | Ident | Int | Money | String )
		int alt12=26;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__13
				{
				mT__13(); 

				}
				break;
			case 2 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__14
				{
				mT__14(); 

				}
				break;
			case 3 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__15
				{
				mT__15(); 

				}
				break;
			case 4 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__16
				{
				mT__16(); 

				}
				break;
			case 5 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__17
				{
				mT__17(); 

				}
				break;
			case 6 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__18
				{
				mT__18(); 

				}
				break;
			case 7 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__19
				{
				mT__19(); 

				}
				break;
			case 8 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__20
				{
				mT__20(); 

				}
				break;
			case 9 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__21
				{
				mT__21(); 

				}
				break;
			case 10 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__22
				{
				mT__22(); 

				}
				break;
			case 11 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__23
				{
				mT__23(); 

				}
				break;
			case 12 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__24
				{
				mT__24(); 

				}
				break;
			case 13 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__25
				{
				mT__25(); 

				}
				break;
			case 14 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__26
				{
				mT__26(); 

				}
				break;
			case 15 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__27
				{
				mT__27(); 

				}
				break;
			case 16 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__28
				{
				mT__28(); 

				}
				break;
			case 17 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__29
				{
				mT__29(); 

				}
				break;
			case 18 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__30
				{
				mT__30(); 

				}
				break;
			case 19 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:118: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 20 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:126: WS
				{
				mWS(); 

				}
				break;
			case 21 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:129: Bool
				{
				mBool(); 

				}
				break;
			case 22 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:134: Type
				{
				mType(); 

				}
				break;
			case 23 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:139: Ident
				{
				mIdent(); 

				}
				break;
			case 24 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:145: Int
				{
				mInt(); 

				}
				break;
			case 25 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:149: Money
				{
				mMoney(); 

				}
				break;
			case 26 :
				// /Users/abort/Documents/UvA/Repository/abort/src/org/uva/sea/ql/parser/antlr/QL.g:1:155: String
				{
				mString(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\1\uffff\1\34\6\uffff\1\36\1\40\1\uffff\1\42\1\30\4\uffff\7\30\1\uffff"+
		"\1\54\11\uffff\1\56\10\30\3\uffff\11\30\1\100\1\30\1\100\5\30\1\uffff"+
		"\2\100\2\30\1\111\1\30\1\111\1\30\1\uffff\2\111";
	static final String DFA12_eofS =
		"\114\uffff";
	static final String DFA12_minS =
		"\1\11\1\75\6\uffff\1\52\1\75\1\uffff\1\75\1\146\4\uffff\1\122\1\101\1"+
		"\162\1\141\1\164\2\157\1\uffff\1\56\11\uffff\1\60\1\164\1\125\1\114\1"+
		"\165\1\154\1\162\1\157\1\156\3\uffff\1\145\1\105\1\123\1\145\1\163\1\151"+
		"\1\154\1\145\1\147\1\60\1\105\1\60\1\145\1\156\1\145\1\171\1\145\1\uffff"+
		"\2\60\1\147\1\141\1\60\1\162\1\60\1\156\1\uffff\2\60";
	static final String DFA12_maxS =
		"\1\175\1\75\6\uffff\1\57\1\75\1\uffff\1\75\1\156\4\uffff\1\122\1\101\1"+
		"\162\1\141\1\164\2\157\1\uffff\1\71\11\uffff\1\172\1\164\1\125\1\114\1"+
		"\165\1\154\1\162\1\157\1\156\3\uffff\1\145\1\105\1\123\1\145\1\163\1\151"+
		"\1\154\1\145\1\147\1\172\1\105\1\172\1\145\1\156\1\145\1\171\1\145\1\uffff"+
		"\2\172\1\147\1\141\1\172\1\162\1\172\1\156\1\uffff\2\172";
	static final String DFA12_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\14\2\uffff\1\20\1\21\1\22"+
		"\1\24\7\uffff\1\27\1\uffff\1\32\1\2\1\1\1\23\1\11\1\13\1\12\1\16\1\15"+
		"\11\uffff\1\30\1\31\1\17\21\uffff\1\25\10\uffff\1\26\2\uffff";
	static final String DFA12_specialS =
		"\114\uffff}>";
	static final String[] DFA12_transitionS = {
			"\2\20\2\uffff\1\20\22\uffff\1\20\1\1\1\32\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\31\2\uffff\1\11\1\12\1\13\2\uffff"+
			"\5\30\1\22\15\30\1\21\6\30\6\uffff\1\30\1\26\3\30\1\24\2\30\1\14\3\30"+
			"\1\27\5\30\1\25\1\23\6\30\1\15\1\16\1\17",
			"\1\33",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\35\4\uffff\1\35",
			"\1\37",
			"",
			"\1\41",
			"\1\43\7\uffff\1\44",
			"",
			"",
			"",
			"",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"\1\53",
			"",
			"\1\55\1\uffff\12\31",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"",
			"",
			"",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\101",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\107",
			"\1\110",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\112",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\113",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30"
	};

	static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
	static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
	static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
	static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
	static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
	static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
	static final short[][] DFA12_transition;

	static {
		int numStates = DFA12_transitionS.length;
		DFA12_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
		}
	}

	protected class DFA12 extends DFA {

		public DFA12(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 12;
			this.eot = DFA12_eot;
			this.eof = DFA12_eof;
			this.min = DFA12_min;
			this.max = DFA12_max;
			this.accept = DFA12_accept;
			this.special = DFA12_special;
			this.transition = DFA12_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | COMMENT | WS | Bool | Type | Ident | Int | Money | String );";
		}
	}

}
