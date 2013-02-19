// $ANTLR 3.4 /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g 2013-02-18 15:27:13

package org.uva.sea.ql.parser.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class QLLexer extends Lexer {
    public static final int EOF=-1;
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
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int BOOLEAN=4;
    public static final int Bool=5;
    public static final int COMMENT=6;
    public static final int Decimal=7;
    public static final int INTEGER=8;
    public static final int Ident=9;
    public static final int Int=10;
    public static final int STRING=11;
    public static final int StringLit=12;
    public static final int WS=13;

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
    public String getGrammarFileName() { return "/home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:7: ( '!' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:6:9: '!'
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
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:7: ( '!=' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:7:9: '!='
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
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:7: ( '&&' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:8:9: '&&'
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
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:7: ( '(' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:9:9: '('
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
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:7: ( ')' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:10:9: ')'
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
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:7: ( '*' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:11:9: '*'
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
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:7: ( '+' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:12:9: '+'
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
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:7: ( '-' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:13:9: '-'
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
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:7: ( '/' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:14:9: '/'
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
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:7: ( ':' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:15:9: ':'
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
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:7: ( '<' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:16:9: '<'
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
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:7: ( '<=' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:17:9: '<='
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
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:7: ( '==' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:18:9: '=='
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
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:7: ( '>' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:19:9: '>'
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
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:7: ( '>=' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:20:9: '>='
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
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:7: ( 'else' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:21:9: 'else'
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:7: ( 'form' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:22:9: 'form'
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:7: ( 'if' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:23:9: 'if'
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:7: ( '{' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:24:9: '{'
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:7: ( '||' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:25:9: '||'
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
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:7: ( '}' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:26:9: '}'
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
    // $ANTLR end "T__34"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:130:8: ( 'boolean' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:130:10: 'boolean'
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
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:8: ( 'int' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:131:10: 'int'
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
    // $ANTLR end "INTEGER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:7: ( 'text' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:134:9: 'text'
            {
            match("text"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:136:5: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:136:7: ( ' ' | '\\t' | '\\n' | '\\r' )
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
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:6: ( '/*' ( . )* '*/' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:8: '/*' ( . )* '*/'
            {
            match("/*"); 



            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:13: ( . )*
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
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:140:13: .
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

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:143:5: ( 'true' | 'false' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                alt2=1;
            }
            else if ( (LA2_0=='f') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:143:7: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:143:16: 'false'
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

    // $ANTLR start "Ident"
    public final void mIdent() throws RecognitionException {
        try {
            int _type = Ident;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:6: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:145:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:4: ( ( '0' .. '9' )+ )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:6: ( '0' .. '9' )+
            {
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:147:6: ( '0' .. '9' )+
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
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:
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

    // $ANTLR start "Decimal"
    public final void mDecimal() throws RecognitionException {
        try {
            int _type = Decimal;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:9: ( Int '.' Int )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:149:11: Int '.' Int
            {
            mInt(); 


            match('.'); 

            mInt(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Decimal"

    // $ANTLR start "StringLit"
    public final void mStringLit() throws RecognitionException {
        try {
            int _type = StringLit;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:10: ( '\"' ( . )* '\"' )
            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:12: '\"' ( . )* '\"'
            {
            match('\"'); 

            // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:16: ( . )*
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
            	    // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:151:16: .
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
    // $ANTLR end "StringLit"

    public void mTokens() throws RecognitionException {
        // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | BOOLEAN | INTEGER | STRING | WS | COMMENT | Bool | Ident | Int | Decimal | StringLit )
        int alt6=31;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:10: T__14
                {
                mT__14(); 


                }
                break;
            case 2 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:16: T__15
                {
                mT__15(); 


                }
                break;
            case 3 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:22: T__16
                {
                mT__16(); 


                }
                break;
            case 4 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:28: T__17
                {
                mT__17(); 


                }
                break;
            case 5 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:34: T__18
                {
                mT__18(); 


                }
                break;
            case 6 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:40: T__19
                {
                mT__19(); 


                }
                break;
            case 7 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:46: T__20
                {
                mT__20(); 


                }
                break;
            case 8 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:52: T__21
                {
                mT__21(); 


                }
                break;
            case 9 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:58: T__22
                {
                mT__22(); 


                }
                break;
            case 10 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:64: T__23
                {
                mT__23(); 


                }
                break;
            case 11 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:70: T__24
                {
                mT__24(); 


                }
                break;
            case 12 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:76: T__25
                {
                mT__25(); 


                }
                break;
            case 13 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:82: T__26
                {
                mT__26(); 


                }
                break;
            case 14 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:88: T__27
                {
                mT__27(); 


                }
                break;
            case 15 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:94: T__28
                {
                mT__28(); 


                }
                break;
            case 16 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:100: T__29
                {
                mT__29(); 


                }
                break;
            case 17 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:106: T__30
                {
                mT__30(); 


                }
                break;
            case 18 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:112: T__31
                {
                mT__31(); 


                }
                break;
            case 19 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:118: T__32
                {
                mT__32(); 


                }
                break;
            case 20 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:124: T__33
                {
                mT__33(); 


                }
                break;
            case 21 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:130: T__34
                {
                mT__34(); 


                }
                break;
            case 22 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:136: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 23 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:144: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 24 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:152: STRING
                {
                mSTRING(); 


                }
                break;
            case 25 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:159: WS
                {
                mWS(); 


                }
                break;
            case 26 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:162: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 27 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:170: Bool
                {
                mBool(); 


                }
                break;
            case 28 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:175: Ident
                {
                mIdent(); 


                }
                break;
            case 29 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:181: Int
                {
                mInt(); 


                }
                break;
            case 30 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:185: Decimal
                {
                mDecimal(); 


                }
                break;
            case 31 :
                // /home/ioana/workspace/Construction/sea-of-ql/ioanarucareanu/QLJava/src/org/uva/sea/ql/parser/antlr/QL.g:1:193: StringLit
                {
                mStringLit(); 


                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\uffff\1\32\6\uffff\1\34\1\uffff\1\36\1\uffff\1\40\3\26\3\uffff"+
        "\2\26\2\uffff\1\51\11\uffff\3\26\1\56\4\26\2\uffff\3\26\1\uffff"+
        "\1\66\3\26\1\72\1\73\1\26\1\uffff\1\26\1\76\1\77\2\uffff\1\77\1"+
        "\26\2\uffff\1\26\1\102\1\uffff";
    static final String DFA6_eofS =
        "\103\uffff";
    static final String DFA6_minS =
        "\1\11\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\154\1\141\1"+
        "\146\3\uffff\1\157\1\145\2\uffff\1\56\11\uffff\1\163\1\162\1\154"+
        "\1\60\1\164\1\157\1\170\1\165\2\uffff\1\145\1\155\1\163\1\uffff"+
        "\1\60\1\154\1\164\1\145\2\60\1\145\1\uffff\1\145\2\60\2\uffff\1"+
        "\60\1\141\2\uffff\1\156\1\60\1\uffff";
    static final String DFA6_maxS =
        "\1\175\1\75\6\uffff\1\52\1\uffff\1\75\1\uffff\1\75\1\154\1\157\1"+
        "\156\3\uffff\1\157\1\162\2\uffff\1\71\11\uffff\1\163\1\162\1\154"+
        "\1\172\1\164\1\157\1\170\1\165\2\uffff\1\145\1\155\1\163\1\uffff"+
        "\1\172\1\154\1\164\1\145\2\172\1\145\1\uffff\1\145\2\172\2\uffff"+
        "\1\172\1\141\2\uffff\1\156\1\172\1\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\12\1\uffff\1\15\4\uffff"+
        "\1\23\1\24\1\25\2\uffff\1\31\1\34\1\uffff\1\37\1\2\1\1\1\32\1\11"+
        "\1\14\1\13\1\17\1\16\10\uffff\1\35\1\36\3\uffff\1\22\7\uffff\1\27"+
        "\3\uffff\1\20\1\21\2\uffff\1\30\1\33\2\uffff\1\26";
    static final String DFA6_specialS =
        "\103\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\25\2\uffff\1\25\22\uffff\1\25\1\1\1\30\3\uffff\1\2\1\uffff"+
            "\1\3\1\4\1\5\1\6\1\uffff\1\7\1\uffff\1\10\12\27\1\11\1\uffff"+
            "\1\12\1\13\1\14\2\uffff\32\26\6\uffff\1\26\1\23\2\26\1\15\1"+
            "\16\2\26\1\17\12\26\1\24\6\26\1\20\1\21\1\22",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\33",
            "",
            "\1\35",
            "",
            "\1\37",
            "\1\41",
            "\1\43\15\uffff\1\42",
            "\1\44\7\uffff\1\45",
            "",
            "",
            "",
            "\1\46",
            "\1\47\14\uffff\1\50",
            "",
            "",
            "\1\52\1\uffff\12\27",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\53",
            "\1\54",
            "\1\55",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\67",
            "\1\70",
            "\1\71",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\74",
            "",
            "\1\75",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "",
            "",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
            "\1\100",
            "",
            "",
            "\1\101",
            "\12\26\7\uffff\32\26\4\uffff\1\26\1\uffff\32\26",
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
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | BOOLEAN | INTEGER | STRING | WS | COMMENT | Bool | Ident | Int | Decimal | StringLit );";
        }
    }
 

}