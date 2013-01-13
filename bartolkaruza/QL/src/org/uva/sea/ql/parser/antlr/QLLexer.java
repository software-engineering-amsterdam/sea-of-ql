// $ANTLR 3.4 src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-09 20:35:19

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int COMMENT=4;
    public static final int IF=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int TYPE=8;
    public static final int WS=9;

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
    public String getGrammarFileName() { return "src/org/uva/sea/ql/parser/antlr/QL.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( ':' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:15:9: ':'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<'
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<=' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<='
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '==' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '=='
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>'
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>=' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>='
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( '\\\"' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:21:9: '\\\"'
            {
            match('\"'); 

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
            // src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( 'form' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:22:9: 'form'
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( '{' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:23:9: '{'
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( '||' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:24:9: '||'
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( '}' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:25:9: '}'
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
    // $ANTLR end "T__29"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:109:6: ( 'boolean' | 'number' | 'textfield' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt1=1;
                }
                break;
            case 'n':
                {
                alt1=2;
                }
                break;
            case 't':
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
                    // src/org/uva/sea/ql/parser/antlr/QL.g:109:8: 'boolean'
                    {
                    match("boolean"); 



                    }
                    break;
                case 2 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:109:20: 'number'
                    {
                    match("number"); 



                    }
                    break;
                case 3 :
                    // src/org/uva/sea/ql/parser/antlr/QL.g:109:31: 'textfield'
                    {
                    match("textfield"); 



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
    // $ANTLR end "TYPE"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:111:4: ( 'if' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:111:6: 'if'
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
    // $ANTLR end "IF"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // src/org/uva/sea/ql/parser/antlr/QL.g:115:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // src/org/uva/sea/ql/parser/antlr/QL.g:115:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:117:9: ( '/*' ( . )* '*/' )
            // src/org/uva/sea/ql/parser/antlr/QL.g:117:11: '/*' ( . )* '*/'
            {
            match("/*"); 



            // src/org/uva/sea/ql/parser/antlr/QL.g:117:16: ( . )*
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
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:117:16: .
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:119:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // src/org/uva/sea/ql/parser/antlr/QL.g:119:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // src/org/uva/sea/ql/parser/antlr/QL.g:119:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:
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
            // src/org/uva/sea/ql/parser/antlr/QL.g:121:4: ( ( '0' .. '9' )+ )
            // src/org/uva/sea/ql/parser/antlr/QL.g:121:6: ( '0' .. '9' )+
            {
            // src/org/uva/sea/ql/parser/antlr/QL.g:121:6: ( '0' .. '9' )+
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
            	    // src/org/uva/sea/ql/parser/antlr/QL.g:
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
        // src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | TYPE | IF | WS | COMMENT | Ident | Int )
        int alt5=26;
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
                alt5=24;
            }
            else {
                alt5=9;
            }
            }
            break;
        case ':':
            {
            alt5=10;
            }
            break;
        case '<':
            {
            int LA5_10 = input.LA(2);

            if ( (LA5_10=='=') ) {
                alt5=12;
            }
            else {
                alt5=11;
            }
            }
            break;
        case '=':
            {
            alt5=13;
            }
            break;
        case '>':
            {
            int LA5_12 = input.LA(2);

            if ( (LA5_12=='=') ) {
                alt5=15;
            }
            else {
                alt5=14;
            }
            }
            break;
        case '\"':
            {
            alt5=16;
            }
            break;
        case 'f':
            {
            int LA5_14 = input.LA(2);

            if ( (LA5_14=='o') ) {
                int LA5_33 = input.LA(3);

                if ( (LA5_33=='r') ) {
                    int LA5_38 = input.LA(4);

                    if ( (LA5_38=='m') ) {
                        int LA5_43 = input.LA(5);

                        if ( ((LA5_43 >= '0' && LA5_43 <= '9')||(LA5_43 >= 'A' && LA5_43 <= 'Z')||LA5_43=='_'||(LA5_43 >= 'a' && LA5_43 <= 'z')) ) {
                            alt5=25;
                        }
                        else {
                            alt5=17;
                        }
                    }
                    else {
                        alt5=25;
                    }
                }
                else {
                    alt5=25;
                }
            }
            else {
                alt5=25;
            }
            }
            break;
        case '{':
            {
            alt5=18;
            }
            break;
        case '|':
            {
            alt5=19;
            }
            break;
        case '}':
            {
            alt5=20;
            }
            break;
        case 'b':
            {
            int LA5_18 = input.LA(2);

            if ( (LA5_18=='o') ) {
                int LA5_34 = input.LA(3);

                if ( (LA5_34=='o') ) {
                    int LA5_39 = input.LA(4);

                    if ( (LA5_39=='l') ) {
                        int LA5_44 = input.LA(5);

                        if ( (LA5_44=='e') ) {
                            int LA5_48 = input.LA(6);

                            if ( (LA5_48=='a') ) {
                                int LA5_51 = input.LA(7);

                                if ( (LA5_51=='n') ) {
                                    int LA5_54 = input.LA(8);

                                    if ( ((LA5_54 >= '0' && LA5_54 <= '9')||(LA5_54 >= 'A' && LA5_54 <= 'Z')||LA5_54=='_'||(LA5_54 >= 'a' && LA5_54 <= 'z')) ) {
                                        alt5=25;
                                    }
                                    else {
                                        alt5=21;
                                    }
                                }
                                else {
                                    alt5=25;
                                }
                            }
                            else {
                                alt5=25;
                            }
                        }
                        else {
                            alt5=25;
                        }
                    }
                    else {
                        alt5=25;
                    }
                }
                else {
                    alt5=25;
                }
            }
            else {
                alt5=25;
            }
            }
            break;
        case 'n':
            {
            int LA5_19 = input.LA(2);

            if ( (LA5_19=='u') ) {
                int LA5_35 = input.LA(3);

                if ( (LA5_35=='m') ) {
                    int LA5_40 = input.LA(4);

                    if ( (LA5_40=='b') ) {
                        int LA5_45 = input.LA(5);

                        if ( (LA5_45=='e') ) {
                            int LA5_49 = input.LA(6);

                            if ( (LA5_49=='r') ) {
                                int LA5_52 = input.LA(7);

                                if ( ((LA5_52 >= '0' && LA5_52 <= '9')||(LA5_52 >= 'A' && LA5_52 <= 'Z')||LA5_52=='_'||(LA5_52 >= 'a' && LA5_52 <= 'z')) ) {
                                    alt5=25;
                                }
                                else {
                                    alt5=21;
                                }
                            }
                            else {
                                alt5=25;
                            }
                        }
                        else {
                            alt5=25;
                        }
                    }
                    else {
                        alt5=25;
                    }
                }
                else {
                    alt5=25;
                }
            }
            else {
                alt5=25;
            }
            }
            break;
        case 't':
            {
            int LA5_20 = input.LA(2);

            if ( (LA5_20=='e') ) {
                int LA5_36 = input.LA(3);

                if ( (LA5_36=='x') ) {
                    int LA5_41 = input.LA(4);

                    if ( (LA5_41=='t') ) {
                        int LA5_46 = input.LA(5);

                        if ( (LA5_46=='f') ) {
                            int LA5_50 = input.LA(6);

                            if ( (LA5_50=='i') ) {
                                int LA5_53 = input.LA(7);

                                if ( (LA5_53=='e') ) {
                                    int LA5_56 = input.LA(8);

                                    if ( (LA5_56=='l') ) {
                                        int LA5_57 = input.LA(9);

                                        if ( (LA5_57=='d') ) {
                                            int LA5_58 = input.LA(10);

                                            if ( ((LA5_58 >= '0' && LA5_58 <= '9')||(LA5_58 >= 'A' && LA5_58 <= 'Z')||LA5_58=='_'||(LA5_58 >= 'a' && LA5_58 <= 'z')) ) {
                                                alt5=25;
                                            }
                                            else {
                                                alt5=21;
                                            }
                                        }
                                        else {
                                            alt5=25;
                                        }
                                    }
                                    else {
                                        alt5=25;
                                    }
                                }
                                else {
                                    alt5=25;
                                }
                            }
                            else {
                                alt5=25;
                            }
                        }
                        else {
                            alt5=25;
                        }
                    }
                    else {
                        alt5=25;
                    }
                }
                else {
                    alt5=25;
                }
            }
            else {
                alt5=25;
            }
            }
            break;
        case 'i':
            {
            int LA5_21 = input.LA(2);

            if ( (LA5_21=='f') ) {
                int LA5_37 = input.LA(3);

                if ( ((LA5_37 >= '0' && LA5_37 <= '9')||(LA5_37 >= 'A' && LA5_37 <= 'Z')||LA5_37=='_'||(LA5_37 >= 'a' && LA5_37 <= 'z')) ) {
                    alt5=25;
                }
                else {
                    alt5=22;
                }
            }
            else {
                alt5=25;
            }
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt5=23;
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
            alt5=25;
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
            alt5=26;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 5, 0, input);

            throw nvae;

        }

        switch (alt5) {
            case 1 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__10
                {
                mT__10(); 


                }
                break;
            case 2 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__11
                {
                mT__11(); 


                }
                break;
            case 3 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__12
                {
                mT__12(); 


                }
                break;
            case 4 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__13
                {
                mT__13(); 


                }
                break;
            case 5 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__14
                {
                mT__14(); 


                }
                break;
            case 6 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__15
                {
                mT__15(); 


                }
                break;
            case 7 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__16
                {
                mT__16(); 


                }
                break;
            case 8 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__17
                {
                mT__17(); 


                }
                break;
            case 9 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__18
                {
                mT__18(); 


                }
                break;
            case 10 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__19
                {
                mT__19(); 


                }
                break;
            case 11 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__20
                {
                mT__20(); 


                }
                break;
            case 12 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__21
                {
                mT__21(); 


                }
                break;
            case 13 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__22
                {
                mT__22(); 


                }
                break;
            case 14 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__23
                {
                mT__23(); 


                }
                break;
            case 15 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__24
                {
                mT__24(); 


                }
                break;
            case 16 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__25
                {
                mT__25(); 


                }
                break;
            case 17 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__26
                {
                mT__26(); 


                }
                break;
            case 18 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__27
                {
                mT__27(); 


                }
                break;
            case 19 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__28
                {
                mT__28(); 


                }
                break;
            case 20 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:124: T__29
                {
                mT__29(); 


                }
                break;
            case 21 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:130: TYPE
                {
                mTYPE(); 


                }
                break;
            case 22 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:135: IF
                {
                mIF(); 


                }
                break;
            case 23 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:138: WS
                {
                mWS(); 


                }
                break;
            case 24 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:141: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 25 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:149: Ident
                {
                mIdent(); 


                }
                break;
            case 26 :
                // src/org/uva/sea/ql/parser/antlr/QL.g:1:155: Int
                {
                mInt(); 


                }
                break;

        }

    }


 

}