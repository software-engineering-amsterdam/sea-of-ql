// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-19 21:14:47

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


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
	public static final int Boolean=4;
	public static final int COMMENT=5;
	public static final int FormId=6;
	public static final int FormStart=7;
	public static final int IF=8;
	public static final int Ident=9;
	public static final int Int=10;
	public static final int Lbr=11;
	public static final int Money=12;
	public static final int Question=13;
	public static final int QuestionId=14;
	public static final int Rbr=15;
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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!'
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
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '!=' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '!='
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
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '&&' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '&&'
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
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( '(' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: '('
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( ')' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: ')'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '*' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '*'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '+' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '+'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '-' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '-'
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '/' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: '/'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( ':' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: ':'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '<=' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '<='
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '==' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '=='
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '>=' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '>='
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( '||' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: '||'
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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:171:5: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:171:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:171:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
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

			 _channel = HIDDEN; 
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
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:13: ( ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* ) )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
			{
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
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
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:16: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:21: ( . )*
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
							// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:21: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop2;
						}
					}

					match("*/"); 

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:31: '//' (~ ( '\\r' | '\\n' ) )*
					{
					match("//"); 

					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:172:36: (~ ( '\\r' | '\\n' ) )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

					}
					break;

			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "FormStart"
	public final void mFormStart() throws RecognitionException {
		try {
			int _type = FormStart;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:174:10: ( 'form' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:174:12: 'form'
			{
			match("form"); 

			 System.out.println("Lex Start: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FormStart"

	// $ANTLR start "Boolean"
	public final void mBoolean() throws RecognitionException {
		try {
			int _type = Boolean;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:175:9: ( 'boolean' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:175:11: 'boolean'
			{
			match("boolean"); 

			 System.out.println("Lex Boolean: "+getText()); 
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
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:176:7: ( 'money' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:176:9: 'money'
			{
			match("money"); 

			 System.out.println("Lex Money: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Money"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:178:4: ( 'if' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:178:6: 'if'
			{
			match("if"); 

			 System.out.println("Lex IF: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "FormId"
	public final void mFormId() throws RecognitionException {
		try {
			int _type = FormId;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:9: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:11: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			{
			matchRange('A','Z'); 
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:180:20: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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

			 System.out.println("Lex FormId: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FormId"

	// $ANTLR start "QuestionId"
	public final void mQuestionId() throws RecognitionException {
		try {
			int _type = QuestionId;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:181:12: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:181:14: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			{
			matchRange('a','z'); 
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:181:22: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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

			 System.out.println("Lex QuesionID: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QuestionId"

	// $ANTLR start "Question"
	public final void mQuestion() throws RecognitionException {
		try {
			int _type = Question;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:182:9: ( '\"' ( . )* '\"' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:182:11: '\"' ( . )* '\"'
			{
			match('\"'); 
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:182:15: ( . )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\"') ) {
					alt7=2;
				}
				else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:182:15: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop7;
				}
			}

			match('\"'); 
			 System.out.println("Lex Question: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Question"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:186:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:186:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:186:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')||(LA8_0 >= 'A' && LA8_0 <= 'Z')||LA8_0=='_'||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			 System.out.println("Lex Ident: "+getText()); 
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
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:187:4: ( ( '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:187:6: ( '0' .. '9' )+
			{
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:187:6: ( '0' .. '9' )+
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
					// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

			 System.out.println("Lex Int: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Int"

	// $ANTLR start "Lbr"
	public final void mLbr() throws RecognitionException {
		try {
			int _type = Lbr;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:189:5: ( '{' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:189:7: '{'
			{
			match('{'); 
			 System.out.println("Lex {: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Lbr"

	// $ANTLR start "Rbr"
	public final void mRbr() throws RecognitionException {
		try {
			int _type = Rbr;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:190:5: ( '}' )
			// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:190:7: '}'
			{
			match('}'); 
			 System.out.println("Lex }: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Rbr"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | WS | COMMENT | FormStart | Boolean | Money | IF | FormId | QuestionId | Question | Ident | Int | Lbr | Rbr )
		int alt10=29;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__17
				{
				mT__17(); 

				}
				break;
			case 2 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__18
				{
				mT__18(); 

				}
				break;
			case 3 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__19
				{
				mT__19(); 

				}
				break;
			case 4 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__20
				{
				mT__20(); 

				}
				break;
			case 5 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__21
				{
				mT__21(); 

				}
				break;
			case 6 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__22
				{
				mT__22(); 

				}
				break;
			case 7 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__23
				{
				mT__23(); 

				}
				break;
			case 8 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__24
				{
				mT__24(); 

				}
				break;
			case 9 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__25
				{
				mT__25(); 

				}
				break;
			case 10 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__26
				{
				mT__26(); 

				}
				break;
			case 11 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__27
				{
				mT__27(); 

				}
				break;
			case 12 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__28
				{
				mT__28(); 

				}
				break;
			case 13 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__29
				{
				mT__29(); 

				}
				break;
			case 14 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__30
				{
				mT__30(); 

				}
				break;
			case 15 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__31
				{
				mT__31(); 

				}
				break;
			case 16 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__32
				{
				mT__32(); 

				}
				break;
			case 17 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: WS
				{
				mWS(); 

				}
				break;
			case 18 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:109: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 19 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:117: FormStart
				{
				mFormStart(); 

				}
				break;
			case 20 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:127: Boolean
				{
				mBoolean(); 

				}
				break;
			case 21 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:135: Money
				{
				mMoney(); 

				}
				break;
			case 22 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:141: IF
				{
				mIF(); 

				}
				break;
			case 23 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:144: FormId
				{
				mFormId(); 

				}
				break;
			case 24 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:151: QuestionId
				{
				mQuestionId(); 

				}
				break;
			case 25 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:162: Question
				{
				mQuestion(); 

				}
				break;
			case 26 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:171: Ident
				{
				mIdent(); 

				}
				break;
			case 27 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:177: Int
				{
				mInt(); 

				}
				break;
			case 28 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:181: Lbr
				{
				mLbr(); 

				}
				break;
			case 29 :
				// /Users/luc0/Desktop/Software_Creation/code/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:185: Rbr
				{
				mRbr(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\1\uffff\1\32\6\uffff\1\34\1\uffff\1\36\1\uffff\1\40\24\uffff\2\51\1\uffff"+
		"\2\51\1\54\1\55\1\51\1\uffff\2\51\2\uffff\1\61\2\51\1\uffff\1\51\1\65"+
		"\1\51\1\uffff\1\67\1\uffff";
	static final String DFA10_eofS =
		"\70\uffff";
	static final String DFA10_minS =
		"\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\2\uffff\6\60\14\uffff"+
		"\2\60\1\uffff\5\60\1\uffff\2\60\2\uffff\3\60\1\uffff\3\60\1\uffff\1\60"+
		"\1\uffff";
	static final String DFA10_maxS =
		"\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\2\uffff\6\172\14\uffff"+
		"\2\172\1\uffff\5\172\1\uffff\2\172\2\uffff\3\172\1\uffff\3\172\1\uffff"+
		"\1\172\1\uffff";
	static final String DFA10_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\1\uffff\1"+
		"\20\1\21\6\uffff\1\31\1\33\1\34\1\35\1\2\1\1\1\22\1\11\1\14\1\13\1\17"+
		"\1\16\2\uffff\1\32\5\uffff\1\30\2\uffff\1\26\1\27\3\uffff\1\23\3\uffff"+
		"\1\25\1\uffff\1\24";
	static final String DFA10_specialS =
		"\70\uffff}>";
	static final String[] DFA10_transitionS = {
			"\2\16\1\uffff\2\16\22\uffff\1\16\1\1\1\25\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\26\1\11\1\uffff\1\12\1\13\1\14\2"+
			"\uffff\32\23\6\uffff\1\24\1\20\3\24\1\17\2\24\1\22\3\24\1\21\15\24\1"+
			"\27\1\15\1\30",
			"\1\31",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\33\4\uffff\1\33",
			"",
			"\1\35",
			"",
			"\1\37",
			"",
			"",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\16\42\1\41\13\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\16\42\1\44\13\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\16\42\1\45\13\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\5\42\1\46\24\42",
			"\12\47\7\uffff\32\47\4\uffff\1\43\1\uffff\32\47",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\32\42",
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
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\21\42\1\50\10\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\32\42",
			"",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\16\42\1\52\13\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\15\42\1\53\14\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\32\42",
			"\12\47\7\uffff\32\47\4\uffff\1\43\1\uffff\32\47",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\14\42\1\56\15\42",
			"",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\13\42\1\57\16\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\4\42\1\60\25\42",
			"",
			"",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\32\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\4\42\1\62\25\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\30\42\1\63\1\42",
			"",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\1\64\31\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\32\42",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\15\42\1\66\14\42",
			"",
			"\12\42\7\uffff\32\42\4\uffff\1\43\1\uffff\32\42",
			""
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
			return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | WS | COMMENT | FormStart | Boolean | Money | IF | FormId | QuestionId | Question | Ident | Int | Lbr | Rbr );";
		}
	}

}
