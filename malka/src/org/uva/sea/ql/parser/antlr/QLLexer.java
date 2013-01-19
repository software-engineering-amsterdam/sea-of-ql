// $ANTLR !Unknown version! QL.g 2013-01-19 17:14:56

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class QLLexer extends Lexer {
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int ELSE=8;
    public static final int BOOL=10;
    public static final int INT=9;
    public static final int EOF=-1;
    public static final int IF=7;
    public static final int TYPE=6;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__16=16;
    public static final int WS=11;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int IDENT=4;
    public static final int COMMENT=12;
    public static final int STRING=5;

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

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:7:7: ( 'form' )
            // QL.g:7:9: 'form'
            {
            match("form"); 


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
            // QL.g:8:7: ( '{' )
            // QL.g:8:9: '{'
            {
            match('{'); 

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
            // QL.g:9:7: ( '}' )
            // QL.g:9:9: '}'
            {
            match('}'); 

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
            // QL.g:10:7: ( ':' )
            // QL.g:10:9: ':'
            {
            match(':'); 

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
            // QL.g:11:7: ( '(' )
            // QL.g:11:9: '('
            {
            match('('); 

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
            // QL.g:12:7: ( ')' )
            // QL.g:12:9: ')'
            {
            match(')'); 

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
            // QL.g:13:7: ( '+' )
            // QL.g:13:9: '+'
            {
            match('+'); 

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
            // QL.g:14:7: ( '-' )
            // QL.g:14:9: '-'
            {
            match('-'); 

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
            // QL.g:15:7: ( '!' )
            // QL.g:15:9: '!'
            {
            match('!'); 

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
            // QL.g:16:7: ( '*' )
            // QL.g:16:9: '*'
            {
            match('*'); 

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
            // QL.g:17:7: ( '/' )
            // QL.g:17:9: '/'
            {
            match('/'); 

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
            // QL.g:18:7: ( '<' )
            // QL.g:18:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:19:7: ( '<=' )
            // QL.g:19:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:20:7: ( '>' )
            // QL.g:20:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:21:7: ( '>=' )
            // QL.g:21:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:22:7: ( '==' )
            // QL.g:22:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:23:7: ( '!=' )
            // QL.g:23:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:24:7: ( '&&' )
            // QL.g:24:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:25:7: ( '||' )
            // QL.g:25:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:109:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // QL.g:109:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // QL.g:113:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // QL.g:113:7: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // QL.g:113:12: ( options {greedy=false; } : . )*
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
            	    // QL.g:113:38: .
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
            // QL.g:117:2: ( '\"' ( options {greedy=false; } : . )* '\"' | '\\'' ( options {greedy=false; } : . )* '\\'' )
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
                    // QL.g:117:4: '\"' ( options {greedy=false; } : . )* '\"'
                    {
                    match('\"'); 
                    // QL.g:117:8: ( options {greedy=false; } : . )*
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
                    	    // QL.g:117:34: .
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
                    // QL.g:118:4: '\\'' ( options {greedy=false; } : . )* '\\''
                    {
                    match('\''); 
                    // QL.g:118:9: ( options {greedy=false; } : . )*
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
                    	    // QL.g:118:35: .
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

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:122:2: ( 'if' )
            // QL.g:122:4: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:126:2: ( 'else' )
            // QL.g:126:4: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:130:2: ( 'true' | 'false' | 'TRUE' | 'FALSE' )
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
                    // QL.g:130:4: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // QL.g:131:4: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 3 :
                    // QL.g:132:4: 'TRUE'
                    {
                    match("TRUE"); 


                    }
                    break;
                case 4 :
                    // QL.g:133:4: 'FALSE'
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

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:137:2: ( 'boolean' | 'integer' | 'string' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt6=1;
                }
                break;
            case 'i':
                {
                alt6=2;
                }
                break;
            case 's':
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // QL.g:137:4: 'boolean'
                    {
                    match("boolean"); 


                    }
                    break;
                case 2 :
                    // QL.g:138:4: 'integer'
                    {
                    match("integer"); 


                    }
                    break;
                case 3 :
                    // QL.g:139:4: 'string'
                    {
                    match("string"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:143:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:143:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // QL.g:143:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
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
            	    break loop7;
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
            // QL.g:146:2: ( ( '0' .. '9' )+ )
            // QL.g:146:4: ( '0' .. '9' )+
            {
            // QL.g:146:4: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // QL.g:146:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
        // QL.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | WS | COMMENT | STRING | IF | ELSE | BOOL | TYPE | IDENT | INT )
        int alt9=28;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // QL.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // QL.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // QL.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // QL.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // QL.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // QL.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // QL.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // QL.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // QL.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // QL.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // QL.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // QL.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // QL.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // QL.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // QL.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // QL.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // QL.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // QL.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // QL.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // QL.g:1:124: WS
                {
                mWS(); 

                }
                break;
            case 21 :
                // QL.g:1:127: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 22 :
                // QL.g:1:135: STRING
                {
                mSTRING(); 

                }
                break;
            case 23 :
                // QL.g:1:142: IF
                {
                mIF(); 

                }
                break;
            case 24 :
                // QL.g:1:145: ELSE
                {
                mELSE(); 

                }
                break;
            case 25 :
                // QL.g:1:150: BOOL
                {
                mBOOL(); 

                }
                break;
            case 26 :
                // QL.g:1:155: TYPE
                {
                mTYPE(); 

                }
                break;
            case 27 :
                // QL.g:1:160: IDENT
                {
                mIDENT(); 

                }
                break;
            case 28 :
                // QL.g:1:166: INT
                {
                mINT(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\32\7\uffff\1\37\1\uffff\1\41\1\43\1\45\5\uffff\7\32\2"+
        "\uffff\2\32\10\uffff\1\60\11\32\1\uffff\7\32\1\101\2\32\1\104\2"+
        "\105\3\32\1\uffff\1\105\1\32\2\uffff\1\105\4\32\3\116\1\uffff";
    static final String DFA9_eofS =
        "\117\uffff";
    static final String DFA9_minS =
        "\1\11\1\141\7\uffff\1\75\1\uffff\1\52\2\75\5\uffff\1\146\1\154\1"+
        "\162\1\122\1\101\1\157\1\164\2\uffff\1\162\1\154\10\uffff\1\60\1"+
        "\164\1\163\1\165\1\125\1\114\1\157\1\162\1\155\1\163\1\uffff\3\145"+
        "\1\105\1\123\1\154\1\151\1\60\1\145\1\147\3\60\1\105\1\145\1\156"+
        "\1\uffff\1\60\1\145\2\uffff\1\60\1\141\1\147\1\162\1\156\3\60\1"+
        "\uffff";
    static final String DFA9_maxS =
        "\1\175\1\157\7\uffff\1\75\1\uffff\1\52\2\75\5\uffff\1\156\1\154"+
        "\1\162\1\122\1\101\1\157\1\164\2\uffff\1\162\1\154\10\uffff\1\172"+
        "\1\164\1\163\1\165\1\125\1\114\1\157\1\162\1\155\1\163\1\uffff\3"+
        "\145\1\105\1\123\1\154\1\151\1\172\1\145\1\147\3\172\1\105\1\145"+
        "\1\156\1\uffff\1\172\1\145\2\uffff\1\172\1\141\1\147\1\162\1\156"+
        "\3\172\1\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\3\uffff\1\20"+
        "\1\22\1\23\1\24\1\26\7\uffff\1\33\1\34\2\uffff\1\21\1\11\1\25\1"+
        "\13\1\15\1\14\1\17\1\16\12\uffff\1\27\20\uffff\1\1\2\uffff\1\30"+
        "\1\31\10\uffff\1\32";
    static final String DFA9_specialS =
        "\117\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\21\2\uffff\1\21\22\uffff\1\21\1\11\1\22\3\uffff\1\17\1\22"+
            "\1\5\1\6\1\12\1\7\1\uffff\1\10\1\uffff\1\13\12\33\1\4\1\uffff"+
            "\1\14\1\16\1\15\2\uffff\5\32\1\27\15\32\1\26\6\32\6\uffff\1"+
            "\32\1\30\2\32\1\24\1\1\2\32\1\23\11\32\1\31\1\25\6\32\1\2\1"+
            "\20\1\3",
            "\1\35\15\uffff\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\36",
            "",
            "\1\40",
            "\1\42",
            "\1\44",
            "",
            "",
            "",
            "",
            "",
            "\1\46\7\uffff\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "",
            "\1\56",
            "\1\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\102",
            "\1\103",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\111",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
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

    class DFA9 extends DFA {

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
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | WS | COMMENT | STRING | IF | ELSE | BOOL | TYPE | IDENT | INT );";
        }
    }
 

}