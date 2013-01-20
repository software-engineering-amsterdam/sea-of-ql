// $ANTLR 3.4 C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-20 16:59:34

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
    public static final int BOOLEAN=4;
    public static final int COMMENT=5;
    public static final int IDENT=6;
    public static final int INT=7;
    public static final int STRING_LITERAL=8;
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
    public String getGrammarFileName() { return "C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:7: ( '!' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:9: '!'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:7: ( '!=' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:9: '!='
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:7: ( '&&' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:9: '&&'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:7: ( '(' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:9: '('
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:7: ( ')' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:9: ')'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '*' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '*'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '+' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '+'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '-' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '-'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '/' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '/'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( ':' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: ':'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '<' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '<'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '<=' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '<='
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( '==' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: '=='
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( '>' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: '>'
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( '>=' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: '>='
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: ( 'boolean' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:9: 'boolean'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:7: ( 'money' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:22:9: 'money'
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:7: ( '||' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:23:9: '||'
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:2: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:112:4: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:2: ( '/*' ( . )* '*/' | '//' ( . )* ( '\\n' | '\\r' ) )
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
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:4: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:9: ( . )*
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
                    	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:116:9: .
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
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:7: '//' ( . )* ( '\\n' | '\\r' )
                    {
                    match("//"); 



                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:12: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\n'||LA2_0=='\r') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:117:12: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    _channel = HIDDEN;

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

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:2: ( ( '0' .. '9' )+ )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:4: ( '0' .. '9' )+
            {
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:121:4: ( '0' .. '9' )+
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
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
    // $ANTLR end "INT"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:2: ( '\"' ( . )* '\"' )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:4: '\"' ( . )* '\"'
            {
            match('\"'); 

            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:8: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\"') ) {
                    alt5=2;
                }
                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:125:8: .
            	    {
            	    matchAny(); 

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
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:2: ( ( 'true' | 'false' ) )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:4: ( 'true' | 'false' )
            {
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:4: ( 'true' | 'false' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='t') ) {
                alt6=1;
            }
            else if ( (LA6_0=='f') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:5: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:129:14: 'false'
                    {
                    match("false"); 



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
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:2: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:4: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:133:23: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')||(LA7_0 >= 'A' && LA7_0 <= 'Z')||LA7_0=='_'||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
    // $ANTLR end "IDENT"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | WS | COMMENT | INT | STRING_LITERAL | BOOLEAN | IDENT )
        int alt8=24;
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
                alt8=20;
            }
            else {
                alt8=9;
            }
            }
            break;
        case ':':
            {
            alt8=10;
            }
            break;
        case '<':
            {
            int LA8_10 = input.LA(2);

            if ( (LA8_10=='=') ) {
                alt8=12;
            }
            else {
                alt8=11;
            }
            }
            break;
        case '=':
            {
            alt8=13;
            }
            break;
        case '>':
            {
            int LA8_12 = input.LA(2);

            if ( (LA8_12=='=') ) {
                alt8=15;
            }
            else {
                alt8=14;
            }
            }
            break;
        case 'b':
            {
            int LA8_13 = input.LA(2);

            if ( (LA8_13=='o') ) {
                int LA8_30 = input.LA(3);

                if ( (LA8_30=='o') ) {
                    int LA8_34 = input.LA(4);

                    if ( (LA8_34=='l') ) {
                        int LA8_38 = input.LA(5);

                        if ( (LA8_38=='e') ) {
                            int LA8_42 = input.LA(6);

                            if ( (LA8_42=='a') ) {
                                int LA8_46 = input.LA(7);

                                if ( (LA8_46=='n') ) {
                                    int LA8_48 = input.LA(8);

                                    if ( ((LA8_48 >= '0' && LA8_48 <= '9')||(LA8_48 >= 'A' && LA8_48 <= 'Z')||LA8_48=='_'||(LA8_48 >= 'a' && LA8_48 <= 'z')) ) {
                                        alt8=24;
                                    }
                                    else {
                                        alt8=16;
                                    }
                                }
                                else {
                                    alt8=24;
                                }
                            }
                            else {
                                alt8=24;
                            }
                        }
                        else {
                            alt8=24;
                        }
                    }
                    else {
                        alt8=24;
                    }
                }
                else {
                    alt8=24;
                }
            }
            else {
                alt8=24;
            }
            }
            break;
        case 'm':
            {
            int LA8_14 = input.LA(2);

            if ( (LA8_14=='o') ) {
                int LA8_31 = input.LA(3);

                if ( (LA8_31=='n') ) {
                    int LA8_35 = input.LA(4);

                    if ( (LA8_35=='e') ) {
                        int LA8_39 = input.LA(5);

                        if ( (LA8_39=='y') ) {
                            int LA8_43 = input.LA(6);

                            if ( ((LA8_43 >= '0' && LA8_43 <= '9')||(LA8_43 >= 'A' && LA8_43 <= 'Z')||LA8_43=='_'||(LA8_43 >= 'a' && LA8_43 <= 'z')) ) {
                                alt8=24;
                            }
                            else {
                                alt8=17;
                            }
                        }
                        else {
                            alt8=24;
                        }
                    }
                    else {
                        alt8=24;
                    }
                }
                else {
                    alt8=24;
                }
            }
            else {
                alt8=24;
            }
            }
            break;
        case '|':
            {
            alt8=18;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt8=19;
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
        case '\"':
            {
            alt8=22;
            }
            break;
        case 't':
            {
            int LA8_19 = input.LA(2);

            if ( (LA8_19=='r') ) {
                int LA8_32 = input.LA(3);

                if ( (LA8_32=='u') ) {
                    int LA8_36 = input.LA(4);

                    if ( (LA8_36=='e') ) {
                        int LA8_40 = input.LA(5);

                        if ( ((LA8_40 >= '0' && LA8_40 <= '9')||(LA8_40 >= 'A' && LA8_40 <= 'Z')||LA8_40=='_'||(LA8_40 >= 'a' && LA8_40 <= 'z')) ) {
                            alt8=24;
                        }
                        else {
                            alt8=23;
                        }
                    }
                    else {
                        alt8=24;
                    }
                }
                else {
                    alt8=24;
                }
            }
            else {
                alt8=24;
            }
            }
            break;
        case 'f':
            {
            int LA8_20 = input.LA(2);

            if ( (LA8_20=='a') ) {
                int LA8_33 = input.LA(3);

                if ( (LA8_33=='l') ) {
                    int LA8_37 = input.LA(4);

                    if ( (LA8_37=='s') ) {
                        int LA8_41 = input.LA(5);

                        if ( (LA8_41=='e') ) {
                            int LA8_45 = input.LA(6);

                            if ( ((LA8_45 >= '0' && LA8_45 <= '9')||(LA8_45 >= 'A' && LA8_45 <= 'Z')||LA8_45=='_'||(LA8_45 >= 'a' && LA8_45 <= 'z')) ) {
                                alt8=24;
                            }
                            else {
                                alt8=23;
                            }
                        }
                        else {
                            alt8=24;
                        }
                    }
                    else {
                        alt8=24;
                    }
                }
                else {
                    alt8=24;
                }
            }
            else {
                alt8=24;
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
        case 'i':
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
            alt8=24;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }

        switch (alt8) {
            case 1 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__10
                {
                mT__10(); 


                }
                break;
            case 2 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__11
                {
                mT__11(); 


                }
                break;
            case 3 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__12
                {
                mT__12(); 


                }
                break;
            case 4 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__13
                {
                mT__13(); 


                }
                break;
            case 5 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__14
                {
                mT__14(); 


                }
                break;
            case 6 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__15
                {
                mT__15(); 


                }
                break;
            case 7 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__16
                {
                mT__16(); 


                }
                break;
            case 8 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__17
                {
                mT__17(); 


                }
                break;
            case 9 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__18
                {
                mT__18(); 


                }
                break;
            case 10 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__19
                {
                mT__19(); 


                }
                break;
            case 11 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__20
                {
                mT__20(); 


                }
                break;
            case 12 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__21
                {
                mT__21(); 


                }
                break;
            case 13 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__22
                {
                mT__22(); 


                }
                break;
            case 14 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__23
                {
                mT__23(); 


                }
                break;
            case 15 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__24
                {
                mT__24(); 


                }
                break;
            case 16 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__25
                {
                mT__25(); 


                }
                break;
            case 17 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: T__26
                {
                mT__26(); 


                }
                break;
            case 18 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:112: T__27
                {
                mT__27(); 


                }
                break;
            case 19 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:118: WS
                {
                mWS(); 


                }
                break;
            case 20 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:121: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 21 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:129: INT
                {
                mINT(); 


                }
                break;
            case 22 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:133: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 23 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:148: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 24 :
                // C:\\Users\\Theodora\\workspace\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:156: IDENT
                {
                mIDENT(); 


                }
                break;

        }

    }


 

}