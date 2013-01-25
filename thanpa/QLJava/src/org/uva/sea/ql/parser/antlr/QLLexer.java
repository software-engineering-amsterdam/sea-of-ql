// $ANTLR 3.5 /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-20 20:41:34

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
	public static final int Bool=4;
	public static final int Comment=5;
	public static final int Ident=6;
	public static final int Int=7;
	public static final int StringLiteral=8;
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
	@Override public String getGrammarFileName() { return "/Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '<' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: '<'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<=' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<='
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '==' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '=='
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '>' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '>'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>=' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>='
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '||' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '||'
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
	// $ANTLR end "T__24"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:90:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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

	// $ANTLR start "Comment"
	public final void mComment() throws RecognitionException {
		try {
			int _type = Comment;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:3: ( '/*' ( . )* '*/' | '//' ( . )* ( '\\n' | '\\r' ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='/') ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1=='*') ) {
					alt3=1;
				}
				else if ( (LA3_1=='/') ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:5: '/*' ( . )* '*/'
					{
					match("/*"); 

					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:10: ( . )*
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
							// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:94:10: .
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
					break;
				case 2 :
					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:5: '//' ( . )* ( '\\n' | '\\r' )
					{
					match("//"); 

					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:10: ( . )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0=='\n'||LA2_0=='\r') ) {
							alt2=2;
						}
						else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:95:10: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop2;
						}
					}

					if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					_channel = HIDDEN;
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
	// $ANTLR end "Comment"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:5: ( ( 'true' | 'false' )+ )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:7: ( 'true' | 'false' )+
			{
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:7: ( 'true' | 'false' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='t') ) {
					alt4=1;
				}
				else if ( (LA4_0=='f') ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:8: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:98:15: 'false'
					{
					match("false"); 

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
	// $ANTLR end "Bool"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:100:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:4: ( ( '0' .. '9' )+ )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:6: ( '0' .. '9' )+
			{
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:102:6: ( '0' .. '9' )+
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
					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

	// $ANTLR start "StringLiteral"
	public final void mStringLiteral() throws RecognitionException {
		try {
			int _type = StringLiteral;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:14: ( '\"' ( . )* '\"' )
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:16: '\"' ( . )* '\"'
			{
			match('\"'); 
			// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:20: ( . )*
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
					// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:104:20: .
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
	// $ANTLR end "StringLiteral"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | WS | Comment | Bool | Ident | Int | StringLiteral )
		int alt8=21;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__10
				{
				mT__10(); 

				}
				break;
			case 2 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__11
				{
				mT__11(); 

				}
				break;
			case 3 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__12
				{
				mT__12(); 

				}
				break;
			case 4 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__13
				{
				mT__13(); 

				}
				break;
			case 5 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__14
				{
				mT__14(); 

				}
				break;
			case 6 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__15
				{
				mT__15(); 

				}
				break;
			case 7 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__16
				{
				mT__16(); 

				}
				break;
			case 8 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__17
				{
				mT__17(); 

				}
				break;
			case 9 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__18
				{
				mT__18(); 

				}
				break;
			case 10 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__19
				{
				mT__19(); 

				}
				break;
			case 11 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__20
				{
				mT__20(); 

				}
				break;
			case 12 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__21
				{
				mT__21(); 

				}
				break;
			case 13 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__22
				{
				mT__22(); 

				}
				break;
			case 14 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__23
				{
				mT__23(); 

				}
				break;
			case 15 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__24
				{
				mT__24(); 

				}
				break;
			case 16 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: WS
				{
				mWS(); 

				}
				break;
			case 17 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:103: Comment
				{
				mComment(); 

				}
				break;
			case 18 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:111: Bool
				{
				mBool(); 

				}
				break;
			case 19 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:116: Ident
				{
				mIdent(); 

				}
				break;
			case 20 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:122: Int
				{
				mInt(); 

				}
				break;
			case 21 :
				// /Users/thanasis/Uva/sea-of-ql/thanpa/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:126: StringLiteral
				{
				mStringLiteral(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\1\uffff\1\24\6\uffff\1\26\1\30\1\uffff\1\32\2\uffff\2\20\13\uffff\4\20"+
		"\1\41\1\20\1\uffff\2\20\1\41";
	static final String DFA8_eofS =
		"\45\uffff";
	static final String DFA8_minS =
		"\1\11\1\75\6\uffff\1\52\1\75\1\uffff\1\75\2\uffff\1\162\1\141\13\uffff"+
		"\1\165\1\154\1\145\1\163\1\60\1\145\1\uffff\1\162\1\141\1\60";
	static final String DFA8_maxS =
		"\1\174\1\75\6\uffff\1\57\1\75\1\uffff\1\75\2\uffff\1\162\1\141\13\uffff"+
		"\1\165\1\154\1\145\1\163\1\172\1\145\1\uffff\1\162\1\141\1\172";
	static final String DFA8_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\2\uffff\1\14\1\uffff\1\17\1\20\2\uffff"+
		"\1\23\1\24\1\25\1\2\1\1\1\21\1\11\1\13\1\12\1\16\1\15\6\uffff\1\22\3\uffff";
	static final String DFA8_specialS =
		"\45\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\15\2\uffff\1\15\22\uffff\1\15\1\1\1\22\3\uffff\1\2\1\uffff\1\3\1\4"+
			"\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\21\2\uffff\1\11\1\12\1\13\2\uffff"+
			"\32\20\6\uffff\5\20\1\17\15\20\1\16\6\20\1\uffff\1\14",
			"\1\23",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\25\4\uffff\1\25",
			"\1\27",
			"",
			"\1\31",
			"",
			"",
			"\1\33",
			"\1\34",
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
			"\1\35",
			"\1\36",
			"\1\37",
			"\1\40",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\5\20\1\43\15\20\1\42\6\20",
			"\1\44",
			"",
			"\1\33",
			"\1\34",
			"\12\20\7\uffff\32\20\4\uffff\1\20\1\uffff\5\20\1\43\15\20\1\42\6\20"
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
			return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | WS | Comment | Bool | Ident | Int | StringLiteral );";
		}
	}

}
