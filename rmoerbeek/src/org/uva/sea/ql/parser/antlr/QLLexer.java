// $ANTLR 3.5 C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-03-19 09:45:39

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
	public static final int Boolean=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int Inttype=8;
	public static final int Money=9;
	public static final int MultiLineComment=10;
	public static final int SingleLineComment=11;
	public static final int String=12;
	public static final int StringLit=13;
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
	@Override public String getGrammarFileName() { return "C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:7: ( '!' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:9: '!'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:7: ( '!=' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:9: '!='
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:7: ( '&&' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:9: '&&'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:7: ( '(' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:9: '('
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:7: ( ')' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:9: ')'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '*' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '*'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '+' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '+'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '-' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '-'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '/' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '/'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( ':' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: ':'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '<' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '<'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '<=' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '<='
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( '==' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: '=='
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( '>' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: '>'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( '>=' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: '>='
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: ( 'else if' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:9: 'else if'
			{
			match("else if"); 

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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: ( 'else' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:9: 'else'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:7: ( 'form' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:9: 'form'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:7: ( 'if' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:24:9: 'if'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:7: ( '{' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:25:9: '{'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:7: ( '||' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:26:9: '||'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:7: ( '}' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:27:9: '}'
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

	// $ANTLR start "Boolean"
	public final void mBoolean() throws RecognitionException {
		try {
			int _type = Boolean;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:188:5: ( 'boolean' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:188:7: 'boolean'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:192:5: ( 'money' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:192:7: 'money'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:196:5: ( 'string' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:196:7: 'string'
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
	// $ANTLR end "String"

	// $ANTLR start "Inttype"
	public final void mInttype() throws RecognitionException {
		try {
			int _type = Inttype;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:200:5: ( 'integer' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:200:7: 'integer'
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
	// $ANTLR end "Inttype"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:204:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:204:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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

	// $ANTLR start "StringLit"
	public final void mStringLit() throws RecognitionException {
		try {
			int _type = StringLit;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:212:11: ( '\"' ( '\"\"' |~ '\"' )* '\"' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:212:13: '\"' ( '\"\"' |~ '\"' )* '\"'
			{
			match('\"'); 
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:212:17: ( '\"\"' |~ '\"' )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='\"') ) {
					int LA1_1 = input.LA(2);
					if ( (LA1_1=='\"') ) {
						alt1=1;
					}

				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '\uFFFF')) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:212:18: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:212:25: ~ '\"'
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "StringLit"

	// $ANTLR start "MultiLineComment"
	public final void mMultiLineComment() throws RecognitionException {
		try {
			int _type = MultiLineComment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:215:5: ( '/*' ( . )* '*/' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:215:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:215:12: ( . )*
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:215:12: .
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MultiLineComment"

	// $ANTLR start "SingleLineComment"
	public final void mSingleLineComment() throws RecognitionException {
		try {
			int _type = SingleLineComment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:219:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:219:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:219:12: (~ ( '\\n' | '\\r' ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:219:26: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:219:26: '\\r'
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
	// $ANTLR end "SingleLineComment"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:223:5: ( 'true' | 'false' )
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:223:7: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:223:16: 'false'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:227:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:227:7: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:227:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:231:5: ( ( '0' .. '9' )+ )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:231:7: ( '0' .. '9' )+
			{
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:231:7: ( '0' .. '9' )+
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
		// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | Boolean | Money | String | Inttype | WS | StringLit | MultiLineComment | SingleLineComment | Bool | Ident | Int )
		int alt8=33;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__15
				{
				mT__15(); 

				}
				break;
			case 2 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__16
				{
				mT__16(); 

				}
				break;
			case 3 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__17
				{
				mT__17(); 

				}
				break;
			case 4 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__18
				{
				mT__18(); 

				}
				break;
			case 5 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__19
				{
				mT__19(); 

				}
				break;
			case 6 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__20
				{
				mT__20(); 

				}
				break;
			case 7 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__21
				{
				mT__21(); 

				}
				break;
			case 8 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__22
				{
				mT__22(); 

				}
				break;
			case 9 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__23
				{
				mT__23(); 

				}
				break;
			case 10 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__24
				{
				mT__24(); 

				}
				break;
			case 11 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__25
				{
				mT__25(); 

				}
				break;
			case 12 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__26
				{
				mT__26(); 

				}
				break;
			case 13 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__27
				{
				mT__27(); 

				}
				break;
			case 14 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__28
				{
				mT__28(); 

				}
				break;
			case 15 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__29
				{
				mT__29(); 

				}
				break;
			case 16 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__30
				{
				mT__30(); 

				}
				break;
			case 17 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: T__31
				{
				mT__31(); 

				}
				break;
			case 18 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:112: T__32
				{
				mT__32(); 

				}
				break;
			case 19 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:118: T__33
				{
				mT__33(); 

				}
				break;
			case 20 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:124: T__34
				{
				mT__34(); 

				}
				break;
			case 21 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:130: T__35
				{
				mT__35(); 

				}
				break;
			case 22 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:136: T__36
				{
				mT__36(); 

				}
				break;
			case 23 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:142: Boolean
				{
				mBoolean(); 

				}
				break;
			case 24 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:150: Money
				{
				mMoney(); 

				}
				break;
			case 25 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:156: String
				{
				mString(); 

				}
				break;
			case 26 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:163: Inttype
				{
				mInttype(); 

				}
				break;
			case 27 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:171: WS
				{
				mWS(); 

				}
				break;
			case 28 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:174: StringLit
				{
				mStringLit(); 

				}
				break;
			case 29 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:184: MultiLineComment
				{
				mMultiLineComment(); 

				}
				break;
			case 30 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:201: SingleLineComment
				{
				mSingleLineComment(); 

				}
				break;
			case 31 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:219: Bool
				{
				mBool(); 

				}
				break;
			case 32 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:224: Ident
				{
				mIdent(); 

				}
				break;
			case 33 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:230: Int
				{
				mInt(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\34\6\uffff\1\37\1\uffff\1\41\1\uffff\1\43\3\31\3\uffff\3\31"+
		"\2\uffff\1\31\13\uffff\3\31\1\60\10\31\1\uffff\5\31\1\77\1\100\5\31\1"+
		"\106\3\uffff\1\106\2\31\1\111\1\31\1\uffff\2\31\1\uffff\1\115\1\116\1"+
		"\117\3\uffff";
	static final String DFA8_eofS =
		"\120\uffff";
	static final String DFA8_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\154\1\141\1\146\3"+
		"\uffff\2\157\1\164\2\uffff\1\162\13\uffff\1\163\1\162\1\154\1\60\1\164"+
		"\1\157\1\156\1\162\1\165\1\145\1\155\1\163\1\uffff\1\145\1\154\1\145\1"+
		"\151\1\145\1\40\1\60\1\145\1\147\1\145\1\171\1\156\1\60\3\uffff\1\60\1"+
		"\145\1\141\1\60\1\147\1\uffff\1\162\1\156\1\uffff\3\60\3\uffff";
	static final String DFA8_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\154\1\157\1\156\3"+
		"\uffff\2\157\1\164\2\uffff\1\162\13\uffff\1\163\1\162\1\154\1\172\1\164"+
		"\1\157\1\156\1\162\1\165\1\145\1\155\1\163\1\uffff\1\145\1\154\1\145\1"+
		"\151\1\145\2\172\1\145\1\147\1\145\1\171\1\156\1\172\3\uffff\1\172\1\145"+
		"\1\141\1\172\1\147\1\uffff\1\162\1\156\1\uffff\3\172\3\uffff";
	static final String DFA8_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\4\uffff\1"+
		"\24\1\25\1\26\3\uffff\1\33\1\34\1\uffff\1\40\1\41\1\2\1\1\1\35\1\36\1"+
		"\11\1\14\1\13\1\17\1\16\14\uffff\1\23\15\uffff\1\20\1\21\1\22\5\uffff"+
		"\1\37\2\uffff\1\30\3\uffff\1\31\1\32\1\27";
	static final String DFA8_specialS =
		"\120\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\26\2\uffff\1\26\22\uffff\1\26\1\1\1\27\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\32\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\31\6\uffff\1\31\1\23\2\31\1\15\1\16\2\31\1\17\3\31\1\24\5\31"+
			"\1\25\1\30\6\31\1\20\1\21\1\22",
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
			"\1\51",
			"\1\52",
			"\1\53",
			"",
			"",
			"\1\54",
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
			"\1\55",
			"\1\56",
			"\1\57",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76\17\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\107",
			"\1\110",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\112",
			"",
			"\1\113",
			"\1\114",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
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
			return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | Boolean | Money | String | Inttype | WS | StringLit | MultiLineComment | SingleLineComment | Bool | Ident | Int );";
		}
	}

}
