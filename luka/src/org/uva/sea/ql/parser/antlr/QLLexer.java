// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-20 20:03:01

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
	@Override public String getGrammarFileName() { return "/Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:172:5: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:172:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:172:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:13: ( ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* ) )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
			{
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:16: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:21: ( . )*
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
							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:21: .
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:31: '//' (~ ( '\\r' | '\\n' ) )*
					{
					match("//"); 

					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:173:36: (~ ( '\\r' | '\\n' ) )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:175:10: ( 'form' )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:175:12: 'form'
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:176:9: ( 'boolean' )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:176:11: 'boolean'
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:177:7: ( 'money' )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:177:9: 'money'
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:179:4: ( 'if' )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:179:6: 'if'
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:181:9: ( 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:181:11: 'A' .. 'Z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			{
			matchRange('A','Z'); 
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:181:20: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:182:12: ( 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:182:14: 'a' .. 'z' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
			{
			matchRange('a','z'); 
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:182:22: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:183:9: ( '\"' ( . )* '\"' )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:183:11: '\"' ( . )* '\"'
			{
			match('\"'); 
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:183:15: ( . )*
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:183:15: .
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:187:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+ )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:187:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:187:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )+
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:188:4: ( ( '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:188:6: ( '0' .. '9' )+
			{
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:188:6: ( '0' .. '9' )+
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
					// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:190:5: ( '{' )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:190:7: '{'
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
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:5: ( '}' )
			// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:191:7: '}'
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
		// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( WS | COMMENT | FormStart | Boolean | Money | IF | FormId | QuestionId | Question | Ident | Int | Lbr | Rbr )
		int alt10=13;
		alt10 = dfa10.predict(input);
		switch (alt10) {
			case 1 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: WS
				{
				mWS(); 

				}
				break;
			case 2 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:13: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 3 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:21: FormStart
				{
				mFormStart(); 

				}
				break;
			case 4 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:31: Boolean
				{
				mBoolean(); 

				}
				break;
			case 5 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:39: Money
				{
				mMoney(); 

				}
				break;
			case 6 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:45: IF
				{
				mIF(); 

				}
				break;
			case 7 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:48: FormId
				{
				mFormId(); 

				}
				break;
			case 8 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:55: QuestionId
				{
				mQuestionId(); 

				}
				break;
			case 9 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:66: Question
				{
				mQuestion(); 

				}
				break;
			case 10 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:75: Ident
				{
				mIdent(); 

				}
				break;
			case 11 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:81: Int
				{
				mInt(); 

				}
				break;
			case 12 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:85: Lbr
				{
				mLbr(); 

				}
				break;
			case 13 :
				// /Users/luc0/Desktop/Software_Creation/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:89: Rbr
				{
				mRbr(); 

				}
				break;

		}
	}


	protected DFA10 dfa10 = new DFA10(this);
	static final String DFA10_eotS =
		"\15\uffff\2\25\1\uffff\2\25\1\30\1\31\1\25\1\uffff\2\25\2\uffff\1\35\2"+
		"\25\1\uffff\1\25\1\41\1\25\1\uffff\1\43\1\uffff";
	static final String DFA10_eofS =
		"\44\uffff";
	static final String DFA10_minS =
		"\1\11\2\uffff\6\60\4\uffff\2\60\1\uffff\5\60\1\uffff\2\60\2\uffff\3\60"+
		"\1\uffff\3\60\1\uffff\1\60\1\uffff";
	static final String DFA10_maxS =
		"\1\175\2\uffff\6\172\4\uffff\2\172\1\uffff\5\172\1\uffff\2\172\2\uffff"+
		"\3\172\1\uffff\3\172\1\uffff\1\172\1\uffff";
	static final String DFA10_acceptS =
		"\1\uffff\1\1\1\2\6\uffff\1\11\1\13\1\14\1\15\2\uffff\1\12\5\uffff\1\10"+
		"\2\uffff\1\6\1\7\3\uffff\1\3\3\uffff\1\5\1\uffff\1\4";
	static final String DFA10_specialS =
		"\44\uffff}>";
	static final String[] DFA10_transitionS = {
			"\2\1\1\uffff\2\1\22\uffff\1\1\1\uffff\1\11\14\uffff\1\2\12\12\7\uffff"+
			"\32\7\6\uffff\1\10\1\4\3\10\1\3\2\10\1\6\3\10\1\5\15\10\1\13\1\uffff"+
			"\1\14",
			"",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\16\16\1\15\13\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\16\16\1\20\13\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\16\16\1\21\13\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\5\16\1\22\24\16",
			"\12\23\7\uffff\32\23\4\uffff\1\17\1\uffff\32\23",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\32\16",
			"",
			"",
			"",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\21\16\1\24\10\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\32\16",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\16\16\1\26\13\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\15\16\1\27\14\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\32\16",
			"\12\23\7\uffff\32\23\4\uffff\1\17\1\uffff\32\23",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\14\16\1\32\15\16",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\13\16\1\33\16\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\4\16\1\34\25\16",
			"",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\32\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\4\16\1\36\25\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\30\16\1\37\1\16",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\1\40\31\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\32\16",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\15\16\1\42\14\16",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\17\1\uffff\32\16",
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
			return "1:1: Tokens : ( WS | COMMENT | FormStart | Boolean | Money | IF | FormId | QuestionId | Question | Ident | Int | Lbr | Rbr );";
		}
	}

}
