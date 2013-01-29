// $ANTLR 3.4 QL.g 2013-01-29 15:49:31

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__9=9;
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
    public static final int COMMENT=4;
    public static final int Ident=5;
    public static final int Int=6;
    public static final int Str=7;
    public static final int WS=8;

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
    public String getGrammarFileName() { return "QL.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:6:6: ( '!' )
            // QL.g:6:8: '!'
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
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:7:7: ( '!=' )
            // QL.g:7:9: '!='
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:8:7: ( '&&' )
            // QL.g:8:9: '&&'
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:9:7: ( '(' )
            // QL.g:9:9: '('
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:10:7: ( ')' )
            // QL.g:10:9: ')'
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:11:7: ( '*' )
            // QL.g:11:9: '*'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:12:7: ( '+' )
            // QL.g:12:9: '+'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:13:7: ( '-' )
            // QL.g:13:9: '-'
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:14:7: ( '/' )
            // QL.g:14:9: '/'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:15:7: ( ':' )
            // QL.g:15:9: ':'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:16:7: ( '<' )
            // QL.g:16:9: '<'
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
            // QL.g:17:7: ( '<=' )
            // QL.g:17:9: '<='
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
            // QL.g:18:7: ( '==' )
            // QL.g:18:9: '=='
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
            // QL.g:19:7: ( '>' )
            // QL.g:19:9: '>'
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
            // QL.g:20:7: ( '>=' )
            // QL.g:20:9: '>='
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
            // QL.g:21:7: ( 'form' )
            // QL.g:21:9: 'form'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:22:7: ( '{' )
            // QL.g:22:9: '{'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:23:7: ( '||' )
            // QL.g:23:9: '||'
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:24:7: ( '}' )
            // QL.g:24:9: '}'
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
    // $ANTLR end "T__27"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:109:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // QL.g:109:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // QL.g:113:6: ( '/*' ( . )* '*/' | '//' ( . )* '\\n' )
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
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // QL.g:113:8: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // QL.g:113:13: ( . )*
                    loop1:
                    do {
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
                    	    // QL.g:113:13: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    match("*/"); 



                     _channel=HIDDEN; 

                    }
                    break;
                case 2 :
                    // QL.g:114:8: '//' ( . )* '\\n'
                    {
                    match("//"); 



                    // QL.g:114:13: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\n') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // QL.g:114:13: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    match('\n'); 

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

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:117:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:117:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // QL.g:117:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // QL.g:
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
            	    break loop4;
                }
            } while (true);


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
            // QL.g:119:4: ( ( '0' .. '9' )+ )
            // QL.g:119:6: ( '0' .. '9' )+
            {
            // QL.g:119:6: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // QL.g:
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
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Int"

    // $ANTLR start "Str"
    public final void mStr() throws RecognitionException {
        try {
            int _type = Str;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:121:4: ( ( '\"' ( . )* '\"' | '“' ( . )* '”' ) )
            // QL.g:121:8: ( '\"' ( . )* '\"' | '“' ( . )* '”' )
            {
            // QL.g:121:8: ( '\"' ( . )* '\"' | '“' ( . )* '”' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\u201C') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // QL.g:121:9: '\"' ( . )* '\"'
                    {
                    match('\"'); 

                    // QL.g:121:13: ( . )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\"') ) {
                            alt6=2;
                        }
                        else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '\uFFFF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // QL.g:121:13: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;
                case 2 :
                    // QL.g:121:22: '“' ( . )* '”'
                    {
                    match('\u201C'); 

                    // QL.g:121:26: ( . )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\u201D') ) {
                            alt7=2;
                        }
                        else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\u201C')||(LA7_0 >= '\u201E' && LA7_0 <= '\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // QL.g:121:26: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    match('\u201D'); 

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
    // $ANTLR end "Str"

    public void mTokens() throws RecognitionException {
        // QL.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | WS | COMMENT | Ident | Int | Str )
        int alt9=24;
        switch ( input.LA(1) ) {
        case '!':
            {
            int LA9_1 = input.LA(2);

            if ( (LA9_1=='=') ) {
                alt9=2;
            }
            else {
                alt9=1;
            }
            }
            break;
        case '&':
            {
            alt9=3;
            }
            break;
        case '(':
            {
            alt9=4;
            }
            break;
        case ')':
            {
            alt9=5;
            }
            break;
        case '*':
            {
            alt9=6;
            }
            break;
        case '+':
            {
            alt9=7;
            }
            break;
        case '-':
            {
            alt9=8;
            }
            break;
        case '/':
            {
            int LA9_8 = input.LA(2);

            if ( (LA9_8=='*'||LA9_8=='/') ) {
                alt9=21;
            }
            else {
                alt9=9;
            }
            }
            break;
        case ':':
            {
            alt9=10;
            }
            break;
        case '<':
            {
            int LA9_10 = input.LA(2);

            if ( (LA9_10=='=') ) {
                alt9=12;
            }
            else {
                alt9=11;
            }
            }
            break;
        case '=':
            {
            alt9=13;
            }
            break;
        case '>':
            {
            int LA9_12 = input.LA(2);

            if ( (LA9_12=='=') ) {
                alt9=15;
            }
            else {
                alt9=14;
            }
            }
            break;
        case 'f':
            {
            int LA9_13 = input.LA(2);

            if ( (LA9_13=='o') ) {
                int LA9_29 = input.LA(3);

                if ( (LA9_29=='r') ) {
                    int LA9_30 = input.LA(4);

                    if ( (LA9_30=='m') ) {
                        int LA9_31 = input.LA(5);

                        if ( ((LA9_31 >= '0' && LA9_31 <= '9')||(LA9_31 >= 'A' && LA9_31 <= 'Z')||LA9_31=='_'||(LA9_31 >= 'a' && LA9_31 <= 'z')) ) {
                            alt9=22;
                        }
                        else {
                            alt9=16;
                        }
                    }
                    else {
                        alt9=22;
                    }
                }
                else {
                    alt9=22;
                }
            }
            else {
                alt9=22;
            }
            }
            break;
        case '{':
            {
            alt9=17;
            }
            break;
        case '|':
            {
            alt9=18;
            }
            break;
        case '}':
            {
            alt9=19;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt9=20;
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
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt9=22;
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
            alt9=23;
            }
            break;
        case '\"':
        case '\u201C':
            {
            alt9=24;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 9, 0, input);

            throw nvae;

        }

        switch (alt9) {
            case 1 :
                // QL.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // QL.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // QL.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // QL.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // QL.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // QL.g:1:39: T__14
                {
                mT__14(); 


                }
                break;
            case 7 :
                // QL.g:1:45: T__15
                {
                mT__15(); 


                }
                break;
            case 8 :
                // QL.g:1:51: T__16
                {
                mT__16(); 


                }
                break;
            case 9 :
                // QL.g:1:57: T__17
                {
                mT__17(); 


                }
                break;
            case 10 :
                // QL.g:1:63: T__18
                {
                mT__18(); 


                }
                break;
            case 11 :
                // QL.g:1:69: T__19
                {
                mT__19(); 


                }
                break;
            case 12 :
                // QL.g:1:75: T__20
                {
                mT__20(); 


                }
                break;
            case 13 :
                // QL.g:1:81: T__21
                {
                mT__21(); 


                }
                break;
            case 14 :
                // QL.g:1:87: T__22
                {
                mT__22(); 


                }
                break;
            case 15 :
                // QL.g:1:93: T__23
                {
                mT__23(); 


                }
                break;
            case 16 :
                // QL.g:1:99: T__24
                {
                mT__24(); 


                }
                break;
            case 17 :
                // QL.g:1:105: T__25
                {
                mT__25(); 


                }
                break;
            case 18 :
                // QL.g:1:111: T__26
                {
                mT__26(); 


                }
                break;
            case 19 :
                // QL.g:1:117: T__27
                {
                mT__27(); 


                }
                break;
            case 20 :
                // QL.g:1:123: WS
                {
                mWS(); 


                }
                break;
            case 21 :
                // QL.g:1:126: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 22 :
                // QL.g:1:134: Ident
                {
                mIdent(); 


                }
                break;
            case 23 :
                // QL.g:1:140: Int
                {
                mInt(); 


                }
                break;
            case 24 :
                // QL.g:1:144: Str
                {
                mStr(); 


                }
                break;

        }

    }


 

}