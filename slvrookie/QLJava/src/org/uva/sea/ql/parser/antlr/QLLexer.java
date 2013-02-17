// $ANTLR 3.5 C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-02-17 20:00:25

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
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int BOOLEAN=4;
	public static final int BoolLiteral=5;
	public static final int Comment=6;
	public static final int INTEGER=7;
	public static final int Ident=8;
	public static final int IntLiteral=9;
	public static final int LineComment=10;
	public static final int MONEY=11;
	public static final int MoneyLiteral=12;
	public static final int STRING=13;
	public static final int StringLiteral=14;
	public static final int Ws=15;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:7: ( '!' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:9: '!'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:7: ( '!=' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:9: '!='
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:7: ( '&&' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:9: '&&'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:7: ( '(' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:9: '('
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:7: ( ')' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:9: ')'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '*' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '*'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '+' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '+'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '-' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '-'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '/' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '/'
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( ':' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: ':'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '<' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '<'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '<=' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '<='
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( '==' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: '=='
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( '>' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: '>'
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( '>=' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: '>='
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: ( 'else' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:9: 'else'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: ( 'form' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:9: 'form'
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:7: ( 'if' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:9: 'if'
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
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:7: ( '{' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:9: '{'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:7: ( '||' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:9: '||'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:7: ( '}' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:9: '}'
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

	// $ANTLR start "Ws"
	public final void mWs() throws RecognitionException {
		try {
			int _type = Ws;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
	// $ANTLR end "Ws"

	// $ANTLR start "Comment"
	public final void mComment() throws RecognitionException {
		try {
			int _type = Comment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:9: ( '/*' ( . )* '*/' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:16: ( . )*
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:16: .
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Comment"

	// $ANTLR start "LineComment"
	public final void mLineComment() throws RecognitionException {
		try {
			int _type = LineComment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:13: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:15: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:20: (~ ( '\\n' | '\\r' ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:34: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:34: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LineComment"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:9: ( 'int' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:11: 'int'
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
	// $ANTLR end "INTEGER"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:9: ( 'string' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:11: 'string'
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
	// $ANTLR end "STRING"

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:9: ( 'boolean' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:11: 'boolean'
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
	// $ANTLR end "BOOLEAN"

	// $ANTLR start "MONEY"
	public final void mMONEY() throws RecognitionException {
		try {
			int _type = MONEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:131:7: ( 'money' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:131:9: 'money'
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
	// $ANTLR end "MONEY"

	// $ANTLR start "BoolLiteral"
	public final void mBoolLiteral() throws RecognitionException {
		try {
			int _type = BoolLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:12: ( 'true' | 'false' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='t') ) {
				alt4=1;
			}
			else if ( (LA4_0=='f') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:14: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:21: 'false'
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
	// $ANTLR end "BoolLiteral"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:135:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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

	// $ANTLR start "StringLiteral"
	public final void mStringLiteral() throws RecognitionException {
		try {
			int _type = StringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:15: ( '\"' (~ ( '\\n' | '\\r' | '\\f' | '\"' ) )* '\"' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:17: '\"' (~ ( '\\n' | '\\r' | '\\f' | '\"' ) )* '\"'
			{
			match('\"'); 
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:137:21: (~ ( '\\n' | '\\r' | '\\f' | '\"' ) )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||LA6_0=='\u000B'||(LA6_0 >= '\u000E' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '\uFFFF')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||input.LA(1)=='\u000B'||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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
	// $ANTLR end "StringLiteral"

	// $ANTLR start "MoneyLiteral"
	public final void mMoneyLiteral() throws RecognitionException {
		try {
			int _type = MoneyLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:139:14: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' ) ( '0' .. '9' ) )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:139:16: ( '0' .. '9' )+ '\\.' ( '0' .. '9' ) ( '0' .. '9' )
			{
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:139:16: ( '0' .. '9' )+
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
	// $ANTLR end "MoneyLiteral"

	// $ANTLR start "IntLiteral"
	public final void mIntLiteral() throws RecognitionException {
		try {
			int _type = IntLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:12: ( ( '0' .. '9' )+ )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:14: ( '0' .. '9' )+
			{
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:141:14: ( '0' .. '9' )+
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
	// $ANTLR end "IntLiteral"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | Ws | Comment | LineComment | INTEGER | STRING | BOOLEAN | MONEY | BoolLiteral | Ident | StringLiteral | MoneyLiteral | IntLiteral )
		int alt9=33;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__16
				{
				mT__16(); 

				}
				break;
			case 2 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__17
				{
				mT__17(); 

				}
				break;
			case 3 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__18
				{
				mT__18(); 

				}
				break;
			case 4 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__19
				{
				mT__19(); 

				}
				break;
			case 5 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__20
				{
				mT__20(); 

				}
				break;
			case 6 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__21
				{
				mT__21(); 

				}
				break;
			case 7 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__22
				{
				mT__22(); 

				}
				break;
			case 8 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__23
				{
				mT__23(); 

				}
				break;
			case 9 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__24
				{
				mT__24(); 

				}
				break;
			case 10 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__25
				{
				mT__25(); 

				}
				break;
			case 11 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__26
				{
				mT__26(); 

				}
				break;
			case 12 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__27
				{
				mT__27(); 

				}
				break;
			case 13 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__28
				{
				mT__28(); 

				}
				break;
			case 14 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__29
				{
				mT__29(); 

				}
				break;
			case 15 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__30
				{
				mT__30(); 

				}
				break;
			case 16 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__31
				{
				mT__31(); 

				}
				break;
			case 17 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: T__32
				{
				mT__32(); 

				}
				break;
			case 18 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:112: T__33
				{
				mT__33(); 

				}
				break;
			case 19 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:118: T__34
				{
				mT__34(); 

				}
				break;
			case 20 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:124: T__35
				{
				mT__35(); 

				}
				break;
			case 21 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:130: T__36
				{
				mT__36(); 

				}
				break;
			case 22 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:136: Ws
				{
				mWs(); 

				}
				break;
			case 23 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:139: Comment
				{
				mComment(); 

				}
				break;
			case 24 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:147: LineComment
				{
				mLineComment(); 

				}
				break;
			case 25 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:159: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 26 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:167: STRING
				{
				mSTRING(); 

				}
				break;
			case 27 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:174: BOOLEAN
				{
				mBOOLEAN(); 

				}
				break;
			case 28 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:182: MONEY
				{
				mMONEY(); 

				}
				break;
			case 29 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:188: BoolLiteral
				{
				mBoolLiteral(); 

				}
				break;
			case 30 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:200: Ident
				{
				mIdent(); 

				}
				break;
			case 31 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:206: StringLiteral
				{
				mStringLiteral(); 

				}
				break;
			case 32 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:220: MoneyLiteral
				{
				mMoneyLiteral(); 

				}
				break;
			case 33 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:233: IntLiteral
				{
				mIntLiteral(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\1\uffff\1\34\6\uffff\1\37\1\uffff\1\41\1\uffff\1\43\3\30\4\uffff\4\30"+
		"\2\uffff\1\56\11\uffff\3\30\1\62\5\30\2\uffff\3\30\1\uffff\1\73\4\30\1"+
		"\100\1\101\1\30\1\uffff\3\30\1\106\2\uffff\1\106\2\30\1\111\1\uffff\1"+
		"\112\1\30\2\uffff\1\114\1\uffff";
	static final String DFA9_eofS =
		"\115\uffff";
	static final String DFA9_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\154\1\141\1\146\4"+
		"\uffff\1\164\2\157\1\162\2\uffff\1\56\11\uffff\1\163\1\162\1\154\1\60"+
		"\1\164\1\162\1\157\1\156\1\165\2\uffff\1\145\1\155\1\163\1\uffff\1\60"+
		"\1\151\1\154\2\145\2\60\1\145\1\uffff\1\156\1\145\1\171\1\60\2\uffff\1"+
		"\60\1\147\1\141\1\60\1\uffff\1\60\1\156\2\uffff\1\60\1\uffff";
	static final String DFA9_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\154\1\157\1\156\4"+
		"\uffff\1\164\2\157\1\162\2\uffff\1\71\11\uffff\1\163\1\162\1\154\1\172"+
		"\1\164\1\162\1\157\1\156\1\165\2\uffff\1\145\1\155\1\163\1\uffff\1\172"+
		"\1\151\1\154\2\145\2\172\1\145\1\uffff\1\156\1\145\1\171\1\172\2\uffff"+
		"\1\172\1\147\1\141\1\172\1\uffff\1\172\1\156\2\uffff\1\172\1\uffff";
	static final String DFA9_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\4\uffff\1"+
		"\23\1\24\1\25\1\26\4\uffff\1\36\1\37\1\uffff\1\2\1\1\1\27\1\30\1\11\1"+
		"\14\1\13\1\17\1\16\11\uffff\1\40\1\41\3\uffff\1\22\10\uffff\1\31\4\uffff"+
		"\1\20\1\21\4\uffff\1\35\2\uffff\1\34\1\32\1\uffff\1\33";
	static final String DFA9_specialS =
		"\115\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\23\2\uffff\1\23\22\uffff\1\23\1\1\1\31\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\32\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\30\6\uffff\1\30\1\25\2\30\1\15\1\16\2\30\1\17\3\30\1\26\5\30"+
			"\1\24\1\27\6\30\1\20\1\21\1\22",
			"\1\33",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\35\4\uffff\1\36",
			"",
			"\1\40",
			"",
			"\1\42",
			"\1\44",
			"\1\46\15\uffff\1\45",
			"\1\47\7\uffff\1\50",
			"",
			"",
			"",
			"",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"",
			"",
			"\1\55\1\uffff\12\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\57",
			"\1\60",
			"\1\61",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"",
			"",
			"\1\70",
			"\1\71",
			"\1\72",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\102",
			"",
			"\1\103",
			"\1\104",
			"\1\105",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\107",
			"\1\110",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\113",
			"",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
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
			return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | Ws | Comment | LineComment | INTEGER | STRING | BOOLEAN | MONEY | BoolLiteral | Ident | StringLiteral | MoneyLiteral | IntLiteral );";
		}
	}

}
