// $ANTLR 3.4 QL.g 2013-07-12 02:19:19

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
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int Bool=4;
    public static final int COMMENT=5;
    public static final int Ident=6;
    public static final int Int=7;
    public static final int Str=8;
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
    public String getGrammarFileName() { return "QL.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
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
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
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
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
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
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
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
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:21:7: ( 'boolean' )
            // QL.g:21:9: 'boolean'
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
            // QL.g:22:7: ( 'form' )
            // QL.g:22:9: 'form'
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
            // QL.g:23:7: ( 'if' )
            // QL.g:23:9: 'if'
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:24:7: ( 'int' )
            // QL.g:24:9: 'int'
            {
            match("int"); 



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
            // QL.g:25:7: ( 'string' )
            // QL.g:25:9: 'string'
            {
            match("string"); 



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
            // QL.g:26:7: ( '{' )
            // QL.g:26:9: '{'
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:27:7: ( '||' )
            // QL.g:27:9: '||'
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

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:28:7: ( '}' )
            // QL.g:28:9: '}'
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
    // $ANTLR end "T__32"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:127:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // QL.g:127:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // QL.g:131:6: ( '/*' ( . )* '*/' | '//' ( . )* '\\n' )
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
                    // QL.g:131:8: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // QL.g:131:13: ( . )*
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
                    	    // QL.g:131:13: .
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
                    // QL.g:132:8: '//' ( . )* '\\n'
                    {
                    match("//"); 



                    // QL.g:132:13: ( . )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='\n') ) {
                            alt2=2;
                        }
                        else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // QL.g:132:13: .
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:135:5: ( ( 'true' | 'True' | 'TRUE' | 'false' | 'False' | 'FALSE' ) )
            // QL.g:135:7: ( 'true' | 'True' | 'TRUE' | 'false' | 'False' | 'FALSE' )
            {
            // QL.g:135:7: ( 'true' | 'True' | 'TRUE' | 'false' | 'False' | 'FALSE' )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt4=1;
                }
                break;
            case 'T':
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2=='r') ) {
                    alt4=2;
                }
                else if ( (LA4_2=='R') ) {
                    alt4=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'f':
                {
                alt4=4;
                }
                break;
            case 'F':
                {
                int LA4_4 = input.LA(2);

                if ( (LA4_4=='a') ) {
                    alt4=5;
                }
                else if ( (LA4_4=='A') ) {
                    alt4=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // QL.g:135:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // QL.g:135:15: 'True'
                    {
                    match("True"); 



                    }
                    break;
                case 3 :
                    // QL.g:135:22: 'TRUE'
                    {
                    match("TRUE"); 



                    }
                    break;
                case 4 :
                    // QL.g:135:29: 'false'
                    {
                    match("false"); 



                    }
                    break;
                case 5 :
                    // QL.g:135:37: 'False'
                    {
                    match("False"); 



                    }
                    break;
                case 6 :
                    // QL.g:135:45: 'FALSE'
                    {
                    match("FALSE"); 



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
    // $ANTLR end "Bool"

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:137:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // QL.g:137:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // QL.g:137:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
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
            	    break loop5;
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
            // QL.g:139:4: ( ( '0' .. '9' )+ )
            // QL.g:139:6: ( '0' .. '9' )+
            {
            // QL.g:139:6: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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

    // $ANTLR start "Str"
    public final void mStr() throws RecognitionException {
        try {
            int _type = Str;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // QL.g:141:4: ( ( '\"' ( . )* '\"' | '“' ( . )* '”' ) )
            // QL.g:141:8: ( '\"' ( . )* '\"' | '“' ( . )* '”' )
            {
            // QL.g:141:8: ( '\"' ( . )* '\"' | '“' ( . )* '”' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\"') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\u201C') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // QL.g:141:9: '\"' ( . )* '\"'
                    {
                    match('\"'); 

                    // QL.g:141:13: ( . )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\"') ) {
                            alt7=2;
                        }
                        else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // QL.g:141:13: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;
                case 2 :
                    // QL.g:141:22: '“' ( . )* '”'
                    {
                    match('\u201C'); 

                    // QL.g:141:26: ( . )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='\u201D') ) {
                            alt8=2;
                        }
                        else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\u201C')||(LA8_0 >= '\u201E' && LA8_0 <= '\uFFFF')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // QL.g:141:26: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    match('\u201D'); 

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
    // $ANTLR end "Str"

    public void mTokens() throws RecognitionException {
        // QL.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | WS | COMMENT | Bool | Ident | Int | Str )
        int alt10=29;
        alt10 = dfa10.predict(input);
        switch (alt10) {
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
                // QL.g:1:100: T__25
                {
                mT__25(); 


                }
                break;
            case 17 :
                // QL.g:1:106: T__26
                {
                mT__26(); 


                }
                break;
            case 18 :
                // QL.g:1:112: T__27
                {
                mT__27(); 


                }
                break;
            case 19 :
                // QL.g:1:118: T__28
                {
                mT__28(); 


                }
                break;
            case 20 :
                // QL.g:1:124: T__29
                {
                mT__29(); 


                }
                break;
            case 21 :
                // QL.g:1:130: T__30
                {
                mT__30(); 


                }
                break;
            case 22 :
                // QL.g:1:136: T__31
                {
                mT__31(); 


                }
                break;
            case 23 :
                // QL.g:1:142: T__32
                {
                mT__32(); 


                }
                break;
            case 24 :
                // QL.g:1:148: WS
                {
                mWS(); 


                }
                break;
            case 25 :
                // QL.g:1:151: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 26 :
                // QL.g:1:159: Bool
                {
                mBool(); 


                }
                break;
            case 27 :
                // QL.g:1:164: Ident
                {
                mIdent(); 


                }
                break;
            case 28 :
                // QL.g:1:170: Int
                {
                mInt(); 


                }
                break;
            case 29 :
                // QL.g:1:174: Str
                {
                mStr(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\1\34\6\uffff\1\36\1\uffff\1\40\1\uffff\1\42\4\30\4\uffff"+
        "\3\30\13\uffff\3\30\1\61\12\30\1\uffff\1\74\7\30\1\104\1\30\1\uffff"+
        "\1\30\3\107\3\30\1\uffff\1\107\1\30\1\uffff\2\107\1\30\1\115\1\116"+
        "\2\uffff";
    static final String DFA10_eofS =
        "\117\uffff";
    static final String DFA10_minS =
        "\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\157\1\141\1"+
        "\146\1\164\4\uffff\1\162\1\122\1\101\13\uffff\1\157\1\162\1\154"+
        "\1\60\1\164\1\162\2\165\1\125\1\154\1\114\1\154\1\155\1\163\1\uffff"+
        "\1\60\1\151\2\145\1\105\1\163\1\123\1\145\1\60\1\145\1\uffff\1\156"+
        "\3\60\1\145\1\105\1\141\1\uffff\1\60\1\147\1\uffff\2\60\1\156\2"+
        "\60\2\uffff";
    static final String DFA10_maxS =
        "\1\u201c\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\2\157\1\156"+
        "\1\164\4\uffff\2\162\1\141\13\uffff\1\157\1\162\1\154\1\172\1\164"+
        "\1\162\2\165\1\125\1\154\1\114\1\154\1\155\1\163\1\uffff\1\172\1"+
        "\151\2\145\1\105\1\163\1\123\1\145\1\172\1\145\1\uffff\1\156\3\172"+
        "\1\145\1\105\1\141\1\uffff\1\172\1\147\1\uffff\2\172\1\156\2\172"+
        "\2\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\5\uffff"+
        "\1\25\1\26\1\27\1\30\3\uffff\1\33\1\34\1\35\1\2\1\1\1\31\1\11\1"+
        "\14\1\13\1\17\1\16\16\uffff\1\22\12\uffff\1\23\7\uffff\1\21\2\uffff"+
        "\1\32\5\uffff\1\24\1\20";
    static final String DFA10_specialS =
        "\117\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\24\2\uffff\1\24\22\uffff\1\24\1\1\1\32\3\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\31\1\11\1\uffff"+
            "\1\12\1\13\1\14\2\uffff\5\30\1\27\15\30\1\26\6\30\6\uffff\1"+
            "\30\1\15\3\30\1\16\2\30\1\17\11\30\1\20\1\25\6\30\1\21\1\22"+
            "\1\23\u1f9e\uffff\1\32",
            "\1\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\35\4\uffff\1\35",
            "",
            "\1\37",
            "",
            "\1\41",
            "\1\43",
            "\1\45\15\uffff\1\44",
            "\1\46\7\uffff\1\47",
            "\1\50",
            "",
            "",
            "",
            "",
            "\1\51",
            "\1\53\37\uffff\1\52",
            "\1\55\37\uffff\1\54",
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
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\105",
            "",
            "\1\106",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\110",
            "\1\111",
            "\1\112",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\113",
            "",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\1\114",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "\12\30\7\uffff\32\30\4\uffff\1\30\1\uffff\32\30",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | WS | COMMENT | Bool | Ident | Int | Str );";
        }
    }
 

}