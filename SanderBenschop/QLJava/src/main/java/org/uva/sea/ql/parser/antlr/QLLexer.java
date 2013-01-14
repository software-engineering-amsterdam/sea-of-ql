// $ANTLR 3.5 /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g 2013-01-14 21:06:43

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int BRACE_CLOSE=4;
	public static final int BRACE_OPEN=5;
	public static final int Bool=6;
	public static final int COMMENT=7;
	public static final int Datatype=8;
	public static final int EscapedCharacterSequence=9;
	public static final int FORM=10;
	public static final int Ident=11;
	public static final int Int=12;
	public static final int PAREN_CLOSE=13;
	public static final int PAREN_OPEN=14;
	public static final int Str=15;
	public static final int WS=16;

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
	@Override public String getGrammarFileName() { return "/Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '*' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:9:9: '*'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( '+' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:10:9: '+'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '-' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:11:9: '-'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '/' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:12:9: '/'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( ':' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:13:9: ':'
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '<' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:14:9: '<'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '<=' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:15:9: '<='
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '==' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:16:9: '=='
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '>' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:17:9: '>'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '>=' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:18:9: '>='
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( 'else' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:19:9: 'else'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( 'if' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:20:9: 'if'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '||' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:21:9: '||'
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
	// $ANTLR end "T__32"

	// $ANTLR start "FORM"
	public final void mFORM() throws RecognitionException {
		try {
			int _type = FORM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:163:6: ( 'form' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:163:8: 'form'
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

	// $ANTLR start "BRACE_OPEN"
	public final void mBRACE_OPEN() throws RecognitionException {
		try {
			int _type = BRACE_OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:165:12: ( '{' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:165:14: '{'
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
	// $ANTLR end "BRACE_OPEN"

	// $ANTLR start "BRACE_CLOSE"
	public final void mBRACE_CLOSE() throws RecognitionException {
		try {
			int _type = BRACE_CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:13: ( '}' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:166:15: '}'
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
	// $ANTLR end "BRACE_CLOSE"

	// $ANTLR start "PAREN_OPEN"
	public final void mPAREN_OPEN() throws RecognitionException {
		try {
			int _type = PAREN_OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:167:12: ( '(' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:167:14: '('
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
	// $ANTLR end "PAREN_OPEN"

	// $ANTLR start "PAREN_CLOSE"
	public final void mPAREN_CLOSE() throws RecognitionException {
		try {
			int _type = PAREN_CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:168:13: ( ')' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:168:15: ')'
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
	// $ANTLR end "PAREN_CLOSE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:170:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:170:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:174:5: ( '/*' ( . )* '*/' | '//' (~ ( '\\n' ) )* )
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:174:7: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:174:12: ( . )*
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
							// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:174:12: .
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:175:7: '//' (~ ( '\\n' ) )*
					{
					match("//"); 

					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:175:12: (~ ( '\\n' ) )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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

	// $ANTLR start "Datatype"
	public final void mDatatype() throws RecognitionException {
		try {
			int _type = Datatype;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:178:9: ( 'boolean' | 'string' | 'int' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case 'b':
				{
				alt4=1;
				}
				break;
			case 's':
				{
				alt4=2;
				}
				break;
			case 'i':
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:178:11: 'boolean'
					{
					match("boolean"); 

					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:178:23: 'string'
					{
					match("string"); 

					}
					break;
				case 3 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:178:34: 'int'
					{
					match("int"); 

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
	// $ANTLR end "Datatype"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:180:5: ( 'true' | 'false' )
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:180:7: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:180:16: 'false'
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
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:181:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:181:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:181:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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

	// $ANTLR start "Str"
	public final void mStr() throws RecognitionException {
		try {
			int _type = Str;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:183:4: ( '\"' ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )* '\"' )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:183:6: '\"' ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:183:10: ( EscapedCharacterSequence |~ ( '\\\\' | '\"' ) )*
			loop7:
			while (true) {
				int alt7=3;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\\') ) {
					alt7=1;
				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
					alt7=2;
				}

				switch (alt7) {
				case 1 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:183:11: EscapedCharacterSequence
					{
					mEscapedCharacterSequence(); 

					}
					break;
				case 2 :
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:183:38: ~ ( '\\\\' | '\"' )
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
	// $ANTLR end "Str"

	// $ANTLR start "EscapedCharacterSequence"
	public final void mEscapedCharacterSequence() throws RecognitionException {
		try {
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:186:25: ( '\\\\' ( '\\\"' | '\\\\' ) )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:186:27: '\\\\' ( '\\\"' | '\\\\' )
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

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:187:4: ( ( '0' .. '9' )+ )
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:187:6: ( '0' .. '9' )+
			{
			// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:187:6: ( '0' .. '9' )+
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
					// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:
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
		// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | FORM | BRACE_OPEN | BRACE_CLOSE | PAREN_OPEN | PAREN_CLOSE | WS | COMMENT | Datatype | Bool | Ident | Str | Int )
		int alt9=28;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__17
				{
				mT__17(); 

				}
				break;
			case 2 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__18
				{
				mT__18(); 

				}
				break;
			case 3 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__19
				{
				mT__19(); 

				}
				break;
			case 4 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__20
				{
				mT__20(); 

				}
				break;
			case 5 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__21
				{
				mT__21(); 

				}
				break;
			case 6 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__22
				{
				mT__22(); 

				}
				break;
			case 7 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__23
				{
				mT__23(); 

				}
				break;
			case 8 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__24
				{
				mT__24(); 

				}
				break;
			case 9 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__25
				{
				mT__25(); 

				}
				break;
			case 10 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__26
				{
				mT__26(); 

				}
				break;
			case 11 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__27
				{
				mT__27(); 

				}
				break;
			case 12 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__28
				{
				mT__28(); 

				}
				break;
			case 13 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__29
				{
				mT__29(); 

				}
				break;
			case 14 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__30
				{
				mT__30(); 

				}
				break;
			case 15 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__31
				{
				mT__31(); 

				}
				break;
			case 16 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__32
				{
				mT__32(); 

				}
				break;
			case 17 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:106: FORM
				{
				mFORM(); 

				}
				break;
			case 18 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:111: BRACE_OPEN
				{
				mBRACE_OPEN(); 

				}
				break;
			case 19 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:122: BRACE_CLOSE
				{
				mBRACE_CLOSE(); 

				}
				break;
			case 20 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:134: PAREN_OPEN
				{
				mPAREN_OPEN(); 

				}
				break;
			case 21 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:145: PAREN_CLOSE
				{
				mPAREN_CLOSE(); 

				}
				break;
			case 22 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:157: WS
				{
				mWS(); 

				}
				break;
			case 23 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:160: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 24 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:168: Datatype
				{
				mDatatype(); 

				}
				break;
			case 25 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:177: Bool
				{
				mBool(); 

				}
				break;
			case 26 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:182: Ident
				{
				mIdent(); 

				}
				break;
			case 27 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:188: Str
				{
				mStr(); 

				}
				break;
			case 28 :
				// /Users/benschop/Documents/workspace/studie/sea-of-ql/SanderBenschop/QLJava/src/main/java/org/uva/sea/ql/parser/antlr/QL.g:1:192: Int
				{
				mInt(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\1\uffff\1\33\4\uffff\1\35\1\uffff\1\37\1\uffff\1\41\2\27\1\uffff\1\27"+
		"\5\uffff\3\27\13\uffff\1\27\1\53\7\27\1\uffff\1\63\5\27\1\71\1\uffff\1"+
		"\72\3\27\1\76\2\uffff\1\76\2\27\1\uffff\1\27\2\63";
	static final String DFA9_eofS =
		"\102\uffff";
	static final String DFA9_minS =
		"\1\11\1\75\4\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\154\1\146\1\uffff"+
		"\1\141\5\uffff\1\157\1\164\1\162\13\uffff\1\163\1\60\1\164\1\162\1\154"+
		"\1\157\1\162\1\165\1\145\1\uffff\1\60\1\155\1\163\1\154\1\151\1\145\1"+
		"\60\1\uffff\1\60\2\145\1\156\1\60\2\uffff\1\60\1\141\1\147\1\uffff\1\156"+
		"\2\60";
	static final String DFA9_maxS =
		"\1\175\1\75\4\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\154\1\156\1\uffff"+
		"\1\157\5\uffff\1\157\1\164\1\162\13\uffff\1\163\1\172\1\164\1\162\1\154"+
		"\1\157\1\162\1\165\1\145\1\uffff\1\172\1\155\1\163\1\154\1\151\1\145\1"+
		"\172\1\uffff\1\172\2\145\1\156\1\172\2\uffff\1\172\1\141\1\147\1\uffff"+
		"\1\156\2\172";
	static final String DFA9_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\uffff\1\10\1\uffff\1\13\3\uffff\1\20\1\uffff"+
		"\1\22\1\23\1\24\1\25\1\26\3\uffff\1\32\1\33\1\34\1\2\1\1\1\27\1\7\1\12"+
		"\1\11\1\15\1\14\11\uffff\1\17\7\uffff\1\30\5\uffff\1\16\1\21\3\uffff\1"+
		"\31\3\uffff";
	static final String DFA9_specialS =
		"\102\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\23\2\uffff\1\23\22\uffff\1\23\1\1\1\30\3\uffff\1\2\1\uffff\1\21\1"+
			"\22\1\3\1\4\1\uffff\1\5\1\uffff\1\6\12\31\1\7\1\uffff\1\10\1\11\1\12"+
			"\2\uffff\32\27\6\uffff\1\27\1\24\2\27\1\13\1\16\2\27\1\14\11\27\1\25"+
			"\1\26\6\27\1\17\1\15\1\20",
			"\1\32",
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
			"\1\43\7\uffff\1\44",
			"",
			"\1\46\15\uffff\1\45",
			"",
			"",
			"",
			"",
			"",
			"\1\47",
			"\1\50",
			"\1\51",
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
			"\1\52",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\73",
			"\1\74",
			"\1\75",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\77",
			"\1\100",
			"",
			"\1\101",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27"
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | FORM | BRACE_OPEN | BRACE_CLOSE | PAREN_OPEN | PAREN_CLOSE | WS | COMMENT | Datatype | Bool | Ident | Str | Int );";
		}
	}

}
