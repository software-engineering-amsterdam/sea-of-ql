// $ANTLR 3.5 src/main/java/eu/karuza/ql/parser/antlr/QL.g 2013-02-25 15:05:50

package eu.karuza.ql.parser.antlr;
import eu.karuza.ql.error.*;


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
	public static final int BOOLEAN_VALUE=4;
	public static final int COMMENT=5;
	public static final int ELSE=6;
	public static final int IF=7;
	public static final int INT_VALUE=8;
	public static final int Ident=9;
	public static final int MONEY_VALUE=10;
	public static final int NL=11;
	public static final int STRING_VALUE=12;
	public static final int TYPE=13;
	public static final int WS=14;

	  @Override
	  public void reportError(RecognitionException e) {
	    throw new RuntimeException(e); 
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
	@Override public String getGrammarFileName() { return "src/main/java/eu/karuza/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:13:7: ( '!' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:13:9: '!'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:14:7: ( '!=' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:14:9: '!='
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:15:7: ( '&&' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:15:9: '&&'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:16:7: ( '(' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:16:9: '('
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:17:7: ( ')' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:17:9: ')'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:18:7: ( '*' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:18:9: '*'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:19:7: ( '+' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:19:9: '+'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:20:7: ( '-' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:20:9: '-'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:21:7: ( '/' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:21:9: '/'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:22:7: ( ':' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:22:9: ':'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:23:7: ( '<' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:23:9: '<'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:24:7: ( '<=' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:24:9: '<='
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:25:7: ( '==' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:25:9: '=='
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:26:7: ( '>' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:26:9: '>'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:27:7: ( '>=' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:27:9: '>='
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:28:7: ( 'form' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:28:9: 'form'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:29:7: ( '{' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:29:9: '{'
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:30:7: ( '||' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:30:9: '||'
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

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:31:7: ( '}' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:31:9: '}'
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
	// $ANTLR end "T__33"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:150:6: ( 'boolean' | 'integer' | 'string' | 'money' )
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:150:8: 'boolean'
					{
					match("boolean"); 

					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:150:20: 'integer'
					{
					match("integer"); 

					}
					break;
				case 3 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:150:32: 'string'
					{
					match("string"); 

					}
					break;
				case 4 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:150:43: 'money'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:152:4: ( 'if' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:152:6: 'if'
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

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:154:6: ( 'else' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:154:8: 'else'
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

	// $ANTLR start "BOOLEAN_VALUE"
	public final void mBOOLEAN_VALUE() throws RecognitionException {
		try {
			int _type = BOOLEAN_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:156:14: ( 'true' | 'false' )
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:156:16: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:156:25: 'false'
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:158:14: ( '\\\"' ( . )* '\\\"' )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:158:16: '\\\"' ( . )* '\\\"'
			{
			match('\"'); 
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:158:21: ( . )*
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:158:21: .
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:160:13: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:160:15: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:160:15: ( '0' .. '9' )+
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:160:31: ( '0' .. '9' )+
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:
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
	// $ANTLR end "MONEY_VALUE"

	// $ANTLR start "INT_VALUE"
	public final void mINT_VALUE() throws RecognitionException {
		try {
			int _type = INT_VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:162:10: ( ( '0' .. '9' )+ )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:162:12: ( '0' .. '9' )+
			{
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:162:12: ( '0' .. '9' )+
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
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:
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
	// $ANTLR end "INT_VALUE"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:164:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:164:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:164:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:
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

	// $ANTLR start "NL"
	public final void mNL() throws RecognitionException {
		try {
			int _type = NL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:166:4: ( ( '\\n' | '\\r' | '\\n\\r' ) )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:166:6: ( '\\n' | '\\r' | '\\n\\r' )
			{
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:166:6: ( '\\n' | '\\r' | '\\n\\r' )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='\n') ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1=='\r') ) {
					alt8=3;
				}

				else {
					alt8=1;
				}

			}
			else if ( (LA8_0=='\r') ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:166:7: '\\n'
					{
					match('\n'); 
					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:166:14: '\\r'
					{
					match('\r'); 
					}
					break;
				case 3 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:166:21: '\\n\\r'
					{
					match("\n\r"); 

					}
					break;

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
	// $ANTLR end "NL"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:168:5: ( ( ' ' | '\\t' ) )
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:168:7: ( ' ' | '\\t' )
			{
			if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
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
			// src/main/java/eu/karuza/ql/parser/antlr/QL.g:170:9: ( '/*' ( . )* '*/' | '//' ( . )* NL )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='/') ) {
				int LA11_1 = input.LA(2);
				if ( (LA11_1=='*') ) {
					alt11=1;
				}
				else if ( (LA11_1=='/') ) {
					alt11=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:170:11: '/*' ( . )* '*/'
					{
					match("/*"); 

					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:170:16: ( . )*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0=='*') ) {
							int LA9_1 = input.LA(2);
							if ( (LA9_1=='/') ) {
								alt9=2;
							}
							else if ( ((LA9_1 >= '\u0000' && LA9_1 <= '.')||(LA9_1 >= '0' && LA9_1 <= '\uFFFF')) ) {
								alt9=1;
							}

						}
						else if ( ((LA9_0 >= '\u0000' && LA9_0 <= ')')||(LA9_0 >= '+' && LA9_0 <= '\uFFFF')) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// src/main/java/eu/karuza/ql/parser/antlr/QL.g:170:16: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop9;
						}
					}

					match("*/"); 

					}
					break;
				case 2 :
					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:170:26: '//' ( . )* NL
					{
					match("//"); 

					// src/main/java/eu/karuza/ql/parser/antlr/QL.g:170:31: ( . )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0=='\n') ) {
							alt10=2;
						}
						else if ( (LA10_0=='\r') ) {
							alt10=2;
						}
						else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF')) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// src/main/java/eu/karuza/ql/parser/antlr/QL.g:170:31: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop10;
						}
					}

					mNL(); 

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

	@Override
	public void mTokens() throws RecognitionException {
		// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | TYPE | IF | ELSE | BOOLEAN_VALUE | STRING_VALUE | MONEY_VALUE | INT_VALUE | Ident | NL | WS | COMMENT )
		int alt12=30;
		alt12 = dfa12.predict(input);
		switch (alt12) {
			case 1 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:10: T__15
				{
				mT__15(); 

				}
				break;
			case 2 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:16: T__16
				{
				mT__16(); 

				}
				break;
			case 3 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:22: T__17
				{
				mT__17(); 

				}
				break;
			case 4 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:28: T__18
				{
				mT__18(); 

				}
				break;
			case 5 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:34: T__19
				{
				mT__19(); 

				}
				break;
			case 6 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:40: T__20
				{
				mT__20(); 

				}
				break;
			case 7 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:46: T__21
				{
				mT__21(); 

				}
				break;
			case 8 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:52: T__22
				{
				mT__22(); 

				}
				break;
			case 9 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:58: T__23
				{
				mT__23(); 

				}
				break;
			case 10 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:64: T__24
				{
				mT__24(); 

				}
				break;
			case 11 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:70: T__25
				{
				mT__25(); 

				}
				break;
			case 12 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:76: T__26
				{
				mT__26(); 

				}
				break;
			case 13 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:82: T__27
				{
				mT__27(); 

				}
				break;
			case 14 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:88: T__28
				{
				mT__28(); 

				}
				break;
			case 15 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:94: T__29
				{
				mT__29(); 

				}
				break;
			case 16 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:100: T__30
				{
				mT__30(); 

				}
				break;
			case 17 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:106: T__31
				{
				mT__31(); 

				}
				break;
			case 18 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:112: T__32
				{
				mT__32(); 

				}
				break;
			case 19 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:118: T__33
				{
				mT__33(); 

				}
				break;
			case 20 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:124: TYPE
				{
				mTYPE(); 

				}
				break;
			case 21 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:129: IF
				{
				mIF(); 

				}
				break;
			case 22 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:132: ELSE
				{
				mELSE(); 

				}
				break;
			case 23 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:137: BOOLEAN_VALUE
				{
				mBOOLEAN_VALUE(); 

				}
				break;
			case 24 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:151: STRING_VALUE
				{
				mSTRING_VALUE(); 

				}
				break;
			case 25 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:164: MONEY_VALUE
				{
				mMONEY_VALUE(); 

				}
				break;
			case 26 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:176: INT_VALUE
				{
				mINT_VALUE(); 

				}
				break;
			case 27 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:186: Ident
				{
				mIdent(); 

				}
				break;
			case 28 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:192: NL
				{
				mNL(); 

				}
				break;
			case 29 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:195: WS
				{
				mWS(); 

				}
				break;
			case 30 :
				// src/main/java/eu/karuza/ql/parser/antlr/QL.g:1:198: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA12 dfa12 = new DFA12(this);
	static final String DFA12_eotS =
		"\1\uffff\1\35\6\uffff\1\37\1\uffff\1\41\1\uffff\1\43\1\31\3\uffff\6\31"+
		"\1\uffff\1\56\13\uffff\4\31\1\63\4\31\2\uffff\4\31\1\uffff\4\31\1\100"+
		"\5\31\1\106\1\107\1\uffff\1\107\3\31\1\113\2\uffff\2\31\1\113\1\uffff"+
		"\2\113";
	static final String DFA12_eofS =
		"\116\uffff";
	static final String DFA12_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\141\3\uffff\1\157"+
		"\1\146\1\164\1\157\1\154\1\162\1\uffff\1\56\13\uffff\1\162\1\154\1\157"+
		"\1\164\1\60\1\162\1\156\1\163\1\165\2\uffff\1\155\1\163\1\154\1\145\1"+
		"\uffff\1\151\3\145\1\60\2\145\1\147\1\156\1\171\2\60\1\uffff\1\60\1\141"+
		"\1\145\1\147\1\60\2\uffff\1\156\1\162\1\60\1\uffff\2\60";
	static final String DFA12_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\157\3\uffff\1\157"+
		"\1\156\1\164\1\157\1\154\1\162\1\uffff\1\71\13\uffff\1\162\1\154\1\157"+
		"\1\164\1\172\1\162\1\156\1\163\1\165\2\uffff\1\155\1\163\1\154\1\145\1"+
		"\uffff\1\151\3\145\1\172\2\145\1\147\1\156\1\171\2\172\1\uffff\1\172\1"+
		"\141\1\145\1\147\1\172\2\uffff\1\156\1\162\1\172\1\uffff\2\172";
	static final String DFA12_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\2\uffff\1"+
		"\21\1\22\1\23\6\uffff\1\30\1\uffff\1\33\1\34\1\35\1\2\1\1\1\36\1\11\1"+
		"\14\1\13\1\17\1\16\11\uffff\1\31\1\32\4\uffff\1\25\14\uffff\1\20\5\uffff"+
		"\1\26\1\27\3\uffff\1\24\2\uffff";
	static final String DFA12_specialS =
		"\116\uffff}>";
	static final String[] DFA12_transitionS = {
			"\1\33\1\32\2\uffff\1\32\22\uffff\1\33\1\1\1\27\3\uffff\1\2\1\uffff\1"+
			"\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\30\1\11\1\uffff\1\12\1\13"+
			"\1\14\2\uffff\32\31\6\uffff\1\31\1\21\2\31\1\25\1\15\2\31\1\22\3\31\1"+
			"\24\5\31\1\23\1\26\6\31\1\16\1\17\1\20",
			"\1\34",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\36\4\uffff\1\36",
			"",
			"\1\40",
			"",
			"\1\42",
			"\1\45\15\uffff\1\44",
			"",
			"",
			"",
			"\1\46",
			"\1\50\7\uffff\1\47",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"",
			"\1\55\1\uffff\12\30",
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
			"\1\57",
			"\1\60",
			"\1\61",
			"\1\62",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"",
			"",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\1\110",
			"\1\111",
			"\1\112",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"",
			"\1\114",
			"\1\115",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31",
			"\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32\31"
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
			return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | TYPE | IF | ELSE | BOOLEAN_VALUE | STRING_VALUE | MONEY_VALUE | INT_VALUE | Ident | NL | WS | COMMENT );";
		}
	}

}
