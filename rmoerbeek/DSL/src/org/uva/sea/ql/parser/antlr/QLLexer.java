// $ANTLR 3.5 C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-03-01 12:53:53

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int T__35=35;
	public static final int Boolean=4;
	public static final int Ident=5;
	public static final int Int=6;
	public static final int Inttype=7;
	public static final int Money=8;
	public static final int MultiLineComment=9;
	public static final int SingleLineComment=10;
	public static final int String=11;
	public static final int StringLit=12;
	public static final int WS=13;

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

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
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
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
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
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
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
	// $ANTLR end "T__35"

	// $ANTLR start "Boolean"
	public final void mBoolean() throws RecognitionException {
		try {
			int _type = Boolean;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:219:5: ( 'boolean' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:219:7: 'boolean'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:223:5: ( 'money' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:223:7: 'money'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:227:5: ( 'string' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:227:7: 'string'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:231:5: ( 'integer' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:231:7: 'integer'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:235:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:235:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:250:11: ( '\"' ( '\"\"' |~ '\"' )* '\"' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:250:13: '\"' ( '\"\"' |~ '\"' )* '\"'
			{
			match('\"'); 
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:250:17: ( '\"\"' |~ '\"' )*
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:250:18: '\"\"'
					{
					match("\"\""); 

					}
					break;
				case 2 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:250:25: ~ '\"'
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:253:5: ( '/*' ( . )* '*/' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:253:7: '/*' ( . )* '*/'
			{
			match("/*"); 

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:253:12: ( . )*
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
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:253:12: .
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
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:257:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:257:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
			{
			match("//"); 

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:257:12: (~ ( '\\n' | '\\r' ) )*
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

			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:257:26: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:257:26: '\\r'
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

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:261:5: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:261:7: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:261:26: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
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

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:265:5: ( ( '0' .. '9' )+ )
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:265:7: ( '0' .. '9' )+
			{
			// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:265:7: ( '0' .. '9' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
		// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | Boolean | Money | String | Inttype | WS | StringLit | MultiLineComment | SingleLineComment | Ident | Int )
		int alt7=32;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__14
				{
				mT__14(); 

				}
				break;
			case 2 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__15
				{
				mT__15(); 

				}
				break;
			case 3 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__16
				{
				mT__16(); 

				}
				break;
			case 4 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__17
				{
				mT__17(); 

				}
				break;
			case 5 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__18
				{
				mT__18(); 

				}
				break;
			case 6 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__19
				{
				mT__19(); 

				}
				break;
			case 7 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__20
				{
				mT__20(); 

				}
				break;
			case 8 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__21
				{
				mT__21(); 

				}
				break;
			case 9 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__22
				{
				mT__22(); 

				}
				break;
			case 10 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__23
				{
				mT__23(); 

				}
				break;
			case 11 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__24
				{
				mT__24(); 

				}
				break;
			case 12 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__25
				{
				mT__25(); 

				}
				break;
			case 13 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__26
				{
				mT__26(); 

				}
				break;
			case 14 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__27
				{
				mT__27(); 

				}
				break;
			case 15 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__28
				{
				mT__28(); 

				}
				break;
			case 16 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__29
				{
				mT__29(); 

				}
				break;
			case 17 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: T__30
				{
				mT__30(); 

				}
				break;
			case 18 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:112: T__31
				{
				mT__31(); 

				}
				break;
			case 19 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:118: T__32
				{
				mT__32(); 

				}
				break;
			case 20 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:124: T__33
				{
				mT__33(); 

				}
				break;
			case 21 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:130: T__34
				{
				mT__34(); 

				}
				break;
			case 22 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:136: T__35
				{
				mT__35(); 

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
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:219: Ident
				{
				mIdent(); 

				}
				break;
			case 32 :
				// C:\\Users\\Romy\\Construction\\DSL\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:225: Int
				{
				mInt(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\1\uffff\1\33\6\uffff\1\36\1\uffff\1\40\1\uffff\1\42\3\30\3\uffff\3\30"+
		"\15\uffff\2\30\1\54\6\30\1\uffff\4\30\1\70\1\71\4\30\3\uffff\2\30\1\100"+
		"\3\30\1\uffff\1\104\1\105\1\106\3\uffff";
	static final String DFA7_eofS =
		"\107\uffff";
	static final String DFA7_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\154\1\157\1\146\3"+
		"\uffff\2\157\1\164\15\uffff\1\163\1\162\1\60\1\164\1\157\1\156\1\162\1"+
		"\145\1\155\1\uffff\1\145\1\154\1\145\1\151\1\40\1\60\1\147\1\145\1\171"+
		"\1\156\3\uffff\1\145\1\141\1\60\1\147\1\162\1\156\1\uffff\3\60\3\uffff";
	static final String DFA7_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\154\1\157\1\156\3"+
		"\uffff\2\157\1\164\15\uffff\1\163\1\162\1\172\1\164\1\157\1\156\1\162"+
		"\1\145\1\155\1\uffff\1\145\1\154\1\145\1\151\2\172\1\147\1\145\1\171\1"+
		"\156\3\uffff\1\145\1\141\1\172\1\147\1\162\1\156\1\uffff\3\172\3\uffff";
	static final String DFA7_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\4\uffff\1"+
		"\24\1\25\1\26\3\uffff\1\33\1\34\1\37\1\40\1\2\1\1\1\35\1\36\1\11\1\14"+
		"\1\13\1\17\1\16\11\uffff\1\23\12\uffff\1\20\1\21\1\22\6\uffff\1\30\3\uffff"+
		"\1\31\1\32\1\27";
	static final String DFA7_specialS =
		"\107\uffff}>";
	static final String[] DFA7_transitionS = {
			"\2\26\2\uffff\1\26\22\uffff\1\26\1\1\1\27\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\31\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\30\6\uffff\1\30\1\23\2\30\1\15\1\16\2\30\1\17\3\30\1\24\5\30"+
			"\1\25\7\30\1\20\1\21\1\22",
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
			"\1\43",
			"\1\44",
			"\1\45\7\uffff\1\46",
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
			"",
			"",
			"\1\52",
			"\1\53",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\55",
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67\17\uffff\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"",
			"",
			"",
			"\1\76",
			"\1\77",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\101",
			"\1\102",
			"\1\103",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"",
			""
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | Boolean | Money | String | Inttype | WS | StringLit | MultiLineComment | SingleLineComment | Ident | Int );";
		}
	}

}
