// $ANTLR 3.4 C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-01-22 11:06:20

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int BooleanType=4;
    public static final int COMMENT=5;
    public static final int ElseRW=6;
    public static final int FalseRW=7;
    public static final int Ident=8;
    public static final int IfRW=9;
    public static final int Int=10;
    public static final int IntegerType=11;
    public static final int SINGLE_LINE_COMMENT=12;
    public static final int StringLiteral=13;
    public static final int StringType=14;
    public static final int ThenRW=15;
    public static final int TrueRW=16;
    public static final int WS=17;

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
    public String getGrammarFileName() { return "C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( ':' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: ':'
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<'
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<=' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<='
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '==' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '=='
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>'
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>=' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>='
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( 'form' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: 'form'
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( '{' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: '{'
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
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( '||' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:9: '||'
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
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( '}' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:9: '}'
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
    // $ANTLR end "T__36"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:158:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:158:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:6: ( '/*' ( . )* '*/' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:8: '/*' ( . )* '*/'
            {
            match("/*"); 



            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:13: ( . )*
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
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:162:13: .
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
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "SINGLE_LINE_COMMENT"
    public final void mSINGLE_LINE_COMMENT() throws RecognitionException {
        try {
            int _type = SINGLE_LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:166:7: ( '//' ( . )* '\\n' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:166:9: '//' ( . )* '\\n'
            {
            match("//"); 



            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:166:14: ( . )*
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
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:166:14: .
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SINGLE_LINE_COMMENT"

    // $ANTLR start "BooleanType"
    public final void mBooleanType() throws RecognitionException {
        try {
            int _type = BooleanType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:169:14: ( 'bool' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:169:17: 'bool'
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
    // $ANTLR end "BooleanType"

    // $ANTLR start "IntegerType"
    public final void mIntegerType() throws RecognitionException {
        try {
            int _type = IntegerType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:171:14: ( 'int' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:171:17: 'int'
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
    // $ANTLR end "IntegerType"

    // $ANTLR start "StringType"
    public final void mStringType() throws RecognitionException {
        try {
            int _type = StringType;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:173:12: ( 'string' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:173:15: 'string'
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

    // $ANTLR start "TrueRW"
    public final void mTrueRW() throws RecognitionException {
        try {
            int _type = TrueRW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:175:10: ( 'true' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:175:13: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TrueRW"

    // $ANTLR start "FalseRW"
    public final void mFalseRW() throws RecognitionException {
        try {
            int _type = FalseRW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:177:10: ( 'false' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:177:13: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FalseRW"

    // $ANTLR start "IfRW"
    public final void mIfRW() throws RecognitionException {
        try {
            int _type = IfRW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:179:8: ( 'if' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:179:11: 'if'
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
    // $ANTLR end "IfRW"

    // $ANTLR start "ThenRW"
    public final void mThenRW() throws RecognitionException {
        try {
            int _type = ThenRW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:181:10: ( 'then' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:181:13: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ThenRW"

    // $ANTLR start "ElseRW"
    public final void mElseRW() throws RecognitionException {
        try {
            int _type = ElseRW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:183:9: ( 'else' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:183:12: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ElseRW"

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:185:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:185:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:185:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:187:4: ( ( '0' .. '9' )+ )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:187:6: ( '0' .. '9' )+
            {
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:187:6: ( '0' .. '9' )+
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
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

    // $ANTLR start "StringLiteral"
    public final void mStringLiteral() throws RecognitionException {
        try {
            int _type = StringLiteral;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:189:15: ( '\"' ( . )* '\"' )
            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:189:17: '\"' ( . )* '\"'
            {
            match('\"'); 

            // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:189:21: ( . )*
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
            	    // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:189:21: .
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
    // $ANTLR end "StringLiteral"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | WS | COMMENT | SINGLE_LINE_COMMENT | BooleanType | IntegerType | StringType | TrueRW | FalseRW | IfRW | ThenRW | ElseRW | Ident | Int | StringLiteral )
        int alt6=33;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__18
                {
                mT__18(); 


                }
                break;
            case 2 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__19
                {
                mT__19(); 


                }
                break;
            case 3 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__20
                {
                mT__20(); 


                }
                break;
            case 4 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__21
                {
                mT__21(); 


                }
                break;
            case 5 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__22
                {
                mT__22(); 


                }
                break;
            case 6 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__23
                {
                mT__23(); 


                }
                break;
            case 7 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__24
                {
                mT__24(); 


                }
                break;
            case 8 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__25
                {
                mT__25(); 


                }
                break;
            case 9 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__26
                {
                mT__26(); 


                }
                break;
            case 10 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__27
                {
                mT__27(); 


                }
                break;
            case 11 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__28
                {
                mT__28(); 


                }
                break;
            case 12 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__29
                {
                mT__29(); 


                }
                break;
            case 13 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__30
                {
                mT__30(); 


                }
                break;
            case 14 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__31
                {
                mT__31(); 


                }
                break;
            case 15 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__32
                {
                mT__32(); 


                }
                break;
            case 16 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__33
                {
                mT__33(); 


                }
                break;
            case 17 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__34
                {
                mT__34(); 


                }
                break;
            case 18 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__35
                {
                mT__35(); 


                }
                break;
            case 19 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__36
                {
                mT__36(); 


                }
                break;
            case 20 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:124: WS
                {
                mWS(); 


                }
                break;
            case 21 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:127: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 22 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:135: SINGLE_LINE_COMMENT
                {
                mSINGLE_LINE_COMMENT(); 


                }
                break;
            case 23 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:155: BooleanType
                {
                mBooleanType(); 


                }
                break;
            case 24 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:167: IntegerType
                {
                mIntegerType(); 


                }
                break;
            case 25 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:179: StringType
                {
                mStringType(); 


                }
                break;
            case 26 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:190: TrueRW
                {
                mTrueRW(); 


                }
                break;
            case 27 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:197: FalseRW
                {
                mFalseRW(); 


                }
                break;
            case 28 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:205: IfRW
                {
                mIfRW(); 


                }
                break;
            case 29 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:210: ThenRW
                {
                mThenRW(); 


                }
                break;
            case 30 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:217: ElseRW
                {
                mElseRW(); 


                }
                break;
            case 31 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:224: Ident
                {
                mIdent(); 


                }
                break;
            case 32 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:230: Int
                {
                mInt(); 


                }
                break;
            case 33 :
                // C:\\Users\\caytekin\\Documents\\GitHub\\sea-of-ql\\caytekin\\QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:234: StringLiteral
                {
                mStringLiteral(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\1\33\6\uffff\1\36\1\uffff\1\40\1\uffff\1\42\1\27\4\uffff"+
        "\5\27\14\uffff\4\27\1\60\7\27\1\70\1\uffff\4\27\1\75\1\27\1\77\1"+
        "\uffff\1\27\1\101\1\102\1\103\1\uffff\1\104\1\uffff\1\27\4\uffff"+
        "\1\106\1\uffff";
    static final String DFA6_eofS =
        "\107\uffff";
    static final String DFA6_minS =
        "\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\141\4\uffff"+
        "\1\157\1\146\1\164\1\150\1\154\14\uffff\1\162\1\154\1\157\1\164"+
        "\1\60\1\162\1\165\1\145\1\163\1\155\1\163\1\154\1\60\1\uffff\1\151"+
        "\1\145\1\156\1\145\1\60\1\145\1\60\1\uffff\1\156\3\60\1\uffff\1"+
        "\60\1\uffff\1\147\4\uffff\1\60\1\uffff";
    static final String DFA6_maxS =
        "\1\175\1\75\6\uffff\1\57\1\uffff\1\75\1\uffff\1\75\1\157\4\uffff"+
        "\1\157\1\156\1\164\1\162\1\154\14\uffff\1\162\1\154\1\157\1\164"+
        "\1\172\1\162\1\165\1\145\1\163\1\155\1\163\1\154\1\172\1\uffff\1"+
        "\151\1\145\1\156\1\145\1\172\1\145\1\172\1\uffff\1\156\3\172\1\uffff"+
        "\1\172\1\uffff\1\147\4\uffff\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\2\uffff"+
        "\1\21\1\22\1\23\1\24\5\uffff\1\37\1\40\1\41\1\2\1\1\1\25\1\26\1"+
        "\11\1\14\1\13\1\17\1\16\15\uffff\1\34\7\uffff\1\30\4\uffff\1\20"+
        "\1\uffff\1\27\1\uffff\1\32\1\35\1\36\1\33\1\uffff\1\31";
    static final String DFA6_specialS =
        "\107\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\21\2\uffff\1\21\22\uffff\1\21\1\1\1\31\3\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\30\1\11\1\uffff"+
            "\1\12\1\13\1\14\2\uffff\32\27\6\uffff\1\27\1\22\2\27\1\26\1"+
            "\15\2\27\1\23\11\27\1\24\1\25\6\27\1\16\1\17\1\20",
            "\1\32",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\34\4\uffff\1\35",
            "",
            "\1\37",
            "",
            "\1\41",
            "\1\44\15\uffff\1\43",
            "",
            "",
            "",
            "",
            "\1\45",
            "\1\47\7\uffff\1\46",
            "\1\50",
            "\1\52\11\uffff\1\51",
            "\1\53",
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
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\1\76",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\100",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            "",
            "\1\105",
            "",
            "",
            "",
            "",
            "\12\27\7\uffff\32\27\4\uffff\1\27\1\uffff\32\27",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | WS | COMMENT | SINGLE_LINE_COMMENT | BooleanType | IntegerType | StringType | TrueRW | FalseRW | IfRW | ThenRW | ElseRW | Ident | Int | StringLiteral );";
        }
    }
 

}