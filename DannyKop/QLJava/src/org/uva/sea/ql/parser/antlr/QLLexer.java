// $ANTLR 3.5 /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-02 15:04:57

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int Bool=4;
	public static final int Comment=5;
	public static final int Else=6;
	public static final int Form=7;
	public static final int Ident=8;
	public static final int If=9;
	public static final int Int=10;
	public static final int Money=11;
	public static final int SpecialChars=12;
	public static final int Str=13;
	public static final int WS=14;

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

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( ':' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: ':'
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '<' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '<'
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( '<=' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: '<='
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( '==' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:9: '=='
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( '>' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:9: '>'
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( '>=' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: '>='
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:7: ( 'boolean' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:9: 'boolean'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:7: ( 'int' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:27:9: 'int'
			{
			match("int"); 

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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:7: ( 'money' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:28:9: 'money'
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:7: ( 'string' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:29:9: 'string'
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
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:7: ( '{' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:30:9: '{'
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
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:7: ( '||' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:31:9: '||'
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
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:7: ( '}' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:32:9: '}'
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
	// $ANTLR end "T__36"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:3: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
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

	// $ANTLR start "Comment"
	public final void mComment() throws RecognitionException {
		try {
			int _type = Comment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:8: ( '/*' ( . )* '*/' | '//' (~ ( '\\n' | '\\r' ) )* )
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:10: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:15: ( . )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0=='*') ) {
							int LA2_1 = input.LA(2);
							if ( (LA2_1=='/') ) {
								alt2=2;
							}
							else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
								alt2=1;
							}

						}
						else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:15: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop2;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:11: '//' (~ ( '\\n' | '\\r' ) )*
					{
					match("//"); 

					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:150:17: (~ ( '\\n' | '\\r' ) )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
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
							break loop3;
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
	// $ANTLR end "Comment"

	// $ANTLR start "SpecialChars"
	public final void mSpecialChars() throws RecognitionException {
		try {
			int _type = SpecialChars;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:152:13: ( ( '!' | '?' | ',' | '.' | '<' | '>' | '=' | '+' | '-' | '[' | ']' | '|' | ':' | '/' | '\\\\' | '\\'' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
			{
			if ( input.LA(1)=='!'||input.LA(1)=='\''||(input.LA(1) >= '+' && input.LA(1) <= '/')||input.LA(1)==':'||(input.LA(1) >= '<' && input.LA(1) <= '?')||(input.LA(1) >= '[' && input.LA(1) <= ']')||input.LA(1)=='|' ) {
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
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:5: ( ( 'true' | 'false' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:7: ( 'true' | 'false' )
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:7: ( 'true' | 'false' )
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
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:8: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:154:17: 'false'
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

	// $ANTLR start "If"
	public final void mIf() throws RecognitionException {
		try {
			int _type = If;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:3: ( ( 'if' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:5: ( 'if' )
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:5: ( 'if' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:156:6: 'if'
			{
			match("if"); 

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "If"

	// $ANTLR start "Else"
	public final void mElse() throws RecognitionException {
		try {
			int _type = Else;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:158:5: ( ( 'else' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:158:7: ( 'else' )
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:158:7: ( 'else' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:158:8: 'else'
			{
			match("else"); 

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Else"

	// $ANTLR start "Form"
	public final void mForm() throws RecognitionException {
		try {
			int _type = Form;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:5: ( 'form' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:160:7: 'form'
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

	// $ANTLR start "Str"
	public final void mStr() throws RecognitionException {
		try {
			int _type = Str;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:4: ( '\"' ( Ident | WS | Int | SpecialChars )* '\"' )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:6: '\"' ( Ident | WS | Int | SpecialChars )* '\"'
			{
			match('\"'); 
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:10: ( Ident | WS | Int | SpecialChars )*
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
				case '\'':
				case '+':
				case ',':
				case '-':
				case '.':
				case '/':
				case ':':
				case '<':
				case '=':
				case '>':
				case '?':
				case '[':
				case '\\':
				case ']':
				case '|':
					{
					alt6=4;
					}
					break;
				}
				switch (alt6) {
				case 1 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:11: Ident
					{
					mIdent(); 

					}
					break;
				case 2 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:19: WS
					{
					mWS(); 

					}
					break;
				case 3 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:24: Int
					{
					mInt(); 

					}
					break;
				case 4 :
					// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:30: SpecialChars
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
	// $ANTLR end "Str"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:164:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:164:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:164:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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

	// $ANTLR start "Money"
	public final void mMoney() throws RecognitionException {
		try {
			int _type = Money;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:166:6: ( ( '0' .. '9' ) ',' ( '0' .. '9' ) ( '0' .. '9' ) )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:166:8: ( '0' .. '9' ) ',' ( '0' .. '9' ) ( '0' .. '9' )
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match(','); 
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
	// $ANTLR end "Money"

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:168:4: ( ( '0' .. '9' )+ )
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:168:6: ( '0' .. '9' )+
			{
			// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:168:6: ( '0' .. '9' )+
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
		// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | WS | Comment | SpecialChars | Bool | If | Else | Form | Str | Ident | Money | Int )
		int alt9=33;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__15
				{
				mT__15(); 

				}
				break;
			case 2 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__16
				{
				mT__16(); 

				}
				break;
			case 3 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__17
				{
				mT__17(); 

				}
				break;
			case 4 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__18
				{
				mT__18(); 

				}
				break;
			case 5 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__19
				{
				mT__19(); 

				}
				break;
			case 6 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__20
				{
				mT__20(); 

				}
				break;
			case 7 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__21
				{
				mT__21(); 

				}
				break;
			case 8 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__22
				{
				mT__22(); 

				}
				break;
			case 9 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__23
				{
				mT__23(); 

				}
				break;
			case 10 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__24
				{
				mT__24(); 

				}
				break;
			case 11 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__25
				{
				mT__25(); 

				}
				break;
			case 12 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__26
				{
				mT__26(); 

				}
				break;
			case 13 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__27
				{
				mT__27(); 

				}
				break;
			case 14 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__28
				{
				mT__28(); 

				}
				break;
			case 15 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__29
				{
				mT__29(); 

				}
				break;
			case 16 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__30
				{
				mT__30(); 

				}
				break;
			case 17 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__31
				{
				mT__31(); 

				}
				break;
			case 18 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__32
				{
				mT__32(); 

				}
				break;
			case 19 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__33
				{
				mT__33(); 

				}
				break;
			case 20 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:124: T__34
				{
				mT__34(); 

				}
				break;
			case 21 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:130: T__35
				{
				mT__35(); 

				}
				break;
			case 22 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:136: T__36
				{
				mT__36(); 

				}
				break;
			case 23 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:142: WS
				{
				mWS(); 

				}
				break;
			case 24 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:145: Comment
				{
				mComment(); 

				}
				break;
			case 25 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:153: SpecialChars
				{
				mSpecialChars(); 

				}
				break;
			case 26 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:166: Bool
				{
				mBool(); 

				}
				break;
			case 27 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:171: If
				{
				mIf(); 

				}
				break;
			case 28 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:174: Else
				{
				mElse(); 

				}
				break;
			case 29 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:179: Form
				{
				mForm(); 

				}
				break;
			case 30 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:184: Str
				{
				mStr(); 

				}
				break;
			case 31 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:188: Ident
				{
				mIdent(); 

				}
				break;
			case 32 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:194: Money
				{
				mMoney(); 

				}
				break;
			case 33 :
				// /Users/toysoldier/Documents/School/UvA/Master Software Engineering/Software Construction/sea-of-ql/sea-of-ql/DannyKop/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:200: Int
				{
				mInt(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\1\uffff\1\35\6\uffff\1\41\1\uffff\1\44\1\25\1\47\4\32\1\uffff\1\25\3"+
		"\uffff\3\32\2\uffff\1\63\14\uffff\2\32\1\66\2\32\1\uffff\4\32\2\uffff"+
		"\1\32\1\76\1\uffff\7\32\1\uffff\2\32\1\110\1\32\1\112\1\113\1\32\1\115"+
		"\1\32\1\uffff\1\110\2\uffff\1\32\1\uffff\1\120\1\121\2\uffff";
	static final String DFA9_eofS =
		"\122\uffff";
	static final String DFA9_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\3\75\1\157\1\146\1\157\1\164\1\uffff\1"+
		"\174\3\uffff\1\162\1\141\1\154\2\uffff\1\54\14\uffff\1\157\1\164\1\60"+
		"\1\156\1\162\1\uffff\1\165\1\154\1\162\1\163\2\uffff\1\154\1\60\1\uffff"+
		"\1\145\1\151\1\145\1\163\1\155\2\145\1\uffff\1\171\1\156\1\60\1\145\2"+
		"\60\1\141\1\60\1\147\1\uffff\1\60\2\uffff\1\156\1\uffff\2\60\2\uffff";
	static final String DFA9_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\3\75\1\157\1\156\1\157\1\164\1\uffff"+
		"\1\174\3\uffff\1\162\1\157\1\154\2\uffff\1\54\14\uffff\1\157\1\164\1\172"+
		"\1\156\1\162\1\uffff\1\165\1\154\1\162\1\163\2\uffff\1\154\1\172\1\uffff"+
		"\1\145\1\151\1\145\1\163\1\155\2\145\1\uffff\1\171\1\156\1\172\1\145\2"+
		"\172\1\141\1\172\1\147\1\uffff\1\172\2\uffff\1\156\1\uffff\2\172\2\uffff";
	static final String DFA9_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\7\uffff\1\24\1\uffff\1"+
		"\26\1\27\1\31\3\uffff\1\36\1\37\1\uffff\1\2\1\1\1\7\1\10\1\30\1\11\1\12"+
		"\1\14\1\13\1\15\1\17\1\16\5\uffff\1\25\4\uffff\1\40\1\41\2\uffff\1\33"+
		"\7\uffff\1\21\11\uffff\1\32\1\uffff\1\35\1\34\1\uffff\1\22\2\uffff\1\23"+
		"\1\20";
	static final String DFA9_specialS =
		"\122\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\24\2\uffff\1\24\22\uffff\1\24\1\1\1\31\3\uffff\1\2\1\25\1\3\1\4\1"+
			"\5\1\6\1\25\1\7\1\25\1\10\12\33\1\11\1\uffff\1\12\1\13\1\14\1\25\1\uffff"+
			"\32\32\3\25\3\uffff\1\32\1\15\2\32\1\30\1\27\2\32\1\16\3\32\1\17\5\32"+
			"\1\20\1\26\6\32\1\21\1\22\1\23",
			"\1\34",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\40\4\uffff\1\40",
			"",
			"\1\43",
			"\1\45",
			"\1\46",
			"\1\50",
			"\1\52\7\uffff\1\51",
			"\1\53",
			"\1\54",
			"",
			"\1\55",
			"",
			"",
			"",
			"\1\56",
			"\1\57\15\uffff\1\60",
			"\1\61",
			"",
			"",
			"\1\62",
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
			"\1\64",
			"\1\65",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\67",
			"\1\70",
			"",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"",
			"",
			"\1\75",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"",
			"\1\106",
			"\1\107",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\111",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\114",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\1\116",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			"",
			"\1\117",
			"",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
			"",
			""
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
			return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | WS | Comment | SpecialChars | Bool | If | Else | Form | Str | Ident | Money | Int );";
		}
	}

}
