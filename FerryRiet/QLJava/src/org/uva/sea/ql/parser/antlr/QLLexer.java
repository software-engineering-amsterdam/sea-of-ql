// $ANTLR 3.4 QL.g 2013-01-08 18:16:45

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int Boolean=4;
    public static final int COLON=5;
    public static final int COMMENT=6;
    public static final int Ident=7;
    public static final int Int=8;
    public static final int LBRACE=9;
    public static final int RBRACE=10;
    public static final int String=11;
    public static final int WS=12;

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

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
        	// do for sure before leaving
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:20:7: ( 'boolean' )
            // QL.g:20:9: 'boolean'
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:22:7: ( 'if' )
            // QL.g:22:9: 'if'
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:23:7: ( 'money' )
            // QL.g:23:9: 'money'
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:111:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // QL.g:111:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:114:8: ( '\"' (~ ( '\\n' | '\\r' | '\"' ) )* '\"' )
            // QL.g:114:10: '\"' (~ ( '\\n' | '\\r' | '\"' ) )* '\"'
            {
            match('\"'); 

            // QL.g:114:14: (~ ( '\\n' | '\\r' | '\"' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '!')||(LA1_0 >= '#' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // QL.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:116:8: ( ':' )
            // QL.g:116:10: ':'
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
    // $ANTLR end "COLON"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:117:8: ( '{' )
            // QL.g:117:10: '{'
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
    // $ANTLR end "LBRACE"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:118:8: ( '}' )
            // QL.g:118:10: '}'
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
    // $ANTLR end "RBRACE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:121:5: ( '/*' ( . )* '*/' | '//' (~ '\\n' )* )
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
                    // QL.g:121:7: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // QL.g:121:12: ( . )*
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
                    	    // QL.g:121:12: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    match("*/"); 



                    _channel=HIDDEN;

                    }
                    break;
                case 2 :
                    // QL.g:122:7: '//' (~ '\\n' )*
                    {
                    match("//"); 



                    // QL.g:122:12: (~ '\\n' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // QL.g:
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\uFFFF') ) {
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
                    } while (true);


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

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:126:5: ( 'true' | 'false' )
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
                    // QL.g:126:7: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // QL.g:127:7: 'false'
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
    // $ANTLR end "Boolean"

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:130:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:130:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // QL.g:130:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
            // QL.g:134:4: ( ( '0' .. '9' )+ )
            // QL.g:134:6: ( '0' .. '9' )+
            {
            // QL.g:134:6: ( '0' .. '9' )+
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
        // QL.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | WS | String | COLON | LBRACE | RBRACE | COMMENT | Boolean | Ident | Int )
        int alt8=28;
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
                alt8=25;
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
        case 'b':
            {
            int LA8_12 = input.LA(2);

            if ( (LA8_12=='o') ) {
                int LA8_33 = input.LA(3);

                if ( (LA8_33=='o') ) {
                    int LA8_39 = input.LA(4);

                    if ( (LA8_39=='l') ) {
                        int LA8_45 = input.LA(5);

                        if ( (LA8_45=='e') ) {
                            int LA8_50 = input.LA(6);

                            if ( (LA8_50=='a') ) {
                                int LA8_55 = input.LA(7);

                                if ( (LA8_55=='n') ) {
                                    int LA8_57 = input.LA(8);

                                    if ( ((LA8_57 >= '0' && LA8_57 <= '9')||(LA8_57 >= 'A' && LA8_57 <= 'Z')||LA8_57=='_'||(LA8_57 >= 'a' && LA8_57 <= 'z')) ) {
                                        alt8=27;
                                    }
                                    else {
                                        alt8=15;
                                    }
                                }
                                else {
                                    alt8=27;
                                }
                            }
                            else {
                                alt8=27;
                            }
                        }
                        else {
                            alt8=27;
                        }
                    }
                    else {
                        alt8=27;
                    }
                }
                else {
                    alt8=27;
                }
            }
            else {
                alt8=27;
            }
            }
            break;
        case 'f':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA8_34 = input.LA(3);

                if ( (LA8_34=='r') ) {
                    int LA8_40 = input.LA(4);

                    if ( (LA8_40=='m') ) {
                        int LA8_46 = input.LA(5);

                        if ( ((LA8_46 >= '0' && LA8_46 <= '9')||(LA8_46 >= 'A' && LA8_46 <= 'Z')||LA8_46=='_'||(LA8_46 >= 'a' && LA8_46 <= 'z')) ) {
                            alt8=27;
                        }
                        else {
                            alt8=16;
                        }
                    }
                    else {
                        alt8=27;
                    }
                }
                else {
                    alt8=27;
                }
                }
                break;
            case 'a':
                {
                int LA8_35 = input.LA(3);

                if ( (LA8_35=='l') ) {
                    int LA8_41 = input.LA(4);

                    if ( (LA8_41=='s') ) {
                        int LA8_47 = input.LA(5);

                        if ( (LA8_47=='e') ) {
                            int LA8_52 = input.LA(6);

                            if ( ((LA8_52 >= '0' && LA8_52 <= '9')||(LA8_52 >= 'A' && LA8_52 <= 'Z')||LA8_52=='_'||(LA8_52 >= 'a' && LA8_52 <= 'z')) ) {
                                alt8=27;
                            }
                            else {
                                alt8=26;
                            }
                        }
                        else {
                            alt8=27;
                        }
                    }
                    else {
                        alt8=27;
                    }
                }
                else {
                    alt8=27;
                }
                }
                break;
            default:
                alt8=27;
            }

            }
            break;
        case 'i':
            {
            int LA8_14 = input.LA(2);

            if ( (LA8_14=='f') ) {
                int LA8_36 = input.LA(3);

                if ( ((LA8_36 >= '0' && LA8_36 <= '9')||(LA8_36 >= 'A' && LA8_36 <= 'Z')||LA8_36=='_'||(LA8_36 >= 'a' && LA8_36 <= 'z')) ) {
                    alt8=27;
                }
                else {
                    alt8=17;
                }
            }
            else {
                alt8=27;
            }
            }
            break;
        case 'm':
            {
            int LA8_15 = input.LA(2);

            if ( (LA8_15=='o') ) {
                int LA8_37 = input.LA(3);

                if ( (LA8_37=='n') ) {
                    int LA8_43 = input.LA(4);

                    if ( (LA8_43=='e') ) {
                        int LA8_48 = input.LA(5);

                        if ( (LA8_48=='y') ) {
                            int LA8_53 = input.LA(6);

                            if ( ((LA8_53 >= '0' && LA8_53 <= '9')||(LA8_53 >= 'A' && LA8_53 <= 'Z')||LA8_53=='_'||(LA8_53 >= 'a' && LA8_53 <= 'z')) ) {
                                alt8=27;
                            }
                            else {
                                alt8=18;
                            }
                        }
                        else {
                            alt8=27;
                        }
                    }
                    else {
                        alt8=27;
                    }
                }
                else {
                    alt8=27;
                }
            }
            else {
                alt8=27;
            }
            }
            break;
        case '|':
            {
            alt8=19;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt8=20;
            }
            break;
        case '\"':
            {
            alt8=21;
            }
            break;
        case ':':
            {
            alt8=22;
            }
            break;
        case '{':
            {
            alt8=23;
            }
            break;
        case '}':
            {
            alt8=24;
            }
            break;
        case 't':
            {
            int LA8_22 = input.LA(2);

            if ( (LA8_22=='r') ) {
                int LA8_38 = input.LA(3);

                if ( (LA8_38=='u') ) {
                    int LA8_44 = input.LA(4);

                    if ( (LA8_44=='e') ) {
                        int LA8_49 = input.LA(5);

                        if ( ((LA8_49 >= '0' && LA8_49 <= '9')||(LA8_49 >= 'A' && LA8_49 <= 'Z')||LA8_49=='_'||(LA8_49 >= 'a' && LA8_49 <= 'z')) ) {
                            alt8=27;
                        }
                        else {
                            alt8=26;
                        }
                    }
                    else {
                        alt8=27;
                    }
                }
                else {
                    alt8=27;
                }
            }
            else {
                alt8=27;
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
        case 'e':
        case 'g':
        case 'h':
        case 'j':
        case 'k':
        case 'l':
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
            alt8=27;
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
            alt8=28;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }

        switch (alt8) {
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
                // QL.g:1:127: String
                {
                mString(); 


                }
                break;
            case 22 :
                // QL.g:1:134: COLON
                {
                mCOLON(); 


                }
                break;
            case 23 :
                // QL.g:1:140: LBRACE
                {
                mLBRACE(); 


                }
                break;
            case 24 :
                // QL.g:1:147: RBRACE
                {
                mRBRACE(); 


                }
                break;
            case 25 :
                // QL.g:1:154: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 26 :
                // QL.g:1:162: Boolean
                {
                mBoolean(); 


                }
                break;
            case 27 :
                // QL.g:1:170: Ident
                {
                mIdent(); 


                }
                break;
            case 28 :
                // QL.g:1:176: Int
                {
                mInt(); 


                }
                break;

        }

    }


 

}