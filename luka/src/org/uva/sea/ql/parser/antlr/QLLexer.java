// $ANTLR 3.5 /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-18 23:53:38

package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
	public static final int ASSIGNMENT=4;
	public static final int ASSIGNMENT_EXPRESSION=5;
	public static final int ASSIGNMENT_TYPE=6;
	public static final int Add=7;
	public static final int And=8;
	public static final int Assignment_Indicator=9;
	public static final int BLOCK=10;
	public static final int Bool=11;
	public static final int BooleanType=12;
	public static final int COMMENT=13;
	public static final int Div=14;
	public static final int Doub=15;
	public static final int DoubleType=16;
	public static final int Else=17;
	public static final int Equ=18;
	public static final int FormStart=19;
	public static final int GT=20;
	public static final int GTEqu=21;
	public static final int IDENT=22;
	public static final int IF_BLOCK_FALSE=23;
	public static final int IF_BLOCK_TRUE=24;
	public static final int IF_CONDITION=25;
	public static final int IF_STATEMENT=26;
	public static final int Ident=27;
	public static final int If=28;
	public static final int Int=29;
	public static final int IntegerType=30;
	public static final int LT=31;
	public static final int LTEqu=32;
	public static final int Lbr=33;
	public static final int MoneyType=34;
	public static final int Mul=35;
	public static final int Not=36;
	public static final int NotEqu=37;
	public static final int Or=38;
	public static final int QUESTION_LABEL=39;
	public static final int Rbr=40;
	public static final int RoundLbr=41;
	public static final int RoundRbr=42;
	public static final int Str=43;
	public static final int StringType=44;
	public static final int Sub=45;
	public static final int UNARY_MINUS=46;
	public static final int UNARY_NEGATE=47;
	public static final int WS=48;

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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:5: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:149:7: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:13: ( ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* ) )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:15: ( '/*' ( . )* '*/' | '//' (~ ( '\\r' | '\\n' ) )* )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:16: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:21: ( . )*
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
							// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:21: .
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:31: '//' (~ ( '\\r' | '\\n' ) )*
					{
					match("//"); 

					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:150:36: (~ ( '\\r' | '\\n' ) )*
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
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:152:10: ( 'form' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:152:12: 'form'
			{
			match("form"); 

			 System.out.println("Start grammar"); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FormStart"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:7: ( 'true' | 'false' )
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:153:9: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:154:4: 'false'
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

	// $ANTLR start "BooleanType"
	public final void mBooleanType() throws RecognitionException {
		try {
			int _type = BooleanType;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:156:13: ( 'boolean' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:156:15: 'boolean'
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
	// $ANTLR end "BooleanType"

	// $ANTLR start "MoneyType"
	public final void mMoneyType() throws RecognitionException {
		try {
			int _type = MoneyType;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:157:11: ( 'money' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:157:13: 'money'
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
	// $ANTLR end "MoneyType"

	// $ANTLR start "IntegerType"
	public final void mIntegerType() throws RecognitionException {
		try {
			int _type = IntegerType;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:158:14: ( 'integer' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:158:16: 'integer'
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
	// $ANTLR end "IntegerType"

	// $ANTLR start "StringType"
	public final void mStringType() throws RecognitionException {
		try {
			int _type = StringType;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:159:12: ( 'string' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:159:14: 'string'
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
	// $ANTLR end "StringType"

	// $ANTLR start "DoubleType"
	public final void mDoubleType() throws RecognitionException {
		try {
			int _type = DoubleType;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:160:12: ( 'double' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:160:14: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DoubleType"

	// $ANTLR start "If"
	public final void mIf() throws RecognitionException {
		try {
			int _type = If;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:161:4: ( 'if' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:161:6: 'if'
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
	// $ANTLR end "If"

	// $ANTLR start "Else"
	public final void mElse() throws RecognitionException {
		try {
			int _type = Else;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:162:6: ( 'else' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:162:8: 'else'
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
	// $ANTLR end "Else"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:165:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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

	// $ANTLR start "Str"
	public final void mStr() throws RecognitionException {
		try {
			int _type = Str;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:166:4: ( '\"' ( . )* '\"' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:166:6: '\"' ( . )* '\"'
			{
			match('\"'); 
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:166:10: ( . )*
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
					// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:166:10: .
					{
					matchAny(); 
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
	// $ANTLR end "Str"

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:171:4: ( ( '0' .. '9' )+ )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:171:6: ( '0' .. '9' )+
			{
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:171:6: ( '0' .. '9' )+
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
	// $ANTLR end "Int"

	// $ANTLR start "Doub"
	public final void mDoub() throws RecognitionException {
		try {
			int _type = Doub;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:172:6: ( Int '.' Int )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:172:8: Int '.' Int
			{
			mInt(); 

			match('.'); 
			mInt(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Doub"

	// $ANTLR start "Lbr"
	public final void mLbr() throws RecognitionException {
		try {
			int _type = Lbr;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:174:5: ( '{' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:174:7: '{'
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
	// $ANTLR end "Lbr"

	// $ANTLR start "Rbr"
	public final void mRbr() throws RecognitionException {
		try {
			int _type = Rbr;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:175:5: ( '}' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:175:7: '}'
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
	// $ANTLR end "Rbr"

	// $ANTLR start "Assignment_Indicator"
	public final void mAssignment_Indicator() throws RecognitionException {
		try {
			int _type = Assignment_Indicator;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:178:22: ( ':' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:178:24: ':'
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
	// $ANTLR end "Assignment_Indicator"

	// $ANTLR start "RoundLbr"
	public final void mRoundLbr() throws RecognitionException {
		try {
			int _type = RoundLbr;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:180:10: ( '(' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:180:12: '('
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
	// $ANTLR end "RoundLbr"

	// $ANTLR start "RoundRbr"
	public final void mRoundRbr() throws RecognitionException {
		try {
			int _type = RoundRbr;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:182:10: ( ')' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:182:12: ')'
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
	// $ANTLR end "RoundRbr"

	// $ANTLR start "Mul"
	public final void mMul() throws RecognitionException {
		try {
			int _type = Mul;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:184:5: ( '*' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:184:7: '*'
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
	// $ANTLR end "Mul"

	// $ANTLR start "Div"
	public final void mDiv() throws RecognitionException {
		try {
			int _type = Div;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:186:5: ( '/' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:186:6: '/'
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
	// $ANTLR end "Div"

	// $ANTLR start "Add"
	public final void mAdd() throws RecognitionException {
		try {
			int _type = Add;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:188:5: ( '+' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:188:6: '+'
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
	// $ANTLR end "Add"

	// $ANTLR start "Sub"
	public final void mSub() throws RecognitionException {
		try {
			int _type = Sub;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:190:5: ( '-' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:190:6: '-'
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
	// $ANTLR end "Sub"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:192:4: ( '<' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:192:5: '<'
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
	// $ANTLR end "LT"

	// $ANTLR start "LTEqu"
	public final void mLTEqu() throws RecognitionException {
		try {
			int _type = LTEqu;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:7: ( '<=' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:194:8: '<='
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
	// $ANTLR end "LTEqu"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:196:4: ( '>' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:196:5: '>'
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
	// $ANTLR end "GT"

	// $ANTLR start "GTEqu"
	public final void mGTEqu() throws RecognitionException {
		try {
			int _type = GTEqu;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:198:7: ( '>=' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:198:8: '>='
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
	// $ANTLR end "GTEqu"

	// $ANTLR start "Equ"
	public final void mEqu() throws RecognitionException {
		try {
			int _type = Equ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:200:5: ( '==' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:200:6: '=='
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
	// $ANTLR end "Equ"

	// $ANTLR start "NotEqu"
	public final void mNotEqu() throws RecognitionException {
		try {
			int _type = NotEqu;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:202:9: ( '!=' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:202:10: '!='
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
	// $ANTLR end "NotEqu"

	// $ANTLR start "And"
	public final void mAnd() throws RecognitionException {
		try {
			int _type = And;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:204:5: ( '&&' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:204:6: '&&'
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
	// $ANTLR end "And"

	// $ANTLR start "Or"
	public final void mOr() throws RecognitionException {
		try {
			int _type = Or;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:206:4: ( '||' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:206:5: '||'
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
	// $ANTLR end "Or"

	// $ANTLR start "Not"
	public final void mNot() throws RecognitionException {
		try {
			int _type = Not;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:208:5: ( '!' )
			// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:208:6: '!'
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
	// $ANTLR end "Not"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( WS | COMMENT | FormStart | Bool | BooleanType | MoneyType | IntegerType | StringType | DoubleType | If | Else | Ident | Str | Int | Doub | Lbr | Rbr | Assignment_Indicator | RoundLbr | RoundRbr | Mul | Div | Add | Sub | LT | LTEqu | GT | GTEqu | Equ | NotEqu | And | Or | Not )
		int alt9=33;
		alt9 = dfa9.predict(input);
		switch (alt9) {
			case 1 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: WS
				{
				mWS(); 

				}
				break;
			case 2 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:13: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 3 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:21: FormStart
				{
				mFormStart(); 

				}
				break;
			case 4 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:31: Bool
				{
				mBool(); 

				}
				break;
			case 5 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:36: BooleanType
				{
				mBooleanType(); 

				}
				break;
			case 6 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:48: MoneyType
				{
				mMoneyType(); 

				}
				break;
			case 7 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: IntegerType
				{
				mIntegerType(); 

				}
				break;
			case 8 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: StringType
				{
				mStringType(); 

				}
				break;
			case 9 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:81: DoubleType
				{
				mDoubleType(); 

				}
				break;
			case 10 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:92: If
				{
				mIf(); 

				}
				break;
			case 11 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:95: Else
				{
				mElse(); 

				}
				break;
			case 12 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: Ident
				{
				mIdent(); 

				}
				break;
			case 13 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: Str
				{
				mStr(); 

				}
				break;
			case 14 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:110: Int
				{
				mInt(); 

				}
				break;
			case 15 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:114: Doub
				{
				mDoub(); 

				}
				break;
			case 16 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:119: Lbr
				{
				mLbr(); 

				}
				break;
			case 17 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:123: Rbr
				{
				mRbr(); 

				}
				break;
			case 18 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:127: Assignment_Indicator
				{
				mAssignment_Indicator(); 

				}
				break;
			case 19 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:148: RoundLbr
				{
				mRoundLbr(); 

				}
				break;
			case 20 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:157: RoundRbr
				{
				mRoundRbr(); 

				}
				break;
			case 21 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:166: Mul
				{
				mMul(); 

				}
				break;
			case 22 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:170: Div
				{
				mDiv(); 

				}
				break;
			case 23 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:174: Add
				{
				mAdd(); 

				}
				break;
			case 24 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:178: Sub
				{
				mSub(); 

				}
				break;
			case 25 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:182: LT
				{
				mLT(); 

				}
				break;
			case 26 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:185: LTEqu
				{
				mLTEqu(); 

				}
				break;
			case 27 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:191: GT
				{
				mGT(); 

				}
				break;
			case 28 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:194: GTEqu
				{
				mGTEqu(); 

				}
				break;
			case 29 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:200: Equ
				{
				mEqu(); 

				}
				break;
			case 30 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:204: NotEqu
				{
				mNotEqu(); 

				}
				break;
			case 31 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:211: And
				{
				mAnd(); 

				}
				break;
			case 32 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:215: Or
				{
				mOr(); 

				}
				break;
			case 33 :
				// /Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/QL.g:1:218: Not
				{
				mNot(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\2\uffff\1\35\10\13\2\uffff\1\50\10\uffff\1\53\1\55\1\uffff\1\57\4\uffff"+
		"\6\13\1\66\3\13\10\uffff\6\13\1\uffff\3\13\1\103\1\13\1\105\5\13\1\113"+
		"\1\uffff\1\105\1\uffff\1\13\1\115\3\13\1\uffff\1\13\1\uffff\1\13\1\123"+
		"\1\124\1\125\1\126\4\uffff";
	static final String DFA9_eofS =
		"\127\uffff";
	static final String DFA9_minS =
		"\1\11\1\uffff\1\52\1\141\1\162\2\157\1\146\1\164\1\157\1\154\2\uffff\1"+
		"\56\10\uffff\2\75\1\uffff\1\75\4\uffff\1\162\1\154\1\165\1\157\1\156\1"+
		"\164\1\60\1\162\1\165\1\163\10\uffff\1\155\1\163\1\145\1\154\2\145\1\uffff"+
		"\1\151\1\142\1\145\1\60\1\145\1\60\1\145\1\171\1\147\1\156\1\154\1\60"+
		"\1\uffff\1\60\1\uffff\1\141\1\60\1\145\1\147\1\145\1\uffff\1\156\1\uffff"+
		"\1\162\4\60\4\uffff";
	static final String DFA9_maxS =
		"\1\175\1\uffff\1\57\1\157\1\162\2\157\1\156\1\164\1\157\1\154\2\uffff"+
		"\1\71\10\uffff\2\75\1\uffff\1\75\4\uffff\1\162\1\154\1\165\1\157\1\156"+
		"\1\164\1\172\1\162\1\165\1\163\10\uffff\1\155\1\163\1\145\1\154\2\145"+
		"\1\uffff\1\151\1\142\1\145\1\172\1\145\1\172\1\145\1\171\1\147\1\156\1"+
		"\154\1\172\1\uffff\1\172\1\uffff\1\141\1\172\1\145\1\147\1\145\1\uffff"+
		"\1\156\1\uffff\1\162\4\172\4\uffff";
	static final String DFA9_acceptS =
		"\1\uffff\1\1\11\uffff\1\14\1\15\1\uffff\1\20\1\21\1\22\1\23\1\24\1\25"+
		"\1\27\1\30\2\uffff\1\35\1\uffff\1\37\1\40\1\2\1\26\12\uffff\1\16\1\17"+
		"\1\32\1\31\1\34\1\33\1\36\1\41\6\uffff\1\12\14\uffff\1\3\1\uffff\1\4\5"+
		"\uffff\1\13\1\uffff\1\6\5\uffff\1\10\1\11\1\5\1\7";
	static final String DFA9_specialS =
		"\127\uffff}>";
	static final String[] DFA9_transitionS = {
			"\2\1\1\uffff\2\1\22\uffff\1\1\1\31\1\14\3\uffff\1\32\1\uffff\1\21\1\22"+
			"\1\23\1\24\1\uffff\1\25\1\uffff\1\2\12\15\1\20\1\uffff\1\26\1\30\1\27"+
			"\2\uffff\32\13\6\uffff\1\13\1\5\1\13\1\11\1\12\1\3\2\13\1\7\3\13\1\6"+
			"\5\13\1\10\1\4\6\13\1\16\1\33\1\17",
			"",
			"\1\34\4\uffff\1\34",
			"\1\37\15\uffff\1\36",
			"\1\40",
			"\1\41",
			"\1\42",
			"\1\44\7\uffff\1\43",
			"\1\45",
			"\1\46",
			"\1\47",
			"",
			"",
			"\1\51\1\uffff\12\15",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\52",
			"\1\54",
			"",
			"\1\56",
			"",
			"",
			"",
			"",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\1\67",
			"\1\70",
			"\1\71",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"",
			"\1\100",
			"\1\101",
			"\1\102",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\1\104",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"",
			"\1\114",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\1\116",
			"\1\117",
			"\1\120",
			"",
			"\1\121",
			"",
			"\1\122",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"\12\13\7\uffff\32\13\4\uffff\1\13\1\uffff\32\13",
			"",
			"",
			"",
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
			return "1:1: Tokens : ( WS | COMMENT | FormStart | Bool | BooleanType | MoneyType | IntegerType | StringType | DoubleType | If | Else | Ident | Str | Int | Doub | Lbr | Rbr | Assignment_Indicator | RoundLbr | RoundRbr | Mul | Div | Add | Sub | LT | LTEqu | GT | GTEqu | Equ | NotEqu | And | Or | Not );";
		}
	}

}
