// $ANTLR 3.4 /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g 2013-01-15 10:57:53

  package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SampleLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int IDENT=4;
    public static final int WS=5;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public SampleLexer() {} 
    public SampleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SampleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:11:6: ( '.' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:11:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:12:6: ( '=' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:12:8: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:13:6: ( 'begin' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:13:8: 'begin'
            {
            match("begin"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:14:6: ( 'end' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:14:8: 'end'
            {
            match("end"); 



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
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:15:7: ( 'program' )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:15:9: 'program'
            {
            match("program"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:21:7: ( ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* ) )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:21:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            {
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:21:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:21:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:21:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:
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
            	    break loop1;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:22:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:22:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:22:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||(LA2_0 >= '\f' && LA2_0 <= '\r')||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:
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
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | IDENT | WS )
        int alt3=7;
        switch ( input.LA(1) ) {
        case '.':
            {
            alt3=1;
            }
            break;
        case '=':
            {
            alt3=2;
            }
            break;
        case 'b':
            {
            int LA3_3 = input.LA(2);

            if ( (LA3_3=='e') ) {
                int LA3_8 = input.LA(3);

                if ( (LA3_8=='g') ) {
                    int LA3_11 = input.LA(4);

                    if ( (LA3_11=='i') ) {
                        int LA3_14 = input.LA(5);

                        if ( (LA3_14=='n') ) {
                            int LA3_17 = input.LA(6);

                            if ( ((LA3_17 >= '0' && LA3_17 <= '9')||(LA3_17 >= 'A' && LA3_17 <= 'Z')||(LA3_17 >= 'a' && LA3_17 <= 'z')) ) {
                                alt3=6;
                            }
                            else {
                                alt3=3;
                            }
                        }
                        else {
                            alt3=6;
                        }
                    }
                    else {
                        alt3=6;
                    }
                }
                else {
                    alt3=6;
                }
            }
            else {
                alt3=6;
            }
            }
            break;
        case 'e':
            {
            int LA3_4 = input.LA(2);

            if ( (LA3_4=='n') ) {
                int LA3_9 = input.LA(3);

                if ( (LA3_9=='d') ) {
                    int LA3_12 = input.LA(4);

                    if ( ((LA3_12 >= '0' && LA3_12 <= '9')||(LA3_12 >= 'A' && LA3_12 <= 'Z')||(LA3_12 >= 'a' && LA3_12 <= 'z')) ) {
                        alt3=6;
                    }
                    else {
                        alt3=4;
                    }
                }
                else {
                    alt3=6;
                }
            }
            else {
                alt3=6;
            }
            }
            break;
        case 'p':
            {
            int LA3_5 = input.LA(2);

            if ( (LA3_5=='r') ) {
                int LA3_10 = input.LA(3);

                if ( (LA3_10=='o') ) {
                    int LA3_13 = input.LA(4);

                    if ( (LA3_13=='g') ) {
                        int LA3_16 = input.LA(5);

                        if ( (LA3_16=='r') ) {
                            int LA3_18 = input.LA(6);

                            if ( (LA3_18=='a') ) {
                                int LA3_20 = input.LA(7);

                                if ( (LA3_20=='m') ) {
                                    int LA3_21 = input.LA(8);

                                    if ( ((LA3_21 >= '0' && LA3_21 <= '9')||(LA3_21 >= 'A' && LA3_21 <= 'Z')||(LA3_21 >= 'a' && LA3_21 <= 'z')) ) {
                                        alt3=6;
                                    }
                                    else {
                                        alt3=5;
                                    }
                                }
                                else {
                                    alt3=6;
                                }
                            }
                            else {
                                alt3=6;
                            }
                        }
                        else {
                            alt3=6;
                        }
                    }
                    else {
                        alt3=6;
                    }
                }
                else {
                    alt3=6;
                }
            }
            else {
                alt3=6;
            }
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
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
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
            alt3=6;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt3=7;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;

        }

        switch (alt3) {
            case 1 :
                // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:10: T__6
                {
                mT__6(); 


                }
                break;
            case 2 :
                // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:15: T__7
                {
                mT__7(); 


                }
                break;
            case 3 :
                // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:20: T__8
                {
                mT__8(); 


                }
                break;
            case 4 :
                // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:25: T__9
                {
                mT__9(); 


                }
                break;
            case 5 :
                // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:30: T__10
                {
                mT__10(); 


                }
                break;
            case 6 :
                // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:36: IDENT
                {
                mIDENT(); 


                }
                break;
            case 7 :
                // /Users/peter/Documents/school/UvA/Software Construction/Git/sea-of-ql/pklijn/src/org/uva/sea/ql/parser/antlr/Sample.g:1:42: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}