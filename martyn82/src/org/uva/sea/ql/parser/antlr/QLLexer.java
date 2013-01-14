// $ANTLR 3.4 QL.g 2013-01-14 11:23:16

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int NEWLINE=8;
    public static final int Str=9;
    public static final int Type=10;
    public static final int WS=11;

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

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "Type"
    public final void mType() throws RecognitionException {
        try {
            int _type = Type;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:119:3: ( 'boolean' | 'integer' | 'string' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt1=1;
                }
                break;
            case 'i':
                {
                alt1=2;
                }
                break;
            case 's':
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // QL.g:119:5: 'boolean'
                    {
                    match("boolean"); 



                    }
                    break;
                case 2 :
                    // QL.g:119:17: 'integer'
                    {
                    match("integer"); 



                    }
                    break;
                case 3 :
                    // QL.g:119:29: 'string'
                    {
                    match("string"); 



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
    // $ANTLR end "Type"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:122:5: ( ( ' ' | '\\t' | NEWLINE ) )
            // QL.g:122:7: ( ' ' | '\\t' | NEWLINE )
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
            // QL.g:126:5: ( ( '//' (~ ( NEWLINE ) )* | '/*' ( . )* '*/' ) )
            // QL.g:126:7: ( '//' (~ ( NEWLINE ) )* | '/*' ( . )* '*/' )
            {
            // QL.g:126:7: ( '//' (~ ( NEWLINE ) )* | '/*' ( . )* '*/' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='/') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='/') ) {
                    alt4=1;
                }
                else if ( (LA4_1=='*') ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // QL.g:126:8: '//' (~ ( NEWLINE ) )*
                    {
                    match("//"); 



                    // QL.g:126:13: (~ ( NEWLINE ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
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
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // QL.g:126:27: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // QL.g:126:32: ( . )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='*') ) {
                            int LA3_1 = input.LA(2);

                            if ( (LA3_1=='/') ) {
                                alt3=2;
                            }
                            else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
                                alt3=1;
                            }


                        }
                        else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // QL.g:126:32: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
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
            // QL.g:130:5: ( ( '\\r' | '\\n' ) )
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
            // QL.g:133:5: ( 'true' | 'false' )
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
                    // QL.g:133:9: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // QL.g:133:18: 'false'
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
            // QL.g:134:4: ( '\\\"' ( '\\\\\"' |~ '\\\"' )* '\\\"' )
            // QL.g:134:9: '\\\"' ( '\\\\\"' |~ '\\\"' )* '\\\"'
            {
            match('\"'); 

            // QL.g:134:14: ( '\\\\\"' |~ '\\\"' )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2=='\"') ) {
                        int LA6_4 = input.LA(3);

                        if ( ((LA6_4 >= '\u0000' && LA6_4 <= '\uFFFF')) ) {
                            alt6=1;
                        }

                        else {
                            alt6=2;
                        }


                    }
                    else if ( ((LA6_2 >= '\u0000' && LA6_2 <= '!')||(LA6_2 >= '#' && LA6_2 <= '\uFFFF')) ) {
                        alt6=2;
                    }


                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '[')||(LA6_0 >= ']' && LA6_0 <= '\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // QL.g:134:15: '\\\\\"'
            	    {
            	    match("\\\""); 



            	    }
            	    break;
            	case 2 :
            	    // QL.g:134:23: ~ '\\\"'
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
            	    break loop6;
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
            // QL.g:135:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:135:9: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // QL.g:135:28: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                    alt7=1;
                }


                switch (alt7) {
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
            	    break loop7;
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
            // QL.g:136:4: ( ( '0' .. '9' )+ )
            // QL.g:136:9: ( '0' .. '9' )+
            {
            // QL.g:136:9: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                    alt8=1;
                }


                switch (alt8) {
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Int"

    public void mTokens() throws RecognitionException {
        // QL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | Type | WS | COMMENT | Bool | Str | Ident | Int )
        int alt9=23;
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
                alt9=19;
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
        case '|':
            {
            alt9=16;
            }
            break;
        case 'b':
            {
            int LA9_14 = input.LA(2);

            if ( (LA9_14=='o') ) {
                int LA9_31 = input.LA(3);

                if ( (LA9_31=='o') ) {
                    int LA9_36 = input.LA(4);

                    if ( (LA9_36=='l') ) {
                        int LA9_41 = input.LA(5);

                        if ( (LA9_41=='e') ) {
                            int LA9_46 = input.LA(6);

                            if ( (LA9_46=='a') ) {
                                int LA9_51 = input.LA(7);

                                if ( (LA9_51=='n') ) {
                                    int LA9_54 = input.LA(8);

                                    if ( ((LA9_54 >= '0' && LA9_54 <= '9')||(LA9_54 >= 'A' && LA9_54 <= 'Z')||LA9_54=='_'||(LA9_54 >= 'a' && LA9_54 <= 'z')) ) {
                                        alt9=22;
                                    }
                                    else {
                                        alt9=17;
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
        case 'i':
            {
            int LA9_15 = input.LA(2);

            if ( (LA9_15=='n') ) {
                int LA9_32 = input.LA(3);

                if ( (LA9_32=='t') ) {
                    int LA9_37 = input.LA(4);

                    if ( (LA9_37=='e') ) {
                        int LA9_42 = input.LA(5);

                        if ( (LA9_42=='g') ) {
                            int LA9_47 = input.LA(6);

                            if ( (LA9_47=='e') ) {
                                int LA9_52 = input.LA(7);

                                if ( (LA9_52=='r') ) {
                                    int LA9_55 = input.LA(8);

                                    if ( ((LA9_55 >= '0' && LA9_55 <= '9')||(LA9_55 >= 'A' && LA9_55 <= 'Z')||LA9_55=='_'||(LA9_55 >= 'a' && LA9_55 <= 'z')) ) {
                                        alt9=22;
                                    }
                                    else {
                                        alt9=17;
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
        case 's':
            {
            int LA9_16 = input.LA(2);

            if ( (LA9_16=='t') ) {
                int LA9_33 = input.LA(3);

                if ( (LA9_33=='r') ) {
                    int LA9_38 = input.LA(4);

                    if ( (LA9_38=='i') ) {
                        int LA9_43 = input.LA(5);

                        if ( (LA9_43=='n') ) {
                            int LA9_48 = input.LA(6);

                            if ( (LA9_48=='g') ) {
                                int LA9_53 = input.LA(7);

                                if ( ((LA9_53 >= '0' && LA9_53 <= '9')||(LA9_53 >= 'A' && LA9_53 <= 'Z')||LA9_53=='_'||(LA9_53 >= 'a' && LA9_53 <= 'z')) ) {
                                    alt9=22;
                                }
                                else {
                                    alt9=17;
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
                else {
                    alt9=22;
                }
            }
            else {
                alt9=22;
            }
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt9=18;
            }
            break;
        case 't':
            {
            int LA9_18 = input.LA(2);

            if ( (LA9_18=='r') ) {
                int LA9_34 = input.LA(3);

                if ( (LA9_34=='u') ) {
                    int LA9_39 = input.LA(4);

                    if ( (LA9_39=='e') ) {
                        int LA9_44 = input.LA(5);

                        if ( ((LA9_44 >= '0' && LA9_44 <= '9')||(LA9_44 >= 'A' && LA9_44 <= 'Z')||LA9_44=='_'||(LA9_44 >= 'a' && LA9_44 <= 'z')) ) {
                            alt9=22;
                        }
                        else {
                            alt9=20;
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
        case 'f':
            {
            int LA9_19 = input.LA(2);

            if ( (LA9_19=='a') ) {
                int LA9_35 = input.LA(3);

                if ( (LA9_35=='l') ) {
                    int LA9_40 = input.LA(4);

                    if ( (LA9_40=='s') ) {
                        int LA9_45 = input.LA(5);

                        if ( (LA9_45=='e') ) {
                            int LA9_50 = input.LA(6);

                            if ( ((LA9_50 >= '0' && LA9_50 <= '9')||(LA9_50 >= 'A' && LA9_50 <= 'Z')||LA9_50=='_'||(LA9_50 >= 'a' && LA9_50 <= 'z')) ) {
                                alt9=22;
                            }
                            else {
                                alt9=20;
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
            else {
                alt9=22;
            }
            }
            break;
        case '\"':
            {
            alt9=21;
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
        case 'e':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
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
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 9, 0, input);

            throw nvae;

        }

        switch (alt9) {
            case 1 :
                // QL.g:1:10: T__12
                {
                mT__12(); 


                }
                break;
            case 2 :
                // QL.g:1:16: T__13
                {
                mT__13(); 


                }
                break;
            case 3 :
                // QL.g:1:22: T__14
                {
                mT__14(); 


                }
                break;
            case 4 :
                // QL.g:1:28: T__15
                {
                mT__15(); 


                }
                break;
            case 5 :
                // QL.g:1:34: T__16
                {
                mT__16(); 


                }
                break;
            case 6 :
                // QL.g:1:40: T__17
                {
                mT__17(); 


                }
                break;
            case 7 :
                // QL.g:1:46: T__18
                {
                mT__18(); 


                }
                break;
            case 8 :
                // QL.g:1:52: T__19
                {
                mT__19(); 


                }
                break;
            case 9 :
                // QL.g:1:58: T__20
                {
                mT__20(); 


                }
                break;
            case 10 :
                // QL.g:1:64: T__21
                {
                mT__21(); 


                }
                break;
            case 11 :
                // QL.g:1:70: T__22
                {
                mT__22(); 


                }
                break;
            case 12 :
                // QL.g:1:76: T__23
                {
                mT__23(); 


                }
                break;
            case 13 :
                // QL.g:1:82: T__24
                {
                mT__24(); 


                }
                break;
            case 14 :
                // QL.g:1:88: T__25
                {
                mT__25(); 


                }
                break;
            case 15 :
                // QL.g:1:94: T__26
                {
                mT__26(); 


                }
                break;
            case 16 :
                // QL.g:1:100: T__27
                {
                mT__27(); 


                }
                break;
            case 17 :
                // QL.g:1:106: Type
                {
                mType(); 


                }
                break;
            case 18 :
                // QL.g:1:111: WS
                {
                mWS(); 


                }
                break;
            case 19 :
                // QL.g:1:114: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 20 :
                // QL.g:1:122: Bool
                {
                mBool(); 


                }
                break;
            case 21 :
                // QL.g:1:127: Str
                {
                mStr(); 


                }
                break;
            case 22 :
                // QL.g:1:131: Ident
                {
                mIdent(); 


                }
                break;
            case 23 :
                // QL.g:1:137: Int
                {
                mInt(); 


                }
                break;

        }

    }


 

}