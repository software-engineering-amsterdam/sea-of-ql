// $ANTLR 3.5 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-15 22:47:19

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
	public static final int BOOLEAN_VALUE=4;
	public static final int COMMENT=5;
	public static final int IF=6;
	public static final int INT_VALUE=7;
	public static final int Ident=8;
	public static final int MONEY_VALUE=9;
	public static final int STRING_VALUE=10;
	public static final int TYPE=11;
	public static final int WS=12;

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

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
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
	// $ANTLR end "T__32"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:131:6: ( 'boolean' | 'integer' | 'string' | 'money' )
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
					// src/org/uva/sea/ql/parser/antlr/QL.g:131:8: 'boolean'
					{
					match("boolean"); 

					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:131:20: 'integer'
					{
					match("integer"); 

					}
					break;
				case 3 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:131:32: 'string'
					{
					match("string"); 

					}
					break;
				case 4 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:131:43: 'money'
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
			// src/org/uva/sea/ql/parser/antlr/QL.g:133:4: ( 'if' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:133:6: 'if'
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

	// $ANTLR start "BOOLEAN_VALUE"
	public final void mBOOLEAN_VALUE() throws RecognitionException {
		try {
			int _type = BOOLEAN_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:135:14: ( 'true' | 'false' )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='t') ) {
				alt2=1;
			}
			else if ( (LA2_0=='f') ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:135:16: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:135:25: 'false'
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
	// $ANTLR end "BOOLEAN_VALUE"

	// $ANTLR start "STRING_VALUE"
	public final void mSTRING_VALUE() throws RecognitionException {
		try {
			int _type = STRING_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:137:14: ( '\\\"' ( . )* '\\\"' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:137:16: '\\\"' ( . )* '\\\"'
			{
			match('\"'); 
			// src/org/uva/sea/ql/parser/antlr/QL.g:137:21: ( . )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\"') ) {
					alt3=2;
				}
				else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:137:21: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop3;
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
	// $ANTLR end "STRING_VALUE"

	// $ANTLR start "MONEY_VALUE"
	public final void mMONEY_VALUE() throws RecognitionException {
		try {
			int _type = MONEY_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:139:12: ( ( '0' .. '9' )+ '\\.' ( '0' .. '9' ) ( '0' .. '9' ) )
			// src/org/uva/sea/ql/parser/antlr/QL.g:139:14: ( '0' .. '9' )+ '\\.' ( '0' .. '9' ) ( '0' .. '9' )
			{
			// src/org/uva/sea/ql/parser/antlr/QL.g:139:14: ( '0' .. '9' )+
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
	// $ANTLR end "MONEY_VALUE"

	// $ANTLR start "INT_VALUE"
	public final void mINT_VALUE() throws RecognitionException {
		try {
			int _type = INT_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:141:10: ( ( '0' .. '9' )+ )
			// src/org/uva/sea/ql/parser/antlr/QL.g:141:12: ( '0' .. '9' )+
			{
			// src/org/uva/sea/ql/parser/antlr/QL.g:141:12: ( '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
					alt5=1;
				}

				switch (alt5) {
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
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT_VALUE"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:143:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// src/org/uva/sea/ql/parser/antlr/QL.g:143:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src/org/uva/sea/ql/parser/antlr/QL.g:143:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/org/uva/sea/ql/parser/antlr/QL.g:145:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// src/org/uva/sea/ql/parser/antlr/QL.g:145:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
			// src/org/uva/sea/ql/parser/antlr/QL.g:147:9: ( '/*' ( . )* '*/' )
			// src/org/uva/sea/ql/parser/antlr/QL.g:147:11: '/*' ( . )* '*/'
			{
			match("/*"); 

			// src/org/uva/sea/ql/parser/antlr/QL.g:147:16: ( . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='*') ) {
					int LA7_1 = input.LA(2);
					if ( (LA7_1=='/') ) {
						alt7=2;
					}
					else if ( ((LA7_1 >= '\u0000' && LA7_1 <= '.')||(LA7_1 >= '0' && LA7_1 <= '\uFFFF')) ) {
						alt7=1;
					}

				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= ')')||(LA7_0 >= '+' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/org/uva/sea/ql/parser/antlr/QL.g:147:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
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

	@Override
	public void mTokens() throws RecognitionException {
		// src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | TYPE | IF | BOOLEAN_VALUE | STRING_VALUE | MONEY_VALUE | INT_VALUE | Ident | WS | COMMENT )
		int alt8=29;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__13
				{
				mT__13(); 

				}
				break;
			case 2 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__14
				{
				mT__14(); 

				}
				break;
			case 3 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__15
				{
				mT__15(); 

				}
				break;
			case 4 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__16
				{
				mT__16(); 

				}
				break;
			case 5 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__17
				{
				mT__17(); 

				}
				break;
			case 6 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__18
				{
				mT__18(); 

				}
				break;
			case 7 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__19
				{
				mT__19(); 

				}
				break;
			case 8 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__20
				{
				mT__20(); 

				}
				break;
			case 9 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__21
				{
				mT__21(); 

				}
				break;
			case 10 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__22
				{
				mT__22(); 

				}
				break;
			case 11 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__23
				{
				mT__23(); 

				}
				break;
			case 12 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__24
				{
				mT__24(); 

				}
				break;
			case 13 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__25
				{
				mT__25(); 

				}
				break;
			case 14 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__26
				{
				mT__26(); 

				}
				break;
			case 15 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__27
				{
				mT__27(); 

				}
				break;
			case 16 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__28
				{
				mT__28(); 

				}
				break;
			case 17 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__29
				{
				mT__29(); 

				}
				break;
			case 18 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__30
				{
				mT__30(); 

				}
				break;
			case 19 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__31
				{
				mT__31(); 

				}
				break;
			case 20 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:124: T__32
				{
				mT__32(); 

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
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:138: BOOLEAN_VALUE
				{
				mBOOLEAN_VALUE(); 

				}
				break;
			case 24 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:152: STRING_VALUE
				{
				mSTRING_VALUE(); 

				}
				break;
			case 25 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:165: MONEY_VALUE
				{
				mMONEY_VALUE(); 

				}
				break;
			case 26 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:177: INT_VALUE
				{
				mINT_VALUE(); 

				}
				break;
			case 27 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:187: Ident
				{
				mIdent(); 

				}
				break;
			case 28 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:193: WS
				{
				mWS(); 

				}
				break;
			case 29 :
				// src/org/uva/sea/ql/parser/antlr/QL.g:1:196: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\33\6\uffff\1\35\1\uffff\1\37\1\uffff\1\41\1\42\1\30\3\uffff"+
		"\5\30\1\55\14\uffff\4\30\1\62\3\30\2\uffff\4\30\1\uffff\3\30\1\75\5\30"+
		"\1\103\1\uffff\1\103\3\30\1\107\1\uffff\2\30\1\107\1\uffff\2\107";
	static final String DFA8_eofS =
		"\112\uffff";
	static final String DFA8_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\0\1\141\3\uffff\1"+
		"\157\1\146\1\164\1\157\1\162\1\56\14\uffff\1\162\1\154\1\157\1\164\1\60"+
		"\1\162\1\156\1\165\2\uffff\1\155\1\163\1\154\1\145\1\uffff\1\151\2\145"+
		"\1\60\2\145\1\147\1\156\1\171\1\60\1\uffff\1\60\1\141\1\145\1\147\1\60"+
		"\1\uffff\1\156\1\162\1\60\1\uffff\2\60";
	static final String DFA8_maxS =
		"\1\175\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\uffff\1\157\3\uffff"+
		"\1\157\1\156\1\164\1\157\1\162\1\71\14\uffff\1\162\1\154\1\157\1\164\1"+
		"\172\1\162\1\156\1\165\2\uffff\1\155\1\163\1\154\1\145\1\uffff\1\151\2"+
		"\145\1\172\2\145\1\147\1\156\1\171\1\172\1\uffff\1\172\1\141\1\145\1\147"+
		"\1\172\1\uffff\1\156\1\162\1\172\1\uffff\2\172";
	static final String DFA8_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\3\uffff\1"+
		"\22\1\23\1\24\6\uffff\1\33\1\34\1\2\1\1\1\35\1\11\1\14\1\13\1\17\1\16"+
		"\1\20\1\30\10\uffff\1\31\1\32\4\uffff\1\26\12\uffff\1\21\5\uffff\1\27"+
		"\3\uffff\1\25\2\uffff";
	static final String DFA8_specialS =
		"\15\uffff\1\0\74\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\31\2\uffff\1\31\22\uffff\1\31\1\1\1\15\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\27\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\30\6\uffff\1\30\1\22\3\30\1\16\2\30\1\23\3\30\1\25\5\30\1\24"+
			"\1\26\6\30\1\17\1\20\1\21",
			"\1\32",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\34",
			"",
			"\1\36",
			"",
			"\1\40",
			"\0\43",
			"\1\45\15\uffff\1\44",
			"",
			"",
			"",
			"\1\46",
			"\1\50\7\uffff\1\47",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54\1\uffff\12\27",
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
			"\1\56",
			"\1\57",
			"\1\60",
			"\1\61",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\63",
			"\1\64",
			"\1\65",
			"",
			"",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"",
			"\1\72",
			"\1\73",
			"\1\74",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\1\104",
			"\1\105",
			"\1\106",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\1\110",
			"\1\111",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
			"\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30"
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
			return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | TYPE | IF | BOOLEAN_VALUE | STRING_VALUE | MONEY_VALUE | INT_VALUE | Ident | WS | COMMENT );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA8_13 = input.LA(1);
						s = -1;
						if ( ((LA8_13 >= '\u0000' && LA8_13 <= '\uFFFF')) ) {s = 35;}
						else s = 34;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 8, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
