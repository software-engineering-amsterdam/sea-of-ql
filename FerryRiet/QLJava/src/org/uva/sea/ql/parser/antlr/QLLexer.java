// $ANTLR 3.4 QL.g 2013-01-08 15:22:02

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
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int COLON=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int LBRACE=8;
    public static final int RBRACE=9;
    public static final int String=10;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
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
    // $ANTLR end "T__30"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:110:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // QL.g:110:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // QL.g:121:6: ( '/*' ( . )* '*/' )
            // QL.g:121:8: '/*' ( . )* '*/'
            {
            match("/*"); 



            // QL.g:121:13: ( . )*
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
            	    // QL.g:121:13: .
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
            // QL.g:124:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:124:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // QL.g:124:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
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
            	    break loop3;
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
            // QL.g:126:4: ( ( '0' .. '9' )+ )
            // QL.g:126:6: ( '0' .. '9' )+
            {
            // QL.g:126:6: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
        // QL.g:1:8: ( T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | WS | String | COLON | LBRACE | RBRACE | COMMENT | Ident | Int )
        int alt5=27;
        switch ( input.LA(1) ) {
        case '!':
            {
            int LA5_1 = input.LA(2);

            if ( (LA5_1=='=') ) {
                alt5=2;
            }
            else {
                alt5=1;
            }
            }
            break;
        case '&':
            {
            alt5=3;
            }
            break;
        case '(':
            {
            alt5=4;
            }
            break;
        case ')':
            {
            alt5=5;
            }
            break;
        case '*':
            {
            alt5=6;
            }
            break;
        case '+':
            {
            alt5=7;
            }
            break;
        case '-':
            {
            alt5=8;
            }
            break;
        case '/':
            {
            int LA5_8 = input.LA(2);

            if ( (LA5_8=='*') ) {
                alt5=25;
            }
            else {
                alt5=9;
            }
            }
            break;
        case '<':
            {
            int LA5_9 = input.LA(2);

            if ( (LA5_9=='=') ) {
                alt5=11;
            }
            else {
                alt5=10;
            }
            }
            break;
        case '=':
            {
            alt5=12;
            }
            break;
        case '>':
            {
            int LA5_11 = input.LA(2);

            if ( (LA5_11=='=') ) {
                alt5=14;
            }
            else {
                alt5=13;
            }
            }
            break;
        case 'b':
            {
            int LA5_12 = input.LA(2);

            if ( (LA5_12=='o') ) {
                int LA5_32 = input.LA(3);

                if ( (LA5_32=='o') ) {
                    int LA5_36 = input.LA(4);

                    if ( (LA5_36=='l') ) {
                        int LA5_40 = input.LA(5);

                        if ( (LA5_40=='e') ) {
                            int LA5_43 = input.LA(6);

                            if ( (LA5_43=='a') ) {
                                int LA5_46 = input.LA(7);

                                if ( (LA5_46=='n') ) {
                                    int LA5_48 = input.LA(8);

                                    if ( ((LA5_48 >= '0' && LA5_48 <= '9')||(LA5_48 >= 'A' && LA5_48 <= 'Z')||LA5_48=='_'||(LA5_48 >= 'a' && LA5_48 <= 'z')) ) {
                                        alt5=26;
                                    }
                                    else {
                                        alt5=15;
                                    }
                                }
                                else {
                                    alt5=26;
                                }
                            }
                            else {
                                alt5=26;
                            }
                        }
                        else {
                            alt5=26;
                        }
                    }
                    else {
                        alt5=26;
                    }
                }
                else {
                    alt5=26;
                }
            }
            else {
                alt5=26;
            }
            }
            break;
        case 'f':
            {
            int LA5_13 = input.LA(2);

            if ( (LA5_13=='o') ) {
                int LA5_33 = input.LA(3);

                if ( (LA5_33=='r') ) {
                    int LA5_37 = input.LA(4);

                    if ( (LA5_37=='m') ) {
                        int LA5_41 = input.LA(5);

                        if ( ((LA5_41 >= '0' && LA5_41 <= '9')||(LA5_41 >= 'A' && LA5_41 <= 'Z')||LA5_41=='_'||(LA5_41 >= 'a' && LA5_41 <= 'z')) ) {
                            alt5=26;
                        }
                        else {
                            alt5=16;
                        }
                    }
                    else {
                        alt5=26;
                    }
                }
                else {
                    alt5=26;
                }
            }
            else {
                alt5=26;
            }
            }
            break;
        case 'i':
            {
            int LA5_14 = input.LA(2);

            if ( (LA5_14=='f') ) {
                int LA5_34 = input.LA(3);

                if ( ((LA5_34 >= '0' && LA5_34 <= '9')||(LA5_34 >= 'A' && LA5_34 <= 'Z')||LA5_34=='_'||(LA5_34 >= 'a' && LA5_34 <= 'z')) ) {
                    alt5=26;
                }
                else {
                    alt5=17;
                }
            }
            else {
                alt5=26;
            }
            }
            break;
        case 'm':
            {
            int LA5_15 = input.LA(2);

            if ( (LA5_15=='o') ) {
                int LA5_35 = input.LA(3);

                if ( (LA5_35=='n') ) {
                    int LA5_39 = input.LA(4);

                    if ( (LA5_39=='e') ) {
                        int LA5_42 = input.LA(5);

                        if ( (LA5_42=='y') ) {
                            int LA5_45 = input.LA(6);

                            if ( ((LA5_45 >= '0' && LA5_45 <= '9')||(LA5_45 >= 'A' && LA5_45 <= 'Z')||LA5_45=='_'||(LA5_45 >= 'a' && LA5_45 <= 'z')) ) {
                                alt5=26;
                            }
                            else {
                                alt5=18;
                            }
                        }
                        else {
                            alt5=26;
                        }
                    }
                    else {
                        alt5=26;
                    }
                }
                else {
                    alt5=26;
                }
            }
            else {
                alt5=26;
            }
            }
            break;
        case '|':
            {
            alt5=19;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt5=20;
            }
            break;
        case '\"':
            {
            alt5=21;
            }
            break;
        case ':':
            {
            alt5=22;
            }
            break;
        case '{':
            {
            alt5=23;
            }
            break;
        case '}':
            {
            alt5=24;
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
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt5=26;
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
            alt5=27;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
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
                // QL.g:1:106: T__28
                {
                mT__28(); 


                }
                break;
            case 18 :
                // QL.g:1:112: T__29
                {
                mT__29(); 


                }
                break;
            case 19 :
                // QL.g:1:118: T__30
                {
                mT__30(); 


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
                // QL.g:1:162: Ident
                {
                mIdent(); 


                }
                break;
            case 27 :
                // QL.g:1:168: Int
                {
                mInt(); 


                }
                break;

        }

    }


 

}