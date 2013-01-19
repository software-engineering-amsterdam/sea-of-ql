// $ANTLR !Unknown version! QL.g 2013-01-18 19:56:35

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QLLexer extends Lexer {
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int BOOL=5;
    public static final int INT=4;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int WS=8;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int IDENT=7;
    public static final int COMMENT=9;
    public static final int STRING=6;

    // delegates
    // delegators

    public QLLexer() {;} 
    public QLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public QLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "QL.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:7:7: ( '(' )
            // QL.g:7:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:8:7: ( ')' )
            // QL.g:8:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:9:7: ( '+' )
            // QL.g:9:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:10:7: ( '-' )
            // QL.g:10:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:11:7: ( '!' )
            // QL.g:11:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:12:7: ( '*' )
            // QL.g:12:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:13:7: ( '/' )
            // QL.g:13:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:14:7: ( '<' )
            // QL.g:14:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:15:7: ( '<=' )
            // QL.g:15:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:16:7: ( '>' )
            // QL.g:16:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:17:7: ( '>=' )
            // QL.g:17:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
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
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:19:7: ( '!=' )
            // QL.g:19:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:20:7: ( '&&' )
            // QL.g:20:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:21:7: ( '||' )
            // QL.g:21:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:93:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // QL.g:93:7: ( ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:97:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // QL.g:97:7: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // QL.g:97:12: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:97:38: .
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:101:2: ( '\"' ( options {greedy=false; } : . )* '\"' | '\\'' ( options {greedy=false; } : . )* '\\'' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\"') ) {
                alt4=1;
            }
            else if ( (LA4_0=='\'') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // QL.g:101:4: '\"' ( options {greedy=false; } : . )* '\"'
                    {
                    match('\"'); 
                    // QL.g:101:8: ( options {greedy=false; } : . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\"') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // QL.g:101:34: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // QL.g:102:4: '\\'' ( options {greedy=false; } : . )* '\\''
                    {
                    match('\''); 
                    // QL.g:102:9: ( options {greedy=false; } : . )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\'') ) {
                            alt3=2;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // QL.g:102:35: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:106:2: ( 'true' | 'false' | 'TRUE' | 'FALSE' )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt5=1;
                }
                break;
            case 'f':
                {
                alt5=2;
                }
                break;
            case 'T':
                {
                alt5=3;
                }
                break;
            case 'F':
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // QL.g:106:4: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // QL.g:107:4: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 3 :
                    // QL.g:108:4: 'TRUE'
                    {
                    match("TRUE"); 


                    }
                    break;
                case 4 :
                    // QL.g:109:4: 'FALSE'
                    {
                    match("FALSE"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:113:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:113:6: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // QL.g:113:25: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:116:2: ( ( '0' .. '9' )+ )
            // QL.g:116:4: ( '0' .. '9' )+
            {
            // QL.g:116:4: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // QL.g:116:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
        }
    }
    // $ANTLR end "INT"

    public void mTokens() throws RecognitionException {
        // QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | WS | COMMENT | STRING | BOOL | IDENT | INT )
        int alt8=21;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // QL.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // QL.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // QL.g:1:22: T__12
                {
                mT__12(); 

                }
                break;
            case 4 :
                // QL.g:1:28: T__13
                {
                mT__13(); 

                }
                break;
            case 5 :
                // QL.g:1:34: T__14
                {
                mT__14(); 

                }
                break;
            case 6 :
                // QL.g:1:40: T__15
                {
                mT__15(); 

                }
                break;
            case 7 :
                // QL.g:1:46: T__16
                {
                mT__16(); 

                }
                break;
            case 8 :
                // QL.g:1:52: T__17
                {
                mT__17(); 

                }
                break;
            case 9 :
                // QL.g:1:58: T__18
                {
                mT__18(); 

                }
                break;
            case 10 :
                // QL.g:1:64: T__19
                {
                mT__19(); 

                }
                break;
            case 11 :
                // QL.g:1:70: T__20
                {
                mT__20(); 

                }
                break;
            case 12 :
                // QL.g:1:76: T__21
                {
                mT__21(); 

                }
                break;
            case 13 :
                // QL.g:1:82: T__22
                {
                mT__22(); 

                }
                break;
            case 14 :
                // QL.g:1:88: T__23
                {
                mT__23(); 

                }
                break;
            case 15 :
                // QL.g:1:94: T__24
                {
                mT__24(); 

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
                // QL.g:1:111: STRING
                {
                mSTRING(); 

                }
                break;
            case 19 :
                // QL.g:1:118: BOOL
                {
                mBOOL(); 

                }
                break;
            case 20 :
                // QL.g:1:123: IDENT
                {
                mIDENT(); 

                }
                break;
            case 21 :
                // QL.g:1:129: INT
                {
                mINT(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\5\uffff\1\26\1\uffff\1\30\1\32\1\34\5\uffff\4\23\12\uffff\10\23"+
        "\1\51\1\23\1\51\1\23\1\uffff\2\51";
    static final String DFA8_eofS =
        "\54\uffff";
    static final String DFA8_minS =
        "\1\11\4\uffff\1\75\1\uffff\1\52\2\75\5\uffff\1\162\1\141\1\122\1"+
        "\101\12\uffff\1\165\1\154\1\125\1\114\1\145\1\163\1\105\1\123\1"+
        "\60\1\145\1\60\1\105\1\uffff\2\60";
    static final String DFA8_maxS =
        "\1\174\4\uffff\1\75\1\uffff\1\52\2\75\5\uffff\1\162\1\141\1\122"+
        "\1\101\12\uffff\1\165\1\154\1\125\1\114\1\145\1\163\1\105\1\123"+
        "\1\172\1\145\1\172\1\105\1\uffff\2\172";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\3\uffff\1\14\1\16\1\17\1\20"+
        "\1\22\4\uffff\1\24\1\25\1\15\1\5\1\21\1\7\1\11\1\10\1\13\1\12\14"+
        "\uffff\1\23\2\uffff";
    static final String DFA8_specialS =
        "\54\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\15\2\uffff\1\15\22\uffff\1\15\1\5\1\16\3\uffff\1\13\1\16"+
            "\1\1\1\2\1\6\1\3\1\uffff\1\4\1\uffff\1\7\12\24\2\uffff\1\10"+
            "\1\12\1\11\2\uffff\5\23\1\22\15\23\1\21\6\23\6\uffff\5\23\1"+
            "\20\15\23\1\17\6\23\1\uffff\1\14",
            "",
            "",
            "",
            "",
            "\1\25",
            "",
            "\1\27",
            "\1\31",
            "\1\33",
            "",
            "",
            "",
            "",
            "",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
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
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\52",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\53",
            "",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23"
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

    class DFA8 extends DFA {

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
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | WS | COMMENT | STRING | BOOL | IDENT | INT );";
        }
    }
 

}