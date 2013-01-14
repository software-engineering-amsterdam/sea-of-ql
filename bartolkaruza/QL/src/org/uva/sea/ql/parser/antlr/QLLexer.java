// $ANTLR 3.5 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-14 21:16:59

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__10=10;
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
	public static final int COMMENT=4;
	public static final int IF=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int TYPE=8;
	public static final int WS=9;

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
	@Override public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( ':' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:15:9: ':'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<=' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<='
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '==' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '=='
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>=' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>='
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '\\\"' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '\\\"'
			{
			match('\"'); 
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
			// src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( 'form' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:22:9: 'form'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( '{' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:23:9: '{'
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
			// src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( '||' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:24:9: '||'
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
			// src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( '}' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:25:9: '}'
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

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:125:6: ( 'boolean' | 'integer' | 'string' | 'money' )
			int alt1=4;
			switch ( input.LA(1) ) {
			case 'b':
				{
				alt1=1;
				}
				break;
			case 'i':
				{
				alt1=2;
				}
				break;
			case 's':
				{
				alt1=3;
				}
				break;
			case 'm':
				{
				alt1=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:125:8: 'boolean'
					{
					match("boolean"); 

					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:125:20: 'integer'
					{
					match("integer"); 

					}
					break;
				case 3 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:125:32: 'string'
					{
					match("string"); 

					}
					break;
				case 4 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:125:43: 'money'
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
	// $ANTLR end "TYPE"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:127:4: ( 'if' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:127:6: 'if'
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:129:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// src/org/uva/sea/ql/parser/antlr/QL.g:129:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// src/org/uva/sea/ql/parser/antlr/QL.g:131:9: ( '/*' ( . )* '*/' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:131:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// src/org/uva/sea/ql/parser/antlr/QL.g:131:16: ( . )*
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:131:16: .
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
	// $ANTLR end "COMMENT"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:133:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:133:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src/org/uva/sea/ql/parser/antlr/QL.g:133:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:
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
					break loop3;
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
			// src/org/uva/sea/ql/parser/antlr/QL.g:135:4: ( ( '0' .. '9' )+ )
			// src/org/uva/sea/ql/parser/antlr/QL.g:135:6: ( '0' .. '9' )+
			{
			// src/org/uva/sea/ql/parser/antlr/QL.g:135:6: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:
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
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
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
		// src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | TYPE | IF | WS | COMMENT | Ident | Int )
		int alt5=26;
		alt5 = dfa5.predict(input);
		switch (alt5) {
			case 1 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__10
				{
				mT__10(); 

				}
				break;
			case 2 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__11
				{
				mT__11(); 

				}
				break;
			case 3 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__12
				{
				mT__12(); 

				}
				break;
			case 4 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__13
				{
				mT__13(); 

				}
				break;
			case 5 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__14
				{
				mT__14(); 

				}
				break;
			case 6 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__15
				{
				mT__15(); 

				}
				break;
			case 7 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__16
				{
				mT__16(); 

				}
				break;
			case 8 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__17
				{
				mT__17(); 

				}
				break;
			case 9 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__18
				{
				mT__18(); 

				}
				break;
			case 10 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__19
				{
				mT__19(); 

				}
				break;
			case 11 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__20
				{
				mT__20(); 

				}
				break;
			case 12 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__21
				{
				mT__21(); 

				}
				break;
			case 13 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__22
				{
				mT__22(); 

				}
				break;
			case 14 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__23
				{
				mT__23(); 

				}
				break;
			case 15 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__24
				{
				mT__24(); 

				}
				break;
			case 16 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__25
				{
				mT__25(); 

				}
				break;
			case 17 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__26
				{
				mT__26(); 

				}
				break;
			case 18 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__27
				{
				mT__27(); 

				}
				break;
			case 19 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__28
				{
				mT__28(); 

				}
				break;
			case 20 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:124: T__29
				{
				mT__29(); 

				}
				break;
			case 21 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:130: TYPE
				{
				mTYPE(); 

				}
				break;
			case 22 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:135: IF
				{
				mIF(); 

				}
				break;
			case 23 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:138: WS
				{
				mWS(); 

				}
				break;
			case 24 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:141: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 25 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:149: Ident
				{
				mIdent(); 

				}
				break;
			case 26 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:155: Int
				{
				mInt(); 

				}
				break;

		}
	}


	protected DFA5 dfa5 = new DFA5(this);
	static final String DFA5_eotS =
		"\1\uffff\1\32\6\uffff\1\34\1\uffff\1\36\1\uffff\1\40\1\uffff\1\27\3\uffff"+
		"\4\27\13\uffff\3\27\1\52\5\27\1\uffff\2\27\1\62\4\27\1\uffff\3\27\1\72"+
		"\2\27\1\72\1\uffff\2\72";
	static final String DFA5_eofS =
		"\75\uffff";
	static final String DFA5_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\uffff\1\157\3\uffff"+
		"\1\157\1\146\1\164\1\157\13\uffff\1\162\1\157\1\164\1\60\1\162\1\156\1"+
		"\155\1\154\1\145\1\uffff\1\151\1\145\1\60\1\145\1\147\1\156\1\171\1\uffff"+
		"\1\141\1\145\1\147\1\60\1\156\1\162\1\60\1\uffff\2\60";
	static final String DFA5_maxS =
		"\1\175\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\uffff\1\157\3\uffff"+
		"\1\157\1\156\1\164\1\157\13\uffff\1\162\1\157\1\164\1\172\1\162\1\156"+
		"\1\155\1\154\1\145\1\uffff\1\151\1\145\1\172\1\145\1\147\1\156\1\171\1"+
		"\uffff\1\141\1\145\1\147\1\172\1\156\1\162\1\172\1\uffff\2\172";
	static final String DFA5_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\1\uffff\1"+
		"\20\1\uffff\1\22\1\23\1\24\4\uffff\1\27\1\31\1\32\1\2\1\1\1\30\1\11\1"+
		"\14\1\13\1\17\1\16\11\uffff\1\26\7\uffff\1\21\7\uffff\1\25\2\uffff";
	static final String DFA5_specialS =
		"\75\uffff}>";
	static final String[] DFA5_transitionS = {
			"\2\26\2\uffff\1\26\22\uffff\1\26\1\1\1\15\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\30\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\27\6\uffff\1\27\1\22\3\27\1\16\2\27\1\23\3\27\1\25\5\27\1\24"+
			"\7\27\1\17\1\20\1\21",
			"\1\31",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\33",
			"",
			"\1\35",
			"",
			"\1\37",
			"",
			"\1\41",
			"",
			"",
			"",
			"\1\42",
			"\1\44\7\uffff\1\43",
			"\1\45",
			"\1\46",
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
			"\1\47",
			"\1\50",
			"\1\51",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\53",
			"\1\54",
			"\1\55",
			"\1\56",
			"\1\57",
			"",
			"\1\60",
			"\1\61",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"",
			"\1\67",
			"\1\70",
			"\1\71",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\1\73",
			"\1\74",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
			"\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27"
	};

	static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
	static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
	static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
	static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
	static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
	static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
	static final short[][] DFA5_transition;

	static {
		int numStates = DFA5_transitionS.length;
		DFA5_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
		}
	}

	protected class DFA5 extends DFA {

		public DFA5(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 5;
			this.eot = DFA5_eot;
			this.eof = DFA5_eof;
			this.min = DFA5_min;
			this.max = DFA5_max;
			this.accept = DFA5_accept;
			this.special = DFA5_special;
			this.transition = DFA5_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | TYPE | IF | WS | COMMENT | Ident | Int );";
		}
	}

}
