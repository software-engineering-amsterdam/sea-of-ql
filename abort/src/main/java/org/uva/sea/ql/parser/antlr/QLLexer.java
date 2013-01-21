// $ANTLR 3.5 /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 14:12:55

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int BLOCK_END=4;
	public static final int BLOCK_START=5;
	public static final int Bool=6;
	public static final int COMMENT=7;
	public static final int ELSE=8;
	public static final int EscapedCharacterSequence=9;
	public static final int FORM=10;
	public static final int IF=11;
	public static final int Ident=12;
	public static final int Int=13;
	public static final int Money=14;
	public static final int PARENTHESES_CLOSE=15;
	public static final int PARENTHESES_OPEN=16;
	public static final int String=17;
	public static final int Type=18;
	public static final int WS=19;



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
	@Override public String getGrammarFileName() { return "/Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '!' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:8:9: '!'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '!=' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:9:9: '!='
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( '&&' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:10:9: '&&'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( ':' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:15:9: ':'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<=' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<='
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '==' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:18:9: '=='
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>=' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>='
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '||' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:21:9: '||'
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
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:143:6: ( '/*' ( . )* '*/' | '//' (~ ( '\\n' | '\\r' ) )* )
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:143:8: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:143:13: ( . )*
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
							// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:143:13: .
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:144:8: '//' (~ ( '\\n' | '\\r' ) )*
					{
					match("//"); 

					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:144:13: (~ ( '\\n' | '\\r' ) )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:147:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:147:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:149:3: ( 'if' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:149:5: 'if'
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
	// $ANTLR end "IF"

	// $ANTLR start "PARENTHESES_OPEN"
	public final void mPARENTHESES_OPEN() throws RecognitionException {
		try {
			int _type = PARENTHESES_OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:150:17: ( '(' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:150:19: '('
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
	// $ANTLR end "PARENTHESES_OPEN"

	// $ANTLR start "PARENTHESES_CLOSE"
	public final void mPARENTHESES_CLOSE() throws RecognitionException {
		try {
			int _type = PARENTHESES_CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:151:18: ( ')' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:151:20: ')'
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
	// $ANTLR end "PARENTHESES_CLOSE"

	// $ANTLR start "BLOCK_START"
	public final void mBLOCK_START() throws RecognitionException {
		try {
			int _type = BLOCK_START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:152:12: ( '{' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:152:14: '{'
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
	// $ANTLR end "BLOCK_START"

	// $ANTLR start "BLOCK_END"
	public final void mBLOCK_END() throws RecognitionException {
		try {
			int _type = BLOCK_END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:153:10: ( '}' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:153:12: '}'
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
	// $ANTLR end "BLOCK_END"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:154:5: ( 'else' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:154:7: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "FORM"
	public final void mFORM() throws RecognitionException {
		try {
			int _type = FORM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:156:5: ( 'form' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:156:7: 'form'
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
	// $ANTLR end "FORM"

	// $ANTLR start "Type"
	public final void mType() throws RecognitionException {
		try {
			int _type = Type;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:5: ( 'boolean' | 'integer' | 'money' | 'string' )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 'b':
				{
				alt4=1;
				}
				break;
			case 'i':
				{
				alt4=2;
				}
				break;
			case 'm':
				{
				alt4=3;
				}
				break;
			case 's':
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:7: 'boolean'
					{
					match("boolean"); 

					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:19: 'integer'
					{
					match("integer"); 

					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:31: 'money'
					{
					match("money"); 

					}
					break;
				case 4 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:158:41: 'string'
					{
					match("string"); 

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

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:160:5: ( 'TRUE' | 'FALSE' | 'true' | 'false' )
			int alt5=4;
			switch ( input.LA(1) ) {
			case 'T':
				{
				alt5=1;
				}
				break;
			case 'F':
				{
				alt5=2;
				}
				break;
			case 't':
				{
				alt5=3;
				}
				break;
			case 'f':
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:160:7: 'TRUE'
					{
					match("TRUE"); 

					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:160:16: 'FALSE'
					{
					match("FALSE"); 

					}
					break;
				case 3 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:160:26: 'true'
					{
					match("true"); 

					}
					break;
				case 4 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:160:35: 'false'
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

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:162:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:162:8: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:162:27: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:164:4: ( ( '0' .. '9' )+ )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:164:6: ( '0' .. '9' )+
			{
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:164:6: ( '0' .. '9' )+
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:6: ( ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )? )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:8: ( '0' .. '9' )+ ( '.' ( '0' .. '9' )+ )?
			{
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:8: ( '0' .. '9' )+
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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

			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:20: ( '.' ( '0' .. '9' )+ )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='.') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:21: '.' ( '0' .. '9' )+
					{
					match('.'); 
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:25: ( '0' .. '9' )+
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
							// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:168:7: ( '\"' ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )* '\"' )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:168:9: '\"' ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:168:13: ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )*
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
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:168:14: EscapedCharacterSequence
					{
					mEscapedCharacterSequence(); 

					}
					break;
				case 2 :
					// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:168:41: ~ ( '\\\\' | '\"' )
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
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:171:25: ( '\\\\' ( '\\\"' | '\\\\' ) )
			// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:171:27: '\\\\' ( '\\\"' | '\\\\' )
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
		// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | COMMENT | WS | IF | PARENTHESES_OPEN | PARENTHESES_CLOSE | BLOCK_START | BLOCK_END | ELSE | FORM | Type | Bool | Ident | Int | Money | String )
		int alt12=29;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__20
				{
				mT__20(); 

				}
				break;
			case 2 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__21
				{
				mT__21(); 

				}
				break;
			case 3 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__22
				{
				mT__22(); 

				}
				break;
			case 4 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__23
				{
				mT__23(); 

				}
				break;
			case 5 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__24
				{
				mT__24(); 

				}
				break;
			case 6 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__25
				{
				mT__25(); 

				}
				break;
			case 7 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__26
				{
				mT__26(); 

				}
				break;
			case 8 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__27
				{
				mT__27(); 

				}
				break;
			case 9 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__28
				{
				mT__28(); 

				}
				break;
			case 10 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__29
				{
				mT__29(); 

				}
				break;
			case 11 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__30
				{
				mT__30(); 

				}
				break;
			case 12 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__31
				{
				mT__31(); 

				}
				break;
			case 13 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__32
				{
				mT__32(); 

				}
				break;
			case 14 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__33
				{
				mT__33(); 

				}
				break;
			case 15 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:94: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 16 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:102: WS
				{
				mWS(); 

				}
				break;
			case 17 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:105: IF
				{
				mIF(); 

				}
				break;
			case 18 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:108: PARENTHESES_OPEN
				{
				mPARENTHESES_OPEN(); 

				}
				break;
			case 19 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:125: PARENTHESES_CLOSE
				{
				mPARENTHESES_CLOSE(); 

				}
				break;
			case 20 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:143: BLOCK_START
				{
				mBLOCK_START(); 

				}
				break;
			case 21 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:155: BLOCK_END
				{
				mBLOCK_END(); 

				}
				break;
			case 22 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:165: ELSE
				{
				mELSE(); 

				}
				break;
			case 23 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:170: FORM
				{
				mFORM(); 

				}
				break;
			case 24 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:175: Type
				{
				mType(); 

				}
				break;
			case 25 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:180: Bool
				{
				mBool(); 

				}
				break;
			case 26 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:185: Ident
				{
				mIdent(); 

				}
				break;
			case 27 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:191: Int
				{
				mInt(); 

				}
				break;
			case 28 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:195: Money
				{
				mMoney(); 

				}
				break;
			case 29 :
				// /Users/jdijkstra/Documents/UvA/Software Construction/git/abort/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:201: String
				{
				mString(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\1\uffff\1\36\4\uffff\1\40\1\uffff\1\42\1\uffff\1\44\2\uffff\1\32\4\uffff"+
		"\10\32\1\uffff\1\60\11\uffff\1\62\12\32\3\uffff\13\32\1\110\1\111\4\32"+
		"\1\116\1\32\1\116\1\32\2\uffff\1\116\1\32\1\122\1\32\1\uffff\1\116\2\32"+
		"\1\uffff\3\122";
	static final String DFA12_eofS =
		"\126\uffff";
	static final String DFA12_minS =
		"\1\11\1\75\4\uffff\1\52\1\uffff\1\75\1\uffff\1\75\2\uffff\1\146\4\uffff"+
		"\1\154\1\141\2\157\1\164\1\122\1\101\1\162\1\uffff\1\56\11\uffff\1\60"+
		"\1\164\1\163\1\162\1\154\1\157\1\156\1\162\1\125\1\114\1\165\3\uffff\2"+
		"\145\1\155\1\163\1\154\1\145\1\151\1\105\1\123\1\145\1\147\2\60\2\145"+
		"\1\171\1\156\1\60\1\105\1\60\1\145\2\uffff\1\60\1\141\1\60\1\147\1\uffff"+
		"\1\60\1\162\1\156\1\uffff\3\60";
	static final String DFA12_maxS =
		"\1\175\1\75\4\uffff\1\57\1\uffff\1\75\1\uffff\1\75\2\uffff\1\156\4\uffff"+
		"\1\154\3\157\1\164\1\122\1\101\1\162\1\uffff\1\71\11\uffff\1\172\1\164"+
		"\1\163\1\162\1\154\1\157\1\156\1\162\1\125\1\114\1\165\3\uffff\2\145\1"+
		"\155\1\163\1\154\1\145\1\151\1\105\1\123\1\145\1\147\2\172\2\145\1\171"+
		"\1\156\1\172\1\105\1\172\1\145\2\uffff\1\172\1\141\1\172\1\147\1\uffff"+
		"\1\172\1\162\1\156\1\uffff\3\172";
	static final String DFA12_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\10\1\uffff\1\13\1\uffff\1\16\1\20\1"+
		"\uffff\1\22\1\23\1\24\1\25\10\uffff\1\32\1\uffff\1\35\1\2\1\1\1\17\1\7"+
		"\1\12\1\11\1\15\1\14\13\uffff\1\33\1\34\1\21\25\uffff\1\26\1\27\4\uffff"+
		"\1\31\3\uffff\1\30\3\uffff";
	static final String DFA12_specialS =
		"\126\uffff}>";
	static final String[] DFA12_transitionS = {
			"\2\14\2\uffff\1\14\22\uffff\1\14\1\1\1\34\3\uffff\1\2\1\uffff\1\16\1"+
			"\17\1\3\1\4\1\uffff\1\5\1\uffff\1\6\12\33\1\7\1\uffff\1\10\1\11\1\12"+
			"\2\uffff\5\32\1\30\15\32\1\27\6\32\6\uffff\1\32\1\24\2\32\1\22\1\23\2"+
			"\32\1\15\3\32\1\25\5\32\1\26\1\31\6\32\1\20\1\13\1\21",
			"\1\35",
			"",
			"",
			"",
			"",
			"\1\37\4\uffff\1\37",
			"",
			"\1\41",
			"",
			"\1\43",
			"",
			"",
			"\1\45\7\uffff\1\46",
			"",
			"",
			"",
			"",
			"\1\47",
			"\1\51\15\uffff\1\50",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"",
			"\1\61\1\uffff\12\33",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"",
			"",
			"",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\117",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\120",
			"",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\121",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\123",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\124",
			"\1\125",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32"
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
			return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | COMMENT | WS | IF | PARENTHESES_OPEN | PARENTHESES_CLOSE | BLOCK_START | BLOCK_END | ELSE | FORM | Type | Bool | Ident | Int | Money | String );";
		}
	}

}
