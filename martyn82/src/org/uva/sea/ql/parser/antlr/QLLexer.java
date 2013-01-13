// $ANTLR 3.4 QL.g 2013-01-13 14:57:47

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int NEWLINE=8;
    public static final int Str=9;
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
    public String getGrammarFileName() { return "QL.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:6:7: ( '!' )
            // QL.g:6:9: '!'
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:15:7: ( '<' )
            // QL.g:15:9: '<'
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
            // QL.g:16:7: ( '<=' )
            // QL.g:16:9: '<='
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
            // QL.g:17:7: ( '==' )
            // QL.g:17:9: '=='
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
            // QL.g:18:7: ( '>' )
            // QL.g:18:9: '>'
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
            // QL.g:19:7: ( '>=' )
            // QL.g:19:9: '>='
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
            // QL.g:20:7: ( '||' )
            // QL.g:20:9: '||'
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
    // $ANTLR end "T__25"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:95:5: ( ( ' ' | '\\t' | NEWLINE ) )
            // QL.g:95:7: ( ' ' | '\\t' | NEWLINE )
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
            // QL.g:99:5: ( ( '//' (~ ( NEWLINE ) )* | '/*' ( . )* '*/' ) )
            // QL.g:99:7: ( '//' (~ ( NEWLINE ) )* | '/*' ( . )* '*/' )
            {
            // QL.g:99:7: ( '//' (~ ( NEWLINE ) )* | '/*' ( . )* '*/' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='/') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='/') ) {
                    alt3=1;
                }
                else if ( (LA3_1=='*') ) {
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
                    // QL.g:99:8: '//' (~ ( NEWLINE ) )*
                    {
                    match("//"); 



                    // QL.g:99:13: (~ ( NEWLINE ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // QL.g:
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
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // QL.g:99:27: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // QL.g:99:32: ( . )*
                    loop2:
                    do {
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
                    	    // QL.g:99:32: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    match("*/"); 



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
    // $ANTLR end "COMMENT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            // QL.g:103:5: ( ( '\\r' | '\\n' ) )
            // QL.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:106:5: ( 'true' | 'false' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='t') ) {
                alt4=1;
            }
            else if ( (LA4_0=='f') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // QL.g:106:9: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // QL.g:106:18: 'false'
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

    // $ANTLR start "Str"
    public final void mStr() throws RecognitionException {
        try {
            int _type = Str;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:108:4: ( '\\\"' ( '\\\\\"' |~ '\\\"' )* '\\\"' )
            // QL.g:108:9: '\\\"' ( '\\\\\"' |~ '\\\"' )* '\\\"'
            {
            match('\"'); 

            // QL.g:108:14: ( '\\\\\"' |~ '\\\"' )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2=='\"') ) {
                        int LA5_4 = input.LA(3);

                        if ( ((LA5_4 >= '\u0000' && LA5_4 <= '\uFFFF')) ) {
                            alt5=1;
                        }

                        else {
                            alt5=2;
                        }


                    }
                    else if ( ((LA5_2 >= '\u0000' && LA5_2 <= '!')||(LA5_2 >= '#' && LA5_2 <= '\uFFFF')) ) {
                        alt5=2;
                    }


                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '[')||(LA5_0 >= ']' && LA5_0 <= '\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // QL.g:108:15: '\\\\\"'
            	    {
            	    match("\\\""); 



            	    }
            	    break;
            	case 2 :
            	    // QL.g:108:23: ~ '\\\"'
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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
            } while (true);


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

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:110:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:110:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // QL.g:110:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    break loop6;
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
            // QL.g:112:4: ( ( '0' .. '9' )+ )
            // QL.g:112:9: ( '0' .. '9' )+
            {
            // QL.g:112:9: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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

    public void mTokens() throws RecognitionException {
        // QL.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | WS | COMMENT | Bool | Str | Ident | Int )
        int alt8=21;
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
                alt8=17;
            }
            else {
                alt8=9;
            }
            }
            break;
        case '<':
            {
            int LA8_9 = input.LA(2);

            if ( (LA8_9=='=') ) {
                alt8=11;
            }
            else {
                alt8=10;
            }
            }
            break;
        case '=':
            {
            alt8=12;
            }
            break;
        case '>':
            {
            int LA8_11 = input.LA(2);

            if ( (LA8_11=='=') ) {
                alt8=14;
            }
            else {
                alt8=13;
            }
            }
            break;
        case '|':
            {
            alt8=15;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt8=16;
            }
            break;
        case 't':
            {
            int LA8_14 = input.LA(2);

            if ( (LA8_14=='r') ) {
                int LA8_27 = input.LA(3);

                if ( (LA8_27=='u') ) {
                    int LA8_29 = input.LA(4);

                    if ( (LA8_29=='e') ) {
                        int LA8_31 = input.LA(5);

                        if ( ((LA8_31 >= '0' && LA8_31 <= '9')||(LA8_31 >= 'A' && LA8_31 <= 'Z')||LA8_31=='_'||(LA8_31 >= 'a' && LA8_31 <= 'z')) ) {
                            alt8=20;
                        }
                        else {
                            alt8=18;
                        }
                    }
                    else {
                        alt8=20;
                    }
                }
                else {
                    alt8=20;
                }
            }
            else {
                alt8=20;
            }
            }
            break;
        case 'f':
            {
            int LA8_15 = input.LA(2);

            if ( (LA8_15=='a') ) {
                int LA8_28 = input.LA(3);

                if ( (LA8_28=='l') ) {
                    int LA8_30 = input.LA(4);

                    if ( (LA8_30=='s') ) {
                        int LA8_32 = input.LA(5);

                        if ( (LA8_32=='e') ) {
                            int LA8_34 = input.LA(6);

                            if ( ((LA8_34 >= '0' && LA8_34 <= '9')||(LA8_34 >= 'A' && LA8_34 <= 'Z')||LA8_34=='_'||(LA8_34 >= 'a' && LA8_34 <= 'z')) ) {
                                alt8=20;
                            }
                            else {
                                alt8=18;
                            }
                        }
                        else {
                            alt8=20;
                        }
                    }
                    else {
                        alt8=20;
                    }
                }
                else {
                    alt8=20;
                }
            }
            else {
                alt8=20;
            }
            }
            break;
        case '\"':
            {
            alt8=19;
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
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt8=20;
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
            alt8=21;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }

        switch (alt8) {
            case 1 :
                // QL.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // QL.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // QL.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // QL.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // QL.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // QL.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // QL.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // QL.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // QL.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // QL.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // QL.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // QL.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // QL.g:1:82: T__23
                {
                mT__23(); 


                }
                break;
            case 14 :
                // QL.g:1:88: T__24
                {
                mT__24(); 


                }
                break;
            case 15 :
                // QL.g:1:94: T__25
                {
                mT__25(); 


                }
                break;
            case 16 :
                // QL.g:1:100: WS
                {
                mWS(); 


                }
                break;
            case 17 :
                // QL.g:1:103: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 18 :
                // QL.g:1:111: Bool
                {
                mBool(); 


                }
                break;
            case 19 :
                // QL.g:1:116: Str
                {
                mStr(); 


                }
                break;
            case 20 :
                // QL.g:1:120: Ident
                {
                mIdent(); 


                }
                break;
            case 21 :
                // QL.g:1:126: Int
                {
                mInt(); 


                }
                break;

        }

    }


 

}