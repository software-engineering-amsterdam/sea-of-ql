// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-24 18:57:15

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int BOOL_LITERAL=4;
	public static final int BOOL_TYPE=5;
	public static final int Boolean=6;
	public static final int COMMENT=7;
	public static final int CONST_NAME=8;
	public static final int CONST_TYPE=9;
	public static final int CONST_TYPE_INT=10;
	public static final int CONST_VALUE=11;
	public static final int CONST_VAR=12;
	public static final int Else=13;
	public static final int FormStart=14;
	public static final int IDENT_LITERAL=15;
	public static final int IF_BLOCK=16;
	public static final int IF_EXPRESSION=17;
	public static final int IF_FALSE=18;
	public static final int IF_TRUE=19;
	public static final int INT_LITERAL=20;
	public static final int INT_TYPE=21;
	public static final int Ident=22;
	public static final int If=23;
	public static final int Int=24;
	public static final int Lbr=25;
	public static final int MONEY_LITERAL=26;
	public static final int MONEY_TYPE=27;
	public static final int Money=28;
	public static final int NEG_EXPR=29;
	public static final int QUESTION_BLOCK=30;
	public static final int QUESTION_LABEL=31;
	public static final int QUESTION_VAR=32;
	public static final int QuestionLabel=33;
	public static final int Rbr=34;
	public static final int STR_LITERAL=35;
	public static final int STR_TYPE=36;
	public static final int UNARY_EXPR=37;
	public static final int VALUE_CALC=38;
	public static final int VAR_NAME=39;
	public static final int VAR_TYPE=40;
	public static final int VAR_VALUE=41;
	public static final int WS=42;

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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!'
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
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '!=' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '!='
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
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '&&' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '&&'
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
	// $ANTLR end "T__45"

	// $ANTLR start "T__46"
	public final void mT__46() throws RecognitionException {
		try {
			int _type = T__46;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( '(' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: '('
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
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( ')' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: ')'
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
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '*' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '*'
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
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '+' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '+'
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
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '-' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '-'
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
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '/' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: '/'
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
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( ':' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: ':'
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
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<'
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
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '<=' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '<='
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
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '==' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '=='
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
	// $ANTLR end "T__55"

	// $ANTLR start "T__56"
	public final void mT__56() throws RecognitionException {
		try {
			int _type = T__56;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>'
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
	// $ANTLR end "T__56"

	// $ANTLR start "T__57"
	public final void mT__57() throws RecognitionException {
		try {
			int _type = T__57;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '>=' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '>='
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
	// $ANTLR end "T__57"

	// $ANTLR start "T__58"
	public final void mT__58() throws RecognitionException {
		try {
			int _type = T__58;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( '||' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: '||'
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
	// $ANTLR end "T__58"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:190:5: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:190:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:190:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:13: ( ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:16: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:21: ( . )*
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
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:21: .
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:31: '//' (~ ( '\\r' | '\\n' ) )*
					{
					match("//"); 

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:36: (~ ( '\\r' | '\\n' ) )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:193:10: ( 'form' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:193:12: 'form'
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:9: ( 'boolean' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:11: 'boolean'
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:195:7: ( 'money' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:195:9: 'money'
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

	// $ANTLR start "If"
	public final void mIf() throws RecognitionException {
		try {
			int _type = If;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:197:4: ( 'if' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:197:6: 'if'
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
	// $ANTLR end "If"

	// $ANTLR start "Else"
	public final void mElse() throws RecognitionException {
		try {
			int _type = Else;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:198:6: ( 'else' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:198:8: 'else'
			{
			match("else"); 

			 System.out.println("Lex ELSE: "+getText()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Else"

	// $ANTLR start "QuestionLabel"
	public final void mQuestionLabel() throws RecognitionException {
		try {
			int _type = QuestionLabel;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:201:14: ( '\"' ( . )* '\"' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:201:16: '\"' ( . )* '\"'
			{
			match('\"'); 
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:201:20: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\"') ) {
					alt5=2;
				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:201:20: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
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
	// $ANTLR end "QuestionLabel"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:205:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:205:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:205:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:206:4: ( ( '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:206:6: ( '0' .. '9' )+
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:206:6: ( '0' .. '9' )+
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:208:5: ( '{' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:208:7: '{'
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:209:5: ( '}' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:209:7: '}'
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
		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | WS | COMMENT | FormStart | Boolean | Money | If | Else | QuestionLabel | Ident | Int | Lbr | Rbr )
		int alt8=28;
		switch ( input.LA(1) ) {
		case '!':
			{
			int LA8_1 = input.LA(2);
			if ( (LA8_1=='=') ) {
				alt8=2;
			}

			else {
				alt8=1;
			}

			}
			break;
		case '&':
			{
			alt8=3;
			}
			break;
		case '(':
			{
			alt8=4;
			}
			break;
		case ')':
			{
			alt8=5;
			}
			break;
		case '*':
			{
			alt8=6;
			}
			break;
		case '+':
			{
			alt8=7;
			}
			break;
		case '-':
			{
			alt8=8;
			}
			break;
		case '/':
			{
			int LA8_8 = input.LA(2);
			if ( (LA8_8=='*'||LA8_8=='/') ) {
				alt8=18;
			}

			else {
				alt8=9;
			}

			}
			break;
		case ':':
			{
			alt8=10;
			}
			break;
		case '<':
			{
			int LA8_10 = input.LA(2);
			if ( (LA8_10=='=') ) {
				alt8=12;
			}

			else {
				alt8=11;
			}

			}
			break;
		case '=':
			{
			alt8=13;
			}
			break;
		case '>':
			{
			int LA8_12 = input.LA(2);
			if ( (LA8_12=='=') ) {
				alt8=15;
			}

			else {
				alt8=14;
			}

			}
			break;
		case '|':
			{
			alt8=16;
			}
			break;
		case '\t':
		case '\n':
		case '\f':
		case '\r':
		case ' ':
			{
			alt8=17;
			}
			break;
		case 'f':
			{
			int LA8_15 = input.LA(2);
			if ( (LA8_15=='o') ) {
				int LA8_33 = input.LA(3);
				if ( (LA8_33=='r') ) {
					int LA8_38 = input.LA(4);
					if ( (LA8_38=='m') ) {
						int LA8_43 = input.LA(5);
						if ( ((LA8_43 >= '0' && LA8_43 <= '9')||(LA8_43 >= 'A' && LA8_43 <= 'Z')||LA8_43=='_'||(LA8_43 >= 'a' && LA8_43 <= 'z')) ) {
							alt8=25;
						}

						else {
							alt8=19;
						}

					}

					else {
						alt8=25;
					}

				}

				else {
					alt8=25;
				}

			}
			else if ( ((LA8_15 >= '0' && LA8_15 <= '9')||(LA8_15 >= 'A' && LA8_15 <= 'Z')||LA8_15=='_'||(LA8_15 >= 'a' && LA8_15 <= 'n')||(LA8_15 >= 'p' && LA8_15 <= 'z')) ) {
				alt8=25;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 8, 15, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'b':
			{
			int LA8_16 = input.LA(2);
			if ( (LA8_16=='o') ) {
				int LA8_34 = input.LA(3);
				if ( (LA8_34=='o') ) {
					int LA8_39 = input.LA(4);
					if ( (LA8_39=='l') ) {
						int LA8_44 = input.LA(5);
						if ( (LA8_44=='e') ) {
							int LA8_48 = input.LA(6);
							if ( (LA8_48=='a') ) {
								int LA8_51 = input.LA(7);
								if ( (LA8_51=='n') ) {
									int LA8_53 = input.LA(8);
									if ( ((LA8_53 >= '0' && LA8_53 <= '9')||(LA8_53 >= 'A' && LA8_53 <= 'Z')||LA8_53=='_'||(LA8_53 >= 'a' && LA8_53 <= 'z')) ) {
										alt8=25;
									}

									else {
										alt8=20;
									}

								}

								else {
									alt8=25;
								}

							}

							else {
								alt8=25;
							}

						}

						else {
							alt8=25;
						}

					}

					else {
						alt8=25;
					}

				}

				else {
					alt8=25;
				}

			}
			else if ( ((LA8_16 >= '0' && LA8_16 <= '9')||(LA8_16 >= 'A' && LA8_16 <= 'Z')||LA8_16=='_'||(LA8_16 >= 'a' && LA8_16 <= 'n')||(LA8_16 >= 'p' && LA8_16 <= 'z')) ) {
				alt8=25;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 8, 16, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'm':
			{
			int LA8_17 = input.LA(2);
			if ( (LA8_17=='o') ) {
				int LA8_35 = input.LA(3);
				if ( (LA8_35=='n') ) {
					int LA8_40 = input.LA(4);
					if ( (LA8_40=='e') ) {
						int LA8_45 = input.LA(5);
						if ( (LA8_45=='y') ) {
							int LA8_49 = input.LA(6);
							if ( ((LA8_49 >= '0' && LA8_49 <= '9')||(LA8_49 >= 'A' && LA8_49 <= 'Z')||LA8_49=='_'||(LA8_49 >= 'a' && LA8_49 <= 'z')) ) {
								alt8=25;
							}

							else {
								alt8=21;
							}

						}

						else {
							alt8=25;
						}

					}

					else {
						alt8=25;
					}

				}

				else {
					alt8=25;
				}

			}
			else if ( ((LA8_17 >= '0' && LA8_17 <= '9')||(LA8_17 >= 'A' && LA8_17 <= 'Z')||LA8_17=='_'||(LA8_17 >= 'a' && LA8_17 <= 'n')||(LA8_17 >= 'p' && LA8_17 <= 'z')) ) {
				alt8=25;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 8, 17, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'i':
			{
			int LA8_18 = input.LA(2);
			if ( (LA8_18=='f') ) {
				int LA8_36 = input.LA(3);
				if ( ((LA8_36 >= '0' && LA8_36 <= '9')||(LA8_36 >= 'A' && LA8_36 <= 'Z')||LA8_36=='_'||(LA8_36 >= 'a' && LA8_36 <= 'z')) ) {
					alt8=25;
				}

				else {
					alt8=22;
				}

			}
			else if ( ((LA8_18 >= '0' && LA8_18 <= '9')||(LA8_18 >= 'A' && LA8_18 <= 'Z')||LA8_18=='_'||(LA8_18 >= 'a' && LA8_18 <= 'e')||(LA8_18 >= 'g' && LA8_18 <= 'z')) ) {
				alt8=25;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 8, 18, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case 'e':
			{
			int LA8_19 = input.LA(2);
			if ( (LA8_19=='l') ) {
				int LA8_37 = input.LA(3);
				if ( (LA8_37=='s') ) {
					int LA8_42 = input.LA(4);
					if ( (LA8_42=='e') ) {
						int LA8_46 = input.LA(5);
						if ( ((LA8_46 >= '0' && LA8_46 <= '9')||(LA8_46 >= 'A' && LA8_46 <= 'Z')||LA8_46=='_'||(LA8_46 >= 'a' && LA8_46 <= 'z')) ) {
							alt8=25;
						}

						else {
							alt8=23;
						}

					}

					else {
						alt8=25;
					}

				}

				else {
					alt8=25;
				}

			}
			else if ( ((LA8_19 >= '0' && LA8_19 <= '9')||(LA8_19 >= 'A' && LA8_19 <= 'Z')||LA8_19=='_'||(LA8_19 >= 'a' && LA8_19 <= 'k')||(LA8_19 >= 'm' && LA8_19 <= 'z')) ) {
				alt8=25;
			}

			else {
				int nvaeMark = input.mark();
				try {
					input.consume();
					NoViableAltException nvae =
						new NoViableAltException("", 8, 19, input);
					throw nvae;
				} finally {
					input.rewind(nvaeMark);
				}
			}

			}
			break;
		case '\"':
			{
			alt8=24;
			}
			break;
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
		case 'c':
		case 'd':
		case 'g':
		case 'h':
		case 'j':
		case 'k':
		case 'l':
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
			alt8=25;
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
			alt8=26;
			}
			break;
		case '{':
			{
			alt8=27;
			}
			break;
		case '}':
			{
			alt8=28;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 8, 0, input);
			throw nvae;
		}
		switch (alt8) {
			case 1 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__43
				{
				mT__43(); 

				}
				break;
			case 2 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__44
				{
				mT__44(); 

				}
				break;
			case 3 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__45
				{
				mT__45(); 

				}
				break;
			case 4 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__46
				{
				mT__46(); 

				}
				break;
			case 5 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__47
				{
				mT__47(); 

				}
				break;
			case 6 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__48
				{
				mT__48(); 

				}
				break;
			case 7 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__49
				{
				mT__49(); 

				}
				break;
			case 8 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__50
				{
				mT__50(); 

				}
				break;
			case 9 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__51
				{
				mT__51(); 

				}
				break;
			case 10 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__52
				{
				mT__52(); 

				}
				break;
			case 11 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__53
				{
				mT__53(); 

				}
				break;
			case 12 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__54
				{
				mT__54(); 

				}
				break;
			case 13 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__55
				{
				mT__55(); 

				}
				break;
			case 14 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__56
				{
				mT__56(); 

				}
				break;
			case 15 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__57
				{
				mT__57(); 

				}
				break;
			case 16 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__58
				{
				mT__58(); 

				}
				break;
			case 17 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: WS
				{
				mWS(); 

				}
				break;
			case 18 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:109: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 19 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:117: FormStart
				{
				mFormStart(); 

				}
				break;
			case 20 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:127: Boolean
				{
				mBoolean(); 

				}
				break;
			case 21 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:135: Money
				{
				mMoney(); 

				}
				break;
			case 22 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:141: If
				{
				mIf(); 

				}
				break;
			case 23 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:144: Else
				{
				mElse(); 

				}
				break;
			case 24 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:149: QuestionLabel
				{
				mQuestionLabel(); 

				}
				break;
			case 25 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:163: Ident
				{
				mIdent(); 

				}
				break;
			case 26 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:169: Int
				{
				mInt(); 

				}
				break;
			case 27 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:173: Lbr
				{
				mLbr(); 

				}
				break;
			case 28 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:177: Rbr
				{
				mRbr(); 

				}
				break;

		}
	}



}
