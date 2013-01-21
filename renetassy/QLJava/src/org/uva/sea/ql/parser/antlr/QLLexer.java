// $ANTLR 3.5 /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-21 14:36:45

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class QLLexer extends Lexer {
	public static final int EOF=-1;
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
	public static final int Bool=4;
	public static final int Ident=5;
	public static final int Int=6;
	public static final int MLINE_COMMENT=7;
	public static final int SLINE_COMMENT=8;
	public static final int String=9;
	public static final int WS=10;

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
	@Override public String getGrammarFileName() { return "/home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
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
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
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
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( '<' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: '<'
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
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<=' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<='
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
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '==' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '=='
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
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '>' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '>'
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
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>=' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>='
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
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( 'form' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: 'form'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '{' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '{'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( '||' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: '||'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( '}' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:9: '}'
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
	// $ANTLR end "T__28"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:107:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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

	// $ANTLR start "MLINE_COMMENT"
	public final void mMLINE_COMMENT() throws RecognitionException {
		try {
			int _type = MLINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:15: ( '/*' ( . )* '*/' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:17: '/*' ( . )* '*/'
			{
			match("/*"); 

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:22: ( . )*
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:109:22: .
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MLINE_COMMENT"

	// $ANTLR start "SLINE_COMMENT"
	public final void mSLINE_COMMENT() throws RecognitionException {
		try {
			int _type = SLINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:15: ( '//' ( . )* ( '\\n' | '\\r' ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:17: '//' ( . )* ( '\\n' | '\\r' )
			{
			match("//"); 

			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:22: ( . )*
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:111:22: .
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
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SLINE_COMMENT"

	// $ANTLR start "Bool"
	public final void mBool() throws RecognitionException {
		try {
			int _type = Bool;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:5: ( ( 'true' | 'false' | 'TRUE' | 'FALSE' ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:7: ( 'true' | 'false' | 'TRUE' | 'FALSE' )
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:7: ( 'true' | 'false' | 'TRUE' | 'FALSE' )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 't':
				{
				alt3=1;
				}
				break;
			case 'f':
				{
				alt3=2;
				}
				break;
			case 'T':
				{
				alt3=3;
				}
				break;
			case 'F':
				{
				alt3=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:8: 'true'
					{
					match("true"); 

					}
					break;
				case 2 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:17: 'false'
					{
					match("false"); 

					}
					break;
				case 3 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:27: 'TRUE'
					{
					match("TRUE"); 

					}
					break;
				case 4 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:113:36: 'FALSE'
					{
					match("FALSE"); 

					}
					break;

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

	// $ANTLR start "String"
	public final void mString() throws RecognitionException {
		try {
			int _type = String;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:7: ( ( '\"' ( . )* '\"' ) )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:9: ( '\"' ( . )* '\"' )
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:9: ( '\"' ( . )* '\"' )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:10: '\"' ( . )* '\"'
			{
			match('\"'); 
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:14: ( . )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\"') ) {
					alt4=2;
				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:115:14: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop4;
				}
			}

			match('\"'); 
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "String"

	// $ANTLR start "Int"
	public final void mInt() throws RecognitionException {
		try {
			int _type = Int;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:4: ( ( '0' .. '9' )+ )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:6: ( '0' .. '9' )+
			{
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:117:6: ( '0' .. '9' )+
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
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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
	// $ANTLR end "Int"

	// $ANTLR start "Ident"
	public final void mIdent() throws RecognitionException {
		try {
			int _type = Ident;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:119:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

	@Override
	public void mTokens() throws RecognitionException {
		// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | WS | MLINE_COMMENT | SLINE_COMMENT | Bool | String | Int | Ident )
		int alt7=25;
		switch ( input.LA(1) ) {
		case '!':
			{
			int LA7_1 = input.LA(2);
			if ( (LA7_1=='=') ) {
				alt7=2;
			}

			else {
				alt7=1;
			}

			}
			break;
		case '&':
			{
			alt7=3;
			}
			break;
		case '(':
			{
			alt7=4;
			}
			break;
		case ')':
			{
			alt7=5;
			}
			break;
		case '*':
			{
			alt7=6;
			}
			break;
		case '+':
			{
			alt7=7;
			}
			break;
		case '-':
			{
			alt7=8;
			}
			break;
		case '/':
			{
			switch ( input.LA(2) ) {
			case '*':
				{
				alt7=20;
				}
				break;
			case '/':
				{
				alt7=21;
				}
				break;
			default:
				alt7=9;
			}
			}
			break;
		case '<':
			{
			int LA7_9 = input.LA(2);
			if ( (LA7_9=='=') ) {
				alt7=11;
			}

			else {
				alt7=10;
			}

			}
			break;
		case '=':
			{
			alt7=12;
			}
			break;
		case '>':
			{
			int LA7_11 = input.LA(2);
			if ( (LA7_11=='=') ) {
				alt7=14;
			}

			else {
				alt7=13;
			}

			}
			break;
		case 'f':
			{
			switch ( input.LA(2) ) {
			case 'o':
				{
				int LA7_32 = input.LA(3);
				if ( (LA7_32=='r') ) {
					int LA7_37 = input.LA(4);
					if ( (LA7_37=='m') ) {
						int LA7_42 = input.LA(5);
						if ( ((LA7_42 >= '0' && LA7_42 <= '9')||(LA7_42 >= 'A' && LA7_42 <= 'Z')||LA7_42=='_'||(LA7_42 >= 'a' && LA7_42 <= 'z')) ) {
							alt7=25;
						}

						else {
							alt7=15;
						}

					}

					else {
						alt7=25;
					}

				}

				else {
					alt7=25;
				}

				}
				break;
			case 'a':
				{
				int LA7_33 = input.LA(3);
				if ( (LA7_33=='l') ) {
					int LA7_38 = input.LA(4);
					if ( (LA7_38=='s') ) {
						int LA7_43 = input.LA(5);
						if ( (LA7_43=='e') ) {
							int LA7_48 = input.LA(6);
							if ( ((LA7_48 >= '0' && LA7_48 <= '9')||(LA7_48 >= 'A' && LA7_48 <= 'Z')||LA7_48=='_'||(LA7_48 >= 'a' && LA7_48 <= 'z')) ) {
								alt7=25;
							}

							else {
								alt7=22;
							}

						}

						else {
							alt7=25;
						}

					}

					else {
						alt7=25;
					}

				}

				else {
					alt7=25;
				}

				}
				break;
			default:
				alt7=25;
			}
			}
			break;
		case '{':
			{
			alt7=16;
			}
			break;
		case '|':
			{
			alt7=17;
			}
			break;
		case '}':
			{
			alt7=18;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt7=19;
			}
			break;
		case 't':
			{
			int LA7_17 = input.LA(2);
			if ( (LA7_17=='r') ) {
				int LA7_34 = input.LA(3);
				if ( (LA7_34=='u') ) {
					int LA7_39 = input.LA(4);
					if ( (LA7_39=='e') ) {
						int LA7_44 = input.LA(5);
						if ( ((LA7_44 >= '0' && LA7_44 <= '9')||(LA7_44 >= 'A' && LA7_44 <= 'Z')||LA7_44=='_'||(LA7_44 >= 'a' && LA7_44 <= 'z')) ) {
							alt7=25;
						}

						else {
							alt7=22;
						}

					}

					else {
						alt7=25;
					}

				}

				else {
					alt7=25;
				}

			}

			else {
				alt7=25;
			}

			}
			break;
		case 'T':
			{
			int LA7_18 = input.LA(2);
			if ( (LA7_18=='R') ) {
				int LA7_35 = input.LA(3);
				if ( (LA7_35=='U') ) {
					int LA7_40 = input.LA(4);
					if ( (LA7_40=='E') ) {
						int LA7_45 = input.LA(5);
						if ( ((LA7_45 >= '0' && LA7_45 <= '9')||(LA7_45 >= 'A' && LA7_45 <= 'Z')||LA7_45=='_'||(LA7_45 >= 'a' && LA7_45 <= 'z')) ) {
							alt7=25;
						}

						else {
							alt7=22;
						}

					}

					else {
						alt7=25;
					}

				}

				else {
					alt7=25;
				}

			}

			else {
				alt7=25;
			}

			}
			break;
		case 'F':
			{
			int LA7_19 = input.LA(2);
			if ( (LA7_19=='A') ) {
				int LA7_36 = input.LA(3);
				if ( (LA7_36=='L') ) {
					int LA7_41 = input.LA(4);
					if ( (LA7_41=='S') ) {
						int LA7_46 = input.LA(5);
						if ( (LA7_46=='E') ) {
							int LA7_50 = input.LA(6);
							if ( ((LA7_50 >= '0' && LA7_50 <= '9')||(LA7_50 >= 'A' && LA7_50 <= 'Z')||LA7_50=='_'||(LA7_50 >= 'a' && LA7_50 <= 'z')) ) {
								alt7=25;
							}

							else {
								alt7=22;
							}

						}

						else {
							alt7=25;
						}

					}

					else {
						alt7=25;
					}

				}

				else {
					alt7=25;
				}

			}

			else {
				alt7=25;
			}

			}
			break;
		case '\"':
			{
			alt7=23;
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
			alt7=24;
			}
			break;
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
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
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt7=25;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 7, 0, input);
			throw nvae;
		}
		switch (alt7) {
			case 1 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__11
				{
				mT__11(); 

				}
				break;
			case 2 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__12
				{
				mT__12(); 

				}
				break;
			case 3 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__13
				{
				mT__13(); 

				}
				break;
			case 4 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__14
				{
				mT__14(); 

				}
				break;
			case 5 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__15
				{
				mT__15(); 

				}
				break;
			case 6 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__16
				{
				mT__16(); 

				}
				break;
			case 7 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__17
				{
				mT__17(); 

				}
				break;
			case 8 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__18
				{
				mT__18(); 

				}
				break;
			case 9 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__19
				{
				mT__19(); 

				}
				break;
			case 10 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__20
				{
				mT__20(); 

				}
				break;
			case 11 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__21
				{
				mT__21(); 

				}
				break;
			case 12 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__22
				{
				mT__22(); 

				}
				break;
			case 13 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__23
				{
				mT__23(); 

				}
				break;
			case 14 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__24
				{
				mT__24(); 

				}
				break;
			case 15 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__25
				{
				mT__25(); 

				}
				break;
			case 16 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__26
				{
				mT__26(); 

				}
				break;
			case 17 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__27
				{
				mT__27(); 

				}
				break;
			case 18 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__28
				{
				mT__28(); 

				}
				break;
			case 19 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:118: WS
				{
				mWS(); 

				}
				break;
			case 20 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:121: MLINE_COMMENT
				{
				mMLINE_COMMENT(); 

				}
				break;
			case 21 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:135: SLINE_COMMENT
				{
				mSLINE_COMMENT(); 

				}
				break;
			case 22 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:149: Bool
				{
				mBool(); 

				}
				break;
			case 23 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:154: String
				{
				mString(); 

				}
				break;
			case 24 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:161: Int
				{
				mInt(); 

				}
				break;
			case 25 :
				// /home/rene/workspace/sea-of-ql/renetassy/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:165: Ident
				{
				mIdent(); 

				}
				break;

		}
	}



}
