// $ANTLR 3.5 C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-26 09:46:27

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
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int BoolLiteral=4;
	public static final int Comment=5;
	public static final int Ident=6;
	public static final int IntLiteral=7;
	public static final int LineComment=8;
	public static final int MoneyLiteral=9;
	public static final int StringLiteral=10;
	public static final int Type=11;
	public static final int Ws=12;

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
	@Override public String getGrammarFileName() { return "C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:7: ( '!' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:9: '!'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:7: ( '!=' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:9: '!='
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:7: ( '&&' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:9: '&&'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:7: ( '(' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:9: '('
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:7: ( ')' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:9: ')'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '*' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '*'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '+' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '+'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '-' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '-'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '/' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '/'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( ':' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: ':'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '<' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '<'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '<=' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '<='
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( '==' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: '=='
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( '>' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: '>'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( '>=' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: '>='
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: ( 'form' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:9: 'form'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: ( 'if' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:9: 'if'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:7: ( '{' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:9: '{'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:7: ( '||' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:9: '||'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:7: ( '}' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:9: '}'
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
	// $ANTLR end "T__32"

	// $ANTLR start "Ws"
	public final void mWs() throws RecognitionException {
		try {
			int _type = Ws;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:122:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:9: ( '/*' ( . )* '*/' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:16: ( . )*
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:124:16: .
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:13: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:15: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:20: (~ ( '\\n' | '\\r' ) )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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

			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:34: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:126:34: '\\r'
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

	// $ANTLR start "Type"
	public final void mType() throws RecognitionException {
		try {
			int _type = Type;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:5: ( 'string' | 'int' | 'money' | 'boolean' )
			int alt4=4;
			switch ( input.LA(1) ) {
			case 's':
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
			case 'b':
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:7: 'string'
					{
					match("string"); 

					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:18: 'int'
					{
					match("int"); 

					}
					break;
				case 3 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:26: 'money'
					{
					match("money"); 

					}
					break;
				case 4 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:128:36: 'boolean'
					{
					match("boolean"); 

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

	// $ANTLR start "BoolLiteral"
	public final void mBoolLiteral() throws RecognitionException {
		try {
			int _type = BoolLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:12: ( 'true' | 'false' )
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:14: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:130:21: 'false'
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:132:30: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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

	// $ANTLR start "StringLiteral"
	public final void mStringLiteral() throws RecognitionException {
		try {
			int _type = StringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:15: ( '\"' (~ ( '\\n' | '\\r' | '\\f' | '\"' ) )* '\"' )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:17: '\"' (~ ( '\\n' | '\\r' | '\\f' | '\"' ) )* '\"'
			{
			match('\"'); 
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:134:21: (~ ( '\\n' | '\\r' | '\\f' | '\"' ) )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||LA7_0=='\u000B'||(LA7_0 >= '\u000E' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
	// $ANTLR end "StringLiteral"

	// $ANTLR start "MoneyLiteral"
	public final void mMoneyLiteral() throws RecognitionException {
		try {
			int _type = MoneyLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:14: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' ) ( '0' .. '9' ) )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:16: ( '0' .. '9' )+ '\\.' ( '0' .. '9' ) ( '0' .. '9' )
			{
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:136:16: ( '0' .. '9' )+
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:12: ( ( '0' .. '9' )+ )
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:14: ( '0' .. '9' )+
			{
			// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:138:14: ( '0' .. '9' )+
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
					// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
		// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | Ws | Comment | LineComment | Type | BoolLiteral | Ident | StringLiteral | MoneyLiteral | IntLiteral )
		int alt10=29;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__13
				{
				mT__13(); 

				}
				break;
			case 2 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__14
				{
				mT__14(); 

				}
				break;
			case 3 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__15
				{
				mT__15(); 

				}
				break;
			case 4 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__16
				{
				mT__16(); 

				}
				break;
			case 5 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__17
				{
				mT__17(); 

				}
				break;
			case 6 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__18
				{
				mT__18(); 

				}
				break;
			case 7 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__19
				{
				mT__19(); 

				}
				break;
			case 8 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__20
				{
				mT__20(); 

				}
				break;
			case 9 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__21
				{
				mT__21(); 

				}
				break;
			case 10 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__22
				{
				mT__22(); 

				}
				break;
			case 11 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__23
				{
				mT__23(); 

				}
				break;
			case 12 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__24
				{
				mT__24(); 

				}
				break;
			case 13 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__25
				{
				mT__25(); 

				}
				break;
			case 14 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__26
				{
				mT__26(); 

				}
				break;
			case 15 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__27
				{
				mT__27(); 

				}
				break;
			case 16 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__28
				{
				mT__28(); 

				}
				break;
			case 17 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: T__29
				{
				mT__29(); 

				}
				break;
			case 18 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:112: T__30
				{
				mT__30(); 

				}
				break;
			case 19 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:118: T__31
				{
				mT__31(); 

				}
				break;
			case 20 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:124: T__32
				{
				mT__32(); 

				}
				break;
			case 21 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:130: Ws
				{
				mWs(); 

				}
				break;
			case 22 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:133: Comment
				{
				mComment(); 

				}
				break;
			case 23 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:141: LineComment
				{
				mLineComment(); 

				}
				break;
			case 24 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:153: Type
				{
				mType(); 

				}
				break;
			case 25 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:158: BoolLiteral
				{
				mBoolLiteral(); 

				}
				break;
			case 26 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:170: Ident
				{
				mIdent(); 

				}
				break;
			case 27 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:176: StringLiteral
				{
				mStringLiteral(); 

				}
				break;
			case 28 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:190: MoneyLiteral
				{
				mMoneyLiteral(); 

				}
				break;
			case 29 :
				// C:\\Users\\SliverPente\\workspaceindigo\\QLJAVA\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:203: IntLiteral
				{
				mIntLiteral(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\1\uffff\1\33\6\uffff\1\36\1\uffff\1\40\1\uffff\1\42\2\27\4\uffff\4\27"+
		"\2\uffff\1\54\11\uffff\2\27\1\57\5\27\2\uffff\2\27\1\uffff\1\67\4\27\1"+
		"\74\1\27\1\uffff\3\27\1\101\1\uffff\1\101\1\27\1\67\1\27\1\uffff\1\67"+
		"\1\27\1\67";
	static final String DFA10_eofS =
		"\105\uffff";
	static final String DFA10_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\141\1\146\4\uffff"+
		"\1\164\2\157\1\162\2\uffff\1\56\11\uffff\1\162\1\154\1\60\1\164\1\162"+
		"\1\156\1\157\1\165\2\uffff\1\155\1\163\1\uffff\1\60\1\151\1\145\1\154"+
		"\1\145\1\60\1\145\1\uffff\1\156\1\171\1\145\1\60\1\uffff\1\60\1\147\1"+
		"\60\1\141\1\uffff\1\60\1\156\1\60";
	static final String DFA10_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\157\1\156\4\uffff"+
		"\1\164\2\157\1\162\2\uffff\1\71\11\uffff\1\162\1\154\1\172\1\164\1\162"+
		"\1\156\1\157\1\165\2\uffff\1\155\1\163\1\uffff\1\172\1\151\1\145\1\154"+
		"\1\145\1\172\1\145\1\uffff\1\156\1\171\1\145\1\172\1\uffff\1\172\1\147"+
		"\1\172\1\141\1\uffff\1\172\1\156\1\172";
	static final String DFA10_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\3\uffff\1"+
		"\22\1\23\1\24\1\25\4\uffff\1\32\1\33\1\uffff\1\2\1\1\1\26\1\27\1\11\1"+
		"\14\1\13\1\17\1\16\10\uffff\1\34\1\35\2\uffff\1\21\7\uffff\1\30\4\uffff"+
		"\1\20\4\uffff\1\31\3\uffff";
	static final String DFA10_specialS =
		"\105\uffff}>";
	static final String[] DFA10_transitionS = {
			"\2\22\2\uffff\1\22\22\uffff\1\22\1\1\1\30\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\31\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\27\6\uffff\1\27\1\25\3\27\1\15\2\27\1\16\3\27\1\24\5\27\1\23"+
			"\1\26\6\27\1\17\1\20\1\21",
			"\1\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\34\4\uffff\1\35",
			"",
			"\1\37",
			"",
			"\1\41",
			"\1\44\15\uffff\1\43",
			"\1\45\7\uffff\1\46",
			"",
			"",
			"",
			"",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"",
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
			"",
			"\1\55",
			"\1\56",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"",
			"",
			"\1\65",
			"\1\66",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\75",
			"",
			"\1\76",
			"\1\77",
			"\1\100",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\102",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\103",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\104",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27"
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
			return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | Ws | Comment | LineComment | Type | BoolLiteral | Ident | StringLiteral | MoneyLiteral | IntLiteral );";
		}
	}

}
