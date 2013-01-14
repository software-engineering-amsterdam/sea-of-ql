// $ANTLR 3.4 C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g 2013-01-14 14:31:53

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int Bool=4;
    public static final int BoolType=5;
    public static final int COMMENT=6;
    public static final int Form=7;
    public static final int Ident=8;
    public static final int Int=9;
    public static final int IntType=10;
    public static final int NEWLINE=11;
    public static final int String=12;
    public static final int StringType=13;
    public static final int WS=14;

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
    public String getGrammarFileName() { return "C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:7: ( '!' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:6:9: '!'
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:7: ( '!=' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:7:9: '!='
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:7: ( '&&' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:8:9: '&&'
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:7: ( '(' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:9:9: '('
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:7: ( ')' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:10:9: ')'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:7: ( '*' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:11:9: '*'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:7: ( '+' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:12:9: '+'
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:7: ( '-' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:13:9: '-'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:7: ( '/' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:14:9: '/'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:7: ( ':' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:15:9: ':'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:7: ( '<' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:16:9: '<'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:7: ( '<=' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:17:9: '<='
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:7: ( '==' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:18:9: '=='
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:7: ( '>' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:19:9: '>'
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:7: ( '>=' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:20:9: '>='
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:7: ( '||' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:21:9: '||'
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
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:5: ( ( ' ' | '\\t' | NEWLINE ) )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:91:7: ( ' ' | '\\t' | NEWLINE )
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
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:6: ( ( '/*' ( . )* '*/' | '//' (~ ( NEWLINE ) )* ) )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:8: ( '/*' ( . )* '*/' | '//' (~ ( NEWLINE ) )* )
            {
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:8: ( '/*' ( . )* '*/' | '//' (~ ( NEWLINE ) )* )
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
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:9: '/*' ( . )* '*/'
                    {
                    match("/*"); 



                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:14: ( . )*
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
                    	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:14: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    match("*/"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:24: '//' (~ ( NEWLINE ) )*
                    {
                    match("//"); 



                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:95:29: (~ ( NEWLINE ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:98:2: ( ( '\\n' | '\\r' ) )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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

    // $ANTLR start "Form"
    public final void mForm() throws RecognitionException {
        try {
            int _type = Form;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:7: ( 'form' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:100:9: 'form'
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
    // $ANTLR end "Form"

    // $ANTLR start "BoolType"
    public final void mBoolType() throws RecognitionException {
        try {
            int _type = BoolType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:9: ( 'bool' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:102:11: 'bool'
            {
            match("bool"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BoolType"

    // $ANTLR start "IntType"
    public final void mIntType() throws RecognitionException {
        try {
            int _type = IntType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:9: ( 'int' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:104:11: 'int'
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
    // $ANTLR end "IntType"

    // $ANTLR start "StringType"
    public final void mStringType() throws RecognitionException {
        try {
            int _type = StringType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:2: ( 'string' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:107:4: 'string'
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
    // $ANTLR end "StringType"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:9: ( ( '\"' ( . )* '\"' ) )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:11: ( '\"' ( . )* '\"' )
            {
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:11: ( '\"' ( . )* '\"' )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:12: '\"' ( . )* '\"'
            {
            match('\"'); 

            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:16: ( . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\"') ) {
                    alt4=2;
                }
                else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '!')||(LA4_0 >= '#' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:109:16: .
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:7: ( ( 'true' | 'false' ) )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:9: ( 'true' | 'false' )
            {
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:9: ( 'true' | 'false' )
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
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:10: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:111:19: 'false'
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
    // $ANTLR end "Bool"

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:113:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:4: ( ( '0' .. '9' )+ )
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:6: ( '0' .. '9' )+
            {
            // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:115:6: ( '0' .. '9' )+
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
            	    // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:
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
        // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | WS | COMMENT | Form | BoolType | IntType | StringType | String | Bool | Ident | Int )
        int alt8=26;
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
                alt8=18;
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
        case '|':
            {
            alt8=16;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt8=17;
            }
            break;
        case 'f':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA8_31 = input.LA(3);

                if ( (LA8_31=='r') ) {
                    int LA8_37 = input.LA(4);

                    if ( (LA8_37=='m') ) {
                        int LA8_43 = input.LA(5);

                        if ( ((LA8_43 >= '0' && LA8_43 <= '9')||(LA8_43 >= 'A' && LA8_43 <= 'Z')||LA8_43=='_'||(LA8_43 >= 'a' && LA8_43 <= 'z')) ) {
                            alt8=25;
                        }
                        else {
                            alt8=19;
                        }
                    }
                    else {
                        alt8=25;
                    }
                }
                else {
                    alt8=25;
                }
                }
                break;
            case 'a':
                {
                int LA8_32 = input.LA(3);

                if ( (LA8_32=='l') ) {
                    int LA8_38 = input.LA(4);

                    if ( (LA8_38=='s') ) {
                        int LA8_44 = input.LA(5);

                        if ( (LA8_44=='e') ) {
                            int LA8_50 = input.LA(6);

                            if ( ((LA8_50 >= '0' && LA8_50 <= '9')||(LA8_50 >= 'A' && LA8_50 <= 'Z')||LA8_50=='_'||(LA8_50 >= 'a' && LA8_50 <= 'z')) ) {
                                alt8=25;
                            }
                            else {
                                alt8=24;
                            }
                        }
                        else {
                            alt8=25;
                        }
                    }
                    else {
                        alt8=25;
                    }
                }
                else {
                    alt8=25;
                }
                }
                break;
            default:
                alt8=25;
            }

            }
            break;
        case 'b':
            {
            int LA8_16 = input.LA(2);

            if ( (LA8_16=='o') ) {
                int LA8_33 = input.LA(3);

                if ( (LA8_33=='o') ) {
                    int LA8_39 = input.LA(4);

                    if ( (LA8_39=='l') ) {
                        int LA8_45 = input.LA(5);

                        if ( ((LA8_45 >= '0' && LA8_45 <= '9')||(LA8_45 >= 'A' && LA8_45 <= 'Z')||LA8_45=='_'||(LA8_45 >= 'a' && LA8_45 <= 'z')) ) {
                            alt8=25;
                        }
                        else {
                            alt8=20;
                        }
                    }
                    else {
                        alt8=25;
                    }
                }
                else {
                    alt8=25;
                }
            }
            else {
                alt8=25;
            }
            }
            break;
        case 'i':
            {
            int LA8_17 = input.LA(2);

            if ( (LA8_17=='n') ) {
                int LA8_34 = input.LA(3);

                if ( (LA8_34=='t') ) {
                    int LA8_40 = input.LA(4);

                    if ( ((LA8_40 >= '0' && LA8_40 <= '9')||(LA8_40 >= 'A' && LA8_40 <= 'Z')||LA8_40=='_'||(LA8_40 >= 'a' && LA8_40 <= 'z')) ) {
                        alt8=25;
                    }
                    else {
                        alt8=21;
                    }
                }
                else {
                    alt8=25;
                }
            }
            else {
                alt8=25;
            }
            }
            break;
        case 's':
            {
            int LA8_18 = input.LA(2);

            if ( (LA8_18=='t') ) {
                int LA8_35 = input.LA(3);

                if ( (LA8_35=='r') ) {
                    int LA8_41 = input.LA(4);

                    if ( (LA8_41=='i') ) {
                        int LA8_47 = input.LA(5);

                        if ( (LA8_47=='n') ) {
                            int LA8_52 = input.LA(6);

                            if ( (LA8_52=='g') ) {
                                int LA8_54 = input.LA(7);

                                if ( ((LA8_54 >= '0' && LA8_54 <= '9')||(LA8_54 >= 'A' && LA8_54 <= 'Z')||LA8_54=='_'||(LA8_54 >= 'a' && LA8_54 <= 'z')) ) {
                                    alt8=25;
                                }
                                else {
                                    alt8=22;
                                }
                            }
                            else {
                                alt8=25;
                            }
                        }
                        else {
                            alt8=25;
                        }
                    }
                    else {
                        alt8=25;
                    }
                }
                else {
                    alt8=25;
                }
            }
            else {
                alt8=25;
            }
            }
            break;
        case '\"':
            {
            alt8=23;
            }
            break;
        case 't':
            {
            int LA8_20 = input.LA(2);

            if ( (LA8_20=='r') ) {
                int LA8_36 = input.LA(3);

                if ( (LA8_36=='u') ) {
                    int LA8_42 = input.LA(4);

                    if ( (LA8_42=='e') ) {
                        int LA8_48 = input.LA(5);

                        if ( ((LA8_48 >= '0' && LA8_48 <= '9')||(LA8_48 >= 'A' && LA8_48 <= 'Z')||LA8_48=='_'||(LA8_48 >= 'a' && LA8_48 <= 'z')) ) {
                            alt8=25;
                        }
                        else {
                            alt8=24;
                        }
                    }
                    else {
                        alt8=25;
                    }
                }
                else {
                    alt8=25;
                }
            }
            else {
                alt8=25;
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
            alt8=25;
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
            alt8=26;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 8, 0, input);

            throw nvae;

        }

        switch (alt8) {
            case 1 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:10: T__15
                {
                mT__15(); 


                }
                break;
            case 2 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:16: T__16
                {
                mT__16(); 


                }
                break;
            case 3 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:22: T__17
                {
                mT__17(); 


                }
                break;
            case 4 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:28: T__18
                {
                mT__18(); 


                }
                break;
            case 5 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:34: T__19
                {
                mT__19(); 


                }
                break;
            case 6 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:40: T__20
                {
                mT__20(); 


                }
                break;
            case 7 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:46: T__21
                {
                mT__21(); 


                }
                break;
            case 8 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:52: T__22
                {
                mT__22(); 


                }
                break;
            case 9 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:58: T__23
                {
                mT__23(); 


                }
                break;
            case 10 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:64: T__24
                {
                mT__24(); 


                }
                break;
            case 11 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:70: T__25
                {
                mT__25(); 


                }
                break;
            case 12 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:76: T__26
                {
                mT__26(); 


                }
                break;
            case 13 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:82: T__27
                {
                mT__27(); 


                }
                break;
            case 14 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:88: T__28
                {
                mT__28(); 


                }
                break;
            case 15 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:94: T__29
                {
                mT__29(); 


                }
                break;
            case 16 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:100: T__30
                {
                mT__30(); 


                }
                break;
            case 17 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:106: WS
                {
                mWS(); 


                }
                break;
            case 18 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:109: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 19 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:117: Form
                {
                mForm(); 


                }
                break;
            case 20 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:122: BoolType
                {
                mBoolType(); 


                }
                break;
            case 21 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:131: IntType
                {
                mIntType(); 


                }
                break;
            case 22 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:139: StringType
                {
                mStringType(); 


                }
                break;
            case 23 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:150: String
                {
                mString(); 


                }
                break;
            case 24 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:157: Bool
                {
                mBool(); 


                }
                break;
            case 25 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:162: Ident
                {
                mIdent(); 


                }
                break;
            case 26 :
                // C:\\Users\\Wouter Kwakernaak\\sea-of-ql\\Waldo9\\QLJava\\src\\org\\uva\\sea\\ql\\parser\\antlr\\QL.g:1:168: Int
                {
                mInt(); 


                }
                break;

        }

    }


 

}