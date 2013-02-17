// $ANTLR !Unknown version! QL.g 2013-01-28 14:43:38

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;

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
    public static final int ELSE=9;
    public static final int BOOL=11;
    public static final int INT=10;
    public static final int EOF=-1;
    public static final int IF=8;
    public static final int TYPE=7;
    public static final int T__19=19;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__16=16;
    public static final int WS=13;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int IDENT=5;
    public static final int FORM=4;
    public static final int COMMENT=12;
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

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:7:7: ( '{' )
            // QL.g:7:9: '{'
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
            // QL.g:8:7: ( '}' )
            // QL.g:8:9: '}'
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
            // QL.g:9:7: ( ':' )
            // QL.g:9:9: ':'
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
            // QL.g:10:7: ( '(' )
            // QL.g:10:9: '('
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
            // QL.g:11:7: ( ')' )
            // QL.g:11:9: ')'
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
            // QL.g:12:7: ( '+' )
            // QL.g:12:9: '+'
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
            // QL.g:13:7: ( '-' )
            // QL.g:13:9: '-'
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
            // QL.g:14:7: ( '!' )
            // QL.g:14:9: '!'
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
            // QL.g:15:7: ( '*' )
            // QL.g:15:9: '*'
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
            // QL.g:16:7: ( '/' )
            // QL.g:16:9: '/'
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
            // QL.g:17:7: ( '<' )
            // QL.g:17:9: '<'
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
            // QL.g:18:7: ( '<=' )
            // QL.g:18:9: '<='
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
            // QL.g:19:7: ( '>' )
            // QL.g:19:9: '>'
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
            // QL.g:20:7: ( '>=' )
            // QL.g:20:9: '>='
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
            // QL.g:21:7: ( '==' )
            // QL.g:21:9: '=='
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
            // QL.g:22:7: ( '!=' )
            // QL.g:22:9: '!='
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
            // QL.g:23:7: ( '&&' )
            // QL.g:23:9: '&&'
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
            // QL.g:24:7: ( '||' )
            // QL.g:24:9: '||'
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

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:213:5: ( '/*' ( options {greedy=false; } : . )* '*/' | '//' ( options {greedy=false; } : . )* '\\n' )
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
                    // QL.g:213:7: '/*' ( options {greedy=false; } : . )* '*/'
                    {
                    match("/*"); 

                    // QL.g:213:12: ( options {greedy=false; } : . )*
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
                    	    // QL.g:213:38: .
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
                    // QL.g:214:7: '//' ( options {greedy=false; } : . )* '\\n'
                    {
                    match("//"); 

                    // QL.g:214:12: ( options {greedy=false; } : . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\n') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // QL.g:214:38: .
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
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:218:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // QL.g:218:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:223:2: ( '\"' ( options {greedy=false; } : . )* '\"' | '\\'' ( options {greedy=false; } : . )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // QL.g:223:4: '\"' ( options {greedy=false; } : . )* '\"'
                    {
                    match('\"'); 
                    // QL.g:223:8: ( options {greedy=false; } : . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\"') ) {
                            alt4=2;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // QL.g:223:34: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // QL.g:224:4: '\\'' ( options {greedy=false; } : . )* '\\''
                    {
                    match('\''); 
                    // QL.g:224:9: ( options {greedy=false; } : . )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\'') ) {
                            alt5=2;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='\uFFFF')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // QL.g:224:35: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
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
            // QL.g:228:2: ( 'if' )
            // QL.g:228:4: 'if'
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
            // QL.g:232:2: ( 'else' )
            // QL.g:232:4: 'else'
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

    // $ANTLR start "FORM"
    public final void mFORM() throws RecognitionException {
        try {
            int _type = FORM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:236:2: ( 'form' )
            // QL.g:236:4: 'form'
            {
            match("form"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FORM"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:240:2: ( 'true' | 'false' | 'TRUE' | 'FALSE' )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt7=1;
                }
                break;
            case 'f':
                {
                alt7=2;
                }
                break;
            case 'T':
                {
                alt7=3;
                }
                break;
            case 'F':
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // QL.g:240:4: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // QL.g:241:4: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 3 :
                    // QL.g:242:4: 'TRUE'
                    {
                    match("TRUE"); 


                    }
                    break;
                case 4 :
                    // QL.g:243:4: 'FALSE'
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
            // QL.g:247:2: ( 'boolean' | 'integer' | 'string' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt8=1;
                }
                break;
            case 'i':
                {
                alt8=2;
                }
                break;
            case 's':
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // QL.g:247:4: 'boolean'
                    {
                    match("boolean"); 


                    }
                    break;
                case 2 :
                    // QL.g:248:4: 'integer'
                    {
                    match("integer"); 


                    }
                    break;
                case 3 :
                    // QL.g:249:4: 'string'
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
            // QL.g:253:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:253:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // QL.g:253:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
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
            	    break loop9;
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
            // QL.g:256:2: ( ( '0' .. '9' )+ )
            // QL.g:256:4: ( '0' .. '9' )+
            {
            // QL.g:256:4: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // QL.g:256:5: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
        // QL.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | COMMENT | WS | STRING | IF | ELSE | FORM | BOOL | TYPE | IDENT | INT )
        int alt11=28;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // QL.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // QL.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // QL.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // QL.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // QL.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // QL.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // QL.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // QL.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // QL.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // QL.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // QL.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // QL.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // QL.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // QL.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // QL.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // QL.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // QL.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // QL.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // QL.g:1:118: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 20 :
                // QL.g:1:126: WS
                {
                mWS(); 

                }
                break;
            case 21 :
                // QL.g:1:129: STRING
                {
                mSTRING(); 

                }
                break;
            case 22 :
                // QL.g:1:136: IF
                {
                mIF(); 

                }
                break;
            case 23 :
                // QL.g:1:139: ELSE
                {
                mELSE(); 

                }
                break;
            case 24 :
                // QL.g:1:144: FORM
                {
                mFORM(); 

                }
                break;
            case 25 :
                // QL.g:1:149: BOOL
                {
                mBOOL(); 

                }
                break;
            case 26 :
                // QL.g:1:154: TYPE
                {
                mTYPE(); 

                }
                break;
            case 27 :
                // QL.g:1:159: IDENT
                {
                mIDENT(); 

                }
                break;
            case 28 :
                // QL.g:1:165: INT
                {
                mINT(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\10\uffff\1\35\1\uffff\1\37\1\41\1\43\5\uffff\10\32\12\uffff\1\56"+
        "\11\32\1\uffff\12\32\1\102\1\103\1\32\2\105\4\32\2\uffff\1\105\1"+
        "\uffff\1\105\4\32\3\116\1\uffff";
    static final String DFA11_eofS =
        "\117\uffff";
    static final String DFA11_minS =
        "\1\11\7\uffff\1\75\1\uffff\1\52\2\75\5\uffff\1\146\1\154\1\141\1"+
        "\162\1\122\1\101\1\157\1\164\12\uffff\1\60\1\164\1\163\1\162\1\154"+
        "\1\165\1\125\1\114\1\157\1\162\1\uffff\2\145\1\155\1\163\1\145\1"+
        "\105\1\123\1\154\1\151\1\147\2\60\1\145\2\60\1\105\1\145\1\156\1"+
        "\145\2\uffff\1\60\1\uffff\1\60\1\141\1\147\1\162\1\156\3\60\1\uffff";
    static final String DFA11_maxS =
        "\1\175\7\uffff\1\75\1\uffff\1\57\2\75\5\uffff\1\156\1\154\1\157"+
        "\1\162\1\122\1\101\1\157\1\164\12\uffff\1\172\1\164\1\163\1\162"+
        "\1\154\1\165\1\125\1\114\1\157\1\162\1\uffff\2\145\1\155\1\163\1"+
        "\145\1\105\1\123\1\154\1\151\1\147\2\172\1\145\2\172\1\105\1\145"+
        "\1\156\1\145\2\uffff\1\172\1\uffff\1\172\1\141\1\147\1\162\1\156"+
        "\3\172\1\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\11\3\uffff\1\17\1"+
        "\21\1\22\1\24\1\25\10\uffff\1\33\1\34\1\20\1\10\1\23\1\12\1\14\1"+
        "\13\1\16\1\15\12\uffff\1\26\23\uffff\1\27\1\30\1\uffff\1\31\10\uffff"+
        "\1\32";
    static final String DFA11_specialS =
        "\117\uffff}>";
    static final String[] DFA11_transitionS = {
            "\2\20\2\uffff\1\20\22\uffff\1\20\1\10\1\21\3\uffff\1\16\1\21"+
            "\1\4\1\5\1\11\1\6\1\uffff\1\7\1\uffff\1\12\12\33\1\3\1\uffff"+
            "\1\13\1\15\1\14\2\uffff\5\32\1\27\15\32\1\26\6\32\6\uffff\1"+
            "\32\1\30\2\32\1\23\1\24\2\32\1\22\11\32\1\31\1\25\6\32\1\1\1"+
            "\17\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34",
            "",
            "\1\36\4\uffff\1\36",
            "\1\40",
            "\1\42",
            "",
            "",
            "",
            "",
            "",
            "\1\44\7\uffff\1\45",
            "\1\46",
            "\1\50\15\uffff\1\47",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
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
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\104",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "",
            "",
            "\12\32\7\uffff\32\32\4\uffff\1\32\1\uffff\32\32",
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

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | COMMENT | WS | STRING | IF | ELSE | FORM | BOOL | TYPE | IDENT | INT );";
        }
    }
 

}